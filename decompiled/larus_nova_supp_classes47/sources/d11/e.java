package d11;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final int a;
    public final long b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final long g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L20;
        e r7 = (e) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.c;
        int r4 = 0;
        if (r3 == null) goto L5;
        int r5 = r3.hashCode();
    L6:
        int r6 = (r2 + r5) * 31;
        String r7 = this.d;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        String r10 = this.e;
        if (r10 == null) goto L13;
        r4 = r10.hashCode();
    L13:
        int r12 = (((r9 + r4) * 31) + this.f) * 31;
        long r13 = this.g;
        return r12 + ((int) (r13 ^ (r13 >>> 32)));
    L9:
        r8 = 0;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    public final String toString() {
        return "KickOutParams(scene=" + this.a + ", channelId=" + this.b + ", toUserId=" + this.c + ", secToUserId=" + this.d + ", reqSrc=" + this.e + ", kickOutSource=" + this.f + ", toRoomId=" + this.g + ")";
    }

    public e(int r2, long r3, String r5, String r6, String r7, int r8, long r9) {
        Intrinsics.checkNotNullParameter(r7, "reqSrc");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }

    public /* synthetic */ e(int r12, long r13, String r15, String r16, String r17, int r18, long r19, int r22) {
        if ((r22 & 32) == 0) goto L5;
        int r8 = 2;
    L7:
        if ((r22 & 64) == 0) goto L9;
        long r9 = 0;
    L10:
        this(r12, r13, r15, r16, r17, r8, r9);
        return;
    L9:
        r9 = r19;
        goto L10
    L5:
        r8 = r18;
        goto L7
    }
}
