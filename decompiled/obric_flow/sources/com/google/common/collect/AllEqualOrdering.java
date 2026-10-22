package com.google.common.collect;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class AllEqualOrdering extends g8 implements Serializable {
    static final AllEqualOrdering INSTANCE = null;
    private static final long serialVersionUID = 0;

    static {
        INSTANCE = new AllEqualOrdering();
    }

    public AllEqualOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Comparator
    public int compare(Object r5, Object r10) {
        return 0;
    }

    @Override // com.google.common.collect.g8
    public <E> ImmutableList<E> immutableSortedCopy(Iterable<E> r5) {
        return ImmutableList.copyOf(r5);
    }

    @Override // com.google.common.collect.g8
    public <S> g8 reverse() {
        return this;
    }

    @Override // com.google.common.collect.g8
    public <E> List<E> sortedCopy(Iterable<E> r5) {
        return p7.U(r5);
    }

    public String toString() {
        return "Ordering.allEqual()";
    }
}
