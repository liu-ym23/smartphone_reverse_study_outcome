package com.google.common.collect;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedListMultimap<K, V> extends Synchronized$SynchronizedMultimap<K, V> implements x5 {
    private static final long serialVersionUID = 0;

    public Synchronized$SynchronizedListMultimap(x5 r5, Object r10) {
        super(r5, r10);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ q7 delegate() {
        return delegate();
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
    public List<V> get(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        List<V> r11 = p7.Q(delegate().get(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public List<V> removeAll(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        List<V> r11 = delegate().removeAll(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public List<V> replaceValues(K r5, Iterable<? extends V> r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        List<V> r12 = delegate().replaceValues(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.Synchronized$SynchronizedObject
    public x5 delegate() {
        return (x5) super.delegate();
    }
}
