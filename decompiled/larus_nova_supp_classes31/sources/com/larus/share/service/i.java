package com.larus.share.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Integer h;
    public final String i;
    public final Integer j;
    public final Integer k;

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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
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
        int r4 = (r3 + r2) * 31;
        String r5 = this.d;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r4 + r7) * 31;
        String r9 = this.e;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        String r12 = this.f;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.g;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        Integer r18 = this.h;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        String r21 = this.i;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        Integer r24 = this.j;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        Integer r27 = this.k;
        if (r27 == null) goto L43;
        r6 = r27.hashCode();
    L43:
        return r26 + r6;
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r5.hashCode();
        goto L14
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShareDocPermissionParams(token=" + this.a + ", isPublic=" + this.b + ", isLandscape=" + this.c + ", aipptTaskId=" + this.d + ", presentationId=" + this.e + ", spreadsheetId=" + this.f + ", resourceId=" + this.g + ", resourceType=" + this.h + ", artifactMetaId=" + this.i + ", artifactType=" + this.j + ", fileType=" + this.k + ')';
    }

    public i(String r3, boolean r4, boolean r5, String r6, String r7, String r8, String r9, Integer r10, String r11, Integer r12, Integer r13, int r14) {
        if ((r14 & 8) == 0) goto L6;
        r6 = null;
    L6:
        if ((r14 & 16) == 0) goto L9;
        r7 = null;
    L9:
        if ((r14 & 32) == 0) goto L12;
        r8 = null;
    L12:
        if ((r14 & 64) == 0) goto L15;
        r9 = null;
    L15:
        if ((r14 & 128) == 0) goto L18;
        r10 = null;
    L18:
        if ((r14 & 256) == 0) goto L21;
        r11 = null;
    L21:
        if ((r14 & 512) == 0) goto L24;
        r12 = null;
    L24:
        if ((r14 & 1024) == 0) goto L26;
        r13 = null;
    L26:
        Intrinsics.checkNotNullParameter(r3, "token");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
    }
}
