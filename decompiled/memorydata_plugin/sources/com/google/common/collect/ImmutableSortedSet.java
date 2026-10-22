package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements ax<E>, NavigableSet<E> {
    static final int SPLITERATOR_CHARACTERISTICS = 1301;
    final transient Comparator<? super E> comparator;
    transient ImmutableSortedSet<E> descendingSet;

    private static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> r3, Object[] r4) {
            this.comparator = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
            this.elements = r4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Object readResolve() {
            return new a(this.comparator).c(this.elements).d();
        }
    }

    public static final class a<E> extends ImmutableSet.a<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Comparator<? super E> f4477b;
        private E[] c;
        private int d;

        public a(Comparator<? super E> r3) {
            Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
            super(true);
            this.f4477b = (Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r4), Comparator.class, "com.obric.memorydata.plugin");
            this.c = (E[]) new Object[4];
            this.d = 0;
        }

        private void e() {
            int r0 = this.d;
            if (r0 != 0) goto L5;
            return;
        L5:
            Arrays.sort(this.c, 0, r0, this.f4477b);
            int r1 = 1;
            int r2 = 1;
        L6:
            int r3 = this.d;
            if (r1 >= r3) goto L15;
            Comparator<? super E> r4 = this.f4477b;
            E[] r5 = this.c;
            int r6 = r4.compare(r5[r2 - 1], r5[r1]);
            if (r6 >= 0) goto L11;
            E[] r7 = this.c;
            r7[r2] = r7[r1];
            r2 = r2 + 1;
        L12:
            r1 = r1 + 1;
            goto L6
        L11:
            if (r6 <= 0) goto L12;
            throw new AssertionError("Comparator " + this.f4477b + " compare method violates its contract");
        L15:
            Arrays.fill(this.c, r2, r3, null);
            this.d = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.a, com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Object r1) {
            return c(r1);
        }

        @Override // com.google.common.collect.ImmutableSet.a, com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Iterator r3) {
            return c((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.a, com.google.common.collect.ImmutableCollection.a
        public /* synthetic */ ImmutableCollection.a a(Object[] r1) {
            return c(r1);
        }

        @Override // com.google.common.collect.ImmutableSet.a
        /* synthetic */ ImmutableSet.a a(ImmutableSet.a r1) {
            return b(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.a
        public /* synthetic */ ImmutableSet.a b(Object r1) {
            return c(r1);
        }

        @Override // com.google.common.collect.ImmutableSet.a
        public /* synthetic */ ImmutableSet.a b(Iterator r3) {
            return c((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.a
        public /* synthetic */ ImmutableSet.a b(Object[] r1) {
            return c(r1);
        }

        a<E> b(ImmutableSet.a<E> r3) {
            a();
            a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
            int r0 = 0;
        L4:
            if (r0 >= r4.d) goto L6;
            c(r4.c[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.a
        void b() {
            E[] r0 = this.c;
            this.c = (E[]) Arrays.copyOf(r0, r0.length);
        }

        @Override // com.google.common.collect.ImmutableSet.a
        public /* synthetic */ ImmutableSet c() {
            return d();
        }

        public a<E> c(E r4) {
            com.google.common.base.n.a(r4);
            a();
            if (this.d != this.c.length) goto L7;
            e();
            int r0 = this.d;
            int r1 = ImmutableCollection.a.a(r0, r0 + 1);
            E[] r2 = this.c;
            if (r1 <= r2.length) goto L7;
            this.c = (E[]) Arrays.copyOf(r2, r1);
        L7:
            E[] r3 = this.c;
            int r5 = this.d;
            this.d = r5 + 1;
            r3[r5] = r4;
            return this;
        }

        public a<E> c(Iterator<? extends E> r3) {
            super.b((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public a<E> c(E... r4) {
            ap.a(r4);
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            c(r4[r1]);
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }

        public ImmutableSortedSet<E> d() {
            e();
            if (this.d == 0) goto L5;
            this.f4470a = true;
            return new RegularImmutableSortedSet(ImmutableList.asImmutableList(this.c, this.d), this.f4477b);
        L5:
            return ImmutableSortedSet.emptySet(this.f4477b);
        }
    }

    ImmutableSortedSet(Comparator<? super E> r3) {
        this.comparator = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
    }

    static <E> ImmutableSortedSet<E> construct(Comparator<? super E> r4, int r5, E... r6) {
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        if (r5 == 0) goto L5;
        ap.b(r6, r5);
        Arrays.sort(r6, 0, r5, r7);
        int r0 = 1;
        int r1 = 1;
    L7:
        if (r0 >= r5) goto L12;
        E r2 = r6[r0];
        if (r7.compare(r2, r6[r1 - 1]) == 0) goto L11;
        r6[r1] = r2;
        r1 = r1 + 1;
    L11:
        r0 = r0 + 1;
        goto L7
    L12:
        Arrays.fill(r6, r1, r5, null);
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(r6, r1), r7);
    L5:
        return emptySet(r7);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        return copyOf(Ordering.natural(), r3);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        return copyOf(Ordering.natural(), r3);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r3, Iterable<? extends E> r4) {
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        if (ay.a(r5, r6) == true) goto L5;
    L9:
        Object[] r7 = aj.c(r6);
        return construct(r5, r7.length, r7);
    L5:
        if (ZeusTransformUtils.instanceOf(r6, ImmutableSortedSet.class) == false) goto L9;
        ImmutableSortedSet<E> r0 = (ImmutableSortedSet) ZeusTransformUtils.preCheckCast(r6, ImmutableSortedSet.class, "com.obric.memorydata.plugin");
        if (r0.isPartialView() == true) goto L9;
        return r0;
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r2, Collection<? extends E> r3) {
        return copyOf((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r2, Iterator<? extends E> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Iterator<? extends E> r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        return new a(r4).c(r5).d();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> r2) {
        Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        return copyOf(Ordering.natural(), r3);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] r4) {
        return construct(Ordering.natural(), r4.length, (Comparable[]) ZeusTransformUtils.preCheckCast(r4.clone(), Comparable[].class, "com.obric.memorydata.plugin"));
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> r2) {
        SortedSet r3 = (SortedSet) ZeusTransformUtils.wrapperContextForParams(r2, SortedSet.class, "com.obric.memorydata.plugin");
        Comparator r0 = ay.a(r3);
        ImmutableList r4 = ImmutableList.copyOf(r3);
        if (r4.isEmpty() == false) goto L7;
        return emptySet(r0);
    L7:
        return new RegularImmutableSortedSet(r4, r0);
    }

    static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> r2) {
        Comparator r3 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        if (Ordering.natural().equals(r3) == false) goto L7;
        return (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    L7:
        return new RegularImmutableSortedSet(ImmutableList.of(), r3);
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a(Ordering.natural());
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r2) {
        return new RegularImmutableSortedSet(ImmutableList.of((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin")), Ordering.natural());
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r4, Comparable r5) {
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        return construct(Ordering.natural(), 2, new Comparable[]{r6, r7});
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r4, Comparable r5, Comparable r6) {
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r9 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin");
        return construct(Ordering.natural(), 3, new Comparable[]{r7, r8, r9});
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r4, Comparable r5, Comparable r6, Comparable r7) {
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r9 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r10 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r11 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r7, Comparable.class, "com.obric.memorydata.plugin");
        return construct(Ordering.natural(), 4, new Comparable[]{r8, r9, r10, r11});
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r4, Comparable r5, Comparable r6, Comparable r7, Comparable r8) {
        Comparable r9 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r10 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r11 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r12 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r7, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r13 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r8, Comparable.class, "com.obric.memorydata.plugin");
        return construct(Ordering.natural(), 5, new Comparable[]{r9, r10, r11, r12, r13});
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r4, Comparable r5, Comparable r6, Comparable r7, Comparable r8, Comparable r9, Comparable... r10) {
        Comparable r11 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r12 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r13 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r14 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r7, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r15 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r8, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r16 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r9, Comparable.class, "com.obric.memorydata.plugin");
        int r0 = r10.length + 6;
        Comparable[] r2 = new Comparable[r0];
        r2[0] = r11;
        r2[1] = r12;
        r2[2] = r13;
        r2[3] = r14;
        r2[4] = r15;
        r2[5] = r16;
        System.arraycopy(r10, 0, r2, 6, r10.length);
        return construct(Ordering.natural(), r0, r2);
    }

    public static <E> a<E> orderedBy(Comparator<E> r2) {
        return new a((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a(Collections.reverseOrder());
    }

    public static <E> Collector<E, ?, ImmutableSortedSet<E>> toImmutableSortedSet(Comparator<? super E> r2) {
        return n.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"));
    }

    static int unsafeCompare(Comparator<?> r2, Object r3, Object r4) {
        return ((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin")).compare(r3, r4);
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableCollection
    public /* bridge */ /* synthetic */ ImmutableList asList() {
        return super.asList();
    }

    public E ceiling(E r2) {
        return (E) aj.a(tailSet(r2, true), null);
    }

    @Override // com.google.common.collect.ax
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    abstract ImmutableSortedSet<E> createDescendingSet();

    public abstract bj<E> descendingIterator();

    public /* bridge */ /* synthetic */ Iterator descendingIterator() {
        return descendingIterator();
    }

    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> r0 = this.descendingSet;
        if (r0 != null) goto L6;
        ImmutableSortedSet<E> r1 = createDescendingSet();
        this.descendingSet = r1;
        r1.descendingSet = this;
        return r1;
    L6:
        return r0;
    }

    public /* bridge */ /* synthetic */ NavigableSet descendingSet() {
        return descendingSet();
    }

    public E first() {
        return iterator().next();
    }

    public E floor(E r2) {
        return (E) Iterators.b(headSet(r2, true).descendingIterator(), null);
    }

    public ImmutableSortedSet<E> headSet(E r2) {
        return headSet(r2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableSortedSet<E> headSet(E r1, boolean r2) {
        return headSetImpl(com.google.common.base.n.a(r1), r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object r1, boolean r2) {
        return headSet(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet headSet(Object r1) {
        return headSet(r1);
    }

    abstract ImmutableSortedSet<E> headSetImpl(E r1, boolean r2);

    public E higher(E r2) {
        return (E) aj.a(tailSet(r2, false), null);
    }

    abstract int indexOf(Object r1);

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract bj<E> iterator();

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public E last() {
        return descendingIterator().next();
    }

    public E lower(E r2) {
        return (E) Iterators.b(headSet(r2, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        final long r1 = size();
        final int r3 = 1365;
        return new AnonymousClass1(this, r1, r3);
    }

    public ImmutableSortedSet<E> subSet(E r3, E r4) {
        return subSet(r3, true, r4, false);
    }

    public ImmutableSortedSet<E> subSet(E r2, boolean r3, E r4, boolean r5) {
        com.google.common.base.n.a(r2);
        com.google.common.base.n.a(r4);
        if (this.comparator.compare(r2, r4) > 0) goto L5;
        boolean r0 = true;
    L6:
        com.google.common.base.n.a(r0);
        return subSetImpl(r2, r3, r4, r5);
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object r1, boolean r2, Object r3, boolean r4) {
        return subSet(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet subSet(Object r1, Object r2) {
        return subSet(r1, r2);
    }

    abstract ImmutableSortedSet<E> subSetImpl(E r1, boolean r2, E r3, boolean r4);

    public ImmutableSortedSet<E> tailSet(E r2) {
        return tailSet(r2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableSortedSet<E> tailSet(E r1, boolean r2) {
        return tailSetImpl(com.google.common.base.n.a(r1), r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object r1, boolean r2) {
        return tailSet(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object r1) {
        return tailSet(r1);
    }

    abstract ImmutableSortedSet<E> tailSetImpl(E r1, boolean r2);

    int unsafeCompare(Object r1, Object r2) {
        return unsafeCompare(this.comparator, r1, r2);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }
}
