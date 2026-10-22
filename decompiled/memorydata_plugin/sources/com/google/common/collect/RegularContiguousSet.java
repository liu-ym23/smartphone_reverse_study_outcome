package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    private static final long serialVersionUID = 0;
    private final Range<C> range;

    private static final class SerializedForm<C extends Comparable> implements Serializable {
        final DiscreteDomain<C> domain;
        final Range<C> range;

        private SerializedForm(Range<C> r1, DiscreteDomain<C> r2) {
            this.range = r1;
            this.domain = r2;
        }

        /* synthetic */ SerializedForm(Range r1, DiscreteDomain r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private Object readResolve() {
            return new RegularContiguousSet(this.range, this.domain);
        }
    }

    RegularContiguousSet(Range<C> r1, DiscreteDomain<C> r2) {
        super(r2);
        this.range = r1;
    }

    static /* synthetic */ boolean access$000(Comparable r2, Comparable r3) {
        return equalsOrThrow((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    private static boolean equalsOrThrow(Comparable<?> r2, Comparable<?> r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (Range.compareOrThrow(r4, r5) != 0) goto L7;
        return true;
    }

    private ContiguousSet<C> intersectionInCurrentDomain(Range<C> r2) {
        if (this.range.isConnected(r2) == false) goto L6;
        return ContiguousSet.create(this.range.intersection(r2), this.domain);
    L6:
        return new EmptyContiguousSet(this.domain);
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r4) {
        if (r4 != null) goto L8;
        return false;
    L8:
        return this.range.contains((Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
    L7:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r3) {
        return q.a(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList
    ImmutableList<C> createAsList() {
        if (this.domain.supportsFastOffset == false) goto L7;
        return new AnonymousClass3(this);
    L7:
        return super.createAsList();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public bj<C> descendingIterator() {
        final Comparable r1 = last();
        return new AnonymousClass2(this, r1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator descendingIterator() {
        return descendingIterator();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RegularContiguousSet.class) == false) goto L17;
        RegularContiguousSet r0 = (RegularContiguousSet) ZeusTransformUtils.preCheckCast(r5, RegularContiguousSet.class, "com.obric.memorydata.plugin");
        if (this.domain.equals(r0.domain) == false) goto L17;
        if (first().equals(r0.first()) == true) goto L12;
    L14:
        return false;
    L12:
        if (last().equals(r0.last()) == false) goto L14;
        return true;
    L17:
        return super.equals(r5);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C first() {
        return (C) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.range.lowerBound.leastValueAbove(this.domain)), Comparable.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ Object first() {
        return first();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.a(this);
    }

    @Override // com.google.common.collect.ContiguousSet
    ContiguousSet<C> headSetImpl(C r3, boolean r4) {
        return intersectionInCurrentDomain(Range.upTo((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), BoundType.forBoolean(r4)));
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* synthetic */ ImmutableSortedSet headSetImpl(Object r3, boolean r4) {
        return headSetImpl((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    int indexOf(Object r4) {
        if (contains(r4) == true) goto L7;
        return -1;
    L7:
        return (int) this.domain.distance(first(), (Comparable) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4), Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> r6) {
        com.google.common.base.n.a(r6);
        com.google.common.base.n.a(this.domain.equals(r6.domain));
        if (r6.isEmpty() == false) goto L5;
        return r6;
    L5:
        Comparable r0 = (Comparable) ZeusTransformUtils.preCheckCast(Ordering.natural().max(first(), (Comparable) ZeusTransformUtils.preCheckCast(r6.first(), Comparable.class, "com.obric.memorydata.plugin")), Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.preCheckCast(Ordering.natural().min(last(), (Comparable) ZeusTransformUtils.preCheckCast(r6.last(), Comparable.class, "com.obric.memorydata.plugin")), Comparable.class, "com.obric.memorydata.plugin");
        if (r0.compareTo(r7) > 0) goto L9;
        return ContiguousSet.create(Range.closed(r0, r7), this.domain);
    L9:
        return new EmptyContiguousSet(this.domain);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public bj<C> iterator() {
        final Comparable r1 = first();
        return new AnonymousClass1(this, r1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C last() {
        return (C) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.range.upperBound.greatestValueBelow(this.domain)), Comparable.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ Object last() {
        return last();
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        return range(BoundType.CLOSED, BoundType.CLOSED);
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType r3, BoundType r4) {
        return Range.create(this.range.lowerBound.withLowerBoundType(r3, this.domain), this.range.upperBound.withUpperBoundType(r4, this.domain));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long r0 = this.domain.distance(first(), last());
        if (r0 < 2147483647L) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return ((int) r0) + 1;
    }

    @Override // com.google.common.collect.ContiguousSet
    ContiguousSet<C> subSetImpl(C r3, boolean r4, C r5, boolean r6) {
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        if (r7.compareTo(r8) != 0) goto L9;
        if (r4 == true) goto L9;
        if (r6 == true) goto L9;
        return new EmptyContiguousSet(this.domain);
    L9:
        return intersectionInCurrentDomain(Range.range(r7, BoundType.forBoolean(r4), r8, BoundType.forBoolean(r6)));
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* synthetic */ ImmutableSortedSet subSetImpl(Object r3, boolean r4, Object r5, boolean r6) {
        return subSetImpl((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4, (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"), r6);
    }

    @Override // com.google.common.collect.ContiguousSet
    ContiguousSet<C> tailSetImpl(C r3, boolean r4) {
        return intersectionInCurrentDomain(Range.downTo((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), BoundType.forBoolean(r4)));
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* synthetic */ ImmutableSortedSet tailSetImpl(Object r3, boolean r4) {
        return tailSetImpl((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.range, this.domain, null);
    }
}
