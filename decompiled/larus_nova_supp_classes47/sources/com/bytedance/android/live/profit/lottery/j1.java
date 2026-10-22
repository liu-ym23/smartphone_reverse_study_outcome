package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j1<T> implements Predicate {
    public static final j1 a = null;

    static {
        a = new j1();
    }

    public j1() {
    }

    public final boolean test(Object r2) {
        k3 r3 = (k3) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.a instanceof LotteryState.f;
    }
}
