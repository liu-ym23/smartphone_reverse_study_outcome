package com.obric.oui.bouncelayout;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class BounceTranslationDelegate {
    public final Function0<Float> a;
    public final Function0<BounceEdgeEffect[]> b;
    public e c;
    public final Function1<Float, Unit> d;

    public final void a() {
        BounceEdgeEffect[] r0 = (BounceEdgeEffect[]) this.b.invoke();
        int r2 = 0;
        if (this.c != null) goto L11;
        int r1 = r0.length;
    L5:
        if (r2 >= r1) goto L10;
        BounceEdgeEffect r3 = r0[r2];
        r2 = r2 + 1;
        if (r3 == null) goto L5;
        r3.g = null;
        goto L5
    L10:
        return;
    L11:
        int r4 = r0.length;
    L12:
        if (r2 >= r4) goto L17;
        BounceEdgeEffect r5 = r0[r2];
        r2 = r2 + 1;
        if (r5 == null) goto L12;
        r5.g = this.d;
        goto L12
    }

    public BounceTranslationDelegate(Function0<Float> r2, Function0<BounceEdgeEffect[]> r3) {
        Intrinsics.checkNotNullParameter(r2, "getTotalTranslation");
        Intrinsics.checkNotNullParameter(r3, "effectsProvider");
        this.a = r2;
        this.b = r3;
        this.d = new BounceTranslationDelegate$callback$1(this);
    }
}
