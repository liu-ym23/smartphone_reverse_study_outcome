package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y {
    public final boolean a;
    public final z b;
    public final z c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final String g;
    public final String h;
    public final String i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r6 = (y) r5;
        if (this.a == r6.a) goto L12;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
        if (this.e == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.f == true) goto L14;
        r1 = 1237;
    L14:
        int r5 = (r4 + r1) * 31;
        String r6 = this.g;
        int r7 = 0;
        if (r6 != null) goto L17;
        int r8 = 0;
    L18:
        int r9 = (r5 + r8) * 31;
        String r10 = this.h;
        if (r10 != null) goto L21;
        int r11 = 0;
    L22:
        int r12 = (r9 + r11) * 31;
        String r13 = this.i;
        if (r13 == null) goto L27;
        r7 = r13.hashCode();
    L27:
        return r12 + r7;
    L21:
        r11 = r10.hashCode();
        goto L22
    L17:
        r8 = r6.hashCode();
        goto L18
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreviewUIState(disable=" + this.a + ", avatarUri=" + this.b + ", bgUri=" + this.c + ", bgColor=" + this.d + ", bgOpen=" + this.e + ", isInAiGenProcess=" + this.f + ", initialBgUrl=" + this.g + ", originalAvatarImgUri=" + this.h + ", originalBackgroundImgUri=" + this.i + ')';
    }

    public y(boolean r2, z r3, z r4, int r5, boolean r6, boolean r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r3, "avatarUri");
        Intrinsics.checkNotNullParameter(r4, "bgUri");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
