package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    private final int[] cellColumnIndices;
    private final int[] cellRowIndices;
    private final int[] columnCounts;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final int[] rowCounts;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;
    private final V[][] values;

    public final class Column extends ImmutableArrayMap<R, V> {
        private final int columnIndex;
        final /* synthetic */ DenseImmutableTable this$0;

        public Column(DenseImmutableTable r5, int r10) {
            this.this$0 = r5;
            super(DenseImmutableTable.access$500(r5)[r10]);
            this.columnIndex = r10;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public V getValue(int r5) {
            return (V) DenseImmutableTable.access$400(this.this$0)[r5][this.columnIndex];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.access$600(this.this$0);
        }
    }

    public final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        final /* synthetic */ DenseImmutableTable this$0;

        public ColumnMap(DenseImmutableTable r5, l2 r10) {
            this.this$0 = r5;
            super(DenseImmutableTable.access$500(r5).length);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public /* bridge */ /* synthetic */ Object getValue(int r5) {
            return getValue(r5);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.access$300(this.this$0);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, V> getValue(int r5) {
            return new Column(this.this$0, r5);
        }
    }

    public static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        private final int size;

        public ImmutableArrayMap(int r5) {
            this.size = r5;
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            if (this.size != keyToIndex().size()) goto L6;
            return keyToIndex().keySet();
        L6:
            return super.createKeySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public ga entryIterator() {
            return new m2(this);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public V get(Object r5) {
            Integer r10 = keyToIndex().get(r5);
            if (r10 != null) goto L6;
            return null;
        L6:
            return getValue(r10.intValue());
        }

        public K getKey(int r5) {
            return keyToIndex().keySet().asList().get(r5);
        }

        public abstract V getValue(int r5);

        public abstract ImmutableMap<K, Integer> keyToIndex();

        @Override // java.util.Map
        public int size() {
            return this.size;
        }
    }

    public final class Row extends ImmutableArrayMap<C, V> {
        private final int rowIndex;
        final /* synthetic */ DenseImmutableTable this$0;

        public Row(DenseImmutableTable r5, int r10) {
            this.this$0 = r5;
            super(DenseImmutableTable.access$200(r5)[r10]);
            this.rowIndex = r10;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public V getValue(int r5) {
            return (V) DenseImmutableTable.access$400(this.this$0)[this.rowIndex][r5];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.access$300(this.this$0);
        }
    }

    public final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        final /* synthetic */ DenseImmutableTable this$0;

        public RowMap(DenseImmutableTable r5, l2 r10) {
            this.this$0 = r5;
            super(DenseImmutableTable.access$200(r5).length);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public /* bridge */ /* synthetic */ Object getValue(int r5) {
            return getValue(r5);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.access$600(this.this$0);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, V> getValue(int r5) {
            return new Row(this.this$0, r5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DenseImmutableTable(ImmutableList<k9> r10, ImmutableSet<R> r11, ImmutableSet<C> r12) {
        int r5 = 0;
        this.values = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r11.size(), r12.size()}));
        ImmutableMap<R, Integer> r13 = p7.M(r11);
        this.rowKeyToIndex = r13;
        ImmutableMap<C, Integer> r14 = p7.M(r12);
        this.columnKeyToIndex = r14;
        this.rowCounts = new int[r13.size()];
        this.columnCounts = new int[r14.size()];
        int[] r15 = new int[r10.size()];
        int[] r16 = new int[r10.size()];
    L4:
        if (r5 >= r10.size()) goto L6;
        k9 r17 = r10.get(r5);
        Object r18 = r17.getRowKey();
        Object r19 = r17.getColumnKey();
        Integer r20 = this.rowKeyToIndex.get(r18);
        Objects.requireNonNull(r20);
        int r21 = r20.intValue();
        Integer r22 = this.columnKeyToIndex.get(r19);
        Objects.requireNonNull(r22);
        int r23 = r22.intValue();
        checkNoDuplicate(r18, r19, this.values[r21][r23], r17.getValue());
        ((V[][]) this.values)[r21][r23] = r17.getValue();
        int[] r24 = this.rowCounts;
        r24[r21] = r24[r21] + 1;
        int[] r25 = this.columnCounts;
        r25[r23] = r25[r23] + 1;
        r15[r5] = r21;
        r16[r5] = r23;
        r5 = r5 + 1;
        goto L4
    L6:
        this.cellRowIndices = r15;
        this.cellColumnIndices = r16;
        this.rowMap = new RowMap(this, null);
        this.columnMap = new ColumnMap(this, null);
    }

    public static /* synthetic */ int[] access$200(DenseImmutableTable r5) {
        return r5.rowCounts;
    }

    public static /* synthetic */ ImmutableMap access$300(DenseImmutableTable r5) {
        return r5.columnKeyToIndex;
    }

    public static /* synthetic */ Object[][] access$400(DenseImmutableTable r5) {
        return r5.values;
    }

    public static /* synthetic */ int[] access$500(DenseImmutableTable r5) {
        return r5.columnCounts;
    }

    public static /* synthetic */ ImmutableMap access$600(DenseImmutableTable r5) {
        return r5.rowKeyToIndex;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.l9
    public V get(Object r5, Object r10) {
        Integer r11 = this.rowKeyToIndex.get(r5);
        Integer r12 = this.columnKeyToIndex.get(r10);
        if (r11 == null) goto L7;
        if (r12 == null) goto L7;
        return this.values[r11.intValue()][r12.intValue()];
    L7:
        return null;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public k9 getCell(int r5) {
        int r10 = this.cellRowIndices[r5];
        int r11 = this.cellColumnIndices[r5];
        R r12 = rowKeySet().asList().get(r10);
        C r13 = columnKeySet().asList().get(r11);
        V r14 = this.values[r10][r11];
        Objects.requireNonNull(r14);
        return ImmutableTable.cellOf(r12, r13, r14);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int r5) {
        V r10 = this.values[this.cellRowIndices[r5]][this.cellColumnIndices[r5]];
        Objects.requireNonNull(r10);
        return r10;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.RegularImmutableTable, com.google.common.collect.ImmutableTable, com.google.common.collect.l9
    public int size() {
        return this.cellRowIndices.length;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.l9
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.l9
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.rowMap);
    }
}
