package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements com.google.common.base.z, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Range f8855a = null;
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    public static class RangeLexOrdering extends g8 implements Serializable {
        static final g8 INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new RangeLexOrdering();
        }

        private RangeLexOrdering() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r5, Object r10) {
            return compare((Range) r5, (Range) r10);
        }

        public int compare(Range<?> r5, Range<?> r10) {
            return f2.f8965a.a(r5.lowerBound, r10.lowerBound).a(r5.upperBound, r10.upperBound).b();
        }
    }

    static {
        f8855a = new Range(Cut.belowAll(), Cut.aboveAll());
    }

    public Range(Cut r5, Cut r10) {
        r5.getClass();
        this.lowerBound = r5;
        r10.getClass();
        this.upperBound = r10;
        if (r5.compareTo(r10) <= 0) goto L5;
    L10:
        StringBuilder r11 = new StringBuilder(16);
        r5.describeAsLowerBound(r11);
        r11.append("..");
        r10.describeAsUpperBound(r11);
        String r12 = String.valueOf(r11.toString());
        if (r12.length() == 0) goto L13;
        String r13 = "Invalid range: ".concat(r12);
    L15:
        throw new IllegalArgumentException(r13);
    L13:
        r13 = new String("Invalid range: ");
        goto L15
    L5:
        if (r5 == Cut.aboveAll()) goto L10;
        if (r10 == Cut.belowAll()) goto L10;
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return f8855a;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C r5) {
        return create(Cut.belowValue(r5), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C r5) {
        return create(Cut.belowAll(), Cut.aboveValue(r5));
    }

    public static <C extends Comparable<?>> Range<C> closed(C r5, C r10) {
        return create(Cut.belowValue(r5), Cut.aboveValue(r10));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C r5, C r10) {
        return create(Cut.belowValue(r5), Cut.belowValue(r10));
    }

    public static int compareOrThrow(Comparable r5, Comparable r10) {
        return r5.compareTo(r10);
    }

    public static <C extends Comparable<?>> Range<C> create(Cut<C> r5, Cut<C> r10) {
        return new Range(r5, r10);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C r5, BoundType r10) {
        int r11 = i8.f9025a[r10.ordinal()];
        if (r11 == 1) goto L11;
        if (r11 != 2) goto L9;
        return atLeast(r5);
    L9:
        throw new AssertionError();
    L11:
        return greaterThan(r5);
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> r5) {
        r5.getClass();
        if ((r5 instanceof SortedSet) == false) goto L9;
        SortedSet r10 = (SortedSet) r5;
        Comparator r11 = r10.comparator();
        if (g8.natural().equals(r11) == true) goto L8;
        if (r11 != null) goto L9;
    L8:
        return closed((Comparable) r10.first(), (Comparable) r10.last());
    L9:
        Iterator<C> r12 = r5.iterator();
        C r13 = r12.next();
        r13.getClass();
        Comparable r14 = r13;
    L11:
        if (r12.hasNext() == false) goto L14;
        C r15 = r12.next();
        r15.getClass();
        r13 = (Comparable) g8.natural().min(r13, r15);
        r14 = (Comparable) g8.natural().max(r14, r15);
        goto L11
    L14:
        return closed(r13, r14);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C r5) {
        return create(Cut.aboveValue(r5), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C r5) {
        return create(Cut.belowAll(), Cut.belowValue(r5));
    }

    public static <C extends Comparable<?>> com.google.common.base.q lowerBoundFn() {
        return j8.f9041b;
    }

    public static <C extends Comparable<?>> Range<C> open(C r5, C r10) {
        return create(Cut.aboveValue(r5), Cut.belowValue(r10));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C r5, C r10) {
        return create(Cut.aboveValue(r5), Cut.aboveValue(r10));
    }

    public static <C extends Comparable<?>> Range<C> range(C r5, BoundType r10, C r11, BoundType r12) {
        r10.getClass();
        r12.getClass();
        BoundType r13 = BoundType.OPEN;
        if (r10 != r13) goto L5;
        Cut r14 = Cut.aboveValue(r5);
    L6:
        if (r12 != r13) goto L8;
        Cut r15 = Cut.belowValue(r11);
    L10:
        return create(r14, r15);
    L8:
        r15 = Cut.aboveValue(r11);
        goto L10
    L5:
        r14 = Cut.belowValue(r5);
        goto L6
    }

    public static <C extends Comparable<?>> g8 rangeLexOrdering() {
        return RangeLexOrdering.INSTANCE;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C r5) {
        return closed(r5, r5);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C r5, BoundType r10) {
        int r11 = i8.f9025a[r10.ordinal()];
        if (r11 == 1) goto L11;
        if (r11 != 2) goto L9;
        return atMost(r5);
    L9:
        throw new AssertionError();
    L11:
        return lessThan(r5);
    }

    public static <C extends Comparable<?>> com.google.common.base.q upperBoundFn() {
        return j8.f9042c;
    }

    @Override // com.google.common.base.z
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Object r5) {
        return apply((Comparable) r5);
    }

    public Range<C> canonical(n2 r5) {
        r5.getClass();
        Cut<C> r10 = this.lowerBound.canonical(r5);
        Cut<C> r11 = this.upperBound.canonical(r5);
        if (r10 != this.lowerBound) goto L8;
        if (r11 != this.upperBound) goto L8;
        return this;
    L8:
        return create(r10, r11);
    }

    public boolean contains(C r5) {
        r5.getClass();
        if (this.lowerBound.isLessThan(r5) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.upperBound.isLessThan(r5) == true) goto L7;
        return true;
    }

    public boolean containsAll(Iterable<? extends C> r10) {
        if ((r10 instanceof Collection) == false) goto L5;
        boolean r5 = ((Collection) r10).isEmpty();
    L6:
        if (r5 == false) goto L9;
        return true;
    L9:
        if ((r10 instanceof SortedSet) == false) goto L20;
        SortedSet r11 = (SortedSet) r10;
        Comparator r12 = r11.comparator();
        if (g8.natural().equals(r12) == true) goto L14;
        if (r12 != null) goto L20;
    L14:
        if (contains((Comparable) r11.first()) == false) goto L19;
        if (contains((Comparable) r11.last()) == false) goto L19;
        return true;
    L19:
        return false;
    L20:
        Iterator<? extends C> r13 = r10.iterator();
    L22:
        if (r13.hasNext() == false) goto L26;
        if (contains(r13.next()) == true) goto L22;
        return false;
    L26:
        return true;
    L5:
        r5 = !r10.iterator().hasNext();
        goto L6
    }

    public boolean encloses(Range<C> r5) {
        if (this.lowerBound.compareTo(r5.lowerBound) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.upperBound.compareTo(r5.upperBound) < 0) goto L7;
        return true;
    }

    @Override // com.google.common.base.z
    public boolean equals(Object r5) {
        if ((r5 instanceof Range) == false) goto L10;
        Range r10 = (Range) r5;
        if (this.lowerBound.equals(r10.lowerBound) == true) goto L7;
        return false;
    L7:
        if (this.upperBound.equals(r10.upperBound) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public Range<C> gap(Range<C> r5) {
        if (this.lowerBound.compareTo(r5.upperBound) >= 0) goto L10;
        if (r5.lowerBound.compareTo(this.upperBound) >= 0) goto L10;
        String r10 = String.valueOf(this);
        String r11 = String.valueOf(r5);
        int r12 = r10.length() + 39;
        StringBuilder r13 = new StringBuilder(r11.length() + r12);
        r13.append("Ranges have a nonempty intersection: ");
        r13.append(r10);
        r13.append(", ");
        r13.append(r11);
        throw new IllegalArgumentException(r13.toString());
    L10:
        if (this.lowerBound.compareTo(r5.lowerBound) >= 0) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L15;
        Range<C> r15 = this;
    L16:
        if (r14 == false) goto L19;
        Range<C> this = r5;
    L19:
        return create(r15.upperBound, this.lowerBound);
    L15:
        r15 = r5;
        goto L16
    L12:
        r14 = false;
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
        int r10 = this.lowerBound.compareTo(r5.lowerBound);
        int r11 = this.upperBound.compareTo(r5.upperBound);
        if (r10 < 0) goto L6;
        if (r11 > 0) goto L6;
        return this;
    L6:
        if (r10 > 0) goto L9;
        if (r11 < 0) goto L9;
        return r5;
    L9:
        if (r10 < 0) goto L11;
        Cut<C> r12 = this.lowerBound;
    L12:
        if (r11 > 0) goto L14;
        Cut<C> r13 = this.upperBound;
    L16:
        if (r12.compareTo(r13) > 0) goto L18;
        boolean r14 = true;
    L19:
        com.google.common.base.b0.k(r14, "intersection is undefined for disconnected ranges %s and %s", this, r5);
        return create(r12, r13);
    L18:
        r14 = false;
        goto L19
    L14:
        r13 = r5.upperBound;
        goto L16
    L11:
        r12 = r5.lowerBound;
        goto L12
    }

    public boolean isConnected(Range<C> r5) {
        if (this.lowerBound.compareTo(r5.upperBound) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (r5.lowerBound.compareTo(this.upperBound) > 0) goto L7;
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

    public Object readResolve() {
        if (equals(f8855a) == true) goto L5;
        return this;
    L5:
        return all();
    }

    public Range<C> span(Range<C> r5) {
        int r10 = this.lowerBound.compareTo(r5.lowerBound);
        int r11 = this.upperBound.compareTo(r5.upperBound);
        if (r10 > 0) goto L6;
        if (r11 < 0) goto L6;
        return this;
    L6:
        if (r10 < 0) goto L9;
        if (r11 > 0) goto L9;
        return r5;
    L9:
        if (r10 > 0) goto L11;
        Cut<C> r12 = this.lowerBound;
    L12:
        if (r11 < 0) goto L14;
        Cut<C> r13 = this.upperBound;
    L16:
        return create(r12, r13);
    L14:
        r13 = r5.upperBound;
        goto L16
    L11:
        r12 = r5.lowerBound;
        goto L12
    }

    @Override // com.google.common.base.z, java.util.function.Predicate
    public boolean test(Object r5) {
        return apply(r5);
    }

    public String toString() {
        Cut<C> r5 = this.lowerBound;
        Cut<C> r10 = this.upperBound;
        StringBuilder r11 = new StringBuilder(16);
        r5.describeAsLowerBound(r11);
        r11.append("..");
        r10.describeAsUpperBound(r11);
        return r11.toString();
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return (C) this.upperBound.endpoint();
    }

    @Deprecated
    public boolean apply(C r5) {
        return contains(r5);
    }
}
