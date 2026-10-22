package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends s implements NavigableMap {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AbstractMapBasedMultimap f9112h;

    public p(AbstractMapBasedMultimap r5, NavigableMap r10) {
        this.f9112h = r5;
        super(r5, r10);
    }

    @Override // com.google.common.collect.s, com.google.common.collect.o7
    public final Set b() {
        return new q(this.f9112h, i());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object r5) {
        Map.Entry r10 = i().ceilingEntry(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return d(r10);
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object r5) {
        return i().ceilingKey(r5);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet descendingKeySet() {
        return (NavigableSet) super.f();
    }

    @Override // java.util.NavigableMap
    public final NavigableMap descendingMap() {
        NavigableMap r5 = i().descendingMap();
        return new p(this.f9112h, r5);
    }

    @Override // com.google.common.collect.s
    public final SortedSet e() {
        return new q(this.f9112h, i());
    }

    @Override // com.google.common.collect.s
    public final SortedSet f() {
        return (NavigableSet) super.f();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        Map.Entry r5 = i().firstEntry();
        if (r5 != null) goto L6;
        return null;
    L6:
        return d(r5);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object r5) {
        Map.Entry r10 = i().floorEntry(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return d(r10);
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object r5) {
        return i().floorKey(r5);
    }

    @Override // com.google.common.collect.s
    public final /* bridge */ /* synthetic */ SortedMap g() {
        return i();
    }

    public final Map.Entry h(Iterator r5) {
        if (r5.hasNext() == true) goto L6;
        return null;
    L6:
        Map.Entry r10 = (Map.Entry) r5.next();
        AbstractMapBasedMultimap r11 = this.f9112h;
        Collection r12 = r11.createCollection();
        r12.addAll((Collection) r10.getValue());
        r5.remove();
        return new ImmutableEntry(r10.getKey(), r11.unmodifiableCollectionSubclass(r12));
    }

    @Override // com.google.common.collect.s, java.util.SortedMap, java.util.NavigableMap
    public final SortedMap headMap(Object r5) {
        return headMap(r5, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object r5) {
        Map.Entry r10 = i().higherEntry(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return d(r10);
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object r5) {
        return i().higherKey(r5);
    }

    public final NavigableMap i() {
        return (NavigableMap) ((SortedMap) this.d);
    }

    @Override // com.google.common.collect.s, com.google.common.collect.n, com.google.common.collect.o7, java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return (NavigableSet) super.f();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        Map.Entry r5 = i().lastEntry();
        if (r5 != null) goto L6;
        return null;
    L6:
        return d(r5);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object r5) {
        Map.Entry r10 = i().lowerEntry(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return d(r10);
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object r5) {
        return i().lowerKey(r5);
    }

    @Override // java.util.NavigableMap
    public final NavigableSet navigableKeySet() {
        return (NavigableSet) super.f();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        return h(entrySet().iterator());
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        return h(((o7) descendingMap()).entrySet().iterator());
    }

    @Override // com.google.common.collect.s, java.util.SortedMap, java.util.NavigableMap
    public final SortedMap subMap(Object r5, Object r10) {
        return subMap(r5, true, r10, false);
    }

    @Override // com.google.common.collect.s, java.util.SortedMap, java.util.NavigableMap
    public final SortedMap tailMap(Object r5) {
        return tailMap(r5, true);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object r5, boolean r10) {
        NavigableMap r11 = i().headMap(r5, r10);
        return new p(this.f9112h, r11);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object r5, boolean r10, Object r11, boolean r12) {
        NavigableMap r13 = i().subMap(r5, r10, r11, r12);
        return new p(this.f9112h, r13);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object r5, boolean r10) {
        NavigableMap r11 = i().tailMap(r5, r10);
        return new p(this.f9112h, r11);
    }
}
