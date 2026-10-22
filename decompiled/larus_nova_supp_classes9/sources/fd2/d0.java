package fd2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 {
    public final long a;
    public final String b;
    public final String c;
    public final Long d;
    public final int e;
    public final String f;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.c;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        Long r9 = this.d;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (((r8 + r10) * 31) + this.e) * 31;
        String r13 = this.f;
        if (r13 == null) goto L18;
        r3 = r13.hashCode();
    L18:
        return r11 + r3;
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "MvServiceParam(songId=" + this.a + ", songName=" + this.b + ", orderUid=" + this.c + ", songOffset=" + this.d + ", fetchType=" + this.e + ", url=" + this.f + ")";
    }

    public final boolean equals(Object r6) {
        if ((r6 instanceof d0) == false) goto L12;
        d0 r7 = (d0) r6;
        if (r7.a == this.a) goto L7;
    L9:
        return false;
    L7:
        if (Intrinsics.areEqual(this.c, r7.c) == false) goto L9;
        return true;
    L12:
        return super.equals(r6);
    }

    public d0(long r3, String r5, String r6, Long r7, int r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r9 & 8) == 0) goto L9;
        r7 = null;
    L9:
        if ((r9 & 16) == 0) goto L11;
        r8 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r6, "orderUid");
        this.a = r3;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = null;
    }
}
