package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0<T> implements Predicate {
    public static final h0 a = null;

    static {
        a = new h0();
    }

    public h0() {
    }

    public final boolean test(Object r2) {
        sh6.b r3 = (sh6.b) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        t r4 = (t) sh6.c.b(r3);
        if (r4 != null) goto L5;
    L8:
        return true;
    L5:
        if (r4.b != 4) goto L8;
        return false;
    }
}
