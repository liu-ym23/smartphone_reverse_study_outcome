package com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface v8 extends z7, t8 {
    @Override // com.google.common.collect.t8
    Comparator comparator();

    v8 descendingMultiset();

    @Override // com.google.common.collect.z7
    NavigableSet elementSet();

    @Override // com.google.common.collect.z7
    Set entrySet();

    y7 firstEntry();

    v8 headMultiset(Object r5, BoundType r10);

    y7 lastEntry();

    y7 pollFirstEntry();

    y7 pollLastEntry();

    v8 subMultiset(Object r5, BoundType r10, Object r11, BoundType r12);

    v8 tailMultiset(Object r5, BoundType r10);
}
