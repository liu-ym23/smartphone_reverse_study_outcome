package com.google.common.collect;

import java.lang.Comparable;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final n2 domain;

    public ContiguousSet(n2 r5) {
        super(g8.natural());
        this.domain = r5;
    }

    @Deprecated
    public static <E> y4 builder() {
        throw new UnsupportedOperationException();
    }

    public static ContiguousSet<Integer> closed(int r5, int r10) {
        return create(Range.closed(Integer.valueOf(r5), Integer.valueOf(r10)), n2.integers());
    }

    public static ContiguousSet<Integer> closedOpen(int r5, int r10) {
        return create(Range.closedOpen(Integer.valueOf(r5), Integer.valueOf(r10)), n2.integers());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> r5, n2 r10) {
        r5.getClass();
        r10.getClass();
    L6:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L4:
        if (r5.hasLowerBound() == true) goto L8;
        Range<C> r11 = r5.intersection(Range.atLeast(r10.minValue()));     // Catch: NoSuchElementException -> L6
    L10:
        if (r5.hasUpperBound() == true) goto L13;
        r11 = r11.intersection(Range.atMost(r10.maxValue()));     // Catch: NoSuchElementException -> L6
    L13:
        if (r11.isEmpty() == true) goto L24;
        Comparable r12 = r5.lowerBound.leastValueAbove(r10);
        Objects.requireNonNull(r12);
        Comparable r13 = r5.upperBound.greatestValueBelow(r10);
        Objects.requireNonNull(r13);
        if (Range.compareOrThrow(r12, r13) > 0) goto L24;
        return new RegularContiguousSet(r11, r10);
    L24:
        return new EmptyContiguousSet(r10);
    L8:
        r11 = r5;
        goto L10
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSet(Object r5) {
        return headSet((Comparable) r5);
    }

    public abstract ContiguousSet<C> headSetImpl(C r5, boolean r10);

    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object r5, boolean r10) {
        return headSetImpl((Comparable) r5, r10);
    }

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> r5);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType r5, BoundType r10);

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSet(Object r5, Object r10) {
        return subSet((Comparable) r5, (Comparable) r10);
    }

    public abstract ContiguousSet<C> subSetImpl(C r5, boolean r10, C r11, boolean r12);

    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object r5, boolean r10, Object r11, boolean r12) {
        return subSetImpl((Comparable) r5, r10, (Comparable) r11, r12);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSet(Object r5) {
        return tailSet((Comparable) r5);
    }

    public abstract ContiguousSet<C> tailSetImpl(C r5, boolean r10);

    @Override // com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object r5, boolean r10) {
        return tailSetImpl((Comparable) r5, r10);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }

    public static ContiguousSet<Long> closed(long r5, long r10) {
        return create(Range.closed(Long.valueOf(r5), Long.valueOf(r10)), n2.longs());
    }

    public static ContiguousSet<Long> closedOpen(long r5, long r10) {
        return create(Range.closedOpen(Long.valueOf(r5), Long.valueOf(r10)), n2.longs());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSet(Object r5, boolean r10) {
        return headSet((Comparable) r5, r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSet(Object r5, boolean r10, Object r11, boolean r12) {
        return subSet((Comparable) r5, r10, (Comparable) r11, r12);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSet(Object r5, boolean r10) {
        return tailSet((Comparable) r5, r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object r5, boolean r10) {
        return headSet((Comparable) r5, r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object r5, boolean r10, Object r11, boolean r12) {
        return subSet((Comparable) r5, r10, (Comparable) r11, r12);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object r5, boolean r10) {
        return tailSet((Comparable) r5, r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object r5) {
        return headSet((Comparable) r5);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet subSet(Object r5, Object r10) {
        return subSet((Comparable) r5, (Comparable) r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object r5) {
        return tailSet((Comparable) r5);
    }

    public ContiguousSet<C> headSet(C r5) {
        r5.getClass();
        return headSetImpl(r5, false);
    }

    public ContiguousSet<C> subSet(C r5, C r10) {
        r5.getClass();
        r10.getClass();
        if (comparator().compare(r5, r10) > 0) goto L5;
        boolean r11 = true;
    L6:
        com.google.common.base.b0.i(r11);
        return subSetImpl(r5, true, r10, false);
    L5:
        r11 = false;
        goto L6
    }

    public ContiguousSet<C> tailSet(C r5) {
        r5.getClass();
        return tailSetImpl(r5, true);
    }

    public ContiguousSet<C> headSet(C r5, boolean r10) {
        r5.getClass();
        return headSetImpl(r5, r10);
    }

    public ContiguousSet<C> tailSet(C r5, boolean r10) {
        r5.getClass();
        return tailSetImpl(r5, r10);
    }

    public ContiguousSet<C> subSet(C r5, boolean r10, C r11, boolean r12) {
        r5.getClass();
        r11.getClass();
        if (comparator().compare(r5, r11) > 0) goto L5;
        boolean r13 = true;
    L6:
        com.google.common.base.b0.i(r13);
        return subSetImpl(r5, r10, r11, r12);
    L5:
        r13 = false;
        goto L6
    }
}
