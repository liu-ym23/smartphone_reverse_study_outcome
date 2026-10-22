package com.lynx.tasm.behavior.shadow.text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AbsoluteSizeSpan extends android.text.style.AbsoluteSizeSpan {
    public final int hashCode() {
        return ((getDip() ? 1 : 0) * 31) + getSize();
    }

    public AbsoluteSizeSpan(int r1) {
        super(r1);
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof AbsoluteSizeSpan) == false) goto L10;
        AbsoluteSizeSpan r5 = (AbsoluteSizeSpan) r4;
        if (r5.getDip() == getDip()) goto L7;
        return false;
    L7:
        if (r5.getSize() != getSize()) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
