package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y0<T> implements Predicate {
    public static final y0 a = null;

    static {
        a = new y0();
    }

    public y0() {
    }

    public final boolean test(Object r2) {
        Boolean r3 = (Boolean) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.booleanValue();
    }
}
