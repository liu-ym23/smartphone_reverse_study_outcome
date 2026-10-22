package df;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public q() {
        this(null, null, null, null, 255);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof q) == false) goto L22;
        q r11 = (q) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.c;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.d;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.e;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.f;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        String r27 = this.g;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        String r30 = this.h;
        if (r30 == null) goto L34;
        r1 = r30.hashCode();
    L34:
        return r29 + r1;
    L29:
        r28 = 0;
        goto L30
    L25:
        r25 = 0;
        goto L26
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPPassThough(whichAccount=" + this.a + ", recommendInfo=" + this.b + ", requestId=" + this.c + ", labelNameFromLive=" + this.d + ", baseVerifiedCategory=" + this.e + ", labelNameLive=" + this.f + ", transitionTrackerData=" + this.g + ", threeDLogData=" + this.h + ")";
    }

    public /* synthetic */ q(String r10, String r11, String r12, String r13, int r14) {
        if ((r14 & 8) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 16) == 0) goto L8;
        String r15 = null;
    L10:
        if ((r14 & 32) == 0) goto L12;
        String r16 = null;
    L14:
        if ((r14 & 128) == 0) goto L16;
        String r17 = null;
    L17:
        this(null, null, null, r10, r15, r16, null, r17);
        return;
    L16:
        r17 = r13;
        goto L17
    L12:
        r16 = r12;
        goto L14
    L8:
        r15 = r11;
        goto L10
    }

    public q(String r1, String r10, String r11, String r12, String r13, String r14, String r15, String r16) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
    }
}
