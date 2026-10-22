package com.bytedance.android.annie.bridge.method.calendar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final long a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final String g;
    public final int h;

    public b() {
        this(0, null, null, null, null, 0, null, 255, 0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r11.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r10 = this.b;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r1 + r12) * 31;
        String r14 = this.c;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.d;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.e;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (((r19 + r21) * 31) + this.f) * 31;
        String r23 = this.g;
        if (r23 == null) goto L23;
        r11 = r23.hashCode();
    L23:
        return ((r22 + r11) * 31) + this.h;
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "CalendarModel(id=" + this.a + ", name=" + this.b + ", displayName=" + this.c + ", accountType=" + this.d + ", accountName=" + this.e + ", visible=" + this.f + ", ownerAccount=" + this.g + ", accessLevel=" + this.h + ')';
    }

    public b(long r1, String r10, String r11, String r12, String r13, int r14, String r15, int r16) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
    }

    public /* synthetic */ b(long r12, String r14, String r15, String r16, String r17, int r18, String r19, int r20, int r21) {
        if ((r20 & 1) == 0) goto L5;
        long r1 = 0;
    L6:
        String r10 = null;
        if ((r20 & 2) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r22 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r23 = null;
    L22:
        int r24 = 0;
        if ((r20 & 32) == 0) goto L25;
        int r25 = 0;
    L27:
        if ((r20 & 64) != 0) goto L31;
        r10 = r19;
    L31:
        if ((r20 & 128) == 0) goto L33;
        r24 = -1;
    L33:
        this(r1, r11, r13, r22, r23, r25, r10, r24);
        return;
    L25:
        r25 = r18;
        goto L27
    L21:
        r23 = r17;
        goto L22
    L17:
        r22 = r16;
        goto L19
    L13:
        r13 = r15;
        goto L15
    L9:
        r11 = r14;
        goto L11
    L5:
        r1 = r12;
        goto L6
    }
}
