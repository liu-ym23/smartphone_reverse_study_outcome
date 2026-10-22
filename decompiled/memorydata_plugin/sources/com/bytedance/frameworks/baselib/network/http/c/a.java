package com.bytedance.frameworks.baselib.network.http.c;

import android.os.Looper;
import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.retrofit2.ttnet.TTInternalInterceptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class a implements TTInternalInterceptor {
    public a() {
    }

    private String a(String r1, RetrofitMetrics r2) {
        return f.a(r1, true, r2);
    L5:
        th = move-exception;
        th.printStackTrace();
        return r1;
    }

    public Request a(Request r6) {
        if (f.o() == true) goto L5;
    L9:
        if (r6 != null) goto L38;
        return null;
    L38:
        URL r1 = new URL(r6.getUrl());     // Catch: MalformedURLException -> L34
        if ("http".equals(r1.getProtocol()) == false) goto L15;
        f.a(r1.getHost(), r1.getPath(), false, r6.getMetrics());     // Catch: MalformedURLException -> L34
    L15:
        String r0 = r6.getUrl();
        if (ZeusTransformUtils.instanceOf(r6.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L18;
        String r2 = f.a(r0, (com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r6.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.memorydata.plugin"), r6.getMetrics());
    L20:
        if (r6.getUrl().startsWith("https:") == false) goto L25;
        if (r2.startsWith("http:") == false) goto L25;
        URL r3 = new URL(r2);     // Catch: Throwable -> L35
        f.a(r3.getHost(), r3.getPath(), true, r6.getMetrics());     // Catch: Throwable -> L35
    L25:
        if (r6.isAddCommonParam() == false) goto L32;
        com.bytedance.frameworks.baselib.network.http.a.a r4 = com.bytedance.frameworks.baselib.network.http.a.b.a().b();
        if (r4 != null) goto L29;
    L31:
        r2 = a(r2, r6.getMetrics());
        goto L32
    L29:
        if (r4.a() == false) goto L31;
        r2 = com.bytedance.frameworks.baselib.network.http.a.b.a().a(r6, r2, r6.getMetrics());
    L32:
        Request.Builder r5 = r6.newBuilder();
        r5.url(r2);
        return r5.build();
    L18:
        r2 = f.a(r0, r6.getMetrics());
        goto L20
    L5:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L9;
        throw new IOException("You must not send request on main thread");
    }

    public void a(Request r1, SsResponse r2) {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r3) {
        Interceptor.Chain r4 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r3, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Request r0 = a(r4.request());
        if (RealInterceptorChain.isProceedWithoutHookEnabled() == false) goto L5;
        SsResponse r5 = r4.proceedWithoutHook(r0);
    L6:
        a(r0, r5);
        return r5;
    L5:
        r5 = r4.proceed(r0);
        goto L6
    }
}
