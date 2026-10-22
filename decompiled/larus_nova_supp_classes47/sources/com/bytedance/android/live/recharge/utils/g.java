package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements IExchangeService.a {
    public final Order.a a;

    public g(com.bytedance.android.live.recharge.order.f.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
        this.a = r2;
        r2.b(IExchangeService.ExchangeProgress.START);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.IExchangeService.a
    public final void a(IExchangeService.c r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.b(IExchangeService.ExchangeProgress.SUCCESS);
        this.a.a(r3);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.IExchangeService.a
    public final void onFailure(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        this.a.b(IExchangeService.ExchangeProgress.FAIL);
        this.a.d(r3);
    }
}
