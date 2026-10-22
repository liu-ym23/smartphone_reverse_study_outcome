package com.bytedance.android.live.recharge.trace;

import com.bytedance.android.live.recharge.order.Order;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ Order a;
    public final /* synthetic */ com.bytedance.android.live.recharge.trace.session.a b;

    public d(Order r1, com.bytedance.android.live.recharge.trace.session.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Order.State r3 = (Order.State) r2;
        Order.State r4 = (Order.State) this.a.getState().b;
        int r5 = c.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        this.b.c(com.bytedance.android.live.recharge.trace.session.d.e);
        return;
    L5:
        if (r5 != 2) goto L7;
        this.b.c(com.bytedance.android.live.recharge.trace.session.d.f);
        return;
    L7:
        if (r5 != 3) goto L15;
        this.b.c(com.bytedance.android.live.recharge.trace.session.d.g);
        return;
    }
}
