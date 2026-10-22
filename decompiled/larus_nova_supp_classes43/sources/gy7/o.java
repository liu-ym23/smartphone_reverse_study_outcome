package gy7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o {
    public boolean a;
    public int b;
    public String c;

    public o() {
        this(true, 0, "");
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof o) == true) goto L8;
        return false;
    L8:
        o r11 = (o) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + this.b) * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "TaskResult(succeed=" + this.a + ", errorCode=" + this.b + ", errorMessage=" + this.c + ')';
    }

    public o(boolean r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "errorMessage");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
