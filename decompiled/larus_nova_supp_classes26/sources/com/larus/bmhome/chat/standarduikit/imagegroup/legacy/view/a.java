package com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final y a;
    public final x b;
    public final w c;
    public final float d;
    public final int e;
    public final Function0<Map<String, Object>> f;
    public final bc8.b g;

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
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
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Float.floatToIntBits(this.d)) * 31) + this.e) * 31;
        Function0<Map<String, Object>> r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        bc8.b r5 = this.g;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageGroupLegacyInput(sizeData=" + this.a + ", imagesData=" + this.b + ", imageTraceData=" + this.c + ", radius=" + this.d + ", showImageLimit=" + this.e + ", eventExtra=" + this.f + ", blockActionCallback=" + this.g + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(y r2, x r3, w r4, float r5, int r6, Function0<? extends Map<String, ? extends Object>> r7, bc8.b r8) {
        Intrinsics.checkNotNullParameter(r2, "sizeData");
        Intrinsics.checkNotNullParameter(r3, "imagesData");
        Intrinsics.checkNotNullParameter(r4, "imageTraceData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
