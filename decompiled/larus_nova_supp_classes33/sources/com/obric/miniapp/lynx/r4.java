package com.obric.miniapp.lynx;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r4 {
    public final String a;
    public final Drawable b;
    public final Drawable c;
    public final boolean d;
    public final JSONObject e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r4) == true) goto L8;
        return false;
    L8:
        r4 r6 = (r4) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Drawable r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Drawable r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        if (this.d == false) goto L13;
        int r7 = 1231;
    L15:
        return ((r6 + r7) * 31) + this.e.hashCode();
    L13:
        r7 = 1237;
        goto L15
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MiniAppButtonGroupItem(title=" + this.a + ", icon=" + this.b + ", tailIcon=" + this.c + ", disabled=" + this.d + ", json=" + this.e + ')';
    }

    public r4(String r2, Drawable r3, Drawable r4, boolean r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r6, "json");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
