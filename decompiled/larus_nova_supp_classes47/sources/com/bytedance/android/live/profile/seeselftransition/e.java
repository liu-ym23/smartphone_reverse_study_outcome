package com.bytedance.android.live.profile.seeselftransition;

import io.reactivex.functions.BiFunction;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T1, T2, R> implements BiFunction {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r2, Object r3) {
        sh6.b r4 = (sh6.b) r2;
        sh6.b r5 = (sh6.b) r3;
        Intrinsics.checkNotNullParameter(r4, "t1");
        Intrinsics.checkNotNullParameter(r5, "t2");
        return TuplesKt.to(sh6.c.b(r4), sh6.c.b(r5));
    }
}
