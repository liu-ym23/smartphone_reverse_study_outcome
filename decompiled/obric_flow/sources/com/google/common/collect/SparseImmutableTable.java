package com.google.common.collect;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    static final ImmutableTable<Object, Object, Object> EMPTY = null;
    private final int[] cellColumnInRowIndices;
    private final int[] cellRowIndices;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    static {
        EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SparseImmutableTable(ImmutableList<k9> r10, ImmutableSet<R> r11, ImmutableSet<C> r12) {
        ImmutableMap r5 = p7.M(r11);
        LinkedHashMap r13 = p7.Z();
        ga r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.put(r14.next(), new LinkedHashMap());
        goto L4
    L6:
        LinkedHashMap r15 = p7.Z();
        ga r16 = r12.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        r15.put(r16.next(), new LinkedHashMap());
        goto L8
    L10:
        int[] r17 = new int[r10.size()];
        int[] r18 = new int[r10.size()];
        int r19 = 0;
    L12:
        if (r19 >= r10.size()) goto L14;
        k9 r20 = r10.get(r19);
        Object r21 = r20.getRowKey();
        Object r22 = r20.getColumnKey();
        Object r23 = r20.getValue();
        Integer r24 = (Integer) r5.get(r21);
        Objects.requireNonNull(r24);
        r17[r19] = r24.intValue();
        Map r25 = (Map) r13.get(r21);
        Objects.requireNonNull(r25);
        r18[r19] = r25.size();
        checkNoDuplicate(r21, r22, r25.put(r22, r23), r23);
        Map r26 = (Map) r15.get(r22);
        Objects.requireNonNull(r26);
        r26.put(r21, r23);
        r19 = r19 + 1;
        goto L12
    L14:
        this.cellRowIndices = r17;
        this.cellColumnInRowIndices = r18;
        x3 r110 = new x3(r13.size());
        Iterator r111 = r13.entrySet().iterator();
    L16:
        if (r111.hasNext() == false) goto L18;
        Map.Entry r27 = (Map.Entry) r111.next();
        r110.g(r27.getKey(), ImmutableMap.copyOf((Map) r27.getValue()));
        goto L16
    L18:
        this.rowMap = r110.d();
        x3 r112 = new x3(r15.size());
        Iterator r113 = r15.entrySet().iterator();
    L20:
        if (r113.hasNext() == false) goto L22;
        Map.Entry r114 = (Map.Entry) r113.next();
        r112.g(r114.getKey(), ImmutableMap.copyOf((Map) r114.getValue()));
        goto L20
    L22:
        this.columnMap = r112.d();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        ImmutableMap r5 = p7.M(columnKeySet());
        int[] r10 = new int[cellSet().size()];
        ga r11 = cellSet().iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L7;
        Integer r13 = (Integer) r5.get(((k9) r11.next()).getColumnKey());
        Objects.requireNonNull(r13);
        r10[r12] = r13.intValue();
        r12 = r12 + 1;
        goto L4
    L7:
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, r10);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public k9 getCell(int r5) {
        int r10 = this.cellRowIndices[r5];
        Map.Entry<R, ImmutableMap<C, V>> r11 = this.rowMap.entrySet().asList().get(r10);
        ImmutableMap<C, V> r12 = r11.getValue();
        int r13 = this.cellColumnInRowIndices[r5];
        Map.Entry<C, V> r14 = r12.entrySet().asList().get(r13);
        return ImmutableTable.cellOf(r11.getKey(), r14.getKey(), r14.getValue());
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int r5) {
        int r10 = this.cellRowIndices[r5];
        ImmutableMap<C, V> r11 = this.rowMap.values().asList().get(r10);
        int r12 = this.cellColumnInRowIndices[r5];
        return r11.values().asList().get(r12);
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
