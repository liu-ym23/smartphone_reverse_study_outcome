package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    final C singleColumnKey;
    final R singleRowKey;
    final V singleValue;

    SingletonImmutableTable(be.a<R, C, V> r3) {
        be.a r4 = (be.a) ZeusTransformUtils.wrapperContextForParams(r3, be.a.class, "com.obric.memorydata.plugin");
        this(r4.getRowKey(), r4.getColumnKey(), r4.getValue());
    }

    SingletonImmutableTable(R r1, C r2, V r3) {
        this.singleRowKey = (R) com.google.common.base.n.a(r1);
        this.singleColumnKey = (C) com.google.common.base.n.a(r2);
        this.singleValue = (V) com.google.common.base.n.a(r3);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.be
    public ImmutableMap<R, V> column(C r1) {
        com.google.common.base.n.a(r1);
        if (containsColumn(r1) == false) goto L6;
        return ImmutableMap.of(this.singleRowKey, this.singleValue);
    L6:
        return ImmutableMap.of();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map column(Object r1) {
        return column(r1);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.be
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    ImmutableSet<be.a<R, C, V>> createCellSet() {
        return ImmutableSet.of(cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    @Override // com.google.common.collect.ImmutableTable
    ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, new int[]{0}, new int[]{0});
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    ImmutableCollection<V> createValues() {
        return ImmutableSet.of(this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.be
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.be
    public int size() {
        return 1;
    }
}
