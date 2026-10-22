package com.larus.avlink.env.diary.style;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final long h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r9 = (e0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        int r4 = 1231;
        if (this.e == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.f == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.g == true) goto L18;
        r4 = 1237;
    L18:
        long r9 = this.h;
        return ((r8 + r4) * 31) + ((int) (r9 ^ (r9 >>> 32)));
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DiaryStyleItem(id=" + this.a + ", name=" + this.b + ", prompt=" + this.c + ", iconUrl=" + this.d + ", isSelected=" + this.e + ", isCustom=" + this.f + ", isAddButton=" + this.g + ", createTime=" + this.h + ')';
    }

    public static e0 a(e0 r14, String r15, String r16, boolean r17, boolean r18, int r19) {
        String r3 = null;
        if ((r19 & 1) == 0) goto L5;
        String r5 = r14.a;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r6 = r14.b;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r7 = r14.c;
    L15:
        if ((r19 & 8) == 0) goto L17;
        r3 = r14.d;
    L17:
        String r8 = r3;
        if ((r19 & 16) == 0) goto L20;
        boolean r9 = r14.e;
    L22:
        if ((r19 & 32) == 0) goto L24;
        boolean r10 = r14.f;
    L26:
        if ((r19 & 64) == 0) goto L28;
        boolean r11 = r14.g;
    L30:
        if ((r19 & 128) == 0) goto L32;
        long r1 = r14.h;
    L33:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r6, "name");
        Intrinsics.checkNotNullParameter(r7, "prompt");
        return new e0(r5, r6, r7, r8, r9, r10, r11, r1);
    L32:
        r1 = 0;
        goto L33
    L28:
        r11 = false;
        goto L30
    L24:
        r10 = r18;
        goto L26
    L20:
        r9 = r17;
        goto L22
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public /* synthetic */ e0(String r13, String r14, String r15, String r16, boolean r17, boolean r18, boolean r19, int r20) {
        if ((r20 & 8) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r20 & 32) == 0) goto L13;
        boolean r8 = false;
    L15:
        if ((r20 & 64) == 0) goto L17;
        boolean r9 = false;
    L19:
        if ((r20 & 128) == 0) goto L21;
        long r0 = System.currentTimeMillis();
    L22:
        this(r13, r14, r15, r6, r7, r8, r9, r0);
        return;
    L21:
        r0 = 0;
        goto L22
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public e0(String r2, String r3, String r4, String r5, boolean r6, boolean r7, boolean r8, long r9) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "prompt");
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
