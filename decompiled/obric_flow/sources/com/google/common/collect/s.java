package com.google.common.collect;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public class s extends n implements SortedMap {
    public SortedSet f;
    public final /* synthetic */ AbstractMapBasedMultimap g;

    public s(AbstractMapBasedMultimap r5, SortedMap r10) {
        this.g = r5;
        super(r5, r10);
    }

    @Override // com.google.common.collect.o7
    public /* bridge */ /* synthetic */ Set b() {
        return e();
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return g().comparator();
    }

    public SortedSet e() {
        return new t(this.g, g());
    }

    public SortedSet f() {
        SortedSet r5 = this.f;
        if (r5 != null) goto L6;
        SortedSet r10 = e();
        this.f = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return g().firstKey();
    }

    public SortedMap g() {
        return (SortedMap) this.d;
    }

    public SortedMap headMap(Object r5) {
        SortedMap r10 = g().headMap(r5);
        return new s(this.g, r10);
    }

    @Override // com.google.common.collect.n, com.google.common.collect.o7, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return f();
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return g().lastKey();
    }

    public SortedMap subMap(Object r5, Object r10) {
        SortedMap r11 = g().subMap(r5, r10);
        return new s(this.g, r11);
    }

    public SortedMap tailMap(Object r5) {
        SortedMap r10 = g().tailMap(r5);
        return new s(this.g, r10);
    }
}
