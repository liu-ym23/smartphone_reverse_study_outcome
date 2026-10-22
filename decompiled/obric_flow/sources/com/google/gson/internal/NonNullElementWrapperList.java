package com.google.gson.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public class NonNullElementWrapperList<E> extends AbstractList<E> implements RandomAccess {
    private final ArrayList<E> delegate;

    public NonNullElementWrapperList(ArrayList<E> r5) {
        Objects.requireNonNull(r5);
        this.delegate = r5;
    }

    private E nonNull(E r5) {
        if (r5 == null) goto L5;
        return r5;
    L5:
        throw new NullPointerException("Element must be non-null");
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r5, E r10) {
        this.delegate.add(r5, nonNull(r10));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r5) {
        return this.delegate.contains(r5);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r5) {
        return this.delegate.equals(r5);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r5) {
        return this.delegate.get(r5);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r5) {
        return this.delegate.indexOf(r5);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r5) {
        return this.delegate.lastIndexOf(r5);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r5) {
        return this.delegate.remove(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r5) {
        return this.delegate.removeAll(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r5) {
        return this.delegate.retainAll(r5);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r5, E r10) {
        return this.delegate.set(r5, nonNull(r10));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.delegate.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r5) {
        return this.delegate.remove(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r5) {
        return (T[]) this.delegate.toArray(r5);
    }
}
