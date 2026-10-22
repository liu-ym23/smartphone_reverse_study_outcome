package com.ss.bduploader;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes6.dex */
public class BDAuthHelper {
    public static final int keyAccessKey = 0;
    public static final int keyAuthorization = 10;
    public static final int keyCanonicalURI = 5;
    public static final int keyHost = 7;
    public static final int keyHttpMethod = 4;
    public static final int keyPlayLoad = 6;
    public static final int keyQueryStr = 11;
    public static final int keyRegionName = 2;
    public static final int keySecretKey = 1;
    public static final int keyServiceName = 3;
    public static final int keyXAmzDate = 8;
    public static final int keyXAmzSecurityToken = 9;
    private String accessKeyID;
    private String authorization;
    private TreeMap<String, String> awsHeaders;
    private String canonicalURI;
    private boolean debug;
    private String host;
    private String httpMethodName;
    private String payload;
    private TreeMap<String, ArrayList<String>> queryParameters;
    private String queryStr;
    private String regionName;
    private String secretAccessKey;
    private String serviceName;
    private String xAmzDate;
    private String xAmzSecurityToken;

    public BDAuthHelper() {
        this.debug = false;
    }

    private String parseAPIString(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L26;
        return "parseAPIString:query string is empty";
    L26:
        String[] r11 = r10.split("[?]");     // Catch: Exception -> L22
        if (r11.length >= 2) goto L10;
        return "parseAPIString:query string param is empty";
    L10:
        String[] r12 = r11[1].split("&");     // Catch: Exception -> L22
        TreeMap<String, ArrayList<String>> r2 = new TreeMap();     // Catch: Exception -> L22
        int r4 = 0;
    L12:
        if (r4 >= r12.length) goto L20;
        String[] r5 = r12[r4].split("=");     // Catch: Exception -> L22
        if (r5.length < 2) goto L19;
        if (r2.containsKey(r5[0]) == true) goto L18;
        ArrayList<String> r6 = new ArrayList();     // Catch: Exception -> L22
        r6.add(r5[1]);     // Catch: Exception -> L22
        r2.put(r5[0], r6);     // Catch: Exception -> L22
        goto L19
    L18:
        ((ArrayList) ZeusTransformUtils.preCheckCast(r2.get(r5[0]), ArrayList.class, "com.obric.memorydata.plugin")).add(r5[1]);     // Catch: Exception -> L22
    L19:
        r4 = r4 + 1;     // Catch: Exception -> L22
        goto L12
    L20:
        this.queryParameters = r2;     // Catch: Exception -> L22
        return null;
    L22:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public Map<String, String> getSignature() {
        TreeMap<String, String> r0 = new TreeMap();
        r0.put(AWSV4AuthParams.AWSAmzDateKey, this.xAmzDate);
        r0.put(AWSV4AuthParams.AMZ_SECURITY_TOKEN_KEY, this.xAmzSecurityToken);
        parseAPIString(this.queryStr);
        Map<String, String> r1 = new AWSV4Auth.Builder(this.accessKeyID, this.secretAccessKey).regionName(this.regionName).serviceName(this.serviceName).httpMethodName(this.httpMethodName).canonicalURI(AWSV4AuthParams.CANONICAL_URI).queryParameters(this.queryParameters).awsHeaders(r0).payload(this.payload).build().getHeaders();
        this.authorization = (String) ZeusTransformUtils.preCheckCast(r1.get("Authorization"), String.class, "com.obric.memorydata.plugin");
        return r1;
    }

    public String getStringValue(int r2) {
        getSignature();
        if (r2 == 10) goto L7;
        return null;
    L7:
        return this.authorization;
    }

    public void setAwsHeaders(TreeMap<String, String> r1) {
        this.awsHeaders = r1;
    }

    public void setQueryParameters(TreeMap<String, ArrayList<String>> r1) {
        this.queryParameters = r1;
    }

    public void setStringValue(int r1, String r2) {
        switch(r1) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            case 10: goto L26;
            case 11: goto L4;
            default: goto L26;
        };
    L4:
        this.queryStr = r2;
        return;
    L5:
        this.xAmzSecurityToken = r2;
        return;
    L6:
        this.xAmzDate = r2;
        return;
    L7:
        this.host = r2;
        return;
    L8:
        this.payload = r2;
        return;
    L9:
        this.canonicalURI = r2;
        return;
    L10:
        this.httpMethodName = r2;
        return;
    L11:
        this.serviceName = r2;
        return;
    L12:
        this.regionName = r2;
        return;
    L13:
        this.secretAccessKey = r2;
        return;
    L14:
        this.accessKeyID = r2;
        return;
    }
}
