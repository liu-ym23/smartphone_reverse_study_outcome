package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
abstract class i<R, C, V> implements be<R, C, V> {
    private transient Set<be.a<R, C, V>> cellSet;
    private transient Collection<V> values;

    class a extends AbstractSet<be.a<R, C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f4681a;

        a(i r1) {
            this.f4681a = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f4681a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, be.a.class) == false) goto L10;
            be.a r5 = (be.a) ZeusTransformUtils.preCheckCast(r4, be.a.class, "com.obric.memorydata.plugin");
            Map r3 = (Map) ZeusTransformUtils.preCheckCast(Maps.a(this.f4681a.rowMap(), r5.getRowKey()), Map.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L7;
            return false;
        L7:
            if (q.a(r3.entrySet(), Maps.a(r5.getColumnKey(), r5.getValue())) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<be.a<R, C, V>> iterator() {
            return this.f4681a.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, be.a.class) == false) goto L10;
            be.a r5 = (be.a) ZeusTransformUtils.preCheckCast(r4, be.a.class, "com.obric.memorydata.plugin");
            Map r3 = (Map) ZeusTransformUtils.preCheckCast(Maps.a(this.f4681a.rowMap(), r5.getRowKey()), Map.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L7;
            return false;
        L7:
            if (q.b(r3.entrySet(), Maps.a(r5.getColumnKey(), r5.getValue())) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f4681a.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<be.a<R, C, V>> spliterator() {
            return this.f4681a.cellSpliterator();
        }
    }

    class b extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f4682a;

        b(i r1) {
            this.f4682a = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f4682a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            return this.f4682a.containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.f4682a.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f4682a.size();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return this.f4682a.valuesSpliterator();
        }
    }

    i() {
    }

    abstract Iterator<be.a<R, C, V>> cellIterator();

    @Override // com.google.common.collect.be
    public Set<be.a<R, C, V>> cellSet() {
        Set<be.a<R, C, V>> r0 = this.cellSet;
        if (r0 != null) goto L6;
        Set<be.a<R, C, V>> r1 = createCellSet();
        this.cellSet = r1;
        return r1;
    L6:
        return r0;
    }

    abstract Spliterator<be.a<R, C, V>> cellSpliterator();

    @Override // com.google.common.collect.be
    public void clear() {
        Iterators.h(cellSet().iterator());
    }

    @Override // com.google.common.collect.be
    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.be
    public boolean contains(Object r2, Object r3) {
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(Maps.a(rowMap(), r2), Map.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (Maps.b(r1, r3) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.be
    public boolean containsColumn(Object r1) {
        return Maps.b(columnMap(), r1);
    }

    @Override // com.google.common.collect.be
    public boolean containsRow(Object r1) {
        return Maps.b(rowMap(), r1);
    }

    @Override // com.google.common.collect.be
    public boolean containsValue(Object r4) {
        Iterator<Map<C, V>> r3 = rowMap().values().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((Map) ZeusTransformUtils.preCheckCast(r3.next(), Map.class, "com.obric.memorydata.plugin")).containsValue(r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    Set<be.a<R, C, V>> createCellSet() {
        return new a(this);
    }

    Collection<V> createValues() {
        return new b(this);
    }

    @Override // com.google.common.collect.be
    public boolean equals(Object r1) {
        return Tables.a(this, r1);
    }

    @Override // com.google.common.collect.be
    public V get(Object r2, Object r3) {
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(Maps.a(rowMap(), r2), Map.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return (V) Maps.a(r1, r3);
    }

    @Override // com.google.common.collect.be
    public int hashCode() {
        return cellSet().hashCode();
    }

    @Override // com.google.common.collect.be
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.be
    public V put(R r1, C r2, V r3) {
        return row(r1).put(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.be
    public void putAll(be<? extends R, ? extends C, ? extends V> r5) {
        Iterator<be.a<R, C, V>> r6 = ((be) ZeusTransformUtils.wrapperContextForParams(r5, be.class, "com.obric.memorydata.plugin")).cellSet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        be.a r0 = (be.a) ZeusTransformUtils.preCheckCast(r6.next(), be.a.class, "com.obric.memorydata.plugin");
        put(r0.getRowKey(), r0.getColumnKey(), r0.getValue());
        goto L4
    }

    @Override // com.google.common.collect.be
    public V remove(Object r2, Object r3) {
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(Maps.a(rowMap(), r2), Map.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        return (V) Maps.c(r1, r3);
    }

    @Override // com.google.common.collect.be
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public String toString() {
        return rowMap().toString();
    }

    @Override // com.google.common.collect.be
    public Collection<V> values() {
        Collection<V> r0 = this.values;
        if (r0 != null) goto L6;
        Collection<V> r1 = createValues();
        this.values = r1;
        return r1;
    L6:
        return r0;
    }

    Iterator<V> valuesIterator() {
        final Iterator<be.a<R, C, V>> r1 = cellSet().iterator();
        return new AnonymousClass1(this, r1);
    }

    Spliterator<V> valuesSpliterator() {
        return p.a(cellSpliterator(), $$Lambda$XwzORBjqlUHLlYlV6JeMbSKiVnw.INSTANCE);
    }
}
