package com.larus.avlink.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public final Integer a;
    public final String b;
    public final Long c;
    public final Long d;
    public final Long e;

    public i() {
        this(null, null, null, null, 31);
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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
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
        Long r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.e;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "CommandSend(command=" + this.a + ", messageId=" + this.b + ", commandStartTime=" + this.c + ", commandReceivedTime=" + this.d + ", commandSendTime=" + this.e + ')';
    }

    public /* synthetic */ i(Integer r9, String r10, Long r11, Long r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        Integer r3 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        Long r5 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        Long r6 = null;
    L18:
        this(r3, r4, r5, r6, null);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public i(Integer r1, String r2, Long r3, Long r4, Long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
