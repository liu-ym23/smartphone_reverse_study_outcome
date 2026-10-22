package com.bytedance.apm.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class n<F, S> {
    public F a;
    public S b;

    public final int hashCode() {
        F r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        S r3 = this.b;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return r2 ^ r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "Pair{" + String.valueOf(this.a) + " " + this.b + "}";
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof n) == true) goto L5;
        return false;
    L5:
        n r6 = (n) r5;
        F r0 = r6.a;
        F r2 = this.a;
        if (r0 == r2) goto L12;
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L25;
        S r7 = r6.b;
        S r3 = this.b;
        if (r7 == r3) goto L21;
        if (r7 != null) goto L18;
    L20:
        boolean r8 = false;
    L22:
        if (r8 == false) goto L26;
        return true;
    L26:
        return false;
    L18:
        if (r7.equals(r3) == false) goto L20;
    L21:
        r8 = true;
        goto L22
    L25:
        return false;
    L9:
        if (r0.equals(r2) == false) goto L11;
    L12:
        r1 = true;
        goto L13
    }

    public n(F r1, S r2) {
        this.a = r1;
        this.b = r2;
    }
}
