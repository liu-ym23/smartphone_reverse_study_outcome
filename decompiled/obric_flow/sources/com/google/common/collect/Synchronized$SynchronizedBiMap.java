package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedBiMap<K, V> extends Synchronized$SynchronizedMap<K, V> implements c1, Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Set f8869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient c1 f8870b;

    public /* synthetic */ Synchronized$SynchronizedBiMap(c1 r5, Object r10, c1 r11, h9 r12) {
        this(r5, r10, r11);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.c1
    public V forcePut(K r5, V r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        V r12 = (V) delegate().forcePut(r5, r10);
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.c1
    public c1 inverse() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f8870b != null) goto L9;
        this.f8870b = new Synchronized$SynchronizedBiMap(delegate().inverse(), this.mutex, this);     // Catch: Throwable -> L7
    L9:
        c1 r10 = this.f8870b;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public Synchronized$SynchronizedBiMap(c1 r5, Object r10, c1 r11) {
        super(r5, r10);
        this.f8870b = r11;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, java.util.Map
    public Set<V> values() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f8869a != null) goto L9;
        this.f8869a = new Synchronized$SynchronizedSet(delegate().values(), this.mutex);     // Catch: Throwable -> L7
    L9:
        Set<V> r10 = this.f8869a;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    public c1 delegate() {
        return (c1) super.delegate();
    }
}
