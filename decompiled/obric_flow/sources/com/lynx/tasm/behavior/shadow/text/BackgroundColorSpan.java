package com.lynx.tasm.behavior.shadow.text;

/* JADX INFO: loaded from: classes2.dex */
public class BackgroundColorSpan extends android.text.style.BackgroundColorSpan {
    public final boolean equals(Object r5) {
        if ((r5 instanceof BackgroundColorSpan) == true) goto L5;
    L8:
        return false;
    L5:
        if (getBackgroundColor() != ((BackgroundColorSpan) r5).getBackgroundColor()) goto L8;
        return true;
    }

    public final int hashCode() {
        return getBackgroundColor() + 31;
    }
}
