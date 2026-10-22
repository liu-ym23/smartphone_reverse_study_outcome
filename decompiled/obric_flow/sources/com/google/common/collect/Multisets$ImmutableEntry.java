package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class Multisets$ImmutableEntry<E> extends b8 implements Serializable {
    private static final long serialVersionUID = 0;
    private final int count;
    private final E element;

    public Multisets$ImmutableEntry(E r5, int r10) {
        this.element = r5;
        this.count = r10;
        p7.q(r10, "count");
    }

    @Override // com.google.common.collect.y7
    public final int getCount() {
        return this.count;
    }

    @Override // com.google.common.collect.y7
    public final E getElement() {
        return this.element;
    }

    public Multisets$ImmutableEntry<E> nextInBucket() {
        return null;
    }
}
