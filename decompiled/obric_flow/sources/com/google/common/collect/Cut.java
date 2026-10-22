package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;

/* JADX INFO: loaded from: classes2.dex */
abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    private static final long serialVersionUID = 0;
    final C endpoint;

    public static final class AboveAll extends Cut<Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AboveAll f8801a = null;
        private static final long serialVersionUID = 0;

        static {
            f8801a = new AboveAll();
        }

        private AboveAll() {
            super("");
        }

        public static /* synthetic */ AboveAll access$100() {
            return f8801a;
        }

        private Object readResolve() {
            return f8801a;
        }

        @Override // com.google.common.collect.Cut
        public int compareTo(Cut<Comparable<?>> r5) {
            if (r5 != this) goto L4;
            return 0;
        L4:
            return 1;
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder r5) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder r5) {
            r5.append("+∞)");
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> greatestValueBelow(n2 r5) {
            return r5.maxValue();
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(Comparable<?> r5) {
            return false;
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> leastValueAbove(n2 r5) {
            throw new AssertionError();
        }

        public String toString() {
            return "+∞";
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withLowerBoundType(BoundType r5, n2 r10) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withUpperBoundType(BoundType r5, n2 r10) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r5) {
            return compareTo((Cut) r5);
        }
    }

    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public AboveValue(C r5) {
            r5.getClass();
            super(r5);
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> canonical(n2 r5) {
            Comparable r10 = leastValueAbove(r5);
            if (r10 == null) goto L6;
            return Cut.belowValue(r10);
        L6:
            return Cut.aboveAll();
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r5) {
            return super.compareTo((Cut) r5);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder r5) {
            r5.append('(');
            r5.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder r5) {
            r5.append(this.endpoint);
            r5.append(']');
        }

        @Override // com.google.common.collect.Cut
        public C greatestValueBelow(n2 r5) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(C r5) {
            if (Range.compareOrThrow(this.endpoint, r5) >= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.Cut
        public C leastValueAbove(n2 r5) {
            return (C) r5.next(this.endpoint);
        }

        public String toString() {
            String r5 = String.valueOf(this.endpoint);
            return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 2, "/", r5, "\\");
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withLowerBoundType(BoundType r5, n2 r10) {
            int r11 = k2.f9054a[r5.ordinal()];
            if (r11 != 1) goto L5;
            Comparable r12 = r10.next(this.endpoint);
            if (r12 != null) goto L13;
            return Cut.belowAll();
        L13:
            return Cut.belowValue(r12);
        L5:
            if (r11 != 2) goto L8;
            return this;
        L8:
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withUpperBoundType(BoundType r5, n2 r10) {
            int r11 = k2.f9054a[r5.ordinal()];
            if (r11 != 1) goto L5;
            return this;
        L5:
            if (r11 != 2) goto L12;
            Comparable r12 = r10.next(this.endpoint);
            if (r12 != null) goto L10;
            return Cut.aboveAll();
        L10:
            return Cut.belowValue(r12);
        L12:
            throw new AssertionError();
        }
    }

    public static final class BelowAll extends Cut<Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BelowAll f8802a = null;
        private static final long serialVersionUID = 0;

        static {
            f8802a = new BelowAll();
        }

        private BelowAll() {
            super("");
        }

        public static /* synthetic */ BelowAll access$000() {
            return f8802a;
        }

        private Object readResolve() {
            return f8802a;
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> canonical(n2 r5) {
            return Cut.belowValue(r5.minValue());
        L7:
            return this;
        }

        @Override // com.google.common.collect.Cut
        public int compareTo(Cut<Comparable<?>> r5) {
            if (r5 != this) goto L4;
            return 0;
        L4:
            return -1;
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder r5) {
            r5.append("(-∞");
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder r5) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> greatestValueBelow(n2 r5) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(Comparable<?> r5) {
            return true;
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> leastValueAbove(n2 r5) {
            return r5.minValue();
        }

        public String toString() {
            return "-∞";
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withLowerBoundType(BoundType r5, n2 r10) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withUpperBoundType(BoundType r5, n2 r10) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r5) {
            return compareTo((Cut) r5);
        }
    }

    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public BelowValue(C r5) {
            r5.getClass();
            super(r5);
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r5) {
            return super.compareTo((Cut) r5);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder r5) {
            r5.append('[');
            r5.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder r5) {
            r5.append(this.endpoint);
            r5.append(')');
        }

        @Override // com.google.common.collect.Cut
        public C greatestValueBelow(n2 r5) {
            return (C) r5.previous(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(C r5) {
            if (Range.compareOrThrow(this.endpoint, r5) > 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.Cut
        public C leastValueAbove(n2 r5) {
            return this.endpoint;
        }

        public String toString() {
            String r5 = String.valueOf(this.endpoint);
            return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 2, "\\", r5, "/");
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withLowerBoundType(BoundType r5, n2 r10) {
            int r11 = k2.f9054a[r5.ordinal()];
            if (r11 != 1) goto L5;
            return this;
        L5:
            if (r11 != 2) goto L12;
            Comparable r12 = r10.previous(this.endpoint);
            if (r12 != null) goto L10;
            return Cut.belowAll();
        L10:
            return new AboveValue(r12);
        L12:
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withUpperBoundType(BoundType r5, n2 r10) {
            int r11 = k2.f9054a[r5.ordinal()];
            if (r11 != 1) goto L5;
            Comparable r12 = r10.previous(this.endpoint);
            if (r12 != null) goto L13;
            return Cut.aboveAll();
        L13:
            return new AboveValue(r12);
        L5:
            if (r11 != 2) goto L8;
            return this;
        L8:
            throw new AssertionError();
        }
    }

    public Cut(C r5) {
        this.endpoint = r5;
    }

    public static <C extends Comparable> Cut<C> aboveAll() {
        return AboveAll.access$100();
    }

    public static <C extends Comparable> Cut<C> aboveValue(C r5) {
        return new AboveValue(r5);
    }

    public static <C extends Comparable> Cut<C> belowAll() {
        return BelowAll.access$000();
    }

    public static <C extends Comparable> Cut<C> belowValue(C r5) {
        return new BelowValue(r5);
    }

    public Cut<C> canonical(n2 r5) {
        return this;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r5) {
        return compareTo((Cut) r5);
    }

    public abstract void describeAsLowerBound(StringBuilder r5);

    public abstract void describeAsUpperBound(StringBuilder r5);

    public C endpoint() {
        return this.endpoint;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Cut) == true) goto L10;
        return false;
    L10:
        if (compareTo((Cut) r5) != 0) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public abstract C greatestValueBelow(n2 r5);

    public abstract int hashCode();

    public abstract boolean isLessThan(C r5);

    public abstract C leastValueAbove(n2 r5);

    public abstract BoundType typeAsLowerBound();

    public abstract BoundType typeAsUpperBound();

    public abstract Cut<C> withLowerBoundType(BoundType r5, n2 r10);

    public abstract Cut<C> withUpperBoundType(BoundType r5, n2 r10);

    public int compareTo(Cut<C> r5) {
        if (r5 != belowAll()) goto L6;
        return 1;
    L6:
        if (r5 != aboveAll()) goto L8;
        return -1;
    L8:
        int r10 = Range.compareOrThrow(this.endpoint, r5.endpoint);
        if (r10 == 0) goto L11;
        return r10;
    L11:
        boolean r11 = this instanceof AboveValue;
        if (r11 != (r5 instanceof AboveValue)) goto L14;
        return 0;
    L14:
        if (r11 == false) goto L17;
        return 1;
    L17:
        return -1;
    }
}
