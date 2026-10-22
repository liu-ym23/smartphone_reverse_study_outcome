package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
final class SingletonImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    private final transient ImmutableBiMap<V, K> inverse;
    private transient ImmutableBiMap<V, K> lazyInverse;
    final transient K singleKey;
    final transient V singleValue;

    SingletonImmutableBiMap(K r1, V r2) {
        o.a(r1, r2);
        this.singleKey = r1;
        this.singleValue = r2;
        this.inverse = null;
    }

    private SingletonImmutableBiMap(K r1, V r2, ImmutableBiMap<V, K> r3) {
        this.singleKey = r1;
        this.singleValue = r2;
        this.inverse = r3;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object r1) {
        return this.singleKey.equals(r1);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(Object r1) {
        return this.singleValue.equals(r1);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return ImmutableSet.of(Maps.a(this.singleKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return ImmutableSet.of(this.singleKey);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r3) {
        ((BiConsumer) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin")), BiConsumer.class, "com.obric.memorydata.plugin")).accept(this.singleKey, this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r2) {
        if (this.singleKey.equals(r2) == true) goto L7;
        return null;
    L7:
        return this.singleValue;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.k
    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> r0 = this.inverse;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ImmutableBiMap<V, K> r1 = this.lazyInverse;
        if (r1 != null) goto L9;
        SingletonImmutableBiMap r2 = new SingletonImmutableBiMap(this.singleValue, this.singleKey, this);
        this.lazyInverse = r2;
        return r2;
    L9:
        return r1;
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
        return 1;
    }
}
