package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements k8, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ImmutableRangeMap f8831c = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ImmutableList f8832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient ImmutableList f8833b;

    public static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        public SerializedForm(ImmutableMap<Range<K>, V> r5) {
            this.mapOfRanges = r5;
        }

        public Object createRangeMap() {
            j4 r5 = new j4();
            ga r10 = this.mapOfRanges.entrySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L7;
            Map.Entry r11 = (Map.Entry) r10.next();
            r5.b((Range) r11.getKey(), r11.getValue());
            goto L4
        L7:
            return r5.a();
        }

        public Object readResolve() {
            if (this.mapOfRanges.isEmpty() == false) goto L7;
            return ImmutableRangeMap.of();
        L7:
            return createRangeMap();
        }
    }

    static {
        f8831c = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
    }

    public ImmutableRangeMap(ImmutableList<Range<K>> r5, ImmutableList<V> r10) {
        this.f8832a = r5;
        this.f8833b = r10;
    }

    public static /* synthetic */ ImmutableList access$000(ImmutableRangeMap r5) {
        return r5.f8832a;
    }

    public static <K extends Comparable<?>, V> j4 builder() {
        return new j4();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(k8 r11) {
        if ((r11 instanceof ImmutableRangeMap) == true) goto L5;
        Map r12 = r11.asMapOfRanges();
        Object[] r5 = new Object[r12.size()];
        Object[] r10 = new Object[r12.size()];
        Iterator r13 = r12.entrySet().iterator();
        int r14 = 0;
        boolean r15 = false;
        int r16 = 0;
        boolean r17 = false;
    L8:
        if (r13.hasNext() == false) goto L23;
        Map.Entry r18 = (Map.Entry) r13.next();
        Range r19 = (Range) r18.getKey();
        r19.getClass();
        int r20 = r14 + 1;
        if (r5.length >= r20) goto L13;
        r5 = Arrays.copyOf(r5, p7.B(r5.length, r20));
    L12:
        r15 = false;
    L15:
        int r21 = r14 + 1;
        r5[r14] = r19;
        Object r22 = r18.getValue();
        r22.getClass();
        int r23 = r16 + 1;
        if (r10.length >= r23) goto L19;
        r10 = Arrays.copyOf(r10, p7.B(r10.length, r23));
    L18:
        r17 = false;
    L21:
        r10[r16] = r22;
        r16 = r16 + 1;
        r14 = r21;
        goto L8
    L19:
        if (r17 == false) goto L21;
        r10 = Arrays.copyOf(r10, r10.length);
        goto L18
    L13:
        if (r15 == false) goto L15;
        r5 = Arrays.copyOf(r5, r5.length);
        goto L12
    L23:
        return new ImmutableRangeMap(ImmutableList.asImmutableList(r5, r14), ImmutableList.asImmutableList(r10, r16));
    L5:
        return (ImmutableRangeMap) r11;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return f8831c;
    }

    public static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> toImmutableRangeMap(Function<? super T, Range<K>> r5, Function<? super T, ? extends V> r10) {
        Collector r11 = n1.f9084a;
        r5.getClass();
        r10.getClass();
        return Collector.of(new i1(2), new g1(r5, r10, 0), new e1(4), new h(11), new Collector.Characteristics[0]);
    }

    /* JADX INFO: renamed from: asDescendingMapOfRanges, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Map mo92asDescendingMapOfRanges() {
        return asDescendingMapOfRanges();
    }

    @Override // com.google.common.collect.k8
    public /* bridge */ /* synthetic */ Map asMapOfRanges() {
        return asMapOfRanges();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof k8) == true) goto L5;
        return false;
    L5:
        return asMapOfRanges().equals(((k8) r5).asMapOfRanges());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V get(K r10) {
        com.google.common.base.q r5 = Range.lowerBoundFn();
        Cut r11 = Cut.belowValue(r10);
        SortedLists$KeyPresentBehavior r12 = SortedLists$KeyPresentBehavior.ANY_PRESENT;
        SortedLists$KeyAbsentBehavior r13 = SortedLists$KeyAbsentBehavior.NEXT_LOWER;
        ImmutableList r14 = this.f8832a;
        int r15 = p7.l(r14, r5, r11, r12, r13);
        if (r15 != (-1)) goto L6;
        return null;
    L6:
        if (((Range) r14.get(r15)).contains(r10) == true) goto L8;
        return null;
    L8:
        return (V) this.f8833b.get(r15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map.Entry<Range<K>, V> getEntry(K r10) {
        com.google.common.base.q r5 = Range.lowerBoundFn();
        Cut r11 = Cut.belowValue(r10);
        SortedLists$KeyPresentBehavior r12 = SortedLists$KeyPresentBehavior.ANY_PRESENT;
        SortedLists$KeyAbsentBehavior r13 = SortedLists$KeyAbsentBehavior.NEXT_LOWER;
        ImmutableList r14 = this.f8832a;
        int r15 = p7.l(r14, r5, r11, r12, r13);
        if (r15 != (-1)) goto L5;
        return null;
    L5:
        Range r16 = (Range) r14.get(r15);
        if (r16.contains(r10) == true) goto L8;
        return null;
    L8:
        return p7.L(r16, this.f8833b.get(r15));
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Deprecated
    public final void merge(Range<K> r5, V r10, BiFunction<? super V, ? super V, ? extends V> r11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void put(Range<K> r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(k8 r5) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putCoalescing(Range<K> r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void remove(Range<K> r5) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Range<K> span() {
        ImmutableList r5 = this.f8832a;
        if (r5.isEmpty() == true) goto L7;
        return Range.create(((Range) r5.get(0)).lowerBound, ((Range) r5.get(r5.size() - 1)).upperBound);
    L7:
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: subRangeMap, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ k8 mo93subRangeMap(Range r5) {
        return subRangeMap(r5);
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    public Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> r5, V r10) {
        return new ImmutableRangeMap(ImmutableList.of(r5), ImmutableList.of(r10));
    }

    public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
        ImmutableList r5 = this.f8832a;
        if (r5.isEmpty() == false) goto L7;
        return ImmutableMap.of();
    L7:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(r5.reverse(), Range.rangeLexOrdering().reverse()), this.f8833b.reverse());
    }

    @Override // com.google.common.collect.k8
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        ImmutableList r5 = this.f8832a;
        if (r5.isEmpty() == false) goto L7;
        return ImmutableMap.of();
    L7:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(r5, Range.rangeLexOrdering()), this.f8833b);
    }

    public ImmutableRangeMap<K, V> subRangeMap(final Range<K> r10) {
        r10.getClass();
        if (r10.isEmpty() == true) goto L5;
        ImmutableList r5 = this.f8832a;
        if (r5.isEmpty() == false) goto L9;
    L17:
        return this;
    L9:
        if (r10.encloses(span()) == true) goto L17;
        com.google.common.base.q r11 = Range.upperBoundFn();
        Comparable r12 = r10.lowerBound;
        SortedLists$KeyPresentBehavior r13 = SortedLists$KeyPresentBehavior.FIRST_AFTER;
        SortedLists$KeyAbsentBehavior r14 = SortedLists$KeyAbsentBehavior.NEXT_HIGHER;
        final int r15 = p7.l(r5, r11, r12, r13, r14);
        int r16 = p7.l(r5, Range.lowerBoundFn(), r10.upperBound, SortedLists$KeyPresentBehavior.ANY_PRESENT, r14);
        if (r15 >= r16) goto L14;
        final int r17 = r16 - r15;
        final ImmutableList<Range<K>> r18 = new AnonymousClass1(this, r17, r15, r10);
        final ImmutableList r19 = this.f8833b.subList(r15, r16);
        return (ImmutableRangeMap<K, V>) new AnonymousClass2(this, r18, r19, r10, this);
    L14:
        return of();
    L5:
        return of();
    }
}
