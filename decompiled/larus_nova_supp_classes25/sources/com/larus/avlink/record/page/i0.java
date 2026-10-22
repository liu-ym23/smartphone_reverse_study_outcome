package com.larus.avlink.record.page;

import com.larus.minutes.api.MinutesOfflineRecordingDeviceType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i0 {
    public final String a;
    public final String b;
    public final String c;
    public final TagType d;
    public final String e;
    public final String f;
    public final Long g;
    public final Float h;
    public final MinutesOfflineRecordingDeviceType i;
    public final String j;

    public i0() {
        this(null, null, null, null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r6 = (i0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
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
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        TagType r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Float r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        MinutesOfflineRecordingDeviceType r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
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
        return "RecordMinutesItemData(id=" + this.a + ", title=" + this.b + ", contentSummary=" + this.c + ", tag=" + this.d + ", createTime=" + this.e + ", messageId=" + this.f + ", startTimeMs=" + this.g + ", uploadProgress=" + this.h + ", deviceType=" + this.i + ", larkDocToken=" + this.j + ')';
    }

    public static i0 a(i0 r15, TagType r16, Float r17, int r18) {
        String r3 = null;
        if ((r18 & 1) == 0) goto L5;
        String r5 = r15.a;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r6 = r15.b;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r7 = r15.c;
    L15:
        if ((r18 & 8) == 0) goto L17;
        TagType r8 = r15.d;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r9 = r15.e;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r10 = r15.f;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Long r11 = r15.g;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Float r12 = r15.h;
    L35:
        if ((r18 & 256) == 0) goto L37;
        MinutesOfflineRecordingDeviceType r13 = r15.i;
    L39:
        if ((r18 & 512) == 0) goto L42;
        r3 = r15.j;
    L42:
        return new i0(r5, r6, r7, r8, r9, r10, r11, r12, r13, r3);
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = r17;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = r16;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public /* synthetic */ i0(String r15, String r16, TagType r17, String r18, Long r19, Float r20, MinutesOfflineRecordingDeviceType r21, String r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r23 & 8) == 0) goto L13;
        TagType r7 = null;
    L15:
        if ((r23 & 16) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r23 & 64) == 0) goto L21;
        Long r10 = null;
    L23:
        if ((r23 & 128) == 0) goto L25;
        Float r11 = null;
    L27:
        if ((r23 & 256) == 0) goto L29;
        MinutesOfflineRecordingDeviceType r12 = null;
    L31:
        if ((r23 & 512) == 0) goto L33;
        String r13 = null;
    L34:
        this(r4, r5, null, r7, r8, null, r10, r11, r12, r13);
        return;
    L33:
        r13 = r22;
        goto L34
    L29:
        r12 = r21;
        goto L31
    L25:
        r11 = r20;
        goto L27
    L21:
        r10 = r19;
        goto L23
    L17:
        r8 = r18;
        goto L19
    L13:
        r7 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }

    public i0(String r1, String r2, String r3, TagType r4, String r5, String r6, Long r7, Float r8, MinutesOfflineRecordingDeviceType r9, String r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
