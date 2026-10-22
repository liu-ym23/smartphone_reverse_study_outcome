package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v1<T> implements Predicate {
    public static final v1 a = null;

    static {
        a = new v1();
    }

    public v1() {
    }

    public final boolean test(Object r2) {
        LotteryState r3 = (LotteryState) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return l.b(r3);
    }
}
