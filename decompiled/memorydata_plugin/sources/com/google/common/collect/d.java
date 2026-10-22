package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class d<E> extends AbstractCollection<E> implements an<E> {
    private transient Set<E> elementSet;
    private transient Set<an.a<E>> entrySet;

    class a extends Multisets.b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f4676a;

        a(d r1) {
            this.f4676a = r1;
        }

        @Override // com.google.common.collect.Multisets.b
        an<E> a() {
            return this.f4676a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.f4676a.elementIterator();
        }
    }

    class b extends Multisets.c<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f4677a;

        b(d r1) {
            this.f4677a = r1;
        }

        @Override // com.google.common.collect.Multisets.c
        an<E> a() {
            return this.f4677a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<an.a<E>> iterator() {
            return this.f4677a.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4677a.distinctElements();
        }
    }

    d() {
    }

    public int add(E r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public final boolean add(E r2) {
        add(r2, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<? extends E> r3) {
        return Multisets.a(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public boolean contains(Object r1) {
        if (count(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    Set<E> createElementSet() {
        return new a(this);
    }

    Set<an.a<E>> createEntrySet() {
        return new b(this);
    }

    abstract int distinctElements();

    abstract Iterator<E> elementIterator();

    public Set<E> elementSet() {
        Set<E> r0 = this.elementSet;
        if (r0 != null) goto L6;
        Set<E> r1 = createElementSet();
        this.elementSet = r1;
        return r1;
    L6:
        return r0;
    }

    abstract Iterator<an.a<E>> entryIterator();

    public Set<an.a<E>> entrySet() {
        Set<an.a<E>> r0 = this.entrySet;
        if (r0 != null) goto L6;
        Set<an.a<E>> r1 = createEntrySet();
        this.entrySet = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // java.util.Collection, com.google.common.collect.an
    public final boolean equals(Object r1) {
        return Multisets.a(this, r1);
    }

    @Override // java.util.Collection, com.google.common.collect.an
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    public int remove(Object r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public final boolean remove(Object r2) {
        if (remove(r2, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> r3) {
        return Multisets.b(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<?> r3) {
        return Multisets.c(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    public int setCount(E r1, int r2) {
        return Multisets.a(this, r1, r2);
    }

    public boolean setCount(E r1, int r2, int r3) {
        return Multisets.a(this, r1, r2, r3);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }
}
