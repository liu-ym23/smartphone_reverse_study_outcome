package com.ss.bduploader;

import android.util.Log;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes6.dex */
public class AWSV4Auth {
    private static String MAC_ALGORITHM = "HmacSHA256";
    protected static final char[] hexArray = null;
    private static Mac mMacInstance;
    private static MessageDigest mMessageDigest;
    private String accessKeyID;
    private TreeMap<String, String> awsHeaders;
    private boolean awsHeadersHasTimestamp;
    private String canonicalURI;
    private String currentDate;
    private boolean debug;
    private String httpMethodName;
    private String payload;
    private TreeMap<String, ArrayList<String>> queryParameters;
    private String regionName;
    private String secretAccessKey;
    private String serviceName;
    private String strSignedHeader;
    private String xAmzDate;

    /* JADX INFO: renamed from: com.ss.bduploader.AWSV4Auth$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String accessKeyID;
        private TreeMap<String, String> awsHeaders;
        private String canonicalURI;
        private boolean debug;
        private String httpMethodName;
        private String payload;
        private TreeMap<String, ArrayList<String>> queryParameters;
        private String regionName;
        private String secretAccessKey;
        private String serviceName;

        public Builder(String r2, String r3) {
            this.debug = false;
            this.accessKeyID = r2;
            this.secretAccessKey = r3;
        }

        static /* synthetic */ String access$100(Builder r0) {
            return r0.accessKeyID;
        }

        static /* synthetic */ boolean access$1000(Builder r0) {
            return r0.debug;
        }

        static /* synthetic */ String access$200(Builder r0) {
            return r0.secretAccessKey;
        }

        static /* synthetic */ String access$300(Builder r0) {
            return r0.regionName;
        }

        static /* synthetic */ String access$400(Builder r0) {
            return r0.serviceName;
        }

        static /* synthetic */ String access$500(Builder r0) {
            return r0.httpMethodName;
        }

        static /* synthetic */ String access$600(Builder r0) {
            return r0.canonicalURI;
        }

        static /* synthetic */ TreeMap access$700(Builder r0) {
            return r0.queryParameters;
        }

        static /* synthetic */ TreeMap access$800(Builder r0) {
            return r0.awsHeaders;
        }

        static /* synthetic */ String access$900(Builder r0) {
            return r0.payload;
        }

        public Builder awsHeaders(TreeMap<String, String> r1) {
            this.awsHeaders = r1;
            return this;
        }

        public AWSV4Auth build() {
            return new AWSV4Auth(this, null);
        }

        public Builder canonicalURI(String r1) {
            this.canonicalURI = r1;
            return this;
        }

        public Builder debug() {
            this.debug = true;
            return this;
        }

        public Builder httpMethodName(String r1) {
            this.httpMethodName = r1;
            return this;
        }

        public Builder payload(String r1) {
            this.payload = r1;
            return this;
        }

        public Builder queryParameters(TreeMap<String, ArrayList<String>> r1) {
            this.queryParameters = r1;
            return this;
        }

        public Builder regionName(String r1) {
            this.regionName = r1;
            return this;
        }

