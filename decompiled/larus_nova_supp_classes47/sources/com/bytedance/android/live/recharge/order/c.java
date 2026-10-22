package com.bytedance.android.live.recharge.order;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements com.bytedance.android.scope.o {
    public final a a;
    public final com.bytedance.android.live.recharge.platform.service.j b;
    public final com.bytedance.android.live.recharge.platform.service.c c;
    public final com.bytedance.android.live.recharge.platform.service.a d;
    public final com.bytedance.android.live.recharge.platform.service.n e;
    public final com.bytedance.android.live.recharge.platform.service.o f;

    public final void onStop() {
    }

    public final void onStart() {
        a r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "service");
        BusinessType r2 = BusinessType.Generic;
        Intrinsics.checkNotNullParameter(r0, "service");
        Intrinsics.checkNotNullParameter(r2, "businessType");
        com.bytedance.android.live.recharge.platform.service.c r4 = this.c;
        if (r4 == null) goto L5;
        r0.N(r4, r2);
    L5:
        com.bytedance.android.live.recharge.platform.service.a r5 = this.d;
        if (r5 == null) goto L8;
        r0.N(r5, r2);
    L8:
        com.bytedance.android.live.recharge.platform.service.n r6 = this.e;
        if (r6 == null) goto L11;
        r0.N(r6, r2);
    L11:
        com.bytedance.android.live.recharge.platform.service.j r7 = this.b;
        if (r7 == null) goto L14;
        r0.N(r7, r2);
    L14:
        BusinessType r3 = BusinessType.ExchangeOnly;
        Intrinsics.checkNotNullParameter(r0, "service");
        Intrinsics.checkNotNullParameter(r3, "businessType");
        com.bytedance.android.live.recharge.platform.service.o r1 = this.f;
        if (r1 == null) goto L18;
        r0.N(r1, r3);
        return;
    }

    public c(a r2, com.bytedance.android.live.recharge.platform.service.j r3, com.bytedance.android.live.recharge.platform.service.c r4, com.bytedance.android.live.recharge.platform.service.a r5, com.bytedance.android.live.recharge.platform.service.n r6, com.bytedance.android.live.recharge.platform.service.o r7) {
        Intrinsics.checkNotNullParameter(r2, "orderService");
        Intrinsics.checkNotNullParameter(r3, "defaultPayProcessor");
        Intrinsics.checkNotNullParameter(r4, "interceptProcessor");
        Intrinsics.checkNotNullParameter(r5, "bizExtraProcessor");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
