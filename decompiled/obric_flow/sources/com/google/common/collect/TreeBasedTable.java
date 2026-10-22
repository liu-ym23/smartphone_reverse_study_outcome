package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    public static class Factory<C, V> implements com.google.common.base.e0, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        public Factory(Comparator<? super C> r5) {
            this.comparator = r5;
        }

        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // java.util.function.Supplier
        public TreeMap<C, V> get() {
            return new TreeMap(this.comparator);
        }
    }

    public TreeBasedTable(Comparator<? super R> r5, Comparator<? super C> r10) {
        super(new TreeMap(r5), new Factory(r10));
        this.columnComparator = r10;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable(g8.natural(), g8.natural());
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

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
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

    @Override // com.google.common.collect.StandardTable
    public Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> r5 = columnComparator();
        Collection<Map<C, V>> r10 = this.backingMap.values();
        t9 r11 = new t9();
        r10.getClass();
        a5 r12 = new a5(r10, r11, 1);
        com.google.common.base.b0.n(r5, "comparator");
        return new c9(new b4(r12, r5), r5);
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
        return row(r5);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        Comparator<? super R> r5 = rowKeySet().comparator();
        Objects.requireNonNull(r5);
        return r5;
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
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

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> r5) {
        TreeBasedTable<R, C, V> r10 = new TreeBasedTable(r5.rowComparator(), r5.columnComparator());
        r10.putAll(r5);
        return r10;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.l9
    public SortedMap<C, V> row(R r5) {
        return new u9(this, r5, null, null);
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.l9
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.l9
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> r5, Comparator<? super C> r10) {
        r5.getClass();
        r10.getClass();
        return new TreeBasedTable(r5, r10);
    }
}
