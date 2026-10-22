package com.lynx.tasm.behavior.shadow.text;

import android.text.style.StrikethroughSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxStrikethroughSpan extends StrikethroughSpan {
    public final int hashCode() {
        return getSpanTypeId() * 31;
    }

    public LynxStrikethroughSpan() {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L14:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L14;
        if (getSpanTypeId() == ((LynxStrikethroughSpan) r5).getSpanTypeId()) goto L13;
        return false;
    L13:
        return true;
    }
}
