package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m<T1, T2> implements BiFunction<T1, T2, Pair<? extends T1, ? extends T2>> {
    public m() {
    }

    public final Object apply(Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "t1");
        Intrinsics.checkNotNullParameter(r3, "t2");
        return TuplesKt.to(r2, r3);
    }
}
