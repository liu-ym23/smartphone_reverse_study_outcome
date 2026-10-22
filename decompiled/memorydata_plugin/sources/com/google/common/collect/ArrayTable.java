package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
public final class ArrayTable<R, C, V> extends i<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    private transient ArrayTable<R, C, V>.c columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;
    private transient ArrayTable<R, C, V>.e rowMap;

    private static abstract class a<K, V> extends Maps.d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableMap<K, Integer> f4397a;

        private a(ImmutableMap<K, Integer> r1) {
            this.f4397a = r1;
        }

        /* synthetic */ a(ImmutableMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        K a(int r1) {
            return this.f4397a.keySet().asList().get(r1);
        }

        abstract V a(int r1, V r2);

        abstract String a();

        abstract V b(int r1);

        Map.Entry<K, V> c(final int r2) {
            com.google.common.base.n.a(r2, size());
            return new AnonymousClass1(this, r2);
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            return this.f4397a.containsKey(r1);
        }

        @Override // com.google.common.collect.Maps.d
        Iterator<Map.Entry<K, V>> entryIterator() {
            final int r1 = size();
            return new AnonymousClass2(this, r1);
        }

        @Override // com.google.common.collect.Maps.d
        Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return p.a(size(), 16, new $$Lambda$ckgBmxFHh9MgeYFZJW_fYF4Knp8(this));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object r3) {
            Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(this.f4397a.get(r3), Integer.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L7;
            return null;
        L7:
            return b(r4.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f4397a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f4397a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r4, V r5) {
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.f4397a.get(r4), Integer.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            return a(r0.intValue(), r5);
        L7:
            throw new IllegalArgumentException(a() + " " + r4 + " not in " + this.f4397a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f4397a.size();
        }
    }

    private class b extends a<R, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f4401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayTable f4402b;

        b(ArrayTable r2, int r3) {
            this.f4402b = r2;
            super(ArrayTable.access$300(r2), null);
            this.f4401a = r3;
        }

        @Override // com.google.common.collect.ArrayTable.a
        V a(int r2, V r3) {
            return (V) this.f4402b.set(r2, this.f4401a, r3);
        }

        @Override // com.google.common.collect.ArrayTable.a
        String a() {
            return com.tom_roush.pdfbox.pdmodel.a.d.h.i;
        }

        @Override // com.google.common.collect.ArrayTable.a
        V b(int r2) {
            return (V) this.f4402b.at(r2, this.f4401a);
        }
    }

    private class c extends a<C, Map<R, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayTable f4403a;

        private c(ArrayTable r2) {
            this.f4403a = r2;
            super(ArrayTable.access$600(r2), null);
        }

        /* synthetic */ c(ArrayTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.ArrayTable.a
        /* synthetic */ Object a(int r3, Object r4) {
            return a(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.ArrayTable.a
        String a() {
            return com.tom_roush.pdfbox.pdmodel.a.d.h.h;
        }

        Map<R, V> a(int r1, Map<R, V> r2) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        public Map<R, V> a(C r1, Map<R, V> r2) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.a
        /* synthetic */ Object b(int r1) {
            return d(r1);
        }

        Map<R, V> d(int r2) {
            return new b(this.f4403a, r2);
        }

        @Override // com.google.common.collect.ArrayTable.a, java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object put(Object r3, Object r4) {
            return a(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    private class d extends a<C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f4404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayTable f4405b;

        d(ArrayTable r2, int r3) {
            this.f4405b = r2;
            super(ArrayTable.access$600(r2), null);
            this.f4404a = r3;
        }

        @Override // com.google.common.collect.ArrayTable.a
        V a(int r2, V r3) {
            return (V) this.f4405b.set(this.f4404a, r2, r3);
        }

        @Override // com.google.common.collect.ArrayTable.a
        String a() {
            return com.tom_roush.pdfbox.pdmodel.a.d.h.h;
        }

        @Override // com.google.common.collect.ArrayTable.a
        V b(int r2) {
            return (V) this.f4405b.at(this.f4404a, r2);
        }
    }

    private class e extends a<R, Map<C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayTable f4406a;

        private e(ArrayTable r2) {
            this.f4406a = r2;
            super(ArrayTable.access$300(r2), null);
        }

        /* synthetic */ e(ArrayTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.ArrayTable.a
        /* synthetic */ Object a(int r3, Object r4) {
            return a(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.ArrayTable.a
        String a() {
            return com.tom_roush.pdfbox.pdmodel.a.d.h.i;
        }

        Map<C, V> a(int r1, Map<C, V> r2) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        public Map<C, V> a(R r1, Map<C, V> r2) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.a
        /* synthetic */ Object b(int r1) {
            return d(r1);
        }

        Map<C, V> d(int r2) {
            return new d(this.f4406a, r2);
        }

        @Override // com.google.common.collect.ArrayTable.a, java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object put(Object r3, Object r4) {
            return a(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    private ArrayTable(ArrayTable<R, C, V> r7) {
        ImmutableList<R> r0 = r7.rowList;
        this.rowList = r0;
        ImmutableList<C> r1 = r7.columnList;
        this.columnList = r1;
        this.rowKeyToIndex = r7.rowKeyToIndex;
        this.columnKeyToIndex = r7.columnKeyToIndex;
        V[][] r2 = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r0.size(), r1.size()}));
        this.array = r2;
        int r3 = 0;
    L4:
        if (r3 >= this.rowList.size()) goto L6;
        V[][] r4 = r7.array;
        System.arraycopy(r4[r3], 0, r2[r3], 0, r4[r3].length);
        r3 = r3 + 1;
        goto L4
    }

    private ArrayTable(be<R, C, ? extends V> r3) {
        be<? extends R, ? extends C, ? extends V> r4 = (be) ZeusTransformUtils.wrapperContextForParams(r3, be.class, "com.obric.memorydata.plugin");
        this(r4.rowKeySet(), r4.columnKeySet());
        putAll(r4);
    }

    private ArrayTable(Iterable<? extends R> r5, Iterable<? extends C> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        ImmutableList<R> r9 = ImmutableList.copyOf(r7);
        this.rowList = r9;
        ImmutableList<C> r10 = ImmutableList.copyOf(r8);
        this.columnList = r10;
        if (r9.isEmpty() != r10.isEmpty()) goto L5;
        boolean r0 = true;
    L6:
        com.google.common.base.n.a(r0);
        this.rowKeyToIndex = Maps.a(r9);
        this.columnKeyToIndex = Maps.a(r10);
        this.array = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r9.size(), r10.size()}));
        eraseAll();
        return;
    L5:
        r0 = false;
        goto L6
    }

    static /* synthetic */ be.a access$000(ArrayTable r0, int r1) {
        return r0.getCell(r1);
    }

    static /* synthetic */ ImmutableList access$100(ArrayTable r0) {
        return r0.columnList;
    }

    static /* synthetic */ ImmutableList access$200(ArrayTable r0) {
        return r0.rowList;
    }

    static /* synthetic */ ImmutableMap access$300(ArrayTable r0) {
        return r0.rowKeyToIndex;
    }

    static /* synthetic */ ImmutableMap access$600(ArrayTable r0) {
        return r0.columnKeyToIndex;
    }

    static /* synthetic */ Object access$800(ArrayTable r0, int r1) {
        return r0.getValue(r1);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(be<R, C, ? extends V> r3) {
        be r4 = (be) ZeusTransformUtils.wrapperContextForParams(r3, be.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ArrayTable.class) == false) goto L6;
        return new ArrayTable((ArrayTable) ZeusTransformUtils.preCheckCast(r4, ArrayTable.class, "com.obric.memorydata.plugin"));
    L6:
        return new ArrayTable(r4);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> r2, Iterable<? extends C> r3) {
        return new ArrayTable((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
    }

    private be.a<R, C, V> getCell(final int r2) {
        return new AnonymousClass2(this, r2);
    }

    private V getValue(int r3) {
        return at(r3 / this.columnList.size(), r3 % this.columnList.size());
    }

    /* JADX INFO: renamed from: lambda$cpAb-tO1m9LvVRmDWanHGLoAHQ4, reason: not valid java name */
    public static /* synthetic */ be.a m123lambda$cpAbtO1m9LvVRmDWanHGLoAHQ4(ArrayTable r0, int r1) {
        return r0.getCell(r1);
    }

    /* JADX INFO: renamed from: lambda$yqJBEUhtD7sOM-8hNQp9h3Mi57Y, reason: not valid java name */
    public static /* synthetic */ Object m124lambda$yqJBEUhtD7sOM8hNQp9h3Mi57Y(ArrayTable r0, int r1) {
        return r0.getValue(r1);
    }

    public V at(int r2, int r3) {
        com.google.common.base.n.a(r2, this.rowList.size());
        com.google.common.base.n.a(r3, this.columnList.size());
        return this.array[r2][r3];
    }

    @Override // com.google.common.collect.i
    Iterator<be.a<R, C, V>> cellIterator() {
        final int r1 = size();
        return new AnonymousClass1(this, r1);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public Set<be.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.i
    Spliterator<be.a<R, C, V>> cellSpliterator() {
        return p.a(size(), 273, new $$Lambda$ArrayTable$cpAbtO1m9LvVRmDWanHGLoAHQ4(this));
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.be
    public Map<R, V> column(C r3) {
        com.google.common.base.n.a(r3);
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(this.columnKeyToIndex.get(r3), Integer.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return Collections.emptyMap();
    L7:
        return new b(this, r4.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return columnKeySet();
    }

    @Override // com.google.common.collect.be
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.c r0 = this.columnMap;
        if (r0 != null) goto L6;
        ArrayTable<R, C, V>.c r1 = new c(this, null);
        this.columnMap = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public boolean contains(Object r1, Object r2) {
        if (containsRow(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (containsColumn(r2) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public boolean containsColumn(Object r1) {
        return this.columnKeyToIndex.containsKey(r1);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public boolean containsRow(Object r1) {
        return this.rowKeyToIndex.containsKey(r1);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public boolean containsValue(Object r8) {
        V[][] r7 = this.array;
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        V[] r3 = r7[r2];
        int r4 = r3.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L11;
        if (com.google.common.base.k.a(r8, r3[r5]) == true) goto L8;
        r5 = r5 + 1;
        goto L5
    L8:
        return true;
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return false;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    public V erase(Object r3, Object r4) {
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(this.rowKeyToIndex.get(r3), Integer.class, "com.obric.memorydata.plugin");
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(this.columnKeyToIndex.get(r4), Integer.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L8;
        if (r6 == null) goto L8;
        return set(r5.intValue(), r6.intValue(), null);
    L8:
        return null;
    }

    public void eraseAll() {
        V[][] r4 = this.array;
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Arrays.fill(r4[r1], null);
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public V get(Object r3, Object r4) {
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(this.rowKeyToIndex.get(r3), Integer.class, "com.obric.memorydata.plugin");
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(this.columnKeyToIndex.get(r4), Integer.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        if (r6 == null) goto L7;
        return at(r5.intValue(), r6.intValue());
    L7:
        return null;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public boolean isEmpty() {
        if (this.rowList.isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.columnList.isEmpty() == true) goto L8;
        return false;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public V put(R r8, C r9, V r10) {
        com.google.common.base.n.a(r8);
        com.google.common.base.n.a(r9);
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.rowKeyToIndex.get(r8), Integer.class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if (r0 == null) goto L5;
        boolean r4 = true;
    L6:
        com.google.common.base.n.a(r4, "Row %s not in %s", r8, this.rowList);
        Integer r11 = (Integer) ZeusTransformUtils.preCheckCast(this.columnKeyToIndex.get(r9), Integer.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L10;
        r1 = false;
    L10:
        com.google.common.base.n.a(r1, "Column %s not in %s", r9, this.columnList);
        return set(r0.intValue(), r11.intValue(), r10);
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public void putAll(be<? extends R, ? extends C, ? extends V> r3) {
        super.putAll((be) ZeusTransformUtils.wrapperContextForParams(r3, be.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    @Deprecated
    public V remove(Object r1, Object r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.be
    public Map<C, V> row(R r3) {
        com.google.common.base.n.a(r3);
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(this.rowKeyToIndex.get(r3), Integer.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return Collections.emptyMap();
    L7:
        return new d(this, r4.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.be
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.e r0 = this.rowMap;
        if (r0 != null) goto L6;
        ArrayTable<R, C, V>.e r1 = new e(this, null);
        this.rowMap = r1;
        return r1;
    L6:
        return r0;
    }

    public V set(int r2, int r3, V r4) {
        com.google.common.base.n.a(r2, this.rowList.size());
        com.google.common.base.n.a(r3, this.columnList.size());
        V[][] r1 = this.array;
        V r0 = r1[r2][r3];
        r1[r2][r3] = r4;
        return r0;
    }

    @Override // com.google.common.collect.be
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public V[][] toArray(Class<V> r6) {
        V[][] r7 = (V[][]) ((Object[][]) ZeusTransformUtils.preCheckCast(Array.newInstance(r6, new int[]{this.rowList.size(), this.columnList.size()}), Object[][].class, "com.obric.memorydata.plugin"));
        int r0 = 0;
    L4:
        if (r0 >= this.rowList.size()) goto L6;
        V[][] r1 = this.array;
        System.arraycopy(r1[r0], 0, r7[r0], 0, r1[r0].length);
        r0 = r0 + 1;
        goto L4
    L6:
        return r7;
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.i
    Iterator<V> valuesIterator() {
        final int r1 = size();
        return new AnonymousClass3(this, r1);
    }

    @Override // com.google.common.collect.i
    Spliterator<V> valuesSpliterator() {
        return p.a(size(), 16, new $$Lambda$ArrayTable$yqJBEUhtD7sOM8hNQp9h3Mi57Y(this));
    }
}
