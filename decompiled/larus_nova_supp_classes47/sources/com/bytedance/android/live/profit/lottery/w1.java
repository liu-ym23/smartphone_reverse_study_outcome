package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w1<T> implements Predicate {
    public static final w1 a = null;

    static {
        a = new w1();
    }

    public w1() {
    }

    public final boolean test(Object r5) {
        Long r6 = (Long) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        if (r6.longValue() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
