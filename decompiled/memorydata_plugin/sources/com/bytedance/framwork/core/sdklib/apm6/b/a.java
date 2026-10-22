package com.bytedance.framwork.core.sdklib.apm6.b;

import android.text.TextUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.framwork.core.sdkmonitor.f;
import com.bytedance.services.apm.api.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2583a = "POST";

    static {
    }

    private static c a(String r8, byte[] r9, String r10, Map<String, String> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L57;
        HttpURLConnection r13 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(new URL(r8).openConnection(), HttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        r13.setConnectTimeout(5000);     // Catch: Throwable -> L50
        r13.setReadTimeout(5000);     // Catch: Throwable -> L50
        if (r12 != null) goto L10;
    L18:
        r13.setDoOutput(TextUtils.equals(r10, f2583a));     // Catch: Throwable -> L50
        r13.setRequestMethod(r10);     // Catch: Throwable -> L50
        if (r9 != null) goto L21;
    L23:
        int r14 = r13.getResponseCode();     // Catch: Throwable -> L50
        if (r14 != 200) goto L45;
        InputStream r15 = r13.getInputStream();     // Catch: Throwable -> L50
        String r16 = r13.getContentEncoding();     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r16) == false) goto L29;
    L31:
        byte[] r2 = f.a(r15);     // Catch: Throwable -> L59
    L32:
        Map<String, List<String>> r17 = r13.getHeaderFields();     // Catch: Throwable -> L59
        HashMap r3 = new HashMap();     // Catch: Throwable -> L59
        Iterator<String> r4 = r17.keySet().iterator();     // Catch: Throwable -> L59
    L34:
        if (r4.hasNext() == false) goto L40;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        List r6 = (List) ZeusTransformUtils.preCheckCast(r17.get(r5), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        if (r6 == null) goto L34;
        if (r6.size() <= 0) goto L34;
        r3.put(r5, r6.get(0));     // Catch: Throwable -> L59
        goto L34
    L40:
        c r18 = new c(r14, r3, r2);     // Catch: Throwable -> L59
        IOUtils.closeQuietly(r15);
        if (r13 != null) goto L67;
    L44:
        return r18;
    L67:
        r13.disconnect();     // Catch: Exception -> L58
        goto L44
    L29:
        if (r16.equalsIgnoreCase(NetConst.GZIP) == false) goto L31;
        GZIPInputStream r19 = new GZIPInputStream(r15);     // Catch: Throwable -> L59
        r2 = f.a(r19);     // Catch: Throwable -> L59
        r19.close();     // Catch: Throwable -> L59
    L52:
        IOUtils.closeQuietly(r15);
        if (r13 != null) goto L71;
    L55:
        return null;
    L71:
        r13.disconnect();     // Catch: Exception -> L60
        goto L55
    L45:
        c r110 = new c(r14, null);     // Catch: Throwable -> L50
        IOUtils.closeQuietly(null);
        if (r13 != null) goto L69;
    L49:
        return r110;
    L69:
        r13.disconnect();     // Catch: Exception -> L61
        goto L49
    L21:
        if (r9.length <= 0) goto L23;
        DataOutputStream r111 = new DataOutputStream(r13.getOutputStream());     // Catch: Throwable -> L50
        r111.write(r9);     // Catch: Throwable -> L50
        r111.flush();     // Catch: Throwable -> L50
        r111.close();     // Catch: Throwable -> L50
        goto L23
    L10:
        if (r12.isEmpty() == true) goto L18;
        Iterator r112 = r12.entrySet().iterator();     // Catch: Throwable -> L50
    L13:
        if (r112.hasNext() == false) goto L18;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r112.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        if (r7 == null) goto L13;
        r13.setRequestProperty((String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L50
    L50:
        r15 = null;
    L51:
        r13 = null;
        r15 = null;
        goto L52
    L57:
        throw new IllegalArgumentException("request method is not null");
    }

    public static c a(String r2, byte[] r3, Map<String, String> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        return a(r2, r3, f2583a, r5);
    }
}
