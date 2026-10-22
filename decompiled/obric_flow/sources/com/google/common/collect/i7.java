package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public final class i7 extends j7 implements NavigableSet {
    @Override // com.google.common.collect.j7, com.google.common.collect.a9
    public final Map b() {
        return (NavigableMap) ((Map) this.f8898c);
    }

    @Override // com.google.common.collect.j7
    public final SortedMap c() {
        return (NavigableMap) ((Map) this.f8898c);
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object r5) {
        return ((NavigableMap) ((Map) this.f8898c)).ceilingKey(r5);
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return descendingSet().iterator();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return ((NavigableMap) ((Map) this.f8898c)).descendingKeySet();
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object r5) {
        return ((NavigableMap) ((Map) this.f8898c)).floorKey(r5);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object r5, boolean r10) {
        return ((NavigableMap) ((Map) this.f8898c)).headMap(r5, r10).navigableKeySet();
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object r5) {
        return ((NavigableMap) ((Map) this.f8898c)).higherKey(r5);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object r5) {
        return ((NavigableMap) ((Map) this.f8898c)).lowerKey(r5);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        return p7.P(((NavigableMap) ((Map) this.f8898c)).pollFirstEntry());
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        return p7.P(((NavigableMap) ((Map) this.f8898c)).pollLastEntry());
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object r5, boolean r10, Object r11, boolean r12) {
        return ((NavigableMap) ((Map) this.f8898c)).subMap(r5, r10, r11, r12).navigableKeySet();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object r5, boolean r10) {
        return ((NavigableMap) ((Map) this.f8898c)).tailMap(r5, r10).navigableKeySet();
    }

    @Override // com.google.common.collect.j7, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet headSet(Object r5) {
        return headSet(r5, false);
    }

    @Override // com.google.common.collect.j7, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet subSet(Object r5, Object r10) {
        return subSet(r5, true, r10, false);
    }

    @Override // com.google.common.collect.j7, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet tailSet(Object r5) {
        return tailSet(r5, true);
    }
}
