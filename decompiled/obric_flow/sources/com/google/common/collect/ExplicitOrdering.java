package com.google.common.collect;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class ExplicitOrdering<T> extends g8 implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    public ExplicitOrdering(List<T> r5) {
        this(p7.M(r5));
    }

    @Override // java.util.Comparator
    public int compare(final T r5, final T r10) {
        Integer r11 = this.rankMap.get(r5);
        if (r11 == null) goto L11;
        int r12 = r11.intValue();
        Integer r13 = this.rankMap.get(r10);
        if (r13 == null) goto L9;
        return r12 - r13.intValue();
    L9:
        throw new Ordering$IncomparableValueException(r10);
    L11:
        throw new Ordering$IncomparableValueException(r5);
    }

    @Override // java.util.Comparator
    public boolean equals(Object r5) {
        if ((r5 instanceof ExplicitOrdering) == true) goto L5;
        return false;
    L5:
        return this.rankMap.equals(((ExplicitOrdering) r5).rankMap);
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        String r5 = String.valueOf(this.rankMap.keySet());
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 19, "Ordering.explicit(", r5, ")");
    }

    public ExplicitOrdering(ImmutableMap<T, Integer> r5) {
        this.rankMap = r5;
    }
}
