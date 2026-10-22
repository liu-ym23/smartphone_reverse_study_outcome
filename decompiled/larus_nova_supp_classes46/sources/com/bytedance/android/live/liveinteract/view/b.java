package com.bytedance.android.live.liveinteract.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final int a;
    public final long b;
    public final String c;
    public final boolean d;
    public final long e;

    public b() {
        this(0, 31);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L16;
        b r7 = (b) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.c;
        if (r3 == null) goto L5;
        int r4 = r3.hashCode();
    L6:
        int r5 = (r2 + r4) * 31;
        boolean r6 = this.d;
        ?? r7 = r6;
        if (r6 == false) goto L9;
        r7 = 1;
    L9:
        int r8 = (r5 + r7) * 31;
        long r9 = this.e;
        return r8 + ((int) (r9 ^ (r9 >>> 32)));
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "RadioContentConfig(gravity=" + this.a + ", textSize=" + this.b + ", textColor=" + this.c + ", isScrolling=" + this.d + ", scrollSpeed=" + this.e + ")";
    }

    public /* synthetic */ b(long r11, int r13) {
        if ((r13 & 1) == 0) goto L5;
        int r3 = 17;
    L7:
        if ((r13 & 2) == 0) goto L9;
        r11 = 12;
    L9:
        long r4 = r11;
        if ((r13 & 4) == 0) goto L12;
        String r12 = "#FFFFFF";
    L13:
        String r6 = r12;
        if ((r13 & 8) == 0) goto L16;
        boolean r7 = true;
    L18:
        if ((r13 & 16) == 0) goto L20;
        long r14 = 2000;
    L21:
        this(r3, r4, r6, r7, r14);
        return;
    L20:
        r14 = 0;
        goto L21
    L16:
        r7 = false;
        goto L18
    L12:
        r12 = null;
        goto L13
    L5:
        r3 = 0;
        goto L7
    }

    public b(int r2, long r3, String r5, boolean r6, long r7) {
        Intrinsics.checkNotNullParameter(r5, "textColor");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
