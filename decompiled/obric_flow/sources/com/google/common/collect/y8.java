package com.google.common.collect;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public final class y8 extends f9 implements SortedMap {
    public final /* synthetic */ StandardRowSortedTable f;

    public y8(StandardRowSortedTable r5) {
        this.f = r5;
        super(r5, 1);
    }

    @Override // com.google.common.collect.o7
    public final Set b() {
        return new j7(this);
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return StandardRowSortedTable.access$100(this.f).comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return StandardRowSortedTable.access$100(this.f).firstKey();
    }

    @Override // java.util.SortedMap
    public final SortedMap headMap(Object r5) {
        r5.getClass();
        StandardRowSortedTable r10 = this.f;
        return new StandardRowSortedTable(StandardRowSortedTable.access$100(r10).headMap(r5), r10.factory).rowMap();
    }

    @Override // com.google.common.collect.f9, com.google.common.collect.o7, java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return (SortedSet) super.keySet();
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return StandardRowSortedTable.access$100(this.f).lastKey();
    }

    @Override // java.util.SortedMap
    public final SortedMap subMap(Object r5, Object r10) {
        r5.getClass();
        r10.getClass();
        StandardRowSortedTable r11 = this.f;
        return new StandardRowSortedTable(StandardRowSortedTable.access$100(r11).subMap(r5, r10), r11.factory).rowMap();
    }

    @Override // java.util.SortedMap
    public final SortedMap tailMap(Object r5) {
        r5.getClass();
        StandardRowSortedTable r10 = this.f;
        return new StandardRowSortedTable(StandardRowSortedTable.access$100(r10).tailMap(r5), r10.factory).rowMap();
    }
}
