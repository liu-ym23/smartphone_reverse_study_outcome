package com.ss.android.lark.image.compose.common.avatar;

import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.image.compose.common.ImageFormat;
import com.ss.android.lark.maintab.export.TabAppInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final String a;
    public final String b;
    public final float c;
    public final int d;
    public final ImageFormat e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Dp.equals-impl0(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Dp.hashCode-impl(this.c)) * 31) + this.d) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "AvatarImage(key=" + this.a + ", entityId=" + this.b + ", dpSize=" + Dp.toString-impl(this.c) + ", dpr=" + this.d + ", format=" + this.e + ')';
    }

    public a(String r2, String r3, float r4, ImageFormat r5) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "entityId");
        Intrinsics.checkNotNullParameter(r5, "format");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = 1;
        this.e = r5;
    }
}
