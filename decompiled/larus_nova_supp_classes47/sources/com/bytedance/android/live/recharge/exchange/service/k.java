package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements com.bytedance.android.scope.o, com.bytedance.android.live.recharge.platform.service.o {
    public final n a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public k(n r2) {
        Intrinsics.checkNotNullParameter(r2, "exchangeService");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void c(com.bytedance.android.live.recharge.order.f.b r2) {
        Intrinsics.checkNotNullParameter(r2, "order");
        r2.b(this);
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void a(Order r8, com.bytedance.android.live.recharge.order.f.b.a r9) {
        Intrinsics.checkNotNullParameter(r8, "order");
        Intrinsics.checkNotNullParameter(r9, "handle");
        com.bytedance.android.live.recharge.deal.f r2 = r8.o();
        int r1 = com.bytedance.android.live.recharge.utils.e.a;
        IExchangeService.ExchangeApiType r3 = com.bytedance.android.live.recharge.utils.e.b(r8.o());
        if (com.bytedance.android.live.incentive.exchange.i.a() == false) goto L5;
        String r4 = "v1";
    L6:
        IExchangeService.b r0 = new IExchangeService.b(r2, r3, r4, true, 14);
        this.a.t1(r0, r8.a(), new com.bytedance.android.live.recharge.utils.g(r9));
        return;
    L5:
        r4 = "";
        goto L6
    }
}
