package com.bytedance.bdinstall;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.util.NetUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
public class DefaultClientWrapper implements INetworkClientWrapper {
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    private static final String[] HTTP_METHOD = null;
    private static final int LENGTH_MAX = 10240;
    private static final int METHOD_GET = 0;
    private static final int METHOD_POST = 1;

    private static class HttpResp {
        byte[] mRespByteArray;
        String mRespStr;
        int mType;

        HttpResp(int r1) {
            this.mType = r1;
        }
    }

    static {
        HTTP_METHOD = new String[]{HttpMethodContrants.GET, "POST"};
    }

    public DefaultClientWrapper() {
    }

    public static TTResponse http(int r9, String r10, HashMap<String, String> r11, byte[] r12) {
        if (DrLog.debug() == false) goto L16;
        DrLog.d("http: " + r10);
        if (r11 == null) goto L14;
        Iterator<Map.Entry<String, String>> r2 = r11.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L8;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4.getValue(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L8;
        DrLog.d("http headers key:" + ((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin")) + " value:" + ((String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin")));
    L14:
        if (r12 == null) goto L16;
        DrLog.d("http data length:" + r12.length);
    L16:
        TTResponse r3 = null;
        BufferedReader r5 = null;
        r3 = null;
        r3 = null;
        HttpURLConnection r6 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(new URL(r10).openConnection(), HttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L75
        if (r9 != 0) goto L21;
        r6.setDoOutput(false);     // Catch: Throwable -> L75
    L24:
        r6.setRequestMethod(HTTP_METHOD[r9]);     // Catch: Throwable -> L75
        if (r11 != null) goto L27;
    L37:
        r6.setRequestProperty(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);     // Catch: Throwable -> L75
        if (r12 != null) goto L40;
    L43:
        DataOutputStream r13 = null;
    L44:
        int r14 = r6.getResponseCode();     // Catch: Throwable -> L72
        if (r14 != 200) goto L71;
        if (r6.getContentLength() >= LENGTH_MAX) goto L63;
        InputStream r7 = r6.getInputStream();     // Catch: Throwable -> L72
        if (NetConst.GZIP.equalsIgnoreCase(r6.getContentEncoding()) == false) goto L51;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r7)));     // Catch: Throwable -> L72
    L116:
        StringBuilder r8 = new StringBuilder(r7.available());     // Catch: Throwable -> L61
    L53:
        String r15 = r1.readLine();     // Catch: Throwable -> L61
        if (r15 == null) goto L56;
        r8.append(r15).append("\n");     // Catch: Throwable -> L61
        goto L53
    L56:
        String r16 = r8.toString();     // Catch: Throwable -> L61
        JSONObject r17 = new JSONObject(r16);     // Catch: Throwable -> L59
        r17.put(Api.KEY_HTTP_CODE, 200);     // Catch: Throwable -> L59
        r17.put(Api.KEY_SET_COOKIE, r6.getHeaderField(Api.KEY_SET_COOKIE));     // Catch: Throwable -> L59
        List<Pair<String, String>> r18 = NetUtils.parseResponseHeaders(r6.getHeaderFields());     // Catch: Throwable -> L59
        r16 = r17.toString();     // Catch: Throwable -> L59
        TTResponse r0 = new TTResponse(r10, r14, r18, r16);     // Catch: Throwable -> L59
        r5 = r1;
    L65:
        if (r13 != null) goto L103;
    L67:
        if (r5 != null) goto L111;
    L69:
        r3 = r0;
    L84:
        if (DrLog.debug() == false) goto L86;
        DrLog.d("http response: " + r16);
    L86:
        return r3;
    L111:
        r5.close();     // Catch: IOException -> L96
        goto L69
    L103:
        r13.close();     // Catch: IOException -> L95
    L59:
        Throwable th = th;
    L74:
        Throwable r19 = th;
        DataOutputStream r110 = r13;
        th = r19;
    L101:
        DrLog.ysnp(th);     // Catch: Throwable -> L89
        if (ZeusTransformUtils.instanceOf(th, RangersHttpException.class) == true) goto L88;
        if (r110 != null) goto L109;
    L81:
        if (r1 == null) goto L84;
        r1.close();     // Catch: IOException -> L97
        goto L84
    L109:
        r110.close();     // Catch: IOException -> L98
        goto L81
    L88:
        throw ((RangersHttpException) ZeusTransformUtils.preCheckCast(th, RangersHttpException.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        if (r110 != null) goto L105;
    L92:
        if (r1 == null) goto L137;
        r1.close();     // Catch: IOException -> L100
        throw th;
    L138:
        throw th;
    L137:
        throw th;
    L105:
        r110.close();     // Catch: IOException -> L99
    L61:
        th = th;
        r16 = null;
        goto L74
    L51:
        r1 = new BufferedReader(new InputStreamReader(r7));     // Catch: Throwable -> L72
        goto L116
    L63:
        DrLog.ysnp(null);     // Catch: Throwable -> L72
        r0 = null;
        r16 = null;
        goto L65
    L71:
        throw new RangersHttpException(r14, r6.getResponseMessage());     // Catch: Throwable -> L72
    L40:
        if (r12.length <= 0) goto L43;
        r13 = new DataOutputStream(r6.getOutputStream());     // Catch: Throwable -> L75
        r13.write(r12);     // Catch: Throwable -> L72
        r13.flush();     // Catch: Throwable -> L72
        r13.close();     // Catch: Throwable -> L72
    L72:
        th = th;
        r1 = null;
        r16 = null;
        goto L74
    L27:
        if (r11.isEmpty() == true) goto L37;
        Iterator<Map.Entry<String, String>> r20 = r11.entrySet().iterator();     // Catch: Throwable -> L75
    L30:
        if (r20.hasNext() == false) goto L37;
        Map.Entry r111 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L75
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r111.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L36;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r111.getValue(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L36;
        r6.addRequestProperty((String) ZeusTransformUtils.preCheckCast(r111.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r111.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L75
    L36:
        DrLog.ysnp(null);     // Catch: Throwable -> L75
        goto L30
    L21:
        if (r9 != 1) goto L23;
        r6.setDoOutput(true);     // Catch: Throwable -> L75
        goto L24
    L23:
        DrLog.ysnp(null);     // Catch: Throwable -> L75
    L75:
        th = th;
        r110 = null;
        r1 = null;
        r16 = null;
        goto L101
    }

    private static HttpResp httpRequestInner(int r9, String r10, Map<String, String> r11, byte[] r12, int r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        if (DrLog.DEBUG == false) goto L16;
        DrLog.d("http: " + r10);
        if (r14 == null) goto L14;
        Iterator r2 = r14.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L8;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4.getValue(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L8;
        DrLog.d("http headers key:" + ((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin")) + " value:" + ((String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin")));
    L14:
        if (r12 == null) goto L16;
        DrLog.d("http data length:" + r12.length);
    L16:
        HttpResp r3 = new HttpResp(r13);
        Closeable r5 = null;
        HttpURLConnection r15 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(new URL(r10).openConnection(), HttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L84
        if (r9 != 0) goto L21;
        r15.setDoOutput(false);     // Catch: Throwable -> L84
    L24:
        r15.setRequestMethod(HTTP_METHOD[r9]);     // Catch: Throwable -> L84
        if (r14 != null) goto L27;
    L37:
        r15.setRequestProperty(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);     // Catch: Throwable -> L84
        if (r12 != null) goto L40;
    L43:
        DataOutputStream r16 = null;
    L44:
        int r17 = r15.getResponseCode();     // Catch: Throwable -> L81
        if (r17 != 200) goto L80;
        if (r13 == 0) goto L48;
        InputStream r18 = r15.getInputStream();     // Catch: Throwable -> L81
        if (NetConst.GZIP.equalsIgnoreCase(r15.getContentEncoding()) == true) goto L66;
    L97:
        ByteArrayOutputStream r19 = new ByteArrayOutputStream();     // Catch: Throwable -> L77
        byte[] r110 = new byte[1024];     // Catch: Throwable -> L75
    L70:
        int r111 = r18.read(r110);     // Catch: Throwable -> L75
        if (r111 == (-1)) goto L73;
        r19.write(r110, 0, r111);     // Catch: Throwable -> L75
        goto L70
    L73:
        r3.mRespByteArray = r19.toByteArray();     // Catch: Throwable -> L75
        ByteArrayOutputStream r112 = r19;
    L74:
        Utils.closeSafely(r16);
        Utils.closeSafely(r5);
        Closeable r113 = r112;
    L89:
        Utils.closeSafely(r18);
        Utils.closeSafely(r113);
        return r3;
    L75:
        th = move-exception;
        r5 = r16;
        th = th;
        BufferedReader r114 = null;
        Closeable r115 = r19;
    L103:
        DrLog.ysnp(th);     // Catch: Throwable -> L93
        if (ZeusTransformUtils.instanceOf(th, RangersHttpException.class) == true) goto L92;
        Utils.closeSafely(r5);
        Utils.closeSafely(r114);
        r113 = r115;
        goto L89
    L92:
        throw ((RangersHttpException) ZeusTransformUtils.preCheckCast(th, RangersHttpException.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        Utils.closeSafely(r5);
        Utils.closeSafely(r114);
        Utils.closeSafely(r18);
        Utils.closeSafely(r115);
        throw th;
    L77:
        Throwable th = th;
        r114 = null;
    L83:
        r5 = r16;
        th = th;
        r115 = r114;
        goto L103
    L66:
        r18 = new GZIPInputStream(r18);     // Catch: Throwable -> L81
        goto L97
    L48:
        if (r15.getContentLength() >= LENGTH_MAX) goto L61;
        InputStream r116 = r15.getInputStream();     // Catch: Throwable -> L81
        if (NetConst.GZIP.equalsIgnoreCase(r15.getContentEncoding()) == false) goto L52;
        r114 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r116)));     // Catch: Throwable -> L81
    L101:
        StringBuilder r117 = new StringBuilder(r116.available());     // Catch: Throwable -> L59
    L54:
        String r118 = r114.readLine();     // Catch: Throwable -> L59
        if (r118 == null) goto L57;
        r117.append(r118).append("\n");     // Catch: Throwable -> L59
        goto L54
    L57:
        r3.mRespStr = r117.toString();     // Catch: Throwable -> L59
        JSONObject r119 = new JSONObject(r3.mRespStr);     // Catch: Throwable -> L59
        r119.put(Api.KEY_SET_COOKIE, r15.getHeaderField(Api.KEY_SET_COOKIE));     // Catch: Throwable -> L59
        r3.mRespStr = r119.toString();     // Catch: Throwable -> L59
    L62:
        r112 = null;
        r18 = null;
        r5 = r114;
    L59:
        th = move-exception;
        r18 = null;
        r5 = r16;
        th = th;
        r115 = null;
        goto L103
    L52:
        r114 = new BufferedReader(new InputStreamReader(r116));     // Catch: Throwable -> L81
        goto L101
    L61:
        DrLog.ysnp(null);     // Catch: Throwable -> L81
        r114 = null;
        goto L62
    L80:
        throw new RangersHttpException(r17, r15.getResponseMessage());     // Catch: Throwable -> L81
    L40:
        if (r12.length <= 0) goto L43;
        r16 = new DataOutputStream(r15.getOutputStream());     // Catch: Throwable -> L84
        r16.write(r12);     // Catch: Throwable -> L81
        r16.flush();     // Catch: Throwable -> L81
        r16.close();     // Catch: Throwable -> L81
    L81:
        th = th;
        r18 = null;
        r114 = null;
        goto L83
    L27:
        if (r14.isEmpty() == true) goto L37;
        Iterator r20 = r14.entrySet().iterator();     // Catch: Throwable -> L84
    L30:
        if (r20.hasNext() == false) goto L37;
        Map.Entry r120 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L84
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r120.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L36;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r120.getValue(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L36;
        r15.addRequestProperty((String) ZeusTransformUtils.preCheckCast(r120.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r120.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L84
    L36:
        DrLog.ysnp(null);     // Catch: Throwable -> L84
        goto L30
    L21:
        if (r9 != 1) goto L23;
        r15.setDoOutput(true);     // Catch: Throwable -> L84
        goto L24
    L23:
        DrLog.ysnp(null);     // Catch: Throwable -> L84
    L84:
        th = th;
        r115 = null;
        r18 = null;
        r114 = null;
        goto L103
    }

    @Override // com.bytedance.bdinstall.INetworkClientWrapper
    public TTResponse get(String r2, Map<String, String> r3) {
        return http(0, r2, (HashMap) ZeusTransformUtils.preCheckCast((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), HashMap.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // com.bytedance.bdinstall.INetworkClientWrapper
    public TTResponse post(String r6, List<Pair<String, String>> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();
        if (r8 == null) goto L9;
        Iterator r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L9;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r9.next(), Pair.class, "com.obric.memorydata.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.memorydata.plugin"), r2.second);
    L9:
        return post(r6, r0.toString().getBytes(), "application/json; charset=utf-8");
    }

    @Override // com.bytedance.bdinstall.INetworkClientWrapper
    public TTResponse post(String r3, byte[] r4, String r5) {
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r5) == true) goto L6;
        r0.put(NetConst.KEY_CONTENT_TYPE, r5);
    L6:
        return post(r3, r4, r0);
    }

    @Override // com.bytedance.bdinstall.INetworkClientWrapper
    public TTResponse post(String r2, byte[] r3, Map<String, String> r4) {
        return http(1, r2, (HashMap) ZeusTransformUtils.preCheckCast((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), HashMap.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.bytedance.bdinstall.INetworkClientWrapper
    public byte[] postStream(String r2, byte[] r3, Map<String, String> r4) {
        return httpRequestInner(1, r2, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), r3, 1).mRespByteArray;
    }
}
