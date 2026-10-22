package com.google.common.collect;

import com.google.common.primitives.Booleans;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.Comparable;

/* JADX INFO: loaded from: classes2.dex */
abstract class Cut<C extends Comparable> implements Serializable, Comparable<Cut<C>> {
    private static final long serialVersionUID = 0;
    final C endpoint;

    /* JADX INFO: renamed from: com.google.common.collect.Cut$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4425a = null;

        static {
            int[] r0 = new int[BoundType.values().length];
            f4425a = r0;
            r0[BoundType.CLOSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f4425a[BoundType.OPEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static final class AboveAll extends Cut<Comparable<?>> {
        private static final AboveAll INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new AboveAll();
        }

        private AboveAll() {
            super("");
        }

        static /* synthetic */ AboveAll access$100() {
            return INSTANCE;
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.Cut
        public int compareTo(Cut<Comparable<?>> r1) {
            if (r1 != this) goto L4;
            return 0;
        L4:
            return 1;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* synthetic */ int compareTo(Object r3) {
            return compareTo((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder r1) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder r1) {
            r1.append("+∞)");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> r1) {
            return r1.maxValue();
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(Comparable<?> r2) {
            Comparable r1 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
            return false;
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> r1) {
            throw new AssertionError();
        }

        public String toString() {
            return "+∞";
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withLowerBoundType(BoundType r1, DiscreteDomain<Comparable<?>> r2) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withUpperBoundType(BoundType r1, DiscreteDomain<Comparable<?>> r2) {
            throw new IllegalStateException();
        }
    }

    private static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        AboveValue(C r3) {
            super((Comparable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin")), Comparable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Cut
        Cut<C> canonical(DiscreteDomain<C> r1) {
            Comparable r0 = leastValueAbove(r1);
            if (r0 == null) goto L6;
            return belowValue(r0);
        L6:
            return Cut.aboveAll();
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* synthetic */ int compareTo(Object r3) {
            return super.compareTo((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder r2) {
            r2.append('(').append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder r1) {
            r1.append(this.endpoint).append(']');
        }

        @Override // com.google.common.collect.Cut
        C greatestValueBelow(DiscreteDomain<C> r1) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(C r3) {
            Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            if (Range.compareOrThrow(this.endpoint, r4) >= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.Cut
        C leastValueAbove(DiscreteDomain<C> r1) {
            return (C) r1.next(this.endpoint);
        }

        public String toString() {
            return "/" + this.endpoint + "\\";
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> withLowerBoundType(BoundType r2, DiscreteDomain<C> r3) {
            int r4 = AnonymousClass1.f4425a[r2.ordinal()];
            if (r4 != 1) goto L5;
            Comparable r1 = r3.next(this.endpoint);
            if (r1 != null) goto L13;
            return Cut.belowAll();
        L13:
            return belowValue(r1);
        L5:
            if (r4 != 2) goto L8;
            return this;
        L8:
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Cut<C> withUpperBoundType(BoundType r2, DiscreteDomain<C> r3) {
            int r4 = AnonymousClass1.f4425a[r2.ordinal()];
            if (r4 != 1) goto L5;
            return this;
        L5:
            if (r4 != 2) goto L12;
            Comparable r1 = r3.next(this.endpoint);
            if (r1 != null) goto L10;
            return Cut.aboveAll();
        L10:
            return belowValue(r1);
        L12:
            throw new AssertionError();
        }
    }

    private static final class BelowAll extends Cut<Comparable<?>> {
        private static final BelowAll INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new BelowAll();
        }

        private BelowAll() {
            super("");
        }

        static /* synthetic */ BelowAll access$000() {
            return INSTANCE;
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> canonical(DiscreteDomain<Comparable<?>> r1) {
            return Cut.belowValue(r1.minValue());
        L7:
            return this;
        }

        @Override // com.google.common.collect.Cut
        public int compareTo(Cut<Comparable<?>> r1) {
            if (r1 != this) goto L4;
            return 0;
        L4:
            return -1;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* synthetic */ int compareTo(Object r3) {
            return compareTo((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder r1) {
            r1.append("(-∞");
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder r1) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> r1) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(Comparable<?> r2) {
            Comparable r1 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
            return true;
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> r1) {
            return r1.minValue();
        }

        public String toString() {
            return "-∞";
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withLowerBoundType(BoundType r1, DiscreteDomain<Comparable<?>> r2) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> withUpperBoundType(BoundType r1, DiscreteDomain<Comparable<?>> r2) {
            throw new AssertionError("this statement should be unreachable");
        }
    }

    private static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        BelowValue(C r3) {
            super((Comparable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin")), Comparable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* synthetic */ int compareTo(Object r3) {
            return super.compareTo((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Cut
        void describeAsLowerBound(StringBuilder r2) {
            r2.append('[').append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        void describeAsUpperBound(StringBuilder r1) {
            r1.append(this.endpoint).append(')');
        }

        @Override // com.google.common.collect.Cut
        C greatestValueBelow(DiscreteDomain<C> r1) {
            return (C) r1.previous(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        boolean isLessThan(C r3) {
            Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            if (Range.compareOrThrow(this.endpoint, r4) > 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.Cut
        C leastValueAbove(DiscreteDomain<C> r1) {
            return this.endpoint;
        }

        public String toString() {
            return "\\" + this.endpoint + "/";
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsLowerBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        BoundType typeAsUpperBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> withLowerBoundType(BoundType r2, DiscreteDomain<C> r3) {
            int r4 = AnonymousClass1.f4425a[r2.ordinal()];
            if (r4 != 1) goto L5;
            return this;
        L5:
            if (r4 != 2) goto L12;
            Comparable r1 = r3.previous(this.endpoint);
            if (r1 != null) goto L10;
            return Cut.belowAll();
        L10:
            return new AboveValue(r1);
        L12:
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Cut<C> withUpperBoundType(BoundType r2, DiscreteDomain<C> r3) {
            int r4 = AnonymousClass1.f4425a[r2.ordinal()];
            if (r4 != 1) goto L5;
            Comparable r1 = r3.previous(this.endpoint);
            if (r1 != null) goto L13;
            return Cut.aboveAll();
        L13:
            return new AboveValue(r1);
        L5:
            if (r4 != 2) goto L8;
            return this;
        L8:
            throw new AssertionError();
        }
    }

    Cut(C r3) {
        this.endpoint = (C) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
    }

    static <C extends Comparable> Cut<C> aboveAll() {
        return AboveAll.access$100();
    }

    static <C extends Comparable> Cut<C> aboveValue(C r2) {
        return new AboveValue((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin"));
    }

    static <C extends Comparable> Cut<C> belowAll() {
        return BelowAll.access$000();
    }

    static <C extends Comparable> Cut<C> belowValue(C r2) {
        return new BelowValue((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin"));
    }

    Cut<C> canonical(DiscreteDomain<C> r1) {
        return this;
    }

    public int compareTo(Cut<C> r3) {
        if (r3 != belowAll()) goto L7;
        return 1;
    L7:
        if (r3 != aboveAll()) goto L10;
        return -1;
    L10:
        int r0 = Range.compareOrThrow(this.endpoint, r3.endpoint);
        if (r0 == 0) goto L14;
        return r0;
    L14:
        return Booleans.a(ZeusTransformUtils.instanceOf(this, AboveValue.class), ZeusTransformUtils.instanceOf(r3, AboveValue.class));
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r3) {
        return compareTo((Cut) ZeusTransformUtils.preCheckCast(r3, Cut.class, "com.obric.memorydata.plugin"));
    }

    abstract void describeAsLowerBound(StringBuilder r1);

    abstract void describeAsUpperBound(StringBuilder r1);

    C endpoint() {
        return this.endpoint;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Cut.class) == true) goto L10;
        return false;
    L10:
        if (compareTo((Cut) ZeusTransformUtils.preCheckCast(r4, Cut.class, "com.obric.memorydata.plugin")) != 0) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    abstract C greatestValueBelow(DiscreteDomain<C> r1);

    public abstract int hashCode();

    abstract boolean isLessThan(C r1);

    abstract C leastValueAbove(DiscreteDomain<C> r1);

    abstract BoundType typeAsLowerBound();

    abstract BoundType typeAsUpperBound();

    abstract Cut<C> withLowerBoundType(BoundType r1, DiscreteDomain<C> r2);

    abstract Cut<C> withUpperBoundType(BoundType r1, DiscreteDomain<C> r2);
}
