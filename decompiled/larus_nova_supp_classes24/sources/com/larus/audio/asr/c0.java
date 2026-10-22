package com.larus.audio.asr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c0 {
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public c0() {
        String r2 = null;
        this(r2, r2, 0, 255);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r6 = (c0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d) * 31;
        String r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.h;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrTraceInfo(traceId=" + this.a + ", enterFrom=" + this.b + ", isAudioComplement=" + this.c + ", picCnt=" + this.d + ", enterMethod=" + this.e + ", showScene=" + this.f + ", currentPage=" + this.g + ", endStatus=" + this.h + ')';
    }

    public /* synthetic */ c0(String r12, String r13, int r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r15 & 4) == 0) goto L13;
        int r5 = 0;
    L15:
        if ((r15 & 32) == 0) goto L17;
        String r8 = "";
    L19:
        if ((r15 & 64) == 0) goto L21;
        String r9 = "";
    L23:
        if ((r15 & 128) == 0) goto L25;
        String r10 = "";
    L26:
        this(r3, r4, r5, 0, null, r8, r9, r10);
        return;
    L25:
        r10 = null;
        goto L26
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    public static c0 a(c0 r13, int r14, String r15, String r16, String r17, String r19, int r110) {
        String r3 = null;
        if ((r110 & 1) == 0) goto L5;
        String r5 = r13.a;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r3 = r13.b;
    L9:
        String r6 = r3;
        if ((r110 & 4) == 0) goto L12;
        int r7 = r13.c;
    L14:
        if ((r110 & 8) == 0) goto L16;
        int r8 = r13.d;
    L18:
        if ((r110 & 16) == 0) goto L20;
        String r9 = r13.e;
    L22:
        if ((r110 & 32) == 0) goto L24;
        String r10 = r13.f;
    L26:
        if ((r110 & 64) == 0) goto L28;
        String r11 = r13.g;
    L30:
        if ((r110 & 128) == 0) goto L32;
        String r12 = r13.h;
    L33:
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r6, "enterFrom");
        return new c0(r5, r6, r7, r8, r9, r10, r11, r12);
    L32:
        r12 = r19;
        goto L33
    L28:
        r11 = r17;
        goto L30
    L24:
        r10 = r16;
        goto L26
    L20:
        r9 = r15;
        goto L22
    L16:
        r8 = r14;
        goto L18
    L12:
        r7 = 0;
        goto L14
    L5:
        r5 = null;
        goto L7
    }

    public c0(String r2, String r3, int r4, int r5, String r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
