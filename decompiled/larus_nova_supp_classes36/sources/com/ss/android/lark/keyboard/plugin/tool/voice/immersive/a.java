package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final int a;
    public final boolean b;
    public final float c;
    public final boolean d;
    public final Integer e;
    public final Integer f;
    public final Integer g;

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
        if (Float.compare(this.c, r6.c) == 0) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + Float.floatToIntBits(this.c)) * 31;
        if (this.d == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (r3 + r2) * 31;
        Integer r5 = this.e;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r4 + r7) * 31;
        Integer r9 = this.f;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        Integer r12 = this.g;
        if (r12 == null) goto L23;
        r6 = r12.hashCode();
    L23:
        return r11 + r6;
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
        return "AdvanceVoiceButtonConfig(textRes=" + this.a + ", enableTextMode=" + this.b + ", textSizeSp=" + this.c + ", isTextBold=" + this.d + ", buttonHeight=" + this.e + ", buttonVerticalPadding=" + this.f + ", buttonTopMargin=" + this.g + ')';
    }

    public a(boolean r2, boolean r3, Integer r4, Integer r5, Integer r6) {
        this.a = 2131890974;
        this.b = r2;
        this.c = 14.0f;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
    }
}
