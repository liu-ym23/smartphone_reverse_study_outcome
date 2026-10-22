package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements au<R, C, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: com.google.common.collect.StandardRowSortedTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a extends StandardTable<R, C, V>.g implements SortedMap<R, Map<C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StandardRowSortedTable f4588a;

        private a(StandardRowSortedTable r1) {
            this.f4588a = r1;
            super(r1);
        }

        /* synthetic */ a(StandardRowSortedTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        public SortedSet<R> b() {
            return (SortedSet) ZeusTransformUtils.preCheckCast(super.keySet(), SortedSet.class, "com.obric.memorydata.plugin");
        }

        SortedSet<R> c() {
            return new Maps.g(this);
        }

        @Override // java.util.SortedMap
        public Comparator<? super R> comparator() {
            return StandardRowSortedTable.access$100(this.f4588a).comparator();
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) StandardRowSortedTable.access$100(this.f4588a).firstKey();
        }

        @Override // com.google.common.collect.Maps.m
        /* synthetic */ Set h() {
            return c();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R r3) {
            com.google.common.base.n.a(r3);
            return new StandardRowSortedTable(StandardRowSortedTable.access$100(this.f4588a).headMap(r3), this.f4588a.factory).rowMap();
        }

        @Override // com.google.common.collect.Maps.m, java.util.AbstractMap, java.util.Map
        public /* synthetic */ Set keySet() {
            return b();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) StandardRowSortedTable.access$100(this.f4588a).lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R r3, R r4) {
            com.google.common.base.n.a(r3);
            com.google.common.base.n.a(r4);
            return new StandardRowSortedTable(StandardRowSortedTable.access$100(this.f4588a).subMap(r3, r4), this.f4588a.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R r3) {
            com.google.common.base.n.a(r3);
            return new StandardRowSortedTable(StandardRowSortedTable.access$100(this.f4588a).tailMap(r3), this.f4588a.factory).rowMap();
        }
    }

    StandardRowSortedTable(SortedMap<R, Map<C, V>> r3, com.google.common.base.r<? extends Map<C, V>> r4) {
        super((SortedMap) ZeusTransformUtils.wrapperContextForParams(r3, SortedMap.class, "com.obric.memorydata.plugin"), (com.google.common.base.r) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.r.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ SortedMap access$100(StandardRowSortedTable r0) {
        return r0.sortedBackingMap();
    }

    private SortedMap<R, Map<C, V>> sortedBackingMap() {
        return (SortedMap) ZeusTransformUtils.preCheckCast(this.backingMap, SortedMap.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.StandardTable
    /* bridge */ /* synthetic */ Map createRowMap() {
        return createRowMap();
    }

    @Override // com.google.common.collect.StandardTable
    SortedMap<R, Map<C, V>> createRowMap() {
        return new a(this, null);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.be
    public SortedSet<R> rowKeySet() {
        return (SortedSet) ZeusTransformUtils.preCheckCast(rowMap().keySet(), SortedSet.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.be
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.be
    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) ZeusTransformUtils.preCheckCast(super.rowMap(), SortedMap.class, "com.obric.memorydata.plugin");
    }
}
