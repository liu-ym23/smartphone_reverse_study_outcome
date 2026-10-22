package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
abstract class t<E> extends ab<E> implements az<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Comparator<? super E> f4700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient NavigableSet<E> f4701b;
    private transient Set<an.a<E>> c;

    class a extends Multisets.c<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f4702a;

        a(t r1) {
            this.f4702a = r1;
        }

        @Override // com.google.common.collect.Multisets.c
        an<E> a() {
            return this.f4702a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<an.a<E>> iterator() {
            return this.f4702a.b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4702a.a().entrySet().size();
        }
    }

    t() {
    }

    abstract az<E> a();

    abstract Iterator<an.a<E>> b();

    Set<an.a<E>> c() {
        return new a(this);
    }

    @Override // com.google.common.collect.az, com.google.common.collect.ax
    public Comparator<? super E> comparator() {
        Comparator<? super E> r0 = this.f4700a;
        if (r0 != null) goto L6;
        Ordering r1 = Ordering.from(a().comparator()).reverse();
        this.f4700a = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ab, com.google.common.collect.v, com.google.common.collect.ac
    public an<E> delegate() {
        return a();
    }

    @Override // com.google.common.collect.ab, com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ab, com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.az
    public az<E> descendingMultiset() {
        return a();
    }

    @Override // com.google.common.collect.ab, com.google.common.collect.an
    public NavigableSet<E> elementSet() {
        NavigableSet<E> r0 = this.f4701b;
        if (r0 != null) goto L6;
        bb.b r1 = new bb.b(this);
        this.f4701b = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ab, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ab, com.google.common.collect.an
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ab, com.google.common.collect.an
    public Set<an.a<E>> entrySet() {
        Set<an.a<E>> r0 = this.c;
        if (r0 != null) goto L6;
        Set<an.a<E>> r1 = c();
        this.c = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.az
    public an.a<E> firstEntry() {
        return a().lastEntry();
    }

    @Override // com.google.common.collect.az
    public az<E> headMultiset(E r1, BoundType r2) {
        return a().tailMultiset(r1, r2).descendingMultiset();
    }

    @Override // com.google.common.collect.v, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return Multisets.b(this);
    }

    @Override // com.google.common.collect.az
    public an.a<E> lastEntry() {
        return a().firstEntry();
    }

    @Override // com.google.common.collect.az
    public an.a<E> pollFirstEntry() {
        return a().pollLastEntry();
    }

    @Override // com.google.common.collect.az
    public an.a<E> pollLastEntry() {
        return a().pollFirstEntry();
    }

    @Override // com.google.common.collect.az
    public az<E> subMultiset(E r1, BoundType r2, E r3, BoundType r4) {
        return a().subMultiset(r3, r4, r1, r2).descendingMultiset();
    }

    @Override // com.google.common.collect.az
    public az<E> tailMultiset(E r1, BoundType r2) {
        return a().headMultiset(r1, r2).descendingMultiset();
    }

    @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] r1) {
        return (T[]) standardToArray(r1);
    }

    @Override // com.google.common.collect.ac
    public String toString() {
        return entrySet().toString();
    }
}
