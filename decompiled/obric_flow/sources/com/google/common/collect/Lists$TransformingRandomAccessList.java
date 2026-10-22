package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
class Lists$TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;
    final List<F> fromList;
    final com.google.common.base.q function;

    public Lists$TransformingRandomAccessList(List<F> r5, com.google.common.base.q r10) {
        r5.getClass();
        this.fromList = r5;
        r10.getClass();
        this.function = r10;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.fromList.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r5) {
        return (T) this.function.apply(this.fromList.get(r5));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.fromList.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<T> listIterator(int r5) {
        return new z5(this, this.fromList.listIterator(r5), 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int r5) {
        return (T) this.function.apply(this.fromList.remove(r5));
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super T> r5) {
        r5.getClass();
        return this.fromList.removeIf(new y5(this, r5, 0));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.fromList.size();
    }
}
