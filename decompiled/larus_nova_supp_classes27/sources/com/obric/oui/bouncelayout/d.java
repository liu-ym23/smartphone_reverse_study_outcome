package com.obric.oui.bouncelayout;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public final Function0<Integer> a;
    public final Function0<BounceEdgeEffect[]> b;
    public float c;

    public final void a() {
        BounceEdgeEffect[] r0 = (BounceEdgeEffect[]) this.b.invoke();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        BounceEdgeEffect r3 = r0[r2];
        r2 = r2 + 1;
        if (r3 == null) goto L3;
        r3.c = this.c;
        goto L3
    }

    public final void b() {
        int r0 = ((Number) this.a.invoke()).intValue();
        if (r0 <= 0) goto L5;
        this.c = RangesKt.coerceAtLeast(r0, 0.0f);
        a();
        return;
    L5:
        a();
    }

    public d(Function0<Integer> r2, Function0<BounceEdgeEffect[]> r3) {
        Intrinsics.checkNotNullParameter(r2, "sizePxProvider");
        Intrinsics.checkNotNullParameter(r3, "effectsProvider");
        this.a = r2;
        this.b = r3;
    }
}
