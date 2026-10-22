package com.google.common.collect;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class JdkBackedImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    private final Map<V, K> backwardDelegate;
    private final transient ImmutableList<Map.Entry<K, V>> entries;
    private final Map<K, V> forwardDelegate;
    private transient JdkBackedImmutableBiMap<V, K> inverse;

    /* JADX INFO: renamed from: com.google.common.collect.JdkBackedImmutableBiMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class InverseEntries extends ImmutableList<Map.Entry<V, K>> {
        final /* synthetic */ JdkBackedImmutableBiMap this$0;

        private InverseEntries(JdkBackedImmutableBiMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ InverseEntries(JdkBackedImmutableBiMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // java.util.List
        public Map.Entry<V, K> get(int r2) {
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(JdkBackedImmutableBiMap.access$100(this.this$0).get(r2), Map.Entry.class, "com.obric.memorydata.plugin");
            return Maps.a(r1.getValue(), r1.getKey());
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return JdkBackedImmutableBiMap.access$100(this.this$0).size();
        }
    }

    private JdkBackedImmutableBiMap(ImmutableList<Map.Entry<K, V>> r3, Map<K, V> r4, Map<V, K> r5) {
        Map<K, V> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map<V, K> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.entries = r3;
        this.forwardDelegate = r6;
        this.backwardDelegate = r7;
    }

    static /* synthetic */ ImmutableList access$100(JdkBackedImmutableBiMap r0) {
        return r0.entries;
    }

    static <K, V> ImmutableBiMap<K, V> create(int r7, Map.Entry<K, V>[] r8) {
        HashMap r0 = Maps.a(r7);
        HashMap r1 = Maps.a(r7);
        int r2 = 0;
    L3:
        if (r2 >= r7) goto L14;
        ImmutableMapEntry r3 = RegularImmutableMap.makeImmutable((Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r8[r2]), Map.Entry.class, "com.obric.memorydata.plugin"));
        r8[r2] = r3;
        Object r4 = r0.putIfAbsent(r3.getKey(), r3.getValue());
        if (r4 != null) goto L12;
        Object r5 = r1.putIfAbsent(r3.getValue(), r3.getKey());
        if (r5 != null) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        throw conflictException(EventBody.KEY_VALUE, r5 + "=" + r3.getValue(), r8[r2]);
    L12:
        throw conflictException("key", r3.getKey() + "=" + r4, r8[r2]);
    L14:
        return new JdkBackedImmutableBiMap(ImmutableList.asImmutableList(r8, r7), r0, r1);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r1) {
        return this.forwardDelegate.get(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.k
    public ImmutableBiMap<V, K> inverse() {
        JdkBackedImmutableBiMap<V, K> r0 = this.inverse;
        if (r0 != null) goto L6;
        JdkBackedImmutableBiMap<V, K> r1 = new JdkBackedImmutableBiMap(new InverseEntries(this, null), this.backwardDelegate, this.forwardDelegate);
        this.inverse = r1;
        r1.inverse = this;
        return r1;
    L6:
        return r0;
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
        return this.entries.size();
    }
}
