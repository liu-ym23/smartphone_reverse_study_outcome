package com.bytedance.android.live.revenue.service.base;

import dy0.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class RevenueExposedWrapperBase<T extends c> {
    private final Lazy realInstance$delegate;

    public final T getRealInstance() {
        return (T) this.realInstance$delegate.getValue();
    }

    public RevenueExposedWrapperBase(final Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "instanceClass");
        this.realInstance$delegate = LazyKt.lazy(new RevenueExposedWrapperBase$realInstance$2(r2));
    }
}
