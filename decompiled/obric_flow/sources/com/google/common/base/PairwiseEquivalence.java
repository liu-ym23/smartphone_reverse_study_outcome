package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class PairwiseEquivalence<E, T extends E> extends p implements Serializable {
    private static final long serialVersionUID = 1;
    final p elementEquivalence;

    public PairwiseEquivalence(p r5) {
        r5.getClass();
        this.elementEquivalence = r5;
    }

    @Override // com.google.common.base.p
    public /* bridge */ /* synthetic */ boolean doEquivalent(Object r5, Object r10) {
        return doEquivalent((Iterable) r5, (Iterable) r10);
    }

    @Override // com.google.common.base.p
    public /* bridge */ /* synthetic */ int doHash(Object r5) {
        return doHash((Iterable) r5);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof PairwiseEquivalence) == true) goto L5;
        return false;
    L5:
        return this.elementEquivalence.equals(((PairwiseEquivalence) r5).elementEquivalence);
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        String r5 = String.valueOf(this.elementEquivalence);
        return androidx.room.jarjarred.org.antlr.runtime.a.l(r5.length() + 11, r5, ".pairwise()");
    }

    public boolean doEquivalent(Iterable<T> r5, Iterable<T> r10) {
        Iterator<T> r11 = r5.iterator();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        if (r12.hasNext() == false) goto L11;
        if (this.elementEquivalence.equivalent(r11.next(), r12.next()) == true) goto L4;
        return false;
    L11:
        if (r11.hasNext() == false) goto L13;
        return false;
    L13:
        if (r12.hasNext() == true) goto L21;
        return true;
    L21:
        return false;
    }

    public int doHash(Iterable<T> r5) {
        Iterator<T> r10 = r5.iterator();
        int r11 = 78721;
    L4:
        if (r10.hasNext() == false) goto L6;
        T r12 = r10.next();
        r11 = (r11 * 24943) + this.elementEquivalence.hash(r12);
        goto L4
    L6:
        return r11;
    }
}
