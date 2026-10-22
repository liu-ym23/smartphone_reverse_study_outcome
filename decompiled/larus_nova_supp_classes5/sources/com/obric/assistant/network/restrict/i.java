package com.obric.assistant.network.restrict;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;
import hm9.s;
import hm9.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i implements x {
    public final boolean a;
    public x b;

    public i(boolean r1) {
        this.a = r1;
    }

    public final SsResponse<?> a(Interceptor.Chain r3, s r4) {
        if (this.a == false) goto L9;
        if (r4 == null) goto L6;
        s.b(r4, "BackgroundNetworkInterceptor#ObricNetworkControlEnableHandler", "[ObricNetworkControlEnableHandler]Need continue process need open control");
    L6:
        x r0 = this.b;
        if (r0 != null) goto L15;
    L13:
        return null;
    L15:
        return r0.a(r3, r4);
    L9:
        if (r4 == null) goto L11;
        s.b(r4, "BackgroundNetworkInterceptor#ObricNetworkControlEnableHandler", "[ObricNetworkControlEnableHandler]No Need continue ,no need open control just process");
    L11:
        if (r3 == null) goto L13;
        return r3.proceed(r3.request());
    }
}
