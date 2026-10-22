package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Interceptor {
    public f() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r14) {
        Interceptor.Chain r15 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r14, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Request r0 = r15.request();
        if (r0 != null) goto L5;
    L90:
        URI r2 = r0.url().uri();     // Catch: Exception -> L12
    L13:
        Request.Builder r3 = r0.newBuilder();
        CookieHandler r4 = CookieHandler.getDefault();
        Headers r5 = r0.headers();
        Map<String, List<String>> r6 = null;
        if (r2 == null) goto L16;
        String r7 = com.bytedance.frameworks.baselib.network.http.util.c.a(r2.toString());
    L97:
        HashMap r8 = new HashMap();     // Catch: Throwable -> L66
        if (r5 == null) goto L28;
        Set<String> r9 = r5.names();     // Catch: Throwable -> L66
        if (r9 == null) goto L28;
        if (r9.isEmpty() == true) goto L28;
        Iterator<String> r10 = r9.iterator();     // Catch: Throwable -> L66
    L25:
        if (r10.hasNext() == false) goto L28;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66
        r8.put(r11, r5.values(r11));     // Catch: Throwable -> L66
    L28:
        if (r0 != null) goto L30;
    L34:
        boolean r12 = false;
    L35:
        if (r4 == null) goto L43;
        if (r12 == true) goto L43;
        if (r7 == null) goto L39;
        Map<String, List<String>> r13 = r4.get(new URI(r7), r8);     // Catch: IOException -> L41 Throwable -> L66
    L40:
        r6 = r13;
    L39:
        r13 = r4.get(r2, r8);     // Catch: IOException -> L41 Throwable -> L66
    L41:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66
    L43:
        if (r6 != null) goto L45;
    L95:
        r0 = r3.build();     // Catch: Throwable -> L70
    L72:
        Response r16 = r15.proceed(r0);
        HashMap r17 = new HashMap();
        Headers r1 = r16.headers();
        if (r1 == null) goto L82;
        Set<String> r18 = r1.names();
        if (r18 == null) goto L82;
        if (r18.isEmpty() == true) goto L82;
        Iterator<String> r19 = r18.iterator();
    L80:
        if (r19.hasNext() == false) goto L82;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin");
        r17.put(r20, r1.values(r20));
    L82:
        if (r4 != null) goto L93;
    L89:
        return r16;
    L93:
        if (r7 == null) goto L85;
        r4.put(new URI(r7), r17);     // Catch: Throwable -> L87
    L92:
        goto L89
    L85:
        r4.put(r2, r17);     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        th.printStackTrace();
    L70:
        th = move-exception;
        th.printStackTrace();
        goto L72
    L45:
        if (r6.size() <= 0) goto L95;
        Iterator<Map.Entry<String, List<String>>> r110 = r6.entrySet().iterator();     // Catch: Throwable -> L66
    L47:
        if (r110.hasNext() == false) goto L95;
        Map.Entry r21 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66
        StringBuilder r23 = new StringBuilder();     // Catch: Throwable -> L66
        if (CronetHttpURLConnection.SS_COOKIE.equalsIgnoreCase(r22) == true) goto L56;
        if ("Cookie".equalsIgnoreCase(r22) == true) goto L56;
        if ("Cookie2".equalsIgnoreCase(r22) == false) goto L47;
    L56:
        if (((List) ZeusTransformUtils.preCheckCast(r21.getValue(), List.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L47;
        Iterator r24 = ((List) ZeusTransformUtils.preCheckCast(r21.getValue(), List.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L66
        int r111 = 0;
    L59:
        if (r24.hasNext() == false) goto L64;
        String r112 = (String) ZeusTransformUtils.preCheckCast(r24.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66
        if (r111 <= 0) goto L63;
        r23.append("; ");     // Catch: Throwable -> L66
    L63:
        r23.append(r112);     // Catch: Throwable -> L66
        r111 = r111 + 1;     // Catch: Throwable -> L66
        goto L59
    L64:
        r3.addHeader(r22, r23.toString());     // Catch: Throwable -> L66
        goto L47
    L30:
        if (r0.headers() == null) goto L34;
        r12 = "1".equals(r0.header(com.bytedance.retrofit2.client.Request.KEY_BYPASS_OKHTTP_COOKIE));     // Catch: Throwable -> L66
        if ("1".equals(r0.header("x-metasec-ok-bypass-downgrade-cookie")) == false) goto L35;
        r12 = true;
    L66:
        th = move-exception;
        th.printStackTrace();
        goto L95
    L16:
        r7 = null;
    L12:
        r2 = com.bytedance.frameworks.baselib.network.http.util.i.b(r0.url().toString());
        goto L13
    L5:
        if (r0.headers() == null) goto L90;
        if ("0".equals(r0.header(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_COOKIE_HEADER)) == false) goto L90;
        Request.Builder r113 = r0.newBuilder();
        r113.removeHeader(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_COOKIE_HEADER);
        return r15.proceed(r113.build());
    }
}
