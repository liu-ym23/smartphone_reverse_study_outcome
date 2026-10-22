package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedSetMultimap<K, V> extends Synchronized$SynchronizedMultimap<K, V> implements s8 {
    private static final long serialVersionUID = 0;
    transient Set<Map.Entry<K, V>> entrySet;

    public Synchronized$SynchronizedSetMultimap(s8 r5, Object r10) {
        super(r5, r10);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ q7 delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection removeAll(Object r5) {
        return removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public Set<Map.Entry<K, V>> entries() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.entrySet != null) goto L9;
        this.entrySet = new Synchronized$SynchronizedSet(delegate().entries(), this.mutex);     // Catch: Throwable -> L7
    L9:
        Set<Map.Entry<K, V>> r10 = this.entrySet;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public Set<V> get(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Synchronized$SynchronizedSet r11 = new Synchronized$SynchronizedSet(delegate().get(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public Set<V> removeAll(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Set<V> r11 = delegate().removeAll(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public Set<V> replaceValues(K r5, Iterable<? extends V> r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        Set<V> r12 = delegate().replaceValues(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.Synchronized$SynchronizedObject
    public s8 delegate() {
        return (s8) super.delegate();
    }
}
