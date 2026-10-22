package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.livesdk.utils.e4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements com.bytedance.android.scope.o, com.bytedance.android.live.recharge.order.e {
    public c() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void c(com.bytedance.android.live.recharge.order.f.b r4) {
        Intrinsics.checkNotNullParameter(r4, "order");
        if (((Boolean) com.bytedance.android.live.recharge.utils.j.u.getValue(null, com.bytedance.android.live.recharge.utils.j.a[18])).booleanValue() == true) goto L5;
        return;
    L5:
        if (vh6.c.b(dr2.j.class).isFinancialVisible() == true) goto L9;
        r4.b(this);
        return;
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void a(Order r4, com.bytedance.android.live.recharge.order.f.b.a r5) {
        Intrinsics.checkNotNullParameter(r4, "order");
        Intrinsics.checkNotNullParameter(r5, "handle");
        r5.d(new PayService.b(s1.C(2131917191, new Object[]{e4.a()})));
    }
}
