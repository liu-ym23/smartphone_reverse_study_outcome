package com.ss.android.lark.image.uploader.entity;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final float a;
    public final String b;
    public final int c;

    public a() {
        this(1.0f, "native", 0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.a) * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final String toString() {
        return "compressRatio:" + this.a + ", compress_algorithm:" + this.b + ", compressCost:" + this.c;
    }

    public a(float r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "compressAlgorithm");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
