package com.lynx.tasm.behavior.shadow.text;

/* JADX INFO: loaded from: classes2.dex */
public class AbsoluteSizeSpan extends android.text.style.AbsoluteSizeSpan {
    public final boolean equals(Object r5) {
        if ((r5 instanceof AbsoluteSizeSpan) == false) goto L10;
        AbsoluteSizeSpan r10 = (AbsoluteSizeSpan) r5;
        if (r10.getDip() != getDip()) goto L10;
        if (r10.getSize() != getSize()) goto L10;
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r5 = (getDip() ? 1 : 0) * 31;
        return getSize() + r5;
    }
}
