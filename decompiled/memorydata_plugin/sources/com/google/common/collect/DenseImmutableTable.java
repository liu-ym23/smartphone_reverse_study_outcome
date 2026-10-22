package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    /* JADX INFO: renamed from: com.google.common.collect.DenseImmutableTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class Column extends ImmutableArrayMap<R, V> {
        private final int columnIndex;
        final /* synthetic */ DenseImmutableTable this$0;

        Column(DenseImmutableTable r1, int r2) {
            this.this$0 = r1;
            super(DenseImmutableTable.access$500(r1)[r2]);
            this.columnIndex = r2;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        V getValue(int r2) {
            return (V) DenseImmutableTable.access$400(this.this$0)[r2][this.columnIndex];
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.access$600(this.this$0);
        }
    }

    private final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        final /* synthetic */ DenseImmutableTable this$0;

        private ColumnMap(DenseImmutableTable r1) {
            this.this$0 = r1;
            super(DenseImmutableTable.access$500(r1).length);
        }

        /* synthetic */ ColumnMap(DenseImmutableTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<R, V> getValue(int r2) {
            return new Column(this.this$0, r2);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        /* bridge */ /* synthetic */ Object getValue(int r1) {
            return getValue(r1);
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.access$300(this.this$0);
        }
    }

    private static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        private final int size;

        ImmutableArrayMap(int r1) {
            this.size = r1;
        }

        private boolean isFull() {
            if (this.size != keyToIndex().size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        ImmutableSet<K> createKeySet() {
            if (isFull() == false) goto L6;
            return keyToIndex().keySet();
        L6:
            return super.createKeySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        bj<Map.Entry<K, V>> entryIterator() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public V get(Object r3) {
            Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(keyToIndex().get(r3), Integer.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            return getValue(r4.intValue());
        }

        K getKey(int r1) {
            return keyToIndex().keySet().asList().get(r1);
        }

        abstract V getValue(int r1);

        abstract ImmutableMap<K, Integer> keyToIndex();

        @Override // java.util.Map
        public int size() {
            return this.size;
        }
    }

    private final class Row extends ImmutableArrayMap<C, V> {
        private final int rowIndex;
        final /* synthetic */ DenseImmutableTable this$0;

        Row(DenseImmutableTable r1, int r2) {
            this.this$0 = r1;
            super(DenseImmutableTable.access$200(r1)[r2]);
            this.rowIndex = r2;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        V getValue(int r2) {
            return (V) DenseImmutableTable.access$400(this.this$0)[this.rowIndex][r2];
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.access$300(this.this$0);
        }
    }

    private final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        final /* synthetic */ DenseImmutableTable this$0;

        private RowMap(DenseImmutableTable r1) {
            this.this$0 = r1;
            super(DenseImmutableTable.access$200(r1).length);
        }

        /* synthetic */ RowMap(DenseImmutableTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<C, V> getValue(int r2) {
            return new Row(this.this$0, r2);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        /* bridge */ /* synthetic */ Object getValue(int r1) {
            return getValue(r1);
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.access$600(this.this$0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    DenseImmutableTable(ImmutableList<be.a<R, C, V>> r10, ImmutableSet<R> r11, ImmutableSet<C> r12) {
        int r1 = 0;
        this.values = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r11.size(), r12.size()}));
        ImmutableMap<R, Integer> r13 = Maps.a(r11);
        this.rowKeyToIndex = r13;
        ImmutableMap<C, Integer> r14 = Maps.a(r12);
        this.columnKeyToIndex = r14;
        this.rowCounts = new int[r13.size()];
        this.columnCounts = new int[r14.size()];
        int[] r15 = new int[r10.size()];
        int[] r16 = new int[r10.size()];
    L4:
        if (r1 >= r10.size()) goto L6;
        be.a r0 = (be.a) ZeusTransformUtils.preCheckCast(r10.get(r1), be.a.class, "com.obric.memorydata.plugin");
        Object r2 = r0.getRowKey();
        Object r5 = r0.getColumnKey();
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((Integer) ZeusTransformUtils.preCheckCast(this.rowKeyToIndex.get(r2), Integer.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((Integer) ZeusTransformUtils.preCheckCast(this.columnKeyToIndex.get(r5), Integer.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin")).intValue();
        checkNoDuplicate(r2, r5, this.values[r6][r4], r0.getValue());
        ((V[][]) this.values)[r6][r4] = r0.getValue();
        int[] r3 = this.rowCounts;
        r3[r6] = r3[r6] + 1;
        int[] r7 = this.columnCounts;
        r7[r4] = r7[r4] + 1;
        r15[r1] = r6;
        r16[r1] = r4;
        r1 = r1 + 1;
        goto L4
    L6:
        this.cellRowIndices = r15;
        this.cellColumnIndices = r16;
        AnonymousClass1 r17 = null;
        this.rowMap = new RowMap(this, r17);
        this.columnMap = new ColumnMap(this, r17);
    }

    static /* synthetic */ int[] access$200(DenseImmutableTable r0) {
        return r0.rowCounts;
    }

    static /* synthetic */ ImmutableMap access$300(DenseImmutableTable r0) {
        return r0.columnKeyToIndex;
    }

    static /* synthetic */ Object[][] access$400(DenseImmutableTable r0) {
        return r0.values;
    }

    static /* synthetic */ int[] access$500(DenseImmutableTable r0) {
        return r0.columnCounts;
    }

    static /* synthetic */ ImmutableMap access$600(DenseImmutableTable r0) {
        return r0.rowKeyToIndex;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.be
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.ImmutableTable
    ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i, com.google.common.collect.be
    public V get(Object r3, Object r4) {
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(this.rowKeyToIndex.get(r3), Integer.class, "com.obric.memorydata.plugin");
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(this.columnKeyToIndex.get(r4), Integer.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        if (r6 == null) goto L7;
        return this.values[r5.intValue()][r6.intValue()];
    L7:
        return null;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    be.a<R, C, V> getCell(int r4) {
        int r0 = this.cellRowIndices[r4];
        int r5 = this.cellColumnIndices[r4];
        return cellOf(rowKeySet().asList().get(r0), columnKeySet().asList().get(r5), Objects.requireNonNull(this.values[r0][r5]));
    }

    @Override // com.google.common.collect.RegularImmutableTable
    V getValue(int r3) {
        return (V) Objects.requireNonNull(this.values[this.cellRowIndices[r3]][this.cellColumnIndices[r3]]);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.be
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.rowMap);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.be
    public int size() {
        return this.cellRowIndices.length;
    }
}
