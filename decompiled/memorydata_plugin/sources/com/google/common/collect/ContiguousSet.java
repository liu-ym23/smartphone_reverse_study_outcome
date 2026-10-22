package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final DiscreteDomain<C> domain;

    ContiguousSet(DiscreteDomain<C> r2) {
        super(Ordering.natural());
        this.domain = r2;
    }

    @Deprecated
    public static <E> ImmutableSortedSet.a<E> builder() {
        throw new UnsupportedOperationException();
    }

    public static ContiguousSet<Integer> closed(int r0, int r1) {
        return create(Range.closed(Integer.valueOf(r0), Integer.valueOf(r1)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Long> closed(long r0, long r2) {
        return create(Range.closed(Long.valueOf(r0), Long.valueOf(r2)), DiscreteDomain.longs());
    }

    public static ContiguousSet<Integer> closedOpen(int r0, int r1) {
        return create(Range.closedOpen(Integer.valueOf(r0), Integer.valueOf(r1)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Long> closedOpen(long r0, long r2) {
        return create(Range.closedOpen(Long.valueOf(r0), Long.valueOf(r2)), DiscreteDomain.longs());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> r5, DiscreteDomain<C> r6) {
        com.google.common.base.n.a(r5);
        com.google.common.base.n.a(r6);
    L21:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L4:
        if (r5.hasLowerBound() == true) goto L6;
        Range<C> r0 = r5.intersection(Range.atLeast(r6.minValue()));     // Catch: NoSuchElementException -> L21
    L8:
        if (r5.hasUpperBound() == true) goto L10;
        r0 = r0.intersection(Range.atMost(r6.maxValue()));     // Catch: NoSuchElementException -> L21
    L10:
        boolean r2 = true;
        if (r0.isEmpty() == false) goto L14;
    L17:
        if (r2 == false) goto L20;
        return new EmptyContiguousSet(r6);
    L20:
        return new RegularContiguousSet(r0, r6);
    L14:
        if (Range.compareOrThrow((Comparable) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r5.lowerBound.leastValueAbove(r6)), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r5.upperBound.greatestValueBelow(r6)), Comparable.class, "com.obric.memorydata.plugin")) > 0) goto L17;
        r2 = false;
        goto L17
    L6:
        r0 = r5;
        goto L8
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    public ContiguousSet<C> headSet(C r3) {
        return headSetImpl((Comparable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin")), Comparable.class, "com.obric.memorydata.plugin"), false);
    }

    public ContiguousSet<C> headSet(C r3, boolean r4) {
        return headSetImpl((Comparable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin")), Comparable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* synthetic */ ImmutableSortedSet headSet(Object r3) {
        return headSet((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* synthetic */ ImmutableSortedSet headSet(Object r3, boolean r4) {
        return headSet((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* synthetic */ NavigableSet headSet(Object r3, boolean r4) {
        return headSet((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* synthetic */ SortedSet headSet(Object r3) {
        return headSet((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    abstract ContiguousSet<C> headSetImpl(C r1, boolean r2);

    @Override // com.google.common.collect.ImmutableSortedSet
    /* synthetic */ ImmutableSortedSet headSetImpl(Object r3, boolean r4) {
        return headSetImpl((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4);
    }

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> r1);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType r1, BoundType r2);

    public ContiguousSet<C> subSet(C r4, C r5) {
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r6);
        com.google.common.base.n.a(r7);
        if (comparator().compare(r6, r7) > 0) goto L5;
        boolean r0 = true;
    L6:
        com.google.common.base.n.a(r0);
        return subSetImpl(r6, true, r7, false);
    L5:
        r0 = false;
        goto L6
    }

    public ContiguousSet<C> subSet(C r3, boolean r4, C r5, boolean r6) {
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r7);
        com.google.common.base.n.a(r8);
        if (comparator().compare(r7, r8) > 0) goto L5;
        boolean r0 = true;
    L6:
        com.google.common.base.n.a(r0);
        return subSetImpl(r7, r4, r8, r6);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* synthetic */ ImmutableSortedSet subSet(Object r3, Object r4) {
        return subSet((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* synthetic */ ImmutableSortedSet subSet(Object r3, boolean r4, Object r5, boolean r6) {
        return subSet((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4, (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"), r6);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* synthetic */ NavigableSet subSet(Object r3, boolean r4, Object r5, boolean r6) {
        return subSet((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4, (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"), r6);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* synthetic */ SortedSet subSet(Object r3, Object r4) {
        return subSet((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
    }

    abstract ContiguousSet<C> subSetImpl(C r1, boolean r2, C r3, boolean r4);

    @Override // com.google.common.collect.ImmutableSortedSet
    /* synthetic */ ImmutableSortedSet subSetImpl(Object r3, boolean r4, Object r5, boolean r6) {
        return subSetImpl((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4, (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"), r6);
    }

    public ContiguousSet<C> tailSet(C r3) {
        return tailSetImpl((Comparable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin")), Comparable.class, "com.obric.memorydata.plugin"), true);
    }

    public ContiguousSet<C> tailSet(C r3, boolean r4) {
        return tailSetImpl((Comparable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin")), Comparable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* synthetic */ ImmutableSortedSet tailSet(Object r3) {
        return tailSet((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* synthetic */ ImmutableSortedSet tailSet(Object r3, boolean r4) {
        return tailSet((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* synthetic */ NavigableSet tailSet(Object r3, boolean r4) {
        return tailSet((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* synthetic */ SortedSet tailSet(Object r3) {
        return tailSet((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    abstract ContiguousSet<C> tailSetImpl(C r1, boolean r2);

    @Override // com.google.common.collect.ImmutableSortedSet
    /* synthetic */ ImmutableSortedSet tailSetImpl(Object r3, boolean r4) {
        return tailSetImpl((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }
}
