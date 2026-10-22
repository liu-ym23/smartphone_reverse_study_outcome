package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final RegularImmutableBiMap<Object, Object> EMPTY = null;
    static final double MAX_LOAD_FACTOR = 1.2d;
    public final transient ImmutableMapEntry[] e;
    final transient Map.Entry<K, V>[] entries;
    public final transient ImmutableMapEntry[] f;
    public final transient int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final transient int f8856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient ImmutableBiMap f8857i;

    public final class Inverse extends ImmutableBiMap<V, K> {
        final /* synthetic */ RegularImmutableBiMap this$0;

        public final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {
            final /* synthetic */ Inverse this$1;

            public InverseEntrySet(Inverse r5) {
                this.this$1 = r5;
            }

            @Override // com.google.common.collect.ImmutableSet.CachingAsList
            public ImmutableList<Map.Entry<V, K>> createAsList() {
                return new AnonymousClass1(this);
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Map.Entry<V, K>> r5) {
                asList().forEach(r5);
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet, com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
            public int hashCode() {
                return RegularImmutableBiMap.access$300(this.this$1.this$0);
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet, com.google.common.collect.ImmutableSet
            public boolean isHashCodeFast() {
                return true;
            }

            @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public /* bridge */ /* synthetic */ Iterator iterator() {
                return iterator();
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            public ImmutableMap<V, K> map() {
                return this.this$1;
            }

            @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public ga iterator() {
                return asList().iterator();
            }
        }

        public Inverse(RegularImmutableBiMap r5, o8 r10) {
            this.this$0 = r5;
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<V, K>> createEntrySet() {
            return new InverseEntrySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<V> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super V, ? super K> r5) {
            r5.getClass();
            this.this$0.forEach(new h3(r5, 3));
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public K get(Object r5) {
            if (r5 != null) goto L5;
        L14:
            return null;
        L5:
            if (RegularImmutableBiMap.access$100(this.this$0) == null) goto L14;
            int r10 = p7.n0(r5.hashCode()) & RegularImmutableBiMap.access$200(this.this$0);
            ImmutableMapEntry r11 = RegularImmutableBiMap.access$100(this.this$0)[r10];
        L8:
            if (r11 == null) goto L14;
            if (r5.equals(r11.getValue()) == true) goto L12;
            r11 = r11.getNextInValueBucket();
            goto L8
        L12:
            return r11.getKey();
        }

        @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.c1
        public /* bridge */ /* synthetic */ c1 inverse() {
            return inverse();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.Map
        public int size() {
            return inverse().size();
        }

        @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.ImmutableMap
        public Object writeReplace() {
            return new InverseSerializedForm(this.this$0);
        }

        @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.c1
        public ImmutableBiMap<K, V> inverse() {
            return this.this$0;
        }
    }

    public static class InverseSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        private final ImmutableBiMap<K, V> forward;

        public InverseSerializedForm(ImmutableBiMap<K, V> r5) {
            this.forward = r5;
        }

        public Object readResolve() {
            return this.forward.inverse();
        }
    }

    static {
        EMPTY = new RegularImmutableBiMap(null, null, ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
    }

    public RegularImmutableBiMap(ImmutableMapEntry[] r5, ImmutableMapEntry[] r10, Map.Entry[] r11, int r12, int r13) {
        this.e = r5;
        this.f = r10;
        this.entries = r11;
        this.g = r12;
        this.f8856h = r13;
    }

    public static /* synthetic */ ImmutableMapEntry[] access$100(RegularImmutableBiMap r5) {
        return r5.f;
    }

    public static /* synthetic */ int access$200(RegularImmutableBiMap r5) {
        return r5.g;
    }

    public static /* synthetic */ int access$300(RegularImmutableBiMap r5) {
        return r5.f8856h;
    }

    public static <K, V> ImmutableBiMap<K, V> fromEntries(Map.Entry<K, V>... r5) {
        return fromEntryArray(r5.length, r5);
    }

    public static <K, V> ImmutableBiMap<K, V> fromEntryArray(int r20, Map.Entry<K, V>[] r21) {
        int r5 = r20;
        Map.Entry<K, V>[] r10 = r21;
        com.google.common.base.b0.o(r5, r10.length);
        int r11 = p7.v(MAX_LOAD_FACTOR, r5);
        int r12 = r11 - 1;
        ImmutableMapEntry[] r13 = ImmutableMapEntry.createEntryArray(r11);
        ImmutableMapEntry[] r14 = ImmutableMapEntry.createEntryArray(r11);
        if (r5 != r10.length) goto L5;
        Map.Entry<K, V>[] r15 = r10;
    L6:
        int r16 = 0;
        int r17 = 0;
    L7:
        if (r16 >= r5) goto L25;
        Map.Entry<K, V> r18 = r10[r16];
        Objects.requireNonNull(r18);
        K r19 = r18.getKey();
        V r110 = r18.getValue();
        p7.p(r19, r110);
        int r111 = r19.hashCode();
        int r112 = r110.hashCode();
        int r113 = p7.n0(r111) & r12;
        int r114 = p7.n0(r112) & r12;
        ImmutableMapEntry r22 = r13[r113];
        ImmutableMapEntry r23 = r14[r114];
        RegularImmutableMap.checkNoConflictInKeyBucket(r19, r110, r22, true);     // Catch: RegularImmutableMap.BucketOverflowException -> L22
        ImmutableMapEntry r24 = r23;
        int r115 = 0;
    L10:
        if (r24 == null) goto L16;
        int r116 = r12;
        int r117 = r17;
        ImmutableMap.checkNoConflict(!r110.equals(r24.getValue()), "value", r18, r24);     // Catch: RegularImmutableMap.BucketOverflowException -> L22
        int r25 = r115 + 1;     // Catch: RegularImmutableMap.BucketOverflowException -> L22
        if (r25 > 8) goto L15;
        r24 = r24.getNextInValueBucket();     // Catch: RegularImmutableMap.BucketOverflowException -> L22
        r115 = r25;
        r12 = r116;
        r17 = r117;
        goto L10
    L15:
        throw new RegularImmutableMap.BucketOverflowException();     // Catch: RegularImmutableMap.BucketOverflowException -> L22
    L16:
        int r118 = r12;
        int r119 = r17;
        if (r23 != null) goto L20;
        if (r22 != null) goto L20;
        ImmutableMapEntry r26 = RegularImmutableMap.makeImmutable(r18, r19, r110);
    L21:
        r13[r113] = r26;
        r14[r114] = r26;
        r15[r16] = r26;
        r17 = r119 + (r111 ^ r112);
        r16 = r16 + 1;
        r5 = r20;
        r10 = r21;
        r12 = r118;
    L20:
        r26 = new ImmutableMapEntry.NonTerminalImmutableBiMapEntry(r19, r110, r22, r23);
    L23:
        return JdkBackedImmutableBiMap.create(r20, r21);
    L25:
        return new RegularImmutableBiMap(r13, r14, r15, r12, r17);
    L5:
        r15 = ImmutableMapEntry.createEntryArray(r20);
        goto L6
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        r5.getClass();
        Map.Entry<K, V>[] r10 = this.entries;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        Map.Entry<K, V> r13 = r10[r12];
        r5.accept(r13.getKey(), r13.getValue());
        r12 = r12 + 1;
        goto L3
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r5) {
        return (V) RegularImmutableMap.get(r5, this.e, this.g);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public int hashCode() {
        return this.f8856h;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.c1
    public /* bridge */ /* synthetic */ c1 inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.c1
    public ImmutableBiMap<V, K> inverse() {
        if (isEmpty() == true) goto L5;
        ImmutableBiMap<V, K> r5 = this.f8857i;
        if (r5 != null) goto L10;
        Inverse r10 = new Inverse(this, null);
        this.f8857i = r10;
        return r10;
    L10:
        return r5;
    L5:
        return ImmutableBiMap.of();
    }
}
