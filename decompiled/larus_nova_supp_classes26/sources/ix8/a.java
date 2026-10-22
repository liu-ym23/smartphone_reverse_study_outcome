package ix8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Long a;
    public final float b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    public a() {
        this(null, 0.0f, 0, false, false, 63);
    }

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
        if (Float.compare(this.b, r6.b) == 0) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
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
        Long r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((((r1 * 31) + Float.floatToIntBits(this.b)) * 31) + this.c) * 31;
        int r3 = 1231;
        if (this.d == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.e == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.f == true) goto L19;
        r3 = 1237;
    L19:
        return r7 + r3;
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
        return "VLMIntentDetectConfig(timeoutMs=" + this.a + ", resizeShortSide=" + this.b + ", imageCompressQuality=" + this.c + ", needIntent=" + this.d + ", needDewarp=" + this.e + ", needDetection=" + this.f + ')';
    }

    public /* synthetic */ a(Long r8, float r9, int r10, boolean r11, boolean r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        r8 = null;
    L5:
        Long r1 = r8;
        if ((r13 & 2) == 0) goto L8;
        float r2 = 720.0f;
    L10:
        if ((r13 & 4) == 0) goto L12;
        int r3 = 70;
    L14:
        if ((r13 & 8) == 0) goto L16;
        boolean r4 = true;
    L18:
        if ((r13 & 16) == 0) goto L20;
        boolean r5 = false;
    L22:
        if ((r13 & 32) == 0) goto L24;
        boolean r6 = true;
    L25:
        this(r1, r2, r3, r4, r5, r6);
        return;
    L24:
        r6 = r12;
        goto L25
    L20:
        r5 = r11;
        goto L22
    L16:
        r4 = false;
        goto L18
    L12:
        r3 = r10;
        goto L14
    L8:
        r2 = r9;
        goto L10
    }

    public a(Long r1, float r2, int r3, boolean r4, boolean r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
