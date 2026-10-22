package com.google.common.base;

import java.util.function.BiPredicate;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p implements BiPredicate {
    public p() {
    }

    public static p equals() {
        return Equivalence$Equals.INSTANCE;
    }

    public static p identity() {
        return Equivalence$Identity.INSTANCE;
    }

    public abstract boolean doEquivalent(Object r5, Object r10);

    public abstract int doHash(Object r5);

    public final boolean equivalent(Object r5, Object r10) {
        if (r5 != r10) goto L5;
        return true;
    L5:
        if (r5 == null) goto L10;
        if (r10 != null) goto L9;
        return false;
    L9:
        return doEquivalent(r5, r10);
    L10:
        return false;
    }

    public final z equivalentTo(Object r5) {
        return new Equivalence$EquivalentToPredicate(this, r5);
    }

    public final int hash(Object r5) {
        if (r5 != null) goto L6;
        return 0;
    L6:
        return doHash(r5);
    }

    public final <F> p onResultOf(q r5) {
        return new FunctionalEquivalence(r5, this);
    }

    public final <S> p pairwise() {
        return new PairwiseEquivalence(this);
    }

    @Override // java.util.function.BiPredicate
    @Deprecated
    public final boolean test(Object r5, Object r10) {
        return equivalent(r5, r10);
    }

    public final <S> Equivalence$Wrapper<S> wrap(final S r5) {
        final o r10 = null;
        return (Equivalence$Wrapper<S>) new Equivalence$Wrapper(this, r5, r10);
    }
}
