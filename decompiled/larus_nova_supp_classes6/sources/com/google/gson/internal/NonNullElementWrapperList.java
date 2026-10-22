package com.google.gson.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class NonNullElementWrapperList<E> extends AbstractList<E> implements RandomAccess {
    private final ArrayList<E> delegate;

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.delegate.toArray();
    }

    public NonNullElementWrapperList(ArrayList<E> r2) {
        Objects.requireNonNull(r2);
        this.delegate = r2;
    }

    private E nonNull(E r2) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new NullPointerException("Element must be non-null");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r2) {
        return this.delegate.contains(r2);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r2) {
        return this.delegate.equals(r2);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r2) {
        return this.delegate.get(r2);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r2) {
        return this.delegate.indexOf(r2);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r2) {
        return this.delegate.lastIndexOf(r2);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r2) {
        return this.delegate.remove(r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r2) {
        return this.delegate.removeAll(r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r2) {
        return this.delegate.retainAll(r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r2) {
        return (T[]) this.delegate.toArray(r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r2) {
        return this.delegate.remove(r2);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r2, E r3) {
        this.delegate.add(r2, nonNull(r3));
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r2, E r3) {
        return this.delegate.set(r2, nonNull(r3));
    }
}
