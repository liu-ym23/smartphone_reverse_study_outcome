package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
class Lists$OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
    private static final long serialVersionUID = 0;
    final E first;
    final E[] rest;

    public Lists$OnePlusArrayList(E r5, E[] r10) {
        this.first = r5;
        r10.getClass();
        this.rest = r10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r5) {
        com.google.common.base.b0.l(r5, size());
        if (r5 != 0) goto L6;
        return this.first;
    L6:
        return this.rest[r5 - 1];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return dn.a.U(((long) this.rest.length) + ((long) 1));
    }
}
