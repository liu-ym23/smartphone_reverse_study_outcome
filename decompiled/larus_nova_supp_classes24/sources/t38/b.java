package t38;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final String a;
    public final int b;
    public final String c;

    public b() {
        this(null, 0, null, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        String r4 = this.c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoubaoOpenAuthCodeResult(authCode=" + this.a + ", errorCode=" + this.b + ", errorMessage=" + this.c + ')';
    }

    public b(String r3, int r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = null;
    L11:
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
