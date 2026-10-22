package com.google.common.collect;

import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
interface ba<E> extends an<E> {
    @Override // com.google.common.collect.an
    /* bridge */ /* synthetic */ default Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.an
    SortedSet<E> elementSet();
}
