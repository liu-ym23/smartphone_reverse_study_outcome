package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public class j7 extends a9 implements SortedSet {
    @Override // com.google.common.collect.a9
    public /* bridge */ /* synthetic */ Map b() {
        return c();
    }

    public SortedMap c() {
        return (SortedMap) ((Map) this.f8898c);
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return c().comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        return c().firstKey();
    }

    public SortedSet headSet(Object r5) {
        return new j7(c().headMap(r5));
    }

    @Override // java.util.SortedSet
    public final Object last() {
        return c().lastKey();
    }

    public SortedSet subSet(Object r5, Object r10) {
        return new j7(c().subMap(r5, r10));
    }

    public SortedSet tailSet(Object r5) {
        return new j7(c().tailMap(r5));
    }
}
