package com.google.common.collect;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
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
    final transient Map.Entry<K, V>[] entries;
    private final transient int hashCode;
    private transient ImmutableBiMap<V, K> inverse;
    private final transient ImmutableMapEntry<K, V>[] keyTable;
    private final transient int mask;
    private final transient ImmutableMapEntry<K, V>[] valueTable;

    /* JADX INFO: renamed from: com.google.common.collect.RegularImmutableBiMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class Inverse extends ImmutableBiMap<V, K> {
        final /* synthetic */ RegularImmutableBiMap this$0;

        final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {
            final /* synthetic */ Inverse this$1;

            InverseEntrySet(Inverse r1) {
                this.this$1 = r1;
            }

            @Override // com.google.common.collect.ImmutableSet.CachingAsList
            ImmutableList<Map.Entry<V, K>> createAsList() {
                return new AnonymousClass1(this);
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Map.Entry<V, K>> r3) {
                Consumer<? super Map.Entry<K, V>> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
                asList().forEach(r4);
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet, com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
            public int hashCode() {
                return RegularImmutableBiMap.access$300(this.this$1.this$0);
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet, com.google.common.collect.ImmutableSet
            boolean isHashCodeFast() {
                return true;
            }

            @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public bj<Map.Entry<V, K>> iterator() {
                return asList().iterator();
            }

            @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public /* bridge */ /* synthetic */ Iterator iterator() {
                return iterator();
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            ImmutableMap<V, K> map() {
                return this.this$1;
            }
        }

        private Inverse(RegularImmutableBiMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Inverse(RegularImmutableBiMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void lambda$forEach$0(BiConsumer r2, Object r3, Object r4) {
            ((BiConsumer) ZeusTransformUtils.wrapperContextForParams(r2, BiConsumer.class, "com.obric.memorydata.plugin")).accept(r4, r3);
        }

        private void readObject(ObjectInputStream r1) {
            throw new InvalidObjectException("Use InverseSerializedForm");
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<V, K>> createEntrySet() {
            return new InverseEntrySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<V> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super V, ? super K> r3) {
            final BiConsumer r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            this.this$0.forEach(new $$Lambda$RegularImmutableBiMap$Inverse$a92c3TxOCXw_IBq4UuVGbCPIvw(r4));
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public K get(Object r4) {
            if (r4 != null) goto L5;
        L14:
            return null;
        L5:
            if (RegularImmutableBiMap.access$100(this.this$0) == null) goto L14;
            int r1 = ai.a(r4.hashCode()) & RegularImmutableBiMap.access$200(this.this$0);
            ImmutableMapEntry r3 = RegularImmutableBiMap.access$100(this.this$0)[r1];
        L8:
            if (r3 == null) goto L14;
            if (r4.equals(r3.getValue()) == true) goto L12;
            r3 = r3.getNextInValueBucket();
            goto L8
        L12:
            return r3.getKey();
        }

        @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.k
        public ImmutableBiMap<K, V> inverse() {
            return this.this$0;
        }

        @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.k
        public /* bridge */ /* synthetic */ k inverse() {
            return inverse();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return false;
        }

        @Override // java.util.Map
        public int size() {
            return inverse().size();
        }

        @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.ImmutableMap
        Object writeReplace() {
            return new InverseSerializedForm(this.this$0);
        }
    }

    private static class InverseSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        private final ImmutableBiMap<K, V> forward;

        InverseSerializedForm(ImmutableBiMap<K, V> r1) {
            this.forward = r1;
        }

        Object readResolve() {
            return this.forward.inverse();
        }
    }

    static {
        EMPTY = new RegularImmutableBiMap(null, null, ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
    }

    private RegularImmutableBiMap(ImmutableMapEntry<K, V>[] r1, ImmutableMapEntry<K, V>[] r2, Map.Entry<K, V>[] r3, int r4, int r5) {
        this.keyTable = r1;
        this.valueTable = r2;
        this.entries = r3;
        this.mask = r4;
        this.hashCode = r5;
    }

    static /* synthetic */ ImmutableMapEntry[] access$100(RegularImmutableBiMap r0) {
        return r0.valueTable;
    }

    static /* synthetic */ int access$200(RegularImmutableBiMap r0) {
        return r0.mask;
    }

    static /* synthetic */ int access$300(RegularImmutableBiMap r0) {
        return r0.hashCode;
    }

    private static void checkNoConflictInValueBucket(Object r3, Map.Entry<?, ?> r4, ImmutableMapEntry<?, ?> r5) {
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L3:
        if (r5 == null) goto L9;
        checkNoConflict(!r3.equals(r5.getValue()), EventBody.KEY_VALUE, r6, r5);
        r0 = r0 + 1;
        if (r0 > 8) goto L8;
        r5 = r5.getNextInValueBucket();
        goto L3
    L8:
        throw new RegularImmutableMap.BucketOverflowException();
    }

    static <K, V> ImmutableBiMap<K, V> fromEntries(Map.Entry<K, V>... r1) {
        return fromEntryArray(r1.length, r1);
    }

    static <K, V> ImmutableBiMap<K, V> fromEntryArray(int r16, Map.Entry<K, V>[] r17) {
        int r0 = r16;
        Map.Entry<K, V>[] r1 = r17;
        com.google.common.base.n.b(r0, r1.length);
        int r2 = ai.a(r0, MAX_LOAD_FACTOR);
        int r7 = r2 - 1;
        ImmutableMapEntry[] r4 = ImmutableMapEntry.createEntryArray(r2);
        ImmutableMapEntry[] r5 = ImmutableMapEntry.createEntryArray(r2);
        if (r0 != r1.length) goto L5;
        Map.Entry<K, V>[] r6 = r1;
    L6:
        int r3 = 0;
        int r8 = 0;
    L7:
        if (r3 >= r0) goto L18;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r1[r3]), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r10 = r9.getKey();
        Object r11 = r9.getValue();
        o.a(r10, r11);
        int r12 = r10.hashCode();
        int r13 = r11.hashCode();
        int r14 = ai.a(r12) & r7;
        int r15 = ai.a(r13) & r7;
        ImmutableMapEntry r18 = r4[r14];
        ImmutableMapEntry r19 = r5[r15];
        RegularImmutableMap.checkNoConflictInKeyBucket(r10, r11, r18, true);     // Catch: RegularImmutableMap.BucketOverflowException -> L15
        checkNoConflictInValueBucket(r11, r9, r19);     // Catch: RegularImmutableMap.BucketOverflowException -> L15
        if (r19 != null) goto L13;
        if (r18 != null) goto L13;
        ImmutableMapEntry r20 = RegularImmutableMap.makeImmutable(r9, r10, r11);
    L14:
        r4[r14] = r20;
        r5[r15] = r20;
        r6[r3] = r20;
        r8 = r8 + (r12 ^ r13);
        r3 = r3 + 1;
        r0 = r16;
        r1 = r17;
    L13:
        r20 = new ImmutableMapEntry.NonTerminalImmutableBiMapEntry(r10, r11, r18, r19);
    L16:
        return JdkBackedImmutableBiMap.create(r16, r17);
    L18:
        return new RegularImmutableBiMap(r4, r5, r6, r7, r8);
    L5:
        r6 = ImmutableMapEntry.createEntryArray(r16);
        goto L6
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
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
        return (V) RegularImmutableMap.get(r2, this.keyTable, this.mask);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public int hashCode() {
        return this.hashCode;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.k
    public ImmutableBiMap<V, K> inverse() {
        if (isEmpty() == true) goto L5;
        ImmutableBiMap<V, K> r0 = this.inverse;
        if (r0 != null) goto L10;
        Inverse r1 = new Inverse(this, null);
        this.inverse = r1;
        return r1;
    L10:
        return r0;
    L5:
        return ImmutableBiMap.of();
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.k
    public /* bridge */ /* synthetic */ k inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isHashCodeFast() {
        return true;
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
