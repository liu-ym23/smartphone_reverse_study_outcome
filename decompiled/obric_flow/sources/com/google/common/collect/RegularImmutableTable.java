package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    public final class CellSet extends IndexedImmutableSet<k9> {
        final /* synthetic */ RegularImmutableTable this$0;

        public CellSet(RegularImmutableTable r5, q8 r10) {
            this.this$0 = r5;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r5) {
            if ((r5 instanceof k9) == false) goto L10;
            k9 r10 = (k9) r5;
            Object r11 = this.this$0.get(r10.getRowKey(), r10.getColumnKey());
            if (r11 != null) goto L7;
            return false;
        L7:
            if (r11.equals(r10.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public /* bridge */ /* synthetic */ k9 get(int r5) {
            return get(r5);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.collect.IndexedImmutableSet
        public k9 get(int r5) {
            return this.this$0.getCell(r5);
        }
    }

    public final class Values extends ImmutableList<V> {
        final /* synthetic */ RegularImmutableTable this$0;

        public Values(RegularImmutableTable r5, q8 r10) {
            this.this$0 = r5;
        }

        @Override // java.util.List
        public V get(int r5) {
            return (V) this.this$0.getValue(r5);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.this$0.size();
        }
    }

    public RegularImmutableTable() {
    }

    public static RegularImmutableTable a(Iterable r5, Comparator r10, Comparator r11) {
        LinkedHashSet r12 = new LinkedHashSet();
        LinkedHashSet r13 = new LinkedHashSet();
        ImmutableList r14 = ImmutableList.copyOf(r5);
        Iterator r15 = r5.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        k9 r16 = (k9) r15.next();
        r12.add(r16.getRowKey());
        r13.add(r16.getColumnKey());
        goto L4
    L6:
        if (r10 != null) goto L8;
        ImmutableSet r17 = ImmutableSet.copyOf(r12);
    L9:
        if (r11 != null) goto L11;
        ImmutableSet r18 = ImmutableSet.copyOf(r13);
    L13:
        return forOrderedComponents(r14, r17, r18);
    L11:
        r18 = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(r11, r13));
        goto L13
    L8:
        r17 = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(r10, r12));
        goto L9
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<k9> r5) {
        return a(r5, null, null);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<k9> r10, ImmutableSet<R> r11, ImmutableSet<C> r12) {
        if (r10.size() <= ((((long) r11.size()) * ((long) r12.size())) / 2)) goto L6;
        return new DenseImmutableTable(r10, r11, r12);
    L6:
        return new SparseImmutableTable(r10, r11, r12);
    }

    public final void checkNoDuplicate(R r5, C r10, V r11, V r12) {
        if (r11 != null) goto L4;
        boolean r13 = true;
    L5:
        if (r13 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(com.google.common.base.b0.A("Duplicate key: (row=%s, column=%s), values: [%s, %s].", new Object[]{r5, r10, r12, r11}));
    L4:
        r13 = false;
        goto L5
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.s0
    public /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.s0
    public /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    public abstract k9 getCell(int r5);

    public abstract V getValue(int r5);

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.l9
    public abstract /* synthetic */ int size();

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<k9> r5, final Comparator<? super R> r10, final Comparator<? super C> r11) {
        r5.getClass();
        if (r10 != null) goto L5;
        if (r11 != null) goto L5;
    L7:
        return a(r5, r10, r11);
    L5:
        Collections.sort(r5, new p8(r10, r11));
        goto L7
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.s0
    public final ImmutableSet<k9> createCellSet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new CellSet(this, null);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.s0
    public final ImmutableCollection<V> createValues() {
        if (isEmpty() == false) goto L6;
        return ImmutableList.of();
    L6:
        return new Values(this, null);
    }
}
