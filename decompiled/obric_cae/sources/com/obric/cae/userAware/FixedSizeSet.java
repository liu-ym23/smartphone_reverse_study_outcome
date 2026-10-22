package com.obric.cae.userAware;

import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
class FixedSizeSet<E> extends LinkedHashSet<E> {
    private final int maxSize;

    public FixedSizeSet(int r8) {
        super(r8);
        this.maxSize = r8;
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E r8) {
        if (contains(r8) == false) goto L6;
        remove(r8);
    L11:
        return super.add(r8);
    L6:
        if (size() < this.maxSize) goto L11;
        Iterator<E> r10 = iterator();
        if (r10.hasNext() == false) goto L11;
        r10.next();
        r10.remove();
        goto L11
    }
}
