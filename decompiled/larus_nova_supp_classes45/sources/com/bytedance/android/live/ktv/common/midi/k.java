package com.bytedance.android.live.ktv.common.midi;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final int e;
    public final Integer f;
    public final int g;
    public final boolean h;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k) == false) goto L22;
        k r4 = (k) r3;
        if (Float.compare(this.a, r4.a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r4.b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.c, r4.c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.d, r4.d) == 0) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    public final int hashCode() {
        int r0 = ((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + this.e) * 31;
        Integer r1 = this.f;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = (((r0 + r2) * 31) + this.g) * 31;
        boolean r4 = this.h;
        ?? r5 = r4;
        if (r4 == false) goto L10;
        r5 = 1;
    L10:
        return r3 + r5;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ScoreInfo(curTone=" + this.a + ", midiTone=" + this.b + ", sentenceScore=" + this.c + ", avgScore=" + this.d + ", curSentenceIndex=" + this.e + ", hitType=" + this.f + ", comboCount=" + this.g + ", isSeekData=" + this.h + ")";
    }

    public k(float r3, float r4, float r5, float r6, int r7, Integer r8, int r9, boolean r11, int r12) {
        if ((r12 & 32) == 0) goto L6;
        r8 = null;
    L6:
        if ((r12 & 64) == 0) goto L9;
        r9 = 0;
    L9:
        if ((r12 & 128) == 0) goto L11;
        r11 = false;
    L11:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r11;
    }
}
