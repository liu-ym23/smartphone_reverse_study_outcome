package com.bytedance.android.live.recharge.order;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Predicate {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final boolean test(Object r2) {
        Order.State r3 = (Order.State) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.isClosed();
    }
}
