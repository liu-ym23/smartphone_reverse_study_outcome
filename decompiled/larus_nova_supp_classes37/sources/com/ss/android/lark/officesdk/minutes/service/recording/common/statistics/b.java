package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final boolean h;
    public final String i;
    public final boolean j;

    public b() {
        this(null, 1023);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        int r2 = 1231;
        if (this.h == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.i.hashCode()) * 31;
        if (this.j == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmD1204RecordingEventMetadata(hardwareUniqueId=" + this.a + ", sessionId=" + this.b + ", hardwareDeviceId=" + this.c + ", recordingSource=" + this.d + ", recordingTraceId=" + this.e + ", userId=" + this.f + ", tenantId=" + this.g + ", hardwareStarted=" + this.h + ", onlineMeetingId=" + this.i + ", onlineTokenReady=" + this.j + ')';
    }

    public /* synthetic */ b(String r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r15 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r15 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r15 & 16) == 0) goto L21;
        String r7 = "";
    L23:
        if ((r15 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r15 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r15 & 256) == 0) goto L33;
        String r11 = "";
    L34:
        this(r3, r4, r5, r6, r7, r8, r9, false, r11, false);
        return;
    L33:
        r11 = null;
        goto L34
    L29:
        r9 = null;
        goto L31
    L25:
        r8 = null;
        goto L27
    L21:
        r7 = null;
        goto L23
    L17:
        r6 = null;
        goto L19
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = r14;
        goto L7
    }

    public b(String r2, String r3, String r4, String r5, String r6, String r7, String r8, boolean r9, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "hardwareUniqueId");
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        Intrinsics.checkNotNullParameter(r4, "hardwareDeviceId");
        Intrinsics.checkNotNullParameter(r5, "recordingSource");
        Intrinsics.checkNotNullParameter(r6, "recordingTraceId");
        Intrinsics.checkNotNullParameter(r7, "userId");
        Intrinsics.checkNotNullParameter(r8, "tenantId");
        Intrinsics.checkNotNullParameter(r10, "onlineMeetingId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }

    public static b a(b r11, String r12, String r13, String r14, String r15, String r16, String r17, boolean r18, String r19, boolean r20, int r21) {
        if ((r21 & 1) == 0) goto L5;
        String r2 = r11.a;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r3 = r11.b;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r4 = r11.c;
    L15:
        if ((r21 & 8) == 0) goto L17;
        String r5 = r11.d;
    L19:
        if ((r21 & 16) == 0) goto L21;
        String r6 = r11.e;
    L23:
        if ((r21 & 32) == 0) goto L25;
        String r7 = r11.f;
    L27:
        if ((r21 & 64) == 0) goto L29;
        String r8 = r11.g;
    L31:
        if ((r21 & 128) == 0) goto L33;
        boolean r9 = r11.h;
    L35:
        if ((r21 & 256) == 0) goto L37;
        String r10 = r11.i;
    L39:
        if ((r21 & 512) == 0) goto L41;
        boolean r0 = r11.j;
    L42:
        Intrinsics.checkNotNullParameter(r2, "hardwareUniqueId");
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        Intrinsics.checkNotNullParameter(r4, "hardwareDeviceId");
        Intrinsics.checkNotNullParameter(r5, "recordingSource");
        Intrinsics.checkNotNullParameter(r6, "recordingTraceId");
        Intrinsics.checkNotNullParameter(r7, "userId");
        Intrinsics.checkNotNullParameter(r8, "tenantId");
        Intrinsics.checkNotNullParameter(r10, "onlineMeetingId");
        return new b(r2, r3, r4, r5, r6, r7, r8, r9, r10, r0);
    L41:
        r0 = r20;
        goto L42
    L37:
        r10 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = null;
        goto L7
    }
}
