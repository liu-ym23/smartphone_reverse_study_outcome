package p2a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j<T> extends m<T> {
    public final long b;
    public final String c;
    public final String d;
    public final T e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (this.b == r9.b) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r0 = this.b;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.c;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.d;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        T r9 = this.e;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        return r8 + r3;
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public final String toString() {
        return "UgcVoiceFail(code=" + this.b + ", message=" + this.c + ", localizedMessage=" + this.d + ", value=" + this.e + ')';
    }

    public j(long r1, String r3, String r4, T r5) {
        super(r5);
        this.b = r1;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
