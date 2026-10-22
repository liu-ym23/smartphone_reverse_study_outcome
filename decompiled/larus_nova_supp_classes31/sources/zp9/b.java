package zp9;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final int a;
    public final float b;
    public final float c;
    public final double[] d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;

    public final String toString() {
        return "AvatarDetectResult(faceCount=" + this.a + ", faceClarityScore=" + this.b + ", faceIPAScore=" + this.c + ", faceVerifyRes=" + Arrays.toString(this.d) + ", faceQualityScore=" + this.e + ", faceOcclusionRate=" + this.f + ", faceYaw=" + this.g + ", facePitch=" + this.h + ')';
    }

    public final int hashCode() {
        int r0 = ((((((((((((this.a * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h)) * 31;
        double[] r1 = this.d;
        if (r1 == null) goto L5;
        int r2 = Arrays.hashCode(r1);
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(b.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larus.platform.api.creation.AvatarDetectResult");
        b r6 = (b) r5;
        if (this.a == r6.a) goto L16;
        return false;
    L16:
        if (this.b != r6.b) goto L18;
        boolean r1 = true;
    L19:
        if (r1 == true) goto L22;
        return false;
    L22:
        if (this.c != r6.c) goto L24;
        boolean r3 = true;
    L25:
        if (r3 == true) goto L28;
        return false;
    L28:
        if (this.e != r6.e) goto L30;
        boolean r4 = true;
    L31:
        if (r4 == true) goto L34;
        return false;
    L34:
        if (this.f != r6.f) goto L36;
        boolean r7 = true;
    L37:
        if (r7 == true) goto L40;
        return false;
    L40:
        if (this.g != r6.g) goto L42;
        boolean r8 = true;
    L43:
        if (r8 == true) goto L46;
        return false;
    L46:
        if (this.h != r6.h) goto L48;
        boolean r9 = true;
    L49:
        if (r9 == true) goto L52;
        return false;
    L52:
        if (Arrays.equals(this.d, r6.d) == true) goto L54;
        return false;
    L54:
        return true;
    L48:
        r9 = false;
        goto L49
    L42:
        r8 = false;
        goto L43
    L36:
        r7 = false;
        goto L37
    L30:
        r4 = false;
        goto L31
    L24:
        r3 = false;
        goto L25
    L18:
        r1 = false;
        goto L19
    L8:
        r2 = null;
        goto L10
    }

    public b(int r1, float r2, float r3, double[] r4, float r5, float r6, float r7, float r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
