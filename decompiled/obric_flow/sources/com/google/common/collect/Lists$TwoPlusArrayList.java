package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
class Lists$TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
    private static final long serialVersionUID = 0;
    final E first;
    final E[] rest;
    final E second;

    public Lists$TwoPlusArrayList(E r5, E r10, E[] r11) {
        this.first = r5;
        this.second = r10;
        r11.getClass();
        this.rest = r11;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r5) {
        if (r5 == 0) goto L10;
        if (r5 == 1) goto L8;
        com.google.common.base.b0.l(r5, size());
        return this.rest[r5 - 2];
    L8:
        return this.second;
    L10:
        return this.first;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return dn.a.U(((long) this.rest.length) + ((long) 2));
    }
}
