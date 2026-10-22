package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableRangeSet<C extends Comparable> extends f<C> implements Serializable {
    private static final ImmutableRangeSet<Comparable<?>> ALL = null;
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = null;
    private transient ImmutableRangeSet<C> complement;
    private final transient ImmutableList<Range<C>> ranges;

    private final class AsSet extends ImmutableSortedSet<C> {
        private final DiscreteDomain<C> domain;
        private transient Integer size;
        final /* synthetic */ ImmutableRangeSet this$0;

        AsSet(ImmutableRangeSet r1, DiscreteDomain<C> r2) {
            this.this$0 = r1;
            super(Ordering.natural());
            this.domain = r2;
        }

        static /* synthetic */ DiscreteDomain access$100(AsSet r0) {
            return r0.domain;
        }

        private void readObject(ObjectInputStream r1) {
            throw new InvalidObjectException("Use SerializedForm");
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (r4 != null) goto L8;
            return false;
        L8:
            Comparable r5 = (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L7
            return this.this$0.contains(r5);
        L7:
            return false;
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        ImmutableSortedSet<C> createDescendingSet() {
            return new DescendingImmutableSortedSet(this);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public bj<C> descendingIterator() {
            return new AnonymousClass2(this);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator descendingIterator() {
            return descendingIterator();
        }

        ImmutableSortedSet<C> headSetImpl(C r3, boolean r4) {
            return subSet(Range.upTo((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), BoundType.forBoolean(r4)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* synthetic */ ImmutableSortedSet headSetImpl(Object r3, boolean r4) {
            return headSetImpl((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        int indexOf(Object r7) {
            if (contains(r7) == false) goto L14;
            Comparable r8 = (Comparable) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r7), Comparable.class, "com.obric.memorydata.plugin");
            long r2 = 0;
            bj r0 = ImmutableRangeSet.access$000(this.this$0).iterator();
        L6:
            if (r0.hasNext() == false) goto L13;
            Range r4 = (Range) ZeusTransformUtils.preCheckCast(r0.next(), Range.class, "com.obric.memorydata.plugin");
            if (r4.contains(r8) == true) goto L10;
            r2 = r2 + ((long) ContiguousSet.create(r4, this.domain).size());
            goto L6
        L10:
            return Ints.b(r2 + ((long) ContiguousSet.create(r4, this.domain).indexOf(r8)));
        L13:
            throw new AssertionError("impossible");
        L14:
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return ImmutableRangeSet.access$000(this.this$0).isPartialView();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public bj<C> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer r0 = this.size;
            if (r0 != null) goto L11;
            long r1 = 0;
            bj r2 = ImmutableRangeSet.access$000(this.this$0).iterator();
        L6:
            if (r2.hasNext() == false) goto L9;
            r1 = r1 + ((long) ContiguousSet.create((Range) ZeusTransformUtils.preCheckCast(r2.next(), Range.class, "com.obric.memorydata.plugin"), this.domain).size());
            if (r1 < 2147483647L) goto L6;
        L9:
            r0 = Integer.valueOf(Ints.b(r1));
            this.size = r0;
        L11:
            return r0.intValue();
        }

        ImmutableSortedSet<C> subSet(Range<C> r2) {
            return this.this$0.subRangeSet(r2).asSet(this.domain);
        }

        ImmutableSortedSet<C> subSetImpl(C r3, boolean r4, C r5, boolean r6) {
            Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
            if (r4 == true) goto L10;
            if (r6 == true) goto L10;
            if (Range.compareOrThrow(r7, r8) != 0) goto L10;
            return ImmutableSortedSet.of();
        L10:
            return subSet(Range.range(r7, BoundType.forBoolean(r4), r8, BoundType.forBoolean(r6)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* synthetic */ ImmutableSortedSet subSetImpl(Object r3, boolean r4, Object r5, boolean r6) {
            return subSetImpl((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4, (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"), r6);
        }

        ImmutableSortedSet<C> tailSetImpl(C r3, boolean r4) {
            return subSet(Range.downTo((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), BoundType.forBoolean(r4)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* synthetic */ ImmutableSortedSet tailSetImpl(Object r3, boolean r4) {
            return tailSetImpl((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.access$000(this.this$0).toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.access$000(this.this$0), this.domain);
        }
    }

    private static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final DiscreteDomain<C> domain;
        private final ImmutableList<Range<C>> ranges;

        AsSetSerializedForm(ImmutableList<Range<C>> r1, DiscreteDomain<C> r2) {
            this.ranges = r1;
            this.domain = r2;
        }

        Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    private final class ComplementRanges extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;
        final /* synthetic */ ImmutableRangeSet this$0;

        ComplementRanges(ImmutableRangeSet r5) {
            this.this$0 = r5;
            boolean r0 = ((Range) ZeusTransformUtils.preCheckCast(ImmutableRangeSet.access$000(r5).get(0), Range.class, "com.obric.memorydata.plugin")).hasLowerBound();
            this.positiveBoundedBelow = r0;
            boolean r1 = ((Range) ZeusTransformUtils.preCheckCast(aj.d(ImmutableRangeSet.access$000(r5)), Range.class, "com.obric.memorydata.plugin")).hasUpperBound();
            this.positiveBoundedAbove = r1;
            int r6 = ImmutableRangeSet.access$000(r5).size() - 1;
            if (r0 == false) goto L5;
            r6 = r6 + 1;
        L5:
            if (r1 == false) goto L7;
            r6 = r6 + 1;
        L7:
            this.size = r6;
        }

        @Override // java.util.List
        public Range<C> get(int r4) {
            com.google.common.base.n.a(r4, this.size);
            if (this.positiveBoundedBelow == false) goto L7;
            if (r4 != 0) goto L6;
            Cut<C> r0 = Cut.belowAll();
        L10:
            if (this.positiveBoundedAbove == true) goto L12;
        L14:
            Cut<C> r3 = ((Range) ZeusTransformUtils.preCheckCast(ImmutableRangeSet.access$000(this.this$0).get(r4 + (!this.positiveBoundedBelow ? 1 : 0)), Range.class, "com.obric.memorydata.plugin")).lowerBound;
        L16:
            return Range.create(r0, r3);
        L12:
            if (r4 != (this.size - 1)) goto L14;
            r3 = Cut.aboveAll();
            goto L16
        L6:
            Object r1 = ImmutableRangeSet.access$000(this.this$0).get(r4 - 1);
        L8:
            r0 = ((Range) ZeusTransformUtils.preCheckCast(r1, Range.class, "com.obric.memorydata.plugin")).upperBound;
            goto L10
        L7:
            r1 = ImmutableRangeSet.access$000(this.this$0).get(r4);
            goto L8
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    private static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        SerializedForm(ImmutableList<Range<C>> r1) {
            this.ranges = r1;
        }

        Object readResolve() {
            if (this.ranges.isEmpty() == false) goto L7;
            return ImmutableRangeSet.of();
        L7:
            if (this.ranges.equals(ImmutableList.of(Range.all())) == false) goto L11;
            return ImmutableRangeSet.all();
        L11:
            return new ImmutableRangeSet(this.ranges);
        }
    }

    public static class a<C extends Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Range<C>> f4469a;

        public a() {
            this.f4469a = Lists.a();
        }

        a<C> a(a<C> r1) {
            a(r1.f4469a);
            return this;
        }

        public a<C> a(Range<C> r3) {
            com.google.common.base.n.a(!r3.isEmpty(), "range must not be empty, but was %s", r3);
            this.f4469a.add(r3);
            return this;
        }

        public a<C> a(Iterable<Range<C>> r4) {
            Iterator r5 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            a((Range) ZeusTransformUtils.preCheckCast(r5.next(), Range.class, "com.obric.memorydata.plugin"));
            goto L4
        L6:
            return this;
        }

        public ImmutableRangeSet<C> a() {
            ImmutableList.a r0 = new ImmutableList.a(this.f4469a.size());
            Collections.sort(this.f4469a, Range.rangeLexOrdering());
            aq r6 = Iterators.i(this.f4469a.iterator());
        L4:
            if (r6.hasNext() == false) goto L12;
            Range r1 = (Range) ZeusTransformUtils.preCheckCast(r6.next(), Range.class, "com.obric.memorydata.plugin");
        L7:
            if (r6.hasNext() == false) goto L11;
            Range<C> r3 = (Range) ZeusTransformUtils.preCheckCast(r6.a(), Range.class, "com.obric.memorydata.plugin");
            if (r1.isConnected(r3) == false) goto L11;
            com.google.common.base.n.a(r1.intersection(r3).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", r1, r3);
            r1 = r1.span((Range) ZeusTransformUtils.preCheckCast(r6.next(), Range.class, "com.obric.memorydata.plugin"));
        L11:
            r0.b(r1);
            goto L4
        L12:
            ImmutableList r7 = r0.a();
            if (r7.isEmpty() == false) goto L17;
            return ImmutableRangeSet.of();
        L17:
            if (r7.size() != 1) goto L23;
            if (((Range) ZeusTransformUtils.preCheckCast(aj.b(r7), Range.class, "com.obric.memorydata.plugin")).equals(Range.all()) == false) goto L23;
            return ImmutableRangeSet.all();
        L23:
            return new ImmutableRangeSet(r7);
        }
    }

    static {
        EMPTY = new ImmutableRangeSet(ImmutableList.of());
        ALL = new ImmutableRangeSet(ImmutableList.of(Range.all()));
    }

    ImmutableRangeSet(ImmutableList<Range<C>> r1) {
        this.ranges = r1;
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> r1, ImmutableRangeSet<C> r2) {
        this.ranges = r1;
        this.complement = r2;
    }

    static /* synthetic */ ImmutableList access$000(ImmutableRangeSet r0) {
        return r0.ranges;
    }

    static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> a<C> builder() {
        return new a();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(at<C> r3) {
        at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        if (r4.isEmpty() == false) goto L7;
        return of();
    L7:
        if (r4.encloses(Range.all()) == false) goto L11;
        return all();
    L11:
        if (ZeusTransformUtils.instanceOf(r4, ImmutableRangeSet.class) == false) goto L16;
        ImmutableRangeSet<C> r0 = (ImmutableRangeSet) ZeusTransformUtils.preCheckCast(r4, ImmutableRangeSet.class, "com.obric.memorydata.plugin");
        if (r0.isPartialView() == true) goto L16;
        return r0;
    L16:
        return new ImmutableRangeSet(ImmutableList.copyOf(r4.asRanges()));
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> r2) {
        Iterable<Range<C>> r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        return new a().a(r3).a();
    }

    private ImmutableList<Range<C>> intersectRanges(final Range<C> r7) {
        if (this.ranges.isEmpty() == true) goto L26;
        if (r7.isEmpty() == true) goto L26;
        if (r7.encloses(span()) == false) goto L12;
        return this.ranges;
    L12:
        if (r7.hasLowerBound() == false) goto L14;
        final int r0 = SortedLists.a(this.ranges, Range.upperBoundFn(), r7.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    L16:
        if (r7.hasUpperBound() == false) goto L18;
        int r1 = SortedLists.a(this.ranges, Range.lowerBoundFn(), r7.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    L19:
        final int r2 = r1 - r0;
        if (r2 != 0) goto L24;
        return ImmutableList.of();
    L24:
        return (ImmutableList<Range<C>>) new AnonymousClass1(this, r2, r0, r7);
    L18:
        r1 = this.ranges.size();
        goto L19
    L14:
        r0 = 0;
    L26:
        return ImmutableList.of();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> r1) {
        com.google.common.base.n.a(r1);
        if (r1.isEmpty() == false) goto L7;
        return of();
    L7:
        if (r1.equals(Range.all()) == false) goto L11;
        return all();
    L11:
        return new ImmutableRangeSet(ImmutableList.of(r1));
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> toImmutableRangeSet() {
        return n.c();
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> r2) {
        return copyOf(TreeRangeSet.create((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin")));
    }

    @Override // com.google.common.collect.f, com.google.common.collect.at
    @Deprecated
    public void add(Range<C> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.f
    @Deprecated
    public void addAll(at<C> r2) {
        at r1 = (at) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.at
    @Deprecated
    public void addAll(Iterable<Range<C>> r2) {
        Iterable r1 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableSet.of();
    L7:
        return new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse());
    }

    /* JADX INFO: renamed from: asDescendingSetOfRanges, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Set m127asDescendingSetOfRanges() {
        return asDescendingSetOfRanges();
    }

    @Override // com.google.common.collect.at
    public ImmutableSet<Range<C>> asRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableSet.of();
    L7:
        return new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering());
    }

    @Override // com.google.common.collect.at
    public /* bridge */ /* synthetic */ Set asRanges() {
        return asRanges();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> r3) {
        com.google.common.base.n.a(r3);
        if (isEmpty() == true) goto L5;
        Range<C> r0 = span().canonical(r3);
        if (r0.hasLowerBound() == false) goto L17;
        if (r0.hasUpperBound() == true) goto L15;
        r3.maxValue();     // Catch: NoSuchElementException -> L12
    L13:
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
    L15:
        return new AsSet(this, r3);
    L17:
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    L5:
        return ImmutableSortedSet.of();
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.at
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> r0 = this.complement;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.ranges.isEmpty() == false) goto L11;
        ImmutableRangeSet<C> r1 = all();
    L8:
        this.complement = r1;
        return r1;
    L11:
        if (this.ranges.size() == 1) goto L13;
    L15:
        ImmutableRangeSet<C> r2 = new ImmutableRangeSet(new ComplementRanges(this), this);
        this.complement = r2;
        return r2;
    L13:
        if (((Range) ZeusTransformUtils.preCheckCast(this.ranges.get(0), Range.class, "com.obric.memorydata.plugin")).equals(Range.all()) == false) goto L15;
        r1 = of();
        goto L8
    }

    @Override // com.google.common.collect.at
    public /* bridge */ /* synthetic */ at complement() {
        return complement();
    }

    @Override // com.google.common.collect.f
    public /* synthetic */ boolean contains(Comparable r3) {
        return super.contains((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public ImmutableRangeSet<C> difference(at<C> r3) {
        at<C> r4 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
        TreeRangeSet r2 = TreeRangeSet.create(this);
        r2.removeAll(r4);
        return copyOf(r2);
    }

    @Override // com.google.common.collect.f, com.google.common.collect.at
    public boolean encloses(Range<C> r7) {
        int r0 = SortedLists.a(this.ranges, Range.lowerBoundFn(), r7.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r0 != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (((Range) ZeusTransformUtils.preCheckCast(this.ranges.get(r0), Range.class, "com.obric.memorydata.plugin")).encloses(r7) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.f
    public /* synthetic */ boolean enclosesAll(at r3) {
        return super.enclosesAll((at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    public ImmutableRangeSet<C> intersection(at<C> r3) {
        at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
        TreeRangeSet r2 = TreeRangeSet.create(this);
        r2.removeAll(r4.complement());
        return copyOf(r2);
    }

    @Override // com.google.common.collect.f
    public boolean intersects(Range<C> r7) {
        int r0 = SortedLists.a(this.ranges, Range.lowerBoundFn(), r7.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (r0 < this.ranges.size()) goto L5;
    L9:
        if (r0 <= 0) goto L15;
        int r1 = r0 - 1;
        if (((Range) ZeusTransformUtils.preCheckCast(this.ranges.get(r1), Range.class, "com.obric.memorydata.plugin")).isConnected(r7) == false) goto L15;
        if (((Range) ZeusTransformUtils.preCheckCast(this.ranges.get(r1), Range.class, "com.obric.memorydata.plugin")).intersection(r7).isEmpty() == true) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (((Range) ZeusTransformUtils.preCheckCast(this.ranges.get(r0), Range.class, "com.obric.memorydata.plugin")).isConnected(r7) == false) goto L9;
        if (((Range) ZeusTransformUtils.preCheckCast(this.ranges.get(r0), Range.class, "com.obric.memorydata.plugin")).intersection(r7).isEmpty() == true) goto L9;
        return true;
    }

    @Override // com.google.common.collect.f, com.google.common.collect.at
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    @Override // com.google.common.collect.f
    public Range<C> rangeContaining(C r9) {
        Comparable r10 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r9, Comparable.class, "com.obric.memorydata.plugin");
        int r0 = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(r10), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r0 == (-1)) goto L8;
        Range<C> r8 = (Range) ZeusTransformUtils.preCheckCast(this.ranges.get(r0), Range.class, "com.obric.memorydata.plugin");
        if (r8.contains(r10) == true) goto L7;
        return null;
    L7:
        return r8;
    L8:
        return null;
    }

    @Override // com.google.common.collect.f, com.google.common.collect.at
    @Deprecated
    public void remove(Range<C> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.at
    @Deprecated
    public void removeAll(at<C> r2) {
        at r1 = (at) ZeusTransformUtils.wrapperContextForParams(r2, at.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.at
    @Deprecated
    public void removeAll(Iterable<Range<C>> r2) {
        Iterable r1 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    public Range<C> span() {
        if (this.ranges.isEmpty() == true) goto L7;
        Cut<C> r0 = ((Range) ZeusTransformUtils.preCheckCast(this.ranges.get(0), Range.class, "com.obric.memorydata.plugin")).lowerBound;
        ImmutableList<Range<C>> r3 = this.ranges;
        return Range.create(r0, ((Range) ZeusTransformUtils.preCheckCast(r3.get(r3.size() - 1), Range.class, "com.obric.memorydata.plugin")).upperBound);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.at
    public ImmutableRangeSet<C> subRangeSet(Range<C> r3) {
        if (isEmpty() == true) goto L12;
        Range<C> r0 = span();
        if (r3.encloses(r0) == false) goto L8;
        return this;
    L8:
        if (r3.isConnected(r0) == false) goto L12;
        return new ImmutableRangeSet(intersectRanges(r3));
    L12:
        return of();
    }

    @Override // com.google.common.collect.at
    public /* bridge */ /* synthetic */ at subRangeSet(Range r1) {
        return subRangeSet(r1);
    }

    public ImmutableRangeSet<C> union(at<C> r3) {
        at r4 = (at) ZeusTransformUtils.wrapperContextForParams(r3, at.class, "com.obric.memorydata.plugin");
        return unionOf(aj.a(asRanges(), r4.asRanges()));
    }

    Object writeReplace() {
        return new SerializedForm(this.ranges);
    }
}
