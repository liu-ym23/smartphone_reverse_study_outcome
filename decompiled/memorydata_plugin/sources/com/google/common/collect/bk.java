package com.google.common.collect;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class bk<E> extends bj<E> implements ListIterator<E> {
    public bk() {
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void add(E r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(E r1) {
        throw new UnsupportedOperationException();
    }
}
