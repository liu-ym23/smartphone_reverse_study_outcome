package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Ordering<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        IncomparableValueException(Object r3) {
            super("Cannot compare value: " + r3);
            this.value = r3;
        }
    }

    static class a extends Ordering<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentMap<Object, Integer> f4577b;

        a() {
            this.f4576a = new AtomicInteger(0);
            this.f4577b = ar.a(new MapMaker()).g();
        }

        private Integer b(Object r4) {
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.f4577b.get(r4), Integer.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L8;
            Integer r1 = Integer.valueOf(this.f4576a.getAndIncrement());
            Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(this.f4577b.putIfAbsent(r4, r1), Integer.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L7;
            return r1;
        L7:
            return r3;
        L8:
            return r0;
        }

        int a(Object r1) {
            return System.identityHashCode(r1);
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object r5, Object r6) {
            if (r5 != r6) goto L6;
            return 0;
        L6:
            if (r5 != null) goto L9;
            return -1;
        L9:
            if (r6 != null) goto L11;
            return 1;
        L11:
            int r2 = a(r5);
            int r3 = a(r6);
            if (r2 == r3) goto L17;
            if (r2 >= r3) goto L16;
            return -1;
        L16:
            return 1;
        L17:
            int r4 = b(r5).compareTo(b(r6));
            if (r4 == 0) goto L21;
            return r4;
        L21:
            throw new AssertionError();
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Ordering<Object> f4578a = null;

        static {
            f4578a = new a();
        }
    }

    public Ordering() {
    }

    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return b.f4578a;
    }

    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> r2) {
        return new CompoundOrdering((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static <T> Ordering<T> explicit(T r0, T... r1) {
        return explicit(Lists.a(r0, r1));
    }

    public static <T> Ordering<T> explicit(List<T> r2) {
        return new ExplicitOrdering((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> r2) {
        return (Ordering) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r2), Ordering.class, "com.obric.memorydata.plugin");
    }

    public static <T> Ordering<T> from(Comparator<T> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Ordering.class) == false) goto L6;
        return (Ordering) ZeusTransformUtils.preCheckCast(r4, Ordering.class, "com.obric.memorydata.plugin");
    L6:
        return new ComparatorOrdering(r4);
    }

    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    @Deprecated
    public int binarySearch(List<? extends T> r3, T r4) {
        return Collections.binarySearch((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(T r1, T r2);

    public <U extends T> Ordering<U> compound(Comparator<? super U> r4) {
        return new CompoundOrdering(this, (Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin"));
    }

    public <E extends T> List<E> greatestOf(Iterable<E> r3, int r4) {
        Iterable<E> r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        return reverse().leastOf(r5, r4);
    }

    public <E extends T> List<E> greatestOf(Iterator<E> r3, int r4) {
        Iterator<E> r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        return reverse().leastOf(r5, r4);
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> r3) {
        return ImmutableList.sortedCopyOf(this, (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public boolean isOrdered(Iterable<? extends T> r3) {
        Iterator<T> r4 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r4.hasNext() == false) goto L12;
        T r0 = r4.next();
    L6:
        if (r4.hasNext() == false) goto L16;
        T r1 = r4.next();
        if (compare(r0, r1) > 0) goto L9;
        r0 = r1;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> r3) {
        Iterator<T> r4 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r4.hasNext() == false) goto L12;
        T r0 = r4.next();
    L6:
        if (r4.hasNext() == false) goto L16;
        T r1 = r4.next();
        if (compare(r0, r1) >= 0) goto L9;
        r0 = r1;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public <E extends T> List<E> leastOf(Iterable<E> r8, int r9) {
        Iterable r10 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r8, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == false) goto L12;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin");
        if (r0.size() > (((long) r9) * 2)) goto L12;
        Object[] r11 = r0.toArray();
        Arrays.sort(r11, this);
        if (r11.length <= r9) goto L10;
        r11 = Arrays.copyOf(r11, r9);
    L10:
        return Collections.unmodifiableList(Arrays.asList(r11));
    L12:
        return leastOf(r10.iterator(), r9);
    }

    public <E extends T> List<E> leastOf(Iterator<E> r3, int r4) {
        Iterator<? extends T> r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        o.a(r4, "k");
        if (r4 == 0) goto L17;
        if (r5.hasNext() == false) goto L17;
        if (r4 < 1073741823) goto L14;
        ArrayList r6 = Lists.a(r5);
        Collections.sort(r6, this);
        if (r6.size() <= r4) goto L12;
        r6.subList(r4, r6.size()).clear();
    L12:
        r6.trimToSize();
        return Collections.unmodifiableList(r6);
    L14:
        bg r2 = bg.a(r4, this);
        r2.a(r5);
        return r2.a();
    L17:
        return Collections.emptyList();
    }

    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public <E extends T> E max(Iterable<E> r3) {
        return (E) max(((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E max(E r1, E r2) {
        if (compare(r1, r2) < 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    public <E extends T> E max(E r2, E r3, E r4, E... r5) {
        E r6 = (E) max(max(r2, r3), r4);
        int r7 = r5.length;
        int r8 = 0;
    L3:
        if (r8 >= r7) goto L5;
        E r9 = r6;
        r6 = (E) max(r9, r5[r8]);
        r8 = r8 + 1;
        goto L3
    L5:
        return r6;
    }

    public <E extends T> E max(Iterator<E> r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        E r0 = (E) r4.next();
    L4:
        if (r4.hasNext() == false) goto L6;
        E r1 = r0;
        r0 = (E) max(r1, r4.next());
        goto L4
    L6:
        return r0;
    }

    public <E extends T> E min(Iterable<E> r3) {
        return (E) min(((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E min(E r1, E r2) {
        if (compare(r1, r2) > 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    public <E extends T> E min(E r2, E r3, E r4, E... r5) {
        E r6 = (E) min(min(r2, r3), r4);
        int r7 = r5.length;
        int r8 = 0;
    L3:
        if (r8 >= r7) goto L5;
        E r9 = r6;
        r6 = (E) min(r9, r5[r8]);
        r8 = r8 + 1;
        goto L3
    L5:
        return r6;
    }

    public <E extends T> E min(Iterator<E> r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        E r0 = (E) r4.next();
    L4:
        if (r4.hasNext() == false) goto L6;
        E r1 = r0;
        r0 = (E) min(r1, r4.next());
        goto L4
    L6:
        return r0;
    }

    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps.a());
    }

    public <F> Ordering<F> onResultOf(com.google.common.base.g<F, ? extends T> r3) {
        return new ByFunctionOrdering((com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin"), this);
    }

    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> r3) {
        Object[] r4 = aj.c((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
        Arrays.sort(r4, this);
        return Lists.a(Arrays.asList(r4));
    }
}
