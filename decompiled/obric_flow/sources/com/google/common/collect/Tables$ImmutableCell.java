package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Tables$ImmutableCell<R, C, V> extends r9 implements Serializable {
    private static final long serialVersionUID = 0;
    private final C columnKey;
    private final R rowKey;
    private final V value;

    public Tables$ImmutableCell(R r5, C r10, V r11) {
        this.rowKey = r5;
        this.columnKey = r10;
        this.value = r11;
    }

    @Override // com.google.common.collect.k9
    public C getColumnKey() {
        return this.columnKey;
    }

    @Override // com.google.common.collect.k9
    public R getRowKey() {
        return this.rowKey;
    }

    @Override // com.google.common.collect.k9
    public V getValue() {
        return this.value;
    }
}
