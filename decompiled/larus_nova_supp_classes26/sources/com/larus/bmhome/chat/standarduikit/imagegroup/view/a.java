package com.larus.bmhome.chat.standarduikit.imagegroup.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final float e;
    public final Boolean f;

    public a() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (((((r3 + r2) * 31) + this.d) * 31) + Float.floatToIntBits(this.e)) * 31;
        Boolean r5 = this.f;
        if (r5 != null) goto L13;
        int r6 = 0;
    L15:
        return r4 + r6;
    L13:
        r6 = r5.hashCode();
        goto L15
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "SizeData(maxWidth=" + this.a + ", isHead=" + this.b + ", isTail=" + this.c + ", imageCount=" + this.d + ", firstImageRatio=" + this.e + ", isTop=" + this.f + ')';
    }

    public /* synthetic */ a(int r8) {
        this(0, false, false, 0, 0.0f, Boolean.FALSE);
    }

    public a(int r1, boolean r2, boolean r3, int r4, float r5, Boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
