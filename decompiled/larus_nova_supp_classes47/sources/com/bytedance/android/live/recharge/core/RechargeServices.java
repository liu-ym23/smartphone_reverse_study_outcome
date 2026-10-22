package com.bytedance.android.live.recharge.core;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RechargeServices {
    public static final Lazy a = null;

    public static final d b() {
        return (d) a.getValue();
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, RechargeServices$rechargeServices$2.INSTANCE);
    }

    public static final ow0.a a(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$firstChargeService");
        return (ow0.a) r1.f(Reflection.getOrCreateKotlinClass(ow0.a.class));
    }
}
