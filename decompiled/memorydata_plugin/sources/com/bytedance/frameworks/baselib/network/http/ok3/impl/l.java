package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class l implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f2496a;

    public interface a {
        boolean a(String r1, String r2, Map<String, List<String>> r3, String r4);
    }

    static {
    }

    public l() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r6) {
        Interceptor.Chain r5 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r6, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Request r7 = r5.request();
        if (f2496a == null) goto L12;
        if ("/get_domains/v5/".equals(r7.url().encodedPath()) == false) goto L12;
        if (f2496a.a(r7.method(), r7.url().toString(), r7.headers().toMultimap(), "") == true) goto L12;
        throw new IOException("TNC requsest dropped by sandbox");
    L12:
        return r5.proceed(r7);
    }
}
