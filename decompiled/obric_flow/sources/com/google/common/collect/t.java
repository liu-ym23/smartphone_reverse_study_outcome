package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public class t extends o implements SortedSet {
    public final /* synthetic */ AbstractMapBasedMultimap f;

    public t(AbstractMapBasedMultimap r5, SortedMap r10) {
        this.f = r5;
        super(r5, r10);
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
        SortedMap r10 = c().headMap(r5);
        return new t(this.f, r10);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        return c().lastKey();
    }

    public SortedSet subSet(Object r5, Object r10) {
        SortedMap r11 = c().subMap(r5, r10);
        return new t(this.f, r11);
    }

    public SortedSet tailSet(Object r5) {
        SortedMap r10 = c().tailMap(r5);
        return new t(this.f, r10);
    }
}
