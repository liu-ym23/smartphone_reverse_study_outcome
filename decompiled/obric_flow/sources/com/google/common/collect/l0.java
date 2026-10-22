package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l0 extends h7 implements NavigableMap {
    public abstract Iterator a();

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object r5) {
        return tailMap(r5, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object r5) {
        return p7.P(ceilingEntry(r5));
    }

    @Override // java.util.NavigableMap
    public final NavigableSet descendingKeySet() {
        return new k0(this).navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap descendingMap() {
        return new k0(this);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        return (Map.Entry) p7.G(entryIterator());
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        Map.Entry r5 = firstEntry();
        if (r5 == null) goto L7;
        return r5.getKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object r5) {
        return headMap(r5, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object r5) {
        return p7.P(floorEntry(r5));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final SortedMap headMap(Object r5) {
        return headMap(r5, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object r5) {
        return tailMap(r5, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object r5) {
        return p7.P(higherEntry(r5));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public final Set keySet() {
        return new i7(this);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        return (Map.Entry) p7.G(a());
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        Map.Entry r5 = lastEntry();
        if (r5 == null) goto L7;
        return r5.getKey();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object r5) {
        return headMap(r5, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object r5) {
        return p7.P(lowerEntry(r5));
    }

    @Override // java.util.NavigableMap
    public final NavigableSet navigableKeySet() {
        return new i7(this);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        return (Map.Entry) p7.c0(entryIterator());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        return (Map.Entry) p7.c0(a());
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
