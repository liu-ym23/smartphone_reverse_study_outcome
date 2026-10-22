package com.ss.android.lark.chat.cot.detail;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s implements b {
    public final int a;
    public final boolean b;

    public s() {
        int r1 = 0;
        this(r1, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "CotGroupDetailExtra(toolCallCount=" + this.a + ", isGroupExpanded=" + this.b + ')';
    }

    public /* synthetic */ s(int r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = 0;
    L5:
        this(r2, false);
    }

    public s(int r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
