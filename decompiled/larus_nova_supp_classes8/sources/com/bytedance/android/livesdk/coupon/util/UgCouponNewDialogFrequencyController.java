package com.bytedance.android.livesdk.coupon.util;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class UgCouponNewDialogFrequencyController {
    public final Lazy a;
    public final Lazy b;

    public UgCouponNewDialogFrequencyController(final int r2, final int r3) {
        this.a = LazyKt.lazy(new UgCouponNewDialogFrequencyController$sp$2(r2, r3));
        this.b = LazyKt.lazy(new UgCouponNewDialogFrequencyController$frequencyController$2(this, r2, r3));
    }
}
