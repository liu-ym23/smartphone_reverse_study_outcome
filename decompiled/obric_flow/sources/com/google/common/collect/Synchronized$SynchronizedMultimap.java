package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedMultimap<K, V> extends Synchronized$SynchronizedObject implements q7 {
    private static final long serialVersionUID = 0;
    transient Map<K, Collection<V>> asMap;
    transient Collection<Map.Entry<K, V>> entries;
    transient Set<K> keySet;
    transient z7 keys;
    transient Collection<V> valuesCollection;

    public Synchronized$SynchronizedMultimap(q7 r5, Object r10) {
        super(r5, r10);
    }

    @Override // com.google.common.collect.q7
    public Map<K, Collection<V>> asMap() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.asMap != null) goto L9;
        final Map r10 = delegate().asMap();     // Catch: Throwable -> L7
        final Object r11 = this.mutex;     // Catch: Throwable -> L7
        this.asMap = new Synchronized$SynchronizedAsMap(r10, r11);     // Catch: Throwable -> L7
    L9:
        Map<K, Collection<V>> r12 = this.asMap;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r12;
    }

    @Override // com.google.common.collect.q7
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

    @Override // com.google.common.collect.q7
    public boolean containsEntry(Object r5, Object r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        boolean r12 = delegate().containsEntry(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.q7
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

    @Override // com.google.common.collect.q7
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

    @Override // com.google.common.collect.q7
    public Collection<Map.Entry<K, V>> entries() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.entries != null) goto L9;
        this.entries = p7.d(delegate().entries(), this.mutex);     // Catch: Throwable -> L7
    L9:
        Collection<Map.Entry<K, V>> r10 = this.entries;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    }

    @Override // com.google.common.collect.q7
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

    @Override // com.google.common.collect.q7
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

    public Collection<V> get(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Collection<V> r11 = p7.d(delegate().get(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.q7
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

    @Override // com.google.common.collect.q7
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

    @Override // com.google.common.collect.q7
    public Set<K> keySet() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.keySet != null) goto L9;
        this.keySet = p7.c(delegate().keySet(), this.mutex);     // Catch: Throwable -> L7
    L9:
        Set<K> r10 = this.keySet;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    }

    @Override // com.google.common.collect.q7
    public z7 keys() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.keys != null) goto L15;
        z7 r10 = delegate().keys();     // Catch: Throwable -> L13
        Object r11 = this.mutex;     // Catch: Throwable -> L13
        if ((r10 instanceof Synchronized$SynchronizedMultiset) == false) goto L9;
    L12:
        this.keys = r10;     // Catch: Throwable -> L13
        goto L15
    L9:
        if ((r10 instanceof ImmutableMultiset) == true) goto L12;
        r10 = new Synchronized$SynchronizedMultiset(r10, r11);     // Catch: Throwable -> L13
    L15:
        z7 r12 = this.keys;     // Catch: Throwable -> L13
        monitor-exit(r5);     // Catch: Throwable -> L13
        return r12;
    }

    @Override // com.google.common.collect.q7
    public boolean put(K r5, V r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        boolean r12 = delegate().put(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.q7
    public boolean putAll(K r5, Iterable<? extends V> r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        boolean r12 = delegate().putAll(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.q7
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

    public Collection<V> removeAll(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Collection<V> r11 = delegate().removeAll(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public Collection<V> replaceValues(K r5, Iterable<? extends V> r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        Collection<V> r12 = delegate().replaceValues(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.q7
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

    @Override // com.google.common.collect.q7
    public Collection<V> values() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.valuesCollection != null) goto L9;
        this.valuesCollection = new Synchronized$SynchronizedCollection(delegate().values(), this.mutex, null);     // Catch: Throwable -> L7
    L9:
        Collection<V> r10 = this.valuesCollection;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    public q7 delegate() {
        return (q7) super.delegate();
    }

    @Override // com.google.common.collect.q7
    public boolean putAll(q7 r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().putAll(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }
}
