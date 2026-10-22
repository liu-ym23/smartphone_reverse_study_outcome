package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableBiMapFauxverideShim<K, V> implements c1 {

    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        public SerializedForm(ImmutableBiMap<K, V> r5) {
            super(r5);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public /* bridge */ /* synthetic */ x3 makeBuilder(int r5) {
            return makeBuilder(r5);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public p3 makeBuilder(int r5) {
            return new p3(r5);
        }
    }

    public ImmutableBiMap() {
    }

    public static <K, V> p3 builder() {
        return new p3(4);
    }

    public static <K, V> p3 builderWithExpectedSize(int r5) {
        p7.q(r5, "expectedSize");
        return new p3(r5);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> r5) {
        if ((r5 instanceof ImmutableBiMap) == false) goto L8;
        ImmutableBiMap<K, V> r10 = (ImmutableBiMap) r5;
        if (r10.isPartialView() == true) goto L8;
        return r10;
    L8:
        return copyOf(r5.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... r5) {
        return RegularImmutableBiMap.fromEntries(r5);
    }

    public static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> toImmutableBiMap(Function<? super T, ? extends K> r5, Function<? super T, ? extends V> r10) {
        Collector r11 = n1.f9084a;
        r5.getClass();
        r10.getClass();
        return Collector.of(new i1(11), new g1(r5, r10, 6), new e1(0), new h(3), new Collector.Characteristics[0]);
    }

    @Override // com.google.common.collect.ImmutableMap
    public /* bridge */ /* synthetic */ ImmutableCollection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.c1
    @Deprecated
    public final V forcePut(K r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c1
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.c1
    public /* bridge */ /* synthetic */ c1 inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ ImmutableCollection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r5, V r10) {
        return new SingletonImmutableBiMap(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r5, V r10, K r11, V r12) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12)});
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return values();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14)});
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r5) {
        Map.Entry<?, ?>[] r10 = ImmutableMap.EMPTY_ENTRY_ARRAY;
        if ((r5 instanceof Collection) == false) goto L5;
        Collection r11 = (Collection) r5;
    L6:
        Map.Entry[] r12 = (Map.Entry[]) r11.toArray(r10);
        int r13 = r12.length;
        if (r13 == 0) goto L15;
        if (r13 != 1) goto L11;
        Map.Entry r14 = r12[0];
        return of(r14.getKey(), r14.getValue());
    L11:
        return RegularImmutableBiMap.fromEntries(r12);
    L15:
        return of();
    L5:
        r11 = p7.V(r5.iterator());
        goto L6
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14), ImmutableMap.entryOf(r15, r16)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14), ImmutableMap.entryOf(r15, r16), ImmutableMap.entryOf(r17, r18)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r110) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14), ImmutableMap.entryOf(r15, r16), ImmutableMap.entryOf(r17, r18), ImmutableMap.entryOf(r19, r110)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r110, K r111, V r112) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14), ImmutableMap.entryOf(r15, r16), ImmutableMap.entryOf(r17, r18), ImmutableMap.entryOf(r19, r110), ImmutableMap.entryOf(r111, r112)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r110, K r111, V r112, K r113, V r114) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{ImmutableMap.entryOf(r5, r10), ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14), ImmutableMap.entryOf(r15, r16), ImmutableMap.entryOf(r17, r18), ImmutableMap.entryOf(r19, r110), ImmutableMap.entryOf(r111, r112), ImmutableMap.entryOf(r113, r114)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r20, K r21, V r22, K r23, V r24, K r25, V r26, K r27, V r28) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{ImmutableMap.entryOf(r11, r12), ImmutableMap.entryOf(r13, r14), ImmutableMap.entryOf(r15, r16), ImmutableMap.entryOf(r17, r18), ImmutableMap.entryOf(r19, r20), ImmutableMap.entryOf(r21, r22), ImmutableMap.entryOf(r23, r24), ImmutableMap.entryOf(r25, r26), ImmutableMap.entryOf(r27, r28)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r12, V r13, K r14, V r15, K r16, V r17, K r18, V r19, K r20, V r21, K r22, V r23, K r24, V r25, K r26, V r27, K r28, V r29, K r30, V r31) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{ImmutableMap.entryOf(r12, r13), ImmutableMap.entryOf(r14, r15), ImmutableMap.entryOf(r16, r17), ImmutableMap.entryOf(r18, r19), ImmutableMap.entryOf(r20, r21), ImmutableMap.entryOf(r22, r23), ImmutableMap.entryOf(r24, r25), ImmutableMap.entryOf(r26, r27), ImmutableMap.entryOf(r28, r29), ImmutableMap.entryOf(r30, r31)});
    }
}
