package com.google.common.collect;

import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
public final class b2 extends o {
    @Override // com.google.common.collect.o, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this, 17);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.j6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        Object[] r5 = new Object[size()];
        p7.C(this, r5);
        return r5;
    }

    @Override // com.google.common.collect.o, com.google.common.collect.j6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] r5) {
        return p7.s0(this, r5);
    }
}
