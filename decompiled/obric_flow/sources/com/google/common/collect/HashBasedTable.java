package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class HashBasedTable<R, C, V> extends StandardTable<R, C, V> {
    private static final long serialVersionUID = 0;

    public static class Factory<C, V> implements com.google.common.base.e0, Serializable {
        private static final long serialVersionUID = 0;
        final int expectedSize;

        public Factory(int r5) {
            this.expectedSize = r5;
        }

        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // java.util.function.Supplier
        public Map<C, V> get() {
            return p7.a0(this.expectedSize);
        }
    }

    public HashBasedTable(Map<R, Map<C, V>> r5, Factory<C, V> r10) {
        super(r5, r10);
    }

    public static <R, C, V> HashBasedTable<R, C, V> create() {
        return new HashBasedTable(new LinkedHashMap(), new Factory(0));
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map column(Object r5) {
        return super.column(r5);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ boolean contains(Object r5, Object r10) {
        return super.contains(r5, r10);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ boolean containsColumn(Object r5) {
        return super.containsColumn(r5);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ boolean containsRow(Object r5) {
        return super.containsRow(r5);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ boolean containsValue(Object r5) {
        return super.containsValue(r5);
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ boolean equals(Object r5) {
        return super.equals(r5);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Object get(Object r5, Object r10) {
        return super.get(r5, r10);
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Object put(Object r5, Object r10, Object r11) {
        return super.put(r5, r10, r11);
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ void putAll(l9 r5) {
        super.putAll(r5);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Object remove(Object r5, Object r10) {
        return super.remove(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map row(Object r5) {
        return super.row(r5);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map rowMap() {
        return super.rowMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.s0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(int r5, int r10) {
        p7.q(r10, "expectedCellsPerRow");
        return new HashBasedTable(p7.a0(r5), new Factory(r10));
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(l9 r5) {
        HashBasedTable<R, C, V> r10 = create();
        r10.putAll(r5);
        return r10;
    }
}
