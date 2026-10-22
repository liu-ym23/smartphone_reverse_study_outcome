package com.bytedance.bdinstall;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DefaultClient implements INetworkClient {
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    private static final String[] HTTP_METHOD = null;
    private static final int LENGTH_MAX = 10240;
    private static final int METHOD_GET = 0;
    private static final int METHOD_POST = 1;

    private static class HttpResp {
        byte[] mRespByteArray;
        String mRespStr;
        int mType;

        HttpResp(int r10) {
            this.mType = r10;
        }
    }

    static {
        HTTP_METHOD = new String[]{"GET", CloudConfig.REQUEST_TYPE_POST};
    }

    public DefaultClient() {
    }

    public static String http(int r10, String r11, HashMap<String, String> r12, byte[] r13) {
        if (DrLog.debug() == false) goto L16;
        DrLog.d("http: " + r11);
        if (r12 == null) goto L14;
        Iterator<Map.Entry<String, String>> r14 = r12.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L14;
        Map.Entry<String, String> r15 = r14.next();
        if (TextUtils.isEmpty(r15.getKey()) == true) goto L8;
        if (TextUtils.isEmpty(r15.getValue()) == true) goto L8;
        DrLog.d("http headers key:" + r15.getKey() + " value:" + r15.getValue());
    L14:
        if (r13 == null) goto L16;
        DrLog.d("http data length:" + r13.length);
    L16:
        DataOutputStream r16 = null;
        BufferedReader r17 = null;
        HttpURLConnection r18 = (HttpURLConnection) new URL(r11).openConnection();     // Catch: Throwable -> L71
        if (r10 != 0) goto L21;
        r18.setDoOutput(false);     // Catch: Throwable -> L71
    L24:
        r18.setRequestMethod(HTTP_METHOD[r10]);     // Catch: Throwable -> L71
        if (r12 != null) goto L27;
    L37:
        r18.setRequestProperty(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);     // Catch: Throwable -> L71
        if (r13 != null) goto L40;
    L43:
        DataOutputStream r19 = null;
    L44:
        int r20 = r18.getResponseCode();     // Catch: Throwable -> L69
        if (r20 != 200) goto L68;
        if (r18.getContentLength() >= 10240) goto L60;
        InputStream r21 = r18.getInputStream();     // Catch: Throwable -> L69
        if (NetConst.GZIP.equalsIgnoreCase(r18.getContentEncoding()) == false) goto L51;
        BufferedReader r22 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r21)));     // Catch: Throwable -> L69
    L97:
        StringBuilder r23 = new StringBuilder(r21.available());     // Catch: Throwable -> L58
    L53:
        String r24 = r22.readLine();     // Catch: Throwable -> L58
        if (r24 == null) goto L56;
        r23.append(r24);     // Catch: Throwable -> L58
        r23.append("\n");     // Catch: Throwable -> L58
        goto L53
    L56:
        JSONObject r25 = new JSONObject(r23.toString());     // Catch: Throwable -> L58
        r25.put(Api.KEY_HTTP_CODE, 200);     // Catch: Throwable -> L58
        r25.put(Api.KEY_SET_COOKIE, r18.getHeaderField(Api.KEY_SET_COOKIE));     // Catch: Throwable -> L58
        r11 = r25.toString();     // Catch: Throwable -> L58
        r17 = r22;
    L62:
        if (r19 != null) goto L105;
    L64:
        if (r17 == null) goto L80;
        r17.close();     // Catch: IOException -> L92
    L111:
        goto L80
    L105:
        r19.close();     // Catch: IOException -> L91
    L58:
        th = move-exception;
        r16 = r19;
        th = th;
        r11 = null;
    L107:
        DrLog.ysnp(th);     // Catch: Throwable -> L85
        if ((th instanceof RangersHttpException) == true) goto L84;
        if (r16 != null) goto L99;
    L77:
        if (r22 == null) goto L80;
        r22.close();     // Catch: IOException -> L92
        goto L111
    L99:
        r16.close();     // Catch: IOException -> L93
        goto L77
    L84:
        throw th;     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        if (r16 != null) goto L109;
    L88:
        if (r22 == null) goto L129;
        r22.close();     // Catch: IOException -> L95
        throw th;
    L130:
        throw th;
    L129:
        throw th;
    L109:
        r16.close();     // Catch: IOException -> L94
        goto L88
    L51:
        r22 = new BufferedReader(new InputStreamReader(r21));     // Catch: Throwable -> L69
        goto L97
    L60:
        DrLog.ysnp(null);     // Catch: Throwable -> L69
        r11 = null;
        goto L62
    L68:
        throw new RangersHttpException(r20, r18.getResponseMessage());     // Catch: Throwable -> L69
    L40:
        if (r13.length <= 0) goto L43;
        r19 = new DataOutputStream(r18.getOutputStream());     // Catch: Throwable -> L71
        r19.write(r13);     // Catch: Throwable -> L69
        r19.flush();     // Catch: Throwable -> L69
        r19.close();     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        r22 = null;
        r16 = r19;
        th = th;
        r11 = null;
        goto L107
    L27:
        if (r12.isEmpty() == true) goto L37;
        Iterator<Map.Entry<String, String>> r26 = r12.entrySet().iterator();     // Catch: Throwable -> L71
    L30:
        if (r26.hasNext() == false) goto L37;
        Map.Entry<String, String> r27 = r26.next();     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r27.getKey()) == true) goto L36;
        if (TextUtils.isEmpty(r27.getValue()) == true) goto L36;
        r18.addRequestProperty(r27.getKey(), r27.getValue());     // Catch: Throwable -> L71
    L36:
        DrLog.ysnp(null);     // Catch: Throwable -> L71
        goto L30
    L21:
        if (r10 != 1) goto L23;
        r18.setDoOutput(true);     // Catch: Throwable -> L71
        goto L24
    L23:
        DrLog.ysnp(null);     // Catch: Throwable -> L71
    L71:
        th = th;
        r11 = null;
        r22 = null;
    L80:
        if (DrLog.debug() == false) goto L82;
        DrLog.d("http response: " + r11);
    L82:
        return r11;
    }

    private static HttpResp httpRequestInner(int r10, String r11, Map<String, String> r12, byte[] r13, int r14) {
        if (DrLog.DEBUG == false) goto L16;
        DrLog.d("http: " + r11);
        if (r12 == null) goto L14;
        Iterator<Map.Entry<String, String>> r15 = r12.entrySet().iterator();
    L8:
        if (r15.hasNext() == false) goto L14;
        Map.Entry<String, String> r16 = r15.next();
        if (TextUtils.isEmpty(r16.getKey()) == true) goto L8;
        if (TextUtils.isEmpty(r16.getValue()) == true) goto L8;
        DrLog.d("http headers key:" + r16.getKey() + " value:" + r16.getValue());
    L14:
        if (r13 == null) goto L16;
        DrLog.d("http data length:" + r13.length);
    L16:
        HttpResp r17 = new HttpResp(r14);
        Closeable r18 = null;
        HttpURLConnection r19 = (HttpURLConnection) new URL(r11).openConnection();     // Catch: Throwable -> L84
        if (r10 != 0) goto L21;
        r19.setDoOutput(false);     // Catch: Throwable -> L84
    L24:
        r19.setRequestMethod(HTTP_METHOD[r10]);     // Catch: Throwable -> L84
        if (r12 != null) goto L27;
    L37:
        r19.setRequestProperty(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);     // Catch: Throwable -> L84
        if (r13 != null) goto L40;
    L43:
        DataOutputStream r20 = null;
    L44:
        int r21 = r19.getResponseCode();     // Catch: Throwable -> L81
        if (r21 != 200) goto L80;
        if (r14 == 0) goto L48;
        InputStream r22 = r19.getInputStream();     // Catch: Throwable -> L81
        if (NetConst.GZIP.equalsIgnoreCase(r19.getContentEncoding()) == true) goto L66;
    L96:
        ByteArrayOutputStream r23 = new ByteArrayOutputStream();     // Catch: Throwable -> L77
        byte[] r110 = new byte[1024];     // Catch: Throwable -> L75
    L70:
        int r111 = r22.read(r110);     // Catch: Throwable -> L75
        if (r111 == (-1)) goto L73;
        r23.write(r110, 0, r111);     // Catch: Throwable -> L75
        goto L70
    L73:
        r17.mRespByteArray = r23.toByteArray();     // Catch: Throwable -> L75
        ByteArrayOutputStream r24 = r23;
    L74:
        Utils.closeSafely(r20);
        Utils.closeSafely(r18);
        Closeable r25 = r24;
    L89:
        Utils.closeSafely(r22);
        Utils.closeSafely(r25);
        return r17;
    L75:
        th = move-exception;
        r18 = r20;
        th = th;
        BufferedReader r112 = null;
        Closeable r26 = r23;
    L105:
        DrLog.ysnp(th);     // Catch: Throwable -> L93
        if ((th instanceof RangersHttpException) == true) goto L92;
        Utils.closeSafely(r18);
        Utils.closeSafely(r112);
        r25 = r26;
        goto L89
    L92:
        throw th;     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        Utils.closeSafely(r18);
        Utils.closeSafely(r112);
        Utils.closeSafely(r22);
        Utils.closeSafely(r26);
        throw th;
    L77:
        RangersHttpException th = th;
        r112 = null;
    L83:
        r18 = r20;
        th = th;
        r26 = r112;
        goto L105
    L66:
        r22 = new GZIPInputStream(r22);     // Catch: Throwable -> L81
        goto L96
    L48:
        if (r19.getContentLength() >= 10240) goto L61;
        InputStream r27 = r19.getInputStream();     // Catch: Throwable -> L81
        if (NetConst.GZIP.equalsIgnoreCase(r19.getContentEncoding()) == false) goto L52;
        r112 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r27)));     // Catch: Throwable -> L81
    L100:
        StringBuilder r113 = new StringBuilder(r27.available());     // Catch: Throwable -> L59
    L54:
        String r28 = r112.readLine();     // Catch: Throwable -> L59
        if (r28 == null) goto L57;
        r113.append(r28);     // Catch: Throwable -> L59
        r113.append("\n");     // Catch: Throwable -> L59
        goto L54
    L57:
        r17.mRespStr = r113.toString();     // Catch: Throwable -> L59
        JSONObject r29 = new JSONObject(r17.mRespStr);     // Catch: Throwable -> L59
        r29.put(Api.KEY_SET_COOKIE, r19.getHeaderField(Api.KEY_SET_COOKIE));     // Catch: Throwable -> L59
        r17.mRespStr = r29.toString();     // Catch: Throwable -> L59
    L62:
        r24 = null;
        r22 = null;
        r18 = r112;
    L59:
        th = move-exception;
        r22 = null;
        r18 = r20;
        th = th;
        r26 = null;
        goto L105
    L52:
        r112 = new BufferedReader(new InputStreamReader(r27));     // Catch: Throwable -> L81
        goto L100
    L61:
        DrLog.ysnp(null);     // Catch: Throwable -> L81
        r112 = null;
        goto L62
    L80:
        throw new RangersHttpException(r21, r19.getResponseMessage());     // Catch: Throwable -> L81
    L40:
        if (r13.length <= 0) goto L43;
        r20 = new DataOutputStream(r19.getOutputStream());     // Catch: Throwable -> L84
        r20.write(r13);     // Catch: Throwable -> L81
        r20.flush();     // Catch: Throwable -> L81
        r20.close();     // Catch: Throwable -> L81
    L81:
        th = th;
        r22 = null;
        r112 = null;
        goto L83
    L27:
        if (r12.isEmpty() == true) goto L37;
        Iterator<Map.Entry<String, String>> r30 = r12.entrySet().iterator();     // Catch: Throwable -> L84
    L30:
        if (r30.hasNext() == false) goto L37;
        Map.Entry<String, String> r31 = r30.next();     // Catch: Throwable -> L84
        if (TextUtils.isEmpty(r31.getKey()) == true) goto L36;
        if (TextUtils.isEmpty(r31.getValue()) == true) goto L36;
        r19.addRequestProperty(r31.getKey(), r31.getValue());     // Catch: Throwable -> L84
    L36:
        DrLog.ysnp(null);     // Catch: Throwable -> L84
        goto L30
    L21:
        if (r10 != 1) goto L23;
        r19.setDoOutput(true);     // Catch: Throwable -> L84
        goto L24
    L23:
        DrLog.ysnp(null);     // Catch: Throwable -> L84
    L84:
        th = th;
        r26 = null;
        r22 = null;
        r112 = null;
        goto L105
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String get(String r10, Map<String, String> r11) {
        return http(0, r10, (HashMap) r11, null);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r10, List<Pair<String, String>> r11) {
        JSONObject r12 = new JSONObject();
        if (r11 == null) goto L9;
        Iterator<Pair<String, String>> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L9;
        Pair<String, String> r14 = r13.next();
        r12.put((String) r14.first, r14.second);
    L9:
        return post(r10, r12.toString().getBytes(), "application/json; charset=utf-8");
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r10, byte[] r11, String r12) {
        HashMap r13 = new HashMap();
        if (TextUtils.isEmpty(r12) == true) goto L6;
        r13.put(NetConst.KEY_CONTENT_TYPE, r12);
    L6:
        return post(r10, r11, r13);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r10, byte[] r11, Map<String, String> r12) {
        return http(1, r10, (HashMap) r12, r11);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public byte[] postStream(String r10, byte[] r11, Map<String, String> r12) {
        return httpRequestInner(1, r10, r12, r11, 1).mRespByteArray;
    }
}
