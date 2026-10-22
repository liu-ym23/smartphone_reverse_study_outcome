package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public interface x8 extends s8 {
    @Override // com.google.common.collect.s8, com.google.common.collect.q7
    SortedSet get(Object r5);

    @Override // com.google.common.collect.s8, com.google.common.collect.q7
    SortedSet removeAll(Object r5);

    @Override // com.google.common.collect.s8, com.google.common.collect.q7
    SortedSet replaceValues(Object r5, Iterable r10);

    Comparator valueComparator();
}
