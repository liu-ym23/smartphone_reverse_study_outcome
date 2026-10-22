package com.larus.bmhome.chat.component.bottom.voice.service;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public final boolean a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b;
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "Status(open=" + this.a + ", experimentGroup=" + this.b + ')';
    }

    public g(boolean r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
