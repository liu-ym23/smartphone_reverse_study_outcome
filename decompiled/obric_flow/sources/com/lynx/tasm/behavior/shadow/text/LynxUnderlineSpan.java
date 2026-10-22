package com.lynx.tasm.behavior.shadow.text;

import android.text.style.UnderlineSpan;

/* JADX INFO: loaded from: classes2.dex */
public class LynxUnderlineSpan extends UnderlineSpan {
    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L14:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L14;
        if (getSpanTypeId() == ((LynxUnderlineSpan) r5).getSpanTypeId()) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return getSpanTypeId() * 31;
    }
}
