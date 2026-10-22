package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements r8 {
    private static final long serialVersionUID = 0;

    public StandardRowSortedTable(SortedMap<R, Map<C, V>> r5, com.google.common.base.e0 r10) {
        super(r5, r10);
    }

    public static SortedMap access$100(StandardRowSortedTable r5) {
        return (SortedMap) r5.backingMap;
    }

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Map createRowMap() {
        return createRowMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.StandardTable
    public SortedMap<R, Map<C, V>> createRowMap() {
        return new y8(this);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public SortedSet<R> rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) super.rowMap();
    }
}
