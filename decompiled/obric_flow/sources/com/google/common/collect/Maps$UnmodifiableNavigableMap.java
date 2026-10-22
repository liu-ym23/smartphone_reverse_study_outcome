package com.google.common.collect;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
class Maps$UnmodifiableNavigableMap<K, V> extends c3 implements NavigableMap<K, V>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Maps$UnmodifiableNavigableMap f8851a;
    private final NavigableMap<K, ? extends V> delegate;

    public Maps$UnmodifiableNavigableMap(NavigableMap<K, ? extends V> r5) {
        this.delegate = r5;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K r5) {
        return p7.f(this.delegate.ceilingEntry(r5));
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K r5) {
        return this.delegate.ceilingKey(r5);
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

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return p7.x0(this.delegate.descendingKeySet());
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        Maps$UnmodifiableNavigableMap r5 = this.f8851a;
        if (r5 != null) goto L6;
        Maps$UnmodifiableNavigableMap r10 = new Maps$UnmodifiableNavigableMap(this.delegate.descendingMap(), this);
        this.f8851a = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return p7.f(this.delegate.firstEntry());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K r5) {
        return p7.f(this.delegate.floorEntry(r5));
    }

    @Override // java.util.NavigableMap
    public K floorKey(K r5) {
        return this.delegate.floorKey(r5);
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> headMap(K r5) {
        return headMap(r5, false);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K r5) {
        return p7.f(this.delegate.higherEntry(r5));
    }

    @Override // java.util.NavigableMap
    public K higherKey(K r5) {
        return this.delegate.higherKey(r5);
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return p7.f(this.delegate.lastEntry());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K r5) {
        return p7.f(this.delegate.lowerEntry(r5));
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K r5) {
        return this.delegate.lowerKey(r5);
    }

    @Override // java.util.Map
    public V merge(K r5, V r10, BiFunction<? super V, ? super V, ? extends V> r11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return p7.x0(this.delegate.navigableKeySet());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry<K, V> pollLastEntry() {
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

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> subMap(K r5, K r10) {
        return subMap(r5, true, r10, false);
    }

    @Override // java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> tailMap(K r5) {
        return tailMap(r5, true);
    }

    @Override // com.google.common.collect.v2, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K r5, boolean r10) {
        NavigableMap<K, ? extends V> r11 = this.delegate.headMap(r5, r10);
        r11.getClass();
        if ((r11 instanceof Maps$UnmodifiableNavigableMap) == false) goto L6;
        return r11;
    L6:
        return new Maps$UnmodifiableNavigableMap(r11);
    }

    @Override // java.util.Map
    public V replace(K r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K r5, boolean r10, K r11, boolean r12) {
        NavigableMap<K, ? extends V> r13 = this.delegate.subMap(r5, r10, r11, r12);
        r13.getClass();
        if ((r13 instanceof Maps$UnmodifiableNavigableMap) == false) goto L6;
        return r13;
    L6:
        return new Maps$UnmodifiableNavigableMap(r13);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K r5, boolean r10) {
        NavigableMap<K, ? extends V> r11 = this.delegate.tailMap(r5, r10);
        r11.getClass();
        if ((r11 instanceof Maps$UnmodifiableNavigableMap) == false) goto L6;
        return r11;
    L6:
        return new Maps$UnmodifiableNavigableMap(r11);
    }

    public Maps$UnmodifiableNavigableMap(NavigableMap<K, ? extends V> r5, Maps$UnmodifiableNavigableMap<K, V> r10) {
        this.delegate = r5;
        this.f8851a = r10;
    }

    @Override // com.google.common.collect.c3, com.google.common.collect.v2, com.google.common.collect.z2
    public SortedMap<K, V> delegate() {
        return Collections.unmodifiableSortedMap(this.delegate);
    }
}
