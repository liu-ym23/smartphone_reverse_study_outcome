package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends t implements NavigableSet {
    public final /* synthetic */ AbstractMapBasedMultimap g;

    public q(AbstractMapBasedMultimap r5, NavigableMap r10) {
        this.g = r5;
        super(r5, r10);
    }

    @Override // com.google.common.collect.t
    public final /* bridge */ /* synthetic */ SortedMap c() {
        return d();
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object r5) {
        return d().ceilingKey(r5);
    }

    public final NavigableMap d() {
        return (NavigableMap) ((SortedMap) ((Map) this.f8898c));
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return ((o) descendingSet()).iterator();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        NavigableMap r5 = d().descendingMap();
        return new q(this.g, r5);
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object r5) {
        return d().floorKey(r5);
    }

    @Override // com.google.common.collect.t, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet headSet(Object r5) {
        return headSet(r5, false);
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object r5) {
        return d().higherKey(r5);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object r5) {
        return d().lowerKey(r5);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        return p7.c0(iterator());
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        return p7.c0(descendingIterator());
    }

    @Override // com.google.common.collect.t, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet subSet(Object r5, Object r10) {
        return subSet(r5, true, r10, false);
    }

    @Override // com.google.common.collect.t, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet tailSet(Object r5) {
        return tailSet(r5, true);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object r5, boolean r10) {
        NavigableMap r11 = d().headMap(r5, r10);
        return new q(this.g, r11);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object r5, boolean r10, Object r11, boolean r12) {
        NavigableMap r13 = d().subMap(r5, r10, r11, r12);
        return new q(this.g, r13);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object r5, boolean r10) {
        NavigableMap r11 = d().tailMap(r5, r10);
        return new q(this.g, r11);
    }
}
