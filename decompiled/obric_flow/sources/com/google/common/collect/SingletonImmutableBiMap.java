package com.google.common.collect;

import java.util.Map;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
final class SingletonImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    public final transient ImmutableBiMap e;
    public transient ImmutableBiMap f;
    final transient K singleKey;
    final transient V singleValue;

    public SingletonImmutableBiMap(K r5, V r10) {
        p7.p(r5, r10);
        this.singleKey = r5;
        this.singleValue = r10;
        this.e = null;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object r5) {
        return this.singleKey.equals(r5);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(Object r5) {
        return this.singleValue.equals(r5);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return ImmutableSet.of(new ImmutableEntry(this.singleKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return ImmutableSet.of(this.singleKey);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        r5.getClass();
        r5.accept(this.singleKey, this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r5) {
        if (this.singleKey.equals(r5) == true) goto L7;
        return null;
    L7:
        return this.singleValue;
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
        return 1;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.c1
    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> r5 = this.e;
        if (r5 == null) goto L5;
        return r5;
    L5:
        ImmutableBiMap<V, K> r10 = this.f;
        if (r10 != null) goto L9;
        SingletonImmutableBiMap r11 = new SingletonImmutableBiMap(this.singleValue, this.singleKey, this);
        this.f = r11;
        return r11;
    L9:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SingletonImmutableBiMap(Object r5, Object r10, ImmutableBiMap r11) {
        this.singleKey = r5;
        this.singleValue = r10;
        this.e = r11;
    }
}
