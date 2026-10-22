package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m0 implements l8 {
    public m0() {
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof l8) == true) goto L8;
        return false;
    L8:
        return asRanges().equals(((l8) r5).asRanges());
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    public final String toString() {
        return asRanges().toString();
    }
}
