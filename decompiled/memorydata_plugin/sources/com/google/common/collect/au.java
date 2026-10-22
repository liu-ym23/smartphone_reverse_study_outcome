package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public interface au<R, C, V> extends be<R, C, V> {
    @Override // com.google.common.collect.be
    /* bridge */ /* synthetic */ default Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.be
    SortedSet<R> rowKeySet();

    @Override // com.google.common.collect.be
    /* bridge */ /* synthetic */ default Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.be
    SortedMap<R, Map<C, V>> rowMap();
}
