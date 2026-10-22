package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;

/* JADX INFO: loaded from: classes2.dex */
public final class da extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NavigableMap f8946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ea f8947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Range f8948c;

    public da(NavigableMap r5, Range r10) {
        this.f8946a = r5;
        this.f8947b = new ea(r5);
        this.f8948c = r10;
    }

    @Override // com.google.common.collect.l0
    public final Iterator a() {
        Range r5 = this.f8948c;
        if (r5.hasUpperBound() == false) goto L5;
        Cut r10 = (Cut) r5.upperEndpoint();
    L7:
        if (r5.hasUpperBound() == true) goto L9;
    L11:
        boolean r11 = false;
    L12:
        j5 r12 = p7.b0(this.f8947b.headMap(r10, r11).descendingMap().values().iterator());
        boolean r13 = r12.hasNext();
        NavigableMap r14 = this.f8946a;
        if (r13 == false) goto L19;
        if (((Range) r12.a()).upperBound != Cut.aboveAll()) goto L17;
        Object r15 = ((Range) r12.next()).lowerBound;
    L25:
        return new ca(this, (Cut) com.google.common.base.b0.y(r15, Cut.aboveAll()), r12, 1);
    L17:
        r15 = (Cut) r14.higherKey(((Range) r12.a()).upperBound);
        goto L25
    L19:
        if (r5.contains(Cut.belowAll()) == false) goto L27;
        if (r14.containsKey(Cut.belowAll()) == true) goto L27;
        r15 = (Cut) r14.higherKey(Cut.belowAll());
    L27:
        return g5.d;
    L9:
        if (r5.upperBoundType() != BoundType.CLOSED) goto L11;
        r11 = true;
        goto L12
    L5:
        r10 = Cut.aboveAll();
        goto L7
    }

    public final Range b(Object r5) {
        if ((r5 instanceof Cut) == true) goto L12;
    L10:
        return null;
    L12:
        Cut r10 = (Cut) r5;     // Catch: ClassCastException -> L11
        Map.Entry r11 = c(Range.downTo(r10, BoundType.forBoolean(true))).firstEntry();     // Catch: ClassCastException -> L11
        if (r11 == null) goto L10;
        if (((Cut) r11.getKey()).equals(r10) == false) goto L10;
        return (Range) r11.getValue();
    }

    public final NavigableMap c(Range r5) {
        Range r10 = this.f8948c;
        if (r10.isConnected(r5) == false) goto L5;
        Range r11 = r5.intersection(r10);
        return new da(this.f8946a, r11);
    L5:
        return ImmutableSortedMap.of();
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return g8.natural();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r5) {
        if (b(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.h7
    public final Iterator entryIterator() {
        Range r5 = this.f8948c;
        boolean r10 = r5.hasLowerBound();
        ea r11 = this.f8947b;
        if (r10 == false) goto L9;
        Cut r12 = (Cut) r5.lowerEndpoint();
        if (r5.lowerBoundType() != BoundType.CLOSED) goto L7;
        boolean r13 = true;
    L8:
        Collection r14 = r11.tailMap(r12, r13).values();
    L10:
        j5 r15 = p7.b0(r14.iterator());
        if (r5.contains(Cut.belowAll()) == false) goto L18;
        if (r15.hasNext() == true) goto L15;
    L16:
        Cut r16 = Cut.belowAll();
    L21:
        return new ca(this, r16, r15, 0);
    L15:
        if (((Range) r15.a()).lowerBound != Cut.belowAll()) goto L16;
    L18:
        if (r15.hasNext() == false) goto L23;
        r16 = ((Range) r15.next()).upperBound;
        goto L21
    L23:
        return g5.d;
    L7:
        r13 = false;
        goto L8
    L9:
        r14 = r11.values();
        goto L10
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r5) {
        return b(r5);
    }

    @Override // java.util.NavigableMap
    public final NavigableMap headMap(Object r5, boolean r10) {
        return c(Range.upTo((Cut) r5, BoundType.forBoolean(r10)));
    }

    @Override // com.google.common.collect.h7, java.util.AbstractMap, java.util.Map
    public final int size() {
        return p7.m0(entryIterator());
    }

    @Override // java.util.NavigableMap
    public final NavigableMap subMap(Object r5, boolean r10, Object r11, boolean r12) {
        BoundType r13 = BoundType.forBoolean(r10);
        return c(Range.range((Cut) r5, r13, (Cut) r11, BoundType.forBoolean(r12)));
    }

    @Override // java.util.NavigableMap
    public final NavigableMap tailMap(Object r5, boolean r10) {
        return c(Range.downTo((Cut) r5, BoundType.forBoolean(r10)));
    }
}
