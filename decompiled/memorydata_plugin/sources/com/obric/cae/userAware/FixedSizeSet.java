package com.obric.cae.userAware;

import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
class FixedSizeSet<E> extends LinkedHashSet<E> {
    private final int maxSize;

    public FixedSizeSet(int r1) {
        super(r1);
        this.maxSize = r1;
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E r3) {
        if (contains(r3) == false) goto L6;
        remove(r3);
    L11:
        return super.add(r3);
    L6:
        if (size() < this.maxSize) goto L11;
        Iterator<E> r0 = iterator();
        if (r0.hasNext() == false) goto L11;
        r0.next();
        r0.remove();
        goto L11
    }
}
