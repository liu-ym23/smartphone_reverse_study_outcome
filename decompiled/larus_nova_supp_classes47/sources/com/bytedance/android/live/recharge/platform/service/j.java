package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.recharge.order.Order;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements com.bytedance.android.scope.o, com.bytedance.android.live.recharge.order.e {
    public final PayService a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public j(PayService r2) {
        Intrinsics.checkNotNullParameter(r2, "payService");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void c(com.bytedance.android.live.recharge.order.f.b r2) {
        Intrinsics.checkNotNullParameter(r2, "order");
        r2.b(this);
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void a(Order r4, com.bytedance.android.live.recharge.order.f.b.a r5) {
        Intrinsics.checkNotNullParameter(r4, "order");
        Intrinsics.checkNotNullParameter(r5, "handle");
        this.a.a(r4.o(), r4.a(), new com.bytedance.android.live.recharge.utils.h(r5), 0);
    }
}
