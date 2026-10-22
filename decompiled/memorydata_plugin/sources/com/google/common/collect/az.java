package com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public interface az<E> extends ax<E>, ba<E> {
    @Override // com.google.common.collect.ax
    Comparator<? super E> comparator();

    az<E> descendingMultiset();

    @Override // com.google.common.collect.ba, com.google.common.collect.an
    NavigableSet<E> elementSet();

    @Override // com.google.common.collect.ba, com.google.common.collect.an
    /* bridge */ /* synthetic */ default Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ba, com.google.common.collect.an
    /* bridge */ /* synthetic */ default SortedSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.an
    Set<an.a<E>> entrySet();

    an.a<E> firstEntry();

    az<E> headMultiset(E r1, BoundType r2);

    an.a<E> lastEntry();

    an.a<E> pollFirstEntry();

    an.a<E> pollLastEntry();

    az<E> subMultiset(E r1, BoundType r2, E r3, BoundType r4);

    az<E> tailMultiset(E r1, BoundType r2);
}
