package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    final transient Map.Entry<K, V>[] entries;
    private final transient int mask;
    private final transient ImmutableMapEntry<K, V>[] table;

    static class BucketOverflowException extends Exception {
        BucketOverflowException() {
        }
    }

    private static final class KeySet<K> extends IndexedImmutableSet<K> {
        private final RegularImmutableMap<K, ?> map;

        private static class SerializedForm<K> implements Serializable {
            private static final long serialVersionUID = 0;
            final ImmutableMap<K, ?> map;

            SerializedForm(ImmutableMap<K, ?> r1) {
                this.map = r1;
            }

            Object readResolve() {
                return this.map.keySet();
            }
        }

        KeySet(RegularImmutableMap<K, ?> r1) {
            this.map = r1;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.map.containsKey(r1);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        K get(int r1) {
            return this.map.entries[r1].getKey();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }
    }

    private static final class Values<K, V> extends ImmutableList<V> {
        final RegularImmutableMap<K, V> map;

        private static class SerializedForm<V> implements Serializable {
            private static final long serialVersionUID = 0;
            final ImmutableMap<?, V> map;

            SerializedForm(ImmutableMap<?, V> r1) {
                this.map = r1;
            }

            Object readResolve() {
                return this.map.values();
            }
        }

        Values(RegularImmutableMap<K, V> r1) {
            this.map = r1;
        }

        @Override // java.util.List
        public V get(int r1) {
            return this.map.entries[r1].getValue();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
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

    private RegularImmutableMap(Map.Entry<K, V>[] r1, ImmutableMapEntry<K, V>[] r2, int r3) {
        this.entries = r1;
        this.table = r2;
        this.mask = r3;
    }

    static <K, V> ImmutableMapEntry<K, V> checkNoConflictInKeyBucket(Object r4, Object r5, ImmutableMapEntry<K, V> r6, boolean r7) {
        int r1 = 0;
    L3:
        if (r6 == null) goto L14;
        if (r6.getKey().equals(r4) == false) goto L9;
        if (r7 == false) goto L8;
        checkNoConflict(false, "key", r6, r4 + "=" + r5);
        goto L9
    L8:
        return r6;
    L9:
        r1 = r1 + 1;
        if (r1 > 8) goto L13;
        r6 = r6.getNextInKeyBucket();
        goto L3
    L13:
        throw new BucketOverflowException();
    L14:
        return null;
    }

    static <K, V> ImmutableMap<K, V> fromEntries(Map.Entry<K, V>... r2) {
        return fromEntryArray(r2.length, r2, true);
    }

    static <K, V> ImmutableMap<K, V> fromEntryArray(int r1, Map.Entry<K, V>[] r2, boolean r3) {
        com.google.common.base.n.b(r1, r2.length);
        if (r1 == 0) goto L5;
        return fromEntryArrayCheckingBucketOverflow(r1, r2, r3);
    L9:
        return JdkBackedImmutableMap.create(r1, r2, r3);
    L5:
        return (ImmutableMap<K, V>) EMPTY;
    }

    private static <K, V> ImmutableMap<K, V> fromEntryArrayCheckingBucketOverflow(int r17, Map.Entry<K, V>[] r18, boolean r19) {
        if (r17 != r18.length) goto L5;
        Map.Entry<K, V>[] r2 = r18;
    L6:
        int r5 = ai.a(r17, MAX_LOAD_FACTOR);
        ImmutableMapEntry[] r6 = ImmutableMapEntry.createEntryArray(r5);
        int r7 = r5 - 1;
        IdentityHashMap r8 = null;
        int r9 = 0;
        int r10 = r17 - 1;
    L7:
        if (r10 < 0) goto L20;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r18[r10]), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r13 = r12.getKey();
        Object r15 = r12.getValue();
        o.a(r13, r15);
        int r16 = ai.a(r13.hashCode()) & r7;
        ImmutableMapEntry r3 = r6[r16];
        ImmutableMapEntry r11 = checkNoConflictInKeyBucket(r13, r15, r3, r19);
        if (r11 != null) goto L14;
        if (r3 != null) goto L12;
        r11 = makeImmutable(r12, r13, r15);
    L13:
        r6[r16] = r11;
    L19:
        r2[r10] = r11;
        r10 = r10 - 1;
        goto L7
    L12:
        r11 = new ImmutableMapEntry.NonTerminalImmutableMapEntry(r13, r15, r3);
        goto L13
    L14:
        if (r8 != null) goto L16;
        r8 = new IdentityHashMap();
    L16:
        r8.put(r11, true);
        r9 = r9 + 1;
        if (r2 != r18) goto L19;
        r2 = (Map.Entry[]) ZeusTransformUtils.preCheckCast(r2.clone(), Map.Entry[].class, "com.obric.memorydata.plugin");
        goto L19
    L20:
        if (r8 == null) goto L26;
        r2 = removeDuplicates(r2, r17, r17 - r9, r8);
        if (ai.a(r2.length, MAX_LOAD_FACTOR) == r5) goto L26;
        return fromEntryArrayCheckingBucketOverflow(r2.length, r2, true);
    L26:
        return new RegularImmutableMap(r2, r6, r7);
    L5:
        r2 = ImmutableMapEntry.createEntryArray(r17);
        goto L6
    }

    static <V> V get(Object r2, ImmutableMapEntry<?, V>[] r3, int r4) {
        if (r2 == null) goto L13;
        if (r3 == null) goto L13;
        ImmutableMapEntry<?, V> r5 = r3[r4 & ai.a(r2.hashCode())];
    L7:
        if (r5 == null) goto L13;
        if (r2.equals(r5.getKey()) == true) goto L11;
        r5 = r5.getNextInKeyBucket();
        goto L7
    L11:
        return r5.getValue();
    L13:
        return null;
    }

    static <K, V> ImmutableMapEntry<K, V> makeImmutable(Map.Entry<K, V> r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
        return makeImmutable(r3, r3.getKey(), r3.getValue());
    }

    static <K, V> ImmutableMapEntry<K, V> makeImmutable(Map.Entry<K, V> r2, K r3, V r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ImmutableMapEntry.class) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        return (ImmutableMapEntry) ZeusTransformUtils.preCheckCast(r5, ImmutableMapEntry.class, "com.obric.memorydata.plugin");
    L11:
        return new ImmutableMapEntry(r3, r4);
    L5:
        if (((ImmutableMapEntry) ZeusTransformUtils.preCheckCast(r5, ImmutableMapEntry.class, "com.obric.memorydata.plugin")).isReusable() == false) goto L7;
        r0 = true;
        goto L8
    }

    static <K, V> Map.Entry<K, V>[] removeDuplicates(Map.Entry<K, V>[] r7, int r8, int r9, IdentityHashMap<Map.Entry<K, V>, Boolean> r10) {
        ImmutableMapEntry[] r11 = ImmutableMapEntry.createEntryArray(r9);
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r8) goto L11;
        Map.Entry<K, V> r3 = r7[r1];
        Boolean r4 = (Boolean) ZeusTransformUtils.preCheckCast(r10.get(r3), Boolean.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
    L9:
        r11[r2] = r3;
        r2 = r2 + 1;
    L10:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r4.booleanValue() == false) goto L10;
        r10.put(r3, false);
        goto L9
    L11:
        return r11;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new KeySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        BiConsumer r6 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r5, BiConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r6);
        Map.Entry<K, V>[] r4 = this.entries;
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Map.Entry<K, V> r2 = r4[r1];
        r6.accept(r2.getKey(), r2.getValue());
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r2) {
        return (V) get(r2, this.table, this.mask);
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }
}
