package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
abstract class e<K, V> extends Maps.d<K, V> implements NavigableMap<K, V> {

    /* JADX INFO: renamed from: com.google.common.collect.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class a extends Maps.a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f4678a;

        private a(e r1) {
            this.f4678a = r1;
        }

        /* synthetic */ a(e r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.Maps.a
        NavigableMap<K, V> a() {
            return this.f4678a;
        }

        @Override // com.google.common.collect.Maps.a
        Iterator<Map.Entry<K, V>> b() {
            return this.f4678a.a();
        }
    }

    e() {
    }

    abstract Iterator<Map.Entry<K, V>> a();

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K r2) {
        return tailMap(r2, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K r1) {
        return (K) Maps.b(ceilingEntry(r1));
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return new a(this, null);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) ZeusTransformUtils.preCheckCast(Iterators.b(entryIterator(), null), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        Map.Entry<K, V> r0 = firstEntry();
        if (r0 == null) goto L7;
        return r0.getKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K r2) {
        return headMap(r2, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K r1) {
        return (K) Maps.b(floorEntry(r1));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> headMap(K r2) {
        return headMap(r2, false);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K r2) {
        return tailMap(r2, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K r1) {
        return (K) Maps.b(higherEntry(r1));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) ZeusTransformUtils.preCheckCast(Iterators.b(a(), null), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        Map.Entry<K, V> r0 = lastEntry();
        if (r0 == null) goto L7;
        return r0.getKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K r2) {
        return headMap(r2, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K r1) {
        return (K) Maps.b(lowerEntry(r1));
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return new Maps.f(this);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) ZeusTransformUtils.preCheckCast(Iterators.g(entryIterator()), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) ZeusTransformUtils.preCheckCast(Iterators.g(a()), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> subMap(K r3, K r4) {
        return subMap(r3, true, r4, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> tailMap(K r2) {
        return tailMap(r2, true);
    }
}
