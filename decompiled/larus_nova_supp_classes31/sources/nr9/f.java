package nr9;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public final String a;
    public final String b;
    public final String c;
    public final Integer d;
    public final Integer e;
    public transient Bitmap f;

    public f() {
        this(null, null, null, null, null, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Bitmap r16 = this.f;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoPlayCover(thumbUrl=" + this.a + ", url=" + this.b + ", localPath=" + this.c + ", height=" + this.d + ", width=" + this.e + ", bitmap=" + this.f + ')';
    }

    public f(String r1, String r2, String r3, Integer r4, Integer r5, Bitmap r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public /* synthetic */ f(String r7, String r8, String r9, Integer r10, Integer r11, Bitmap r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        r10 = 0;
    L17:
        Integer r4 = r10;
        if ((r13 & 16) == 0) goto L20;
        r11 = 0;
    L20:
        Integer r5 = r11;
        if ((r13 & 32) == 0) goto L23;
        Bitmap r14 = null;
    L24:
        this(r0, r2, r3, r4, r5, r14);
        return;
    L23:
        r14 = r12;
        goto L24
    L13:
        r3 = r9;
        goto L15
    L9:
        r2 = r8;
        goto L11
    L5:
        r0 = r7;
        goto L7
    }

    public static f a(f r7, String r8, String r9, Integer r10, Integer r11, Bitmap r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        String r1 = r8;
        if ((r13 & 2) == 0) goto L8;
        r9 = r7.b;
    L8:
        String r2 = r9;
        if ((r13 & 4) == 0) goto L11;
        String r14 = r7.c;
    L12:
        String r3 = r14;
        if ((r13 & 8) == 0) goto L15;
        r10 = r7.d;
    L15:
        Integer r4 = r10;
        if ((r13 & 16) == 0) goto L18;
        r11 = r7.e;
    L18:
        Integer r5 = r11;
        if ((r13 & 32) == 0) goto L21;
        r12 = r7.f;
    L21:
        r7.getClass();
        return new f(r1, r2, r3, r4, r5, r12);
    L11:
        r14 = null;
        goto L12
    }
}
