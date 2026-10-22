package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedMap<K, V> extends Synchronized$SynchronizedObject implements Map<K, V> {
    private static final long serialVersionUID = 0;
    transient Set<Map.Entry<K, V>> entrySet;
    transient Set<K> keySet;
    transient Collection<V> values;

    public Synchronized$SynchronizedMap(Map<K, V> r5, Object r10) {
        super(r5, r10);
    }

    @Override // java.util.Map
    public void clear() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        delegate().clear();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public V compute(K r5, BiFunction<? super K, ? super V, ? extends V> r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        V r12 = delegate().compute(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public V computeIfAbsent(K r5, Function<? super K, ? extends V> r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        V r12 = delegate().computeIfAbsent(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public V computeIfPresent(K r5, BiFunction<? super K, ? super V, ? extends V> r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        V r12 = delegate().computeIfPresent(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public boolean containsKey(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().containsKey(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean containsValue(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().containsValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.entrySet != null) goto L9;
        this.entrySet = new Synchronized$SynchronizedSet(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L7
    L9:
        Set<Map.Entry<K, V>> r10 = this.entrySet;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    }

    @Override // java.util.Map
    public boolean equals(Object r5) {
        if (r5 != this) goto L5;
        return true;
    L5:
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().equals(r5);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        delegate().forEach(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public V get(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        V r11 = delegate().get(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public V getOrDefault(Object r5, V r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        V r12 = delegate().getOrDefault(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public int hashCode() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        int r10 = delegate().hashCode();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        boolean r10 = delegate().isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.keySet != null) goto L9;
        this.keySet = new Synchronized$SynchronizedSet(delegate().keySet(), this.mutex);     // Catch: Throwable -> L7
    L9:
        Set<K> r10 = this.keySet;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    }

    @Override // java.util.Map
    public V merge(K r5, V r10, BiFunction<? super V, ? super V, ? extends V> r11) {
        Object r12 = this.mutex;
        monitor-enter(r12);
        V r13 = delegate().merge(r5, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return r13;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public V put(K r5, V r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        V r12 = delegate().put(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        delegate().putAll(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public V putIfAbsent(K r5, V r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        V r12 = delegate().putIfAbsent(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public V remove(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        V r11 = delegate().remove(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public boolean replace(K r5, V r10, V r11) {
        Object r12 = this.mutex;
        monitor-enter(r12);
        boolean r13 = delegate().replace(r5, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return r13;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        delegate().replaceAll(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public int size() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        int r10 = delegate().size();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public Collection<V> values() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.values != null) goto L9;
        this.values = new Synchronized$SynchronizedCollection(delegate().values(), this.mutex, null);     // Catch: Throwable -> L7
    L9:
        Collection<V> r10 = this.values;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    public Map<K, V> delegate() {
        return (Map) super.delegate();
    }

    @Override // java.util.Map
    public boolean remove(Object r5, Object r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        boolean r12 = delegate().remove(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public V replace(K r5, V r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        V r12 = delegate().replace(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }
}
