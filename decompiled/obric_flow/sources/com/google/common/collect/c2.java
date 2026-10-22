package com.google.common.collect;

import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
public final class c2 extends y1 {
    @Override // com.google.common.collect.y1, com.google.common.collect.q6, java.util.Collection, java.lang.Iterable
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this, 16);
    }

    @Override // com.google.common.collect.y1, com.google.common.collect.q6, java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] r5) {
        return p7.s0(this, r5);
    }

    @Override // com.google.common.collect.y1, com.google.common.collect.q6, java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        Object[] r5 = new Object[((Map) this.f9135b).size()];
        p7.C(this, r5);
        return r5;
    }
}
