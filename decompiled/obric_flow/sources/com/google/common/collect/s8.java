package com.google.common.collect;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface s8 extends q7 {
    @Override // com.google.common.collect.q7
    Set entries();

    @Override // com.google.common.collect.q7
    Set get(Object r5);

    @Override // com.google.common.collect.q7
    Set removeAll(Object r5);

    @Override // com.google.common.collect.q7
    Set replaceValues(Object r5, Iterable r10);
}
