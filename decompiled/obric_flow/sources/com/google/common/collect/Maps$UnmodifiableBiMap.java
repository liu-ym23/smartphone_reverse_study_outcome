package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
class Maps$UnmodifiableBiMap<K, V> extends v2 implements c1, Serializable {
    private static final long serialVersionUID = 0;
    final c1 delegate;
    c1 inverse;
    final Map<K, V> unmodifiableMap;
    transient Set<V> values;

    public Maps$UnmodifiableBiMap(c1 r5, c1 r10) {
        this.unmodifiableMap = Collections.unmodifiableMap(r5);
        this.delegate = r5;
        this.inverse = r10;
    }

    @Override // java.util.Map
    public V compute(K r5, BiFunction<? super K, ? super V, ? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V computeIfAbsent(K r5, Function<? super K, ? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V computeIfPresent(K r5, BiFunction<? super K, ? super V, ? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.c1
    public V forcePut(K r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c1
    public c1 inverse() {
        c1 r5 = this.inverse;
        if (r5 != null) goto L6;
        Maps$UnmodifiableBiMap r10 = new Maps$UnmodifiableBiMap(this.delegate.inverse(), this);
        this.inverse = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.Map
    public V merge(K r5, V r10, BiFunction<? super V, ? super V, ? extends V> r11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V putIfAbsent(K r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean remove(Object r5, Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean replace(K r5, V r10, V r11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.v2, com.google.common.collect.z2
    public Map<K, V> delegate() {
        return this.unmodifiableMap;
    }

    @Override // java.util.Map
    public V replace(K r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public Set<V> values() {
        Set<V> r5 = this.values;
        if (r5 != null) goto L6;
        Set<V> r10 = Collections.unmodifiableSet(this.delegate.values());
        this.values = r10;
        return r10;
    L6:
        return r5;
    }
}
