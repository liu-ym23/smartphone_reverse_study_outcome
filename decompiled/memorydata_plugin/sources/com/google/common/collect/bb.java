package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
final class bb {

    static class a<E> extends Multisets.b<E> implements SortedSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final az<E> f4666a;

        a(az<E> r3) {
            this.f4666a = (az) ZeusTransformUtils.wrapperContextForParams(r3, az.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Multisets.b
        /* synthetic */ an a() {
            return b();
        }

        final az<E> b() {
            return this.f4666a;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) bb.a(b().firstEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E r2) {
            return b().headMultiset(r2, BoundType.OPEN).elementSet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Multisets.a(b().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public E last() {
            return (E) bb.a(b().lastEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E r3, E r4) {
            return b().subMultiset(r3, BoundType.CLOSED, r4, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E r2) {
            return b().tailMultiset(r2, BoundType.CLOSED).elementSet();
        }
    }

    static class b<E> extends a<E> implements NavigableSet<E> {
        b(az<E> r3) {
            super((az) ZeusTransformUtils.wrapperContextForParams(r3, az.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.NavigableSet
        public E ceiling(E r2) {
            return (E) bb.b(b().tailMultiset(r2, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new b(b().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public E floor(E r2) {
            return (E) bb.b(b().headMultiset(r2, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E r2, boolean r3) {
            return new b(b().headMultiset(r2, BoundType.forBoolean(r3)));
        }

        @Override // java.util.NavigableSet
        public E higher(E r2) {
            return (E) bb.b(b().tailMultiset(r2, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public E lower(E r2) {
            return (E) bb.b(b().headMultiset(r2, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) bb.b(b().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) bb.b(b().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E r2, boolean r3, E r4, boolean r5) {
            return new b(b().subMultiset(r2, BoundType.forBoolean(r3), r4, BoundType.forBoolean(r5)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E r2, boolean r3) {
            return new b(b().tailMultiset(r2, BoundType.forBoolean(r3)));
        }
    }

    static /* synthetic */ Object a(an.a r2) {
        return c((an.a) ZeusTransformUtils.wrapperContextForParams(r2, an.a.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object b(an.a r2) {
        return d((an.a) ZeusTransformUtils.wrapperContextForParams(r2, an.a.class, "com.obric.memorydata.plugin"));
    }

    private static <E> E c(an.a<E> r2) {
        an.a r3 = (an.a) ZeusTransformUtils.wrapperContextForParams(r2, an.a.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        return (E) r3.getElement();
    L7:
        throw new NoSuchElementException();
    }

    private static <E> E d(an.a<E> r2) {
        an.a r3 = (an.a) ZeusTransformUtils.wrapperContextForParams(r2, an.a.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return null;
    L6:
        return (E) r3.getElement();
    }
}
