package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i0<T, R> implements Function {
    public static final i0 a = null;

    static {
        a = new i0();
    }

    public i0() {
    }

    public final Object apply(Object r4) {
        sh6.d r5 = (sh6.b) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        if ((r5 instanceof sh6.d) == false) goto L14;
        sh6.d r6 = r5;
        t r0 = (t) r6.a;
        int r1 = r0.b;
        if (r1 == 1) goto L17;
        if (r1 == 2) goto L17;
        if (r1 == 5) goto L16;
        return v.b.C0034b.a;
    L16:
        return new v.b.c(new i1("", ""), (t) r6.a);
    L17:
        return new v.b.a(r0);
    L14:
        return v.b.C0034b.a;
    }
}
