package com.google.common.collect;

import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedNavigableMap<K, V> extends Synchronized$SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
    private static final long serialVersionUID = 0;
    transient NavigableSet<K> descendingKeySet;
    transient NavigableMap<K, V> descendingMap;
    transient NavigableSet<K> navigableKeySet;

    public Synchronized$SynchronizedNavigableMap(NavigableMap<K, V> r5, Object r10) {
        super(r5, r10);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Map.Entry<K, V> r11 = p7.e(delegate().ceilingEntry(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        K r11 = delegate().ceilingKey(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedMap, com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        NavigableSet<K> r10 = this.descendingKeySet;     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        Synchronized$SynchronizedNavigableSet r11 = new Synchronized$SynchronizedNavigableSet(delegate().descendingKeySet(), this.mutex);     // Catch: Throwable -> L9
        this.descendingKeySet = r11;     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r11;
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r10;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        NavigableMap<K, V> r10 = this.descendingMap;     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        Synchronized$SynchronizedNavigableMap r11 = new Synchronized$SynchronizedNavigableMap(delegate().descendingMap(), this.mutex);     // Catch: Throwable -> L9
        this.descendingMap = r11;     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r11;
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r10;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Map.Entry<K, V> r10 = p7.e(delegate().firstEntry(), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Map.Entry<K, V> r11 = p7.e(delegate().floorEntry(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public K floorKey(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        K r11 = delegate().floorKey(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K r5, boolean r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        Synchronized$SynchronizedNavigableMap r12 = new Synchronized$SynchronizedNavigableMap(delegate().headMap(r5, r10), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Map.Entry<K, V> r11 = p7.e(delegate().higherEntry(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public K higherKey(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        K r11 = delegate().higherKey(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedMap, java.util.Map
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Map.Entry<K, V> r10 = p7.e(delegate().lastEntry(), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Map.Entry<K, V> r11 = p7.e(delegate().lowerEntry(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        K r11 = delegate().lowerKey(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        NavigableSet<K> r10 = this.navigableKeySet;     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        Synchronized$SynchronizedNavigableSet r11 = new Synchronized$SynchronizedNavigableSet(delegate().navigableKeySet(), this.mutex);     // Catch: Throwable -> L9
        this.navigableKeySet = r11;     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r11;
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r10;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Map.Entry<K, V> r10 = p7.e(delegate().pollFirstEntry(), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Map.Entry<K, V> r10 = p7.e(delegate().pollLastEntry(), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K r5, boolean r10, K r11, boolean r12) {
        Object r13 = this.mutex;
        monitor-enter(r13);
        Synchronized$SynchronizedNavigableMap r14 = new Synchronized$SynchronizedNavigableMap(delegate().subMap(r5, r10, r11, r12), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return r14;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K r5, boolean r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        Synchronized$SynchronizedNavigableMap r12 = new Synchronized$SynchronizedNavigableMap(delegate().tailMap(r5, r10), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedMap, com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedMap, com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ SortedMap delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedMap, com.google.common.collect.Synchronized$SynchronizedMap, com.google.common.collect.Synchronized$SynchronizedObject
    public NavigableMap<K, V> delegate() {
        return (NavigableMap) super.delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> headMap(K r5) {
        return headMap(r5, false);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> subMap(K r5, K r10) {
        return subMap(r5, true, r10, false);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> tailMap(K r5) {
        return tailMap(r5, true);
    }
}
