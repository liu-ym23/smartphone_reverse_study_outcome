package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements com.google.common.base.o<C>, Serializable {
    private static final Range<Comparable> ALL = null;
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    /* JADX INFO: renamed from: com.google.common.collect.Range$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4579a = null;

        static {
            int[] r0 = new int[BoundType.values().length];
            f4579a = r0;
            r0[BoundType.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f4579a[BoundType.CLOSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        static final Ordering<Range<?>> INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new RangeLexOrdering();
        }

        private RangeLexOrdering() {
        }

        public int compare(Range<?> r3, Range<?> r4) {
            return s.a().a(r3.lowerBound, r4.lowerBound).a(r3.upperBound, r4.upperBound).b();
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public /* synthetic */ int compare(Object r3, Object r4) {
            return compare((Range) ZeusTransformUtils.preCheckCast(r3, Range.class, "com.obric.memorydata.plugin"), (Range) ZeusTransformUtils.preCheckCast(r4, Range.class, "com.obric.memorydata.plugin"));
        }
    }

    static class a implements com.google.common.base.g<Range, Cut> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f4580a = null;

        static {
            f4580a = new a();
        }

        a() {
        }

        public Cut a(Range r1) {
            return r1.lowerBound;
        }

        @Override // com.google.common.base.g, java.util.function.Function
        public /* synthetic */ Object apply(Object r3) {
            return a((Range) ZeusTransformUtils.preCheckCast(r3, Range.class, "com.obric.memorydata.plugin"));
        }
    }

    static class b implements com.google.common.base.g<Range, Cut> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f4581a = null;

        static {
            f4581a = new b();
        }

        b() {
        }

        public Cut a(Range r1) {
            return r1.upperBound;
        }

        @Override // com.google.common.base.g, java.util.function.Function
        public /* synthetic */ Object apply(Object r3) {
            return a((Range) ZeusTransformUtils.preCheckCast(r3, Range.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ALL = new Range(Cut.belowAll(), Cut.aboveAll());
    }

    private Range(Cut<C> r4, Cut<C> r5) {
        this.lowerBound = (Cut) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r4), Cut.class, "com.obric.memorydata.plugin");
        this.upperBound = (Cut) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), Cut.class, "com.obric.memorydata.plugin");
        if (r4.compareTo(r5) > 0) goto L10;
        if (r4 == Cut.aboveAll()) goto L10;
        if (r5 == Cut.belowAll()) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Invalid range: " + toString(r4, r5));
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C r2) {
        return create(Cut.belowValue((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin")), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C r2) {
        Comparable r3 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        return create(Cut.belowAll(), Cut.aboveValue(r3));
    }

    public static <C extends Comparable<?>> Range<C> closed(C r2, C r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        return create(Cut.belowValue(r4), Cut.aboveValue(r5));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C r2, C r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        return create(Cut.belowValue(r4), Cut.belowValue(r5));
    }

    static int compareOrThrow(Comparable r2, Comparable r3) {
        return ((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin")).compareTo((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    static <C extends Comparable<?>> Range<C> create(Cut<C> r1, Cut<C> r2) {
        return new Range(r1, r2);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C r2, BoundType r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        int r5 = AnonymousClass1.f4579a[r3.ordinal()];
        if (r5 == 1) goto L11;
        if (r5 != 2) goto L9;
        return atLeast(r4);
    L9:
        throw new AssertionError();
    L11:
        return greaterThan(r4);
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r6);
        if (ZeusTransformUtils.instanceOf(r6, SortedSet.class) == false) goto L9;
        SortedSet r0 = (SortedSet) ZeusTransformUtils.preCheckCast(r6, SortedSet.class, "com.obric.memorydata.plugin");
        Comparator r2 = r0.comparator();
        if (Ordering.natural().equals(r2) == true) goto L8;
        if (r2 != null) goto L9;
    L8:
        return closed((Comparable) ZeusTransformUtils.preCheckCast(r0.first(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r0.last(), Comparable.class, "com.obric.memorydata.plugin"));
    L9:
        Iterator r7 = r6.iterator();
        Comparable r1 = (Comparable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparable) ZeusTransformUtils.preCheckCast(r7.next(), Comparable.class, "com.obric.memorydata.plugin")), Comparable.class, "com.obric.memorydata.plugin");
        Comparable r3 = r1;
    L11:
        if (r7.hasNext() == false) goto L14;
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparable) ZeusTransformUtils.preCheckCast(r7.next(), Comparable.class, "com.obric.memorydata.plugin")), Comparable.class, "com.obric.memorydata.plugin");
        r1 = (Comparable) ZeusTransformUtils.preCheckCast(Ordering.natural().min(r1, r4), Comparable.class, "com.obric.memorydata.plugin");
        r3 = (Comparable) ZeusTransformUtils.preCheckCast(Ordering.natural().max(r3, r4), Comparable.class, "com.obric.memorydata.plugin");
        goto L11
    L14:
        return closed(r1, r3);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C r2) {
        return create(Cut.aboveValue((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin")), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C r2) {
        Comparable r3 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        return create(Cut.belowAll(), Cut.belowValue(r3));
    }

    static <C extends Comparable<?>> com.google.common.base.g<Range<C>, Cut<C>> lowerBoundFn() {
        return a.f4580a;
    }

    public static <C extends Comparable<?>> Range<C> open(C r2, C r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        return create(Cut.aboveValue(r4), Cut.belowValue(r5));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C r2, C r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        return create(Cut.aboveValue(r4), Cut.aboveValue(r5));
    }

    public static <C extends Comparable<?>> Range<C> range(C r2, BoundType r3, C r4, BoundType r5) {
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r3);
        com.google.common.base.n.a(r5);
        if (r3 != BoundType.OPEN) goto L5;
        Cut r8 = Cut.aboveValue(r6);
    L7:
        if (r5 != BoundType.OPEN) goto L9;
        Cut r9 = Cut.belowValue(r7);
    L11:
        return create(r8, r9);
    L9:
        r9 = Cut.aboveValue(r7);
        goto L11
    L5:
        r8 = Cut.belowValue(r6);
        goto L7
    }

    static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return (Ordering<Range<C>>) RangeLexOrdering.INSTANCE;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C r2) {
        Comparable r3 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        return closed(r3, r3);
    }

    private static String toString(Cut<?> r2, Cut<?> r3) {
        StringBuilder r0 = new StringBuilder(16);
        r2.describeAsLowerBound(r0);
        r0.append("..");
        r3.describeAsUpperBound(r0);
        return r0.toString();
    }

    public static <C extends Comparable<?>> Range<C> upTo(C r2, BoundType r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        int r5 = AnonymousClass1.f4579a[r3.ordinal()];
        if (r5 == 1) goto L11;
        if (r5 != 2) goto L9;
        return atMost(r4);
    L9:
        throw new AssertionError();
    L11:
        return lessThan(r4);
    }

    static <C extends Comparable<?>> com.google.common.base.g<Range<C>, Cut<C>> upperBoundFn() {
        return b.f4581a;
    }

    @Deprecated
    public boolean apply(C r3) {
        return contains((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.base.o
    @Deprecated
    public /* synthetic */ boolean apply(Object r3) {
        return apply((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public Range<C> canonical(DiscreteDomain<C> r3) {
        com.google.common.base.n.a(r3);
        Cut<C> r0 = this.lowerBound.canonical(r3);
        Cut<C> r4 = this.upperBound.canonical(r3);
        if (r0 != this.lowerBound) goto L8;
        if (r4 != this.upperBound) goto L8;
        return this;
    L8:
        return create(r0, r4);
    }

    public boolean contains(C r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        if (this.lowerBound.isLessThan(r4) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.upperBound.isLessThan(r4) == true) goto L7;
        return true;
    }

    public boolean containsAll(Iterable<? extends C> r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r7, Iterable.class, "com.obric.memorydata.plugin");
        if (aj.e(r8) == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, SortedSet.class) == false) goto L17;
        SortedSet r0 = (SortedSet) ZeusTransformUtils.preCheckCast(r8, SortedSet.class, "com.obric.memorydata.plugin");
        Comparator r4 = r0.comparator();
        if (Ordering.natural().equals(r4) == true) goto L11;
        if (r4 != null) goto L17;
    L11:
        if (contains((Comparable) ZeusTransformUtils.preCheckCast(r0.first(), Comparable.class, "com.obric.memorydata.plugin")) == false) goto L16;
        if (contains((Comparable) ZeusTransformUtils.preCheckCast(r0.last(), Comparable.class, "com.obric.memorydata.plugin")) == false) goto L16;
        return true;
    L16:
        return false;
    L17:
        Iterator r9 = r8.iterator();
    L19:
        if (r9.hasNext() == false) goto L23;
        if (contains((Comparable) ZeusTransformUtils.preCheckCast(r9.next(), Comparable.class, "com.obric.memorydata.plugin")) == true) goto L19;
        return false;
    L23:
        return true;
    }

    public boolean encloses(Range<C> r3) {
        if (this.lowerBound.compareTo(r3.lowerBound) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.upperBound.compareTo(r3.upperBound) < 0) goto L7;
        return true;
    }

    @Override // com.google.common.base.o
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Range.class) == false) goto L10;
        Range r5 = (Range) ZeusTransformUtils.preCheckCast(r4, Range.class, "com.obric.memorydata.plugin");
        if (this.lowerBound.equals(r5.lowerBound) == true) goto L7;
        return false;
    L7:
        if (this.upperBound.equals(r5.upperBound) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public Range<C> gap(Range<C> r4) {
        if (this.lowerBound.compareTo(r4.upperBound) >= 0) goto L10;
        if (r4.lowerBound.compareTo(this.upperBound) >= 0) goto L10;
        throw new IllegalArgumentException("Ranges have a nonempty intersection: " + this + ", " + r4);
    L10:
        if (this.lowerBound.compareTo(r4.lowerBound) >= 0) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        Range<C> r1 = this;
    L16:
        if (r0 == false) goto L19;
        Range<C> this = r4;
    L19:
        return create(r1.upperBound, this.lowerBound);
    L15:
        r1 = r4;
        goto L16
    L12:
        r0 = false;
        goto L13
    }

    public boolean hasLowerBound() {
        if (this.lowerBound == Cut.belowAll()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasUpperBound() {
        if (this.upperBound == Cut.aboveAll()) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> r5) {
        int r0 = this.lowerBound.compareTo(r5.lowerBound);
        int r1 = this.upperBound.compareTo(r5.upperBound);
        if (r0 < 0) goto L6;
        if (r1 > 0) goto L6;
        return this;
    L6:
        if (r0 > 0) goto L9;
        if (r1 < 0) goto L9;
        return r5;
    L9:
        if (r0 < 0) goto L11;
        Cut<C> r2 = this.lowerBound;
    L12:
        if (r1 > 0) goto L14;
        Cut<C> r3 = this.upperBound;
    L16:
        if (r2.compareTo(r3) > 0) goto L18;
        boolean r4 = true;
    L19:
        com.google.common.base.n.a(r4, "intersection is undefined for disconnected ranges %s and %s", this, r5);
        return create(r2, r3);
    L18:
        r4 = false;
        goto L19
    L14:
        r3 = r5.upperBound;
        goto L16
    L11:
        r2 = r5.lowerBound;
        goto L12
    }

    public boolean isConnected(Range<C> r3) {
        if (this.lowerBound.compareTo(r3.upperBound) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (r3.lowerBound.compareTo(this.upperBound) > 0) goto L7;
        return true;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public C lowerEndpoint() {
        return (C) this.lowerBound.endpoint();
    }

    Object readResolve() {
        if (equals(ALL) == true) goto L5;
        return this;
    L5:
        return all();
    }

    public Range<C> span(Range<C> r4) {
        int r0 = this.lowerBound.compareTo(r4.lowerBound);
        int r1 = this.upperBound.compareTo(r4.upperBound);
        if (r0 > 0) goto L6;
        if (r1 < 0) goto L6;
        return this;
    L6:
        if (r0 < 0) goto L9;
        if (r1 > 0) goto L9;
        return r4;
    L9:
        if (r0 > 0) goto L11;
        Cut<C> r2 = this.lowerBound;
    L12:
        if (r1 < 0) goto L14;
        Cut<C> r3 = this.upperBound;
    L16:
        return create(r2, r3);
    L14:
        r3 = r4.upperBound;
        goto L16
    L11:
        r2 = r4.lowerBound;
        goto L12
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return (C) this.upperBound.endpoint();
    }
}
