package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    SparseImmutableTable(ImmutableList<be.a<R, C, V>> r11, ImmutableSet<R> r12, ImmutableSet<C> r13) {
        ImmutableMap r0 = Maps.a(r12);
        LinkedHashMap r1 = Maps.d();
        bj<R> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r1.put(r14.next(), new LinkedHashMap());
        goto L4
    L6:
        LinkedHashMap r15 = Maps.d();
        bj<C> r16 = r13.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        r15.put(r16.next(), new LinkedHashMap());
        goto L8
    L10:
        int[] r17 = new int[r11.size()];
        int[] r2 = new int[r11.size()];
        int r3 = 0;
    L12:
        if (r3 >= r11.size()) goto L14;
        be.a r4 = (be.a) ZeusTransformUtils.preCheckCast(r11.get(r3), be.a.class, "com.obric.memorydata.plugin");
        Object r6 = r4.getRowKey();
        Object r7 = r4.getColumnKey();
        Object r5 = r4.getValue();
        r17[r3] = ((Integer) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((Integer) ZeusTransformUtils.preCheckCast(r0.get(r6), Integer.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin")).intValue();
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((Map) ZeusTransformUtils.preCheckCast(r1.get(r6), Map.class, "com.obric.memorydata.plugin")), Map.class, "com.obric.memorydata.plugin");
        r2[r3] = r8.size();
        checkNoDuplicate(r6, r7, r8.put(r7, r5), r5);
        ((Map) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((Map) ZeusTransformUtils.preCheckCast(r15.get(r7), Map.class, "com.obric.memorydata.plugin")), Map.class, "com.obric.memorydata.plugin")).put(r6, r5);
        r3 = r3 + 1;
        goto L12
    L14:
        this.cellRowIndices = r17;
        this.cellColumnInRowIndices = r2;
        ImmutableMap.a r18 = new ImmutableMap.a(r1.size());
        Iterator r19 = r1.entrySet().iterator();
    L16:
        if (r19.hasNext() == false) goto L18;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r19.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r18.b(r9.getKey(), ImmutableMap.copyOf((Map) ZeusTransformUtils.preCheckCast(r9.getValue(), Map.class, "com.obric.memorydata.plugin")));
        goto L16
    L18:
        this.rowMap = r18.e();
        ImmutableMap.a r110 = new ImmutableMap.a(r15.size());
        Iterator r111 = r15.entrySet().iterator();
    L20:
        if (r111.hasNext() == false) goto L22;
        Map.Entry r112 = (Map.Entry) ZeusTransformUtils.preCheckCast(r111.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r110.b(r112.getKey(), ImmutableMap.copyOf((Map) ZeusTransformUtils.preCheckCast(r112.getValue(), Map.class, "com.obric.memorydata.plugin")));
        goto L20
    L22:
        this.columnMap = r110.e();
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
        ImmutableMap r0 = Maps.a(columnKeySet());
        int[] r1 = new int[cellSet().size()];
        bj<be.a<R, C, V>> r2 = cellSet().iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L7;
        r1[r3] = ((Integer) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((Integer) ZeusTransformUtils.preCheckCast(r0.get(((be.a) ZeusTransformUtils.preCheckCast(r2.next(), be.a.class, "com.obric.memorydata.plugin")).getColumnKey()), Integer.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r3 = r3 + 1;
        goto L4
    L7:
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, r1);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    be.a<R, C, V> getCell(int r5) {
        int r0 = this.cellRowIndices[r5];
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.rowMap.entrySet().asList().get(r0), Map.Entry.class, "com.obric.memorydata.plugin");
        ImmutableMap r2 = (ImmutableMap) ZeusTransformUtils.preCheckCast(r1.getValue(), ImmutableMap.class, "com.obric.memorydata.plugin");
        int r4 = this.cellColumnInRowIndices[r5];
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.entrySet().asList().get(r4), Map.Entry.class, "com.obric.memorydata.plugin");
        return cellOf(r1.getKey(), r6.getKey(), r6.getValue());
    }

    @Override // com.google.common.collect.RegularImmutableTable
    V getValue(int r4) {
        int r0 = this.cellRowIndices[r4];
        ImmutableMap r1 = (ImmutableMap) ZeusTransformUtils.preCheckCast(this.rowMap.values().asList().get(r0), ImmutableMap.class, "com.obric.memorydata.plugin");
        int r3 = this.cellColumnInRowIndices[r4];
        return r1.values().asList().get(r3);
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
