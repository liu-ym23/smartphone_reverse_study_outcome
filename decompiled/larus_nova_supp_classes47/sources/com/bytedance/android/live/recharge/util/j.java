package com.bytedance.android.live.recharge.util;

import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.order.k;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public static final void a(com.bytedance.android.live.recharge.panel.context.c r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$retryLastRechargeAfterSecurityConfirm");
        if (((Number) g.j.getValue(null, g.a[8])).intValue() == 1) goto L5;
        r7.c().onNext(Unit.INSTANCE);
        return;
    L5:
        Order r0 = r7.f().getValue();
        if (r0 == null) goto L11;
        k r1 = r0.a();
        k r2 = k.a(r1, new com.bytedance.android.live.recharge.order.j(MapsKt.toMutableMap(r1.a)), null, r1.j, null, 7678);
        com.bytedance.android.live.recharge.order.j r3 = r2.a;
        String r4 = r7.e();
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r3.put("two_factory_auth_verify_info", r4);
        Order r5 = com.bytedance.android.live.recharge.order.a.C0066a.a(com.bytedance.android.live.recharge.core.f.i(RechargeServices.b()), r0.o(), r2);
        r7.f().setValue(r5);
        return;
    L11:
        r7.c().onNext(Unit.INSTANCE);
    }
}
