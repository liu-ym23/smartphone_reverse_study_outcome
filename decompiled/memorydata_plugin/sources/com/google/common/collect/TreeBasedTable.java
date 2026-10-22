package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    private static class Factory<C, V> implements com.google.common.base.r<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        Factory(Comparator<? super C> r3) {
            this.comparator = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public TreeMap<C, V> get() {
            return new TreeMap(this.comparator);
        }
    }

    private class a extends StandardTable<R, C, V>.f implements SortedMap<C, V> {
        final C d;
        final C e;
        transient SortedMap<C, V> f;
        final /* synthetic */ TreeBasedTable g;

        a(TreeBasedTable r2, R r3) {
            this(r2, r3, null, null);
        }

        a(TreeBasedTable r1, R r2, C r3, C r4) {
            this.g = r1;
            super(r1, r2);
            this.d = r3;
            this.e = r4;
            if (r3 == null) goto L9;
            if (r4 == null) goto L9;
            if (a(r3, r4) <= 0) goto L9;
            boolean r0 = false;
        L10:
            com.google.common.base.n.a(r0);
            return;
        L9:
            r0 = true;
            goto L10
        }

        int a(Object r1, Object r2) {
            return comparator().compare(r1, r2);
        }

        boolean a(Object r2) {
            if (r2 == null) goto L12;
            C r0 = this.d;
            if (r0 != null) goto L6;
        L7:
            C r1 = this.e;
            if (r1 != null) goto L10;
        L11:
            return true;
        L10:
            if (a(r1, r2) <= 0) goto L12;
        L6:
            if (a(r0, r2) <= 0) goto L7;
        L12:
            return false;
        }

        @Override // com.google.common.collect.StandardTable.f
        /* synthetic */ Map b() {
            return f();
        }

        @Override // com.google.common.collect.StandardTable.f
        void c() {
            e();
            SortedMap<C, V> r0 = this.f;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isEmpty() == false) goto L9;
            this.g.backingMap.remove(this.f4607a);
            this.f = null;
            this.f4608b = null;
            return;
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return this.g.columnComparator();
        }

        @Override // com.google.common.collect.StandardTable.f, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r2) {
            if (a(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (super.containsKey(r2) == false) goto L7;
            return true;
        }

        public SortedSet<C> d() {
            return new Maps.g(this);
        }

        void e() {
            SortedMap<C, V> r0 = this.f;
            if (r0 != null) goto L5;
        L8:
            this.f = (SortedMap) ZeusTransformUtils.preCheckCast(this.g.backingMap.get(this.f4607a), SortedMap.class, "com.obric.memorydata.plugin");
            return;
        L5:
            if (r0.isEmpty() == true) goto L7;
            return;
        L7:
            if (this.g.backingMap.containsKey(this.f4607a) == true) goto L8;
        }

        SortedMap<C, V> f() {
            e();
            SortedMap<C, V> r0 = this.f;
            if (r0 == null) goto L11;
            C r1 = this.d;
            if (r1 == null) goto L7;
            r0 = r0.tailMap(r1);
        L7:
            C r2 = this.e;
            if (r2 != null) goto L10;
            return r0;
        L10:
            return r0.headMap(r2);
        L11:
            return null;
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            a();
            if (this.f4608b == null) goto L7;
            return (C) ((SortedMap) ZeusTransformUtils.preCheckCast(this.f4608b, SortedMap.class, "com.obric.memorydata.plugin")).firstKey();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C r4) {
            com.google.common.base.n.a(a(com.google.common.base.n.a(r4)));
            return new a(this.g, this.f4607a, this.d, r4);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public /* synthetic */ Set keySet() {
            return d();
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            a();
            if (this.f4608b == null) goto L7;
            return (C) ((SortedMap) ZeusTransformUtils.preCheckCast(this.f4608b, SortedMap.class, "com.obric.memorydata.plugin")).lastKey();
        L7:
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.f, java.util.AbstractMap, java.util.Map
        public V put(C r2, V r3) {
            com.google.common.base.n.a(a(com.google.common.base.n.a(r2)));
            return (V) super.put(r2, r3);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C r3, C r4) {
            if (a(com.google.common.base.n.a(r3)) == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            com.google.common.base.n.a(r0);
            return new a(this.g, this.f4607a, r3, r4);
        L5:
            if (a(com.google.common.base.n.a(r4)) == false) goto L7;
            r0 = true;
            goto L8
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C r4) {
            com.google.common.base.n.a(a(com.google.common.base.n.a(r4)));
            return new a(this.g, this.f4607a, r4, this.e);
        }
    }

    TreeBasedTable(Comparator<? super R> r3, Comparator<? super C> r4) {
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Comparator<? super C> r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        super(new TreeMap(r5), new Factory(r6));
        this.columnComparator = r6;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable(Ordering.natural(), Ordering.natural());
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> r3) {
        TreeBasedTable<R, C, V> r0 = new TreeBasedTable(r3.rowComparator(), r3.columnComparator());
        r0.putAll(r3);
        return r0;
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> r2, Comparator<? super C> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        return new TreeBasedTable(r4, r5);
    }

    static /* synthetic */ Iterator lambda$createColumnKeyIterator$0(Map r2) {
        return ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).keySet().iterator();
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

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
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

    @Override // com.google.common.collect.StandardTable
    Iterator<C> createColumnKeyIterator() {
        final Comparator<? super C> r0 = columnComparator();
        final bj r1 = Iterators.a(aj.a(this.backingMap.values(), $$Lambda$TreeBasedTable$EYFfqVKdDtxC_86vOHFtJyoVt1c.INSTANCE), r0);
        return new AnonymousClass1(this, r1, r0);
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
        return row(r1);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.be
    public SortedMap<C, V> row(R r2) {
        return new a(this, r2);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        return (Comparator) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(rowKeySet().comparator()), Comparator.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.be
    public SortedMap<R, Map<C, V>> rowMap() {
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
