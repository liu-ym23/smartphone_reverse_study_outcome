package com.ss.android.lark.movable.attatchment;

import com.ss.android.lark.maintab.export.TabAppInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r {
    public final String a;
    public final String b;
    public final float c;
    public final float d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
    }

    public final String toString() {
        return "PhotoWithSize(key=" + this.a + ", type=" + this.b + ", width=" + this.c + ", height=" + this.d + ')';
    }

    public final String getType() {
        return this.b;
    }

    public r(String r2, String r3, float r4, float r5) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
