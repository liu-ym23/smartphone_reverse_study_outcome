package com.google.common.collect;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedRandomAccessList<E> extends Synchronized$SynchronizedList<E> implements RandomAccess {
    private static final long serialVersionUID = 0;

    public Synchronized$SynchronizedRandomAccessList(List<E> r5, Object r10) {
        super(r5, r10);
    }
}
