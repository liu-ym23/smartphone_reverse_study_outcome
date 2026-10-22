package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class NullsLastOrdering<T> extends g8 implements Serializable {
    private static final long serialVersionUID = 0;
    final g8 ordering;

    public NullsLastOrdering(g8 r5) {
        this.ordering = r5;
    }

    @Override // java.util.Comparator
    public int compare(T r5, T r10) {
        if (r5 != r10) goto L5;
        return 0;
    L5:
        if (r5 != null) goto L8;
        return 1;
    L8:
        if (r10 != null) goto L12;
        return -1;
    L12:
        return this.ordering.compare(r5, r10);
    }

    @Override // java.util.Comparator
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof NullsLastOrdering) == true) goto L8;
        return false;
    L8:
        return this.ordering.equals(((NullsLastOrdering) r5).ordering);
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ (-921210296);
    }

    @Override // com.google.common.collect.g8
    public <S extends T> g8 nullsFirst() {
        return this.ordering.nullsFirst();
    }

    @Override // com.google.common.collect.g8
    public <S extends T> g8 nullsLast() {
        return this;
    }

    @Override // com.google.common.collect.g8
    public <S extends T> g8 reverse() {
        return this.ordering.reverse().nullsFirst();
    }

    public String toString() {
        String r5 = String.valueOf(this.ordering);
        return androidx.room.jarjarred.org.antlr.runtime.a.l(r5.length() + 12, r5, ".nullsLast()");
    }
}
