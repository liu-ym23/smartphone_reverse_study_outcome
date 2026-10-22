package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
class StandardTable<R, C, V> extends s0 implements Serializable {
    private static final long serialVersionUID = 0;
    final Map<R, Map<C, V>> backingMap;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient d9 f8868c;
    public transient Map d;
    public transient f9 e;
    final com.google.common.base.e0 factory;

    public StandardTable(Map<R, Map<C, V>> r5, com.google.common.base.e0 r10) {
        this.backingMap = r5;
        this.factory = r10;
    }

    public static boolean access$300(StandardTable r5, Object r10, Object r11, Object r12) {
        if (r12 != null) goto L4;
        r5.getClass();
    L7:
        return false;
    L4:
        if (r12.equals(r5.get(r10, r11)) == false) goto L7;
        return true;
    }

    public static boolean access$400(StandardTable r5, Object r10, Object r11, Object r12) {
        if (r12 != null) goto L5;
        r5.getClass();
    L8:
        boolean r13 = false;
    L9:
        if (r13 == false) goto L12;
        r5.remove(r10, r11);
        return true;
    L12:
        return false;
    L5:
        if (r12.equals(r5.get(r10, r11)) == false) goto L8;
        r13 = true;
        goto L9
    }

    public static Map access$900(StandardTable r5, Object r10) {
        r5.getClass();
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> r12 = r5.backingMap.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Map.Entry<R, Map<C, V>> r13 = r12.next();
        V r14 = r13.getValue().remove(r10);
        if (r14 == null) goto L4;
        r11.put(r13.getKey(), r14);
        if (r13.getValue().isEmpty() == false) goto L4;
        r12.remove();
        goto L4
    L10:
        return r11;
    }

    @Override // com.google.common.collect.s0
    public Iterator<k9> cellIterator() {
        return new m(this);
    }

    @Override // com.google.common.collect.l9
    public Set<k9> cellSet() {
        Set<k9> r5 = this.f9150a;
        if (r5 != null) goto L6;
        Set<k9> r10 = createCellSet();
        this.f9150a = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.s0
    public Spliterator<k9> cellSpliterator() {
        return p7.D(this.backingMap.entrySet().spliterator(), new h(24), 65, size());
    }

    @Override // com.google.common.collect.l9
    public void clear() {
        this.backingMap.clear();
    }

    @Override // com.google.common.collect.l9
    public Map<R, V> column(C r5) {
        return new b9(this, r5);
    }

    @Override // com.google.common.collect.l9
    public Set<C> columnKeySet() {
        d9 r5 = this.f8868c;
        if (r5 != null) goto L6;
        d9 r10 = new d9(this);
        this.f8868c = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.l9
    public Map<C, Map<R, V>> columnMap() {
        f9 r5 = this.e;
        if (r5 != null) goto L6;
        f9 r10 = new f9(this, 0);
        this.e = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.l9
    public boolean contains(Object r5, Object r10) {
        if (r5 == null) goto L9;
        if (r10 == null) goto L9;
        Map r11 = (Map) p7.l0(rowMap(), r5);
        if (r11 == null) goto L9;
        if (p7.k0(r11, r10) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.google.common.collect.l9
    public boolean containsColumn(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        Iterator<Map<C, V>> r10 = this.backingMap.values().iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        if (p7.k0(r10.next(), r5) == false) goto L7;
        return true;
    L12:
        return false;
    }

    @Override // com.google.common.collect.l9
    public boolean containsRow(Object r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (p7.k0(this.backingMap, r5) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.l9
    public boolean containsValue(Object r5) {
        if (r5 == null) goto L9;
        Iterator<V> r10 = rowMap().values().iterator();
    L5:
        if (r10.hasNext() == false) goto L9;
        if (((Map) r10.next()).containsValue(r5) == false) goto L5;
        return true;
    L9:
        return false;
    }

    public Iterator<C> createColumnKeyIterator() {
        return new c9(this);
    }

    public Map<R, Map<C, V>> createRowMap() {
        return new f9(this, 1);
    }

    @Override // com.google.common.collect.l9
    public V get(Object r5, Object r10) {
        if (r5 == null) goto L11;
        if (r10 == null) goto L12;
        Map r11 = (Map) p7.l0(rowMap(), r5);
        if (r11 != null) goto L10;
        return null;
    L10:
        return (V) p7.l0(r11, r10);
    L12:
        return null;
    L11:
        return null;
    }

    @Override // com.google.common.collect.l9
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.l9
    public V put(R r5, C r10, V r11) {
        r5.getClass();
        r10.getClass();
        r11.getClass();
        Map<C, V> r12 = this.backingMap.get(r5);
        if (r12 != null) goto L6;
        r12 = (Map) this.factory.get();
        this.backingMap.put(r5, r12);
    L6:
        return r12.put(r10, r11);
    }

    @Override // com.google.common.collect.l9
    public V remove(Object r5, Object r10) {
        if (r5 == null) goto L13;
        if (r10 == null) goto L13;
        Map r11 = (Map) p7.l0(this.backingMap, r5);
        if (r11 != null) goto L9;
        return null;
    L9:
        V r12 = (V) r11.remove(r10);
        if (r11.isEmpty() == false) goto L12;
        this.backingMap.remove(r5);
    L12:
        return r12;
    L13:
        return null;
    }

    @Override // com.google.common.collect.l9
    public Map<C, V> row(R r5) {
        return new g9(this, r5);
    }

    @Override // com.google.common.collect.l9
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.l9
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> r5 = this.d;
        if (r5 != null) goto L6;
        Map<R, Map<C, V>> r10 = createRowMap();
        this.d = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.l9
    public int size() {
        Iterator<Map<C, V>> r5 = this.backingMap.values().iterator();
        int r10 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r10 = r10 + r5.next().size();
        goto L4
    L6:
        return r10;
    }

    @Override // com.google.common.collect.l9
    public Collection<V> values() {
        Collection<V> r5 = this.f9151b;
        if (r5 != null) goto L6;
        Collection<V> r10 = (Collection<V>) createValues();
        this.f9151b = r10;
        return r10;
    L6:
        return r5;
    }
}
