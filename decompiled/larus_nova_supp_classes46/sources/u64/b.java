package u64;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        long r6 = this.e;
        return ((r4 + r2) * 31) + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AoAccessTokenResult(accessToken=" + this.a + ", openId=" + this.b + ", nickName=" + this.c + ", loginChannel=" + this.d + ", expireAt=" + this.e + ')';
    }

    public b(String r2, String r3, String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "accessToken");
        Intrinsics.checkNotNullParameter(r3, "openId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
