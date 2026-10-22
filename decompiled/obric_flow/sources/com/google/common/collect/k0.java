package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 extends v2 implements NavigableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g8 f9049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient l f9050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient i7 f9051c;
    public final /* synthetic */ l0 d;

    public k0(l0 r5) {
        this.d = r5;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object r5) {
        return this.d.floorEntry(r5);
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object r5) {
        return this.d.floorKey(r5);
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        g8 r5 = this.f9049a;
        if (r5 != null) goto L9;
        Comparator r10 = this.d.comparator();
        if (r10 != null) goto L7;
        r10 = g8.natural();
    L7:
        g8 r11 = g8.from(r10).reverse();
        this.f9049a = r11;
        return r11;
    L9:
        return r5;
    }

    @Override // com.google.common.collect.z2
    public final Object delegate() {
        return this.d;
    }

    @Override // java.util.NavigableMap
    public final NavigableSet descendingKeySet() {
        return this.d.navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap descendingMap() {
        return this.d;
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public final Set entrySet() {
        l r5 = this.f9050b;
        if (r5 != null) goto L6;
        l r10 = new l(2, this);
        this.f9050b = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        return this.d.lastEntry();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return this.d.lastKey();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object r5) {
        return this.d.ceilingEntry(r5);
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object r5) {
        return this.d.ceilingKey(r5);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object r5, boolean r10) {
        return this.d.tailMap(r5, r10).descendingMap();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object r5) {
        return this.d.lowerEntry(r5);
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object r5) {
        return this.d.lowerKey(r5);
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public final Set keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        return this.d.firstEntry();
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return this.d.firstKey();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object r5) {
        return this.d.higherEntry(r5);
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object r5) {
        return this.d.higherKey(r5);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet navigableKeySet() {
        i7 r5 = this.f9051c;
        if (r5 != null) goto L6;
        i7 r10 = new i7(this);
        this.f9051c = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        return this.d.pollLastEntry();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        return this.d.pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object r5, boolean r10, Object r11, boolean r12) {
        return this.d.subMap(r11, r12, r5, r10).descendingMap();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object r5, boolean r10) {
        return this.d.headMap(r5, r10).descendingMap();
    }

    @Override // com.google.common.collect.z2
    public final String toString() {
        return standardToString();
    }

    @Override // com.google.common.collect.v2, java.util.Map
    public final Collection values() {
        return new q6(this);
    }

    @Override // com.google.common.collect.v2, com.google.common.collect.z2
    public final Map delegate() {
        return this.d;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap headMap(Object r5) {
        return headMap(r5, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap subMap(Object r5, Object r10) {
        return subMap(r5, true, r10, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap tailMap(Object r5) {
        return tailMap(r5, true);
    }
}
