package com.google.common.collect;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class i2 extends i0 {
    public final /* synthetic */ ConcurrentHashMultiset e;

    public i2(ConcurrentHashMultiset r5) {
        this.e = r5;
        super(r5, 0);
    }

    @Override // com.google.common.collect.i0, com.google.common.collect.g7
    public final z7 c() {
        return this.e;
    }

    @Override // com.google.common.collect.j6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        j0 r10 = (j0) this.d;
        int r5 = r10.distinctElements();
        p7.q(r5, "arraySize");
        ArrayList r11 = new ArrayList(dn.a.U((((long) r5) + 5) + ((long) (r5 / 10))));
        p7.j(r11, r10.entryIterator());
        return r11.toArray();
    }

    @Override // com.google.common.collect.j6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] r10) {
        j0 r11 = (j0) this.d;
        int r5 = r11.distinctElements();
        p7.q(r5, "arraySize");
        ArrayList r12 = new ArrayList(dn.a.U((((long) r5) + 5) + ((long) (r5 / 10))));
        p7.j(r12, r11.entryIterator());
        return r12.toArray(r10);
    }
}
