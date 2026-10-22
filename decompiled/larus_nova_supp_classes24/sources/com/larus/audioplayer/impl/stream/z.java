package com.larus.audioplayer.impl.stream;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public boolean e;
    public Bitmap f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z) == true) goto L8;
        return false;
    L8:
        z r6 = (z) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        if (this.e == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r4 + r5) * 31;
        Bitmap r7 = this.f;
        if (r7 == null) goto L15;
        r2 = r7.hashCode();
    L15:
        return r6 + r2;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "StreamPlayerInfo(uuid=" + this.a + ", title=" + this.b + ", artist=" + this.c + ", coverUrl=" + this.d + ", isPlaying=" + this.e + ", coverBitmap=" + this.f + ')';
    }

    public z(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "artist");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = true;
        this.f = null;
    }
}
