package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class LexicographicalOrdering<T> extends g8 implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T> elementOrder;

    public LexicographicalOrdering(Comparator<? super T> r5) {
        this.elementOrder = r5;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object r5, Object r10) {
        return compare((Iterable) r5, (Iterable) r10);
    }

    @Override // java.util.Comparator
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof LexicographicalOrdering) == true) goto L8;
        return false;
    L8:
        return this.elementOrder.equals(((LexicographicalOrdering) r5).elementOrder);
    }

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 2075626741;
    }

    public String toString() {
        String r5 = String.valueOf(this.elementOrder);
        return androidx.room.jarjarred.org.antlr.runtime.a.l(r5.length() + 18, r5, ".lexicographical()");
    }

    public int compare(Iterable<T> r5, Iterable<T> r10) {
        Iterator<T> r11 = r5.iterator();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        if (r12.hasNext() == false) goto L7;
        int r13 = this.elementOrder.compare(r11.next(), r12.next());
        if (r13 == 0) goto L4;
        return r13;
    L7:
        return 1;
    L13:
        if (r12.hasNext() == false) goto L16;
        return -1;
    L16:
        return 0;
    }
}
