package sq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public final String a;
    public final String b;
    public final String c;

    public i() {
        this(null, null, null, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationImageShareEventModel(enterFrom=" + this.a + ", messageId=" + this.b + ", creationId=" + this.c + ')';
    }

    public i(String r3, String r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = null;
    L11:
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
