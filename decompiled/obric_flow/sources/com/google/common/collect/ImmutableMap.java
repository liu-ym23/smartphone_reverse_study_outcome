package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient ImmutableSet f8820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ImmutableSet f8821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient ImmutableCollection f8822c;
    public transient ImmutableSetMultimap d;

    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        public IteratorBasedImmutableMap() {
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new C1EntrySetImpl(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        public abstract ga entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        public Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return Spliterators.spliterator(entryIterator(), size(), 1297);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
        final /* synthetic */ ImmutableMap this$0;

        public MapViewOfValuesAsSingletonSets(ImmutableMap r5, w3 r10) {
            this.this$0 = r5;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(Object r5) {
            return this.this$0.containsKey(r5);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return this.this$0.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public ga entryIterator() {
            return new z3(this.this$0.entrySet().iterator());
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(Object r5) {
            return get(r5);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return this.this$0.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return this.this$0.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return this.this$0.size();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(Object r5) {
            Object r10 = this.this$0.get(r5);
            if (r10 != null) goto L6;
            return null;
        L6:
            return ImmutableSet.of(r10);
        }
    }

    public static class SerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        public SerializedForm(ImmutableMap<K, V> r10) {
            Object[] r5 = new Object[r10.size()];
            Object[] r11 = new Object[r10.size()];
            ga r12 = r10.entrySet().iterator();
            int r13 = 0;
        L4:
            if (r12.hasNext() == false) goto L6;
            Map.Entry r14 = (Map.Entry) r12.next();
            r5[r13] = r14.getKey();
            r11[r13] = r14.getValue();
            r13 = r13 + 1;
            goto L4
        L6:
            this.keys = r5;
            this.values = r11;
        }

        public final Object legacyReadResolve() {
            Object[] r5 = (Object[]) this.keys;
            Object[] r10 = (Object[]) this.values;
            x3 r11 = makeBuilder(r5.length);
            int r12 = 0;
        L4:
            if (r12 >= r5.length) goto L7;
            r11.g(r5[r12], r10[r12]);
            r12 = r12 + 1;
            goto L4
        L7:
            return r11.d();
        }

        public x3 makeBuilder(int r5) {
            return new x3(r5);
        }

        public final Object readResolve() {
            Object r5 = this.keys;
            if ((r5 instanceof ImmutableSet) == false) goto L5;
            ImmutableSet r10 = (ImmutableSet) r5;
            ImmutableCollection r11 = (ImmutableCollection) this.values;
            x3 r12 = makeBuilder(r10.size());
            ga r13 = r10.iterator();
            ga r14 = r11.iterator();
        L8:
            if (r13.hasNext() == false) goto L11;
            r12.g(r13.next(), r14.next());
            goto L8
        L11:
            return r12.d();
        L5:
            return legacyReadResolve();
        }
    }

    static {
        EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    }

    public ImmutableMap() {
    }

    public static <K, V> x3 builder() {
        return new x3(4);
    }

    public static <K, V> x3 builderWithExpectedSize(int r5) {
        p7.q(r5, "expectedSize");
        return new x3(r5);
    }

    public static void checkNoConflict(boolean r5, String r10, Object r11, Object r12) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw conflictException(r10, r11, r12);
    }

    public static IllegalArgumentException conflictException(String r5, Object r10, Object r11) {
        String r12 = String.valueOf(r10);
        String r13 = String.valueOf(r11);
        int r14 = androidx.room.jarjarred.org.antlr.runtime.a.g(34, r5);
        int r15 = r12.length() + r14;
        StringBuilder r16 = new StringBuilder(r13.length() + r15);
        r16.append("Multiple entries with same ");
        r16.append(r5);
        r16.append(": ");
        r16.append(r12);
        return new IllegalArgumentException(ai.j0.q(r16, " and ", r13));
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> r5) {
        if ((r5 instanceof ImmutableMap) == false) goto L10;
        if ((r5 instanceof SortedMap) == true) goto L10;
        ImmutableMap<K, V> r10 = (ImmutableMap) r5;
        if (r10.isPartialView() == true) goto L18;
        return r10;
    L18:
        return copyOf(r5.entrySet());
    L10:
        if ((r5 instanceof EnumMap) == false) goto L18;
        EnumMap r11 = new EnumMap((EnumMap) r5);
        Iterator r12 = r11.entrySet().iterator();
    L13:
        if (r12.hasNext() == false) goto L16;
        Map.Entry r13 = (Map.Entry) r12.next();
        p7.p(r13.getKey(), r13.getValue());
        goto L13
    L16:
        return ImmutableEnumMap.asImmutable(r11);
    }

    public static <K, V> Map.Entry<K, V> entryOf(K r5, V r10) {
        return new ImmutableMapEntry(r5, r10);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    @SafeVarargs
    public static <K, V> ImmutableMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... r5) {
        return RegularImmutableMap.fromEntries(r5);
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> r5, Function<? super T, ? extends V> r10) {
        Collector r11 = n1.f9084a;
        r5.getClass();
        r10.getClass();
        return Collector.of(new i1(7), new g1(r5, r10, 1), new e1(6), new h(12), new Collector.Characteristics[0]);
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty() == true) goto L5;
        ImmutableSetMultimap<K, V> r5 = this.d;
        if (r5 != null) goto L10;
        ImmutableSetMultimap<K, V> r10 = new ImmutableSetMultimap(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.d = r10;
        return r10;
    L10:
        return r5;
    L5:
        return ImmutableSetMultimap.of();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V compute(K r5, BiFunction<? super K, ? super V, ? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V computeIfAbsent(K r5, Function<? super K, ? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V computeIfPresent(K r5, BiFunction<? super K, ? super V, ? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object r5) {
        if (get(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object r5) {
        return values().contains(r5);
    }

    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract ImmutableSet<K> createKeySet();

    public abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if ((r5 instanceof Map) == true) goto L10;
        return false;
    L10:
        return entrySet().equals(((Map) r5).entrySet());
    }

    @Override // java.util.Map
    public abstract V get(Object r5);

    @Override // java.util.Map
    public final V getOrDefault(Object r5, V r10) {
        V r11 = get(r5);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return r10;
    }

    @Override // java.util.Map
    public int hashCode() {
        return p7.J(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public ga keyIterator() {
        return new w3(entrySet().iterator());
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    public Spliterator<K> keySpliterator() {
        return p7.R(entrySet().spliterator(), new h(19));
    }

    @Override // java.util.Map
    @Deprecated
    public final V merge(K r5, V r10, BiFunction<? super V, ? super V, ? extends V> r11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V putIfAbsent(K r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean replace(K r5, V r10, V r11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void replaceAll(BiFunction<? super K, ? super V, ? extends V> r5) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return p7.v0(this);
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K r5, V r10) {
        return ImmutableBiMap.of(r5, r10);
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> r5 = this.f8820a;
        if (r5 != null) goto L6;
        ImmutableSet<Map.Entry<K, V>> r10 = createEntrySet();
        this.f8820a = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> r5 = this.f8821b;
        if (r5 != null) goto L6;
        ImmutableSet<K> r10 = createKeySet();
        this.f8821b = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean remove(Object r5, Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V replace(K r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> r5 = this.f8822c;
        if (r5 != null) goto L6;
        ImmutableCollection<V> r10 = createValues();
        this.f8822c = r10;
        return r10;
    L6:
        return r5;
    }

    public static <K, V> ImmutableMap<K, V> of(K r5, V r10, K r11, V r12) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r5, r10), entryOf(r11, r12)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r5, r10), entryOf(r11, r12), entryOf(r13, r14)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r5, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16)});
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> r5, Function<? super T, ? extends V> r10, BinaryOperator<V> r11) {
        Collector r12 = n1.f9084a;
        r5.getClass();
        r10.getClass();
        r11.getClass();
        return Collectors.collectingAndThen(Collectors.toMap(r5, r10, r11, new i1(10)), new h(16));
    }

    public static <K, V> ImmutableMap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r5, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r110) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r5, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r110)});
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r5) {
        Map.Entry<?, ?>[] r10 = EMPTY_ENTRY_ARRAY;
        if ((r5 instanceof Collection) == false) goto L5;
        Collection r11 = (Collection) r5;
    L6:
        Map.Entry[] r12 = (Map.Entry[]) r11.toArray(r10);
        int r13 = r12.length;
        if (r13 == 0) goto L15;
        if (r13 != 1) goto L11;
        Map.Entry r14 = r12[0];
        Objects.requireNonNull(r14);
        return of(r14.getKey(), r14.getValue());
    L11:
        return RegularImmutableMap.fromEntries(r12);
    L15:
        return of();
    L5:
        r11 = p7.V(r5.iterator());
        goto L6
    }

    public static <K, V> ImmutableMap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r110, K r111, V r112) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r5, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r110), entryOf(r111, r112)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r5, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r110, K r111, V r112, K r113, V r114) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r5, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r110), entryOf(r111, r112), entryOf(r113, r114)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r20, K r21, V r22, K r23, V r24, K r25, V r26, K r27, V r28) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r20), entryOf(r21, r22), entryOf(r23, r24), entryOf(r25, r26), entryOf(r27, r28)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r12, V r13, K r14, V r15, K r16, V r17, K r18, V r19, K r20, V r21, K r22, V r23, K r24, V r25, K r26, V r27, K r28, V r29, K r30, V r31) {
        return RegularImmutableMap.fromEntries(new Map.Entry[]{entryOf(r12, r13), entryOf(r14, r15), entryOf(r16, r17), entryOf(r18, r19), entryOf(r20, r21), entryOf(r22, r23), entryOf(r24, r25), entryOf(r26, r27), entryOf(r28, r29), entryOf(r30, r31)});
    }
}
