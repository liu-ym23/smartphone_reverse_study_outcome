package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    /* JADX INFO: renamed from: com.google.common.collect.RegularImmutableTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class CellSet extends IndexedImmutableSet<be.a<R, C, V>> {
        final /* synthetic */ RegularImmutableTable this$0;

        private CellSet(RegularImmutableTable r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CellSet(RegularImmutableTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, be.a.class) == false) goto L10;
            be.a r5 = (be.a) ZeusTransformUtils.preCheckCast(r4, be.a.class, "com.obric.memorydata.plugin");
            Object r3 = this.this$0.get(r5.getRowKey(), r5.getColumnKey());
            if (r3 != null) goto L7;
            return false;
        L7:
            if (r3.equals(r5.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        be.a<R, C, V> get(int r1) {
            return this.this$0.getCell(r1);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }
    }

    private final class Values extends ImmutableList<V> {
        final /* synthetic */ RegularImmutableTable this$0;

        private Values(RegularImmutableTable r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Values(RegularImmutableTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.List
        public V get(int r1) {
            return (V) this.this$0.getValue(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.this$0.size();
        }
    }

    RegularImmutableTable() {
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<be.a<R, C, V>> r2) {
        return forCellsInternal((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), null, null);
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<be.a<R, C, V>> r2, Comparator<? super R> r3, Comparator<? super C> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        final Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        final Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        if (r6 != null) goto L5;
        if (r7 != null) goto L5;
    L7:
        return forCellsInternal(r5, r6, r7);
    L5:
        Collections.sort(r5, new $$Lambda$RegularImmutableTable$_7sGJ1tkwtN1APZcHUJTsQH2JIo(r6, r7));
        goto L7
    }

    private static <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<be.a<R, C, V>> r6, Comparator<? super R> r7, Comparator<? super C> r8) {
        Iterable r9 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        Comparator r10 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r7, Comparator.class, "com.obric.memorydata.plugin");
        Comparator r11 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r8, Comparator.class, "com.obric.memorydata.plugin");
        LinkedHashSet r0 = new LinkedHashSet();
        LinkedHashSet r2 = new LinkedHashSet();
        ImmutableList r3 = ImmutableList.copyOf(r9);
        Iterator r12 = r9.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        be.a r4 = (be.a) ZeusTransformUtils.preCheckCast(r12.next(), be.a.class, "com.obric.memorydata.plugin");
        r0.add(r4.getRowKey());
        r2.add(r4.getColumnKey());
        goto L4
    L6:
        if (r10 != null) goto L8;
        ImmutableSet r13 = ImmutableSet.copyOf(r0);
    L9:
        if (r11 != null) goto L11;
        ImmutableSet r14 = ImmutableSet.copyOf(r2);
    L13:
        return forOrderedComponents(r3, r13, r14);
    L11:
        r14 = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(r11, r2));
        goto L13
    L8:
        r13 = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(r10, r0));
        goto L9
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<be.a<R, C, V>> r6, ImmutableSet<R> r7, ImmutableSet<C> r8) {
        if (r6.size() <= ((((long) r7.size()) * ((long) r8.size())) / 2)) goto L6;
        return new DenseImmutableTable(r6, r7, r8);
    L6:
        return new SparseImmutableTable(r6, r7, r8);
    }

    static /* synthetic */ int lambda$forCells$0(Comparator r3, Comparator r4, be.a r5, be.a r6) {
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Comparator r8 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        be.a r9 = (be.a) ZeusTransformUtils.wrapperContextForParams(r5, be.a.class, "com.obric.memorydata.plugin");
        be.a r10 = (be.a) ZeusTransformUtils.wrapperContextForParams(r6, be.a.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        int r11 = 0;
    L6:
        if (r11 == 0) goto L8;
        return r11;
    L8:
        if (r8 != null) goto L11;
        return 0;
    L11:
        return r8.compare(r9.getColumnKey(), r10.getColumnKey());
    L5:
        r11 = r7.compare(r9.getRowKey(), r10.getRowKey());
        goto L6
    }

    final void checkNoDuplicate(R r7, C r8, V r9, V r10) {
        if (r9 != null) goto L4;
        boolean r6 = true;
    L5:
        com.google.common.base.n.a(r6, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r7, r8, r10, r9);
        return;
    L4:
        r6 = false;
        goto L5
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    final ImmutableSet<be.a<R, C, V>> createCellSet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new CellSet(this, null);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    final ImmutableCollection<V> createValues() {
        if (isEmpty() == false) goto L6;
        return ImmutableList.of();
    L6:
        return new Values(this, null);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    abstract be.a<R, C, V> getCell(int r1);

    abstract V getValue(int r1);
}
