package ot1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;
    public final int f;

    /* JADX INFO: renamed from: ot1.a$a, reason: collision with other inner class name */
    public static final class C0407a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L18;
        a r7 = (a) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.c;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        String r9 = this.d;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        String r12 = this.e;
        if (r12 == null) goto L18;
        r1 = r12.hashCode();
    L18:
        return ((r11 + r1) * 31) + this.f;
    L13:
        r10 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ShareFansParams(anchorId=" + this.a + ", secAnchorId=" + this.b + ", roomId=" + this.c + ", enterFromMerge=" + this.d + ", enterMethod=" + this.e + ", actionType=" + this.f + ")";
    }

    public a() {
        this("0", "", 0, "", "", 0);
    }

    public a(String r2, String r3, long r4, String r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r2, "anchorId");
        Intrinsics.checkNotNullParameter(r3, "secAnchorId");
        Intrinsics.checkNotNullParameter(r6, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r7, "enterMethod");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
