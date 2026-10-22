package com.google.common.collect;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
final class Tables$UnmodifiableRowSortedMap<R, C, V> extends Tables$UnmodifiableTable<R, C, V> implements r8 {
    private static final long serialVersionUID = 0;

    public Tables$UnmodifiableRowSortedMap(r8 r5) {
        super(r5);
    }

    @Override // com.google.common.collect.Tables$UnmodifiableTable, com.google.common.collect.e3, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ l9 delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Tables$UnmodifiableTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.Tables$UnmodifiableTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.Tables$UnmodifiableTable, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Tables$UnmodifiableTable, com.google.common.collect.l9
    public SortedSet<R> rowKeySet() {
        return Collections.unmodifiableSortedSet(delegate().rowKeySet());
    }

    @Override // com.google.common.collect.Tables$UnmodifiableTable, com.google.common.collect.l9
    public SortedMap<R, Map<C, V>> rowMap() {
        j8 r5 = p7.f9120a;
        return Collections.unmodifiableSortedMap(new l7(delegate().rowMap(), new f7(r5)));
    }

    @Override // com.google.common.collect.Tables$UnmodifiableTable, com.google.common.collect.e3, com.google.common.collect.z2
    public r8 delegate() {
        return (r8) super.delegate();
    }
}
