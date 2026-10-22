package com.google.common.collect;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableTable<R, C, V> extends i<R, C, V> implements Serializable {

    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final int[] cellColumnIndices;
        private final int[] cellRowIndices;
        private final Object[] cellValues;
        private final Object[] columnKeys;
        private final Object[] rowKeys;

        private SerializedForm(Object[] r1, Object[] r2, Object[] r3, int[] r4, int[] r5) {
            this.rowKeys = r1;
            this.columnKeys = r2;
            this.cellValues = r3;
            this.cellRowIndices = r4;
            this.cellColumnIndices = r5;
        }

        static SerializedForm create(ImmutableTable<?, ?, ?> r7, int[] r8, int[] r9) {
            return new SerializedForm(r7.rowKeySet().toArray(), r7.columnKeySet().toArray(), r7.values().toArray(), r8, r9);
        }

        Object readResolve() {
            Object[] r0 = this.cellValues;
            if (r0.length == 0) goto L5;
            int r3 = 0;
            if (r0.length == 1) goto L9;
            ImmutableList.a r1 = new ImmutableList.a(this.cellValues.length);
        L11:
            Object[] r2 = this.cellValues;
            if (r3 >= r2.length) goto L15;
            r1.b(ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[r3]], this.columnKeys[this.cellColumnIndices[r3]], r2[r3]));
            r3 = r3 + 1;
            goto L11
        L15:
            return RegularImmutableTable.forOrderedComponents(r1.a(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
        L9:
            return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], r0[0]);
        L5:
            return ImmutableTable.of();
        }
    }

    public static final class a<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<be.a<R, C, V>> f4478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Comparator<? super R> f4479b;
        private Comparator<? super C> c;

        public a() {
            this.f4478a = Lists.a();
        }

        a<R, C, V> a(a<R, C, V> r2) {
            this.f4478a.addAll(r2.f4478a);
            return this;
        }

        public a<R, C, V> a(be.a<? extends R, ? extends C, ? extends V> r3) {
            be.a<R, C, V> r4 = (be.a) ZeusTransformUtils.wrapperContextForParams(r3, be.a.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Tables.ImmutableCell.class) == false) goto L5;
            com.google.common.base.n.a(r4.getRowKey(), "row");
            com.google.common.base.n.a(r4.getColumnKey(), "column");
            com.google.common.base.n.a(r4.getValue(), EventBody.KEY_VALUE);
            this.f4478a.add(r4);
        L6:
            return this;
        L5:
            a(r4.getRowKey(), r4.getColumnKey(), r4.getValue());
            goto L6
        }

        public a<R, C, V> a(R r2, C r3, V r4) {
            this.f4478a.add(ImmutableTable.cellOf(r2, r3, r4));
            return this;
        }

        public ImmutableTable<R, C, V> a() {
            return b();
        }

        public ImmutableTable<R, C, V> b() {
            int r0 = this.f4478a.size();
            if (r0 == 0) goto L11;
            if (r0 == 1) goto L9;
            return RegularImmutableTable.forCells(this.f4478a, this.f4479b, this.c);
        L9:
            return new SingletonImmutableTable((be.a) ZeusTransformUtils.preCheckCast(aj.b(this.f4478a), be.a.class, "com.obric.memorydata.plugin"));
        L11:
            return ImmutableTable.of();
        }
    }

    ImmutableTable() {
    }

    public static <R, C, V> a<R, C, V> builder() {
        return new a();
    }

    static <R, C, V> be.a<R, C, V> cellOf(R r1, C r2, V r3) {
        return Tables.a(com.google.common.base.n.a(r1, "rowKey"), com.google.common.base.n.a(r2, "columnKey"), com.google.common.base.n.a(r3, EventBody.KEY_VALUE));
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(be<? extends R, ? extends C, ? extends V> r3) {
        be r4 = (be) ZeusTransformUtils.wrapperContextForParams(r3, be.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ImmutableTable.class) == false) goto L7;
        return (ImmutableTable) ZeusTransformUtils.preCheckCast(r4, ImmutableTable.class, "com.obric.memorydata.plugin");
    L7:
        return copyOf(r4.cellSet());
    }

    static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends be.a<? extends R, ? extends C, ? extends V>> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        a r0 = builder();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r0.a((be.a) ZeusTransformUtils.preCheckCast(r6.next(), be.a.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        return r0.a();
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY;
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r1, C r2, V r3) {
        return new SingletonImmutableTable(r1, r2, r3);
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(Function<? super T, ? extends R> r2, Function<? super T, ? extends C> r3, Function<? super T, ? extends V> r4) {
        return bf.a((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin"));
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(Function<? super T, ? extends R> r2, Function<? super T, ? extends C> r3, Function<? super T, ? extends V> r4, BinaryOperator<V> r5) {
        return bf.a((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin"), (BinaryOperator) ZeusTransformUtils.wrapperContextForParams(r5, BinaryOperator.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.i
    final bj<be.a<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.i
    /* bridge */ /* synthetic */ Iterator cellIterator() {
        return cellIterator();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public ImmutableSet<be.a<R, C, V>> cellSet() {
        return (ImmutableSet) ZeusTransformUtils.preCheckCast(super.cellSet(), ImmutableSet.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Set cellSet() {
        return cellSet();
    }

    @Override // com.google.common.collect.i
    final Spliterator<be.a<R, C, V>> cellSpliterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.be
    public ImmutableMap<R, V> column(C r2) {
        com.google.common.base.n.a(r2, "columnKey");
        return (ImmutableMap) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a((ImmutableMap) ZeusTransformUtils.preCheckCast(columnMap().get(r2), ImmutableMap.class, "com.obric.memorydata.plugin"), ImmutableMap.of()), ImmutableMap.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map column(Object r1) {
        return column(r1);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return columnKeySet();
    }

    @Override // com.google.common.collect.be
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public boolean contains(Object r1, Object r2) {
        if (get(r1, r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean containsColumn(Object r1) {
        return super.containsColumn(r1);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean containsRow(Object r1) {
        return super.containsRow(r1);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public boolean containsValue(Object r1) {
        return values().contains(r1);
    }

    @Override // com.google.common.collect.i
    abstract ImmutableSet<be.a<R, C, V>> createCellSet();

    @Override // com.google.common.collect.i
    /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    abstract SerializedForm createSerializedForm();

    @Override // com.google.common.collect.i
    abstract ImmutableCollection<V> createValues();

    @Override // com.google.common.collect.i
    /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Object get(Object r1, Object r2) {
        return super.get(r1, r2);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    @Deprecated
    public final V put(R r1, C r2, V r3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    @Deprecated
    public final void putAll(be<? extends R, ? extends C, ? extends V> r2) {
        be r1 = (be) ZeusTransformUtils.wrapperContextForParams(r2, be.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    @Deprecated
    public final V remove(Object r1, Object r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.be
    public ImmutableMap<C, V> row(R r2) {
        com.google.common.base.n.a(r2, "rowKey");
        return (ImmutableMap) ZeusTransformUtils.preCheckCast(com.google.common.base.i.a((ImmutableMap) ZeusTransformUtils.preCheckCast(rowMap().get(r2), ImmutableMap.class, "com.obric.memorydata.plugin"), ImmutableMap.of()), ImmutableMap.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map row(Object r1) {
        return row(r1);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.be
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) ZeusTransformUtils.preCheckCast(super.values(), ImmutableCollection.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.i
    final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    final Object writeReplace() {
        return createSerializedForm();
    }
}
