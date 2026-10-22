package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public final class w8 extends g7 implements NavigableSet, SortedSet {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v8 f9212c;

    public w8(v8 r5) {
        super(1);
        this.f9212c = r5;
    }

    @Override // com.google.common.collect.g7
    public final z7 c() {
        return this.f9212c;
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object r5) {
        BoundType r10 = BoundType.CLOSED;
        return p7.b(this.f9212c.tailMultiset(r5, r10).firstEntry());
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return this.f9212c.comparator();
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return ((w8) descendingSet()).iterator();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return new w8(this.f9212c.descendingMultiset());
    }

    @Override // java.util.SortedSet
    public final Object first() {
        y7 r5 = this.f9212c.firstEntry();
        if (r5 == null) goto L7;
        return r5.getElement();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object r5) {
        BoundType r10 = BoundType.CLOSED;
        return p7.b(this.f9212c.headMultiset(r5, r10).lastEntry());
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final SortedSet headSet(Object r5) {
        BoundType r10 = BoundType.OPEN;
        return this.f9212c.headMultiset(r5, r10).elementSet();
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object r5) {
        BoundType r10 = BoundType.OPEN;
        return p7.b(this.f9212c.tailMultiset(r5, r10).firstEntry());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public final Iterator iterator() {
        return new q0(this.f9212c.entrySet().iterator(), 3);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        y7 r5 = this.f9212c.lastEntry();
        if (r5 == null) goto L7;
        return r5.getElement();
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object r5) {
        BoundType r10 = BoundType.OPEN;
        return p7.b(this.f9212c.headMultiset(r5, r10).lastEntry());
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        return p7.b(this.f9212c.pollFirstEntry());
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        return p7.b(this.f9212c.pollLastEntry());
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final SortedSet subSet(Object r5, Object r10) {
        BoundType r11 = BoundType.CLOSED;
        BoundType r12 = BoundType.OPEN;
        return this.f9212c.subMultiset(r5, r11, r10, r12).elementSet();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final SortedSet tailSet(Object r5) {
        BoundType r10 = BoundType.CLOSED;
        return this.f9212c.tailMultiset(r5, r10).elementSet();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object r5, boolean r10) {
        BoundType r11 = BoundType.forBoolean(r10);
        return new w8(this.f9212c.headMultiset(r5, r11));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object r5, boolean r10, Object r11, boolean r12) {
        BoundType r13 = BoundType.forBoolean(r10);
        BoundType r14 = BoundType.forBoolean(r12);
        return new w8(this.f9212c.subMultiset(r5, r13, r11, r14));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object r5, boolean r10) {
        BoundType r11 = BoundType.forBoolean(r10);
        return new w8(this.f9212c.tailMultiset(r5, r11));
    }
}
