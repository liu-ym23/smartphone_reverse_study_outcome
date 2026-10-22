package com.larus.bmhome.taskskill.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p {
    public final CharSequence a;
    public final CharSequence b;
    public final CharSequence c;
    public final PcConnectionStatusAction d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public p() {
        this(null, null, null, null, false, false, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        CharSequence r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        PcConnectionStatusAction r5 = this.d;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        int r7 = 1231;
        if (this.e == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.f == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        if (this.g == true) goto L23;
        r7 = 1237;
    L23:
        return r11 + r7;
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PcConnectionStatusUiModel(deviceName=" + this.a + ", hintText=" + this.b + ", actionText=" + this.c + ", action=" + this.d + ", shimmer=" + this.e + ", visible=" + this.f + ", directUseHint=" + this.g + ')';
    }

    public p(CharSequence r3, CharSequence r4, CharSequence r5, PcConnectionStatusAction r6, boolean r7, boolean r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r9 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r9 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r9 & 32) == 0) goto L18;
        r7 = true;
    L18:
        if ((r9 & 64) == 0) goto L20;
        r8 = false;
    L20:
        Intrinsics.checkNotNullParameter(r3, "deviceName");
        Intrinsics.checkNotNullParameter(r4, "hintText");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = false;
        this.f = r7;
        this.g = r8;
    }
}
