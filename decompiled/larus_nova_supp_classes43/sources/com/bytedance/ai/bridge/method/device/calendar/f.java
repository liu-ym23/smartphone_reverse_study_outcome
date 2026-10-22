package com.bytedance.ai.bridge.method.device.calendar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final a l = null;
    public final String a;
    public final long b;
    public final boolean c;
    public final String d;
    public final String e;
    public final long f;
    public final boolean g;
    public final long h;
    public final String i;
    public final RepeatInterval j;
    public final Long k;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
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
        if (this.g == r11.g) goto L30;
        return false;
    L30:
        if (this.h == r11.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r11.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r11.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        int r11 = 1231;
        if (this.c == false) goto L5;
        int r12 = 1231;
    L6:
        int r13 = (r10 + r12) * 31;
        String r14 = this.d;
        int r15 = 0;
        if (r14 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r13 + r16) * 31;
        String r18 = this.e;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        long r20 = this.f;
        int r21 = (((r17 + r19) * 31) + ((int) (r20 ^ (r20 >>> 32)))) * 31;
        if (this.g == true) goto L18;
        r11 = 1237;
    L18:
        long r22 = this.h;
        int r23 = (((r21 + r11) * 31) + ((int) (r22 ^ (r22 >>> 32)))) * 31;
        String r24 = this.i;
        if (r24 != null) goto L21;
        int r25 = 0;
    L22:
        int r26 = (r23 + r25) * 31;
        RepeatInterval r27 = this.j;
        if (r27 != null) goto L25;
        int r28 = 0;
    L26:
        int r29 = (r26 + r28) * 31;
        Long r30 = this.k;
        if (r30 == null) goto L31;
        r15 = r30.hashCode();
    L31:
        return r29 + r15;
    L25:
        r28 = r27.hashCode();
        goto L26
    L21:
        r25 = r24.hashCode();
        goto L22
    L13:
        r19 = r18.hashCode();
        goto L14
    L9:
        r16 = r14.hashCode();
        goto L10
    L5:
        r12 = 1237;
        goto L6
    }

    public final String toString() {
        return "CalendarEventArgs(title=" + this.a + ", startTime=" + this.b + ", allDay=" + this.c + ", description=" + this.d + ", location=" + this.e + ", endTime=" + this.f + ", alarm=" + this.g + ", alarmOffset=" + this.h + ", path=" + this.i + ", repeatInterval=" + this.j + ", repeatEndTime=" + this.k + ')';
    }

    static {
        l = new a();
    }

    public f(String r10, long r11, boolean r12, String r13, String r14, long r15, boolean r16, long r17, String r18, RepeatInterval r19, Long r110) {
        Intrinsics.checkNotNullParameter(r10, "title");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r110;
    }
}
