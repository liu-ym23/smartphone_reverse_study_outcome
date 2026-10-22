package com.larus.asr.session.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k0 {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final com.larus.audio.asr.c0 d;
    public final long e;
    public final Long f;
    public final Integer g;
    public final d58.a h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r9 = (k0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (((r3 + r2) * 31) + this.d.hashCode()) * 31;
        long r5 = this.e;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        Long r7 = this.f;
        int r8 = 0;
        if (r7 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r6 + r9) * 31;
        Integer r11 = this.g;
        if (r11 == null) goto L19;
        r8 = r11.hashCode();
    L19:
        return ((r10 + r8) * 31) + this.h.hashCode();
    L13:
        r9 = r7.hashCode();
        goto L14
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatAsrSessionRequest(itemId=" + this.a + ", fromTextArea=" + this.b + ", needVibrate=" + this.c + ", traceInfo=" + this.d + ", startTime=" + this.e + ", preStartTime=" + this.f + ", vuiId=" + this.g + ", durationConfig=" + this.h + ')';
    }

    public k0(String r2, boolean r3, boolean r4, com.larus.audio.asr.c0 r5, long r6, Long r8, Integer r9, d58.a r10) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        Intrinsics.checkNotNullParameter(r5, "traceInfo");
        Intrinsics.checkNotNullParameter(r10, "durationConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
