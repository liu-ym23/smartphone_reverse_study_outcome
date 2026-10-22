package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedSortedMap<K, V> extends Synchronized$SynchronizedMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = 0;

    public Synchronized$SynchronizedSortedMap(SortedMap<K, V> r5, Object r10) {
        super(r5, r10);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Comparator<? super K> r10 = delegate().comparator();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        K r10 = delegate().firstKey();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public SortedMap<K, V> headMap(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Synchronized$SynchronizedSortedMap r11 = new Synchronized$SynchronizedSortedMap(delegate().headMap(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        K r10 = delegate().lastKey();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public SortedMap<K, V> subMap(K r5, K r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        Synchronized$SynchronizedSortedMap r12 = new Synchronized$SynchronizedSortedMap(delegate().subMap(r5, r10), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public SortedMap<K, V> tailMap(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Synchronized$SynchronizedSortedMap r11 = new Synchronized$SynchronizedSortedMap(delegate().tailMap(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    public SortedMap<K, V> delegate() {
        return (SortedMap) super.delegate();
    }
}
