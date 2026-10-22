package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class HashBasedTable<R, C, V> extends StandardTable<R, C, V> {
    private static final long serialVersionUID = 0;

    private static class Factory<C, V> implements com.google.common.base.r<Map<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final int expectedSize;

        Factory(int r1) {
            this.expectedSize = r1;
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public Map<C, V> get() {
            return Maps.c(this.expectedSize);
        }
    }

    HashBasedTable(Map<R, Map<C, V>> r3, Factory<C, V> r4) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), r4);
    }

    public static <R, C, V> HashBasedTable<R, C, V> create() {
        return new HashBasedTable(new LinkedHashMap(), new Factory(0));
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(int r2, int r3) {
        o.a(r3, "expectedCellsPerRow");
        return new HashBasedTable(Maps.c(r2), new Factory(r3));
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(be<? extends R, ? extends C, ? extends V> r2) {
        be r3 = (be) ZeusTransformUtils.wrapperContextForParams(r2, be.class, "com.obric.memorydata.plugin");
        HashBasedTable<R, C, V> r0 = create();
        r0.putAll(r3);
        return r0;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map column(Object r1) {
        return super.column(r1);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean contains(Object r1, Object r2) {
        return super.contains(r1, r2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean containsColumn(Object r1) {
        return super.containsColumn(r1);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean containsRow(Object r1) {
        return super.containsRow(r1);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean containsValue(Object r1) {
        return super.containsValue(r1);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Object get(Object r1, Object r2) {
        return super.get(r1, r2);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Object put(Object r1, Object r2, Object r3) {
        return super.put(r1, r2, r3);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* synthetic */ void putAll(be r3) {
        super.putAll((be) ZeusTransformUtils.wrapperContextForParams(r3, be.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Object remove(Object r1, Object r2) {
        return super.remove(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map row(Object r1) {
        return super.row(r1);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map rowMap() {
        return super.rowMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.be
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }
}