        public Builder serviceName(String r1) {
            this.serviceName = r1;
            return this;
        }
    }

    static {
        mMacInstance = Mac.getInstance("HmacSHA256");     // Catch: NoSuchAlgorithmException -> L6
        mMessageDigest = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);     // Catch: NoSuchAlgorithmException -> L6
    L4:
        hexArray = "0123456789ABCDEF".toCharArray();
    }

    private AWSV4Auth() {
        this.awsHeadersHasTimestamp = false;
        this.debug = false;
    }

    private AWSV4Auth(Builder r3) {
        this.awsHeadersHasTimestamp = false;
        this.debug = false;
        this.accessKeyID = Builder.access$100(r3);
        this.secretAccessKey = Builder.access$200(r3);
        this.regionName = Builder.access$300(r3);
        this.serviceName = Builder.access$400(r3);
        this.httpMethodName = Builder.access$500(r3);
        this.canonicalURI = Builder.access$600(r3);
        this.queryParameters = Builder.access$700(r3);
        this.awsHeaders = Builder.access$800(r3);
        this.payload = Builder.access$900(r3);
        this.debug = Builder.access$1000(r3);
        if (this.awsHeaders != null) goto L5;
        this.awsHeaders = new TreeMap();
    L5:
        String r4 = findTimestampFromHeaderCaseInsensitive();
        this.xAmzDate = r4;
        if (r4 != null) goto L8;
        String r5 = getTimeStamp();
        this.xAmzDate = r5;
        this.awsHeaders.put(AWSV4AuthParams.AWSAmzDateKey, r5);
    L9:
        this.currentDate = getDateFromTimeStamp(this.xAmzDate);
        return;
    L8:
        this.awsHeadersHasTimestamp = true;
        goto L9
    }

    /* synthetic */ AWSV4Auth(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    private static synchronized byte[] SHA256UseMac(byte[] r3, String r4) {
        monitor-enter(AWSV4Auth.class);
        SecretKeySpec r1 = new SecretKeySpec(r3, MAC_ALGORITHM);     // Catch: Throwable -> L7
        mMacInstance.init(r1);     // Catch: Throwable -> L7
        byte[] r5 = r4.getBytes("UTF8");     // Catch: Throwable -> L7
        byte[] r6 = mMacInstance.doFinal(r5);     // Catch: Throwable -> L7
        monitor-exit(AWSV4Auth.class);
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    private String buildAuthorizationString(String r4) {
        return "AWS4-HMAC-SHA256 Credential=" + this.accessKeyID + "/" + this.currentDate + "/" + this.regionName + "/" + this.serviceName + "/" + AWSV4AuthParams.aws4Request + ",SignedHeaders=" + this.strSignedHeader + ",Signature=" + r4;
    }

    private String bytesToHex(byte[] r6) {
        char[] r5 = new char[r6.length * 2];
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L7;
        int r1 = r6[r0] & 255;
        int r2 = r0 * 2;
        char[] r3 = hexArray;
        r5[r2] = r3[r1 >>> 4];
        r5[r2 + 1] = r3[r1 & 15];
        r0 = r0 + 1;
        goto L4
    L7:
        return new String(r5).toLowerCase();
    }

    private String calculateSignature(String r5) {
        return bytesToHex(SHA256UseMac(getSignatureKey(this.secretAccessKey, this.currentDate, this.regionName, this.serviceName), r5));
    L4:
        return null;
    }

    private String encodeParameter(String r3) {
        return URLEncoder.encode(r3, RpcUtils.CHARSET_UTF8).replace(Marker.ANY_NON_NULL_MARKER, "%20").replace("*", "%2A").replace("%7E", "~");
    L7:
        return r3;
    }

    private String findTimestampFromHeaderCaseInsensitive() {
        TreeMap<String, String> r0 = this.awsHeaders;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r4 = this.awsHeaders.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L19;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin")).toLowerCase().equals(AWSV4AuthParams.AWSAmzDateKey) == false) goto L8;
        return (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin");
    L19:
        return null;
    L18:
        return null;
    }

    private static synchronized String generateHex(String r6) {
        monitor-enter(AWSV4Auth.class);
        mMessageDigest.update(r6.getBytes(RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L7 UnsupportedEncodingException -> L10
        String r7 = String.format("%064x", new Object[]{new BigInteger(1, mMessageDigest.digest())});     // Catch: Throwable -> L7 UnsupportedEncodingException -> L10
        monitor-exit(AWSV4Auth.class);
        return r7;
    L10:
        return null;
    L7:
        th = move-exception;
        throw th;
    }

    private String getDateFromTimeStamp(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.length() >= 8) goto L7;
        return null;
    L7:
        return r2.substring(0, 8);
    }

    private static synchronized byte[] getSignatureKey(String r3, String r4, String r5, String r6) {
        monitor-enter(AWSV4Auth.class);
        byte[] r7 = SHA256UseMac(SHA256UseMac(SHA256UseMac(SHA256UseMac(("AWS4" + r3).getBytes("UTF8"), r4), r5), r6), AWSV4AuthParams.aws4Request);     // Catch: Throwable -> L7
        monitor-exit(AWSV4Auth.class);
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    private String getTimeStamp() {
        SimpleDateFormat r1 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        r1.setTimeZone(TimeZone.getTimeZone("UTC"));
        return r1.format(new Date());
    }

    private String prepareCanonicalRequest() {
        String r1 = "";
        StringBuilder r0 = new StringBuilder("");
        r0.append(this.httpMethodName).append("\n");
        String r2 = this.canonicalURI;
        if (r2 != null) goto L5;
    L8:
        String r3 = "/";
    L9:
        this.canonicalURI = r3;
        r0.append(r3).append("\n");
        StringBuilder r4 = new StringBuilder("");
        TreeMap<String, ArrayList<String>> r5 = this.queryParameters;
        if (r5 != null) goto L12;
    L21:
        r4.append("\n");
        r0.append(r4);
        StringBuilder r6 = new StringBuilder("");
        TreeMap<String, String> r7 = this.awsHeaders;
        if (r7 != null) goto L24;
    L33:
        r0.append("\n");
        String r8 = r6.substring(0, r6.length() - 1);
        this.strSignedHeader = r8;
        r0.append(r8).append("\n");
        String r9 = this.payload;
        if (r9 == null) goto L37;
        r1 = r9;
    L37:
        this.payload = r1;
        r0.append(generateHex(r1));
        if (this.debug == false) goto L41;
        System.out.println("##Canonical Request:\n" + r0.toString());
    L41:
        return r0.toString();
    L24:
        if (r7.isEmpty() == true) goto L33;
        TreeMap r10 = new TreeMap();
        Iterator<Map.Entry<String, String>> r11 = this.awsHeaders.entrySet().iterator();
    L27:
        if (r11.hasNext() == false) goto L29;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r10.put(((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin")).toLowerCase(), ((String) ZeusTransformUtils.preCheckCast(r12.getValue(), String.class, "com.obric.memorydata.plugin")).trim());
        goto L27
    L29:
        Iterator r13 = r10.entrySet().iterator();
    L31:
        if (r13.hasNext() == false) goto L33;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r15 = ((String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.memorydata.plugin")).toLowerCase();
        String r16 = ((String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.memorydata.plugin")).trim();
        r6.append(r15).append(";");
        r0.append(r15).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(r16).append("\n");
        goto L31
    L12:
        if (r5.isEmpty() == true) goto L21;
        Iterator<Map.Entry<String, ArrayList<String>>> r17 = this.queryParameters.entrySet().iterator();
    L15:
        if (r17.hasNext() == false) goto L20;
        Map.Entry r18 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r19 = (String) ZeusTransformUtils.preCheckCast(r18.getKey(), String.class, "com.obric.memorydata.plugin");
        ArrayList r20 = (ArrayList) ZeusTransformUtils.preCheckCast(r18.getValue(), ArrayList.class, "com.obric.memorydata.plugin");
        int r110 = 0;
    L18:
        if (r110 >= r20.size()) goto L15;
        r4.append(r19).append("=").append(encodeParameter((String) ZeusTransformUtils.preCheckCast(r20.get(r110), String.class, "com.obric.memorydata.plugin"))).append("&");
        Log.i("AWSV4 queryParameters", r19 + "++++" + ((String) ZeusTransformUtils.preCheckCast(r20.get(r110), String.class, "com.obric.memorydata.plugin")));
        r110 = r110 + 1;
        goto L18
    L20:
        r4.deleteCharAt(r4.lastIndexOf("&"));
        goto L21
    L5:
        if (r2.trim().isEmpty() == true) goto L8;
        r3 = this.canonicalURI;
        goto L9
    }

    private String prepareStringToSign(String r5) {
        String r6 = (("AWS4-HMAC-SHA256\n" + this.xAmzDate + "\n") + this.currentDate + "/" + this.regionName + "/" + this.serviceName + "/" + AWSV4AuthParams.aws4Request + "\n") + generateHex(r5);
        if (this.debug == false) goto L5;
        System.out.println("##String to sign:\n" + r6);
    L5:
        return r6;
    }

    public Map<String, String> getHeaders() {
        String r0 = calculateSignature(prepareStringToSign(prepareCanonicalRequest()));
        if (r0 == null) goto L17;
        HashMap r2 = new HashMap(0);
        Iterator<Map.Entry<String, String>> r3 = this.awsHeaders.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r2.put(r4.getKey(), r4.getValue());
        goto L6
    L8:
        r2.put("Authorization", buildAuthorizationString(r0));
        if (this.debug == false) goto L15;
        System.out.println("##Signature:\n" + r0);
        System.out.println("##Header:");
        Iterator r7 = r2.entrySet().iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        System.out.println(((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin")) + " = " + ((String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L12
    L14:
        System.out.println("================================");
    L15:
        return r2;
    L17:
        if (this.debug == false) goto L23;
        System.out.println("##Signature:\n" + r0);
        return null;
    L23:
        return null;
    }
}
