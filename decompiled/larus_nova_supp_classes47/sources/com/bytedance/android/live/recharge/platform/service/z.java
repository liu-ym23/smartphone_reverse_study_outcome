package com.bytedance.android.live.recharge.platform.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z implements com.bytedance.android.scope.o, dy0.c {
    public final com.bytedance.android.live.recharge.core.a a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public static ww0.a a() {
        return (ww0.a) ((dy0.d) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), ww0.a.class));
    }

    public final com.bytedance.android.live.recharge.core.b f() {
        com.bytedance.android.live.recharge.core.g r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_rechargeScope");
    L5:
        return r0;
    }

    public final com.bytedance.android.live.wallet.pay.iap.a g() {
        com.bytedance.android.live.recharge.core.b r0 = f();
        Object r1 = com.bytedance.android.scope.m.e.d(r0, com.bytedance.android.live.wallet.pay.iap.a.class);
        Intrinsics.checkNotNull(r1);
        return (com.bytedance.android.live.recharge.core.c) r1;
    }

    public z(com.bytedance.android.live.recharge.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "rechargeLoaderService");
        this.a = r2;
    }
}
