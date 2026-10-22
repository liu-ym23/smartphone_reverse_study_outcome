package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class k implements Interceptor {
    public k() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r9) {
        Interceptor.Chain r8 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r9, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Request r10 = r8.request();
        if ("1".equals(r10.headers().get("x-metasec-bypass-mssdk")) == false) goto L7;
        Request.Builder r11 = r10.newBuilder();
        r11.removeHeader("x-metasec-bypass-mssdk");
        Request r12 = r11.build();
    L6:
        return r8.proceed(r12);
    L7:
        Map<String, String> r1 = com.bytedance.frameworks.baselib.network.http.f.a(r10.url().toString(), r10.headers().toMultimap());
        Map<String, String> r2 = null;
        if ("1".equals(r10.headers().get("x-tt-oec-opaque-enable")) == false) goto L10;
        r2 = com.bytedance.frameworks.baselib.network.http.f.b(r10.url().toString(), r10.headers().toMultimap());
    L10:
        if (r1 != null) goto L14;
        if (r2 != null) goto L14;
        return r8.proceed(r10);
    L14:
        Request.Builder r3 = new Request.Builder();
        r3.url(r10.url());
        r3.method(r10.method(), r10.body());
        r3.tag(r10.tag());
        Headers.Builder r13 = r10.headers().newBuilder();
        if (r1 == null) goto L20;
        Iterator<Map.Entry<String, String>> r4 = r1.entrySet().iterator();
    L18:
        if (r4.hasNext() == false) goto L20;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r13.add((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r5.getValue(), String.class, "com.obric.memorydata.plugin"));
    L20:
        if (r2 == null) goto L25;
        Iterator<Map.Entry<String, String>> r6 = r2.entrySet().iterator();
    L23:
        if (r6.hasNext() == false) goto L25;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r13.add((String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.memorydata.plugin"));
    L25:
        r13.removeAll("x-tt-oec-opaque-enable");
        r3.headers(r13.build());
        r12 = r3.build();
        goto L6
    }
}
