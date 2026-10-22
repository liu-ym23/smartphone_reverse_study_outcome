package com.larus.chat.job.impl.page.edit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e0 {
    public final int a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r6 = (e0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        return "ChatJobEditTime(hourOfDay=" + this.a + ", minute=" + this.b + ')';
    }

    public e0(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
