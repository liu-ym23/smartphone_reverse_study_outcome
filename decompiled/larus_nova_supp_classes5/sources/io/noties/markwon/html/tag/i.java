package io.noties.markwon.html.tag;

import lsc.t;
import lsc.y;
import tsc.a0;
import tsc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class i extends a0 {
    public abstract Object e(lsc.h r1, t r2, tsc.l r3);

    public i() {
    }

    @Override // tsc.a0
    public final void a(lsc.m r2, v r3, tsc.l r4) {
        if (r4.isBlock() == false) goto L5;
        a0.d(r2, r3, r4.a());
    L5:
        Object r5 = e(r2.B(), r2.r(), r4);
        if (r5 == null) goto L9;
        y.f(r2.builder(), r5, r4.start(), r4.end());
        return;
    }
}
