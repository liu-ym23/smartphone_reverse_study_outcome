package tc2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements nf6.a {
    public final String a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final String f;
    public final boolean g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof j) == false) goto L20;
        j r7 = (j) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
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
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.c;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.d;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.e;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        String r11 = this.f;
        if (r11 == null) goto L9;
        r1 = r11.hashCode();
    L9:
        int r13 = (r10 + r1) * 31;
        boolean r14 = this.g;
        ?? r15 = r14;
        if (r14 == false) goto L13;
        r15 = 1;
    L13:
        return r13 + r15;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SelfSendInfo(sendType=" + this.a + ", sendTime=" + this.b + ", receiveTime=" + this.c + ", startSendTime=" + this.d + ", apiSuccessTime=" + this.e + ", messageType=" + this.f + ", isSelfClickSend=" + this.g + ")";
    }

    public /* synthetic */ j(String r16, long r17, long r19, long r21, long r23, String r25, int r26) {
        if ((r26 & 8) == 0) goto L5;
        long r9 = 0;
    L7:
        if ((r26 & 16) == 0) goto L9;
        long r11 = 0;
    L11:
        if ((r26 & 32) == 0) goto L13;
        String r13 = "--default--";
    L14:
        this(r16, r17, r19, r9, r11, r13, false);
        return;
    L13:
        r13 = r25;
        goto L14
    L9:
        r11 = r23;
        goto L11
    L5:
        r9 = r21;
        goto L7
    }

    public j(String r2, long r3, long r5, long r7, long r9, String r11, boolean r13) {
        Intrinsics.checkNotNullParameter(r2, "sendType");
        Intrinsics.checkNotNullParameter(r11, "messageType");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r9;
        this.f = r11;
        this.g = r13;
    }
}
