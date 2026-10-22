package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.PayService;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements PayService.a {
    public final WeakReference<Order.a> a;

    public h(com.bytedance.android.live.recharge.order.f.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
        this.a = new WeakReference(r2);
        r2.b(PayService.PayProgress.START);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.PayService.a
    public final void a(PayService.b r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        Order.a r0 = this.a.get();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r4.a;
        if (r1 != 1) goto L8;
        r0.a(r4);
        return;
    L8:
        if (r1 != 2) goto L10;
        r0.cancel(r4);
        return;
    L10:
        if (r1 == 6) goto L12;
        r0.d(r4);
        return;
    L12:
        r0.c(r4);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.PayService.a
    public final void b(PayService.PayProgress r2) {
        Intrinsics.checkNotNullParameter(r2, "progress");
        Order.a r0 = this.a.get();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b(r2);
    }
}
