package com.bytedance.android.live.multilink.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w2 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final String g;
    public final int h;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof w2) == false) goto L22;
        w2 r4 = (w2) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        String r1 = this.g;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((r0 + r2) * 31) + this.h;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "LinkResult(layout=" + this.a + ", scene=" + this.b + ", finalScene=" + this.c + ", source=" + this.d + ", uiLayout=" + this.e + ", initType=" + this.f + ", openSource=" + this.g + ", playMode=" + this.h + ")";
    }

    public w2(int r2, int r3, int r4, int r5, int r6, int r7, String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "openSource");
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
