package com.larus.project;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public final String a;
    public final String b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final boolean j;

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
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        int r2 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        String r4 = this.d;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        String r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.g;
        if (r14 == null) goto L22;
        r5 = r14.hashCode();
    L22:
        int r15 = (r13 + r5) * 31;
        if (this.h == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        if (this.i == false) goto L29;
        int r18 = 1231;
    L30:
        int r19 = (r17 + r18) * 31;
        if (this.j == true) goto L35;
        r2 = 1237;
    L35:
        return r19 + r2;
    L29:
        r18 = 1237;
        goto L30
    L25:
        r16 = 1237;
        goto L26
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskProject(projectId=" + this.a + ", name=" + this.b + ", isCloudProject=" + this.c + ", folderName=" + this.d + ", workspace=" + this.e + ", deviceId=" + this.f + ", deviceName=" + this.g + ", isDeviceOnline=" + this.h + ", isSelected=" + this.i + ", isEnabled=" + this.j + ')';
    }

    public /* synthetic */ i(String r12, String r13, boolean r14, String r15, String r16, String r17, String r18) {
        this(r12, r13, r14, r15, r16, r17, r18, false, false, true);
    }

    public i(String r2, String r3, boolean r4, String r5, String r6, String r7, String r8, boolean r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "projectId");
        Intrinsics.checkNotNullParameter(r3, "name");
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
}
