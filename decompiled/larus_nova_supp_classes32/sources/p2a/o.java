package p2a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o<T> extends m<T> {
    public final T b;
    public final String c;
    public final String d;
    public final Long e;

    public o() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        T r0 = this.b;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.e;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "UgcVoiceSuccess(value=" + this.b + ", payload=" + this.c + ", message=" + this.d + ", code=" + this.e + ')';
    }

    public o(T r1, String r2, String r3, Long r4) {
        super(r1);
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
