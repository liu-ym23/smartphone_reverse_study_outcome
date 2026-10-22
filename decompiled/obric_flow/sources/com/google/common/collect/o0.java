package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 extends y2 implements v8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g8 f9095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient w8 f9096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient i0 f9097c;
    public final /* synthetic */ p0 d;

    public o0(p0 r5) {
        this.d = r5;
    }

    @Override // com.google.common.collect.v8, com.google.common.collect.t8
    public final Comparator comparator() {
        g8 r5 = this.f9095a;
        if (r5 != null) goto L6;
        g8 r10 = g8.from(this.d.comparator()).reverse();
        this.f9095a = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.z2
    public final Object delegate() {
        return this.d;
    }

    @Override // com.google.common.collect.v8
    public final v8 descendingMultiset() {
        return this.d;
    }

    @Override // com.google.common.collect.z7
    public final /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.z7
    public final Set entrySet() {
        i0 r5 = this.f9097c;
        if (r5 != null) goto L6;
        i0 r10 = new i0(this, 1);
        this.f9097c = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.v8
    public final y7 firstEntry() {
        return this.d.lastEntry();
    }

    @Override // com.google.common.collect.v8
    public final v8 headMultiset(Object r5, BoundType r10) {
        return this.d.tailMultiset(r5, r10).descendingMultiset();
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.d.descendingIterator();
    }

    @Override // com.google.common.collect.v8
    public final y7 lastEntry() {
        return this.d.firstEntry();
    }

    @Override // com.google.common.collect.v8
    public final y7 pollFirstEntry() {
        return this.d.pollLastEntry();
    }

    @Override // com.google.common.collect.v8
    public final y7 pollLastEntry() {
        return this.d.pollFirstEntry();
    }

    @Override // com.google.common.collect.v8
    public final v8 subMultiset(Object r5, BoundType r10, Object r11, BoundType r12) {
        return this.d.subMultiset(r11, r12, r5, r10).descendingMultiset();
    }

    @Override // com.google.common.collect.v8
    public final v8 tailMultiset(Object r5, BoundType r10) {
        return this.d.headMultiset(r5, r10).descendingMultiset();
    }

    @Override // com.google.common.collect.t2, java.util.Collection
    public final Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.z2
    public final String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.t2, com.google.common.collect.z2
    public final Collection delegate() {
        return this.d;
    }

    @Override // com.google.common.collect.z7
    public final NavigableSet elementSet() {
        w8 r5 = this.f9096b;
        if (r5 != null) goto L6;
        w8 r10 = new w8(this);
        this.f9096b = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.t2, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] r5) {
        return standardToArray(r5);
    }

    @Override // com.google.common.collect.y2, com.google.common.collect.t2, com.google.common.collect.z2
    public final z7 delegate() {
        return this.d;
    }
}
