package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends u implements Set {
    public final /* synthetic */ AbstractMapBasedMultimap f;

    public y(AbstractMapBasedMultimap r5, Object r10, Set r11) {
        this.f = r5;
        super(r5, r10, r11, null);
    }

    @Override // com.google.common.collect.u, java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection r5) {
        if (r5.isEmpty() == false) goto L6;
        return false;
    L6:
        int r10 = size();
        boolean r11 = p7.i0((Set) this.f9173b, r5);
        if (r11 == false) goto L9;
        int r12 = this.f9173b.size();
        AbstractMapBasedMultimap.access$212(this.f, r12 - r10);
        d();
    L9:
        return r11;
    }
}
