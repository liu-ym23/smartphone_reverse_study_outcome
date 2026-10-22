package com.larus.slides.impl.select.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final boolean a;
    public final String b;
    public final String c;
    public final long d;
    public final int e;
    public final int f;

    public a() {
        String r0 = null;
        this(r0, r0, 63);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        String r6 = this.c;
        if (r6 == null) goto L14;
        r3 = r6.hashCode();
    L14:
        long r7 = this.d;
        return ((((((r5 + r3) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31) + this.e) * 31) + this.f;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "CallbackImageInfo(result=" + this.a + ", localPath=" + this.b + ", fileName=" + this.c + ", fileSize=" + this.d + ", width=" + this.e + ", height=" + this.f + ')';
    }

    public /* synthetic */ a(String r9, String r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r11 & 4) == 0) goto L8;
        String r3 = null;
    L9:
        this(false, r9, r3, 0, 0, 0);
        return;
    L8:
        r3 = r10;
        goto L9
    }

    public a(boolean r1, String r2, String r3, long r4, int r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
    }
}
