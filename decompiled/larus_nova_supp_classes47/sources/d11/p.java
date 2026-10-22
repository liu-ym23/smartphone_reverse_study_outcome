package d11;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public final int a;
    public final String b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final int g;
    public final int h;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof p) == false) goto L22;
        p r7 = (p) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = (r0 + r2) * 31;
        long r4 = this.c;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.d;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.e;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.f;
        return ((((r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.g) * 31) + this.h;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SwitchChannelReplyParams(answerStatus=" + this.a + ", fromAnchorId=" + this.b + ", fromRoomId=" + this.c + ", roomId=" + this.d + ", curChannelId=" + this.e + ", toJoinChannelId=" + this.f + ", matchType=" + this.g + ", inviteType=" + this.h + ")";
    }

    public p(int r2, String r3, long r4, long r6, long r8, long r10, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r3, "fromAnchorId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r8;
        this.f = r10;
        this.g = r12;
        this.h = r13;
    }
}
