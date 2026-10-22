package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.net.Uri;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final Uri a;
    public final boolean b;
    public final boolean c;
    public final TextRes d;
    public final boolean e;
    public final boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Uri r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        int r3 = 1231;
        if (this.b == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.c == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (((r5 + r6) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.f == true) goto L23;
        r3 = 1237;
    L23:
        return r9 + r3;
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BgImageUIState(uri=" + this.a + ", needResize=" + this.b + ", isCircle=" + this.c + ", btnStr=" + this.d + ", isBtnBlue=" + this.e + ", isGenerating=" + this.f + ')';
    }

    public c(Uri r2, boolean r3, boolean r4, TextRes.StringResId r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "btnStr");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
