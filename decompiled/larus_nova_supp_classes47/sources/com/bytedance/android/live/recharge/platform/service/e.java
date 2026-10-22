package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.recharge.utils.LastCustomRechargeRecoder;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T, R> implements Function {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r2) {
        com.bytedance.android.live.recharge.deal.i r3 = (com.bytedance.android.live.recharge.deal.i) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        boolean r0 = LastCustomRechargeRecoder.a;
        return LastCustomRechargeRecoder.c(r3, com.bytedance.android.live.recharge.panel.g.a());
    }
}
