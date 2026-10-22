package com.larus.bmhome.view;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatTitleAlignLeftStyle$b {
    public final ColorStateList a;
    public final Drawable.ConstantState b;
    public final float c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final Typeface h;
    public final int i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatTitleAlignLeftStyle$b) == true) goto L8;
        return false;
    L8:
        ChatTitleAlignLeftStyle$b r6 = (ChatTitleAlignLeftStyle$b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        ColorStateList r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Drawable.ConstantState r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((((((((r3 + r5) * 31) + Float.floatToIntBits(this.c)) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31;
        Typeface r7 = this.h;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((r6 + r1) * 31) + this.i;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TagDefaultStyle(textColors=" + this.a + ", backgroundState=" + this.b + ", textSizePx=" + this.c + ", paddingStart=" + this.d + ", paddingTop=" + this.e + ", paddingEnd=" + this.f + ", paddingBottom=" + this.g + ", typeface=" + this.h + ", gravity=" + this.i + ')';
    }

    public ChatTitleAlignLeftStyle$b(ColorStateList r1, Drawable.ConstantState r2, float r3, int r4, int r5, int r6, int r7, Typeface r8, int r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
