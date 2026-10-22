package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list;

    public VolatileSizeArrayList() {
        this.list = new ArrayList();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T r5) {
        boolean r10 = this.list.add(r5);
        lazySet(this.list.size());
        return r10;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> r5) {
        boolean r10 = this.list.addAll(r5);
        lazySet(this.list.size());
        return r10;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.list.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r5) {
        return this.list.contains(r5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r5) {
        return this.list.containsAll(r5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r5) {
        if ((r5 instanceof VolatileSizeArrayList) == false) goto L7;
        return this.list.equals(((VolatileSizeArrayList) r5).list);
    L7:
        return this.list.equals(r5);
    }

    @Override // java.util.List
    public T get(int r5) {
        return this.list.get(r5);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object r5) {
        return this.list.indexOf(r5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        if (get() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object r5) {
        return this.list.lastIndexOf(r5);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r5) {
        boolean r10 = this.list.remove(r5);
        lazySet(this.list.size());
        return r10;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r5) {
        boolean r10 = this.list.removeAll(r5);
        lazySet(this.list.size());
        return r10;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r5) {
        boolean r10 = this.list.retainAll(r5);
        lazySet(this.list.size());
        return r10;
    }

    @Override // java.util.List
    public T set(int r5, T r10) {
        return this.list.set(r5, r10);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List<T> subList(int r5, int r10) {
        return this.list.subList(r5, r10);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.list.toString();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int r5) {
        return this.list.listIterator(r5);
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] r5) {
        return (E[]) this.list.toArray(r5);
    }

    public VolatileSizeArrayList(int r5) {
        this.list = new ArrayList(r5);
    }

    @Override // java.util.List
    public void add(int r5, T r10) {
        this.list.add(r5, r10);
        lazySet(this.list.size());
    }

    @Override // java.util.List
    public boolean addAll(int r5, Collection<? extends T> r10) {
        boolean r11 = this.list.addAll(r5, r10);
        lazySet(this.list.size());
        return r11;
    }

    @Override // java.util.List
    public T remove(int r5) {
        T r10 = this.list.remove(r5);
        lazySet(this.list.size());
        return r10;
    }
}
