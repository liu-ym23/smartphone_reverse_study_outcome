package com.bytedance.android.live.recharge.exchange.service;

import android.content.DialogInterface;
import com.bytedance.android.live.recharge.order.Order;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ b.c a;
    public final /* synthetic */ Order.a b;
    public final /* synthetic */ Ref.BooleanRef c;

    public d(b.c r1, com.bytedance.android.live.recharge.order.f.b.a r2, Ref.BooleanRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        b.c.b(this.a, this.b.getOrder().g, false, this.c.element);
        r4.dismiss();
        this.b.cancel(null);
    }
}
