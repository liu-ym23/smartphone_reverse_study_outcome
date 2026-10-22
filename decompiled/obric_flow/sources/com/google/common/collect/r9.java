package com.google.common.collect;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r9 implements k9 {
    public r9() {
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof k9) == false) goto L16;
        k9 r10 = (k9) r5;
        if (com.google.common.base.b0.w(getRowKey(), r10.getRowKey()) == false) goto L15;
        if (com.google.common.base.b0.w(getColumnKey(), r10.getColumnKey()) == false) goto L15;
        if (com.google.common.base.b0.w(getValue(), r10.getValue()) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getRowKey(), getColumnKey(), getValue()});
    }

    public String toString() {
        String r5 = String.valueOf(getRowKey());
        String r10 = String.valueOf(getColumnKey());
        String r11 = String.valueOf(getValue());
        int r12 = r5.length() + 4;
        int r13 = r10.length() + r12;
        StringBuilder r14 = new StringBuilder(r11.length() + r13);
        r14.append("(");
        r14.append(r5);
        r14.append(",");
        r14.append(r10);
        return ai.j0.q(r14, ")=", r11);
    }
}
