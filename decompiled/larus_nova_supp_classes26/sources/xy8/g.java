package xy8;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final nr9.f e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final int j;
    public final int k;
    public final double l;
    public final int m;
    public final Bitmap n;
    public final String o;
    public final String p;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r9 = (g) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (Double.compare(this.l, r9.l) == 0) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r9.p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        nr9.f r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.g;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.h;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.i;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (((((r22 + r24) * 31) + this.j) * 31) + this.k) * 31;
        long r26 = Double.doubleToLongBits(this.l);
        int r27 = (((r25 + ((int) (r26 ^ (r26 >>> 32)))) * 31) + this.m) * 31;
        Bitmap r28 = this.n;
        if (r28 != null) goto L37;
        int r29 = 0;
    L38:
        int r30 = (((r27 + r29) * 31) + this.o.hashCode()) * 31;
        String r31 = this.p;
        if (r31 == null) goto L43;
        r2 = r31.hashCode();
    L43:
        return r30 + r2;
    L37:
        r29 = r28.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoContent(engineKey=" + this.a + ", playUrl=" + this.b + ", downloadFilehash=" + this.c + ", coverUrl=" + this.d + ", cover=" + this.e + ", localPath=" + this.f + ", videoModel=" + this.g + ", format=" + this.h + ", resourceId=" + this.i + ", width=" + this.j + ", height=" + this.k + ", duration=" + this.l + ", startTime=" + this.m + ", coverBitmap=" + this.n + ", tag=" + this.o + ", localUri=" + this.p + ')';
    }

    public static g a(g r19, int r20, Bitmap r21) {
        String r1 = r19.a;
        String r2 = r19.b;
        String r3 = r19.c;
        String r4 = r19.d;
        nr9.f r5 = r19.e;
        String r6 = r19.f;
        String r7 = r19.g;
        String r8 = r19.h;
        String r9 = r19.i;
        int r10 = r19.j;
        int r11 = r19.k;
        double r12 = r19.l;
        String r15 = r19.o;
        String r14 = r19.p;
        Intrinsics.checkNotNullParameter(r1, "engineKey");
        Intrinsics.checkNotNullParameter(r15, "tag");
        return new g(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r20, r21, r15, r14);
    }

    public /* synthetic */ g(String r22, String r23, String r24, String r25, nr9.f r26, String r27, String r28, String r29, String r30, int r31, int r32, double r33, Bitmap r35, String r36, String r37, int r38) {
        if ((r38 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r38 & 4) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r38 & 8) == 0) goto L13;
        String r7 = null;
    L15:
        if ((r38 & 16) == 0) goto L17;
        nr9.f r8 = null;
    L19:
        if ((r38 & 32) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r38 & 64) == 0) goto L25;
        String r10 = null;
    L27:
        if ((r38 & 128) == 0) goto L29;
        String r11 = null;
    L31:
        if ((r38 & 256) == 0) goto L33;
        String r12 = null;
    L35:
        if ((r38 & 512) == 0) goto L37;
        int r13 = 0;
    L39:
        if ((r38 & 1024) == 0) goto L41;
        int r14 = 0;
    L43:
        if ((r38 & 2048) == 0) goto L45;
        double r15 = 0.0d;
    L47:
        if ((r38 & 8192) == 0) goto L49;
        Bitmap r18 = null;
    L51:
        if ((r38 & 16384) == 0) goto L53;
        String r19 = "";
    L55:
        if ((r38 & 32768) == 0) goto L57;
        String r20 = null;
    L58:
        this(r22, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, 0, r18, r19, r20);
        return;
    L57:
        r20 = r37;
        goto L58
    L53:
        r19 = r36;
        goto L55
    L49:
        r18 = r35;
        goto L51
    L45:
        r15 = r33;
        goto L47
    L41:
        r14 = r32;
        goto L43
    L37:
        r13 = r31;
        goto L39
    L33:
        r12 = r30;
        goto L35
    L29:
        r11 = r29;
        goto L31
    L25:
        r10 = r28;
        goto L27
    L21:
        r9 = r27;
        goto L23
    L17:
        r8 = r26;
        goto L19
    L13:
        r7 = r25;
        goto L15
    L9:
        r6 = r24;
        goto L11
    L5:
        r5 = r23;
        goto L7
    }

    public g(String r6, String r7, String r8, String r9, nr9.f r10, String r11, String r12, String r13, String r14, int r15, int r16, double r17, int r19, Bitmap r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r6, "engineKey");
        Intrinsics.checkNotNullParameter(r21, "tag");
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r13;
        this.i = r14;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r19;
        this.n = r20;
        this.o = r21;
        this.p = r22;
    }
}
