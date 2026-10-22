package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list;

    public VolatileSizeArrayList() {
        this.list = new ArrayList();
    }

    public VolatileSizeArrayList(int r2) {
        this.list = new ArrayList(r2);
    }

    @Override // java.util.List
    public void add(int r2, T r3) {
        this.list.add(r2, r3);
        lazySet(this.list.size());
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T r2) {
        boolean r3 = this.list.add(r2);
        lazySet(this.list.size());
        return r3;
    }

    @Override // java.util.List
    public boolean addAll(int r3, Collection<? extends T> r4) {
        Collection<? extends T> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        boolean r6 = this.list.addAll(r3, r5);
        lazySet(this.list.size());
        return r6;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> r3) {
        Collection<? extends T> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        boolean r5 = this.list.addAll(r4);
        lazySet(this.list.size());
        return r5;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.list.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r1) {
        return this.list.contains(r1);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return this.list.containsAll(r4);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r3) {
        boolean r1 = ZeusTransformUtils.instanceOf(r3, VolatileSizeArrayList.class);
        ArrayList<T> r2 = this.list;
        if (r1 == false) goto L7;
        return r2.equals(((VolatileSizeArrayList) ZeusTransformUtils.preCheckCast(r3, VolatileSizeArrayList.class, "com.obric.memorydata.plugin")).list);
    L7:
        return r2.equals(r3);
    }

    @Override // java.util.List
    public T get(int r1) {
        return this.list.get(r1);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object r1) {
        return this.list.indexOf(r1);
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
    public int lastIndexOf(Object r1) {
        return this.list.lastIndexOf(r1);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int r1) {
        return this.list.listIterator(r1);
    }

    @Override // java.util.List
    public T remove(int r2) {
        T r3 = this.list.remove(r2);
        lazySet(this.list.size());
        return r3;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r2) {
        boolean r3 = this.list.remove(r2);
        lazySet(this.list.size());
        return r3;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        boolean r5 = this.list.removeAll(r4);
        lazySet(this.list.size());
        return r5;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        boolean r5 = this.list.retainAll(r4);
        lazySet(this.list.size());
        return r5;
    }

    @Override // java.util.List
    public T set(int r1, T r2) {
        return this.list.set(r1, r2);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List<T> subList(int r1, int r2) {
        return this.list.subList(r1, r2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] r1) {
        return (E[]) this.list.toArray(r1);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.list.toString();
    }
}
