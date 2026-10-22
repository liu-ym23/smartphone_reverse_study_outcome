package com.google.common.collect;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public final class p9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f9123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashBasedTable f9124b;

    public p9() {
        this.f9123a = new ArrayList();
        this.f9124b = HashBasedTable.create();
    }

    public final void a(Object r5, Object r10, Object r11, BinaryOperator r12) {
        HashBasedTable r13 = this.f9124b;
        q9 r14 = (q9) r13.get(r5, r10);
        if (r14 != null) goto L5;
        q9 r15 = new q9(r5, r10, r11);
        this.f9123a.add(r15);
        r13.put(r5, r10, r15);
        return;
    L5:
        com.google.common.base.b0.n(r11, "value");
        Object r16 = r12.apply(r14.f9138c, r11);
        com.google.common.base.b0.n(r16, "mergeFunction.apply");
        r14.f9138c = r16;
    }
}
