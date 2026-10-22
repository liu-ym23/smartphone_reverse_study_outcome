package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    private static final long serialVersionUID = 0;
    private final Range<C> range;

    public static final class SerializedForm<C extends Comparable> implements Serializable {
        final n2 domain;
        final Range<C> range;

        public SerializedForm(Range r5, n2 r10, m8 r11) {
            this.range = r5;
            this.domain = r10;
        }

        private Object readResolve() {
            return new RegularContiguousSet(this.range, this.domain);
        }
    }

    public RegularContiguousSet(Range<C> r5, n2 r10) {
        super(r10);
        this.range = r5;
    }

    public static boolean access$000(Comparable r5, Comparable r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (Range.compareOrThrow(r5, r10) != 0) goto L6;
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        if (r5 != null) goto L8;
        return false;
    L8:
        return this.range.contains((Comparable) r5);
    L7:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r5) {
        return p7.x(this, r5);
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList
    public ImmutableList<C> createAsList() {
        if (this.domain.supportsFastOffset == false) goto L7;
        return new AnonymousClass3(this);
    L7:
        return super.createAsList();
    }

    public final ContiguousSet d(Range r5) {
        if (this.range.isConnected(r5) == false) goto L6;
        return ContiguousSet.create(this.range.intersection(r5), this.domain);
    L6:
        return new EmptyContiguousSet(this.domain);
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
        if ((r5 instanceof RegularContiguousSet) == false) goto L17;
        RegularContiguousSet r10 = (RegularContiguousSet) r5;
        if (this.domain.equals(r10.domain) == false) goto L17;
        if (first().equals(r10.first()) == true) goto L12;
    L14:
        return false;
    L12:
        if (last().equals(r10.last()) == false) goto L14;
        return true;
    L17:
        return super.equals(r5);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ Object first() {
        return first();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return p7.J(this);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object r5, boolean r10) {
        return headSetImpl((Comparable) r5, r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object r5) {
        if (contains(r5) == false) goto L5;
        n2 r10 = this.domain;
        Comparable r11 = first();
        Objects.requireNonNull(r5);
        return (int) r10.distance(r11, (Comparable) r5);
    L5:
        return -1;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> r5) {
        r5.getClass();
        com.google.common.base.b0.i(this.domain.equals(r5.domain));
        if (r5.isEmpty() == false) goto L5;
        return r5;
    L5:
        Comparable r10 = (Comparable) g8.natural().max(first(), r5.first());
        Comparable r11 = (Comparable) g8.natural().min(last(), r5.last());
        if (r10.compareTo(r11) > 0) goto L9;
        return ContiguousSet.create(Range.closed(r10, r11), this.domain);
    L9:
        return new EmptyContiguousSet(this.domain);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ Object last() {
        return last();
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        BoundType r5 = BoundType.CLOSED;
        return range(r5, r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long r5 = this.domain.distance(first(), last());
        if (r5 < 2147483647L) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return ((int) r5) + 1;
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object r5, boolean r10, Object r11, boolean r12) {
        return subSetImpl((Comparable) r5, r10, (Comparable) r11, r12);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object r5, boolean r10) {
        return tailSetImpl((Comparable) r5, r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.range, this.domain, null);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public ga descendingIterator() {
        return new n8(this, last());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C first() {
        Comparable r5 = this.range.lowerBound.leastValueAbove(this.domain);
        Objects.requireNonNull(r5);
        return (C) r5;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> headSetImpl(C r5, boolean r10) {
        return d(Range.upTo(r5, BoundType.forBoolean(r10)));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public ga iterator() {
        return new m8(this, first());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C last() {
        Comparable r5 = this.range.upperBound.greatestValueBelow(this.domain);
        Objects.requireNonNull(r5);
        return (C) r5;
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType r5, BoundType r10) {
        return Range.create(this.range.lowerBound.withLowerBoundType(r5, this.domain), this.range.upperBound.withUpperBoundType(r10, this.domain));
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> subSetImpl(C r5, boolean r10, C r11, boolean r12) {
        if (r5.compareTo(r11) != 0) goto L9;
        if (r10 == true) goto L9;
        if (r12 == true) goto L9;
        return new EmptyContiguousSet(this.domain);
    L9:
        return d(Range.range(r5, BoundType.forBoolean(r10), r11, BoundType.forBoolean(r12)));
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> tailSetImpl(C r5, boolean r10) {
        return d(Range.downTo(r5, BoundType.forBoolean(r10)));
    }
}
