package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public final class Tables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.common.base.g<? extends Map<?, ?>, ? extends Map<?, ?>> f4622a = null;

    static final class ImmutableCell<R, C, V> extends a<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final C columnKey;
        private final R rowKey;
        private final V value;

        ImmutableCell(R r1, C r2, V r3) {
            this.rowKey = r1;
            this.columnKey = r2;
            this.value = r3;
        }

        @Override // com.google.common.collect.be.a
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // com.google.common.collect.be.a
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // com.google.common.collect.be.a
        public V getValue() {
            return this.value;
        }
    }

    static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements au<R, C, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableRowSortedMap(au<R, ? extends C, ? extends V> r3) {
            super((au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ah, com.google.common.collect.ac
        public au<R, C, V> delegate() {
            return (au) ZeusTransformUtils.preCheckCast(super.delegate(), au.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ah, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ be delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ah, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ah, com.google.common.collect.be
        public /* bridge */ /* synthetic */ Set rowKeySet() {
            return rowKeySet();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ah, com.google.common.collect.be
        public SortedSet<R> rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ah, com.google.common.collect.be
        public /* bridge */ /* synthetic */ Map rowMap() {
            return rowMap();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ah, com.google.common.collect.be
        public SortedMap<R, Map<C, V>> rowMap() {
            com.google.common.base.g r0 = Tables.a();
            return Collections.unmodifiableSortedMap(Maps.a(delegate().rowMap(), r0));
        }
    }

    private static class UnmodifiableTable<R, C, V> extends ah<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final be<? extends R, ? extends C, ? extends V> delegate;

        UnmodifiableTable(be<? extends R, ? extends C, ? extends V> r3) {
            this.delegate = (be) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((be) ZeusTransformUtils.wrapperContextForParams(r3, be.class, "com.obric.memorydata.plugin")), be.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.be
        public Set<be.a<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.be
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.be
        public Map<R, V> column(C r1) {
            return Collections.unmodifiableMap(super.column(r1));
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.be
        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.be
        public Map<C, Map<R, V>> columnMap() {
            com.google.common.base.g r0 = Tables.a();
            return Collections.unmodifiableMap(Maps.a(super.columnMap(), r0));
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.ac
        public be<R, C, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.be
        public V put(R r1, C r2, V r3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.be
        public void putAll(be<? extends R, ? extends C, ? extends V> r2) {
            be r1 = (be) ZeusTransformUtils.wrapperContextForParams(r2, be.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.be
        public V remove(Object r1, Object r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.be
        public Map<C, V> row(R r1) {
            return Collections.unmodifiableMap(super.row(r1));
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.be
        public Set<R> rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.be
        public Map<R, Map<C, V>> rowMap() {
            com.google.common.base.g r0 = Tables.a();
            return Collections.unmodifiableMap(Maps.a(super.rowMap(), r0));
        }

        @Override // com.google.common.collect.ah, com.google.common.collect.be
        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }
    }

    static abstract class a<R, C, V> implements be.a<R, C, V> {
        a() {
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, be.a.class) == false) goto L16;
            be.a r6 = (be.a) ZeusTransformUtils.preCheckCast(r5, be.a.class, "com.obric.memorydata.plugin");
            if (com.google.common.base.k.a(getRowKey(), r6.getRowKey()) == false) goto L15;
            if (com.google.common.base.k.a(getColumnKey(), r6.getColumnKey()) == false) goto L15;
            if (com.google.common.base.k.a(getValue(), r6.getValue()) == false) goto L15;
            return true;
        L15:
            return false;
        L16:
            return false;
        }

        public int hashCode() {
            return com.google.common.base.k.a(new Object[]{getRowKey(), getColumnKey(), getValue()});
        }

        public String toString() {
            return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
        }
    }

    static {
        f4622a = new AnonymousClass1();
    }

    static /* synthetic */ com.google.common.base.g a() {
        return b();
    }

    public static <R, C, V> be.a<R, C, V> a(R r1, C r2, V r3) {
        return new ImmutableCell(r1, r2, r3);
    }

    static boolean a(be<?, ?, ?> r2, Object r3) {
        be r4 = (be) ZeusTransformUtils.wrapperContextForParams(r2, be.class, "com.obric.memorydata.plugin");
        if (r3 != r4) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, be.class) == false) goto L10;
        be r5 = (be) ZeusTransformUtils.preCheckCast(r3, be.class, "com.obric.memorydata.plugin");
        return r4.cellSet().equals(r5.cellSet());
    L10:
        return false;
    }

    private static <K, V> com.google.common.base.g<Map<K, V>, Map<K, V>> b() {
        return (com.google.common.base.g<Map<K, V>, Map<K, V>>) f4622a;
    }
}
