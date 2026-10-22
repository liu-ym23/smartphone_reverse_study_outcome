package com.larus.avlink.record.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q {
    public final String a;
    public final int b;
    public final String c;
    public final int d;
    public final long e;

    public q() {
        this(null, 0, null, 0, 31);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof q) == true) goto L8;
        return false;
    L8:
        q r9 = (q) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
        long r1 = this.e;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "PendingRecordSession(messageId=" + this.a + ", wakeId=" + this.b + ", source=" + this.c + ", recordType=" + this.d + ", createdAt=" + this.e + ')';
    }

    public /* synthetic */ q(String r10, int r11, String r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r14 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r14 & 8) == 0) goto L17;
        int r6 = 0;
    L19:
        if ((r14 & 16) == 0) goto L21;
        long r15 = System.currentTimeMillis();
    L22:
        this(r3, r4, r5, r6, r15);
        return;
    L21:
        r15 = 0;
        goto L22
    L17:
        r6 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public static q a(q r7, String r8, int r9, int r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        String r1 = r8;
        if ((r11 & 2) == 0) goto L8;
        r9 = r7.b;
    L8:
        int r2 = r9;
        if ((r11 & 4) == 0) goto L11;
        String r12 = r7.c;
    L12:
        String r3 = r12;
        if ((r11 & 8) == 0) goto L15;
        r10 = r7.d;
    L15:
        int r4 = r10;
        if ((r11 & 16) == 0) goto L18;
        long r13 = r7.e;
    L19:
        Intrinsics.checkNotNullParameter(r1, "messageId");
        Intrinsics.checkNotNullParameter(r3, "source");
        return new q(r1, r2, r3, r4, r13);
    L18:
        r13 = 0;
        goto L19
    L11:
        r12 = null;
        goto L12
    }

    public q(String r2, int r3, String r4, int r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r4, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
