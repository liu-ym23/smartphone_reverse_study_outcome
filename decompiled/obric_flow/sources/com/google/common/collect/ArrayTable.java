package com.google.common.collect;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayTable<R, C, V> extends s0 implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient a1 f8789c;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    public transient a1 d;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;

    public ArrayTable(Iterable r5, Iterable r10) {
        ImmutableList<R> r11 = ImmutableList.copyOf(r5);
        this.rowList = r11;
        ImmutableList<C> r12 = ImmutableList.copyOf(r10);
        this.columnList = r12;
        if (r11.isEmpty() != r12.isEmpty()) goto L5;
        boolean r13 = true;
    L6:
        com.google.common.base.b0.i(r13);
        this.rowKeyToIndex = p7.M(r11);
        this.columnKeyToIndex = p7.M(r12);
        this.array = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r11.size(), r12.size()}));
        eraseAll();
        return;
    L5:
        r13 = false;
        goto L6
    }

    public static k9 access$000(ArrayTable r5, int r10) {
        r5.getClass();
        return new v0(r5, r10);
    }

    public static /* synthetic */ ImmutableList access$100(ArrayTable r5) {
        return r5.columnList;
    }

    public static /* synthetic */ ImmutableList access$200(ArrayTable r5) {
        return r5.rowList;
    }

    public static /* synthetic */ ImmutableMap access$300(ArrayTable r5) {
        return r5.rowKeyToIndex;
    }

    public static /* synthetic */ ImmutableMap access$600(ArrayTable r5) {
        return r5.columnKeyToIndex;
    }

    public static /* synthetic */ Object access$800(ArrayTable r5, int r10) {
        return r5.a(r10);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> r5, Iterable<? extends C> r10) {
        return new ArrayTable(r5, r10);
    }

    public final Object a(int r5) {
        return at(r5 / this.columnList.size(), r5 % this.columnList.size());
    }

    public V at(int r5, int r10) {
        com.google.common.base.b0.l(r5, this.rowList.size());
        com.google.common.base.b0.l(r10, this.columnList.size());
        return this.array[r5][r10];
    }

    @Override // com.google.common.collect.s0
    public Iterator<k9> cellIterator() {
        return new u0(this, size(), 0);
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
        return p7.N(size(), 273, new t0(this, 1), null);
    }

    @Override // com.google.common.collect.l9
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.l9
    public Map<R, V> column(C r5) {
        r5.getClass();
        Integer r10 = this.columnKeyToIndex.get(r5);
        if (r10 != null) goto L7;
        return Collections.emptyMap();
    L7:
        return new z0(this, r10.intValue(), 0);
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return columnKeySet();
    }

    @Override // com.google.common.collect.l9
    public Map<C, Map<R, V>> columnMap() {
        a1 r5 = this.f8789c;
        if (r5 != null) goto L6;
        a1 r10 = new a1(this, 0);
        this.f8789c = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.l9
    public boolean contains(Object r5, Object r10) {
        if (containsRow(r5) == true) goto L5;
    L7:
        return false;
    L5:
        if (containsColumn(r10) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.l9
    public boolean containsColumn(Object r5) {
        return this.columnKeyToIndex.containsKey(r5);
    }

    @Override // com.google.common.collect.l9
    public boolean containsRow(Object r5) {
        return this.rowKeyToIndex.containsKey(r5);
    }

    @Override // com.google.common.collect.l9
    public boolean containsValue(Object r10) {
        V[][] r11 = this.array;
        int r5 = r11.length;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L12;
        V[] r13 = r11[r12];
        int r14 = r13.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L11;
        if (com.google.common.base.b0.w(r10, r13[r15]) == true) goto L8;
        r15 = r15 + 1;
        goto L5
    L8:
        return true;
    L11:
        r12 = r12 + 1;
        goto L3
    L12:
        return false;
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ boolean equals(Object r5) {
        return super.equals(r5);
    }

    public V erase(Object r5, Object r10) {
        Integer r11 = this.rowKeyToIndex.get(r5);
        Integer r12 = this.columnKeyToIndex.get(r10);
        if (r11 == null) goto L8;
        if (r12 == null) goto L8;
        return set(r11.intValue(), r12.intValue(), null);
    L8:
        return null;
    }

    public void eraseAll() {
        V[][] r5 = this.array;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        Arrays.fill(r5[r11], null);
        r11 = r11 + 1;
        goto L3
    }

    @Override // com.google.common.collect.l9
    public V get(Object r5, Object r10) {
        Integer r11 = this.rowKeyToIndex.get(r5);
        Integer r12 = this.columnKeyToIndex.get(r10);
        if (r11 == null) goto L7;
        if (r12 == null) goto L7;
        return at(r11.intValue(), r12.intValue());
    L7:
        return null;
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.l9
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.l9
    public boolean isEmpty() {
        if (this.rowList.isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.columnList.isEmpty() == true) goto L8;
        return false;
    }

    @Override // com.google.common.collect.l9
    public V put(R r10, C r11, V r12) {
        r10.getClass();
        r11.getClass();
        Integer r5 = this.rowKeyToIndex.get(r10);
        boolean r13 = false;
        if (r5 == null) goto L5;
        boolean r14 = true;
    L6:
        com.google.common.base.b0.k(r14, "Row %s not in %s", r10, this.rowList);
        Integer r15 = this.columnKeyToIndex.get(r11);
        if (r15 == null) goto L9;
        r13 = true;
    L9:
        com.google.common.base.b0.k(r13, "Column %s not in %s", r11, this.columnList);
        return set(r5.intValue(), r15.intValue(), r12);
    L5:
        r14 = false;
        goto L6
    }

    @Override // com.google.common.collect.s0, com.google.common.collect.l9
    public void putAll(l9 r5) {
        super.putAll(r5);
    }

    @Override // com.google.common.collect.l9
    @Deprecated
    public V remove(Object r5, Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.l9
    public Map<C, V> row(R r5) {
        r5.getClass();
        Integer r10 = this.rowKeyToIndex.get(r5);
        if (r10 != null) goto L7;
        return Collections.emptyMap();
    L7:
        return new z0(this, r10.intValue(), 1);
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.l9
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.l9
    public Map<R, Map<C, V>> rowMap() {
        a1 r5 = this.d;
        if (r5 != null) goto L6;
        a1 r10 = new a1(this, 1);
        this.d = r10;
        return r10;
    L6:
        return r5;
    }

    public V set(int r5, int r10, V r11) {
        com.google.common.base.b0.l(r5, this.rowList.size());
        com.google.common.base.b0.l(r10, this.columnList.size());
        V[] r12 = this.array[r5];
        V r13 = r12[r10];
        r12[r10] = r11;
        return r13;
    }

    @Override // com.google.common.collect.l9
    public int size() {
        int r5 = this.rowList.size();
        return this.columnList.size() * r5;
    }

    public V[][] toArray(Class<V> r10) {
        V[][] r11 = (V[][]) ((Object[][]) Array.newInstance(r10, new int[]{this.rowList.size(), this.columnList.size()}));
        int r5 = 0;
    L4:
        if (r5 >= this.rowList.size()) goto L6;
        V[] r12 = this.array[r5];
        System.arraycopy(r12, 0, r11[r5], 0, r12.length);
        r5 = r5 + 1;
        goto L4
    L6:
        return r11;
    }

    @Override // com.google.common.collect.s0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
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

    @Override // com.google.common.collect.s0
    public Iterator<V> valuesIterator() {
        return new u0(this, size(), 1);
    }

    @Override // com.google.common.collect.s0
    public Spliterator<V> valuesSpliterator() {
        return p7.N(size(), 16, new t0(this, 0), null);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(l9 r5) {
        if ((r5 instanceof ArrayTable) == true) goto L7;
        ArrayTable<R, C, V> r10 = new ArrayTable(r5.rowKeySet(), r5.columnKeySet());
        r10.putAll(r5);
        return r10;
    L7:
        return new ArrayTable((ArrayTable) r5);
    }

    @Override // com.google.common.collect.l9
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.l9
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    public ArrayTable(ArrayTable r10) {
        ImmutableList<R> r5 = r10.rowList;
        this.rowList = r5;
        ImmutableList<C> r11 = r10.columnList;
        this.columnList = r11;
        this.rowKeyToIndex = r10.rowKeyToIndex;
        this.columnKeyToIndex = r10.columnKeyToIndex;
        V[][] r12 = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r5.size(), r11.size()}));
        this.array = r12;
        int r13 = 0;
    L4:
        if (r13 >= this.rowList.size()) goto L6;
        V[] r14 = r10.array[r13];
        System.arraycopy(r14, 0, r12[r13], 0, r14.length);
        r13 = r13 + 1;
        goto L4
    }
}
