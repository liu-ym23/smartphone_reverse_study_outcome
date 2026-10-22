package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
public final class l7 extends k7 implements SortedMap {
    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return ((SortedMap) this.f9057a).comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return ((SortedMap) this.f9057a).firstKey();
    }

    @Override // java.util.SortedMap
    public final SortedMap headMap(Object r5) {
        return new l7(((SortedMap) this.f9057a).headMap(r5), this.f9058b);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return ((SortedMap) this.f9057a).lastKey();
    }

    @Override // java.util.SortedMap
    public final SortedMap subMap(Object r5, Object r10) {
        return new l7(((SortedMap) this.f9057a).subMap(r5, r10), this.f9058b);
    }

    @Override // java.util.SortedMap
    public final SortedMap tailMap(Object r5) {
        return new l7(((SortedMap) this.f9057a).tailMap(r5), this.f9058b);
    }
}
