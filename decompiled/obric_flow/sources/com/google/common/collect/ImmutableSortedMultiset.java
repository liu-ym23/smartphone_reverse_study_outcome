package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements v8 {
    public static final /* synthetic */ int e = 0;
    transient ImmutableSortedMultiset<E> descendingMultiset;

    public static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        public SerializedForm(v8 r5) {
            this.comparator = r5.comparator();
            int r10 = r5.entrySet().size();
            this.elements = (E[]) new Object[r10];
            this.counts = new int[r10];
            Iterator<E> r11 = r5.entrySet().iterator();
            int r12 = 0;
        L4:
            if (r11.hasNext() == false) goto L6;
            y7 r13 = (y7) r11.next();
            ((E[]) this.elements)[r12] = r13.getElement();
            this.counts[r12] = r13.getCount();
            r12 = r12 + 1;
            goto L4
        }

        public Object readResolve() {
            int r5 = this.elements.length;
            Comparator<? super E> r10 = this.comparator;
            r10.getClass();
            TreeMultiset r11 = TreeMultiset.create(r10);
            int r12 = 0;
        L3:
            if (r12 >= r5) goto L6;
            E r13 = this.elements[r12];
            int r14 = this.counts[r12];
            r13.getClass();
            r11.add(r13, r14);
            r12 = r12 + 1;
            goto L3
        L6:
            return ImmutableSortedMultiset.copyOfSorted(r11);
        }
    }

    public ImmutableSortedMultiset() {
    }

    public static ImmutableSortedMultiset c(Comparator r12, Collection r13) {
        if (r13.isEmpty() == true) goto L5;
        Object[] r5 = new Object[r13.size()];
        long[] r10 = new long[r13.size() + 1];
        Iterator<E> r11 = r13.iterator();
        int r14 = 0;
        int r15 = 0;
        boolean r16 = false;
    L8:
        if (r11.hasNext() == false) goto L17;
        y7 r17 = (y7) r11.next();
        Object r18 = r17.getElement();
        r18.getClass();
        int r19 = r15 + 1;
        if (r5.length >= r19) goto L13;
        r5 = Arrays.copyOf(r5, p7.B(r5.length, r19));
    L12:
        r16 = false;
    L15:
        int r20 = r15 + 1;
        r5[r15] = r18;
        int r21 = r14 + 1;
        r10[r21] = r10[r14] + ((long) r17.getCount());
        r14 = r21;
        r15 = r20;
        goto L8
    L13:
        if (r16 == false) goto L15;
        r5 = Arrays.copyOf(r5, r5.length);
        goto L12
    L17:
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(ImmutableList.asImmutableList(r5, r15), r12), r10, 0, r13.size());
    L5:
        return emptyMultiset(r12);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] r5) {
        return copyOf(g8.natural(), Arrays.asList(r5));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(v8 r5) {
        return c(r5.comparator(), p7.U(r5.entrySet()));
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> r5) {
        if (g8.natural().equals(r5) == false) goto L7;
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    L7:
        return new RegularImmutableSortedMultiset(r5);
    }

    public static <E extends Comparable<?>> w4 naturalOrder() {
        return new w4(g8.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E> w4 orderedBy(Comparator<E> r5) {
        return new w4(r5);
    }

    public static <E extends Comparable<?>> w4 reverseOrder() {
        return new w4(g8.natural().reverse());
    }

    public static <E> Collector<E, ?, ImmutableSortedMultiset<E>> toImmutableSortedMultiset(Comparator<? super E> r5) {
        return toImmutableSortedMultiset(r5, Function.identity(), new g4(1));
    }

    @Override // com.google.common.collect.v8, com.google.common.collect.t8
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public abstract /* synthetic */ int count(Object r5);

    public /* bridge */ /* synthetic */ v8 descendingMultiset() {
        return descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ ImmutableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public abstract ImmutableSortedSet<E> elementSet();

    public abstract /* synthetic */ y7 firstEntry();

    @Override // com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    @Override // com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer r5) {
        super.forEachEntry(r5);
    }

    public abstract ImmutableSortedMultiset<E> headMultiset(E r5, BoundType r10);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ v8 headMultiset(Object r5, BoundType r10) {
        return headMultiset(r5, r10);
    }

    public abstract /* synthetic */ y7 lastEntry();

    @Override // com.google.common.collect.v8
    @Deprecated
    public final y7 pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.v8
    @Deprecated
    public final y7 pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.v8
    public /* bridge */ /* synthetic */ v8 subMultiset(Object r5, BoundType r10, Object r11, BoundType r12) {
        return subMultiset(r5, r10, r11, r12);
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E r5, BoundType r10);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ v8 tailMultiset(Object r5, BoundType r10) {
        return tailMultiset(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> r5) {
        return copyOf(g8.natural(), r5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r5) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(r5), new long[]{0, 1}, 0, 1);
    }

    public static <T, E> Collector<T, ?, ImmutableSortedMultiset<E>> toImmutableSortedMultiset(Comparator<? super E> r5, Function<? super T, ? extends E> r10, ToIntFunction<? super T> r11) {
        r5.getClass();
        r10.getClass();
        r11.getClass();
        return Collector.of(new k1(r5, 3), new j1(1, r10, r11), new e1(12), new z8(r5, 2), new Collector.Characteristics[0]);
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> r5 = this.descendingMultiset;
        if (r5 == null) goto L5;
    L9:
        return r5;
    L5:
        if (isEmpty() == false) goto L7;
        r5 = emptyMultiset(g8.from(comparator()).reverse());
    L8:
        this.descendingMultiset = r5;
        goto L9
    L7:
        r5 = new DescendingImmutableSortedMultiset(this);
        goto L8
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return elementSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.v8
    public ImmutableSortedMultiset<E> subMultiset(E r5, BoundType r10, E r11, BoundType r12) {
        if (comparator().compare(r5, r11) > 0) goto L5;
        boolean r13 = true;
    L6:
        com.google.common.base.b0.k(r13, "Expected lowerBound <= upperBound but %s > %s", r5, r11);
        return tailMultiset(r5, r10).headMultiset(r11, r12);
    L5:
        r13 = false;
        goto L6
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> r5) {
        return copyOf(g8.natural(), r5);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r5, Comparable r10) {
        return copyOf(g8.natural(), Arrays.asList(new Comparable[]{r5, r10}));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> r5, Iterable<? extends E> r10) {
        if ((r10 instanceof ImmutableSortedMultiset) == false) goto L11;
        ImmutableSortedMultiset<E> r11 = (ImmutableSortedMultiset) r10;
        if (r5.equals(r11.comparator()) == false) goto L11;
        if (r11.isPartialView() == true) goto L9;
        return r11;
    L9:
        return c(r5, r11.entrySet().asList());
    L11:
        ArrayList r12 = p7.U(r10);
        r5.getClass();
        TreeMultiset r13 = TreeMultiset.create(r5);
        p7.i(r13, r12);
        return c(r5, r13.entrySet());
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r5, Comparable r10, Comparable r11) {
        return copyOf(g8.natural(), Arrays.asList(new Comparable[]{r5, r10, r11}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r5, Comparable r10, Comparable r11, Comparable r12) {
        return copyOf(g8.natural(), Arrays.asList(new Comparable[]{r5, r10, r11, r12}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r5, Comparable r10, Comparable r11, Comparable r12, Comparable r13) {
        return copyOf(g8.natural(), Arrays.asList(new Comparable[]{r5, r10, r11, r12, r13}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r5, Comparable r10, Comparable r11, Comparable r12, Comparable r13, Comparable r14, Comparable... r15) {
        int r16 = r15.length + 6;
        p7.q(r16, "initialArraySize");
        ArrayList r17 = new ArrayList(r16);
        Collections.addAll(r17, new Comparable[]{r5, r10, r11, r12, r13, r14});
        Collections.addAll(r17, r15);
        return copyOf(g8.natural(), r17);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> r5, Iterator<? extends E> r10) {
        r5.getClass();
        w4 r11 = new w4(r5);
        r11.h(r10);
        return copyOfSorted((v8) r11.f9023b);
    }
}
