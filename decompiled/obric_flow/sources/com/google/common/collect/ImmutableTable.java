package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableTable<R, C, V> extends s0 implements Serializable {

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final int[] cellColumnIndices;
        private final int[] cellRowIndices;
        private final Object[] cellValues;
        private final Object[] columnKeys;
        private final Object[] rowKeys;

        public SerializedForm(Object[] r5, Object[] r10, Object[] r11, int[] r12, int[] r13) {
            this.rowKeys = r5;
            this.columnKeys = r10;
            this.cellValues = r11;
            this.cellRowIndices = r12;
            this.cellColumnIndices = r13;
        }

        public static SerializedForm create(ImmutableTable<?, ?, ?> r10, int[] r11, int[] r12) {
            return new SerializedForm(r10.rowKeySet().toArray(), r10.columnKeySet().toArray(), r10.values().toArray(), r11, r12);
        }

        public Object readResolve() {
            Object[] r5 = this.cellValues;
            if (r5.length != 0) goto L7;
            return ImmutableTable.of();
        L7:
            if (r5.length == 1) goto L9;
            Object[] r10 = new Object[r5.length];
            int r11 = 0;
            int r12 = 0;
            boolean r13 = false;
        L11:
            Object[] r14 = this.cellValues;
            if (r11 >= r14.length) goto L21;
            k9 r15 = ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[r11]], this.columnKeys[this.cellColumnIndices[r11]], r14[r11]);
            r15.getClass();
            int r16 = r12 + 1;
            if (r10.length >= r16) goto L17;
            r10 = Arrays.copyOf(r10, p7.B(r10.length, r16));
        L16:
            r13 = false;
        L19:
            r10[r12] = r15;
            r11 = r11 + 1;
            r12 = r12 + 1;
            goto L11
        L17:
            if (r13 == false) goto L19;
            r10 = Arrays.copyOf(r10, r10.length);
            goto L16
        L21:
            return RegularImmutableTable.forOrderedComponents(ImmutableList.asImmutableList(r10, r12), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
        L9:
            return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], r5[0]);
        }
    }

    public ImmutableTable() {
    }

    public static <R, C, V> z4 builder() {
        return new z4();
    }

    public static <R, C, V> k9 cellOf(R r5, C r10, V r11) {
        com.google.common.base.b0.n(r5, "rowKey");
        com.google.common.base.b0.n(r10, "columnKey");
        com.google.common.base.b0.n(r11, "value");
        return new Tables$ImmutableCell(r5, r10, r11);
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(l9 r5) {
        if ((r5 instanceof ImmutableTable) == false) goto L7;
        return (ImmutableTable) r5;
    L7:
        return copyOf(r5.cellSet());
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY;
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(final Function<? super T, ? extends R> r5, final Function<? super T, ? extends C> r10, final Function<? super T, ? extends V> r11) {
        com.google.common.base.b0.n(r5, "rowFunction");
        com.google.common.base.b0.n(r10, "columnFunction");
        com.google.common.base.b0.n(r11, "valueFunction");
        return Collector.of(new i1(13), new o9(r5, r10, r11), new e1(13), new h(26), new Collector.Characteristics[0]);
    }

    @Override // com.google.common.collect.s0
    public /* bridge */ /* synthetic */ Iterator cellIterator() {
        return cellIterator();
    }

    @Override // com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Set cellSet() {
        return cellSet();
    }

    @Override // com.google.common.collect.s0
    public final Spliterator<k9> cellSpliterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.l9
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map column(Object r5) {
        return column(r5);
    }

    @Override // com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return columnKeySet();
    }

    @Override // com.google.common.collect.l9
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.l9
    public boolean contains(Object r5, Object r10) {
        if (get(r5, r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.l9
    public boolean containsColumn(Object r5) {
        return p7.k0(columnMap(), r5);
    }

    @Override // com.google.common.collect.l9
    public boolean containsRow(Object r5) {
        return p7.k0(rowMap(), r5);
    }

    @Override // com.google.common.collect.l9
    public boolean containsValue(Object r5) {
        return values().contains(r5);
    }

    @Override // com.google.common.collect.s0
    public abstract ImmutableSet<k9> createCellSet();

    @Override // com.google.common.collect.s0
    public /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    public abstract SerializedForm createSerializedForm();

    @Override // com.google.common.collect.s0
    public abstract ImmutableCollection<V> createValues();

    @Override // com.google.common.collect.s0
    public /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ boolean equals(Object r5) {
        return super.equals(r5);
    }

    @Override // com.google.common.collect.l9
    public Object get(Object r5, Object r10) {
        Map r11 = (Map) p7.l0(rowMap(), r5);
        if (r11 != null) goto L6;
        return null;
    L6:
        return p7.l0(r11, r10);
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.l9
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.l9
    @Deprecated
    public final V put(R r5, C r10, V r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.l9
    @Deprecated
    public final void putAll(l9 r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.l9
    @Deprecated
    public final V remove(Object r5, Object r10) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map row(Object r5) {
        return row(r5);
    }

    @Override // com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.l9
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.l9
    public abstract /* synthetic */ int size();

    @Override // com.google.common.collect.s0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.s0
    public final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    public final Object writeReplace() {
        return createSerializedForm();
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r5, C r10, V r11) {
        return new SingletonImmutableTable(r5, r10, r11);
    }

    @Override // com.google.common.collect.s0
    public final ga cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.l9
    public ImmutableSet<k9> cellSet() {
        Set r5 = this.f9150a;
        if (r5 != null) goto L6;
        r5 = createCellSet();
        this.f9150a = r5;
    L6:
        return (ImmutableSet) r5;
    }

    @Override // com.google.common.collect.l9
    public ImmutableMap<R, V> column(C r5) {
        com.google.common.base.b0.n(r5, "columnKey");
        return (ImmutableMap) com.google.common.base.b0.y((ImmutableMap) columnMap().get(r5), ImmutableMap.of());
    }

    @Override // com.google.common.collect.l9
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.l9
    public ImmutableMap<C, V> row(R r5) {
        com.google.common.base.b0.n(r5, "rowKey");
        return (ImmutableMap) com.google.common.base.b0.y((ImmutableMap) rowMap().get(r5), ImmutableMap.of());
    }

    @Override // com.google.common.collect.l9
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.l9
    public ImmutableCollection<V> values() {
        Collection r5 = this.f9151b;
        if (r5 != null) goto L6;
        r5 = createValues();
        this.f9151b = r5;
    L6:
        return (ImmutableCollection) r5;
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends k9> r5) {
        z4 r10 = builder();
        Iterator<? extends k9> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        k9 r12 = r11.next();
        r10.getClass();
        boolean r13 = r12 instanceof Tables$ImmutableCell;
        ArrayList r14 = r10.f9244a;
        if (r13 == true) goto L7;
        r14.add(cellOf(r12.getRowKey(), r12.getColumnKey(), r12.getValue()));
        goto L4
    L7:
        com.google.common.base.b0.n(r12.getRowKey(), "row");
        com.google.common.base.b0.n(r12.getColumnKey(), "column");
        com.google.common.base.b0.n(r12.getValue(), "value");
        r14.add(r12);
        goto L4
    L10:
        return r10.a();
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(final Function<? super T, ? extends R> r5, final Function<? super T, ? extends C> r10, final Function<? super T, ? extends V> r11, final BinaryOperator<V> r12) {
        com.google.common.base.b0.n(r5, "rowFunction");
        com.google.common.base.b0.n(r10, "columnFunction");
        com.google.common.base.b0.n(r11, "valueFunction");
        com.google.common.base.b0.n(r12, "mergeFunction");
        return Collector.of(new i1(12), new m9(r5, r10, r11, r12), new n9(r12), new h(25), new Collector.Characteristics[0]);
    }
}
