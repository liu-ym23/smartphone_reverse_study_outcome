package com.larus.platform.audit;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final String a;
    public final String b;
    public final Long c;
    public final String d;
    public final String e;

    public b() {
        this(null, null, null, null, null, 31);
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
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
        Long r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
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
        return "BehaviorAuditFileInfo(fileId=" + this.a + ", fileName=" + this.b + ", fileSize=" + this.c + ", md5=" + this.d + ", fileType=" + this.e + ')';
    }

    public b(String r1, String r2, Long r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public /* synthetic */ b(String r6, String r7, Long r8, String r9, String r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r11 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r11 & 4) == 0) goto L13;
        Long r3 = null;
    L15:
        if ((r11 & 8) == 0) goto L17;
        String r4 = null;
    L19:
        if ((r11 & 16) == 0) goto L21;
        String r12 = null;
    L22:
        this(r0, r2, r3, r4, r12);
        return;
    L21:
        r12 = r10;
        goto L22
    L17:
        r4 = r9;
        goto L19
    L13:
        r3 = r8;
        goto L15
    L9:
        r2 = r7;
        goto L11
    L5:
        r0 = r6;
        goto L7
    }
}
