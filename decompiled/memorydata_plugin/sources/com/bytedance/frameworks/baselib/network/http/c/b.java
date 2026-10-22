package com.bytedance.frameworks.baselib.network.http.c;

import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.retrofit2.ttnet.TTInternalInterceptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements TTInternalInterceptor {
    public b() {
    }

    private Request a(Request r2) {
        if (r2 != null) goto L5;
        return r2;
    L5:
        if (r2.isResponseStreaming() == false) goto L7;
        return r2;
    L7:
        return b(r2);
    }

    private Request b(Request r6) {
        String r5 = f.a(r6.getUrl(), r6.isAddCommonParam(), r6.getMetrics(), new Object[]{r6.getBody()});     // Catch: Throwable -> L4
        Request.Builder r0 = r6.newBuilder();     // Catch: Throwable -> L4
        r0.url(r5);     // Catch: Throwable -> L4
        return r0.build();
    L4:
        th = move-exception;
        th.printStackTrace();
        return r6;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r3) {
        Interceptor.Chain r4 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r3, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Request r2 = a(r4.request());
        if (RealInterceptorChain.isProceedWithoutHookEnabled() == false) goto L6;
        return r4.proceedWithoutHook(r2);
    L6:
        return r4.proceed(r2);
    }
}
