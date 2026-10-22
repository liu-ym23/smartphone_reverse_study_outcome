package com.ss.android.lark.compose.chatterselector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final int a;
    public final float b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "CheckStyle(size=" + this.a + ", strokeWidth=" + this.b + ')';
    }

    public c() {
        this.a = 22;
        this.b = 2.0f;
    }
}
