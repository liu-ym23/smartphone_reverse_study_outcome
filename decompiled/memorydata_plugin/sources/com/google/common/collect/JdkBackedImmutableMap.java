package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
final class JdkBackedImmutableMap<K, V> extends ImmutableMap<K, V> {
    private final transient Map<K, V> delegateMap;
    private final transient ImmutableList<Map.Entry<K, V>> entries;

    JdkBackedImmutableMap(Map<K, V> r3, ImmutableList<Map.Entry<K, V>> r4) {
        this.delegateMap = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.entries = r4;
    }

    static <K, V> ImmutableMap<K, V> create(int r9, Map.Entry<K, V>[] r10, boolean r11) {
        HashMap r0 = Maps.a(r9);
        int r2 = 0;
        HashMap r4 = null;
        int r3 = 0;
        int r5 = 0;
    L4:
        if (r3 >= r9) goto L14;
        r10[r3] = RegularImmutableMap.makeImmutable((Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r10[r3]), Map.Entry.class, "com.obric.memorydata.plugin"));
        K r6 = r10[r3].getKey();
        V r7 = r10[r3].getValue();
        Object r8 = r0.put(r6, r7);
        if (r8 == null) goto L13;
        if (r11 == true) goto L12;
        if (r4 != null) goto L10;
        r4 = new HashMap();
    L10:
        r4.put(r6, r7);
        r5 = r5 + 1;
        goto L13
    L12:
        throw conflictException("key", r10[r3], r10[r3].getKey() + "=" + r8);
    L13:
        r3 = r3 + 1;
        goto L4
    L14:
        if (r4 == null) goto L27;
        Map.Entry<K, V>[] r12 = new Map.Entry[r9 - r5];
        int r13 = 0;
    L16:
        if (r2 >= r9) goto L25;
        Map.Entry<K, V> r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r10[r2]), Map.Entry.class, "com.obric.memorydata.plugin");
        K r15 = r14.getKey();
        if (r4.containsKey(r15) == false) goto L23;
        Object r16 = r4.get(r15);
        if (r16 == null) goto L24;
        ImmutableMapEntry r17 = new ImmutableMapEntry(r15, r16);
        r4.put(r15, null);
        r14 = r17;
    L24:
        r2 = r2 + 1;
    L23:
        r12[r13] = r14;
        r13 = r13 + 1;
        goto L24
    L25:
        r10 = r12;
    L27:
        return new JdkBackedImmutableMap(r0, ImmutableList.asImmutableList(r10, r9));
    }

    static /* synthetic */ void lambda$forEach$0(BiConsumer r2, Map.Entry r3) {
        BiConsumer r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r2, BiConsumer.class, "com.obric.memorydata.plugin");
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        r4.accept(r5.getKey(), r5.getValue());
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return new ImmutableMapValues(this);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r3) {
        final BiConsumer r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        this.entries.forEach(new $$Lambda$JdkBackedImmutableMap$1gmbrw0PEIM4p2uuJhJAkqZrGu0(r4));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r1) {
        return this.delegateMap.get(r1);
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
