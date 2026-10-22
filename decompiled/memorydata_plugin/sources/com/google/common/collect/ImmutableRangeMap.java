package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements as<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = null;
    private static final long serialVersionUID = 0;
    private final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    private static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        SerializedForm(ImmutableMap<Range<K>, V> r1) {
            this.mapOfRanges = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Object createRangeMap() {
            a r0 = new a();
            bj<Map.Entry<Range<K>, V>> r5 = this.mapOfRanges.entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L7;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            r0.a((Range) ZeusTransformUtils.preCheckCast(r1.getKey(), Range.class, "com.obric.memorydata.plugin"), r1.getValue());
            goto L4
        L7:
            return r0.a();
        }

        Object readResolve() {
            if (this.mapOfRanges.isEmpty() == false) goto L7;
            return ImmutableRangeMap.of();
        L7:
            return createRangeMap();
        }
    }

    public static final class a<K extends Comparable<?>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Map.Entry<Range<K>, V>> f4464a;

        public a() {
            this.f4464a = Lists.a();
        }

        a<K, V> a(a<K, V> r2) {
            this.f4464a.addAll(r2.f4464a);
            return this;
        }

        public a<K, V> a(Range<K> r3, V r4) {
            com.google.common.base.n.a(r3);
            com.google.common.base.n.a(r4);
            com.google.common.base.n.a(!r3.isEmpty(), "Range must not be empty, but was %s", r3);
            this.f4464a.add(Maps.a(r3, r4));
            return this;
        }

        public ImmutableRangeMap<K, V> a() {
            Collections.sort(this.f4464a, Range.rangeLexOrdering().onKeys());
            ImmutableList.a r0 = new ImmutableList.a(this.f4464a.size());
            ImmutableList.a r1 = new ImmutableList.a(this.f4464a.size());
            int r2 = 0;
        L4:
            if (r2 >= this.f4464a.size()) goto L16;
            Range r3 = (Range) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(this.f4464a.get(r2), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Range.class, "com.obric.memorydata.plugin");
            if (r2 <= 0) goto L14;
            Range r4 = (Range) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(this.f4464a.get(r2 - 1), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Range.class, "com.obric.memorydata.plugin");
            if (r3.isConnected(r4) == false) goto L14;
            if (r3.intersection(r4).isEmpty() == true) goto L14;
            throw new IllegalArgumentException("Overlapping ranges: range " + r4 + " overlaps with entry " + r3);
        L14:
            r0.b(r3);
            r1.b(((Map.Entry) ZeusTransformUtils.preCheckCast(this.f4464a.get(r2), Map.Entry.class, "com.obric.memorydata.plugin")).getValue());
            r2 = r2 + 1;
            goto L4
        L16:
            return new ImmutableRangeMap(r0.a(), r1.a());
        }
    }

    static {
        EMPTY = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
    }

    ImmutableRangeMap(ImmutableList<Range<K>> r1, ImmutableList<V> r2) {
        this.ranges = r1;
        this.values = r2;
    }

    static /* synthetic */ ImmutableList access$000(ImmutableRangeMap r0) {
        return r0.ranges;
    }

    public static <K extends Comparable<?>, V> a<K, V> builder() {
        return new a();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(as<K, ? extends V> r6) {
        as r7 = (as) ZeusTransformUtils.wrapperContextForParams(r6, as.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ImmutableRangeMap.class) == true) goto L5;
        Map r8 = r7.asMapOfRanges();
        ImmutableList.a r0 = new ImmutableList.a(r8.size());
        ImmutableList.a r1 = new ImmutableList.a(r8.size());
        Iterator r9 = r8.entrySet().iterator();
    L8:
        if (r9.hasNext() == false) goto L11;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.b((Range) ZeusTransformUtils.preCheckCast(r3.getKey(), Range.class, "com.obric.memorydata.plugin"));
        r1.b(r3.getValue());
        goto L8
    L11:
        return new ImmutableRangeMap(r0.a(), r1.a());
    L5:
        return (ImmutableRangeMap) ZeusTransformUtils.preCheckCast(r7, ImmutableRangeMap.class, "com.obric.memorydata.plugin");
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> r1, V r2) {
        return new ImmutableRangeMap(ImmutableList.of(r1), ImmutableList.of(r2));
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> toImmutableRangeMap(Function<? super T, Range<K>> r2, Function<? super T, ? extends V> r3) {
        return n.c((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin"));
    }

    public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableMap.of();
    L7:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    /* JADX INFO: renamed from: asDescendingMapOfRanges, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Map mo125asDescendingMapOfRanges() {
        return asDescendingMapOfRanges();
    }

    @Override // com.google.common.collect.as
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableMap.of();
    L7:
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    @Override // com.google.common.collect.as
    public /* bridge */ /* synthetic */ Map asMapOfRanges() {
        return asMapOfRanges();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, as.class) == false) goto L6;
        as r4 = (as) ZeusTransformUtils.preCheckCast(r3, as.class, "com.obric.memorydata.plugin");
        return asMapOfRanges().equals(r4.asMapOfRanges());
    L6:
        return false;
    }

    public V get(K r7) {
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r7, Comparable.class, "com.obric.memorydata.plugin");
        int r0 = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(r8), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        if (((Range) ZeusTransformUtils.preCheckCast(this.ranges.get(r0), Range.class, "com.obric.memorydata.plugin")).contains(r8) == true) goto L8;
        return null;
    L8:
        return this.values.get(r0);
    }

    public Map.Entry<Range<K>, V> getEntry(K r7) {
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r7, Comparable.class, "com.obric.memorydata.plugin");
        int r0 = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(r8), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r0 != (-1)) goto L5;
        return null;
    L5:
        Range r1 = (Range) ZeusTransformUtils.preCheckCast(this.ranges.get(r0), Range.class, "com.obric.memorydata.plugin");
        if (r1.contains(r8) == true) goto L8;
        return null;
    L8:
        return Maps.a(r1, this.values.get(r0));
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Deprecated
    public final void merge(Range<K> r1, V r2, BiFunction<? super V, ? super V, ? extends V> r3) {
        BiFunction r0 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r3, BiFunction.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void put(Range<K> r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(as<K, ? extends V> r2) {
        as r1 = (as) ZeusTransformUtils.wrapperContextForParams(r2, as.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putCoalescing(Range<K> r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void remove(Range<K> r1) {
        throw new UnsupportedOperationException();
    }

    public Range<K> span() {
        if (this.ranges.isEmpty() == true) goto L7;
        Range r0 = (Range) ZeusTransformUtils.preCheckCast(this.ranges.get(0), Range.class, "com.obric.memorydata.plugin");
        ImmutableList<Range<K>> r3 = this.ranges;
        return Range.create(r0.lowerBound, ((Range) ZeusTransformUtils.preCheckCast(r3.get(r3.size() - 1), Range.class, "com.obric.memorydata.plugin")).upperBound);
    L7:
        throw new NoSuchElementException();
    }

    public ImmutableRangeMap<K, V> subRangeMap(final Range<K> r10) {
        if (((Range) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r10), Range.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return of();
    L7:
        if (this.ranges.isEmpty() == false) goto L9;
    L17:
        return this;
    L9:
        if (r10.encloses(span()) == true) goto L17;
        final int r0 = SortedLists.a(this.ranges, Range.upperBoundFn(), r10.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        int r1 = SortedLists.a(this.ranges, Range.lowerBoundFn(), r10.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (r0 >= r1) goto L14;
        final int r2 = r1 - r0;
        final ImmutableList<Range<K>> r5 = new AnonymousClass1(this, r2, r0, r10);
        final ImmutableList<V> r6 = this.values.subList(r0, r1);
        return (ImmutableRangeMap<K, V>) new AnonymousClass2(this, r5, r6, r10, this);
    L14:
        return of();
    }

    /* JADX INFO: renamed from: subRangeMap, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ as mo126subRangeMap(Range r1) {
        return subRangeMap(r1);
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }
}
