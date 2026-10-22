package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableRangeSet<C extends Comparable> extends m0 implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ImmutableRangeSet f8834c = null;
    public static final ImmutableRangeSet d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ImmutableList f8835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ImmutableRangeSet f8836b;

    public final class AsSet extends ImmutableSortedSet<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient Integer f8837c;
        private final n2 domain;
        final /* synthetic */ ImmutableRangeSet this$0;

        public AsSet(ImmutableRangeSet r5, n2 r10) {
            this.this$0 = r5;
            super(g8.natural());
            this.domain = r10;
        }

        public static /* synthetic */ n2 access$100(AsSet r5) {
            return r5.domain;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            if (r5 != null) goto L8;
            return false;
        L8:
            ImmutableRangeSet r10 = this.this$0;     // Catch: ClassCastException -> L7
            return r10.contains((Comparable) r5);
        L7:
            return false;
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> createDescendingSet() {
            return new DescendingImmutableSortedSet(this);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator descendingIterator() {
            return descendingIterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object r5, boolean r10) {
            return headSetImpl((Comparable) r5, r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object r10) {
            if (contains(r10) == false) goto L14;
            Objects.requireNonNull(r10);
            Comparable r11 = (Comparable) r10;
            ga r5 = ImmutableRangeSet.access$000(this.this$0).iterator();
            long r12 = 0;
        L6:
            if (r5.hasNext() == false) goto L13;
            Range r13 = (Range) r5.next();
            if (r13.contains(r11) == true) goto L10;
            r12 = r12 + ((long) ContiguousSet.create(r13, this.domain).size());
            goto L6
        L10:
            return dn.a.U(r12 + ((long) ContiguousSet.create(r13, this.domain).indexOf(r11)));
        L13:
            throw new AssertionError("impossible");
        L14:
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableRangeSet.access$000(this.this$0).isPartialView();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer r5 = this.f8837c;
            if (r5 != null) goto L11;
            ga r10 = ImmutableRangeSet.access$000(this.this$0).iterator();
            long r11 = 0;
        L6:
            if (r10.hasNext() == false) goto L9;
            r11 = r11 + ((long) ContiguousSet.create((Range) r10.next(), this.domain).size());
            if (r11 < 2147483647L) goto L6;
        L9:
            r5 = Integer.valueOf(dn.a.U(r11));
            this.f8837c = r5;
        L11:
            return r5.intValue();
        }

        public ImmutableSortedSet<C> subSet(Range<C> r5) {
            return this.this$0.subRangeSet(r5).asSet(this.domain);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object r5, boolean r10, Object r11, boolean r12) {
            return subSetImpl((Comparable) r5, r10, (Comparable) r11, r12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object r5, boolean r10) {
            return tailSetImpl((Comparable) r5, r10);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.access$000(this.this$0).toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.access$000(this.this$0), this.domain);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public ga descendingIterator() {
            return new l4(this);
        }

        public ImmutableSortedSet<C> headSetImpl(C r5, boolean r10) {
            return subSet(Range.upTo(r5, BoundType.forBoolean(r10)));
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public ga iterator() {
            return new k4(this);
        }

        public ImmutableSortedSet<C> subSetImpl(C r5, boolean r10, C r11, boolean r12) {
            if (r10 == true) goto L9;
            if (r12 == true) goto L9;
            if (Range.compareOrThrow(r5, r11) != 0) goto L9;
            return ImmutableSortedSet.of();
        L9:
            return subSet(Range.range(r5, BoundType.forBoolean(r10), r11, BoundType.forBoolean(r12)));
        }

        public ImmutableSortedSet<C> tailSetImpl(C r5, boolean r10) {
            return subSet(Range.downTo(r5, BoundType.forBoolean(r10)));
        }
    }

    public static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final n2 domain;
        private final ImmutableList<Range<C>> ranges;

        public AsSetSerializedForm(ImmutableList<Range<C>> r5, n2 r10) {
            this.ranges = r5;
            this.domain = r10;
        }

        public Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    public final class ComplementRanges extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;
        final /* synthetic */ ImmutableRangeSet this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public ComplementRanges(ImmutableRangeSet r5) {
            this.this$0 = r5;
            boolean r10 = ((Range) ImmutableRangeSet.access$000(r5).get(0)).hasLowerBound();
            this.positiveBoundedBelow = r10;
            ImmutableList r11 = ImmutableRangeSet.access$000(r5);
            if (r11 != null) goto L5;
            Iterator<E> r12 = r11.iterator();
        L10:
            Object r13 = r12.next();
            if (r12.hasNext() == true) goto L10;
            Object r14 = r13;
        L13:
            boolean r15 = ((Range) r14).hasUpperBound();
            this.positiveBoundedAbove = r15;
            int r16 = ImmutableRangeSet.access$000(r5).size();
            int r17 = r16 - 1;
            if (r10 == true) goto L17;
            r16 = r17;
        L17:
            if (r15 == false) goto L19;
            r16 = r16 + 1;
        L19:
            this.size = r16;
            return;
        L5:
            if (r11.isEmpty() == true) goto L8;
            r14 = r11.get(r11.size() - 1);
            goto L13
        L8:
            throw new NoSuchElementException();
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object get(int r5) {
            return get(r5);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public Range<C> get(int r5) {
            com.google.common.base.b0.l(r5, this.size);
            if (this.positiveBoundedBelow == false) goto L7;
            if (r5 != 0) goto L6;
            Cut<C> r10 = Cut.belowAll();
        L9:
            if (this.positiveBoundedAbove == true) goto L11;
        L13:
            Cut<C> r11 = ((Range) ImmutableRangeSet.access$000(this.this$0).get(r5 + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound;
        L15:
            return Range.create(r10, r11);
        L11:
            if (r5 != (this.size - 1)) goto L13;
            r11 = Cut.aboveAll();
            goto L15
        L6:
            r10 = ((Range) ImmutableRangeSet.access$000(this.this$0).get(r5 - 1)).upperBound;
            goto L9
        L7:
            r10 = ((Range) ImmutableRangeSet.access$000(this.this$0).get(r5)).upperBound;
            goto L9
        }
    }

    public static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        public SerializedForm(ImmutableList<Range<C>> r5) {
            this.ranges = r5;
        }

        public Object readResolve() {
            if (this.ranges.isEmpty() == false) goto L7;
            return ImmutableRangeSet.of();
        L7:
            if (this.ranges.equals(ImmutableList.of(Range.all())) == false) goto L11;
            return ImmutableRangeSet.all();
        L11:
            return new ImmutableRangeSet(this.ranges);
        }
    }

    static {
        f8834c = new ImmutableRangeSet(ImmutableList.of());
        d = new ImmutableRangeSet(ImmutableList.of(Range.all()));
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> r5) {
        this.f8835a = r5;
    }

    public static /* synthetic */ ImmutableList access$000(ImmutableRangeSet r5) {
        return r5.f8835a;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> all() {
        return d;
    }

    public static <C extends Comparable<?>> m4 builder() {
        return new m4();
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> r5) {
        m4 r10 = new m4();
        Iterator<Range<C>> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        Range<C> r12 = r11.next();
        com.google.common.base.b0.h("range must not be empty, but was %s", !r12.isEmpty(), r12);
        r10.f9072a.add(r12);
        goto L4
    L7:
        return r10.a();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return f8834c;
    }

    public static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> toImmutableRangeSet() {
        return n1.f9086c;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> r5) {
        return copyOf(TreeRangeSet.create(r5));
    }

    @Override // com.google.common.collect.l8
    @Deprecated
    public void add(Range<C> r5) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void addAll(l8 r5) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: asDescendingSetOfRanges, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Set m94asDescendingSetOfRanges() {
        return asDescendingSetOfRanges();
    }

    @Override // com.google.common.collect.l8
    public /* bridge */ /* synthetic */ Set asRanges() {
        return asRanges();
    }

    public ImmutableSortedSet<C> asSet(n2 r5) {
        r5.getClass();
        if (isEmpty() == true) goto L5;
        Range<C> r10 = span().canonical(r5);
        if (r10.hasLowerBound() == false) goto L17;
        if (r10.hasUpperBound() == true) goto L15;
        r5.maxValue();     // Catch: NoSuchElementException -> L12
    L13:
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
    L15:
        return new AsSet(this, r5);
    L17:
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    L5:
        return ImmutableSortedSet.of();
    }

    public void clear() {
        remove(Range.all());
    }

    @Override // com.google.common.collect.l8
    public /* bridge */ /* synthetic */ l8 complement() {
        return complement();
    }

    public boolean contains(Comparable r5) {
        if (rangeContaining(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ImmutableRangeSet<C> difference(l8 r5) {
        TreeRangeSet r10 = TreeRangeSet.create(this);
        r10.removeAll(r5);
        return copyOf(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.l8
    public boolean encloses(Range<C> r10) {
        com.google.common.base.q r5 = Range.lowerBoundFn();
        Cut<C> r11 = r10.lowerBound;
        g8 r12 = g8.natural();
        SortedLists$KeyPresentBehavior r13 = SortedLists$KeyPresentBehavior.ANY_PRESENT;
        SortedLists$KeyAbsentBehavior r14 = SortedLists$KeyAbsentBehavior.NEXT_LOWER;
        int r15 = p7.m(this.f8835a, r5, r11, r12, r13, r14);
        if (r15 != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (((Range) this.f8835a.get(r15)).encloses(r10) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.l8
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable r5) {
        return super.enclosesAll(r5);
    }

    @Override // com.google.common.collect.m0
    public /* bridge */ /* synthetic */ boolean equals(Object r5) {
        return super.equals(r5);
    }

    public ImmutableRangeSet<C> intersection(l8 r5) {
        TreeRangeSet r10 = TreeRangeSet.create(this);
        r10.removeAll(r5.complement());
        return copyOf(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean intersects(Range<C> r10) {
        com.google.common.base.q r5 = Range.lowerBoundFn();
        Cut<C> r11 = r10.lowerBound;
        g8 r12 = g8.natural();
        SortedLists$KeyPresentBehavior r13 = SortedLists$KeyPresentBehavior.ANY_PRESENT;
        SortedLists$KeyAbsentBehavior r14 = SortedLists$KeyAbsentBehavior.NEXT_HIGHER;
        int r15 = p7.m(this.f8835a, r5, r11, r12, r13, r14);
        ImmutableList r16 = this.f8835a;
        if (r15 < r16.size()) goto L5;
    L9:
        if (r15 <= 0) goto L15;
        int r17 = r15 - 1;
        if (((Range) r16.get(r17)).isConnected(r10) == false) goto L15;
        if (((Range) r16.get(r17)).intersection(r10).isEmpty() == true) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (((Range) r16.get(r15)).isConnected(r10) == false) goto L9;
        if (((Range) r16.get(r15)).intersection(r10).isEmpty() == true) goto L9;
        return true;
    }

    @Override // com.google.common.collect.l8
    public boolean isEmpty() {
        return this.f8835a.isEmpty();
    }

    public boolean isPartialView() {
        return this.f8835a.isPartialView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Range<C> rangeContaining(C r10) {
        com.google.common.base.q r5 = Range.lowerBoundFn();
        Cut r11 = Cut.belowValue(r10);
        g8 r12 = g8.natural();
        SortedLists$KeyPresentBehavior r13 = SortedLists$KeyPresentBehavior.ANY_PRESENT;
        SortedLists$KeyAbsentBehavior r14 = SortedLists$KeyAbsentBehavior.NEXT_LOWER;
        int r15 = p7.m(this.f8835a, r5, r11, r12, r13, r14);
        if (r15 == (-1)) goto L8;
        Range<C> r16 = (Range) this.f8835a.get(r15);
        if (r16.contains(r10) == true) goto L7;
        return null;
    L7:
        return r16;
    L8:
        return null;
    }

    @Override // com.google.common.collect.l8
    @Deprecated
    public void remove(Range<C> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.l8
    @Deprecated
    public void removeAll(l8 r5) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Range<C> span() {
        ImmutableList r5 = this.f8835a;
        if (r5.isEmpty() == true) goto L7;
        return Range.create(((Range) r5.get(0)).lowerBound, ((Range) r5.get(r5.size() - 1)).upperBound);
    L7:
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: subRangeSet, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ l8 m95subRangeSet(Range r5) {
        return subRangeSet(r5);
    }

    public ImmutableRangeSet<C> union(l8 r5) {
        int r10 = 0;
        Iterable[] r11 = {asRanges(), r5.asRanges()};
    L3:
        if (r10 >= 2) goto L6;
        r11[r10].getClass();
        r10 = r10 + 1;
        goto L3
    L6:
        return unionOf(new r2(r11));
    }

    public Object writeReplace() {
        return new SerializedForm(this.f8835a);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> r5) {
        r5.getClass();
        if (r5.isEmpty() == false) goto L7;
        return of();
    L7:
        if (r5.equals(Range.all()) == false) goto L11;
        return all();
    L11:
        return new ImmutableRangeSet(ImmutableList.of(r5));
    }

    @Override // com.google.common.collect.l8
    @Deprecated
    public void addAll(Iterable<Range<C>> r5) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        ImmutableList r5 = this.f8835a;
        if (r5.isEmpty() == false) goto L7;
        return ImmutableSet.of();
    L7:
        return new RegularImmutableSortedSet(r5.reverse(), Range.rangeLexOrdering().reverse());
    }

    @Override // com.google.common.collect.l8
    public ImmutableSet<Range<C>> asRanges() {
        ImmutableList r5 = this.f8835a;
        if (r5.isEmpty() == false) goto L7;
        return ImmutableSet.of();
    L7:
        return new RegularImmutableSortedSet(r5, Range.rangeLexOrdering());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.l8
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> r5 = this.f8836b;
        if (r5 == null) goto L5;
        return r5;
    L5:
        ImmutableList r10 = this.f8835a;
        if (r10.isEmpty() == false) goto L10;
        ImmutableRangeSet<C> r11 = all();
        this.f8836b = r11;
        return r11;
    L10:
        if (r10.size() == 1) goto L12;
    L15:
        ImmutableRangeSet<C> r12 = new ImmutableRangeSet(new ComplementRanges(this), this);
        this.f8836b = r12;
        return r12;
    L12:
        if (((Range) r10.get(0)).equals(Range.all()) == false) goto L15;
        ImmutableRangeSet<C> r13 = of();
        this.f8836b = r13;
        return r13;
    }

    public boolean enclosesAll(l8 r5) {
        return enclosesAll(r5.asRanges());
    }

    @Override // com.google.common.collect.l8
    @Deprecated
    public void removeAll(Iterable<Range<C>> r5) {
        throw new UnsupportedOperationException();
    }

    public ImmutableRangeSet<C> subRangeSet(final Range<C> r10) {
        if (isEmpty() == true) goto L33;
        Range<C> r5 = span();
        if (r10.encloses(r5) == false) goto L8;
        return this;
    L8:
        if (r10.isConnected(r5) == false) goto L33;
        ImmutableList<Range<Comparable>> r11 = this.f8835a;
        if (r11.isEmpty() == false) goto L12;
    L29:
        r11 = ImmutableList.of();
    L31:
        return new ImmutableRangeSet(r11);
    L12:
        if (r10.isEmpty() == true) goto L29;
        if (r10.encloses(span()) == true) goto L31;
        if (r10.hasLowerBound() == false) goto L20;
        final int r12 = p7.l(r11, Range.upperBoundFn(), r10.lowerBound, SortedLists$KeyPresentBehavior.FIRST_AFTER, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
    L22:
        if (r10.hasUpperBound() == false) goto L24;
        int r13 = p7.l(r11, Range.lowerBoundFn(), r10.upperBound, SortedLists$KeyPresentBehavior.FIRST_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
    L25:
        final int r14 = r13 - r12;
        if (r14 != 0) goto L28;
        r11 = ImmutableList.of();
        goto L31
    L28:
        r11 = new AnonymousClass1(this, r14, r12, r10);
        goto L31
    L24:
        r13 = r11.size();
        goto L25
    L20:
        r12 = 0;
    L33:
        return of();
    }

    public ImmutableRangeSet(ImmutableList r5, ImmutableRangeSet r10) {
        this.f8835a = r5;
        this.f8836b = r10;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(l8 r5) {
        r5.getClass();
        if (r5.isEmpty() == false) goto L7;
        return of();
    L7:
        if (r5.encloses(Range.all()) == false) goto L11;
        return all();
    L11:
        if ((r5 instanceof ImmutableRangeSet) == false) goto L16;
        ImmutableRangeSet<C> r10 = (ImmutableRangeSet) r5;
        if (r10.isPartialView() == true) goto L16;
        return r10;
    L16:
        return new ImmutableRangeSet(ImmutableList.copyOf(r5.asRanges()));
    }
}
