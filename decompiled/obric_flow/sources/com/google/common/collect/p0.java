package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p0 extends j0 implements v8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient v8 f9113c;
    final Comparator<Object> comparator;

    public p0() {
        this(g8.natural());
    }

    public v8 createDescendingMultiset() {
        return new o0(this);
    }

    @Override // com.google.common.collect.j0
    public /* bridge */ /* synthetic */ Set createElementSet() {
        return createElementSet();
    }

    public abstract Iterator descendingEntryIterator();

    public Iterator<Object> descendingIterator() {
        return p7.O(descendingMultiset());
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    public p0(Comparator r5) {
        r5.getClass();
        this.comparator = r5;
    }

    @Override // com.google.common.collect.j0
    public NavigableSet<Object> createElementSet() {
        return new w8(this);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public NavigableSet elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
