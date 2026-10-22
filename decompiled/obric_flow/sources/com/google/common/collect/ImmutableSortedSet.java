package com.google.common.collect;

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
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, t8 {
    static final int SPLITERATOR_CHARACTERISTICS = 1301;
    final transient Comparator<? super E> comparator;
    transient ImmutableSortedSet<E> descendingSet;

    public static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> r5, Object[] r10) {
            this.comparator = r5;
            this.elements = r10;
        }

        public Object readResolve() {
            y4 r5 = new y4(this.comparator);
            Object[] r10 = this.elements;
            p7.o(r10.length, r10);
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L6;
            r5.F0(r10[r12]);
            r12 = r12 + 1;
            goto L3
        L6:
            return r5.G0();
        }
    }

    public ImmutableSortedSet(Comparator<? super E> r5) {
        this.comparator = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableSortedSet<E> construct(Comparator<? super E> r5, int r10, E... r11) {
        if (r10 == 0) goto L4;
        p7.o(r10, r11);
        Arrays.sort(r11, 0, r10, r5);
        int r12 = 1;
        int r13 = 1;
    L6:
        if (r12 >= r10) goto L11;
        a1.b r14 = (Object) r11[r12];
        if (r5.compare(r14, (Object) r11[r13 - 1]) == 0) goto L10;
        r11[r13] = r14;
        r13 = r13 + 1;
    L10:
        r12 = r12 + 1;
        goto L6
    L11:
        Arrays.fill(r11, r13, r10, null);
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(r11, r13), r5);
    L4:
        return emptySet(r5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] r5) {
        return construct(g8.natural(), r5.length, (Comparable[]) r5.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> r5) {
        Comparator<? super E> r10 = r5.comparator();
        if (r10 != null) goto L5;
        r10 = g8.natural();
    L5:
        ImmutableList r11 = ImmutableList.copyOf(r5);
        if (r11.isEmpty() == false) goto L10;
        return emptySet(r10);
    L10:
        return new RegularImmutableSortedSet(r11, r10);
    }

    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> r5) {
        if (g8.natural().equals(r5) == false) goto L7;
        return (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    L7:
        return new RegularImmutableSortedSet(ImmutableList.of(), r5);
    }

    public static <E extends Comparable<?>> y4 naturalOrder() {
        return new y4(g8.natural());
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    public static <E> y4 orderedBy(Comparator<E> r5) {
        return new y4(r5);
    }

    private void readObject(ObjectInputStream r5) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> y4 reverseOrder() {
        return new y4(Collections.reverseOrder());
    }

    public static <E> Collector<E, ?, ImmutableSortedSet<E>> toImmutableSortedSet(Comparator<? super E> r5) {
        Collector r10 = n1.f9084a;
        r5.getClass();
        return Collector.of(new k1(r5, 1), new f1(3), new e1(7), new h(13), new Collector.Characteristics[0]);
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableCollection
    public /* bridge */ /* synthetic */ ImmutableList asList() {
        return super.asList();
    }

    public E ceiling(E r5) {
        return (E) p7.G(tailSet(r5, true).iterator());
    }

    @Override // java.util.SortedSet, com.google.common.collect.t8
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public abstract ImmutableSortedSet<E> createDescendingSet();

    public abstract ga descendingIterator();

    public /* bridge */ /* synthetic */ Iterator descendingIterator() {
        return descendingIterator();
    }

    public /* bridge */ /* synthetic */ NavigableSet descendingSet() {
        return descendingSet();
    }

    public E first() {
        return (E) iterator().next();
    }

    public E floor(E r5) {
        return (E) p7.G(headSet(r5, true).descendingIterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object r5, boolean r10) {
        return headSet(r5, r10);
    }

    public abstract ImmutableSortedSet<E> headSetImpl(E r5, boolean r10);

    public E higher(E r5) {
        return (E) p7.G(tailSet(r5, false).iterator());
    }

    public abstract int indexOf(Object r5);

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract ga iterator();

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public E last() {
        return (E) descendingIterator().next();
    }

    public E lower(E r5) {
        return (E) p7.G(headSet(r5, false).descendingIterator());
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
        return new x4(this, size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object r5, boolean r10, Object r11, boolean r12) {
        return subSet(r5, r10, r11, r12);
    }

    public abstract ImmutableSortedSet<E> subSetImpl(E r5, boolean r10, E r11, boolean r12);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object r5, boolean r10) {
        return tailSet(r5, r10);
    }

    public abstract ImmutableSortedSet<E> tailSetImpl(E r5, boolean r10);

    public int unsafeCompare(Object r5, Object r10) {
        return unsafeCompare(this.comparator, r5, r10);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> r5) {
        return copyOf(g8.natural(), r5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r5) {
        return new RegularImmutableSortedSet(ImmutableList.of(r5), g8.natural());
    }

    public static int unsafeCompare(Comparator<?> r5, Object r10, Object r11) {
        return r5.compare(r10, r11);
    }

    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> r5 = this.descendingSet;
        if (r5 != null) goto L6;
        ImmutableSortedSet<E> r10 = createDescendingSet();
        this.descendingSet = r10;
        r10.descendingSet = this;
        return r10;
    L6:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet headSet(Object r5) {
        return headSet(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet subSet(Object r5, Object r10) {
        return subSet(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object r5) {
        return tailSet(r5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r5, Comparable r10) {
        return construct(g8.natural(), 2, new Comparable[]{r5, r10});
    }

    public ImmutableSortedSet<E> headSet(E r5) {
        return headSet(r5, false);
    }

    public ImmutableSortedSet<E> subSet(E r5, E r10) {
        return subSet(r5, true, r10, false);
    }

    public ImmutableSortedSet<E> tailSet(E r5) {
        return tailSet(r5, true);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> r5) {
        return copyOf(g8.natural(), r5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r5, Comparable r10, Comparable r11) {
        return construct(g8.natural(), 3, new Comparable[]{r5, r10, r11});
    }

    public ImmutableSortedSet<E> headSet(E r5, boolean r10) {
        r5.getClass();
        return headSetImpl(r5, r10);
    }

    public ImmutableSortedSet<E> subSet(E r5, boolean r10, E r11, boolean r12) {
        r5.getClass();
        r11.getClass();
        if (this.comparator.compare(r5, r11) > 0) goto L5;
        boolean r13 = true;
    L6:
        com.google.common.base.b0.i(r13);
        return subSetImpl(r5, r10, r11, r12);
    L5:
        r13 = false;
        goto L6
    }

    public ImmutableSortedSet<E> tailSet(E r5, boolean r10) {
        r5.getClass();
        return tailSetImpl(r5, r10);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r5, Comparable r10, Comparable r11, Comparable r12) {
        return construct(g8.natural(), 4, new Comparable[]{r5, r10, r11, r12});
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> r5) {
        return copyOf(g8.natural(), r5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r5, Comparable r10, Comparable r11, Comparable r12, Comparable r13) {
        return construct(g8.natural(), 5, new Comparable[]{r5, r10, r11, r12, r13});
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r5, Comparable r10, Comparable r11, Comparable r12, Comparable r13, Comparable r14, Comparable... r15) {
        int r16 = r15.length + 6;
        Comparable[] r17 = new Comparable[r16];
        r17[0] = r5;
        r17[1] = r10;
        r17[2] = r11;
        r17[3] = r12;
        r17[4] = r13;
        r17[5] = r14;
        System.arraycopy(r15, 0, r17, 6, r15.length);
        return construct(g8.natural(), r16, r17);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r5, Iterator<? extends E> r10) {
        y4 r11 = new y4(r5);
        r11.h(r10);
        return r11.G0();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r5, Collection<? extends E> r10) {
        return copyOf(r5, r10);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r5, Iterable<? extends E> r10) {
        r5.getClass();
        if (p7.I(r5, r10) == false) goto L10;
        if ((r10 instanceof ImmutableSortedSet) == false) goto L10;
        ImmutableSortedSet<E> r11 = (ImmutableSortedSet) r10;
        if (r11.isPartialView() == true) goto L10;
        return r11;
    L10:
        if ((r10 instanceof Collection) == false) goto L12;
        Collection r12 = (Collection) r10;
    L13:
        Object[] r13 = r12.toArray();
        return construct(r5, r13.length, r13);
    L12:
        r12 = p7.V(r10.iterator());
        goto L13
    }
}
