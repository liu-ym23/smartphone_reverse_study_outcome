package com.obric.oui.shadow;

import android.content.res.TypedArray;
import com.obric.oui.graphic.BlendMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final /* synthetic */ int g = 0;
    public final float a;
    public final float b;
    public final float c;
    public final int d;
    public final float e;
    public int f;

    /* JADX INFO: renamed from: com.obric.oui.shadow.a$a, reason: collision with other inner class name */
    public static final class C0005a {
        @JvmStatic
        public static int[] b(a r4) {
            Intrinsics.checkNotNullParameter(r4, "shadowConfig");
            b r0 = r4.b();
            if (r0.f != (-1)) goto L5;
            r0.f = BlendMode.SRC_OVER.getPorterDuffMode();
        L5:
            int r1 = r0.f;
            int[] r2 = {r0.d, r1};
            r4.f = r1;
            return r2;
        }

        @JvmStatic
        public static a a(TypedArray r9, int r10, int r11, int r12, int r13, int r14) {
            Intrinsics.checkNotNullParameter(r9, "typedArray");
            float r15 = r9.getDimension(r12, 0.0f);
            float r16 = r9.getDimension(r13, 0.0f);
            float r17 = r9.getDimension(r11, 0.0f);
            int r18 = r9.getColor(r10, 0);
            float r19 = r9.getDimension(r14, 0.0f);
            b r0 = new b(r15, r16, r17, r18, r19, -1);
            Intrinsics.checkNotNullParameter(r0, "<this>");
            return new a(r15, r16, r17, r18, r19, r0.f);
        }
    }

    static {
    }

    @JvmStatic
    public static final a a(TypedArray r0, int r1, int r2, int r3, int r4, int r5) {
        return C0005a.a(r0, r1, r2, r3, r4, r5);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.a), Float.valueOf(r6.a)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.b), Float.valueOf(r6.b)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.e), Float.valueOf(r6.e)) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + this.d) * 31) + Float.floatToIntBits(this.e)) * 31) + this.f;
    }

    public final String toString() {
        return "ShadowConfig(x=" + this.a + ", y=" + this.b + ", blurRadius=" + this.c + ", color=" + this.d + ", spread=" + this.e + ", blendMode=" + this.f + ')';
    }

    public final b b() {
        return new b(this.a, this.b, this.c, this.d, this.e, this.f);
    }

    public a(float r1, float r2, float r3, int r4, float r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
