package com.bytedance.android.live.recharge.order;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ Order a;
    public final /* synthetic */ RechargePanelOrderService.f b;

    public o(Order r1, RechargePanelOrderService.f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Order.State r3 = (Order.State) r2;
        Order r4 = this.a;
        RechargePanelOrderService.a(this.b.a, r4);
    }
}
