package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class CompoundOrdering<T> extends g8 implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T>[] comparators;

    public CompoundOrdering(Comparator<? super T> r5, Comparator<? super T> r10) {
        this.comparators = new Comparator[]{r5, r10};
    }

    @Override // java.util.Comparator
    public int compare(T r5, T r10) {
        int r11 = 0;
    L3:
        Comparator<? super T>[] r12 = this.comparators;
        if (r11 >= r12.length) goto L9;
        int r13 = r12[r11].compare(r5, r10);
        if (r13 != 0) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        return r13;
    L9:
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof CompoundOrdering) == true) goto L8;
        return false;
    L8:
        return Arrays.equals(this.comparators, ((CompoundOrdering) r5).comparators);
    }

    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public String toString() {
        String r5 = Arrays.toString(this.comparators);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(androidx.room.jarjarred.org.antlr.runtime.a.g(19, r5), "Ordering.compound(", r5, ")");
    }

    public CompoundOrdering(Iterable<? extends Comparator<? super T>> r5) {
        Comparator[] r10 = new Comparator[0];
        if ((r5 instanceof Collection) == false) goto L5;
        Collection r11 = (Collection) r5;
    L6:
        this.comparators = (Comparator[]) r11.toArray(r10);
        return;
    L5:
        r11 = p7.V(r5.iterator());
        goto L6
    }
}
