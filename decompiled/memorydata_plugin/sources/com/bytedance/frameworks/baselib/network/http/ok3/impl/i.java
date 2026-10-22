package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class i implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f2491a;

    public interface a {
        void a(String r1, String r2, Map<String, List<String>> r3, String r4);
    }

    static {
    }

    public i() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r7) {
        Interceptor.Chain r6 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r7, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Request r8 = r6.request();
        if (r8 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        ArrayList r2 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r3 = r8.headers().toMultimap().entrySet().iterator();
    L12:
        if (r3.hasNext() == false) goto L20;
        String r4 = (String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin");
        if (r4.equals(com.bytedance.retrofit2.client.Request.KEY_BYPASS_DISPATCH) == false) goto L17;
        if (r1 == false) goto L17;
    L18:
        r2.add(r4);
    L17:
        if (r4.startsWith("x-metasec") == false) goto L12;
    L20:
        if (r2.size() <= 0) goto L27;
        Request.Builder r9 = r8.newBuilder();
        Iterator r5 = r2.iterator();
    L23:
        if (r5.hasNext() == false) goto L25;
        r9.removeHeader((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));
        goto L23
    L25:
        r8 = r9.build();
    L27:
        if (f2491a == null) goto L30;
        f2491a.a(r8.method(), r8.url().toString(), r8.headers().toMultimap(), "");
    L30:
        return r6.proceed(r8);
    L5:
        if (r8.headers() == null) goto L9;
        if (r8.headers().get(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_FEATURES) == null) goto L9;
        r1 = "1".equals(r8.headers().get(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_FEATURES));
        goto L10
    }
}
