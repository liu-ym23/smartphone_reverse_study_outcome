package com.squareup.wire.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
final class MutableOnWriteList<T> extends AbstractList<T> implements RandomAccess, Serializable {
    private final List<T> immutableList;
    List<T> mutableList;

    public MutableOnWriteList(List<T> r5) {
        this.immutableList = r5;
        this.mutableList = r5;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.mutableList);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r5, T r10) {
        if (this.mutableList != this.immutableList) goto L5;
        this.mutableList = new ArrayList(this.immutableList);
    L5:
        this.mutableList.add(r5, r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r5) {
        return this.mutableList.get(r5);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int r5) {
        if (this.mutableList != this.immutableList) goto L6;
        this.mutableList = new ArrayList(this.immutableList);
    L6:
        return this.mutableList.remove(r5);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int r5, T r10) {
        if (this.mutableList != this.immutableList) goto L6;
        this.mutableList = new ArrayList(this.immutableList);
    L6:
        return this.mutableList.set(r5, r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mutableList.size();
    }
}
