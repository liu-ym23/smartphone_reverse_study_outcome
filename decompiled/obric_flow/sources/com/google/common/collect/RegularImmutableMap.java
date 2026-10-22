package com.google.common.collect;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.io.Serializable;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = null;
    static final double HASH_FLOODING_FPP = 0.001d;
    static final int MAX_HASH_BUCKET_LENGTH = 8;
    static final double MAX_LOAD_FACTOR = 1.2d;
    private static final long serialVersionUID = 0;
    public final transient ImmutableMapEntry[] e;
    final transient Map.Entry<K, V>[] entries;
    public final transient int f;

    public static class BucketOverflowException extends Exception {
        public BucketOverflowException() {
        }
    }

    public static final class KeySet<K> extends IndexedImmutableSet<K> {
        private final RegularImmutableMap<K, ?> map;

        public static class SerializedForm<K> implements Serializable {
            private static final long serialVersionUID = 0;
            final ImmutableMap<K, ?> map;

            public SerializedForm(ImmutableMap<K, ?> r5) {
                this.map = r5;
            }

            public Object readResolve() {
                return this.map.keySet();
            }
        }

        public KeySet(RegularImmutableMap<K, ?> r5) {
            this.map = r5;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            return this.map.containsKey(r5);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public K get(int r5) {
            return this.map.entries[r5].getKey();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }
    }

    public static final class Values<K, V> extends ImmutableList<V> {
        final RegularImmutableMap<K, V> map;

        public static class SerializedForm<V> implements Serializable {
            private static final long serialVersionUID = 0;
            final ImmutableMap<?, V> map;

            public SerializedForm(ImmutableMap<?, V> r5) {
                this.map = r5;
            }

            public Object readResolve() {
                return this.map.values();
            }
        }

        public Values(RegularImmutableMap<K, V> r5) {
            this.map = r5;
        }

        @Override // java.util.List
        public V get(int r5) {
            return this.map.entries[r5].getValue();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.map.size();
        }
    }

    static {
        EMPTY = new RegularImmutableMap(ImmutableMap.EMPTY_ENTRY_ARRAY, null, 0);
    }

    public RegularImmutableMap(Map.Entry[] r5, ImmutableMapEntry[] r10, int r11) {
        this.entries = r5;
        this.e = r10;
        this.f = r11;
    }

    public static ImmutableMap a(int r16, Map.Entry[] r17, boolean r18) {
        if (r16 != r17.length) goto L5;
        Map.Entry[] r5 = r17;
    L6:
        int r10 = p7.v(MAX_LOAD_FACTOR, r16);
        ImmutableMapEntry[] r11 = ImmutableMapEntry.createEntryArray(r10);
        int r12 = r10 - 1;
        int r13 = r16 - 1;
        IdentityHashMap r14 = null;
        int r15 = 0;
    L7:
        if (r13 < 0) goto L20;
        Map.Entry r19 = r17[r13];
        Objects.requireNonNull(r19);
        Map.Entry r110 = r19;
        Object r111 = r110.getKey();
        Object r112 = r110.getValue();
        p7.p(r111, r112);
        int r113 = p7.n0(r111.hashCode()) & r12;
        ImmutableMapEntry r114 = r11[r113];
        ImmutableMapEntry r20 = checkNoConflictInKeyBucket(r111, r112, r114, r18);
        if (r20 != null) goto L14;
        if (r114 != null) goto L12;
        r20 = makeImmutable(r110, r111, r112);
    L13:
        r11[r113] = r20;
    L19:
        r5[r13] = r20;
        r13 = r13 - 1;
        goto L7
    L12:
        r20 = new ImmutableMapEntry.NonTerminalImmutableMapEntry(r111, r112, r114);
        goto L13
    L14:
        if (r14 != null) goto L16;
        r14 = new IdentityHashMap();
    L16:
        r14.put(r20, Boolean.TRUE);
        r15 = r15 + 1;
        if (r5 != r17) goto L19;
        r5 = (Map.Entry[]) r5.clone();
        goto L19
    L20:
        if (r14 == null) goto L26;
        r5 = removeDuplicates(r5, r16, r16 - r15, r14);
        if (p7.v(MAX_LOAD_FACTOR, r5.length) == r10) goto L26;
        return a(r5.length, r5, true);
    L26:
        return new RegularImmutableMap(r5, r11, r12);
    L5:
        r5 = ImmutableMapEntry.createEntryArray(r16);
        goto L6
    }

    public static <K, V> ImmutableMapEntry<K, V> checkNoConflictInKeyBucket(Object r10, Object r11, ImmutableMapEntry<K, V> r12, boolean r13) throws BucketOverflowException {
        int r5 = 0;
    L3:
        if (r12 == null) goto L14;
        if (r12.getKey().equals(r10) == false) goto L9;
        if (r13 == false) goto L8;
        String r14 = String.valueOf(r10);
        String r15 = String.valueOf(r11);
        ImmutableMap.checkNoConflict(false, STGroup.DICT_KEY, r12, androidx.room.jarjarred.org.antlr.runtime.a.m(r15.length() + (r14.length() + 1), r14, "=", r15));
        goto L9
    L8:
        return r12;
    L9:
        r5 = r5 + 1;
        if (r5 > 8) goto L13;
        r12 = r12.getNextInKeyBucket();
        goto L3
    L13:
        throw new BucketOverflowException();
    L14:
        return null;
    }

    public static <K, V> ImmutableMap<K, V> fromEntries(Map.Entry<K, V>... r5) {
        return fromEntryArray(r5.length, r5, true);
    }

    public static <K, V> ImmutableMap<K, V> fromEntryArray(int r5, Map.Entry<K, V>[] r10, boolean r11) {
        com.google.common.base.b0.o(r5, r10.length);
        if (r5 == 0) goto L5;
        return a(r5, r10, r11);
    L9:
        return JdkBackedImmutableMap.create(r5, r10, r11);
    L5:
        return (ImmutableMap<K, V>) EMPTY;
    }

    public static <K, V> ImmutableMapEntry<K, V> makeImmutable(Map.Entry<K, V> r5, K r10, V r11) {
        if ((r5 instanceof ImmutableMapEntry) == false) goto L8;
        if (((ImmutableMapEntry) r5).isReusable() == false) goto L8;
        return (ImmutableMapEntry) r5;
    L8:
        return new ImmutableMapEntry(r10, r11);
    }

    public static <K, V> Map.Entry<K, V>[] removeDuplicates(Map.Entry<K, V>[] r5, int r10, int r11, IdentityHashMap<Map.Entry<K, V>, Boolean> r12) {
        ImmutableMapEntry[] r13 = ImmutableMapEntry.createEntryArray(r11);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r10) goto L11;
        Map.Entry<K, V> r16 = r5[r14];
        Boolean r17 = r12.get(r16);
        if (r17 != null) goto L7;
    L9:
        r13[r15] = r16;
        r15 = r15 + 1;
    L10:
        r14 = r14 + 1;
        goto L3
    L7:
        if (r17.booleanValue() == false) goto L10;
        r12.put(r16, Boolean.FALSE);
        goto L9
    L11:
        return r13;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        return new Values(this);
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
        return (V) get(r5, this.e, this.f);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }

    public static <V> V get(Object r5, ImmutableMapEntry<?, V>[] r10, int r11) {
        if (r5 == null) goto L13;
        if (r10 == null) goto L13;
        ImmutableMapEntry<?, V> r12 = r10[r11 & p7.n0(r5.hashCode())];
    L7:
        if (r12 == null) goto L13;
        if (r5.equals(r12.getKey()) == true) goto L11;
        r12 = r12.getNextInKeyBucket();
        goto L7
    L11:
        return r12.getValue();
    L13:
        return null;
    }

    public static <K, V> ImmutableMapEntry<K, V> makeImmutable(Map.Entry<K, V> r5) {
        return makeImmutable(r5, r5.getKey(), r5.getValue());
    }
}
