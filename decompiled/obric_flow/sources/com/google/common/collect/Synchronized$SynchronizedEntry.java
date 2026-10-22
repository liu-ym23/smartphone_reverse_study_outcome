package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedEntry<K, V> extends Synchronized$SynchronizedObject implements Map.Entry<K, V> {
    private static final long serialVersionUID = 0;

    public Synchronized$SynchronizedEntry(Map.Entry<K, V> r5, Object r10) {
        super(r5, r10);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().equals(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        K r10 = delegate().getKey();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        V r10 = delegate().getValue();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map.Entry
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

    @Override // java.util.Map.Entry
    public V setValue(V r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        V r11 = delegate().setValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    public Map.Entry<K, V> delegate() {
        return (Map.Entry) super.delegate();
    }
}
