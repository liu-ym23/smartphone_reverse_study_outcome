package com.obric.assistant.network.restrict;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.obric.assistant.network.api.INetworkInterceptorService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hm9.s;
import hm9.x;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e implements x {
    public x a;
    public final AtomicBoolean b;
    public final String c;

    public e() {
        this.b = new AtomicBoolean(true);
        this.c = "ObricAssistantStateHandler";
        INetworkInterceptorService r0 = (INetworkInterceptorService) ServiceManager.get().getService(INetworkInterceptorService.class);
        if (r0 == null) goto L6;
        r0.b(new d(this));
        return;
    }

    public final SsResponse<?> a(Interceptor.Chain r3, s r4) {
        if (this.b.get() == true) goto L10;
        if (r4 == null) goto L6;
        s.b(r4, "BackgroundNetworkInterceptor#ObricAssistantStateHandler", "[ObricAssistantStateHandler]NO need continue process current is active state}");
    L6:
        if (r4 == null) goto L8;
        r4.c();
    L8:
        if (r3 != null) goto L17;
    L15:
        return null;
    L17:
        return r3.proceed(r3.request());
    L10:
        if (r4 == null) goto L12;
        s.b(r4, "BackgroundNetworkInterceptor#ObricAssistantStateHandler", "[ObricAssistantStateHandler]Need continue process");
    L12:
        x r0 = this.a;
        if (r0 == null) goto L15;
        return r0.a(r3, r4);
    }
}
