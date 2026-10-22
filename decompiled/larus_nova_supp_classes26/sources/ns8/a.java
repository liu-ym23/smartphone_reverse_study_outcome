package ns8;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Integer a;
    public final Integer b;
    public final Integer c;
    public final Bitmap.CompressFormat d;
    public final boolean e;
    public final Integer f;
    public final Bitmap.CompressFormat g;
    public final int h;

    public a() {
        this(null, null, null, null, false, 255);
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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Bitmap.CompressFormat r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.e == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (r12 + r13) * 31;
        Integer r15 = this.f;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        Bitmap.CompressFormat r18 = this.g;
        if (r18 == null) goto L31;
        r1 = r18.hashCode();
    L31:
        return ((r17 + r1) * 31) + this.h;
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = 1237;
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
        return "CompressConfig(optShortSize=" + this.a + ", optLongSize=" + this.b + ", optQuality=" + this.c + ", compressFormat=" + this.d + ", keepExif=" + this.e + ", compressQualityWithAlpha=" + this.f + ", compressFormatWithAlpha=" + this.g + ", minSizeToCompress=" + this.h + ')';
    }

    public static a a(a r11, Bitmap.CompressFormat r12, Bitmap.CompressFormat r13, int r14, int r15) {
        Integer r1 = null;
        if ((r15 & 1) == 0) goto L5;
        Integer r3 = r11.a;
    L7:
        if ((r15 & 2) == 0) goto L9;
        Integer r4 = r11.b;
    L11:
        if ((r15 & 4) == 0) goto L13;
        Integer r5 = r11.c;
    L15:
        if ((r15 & 8) == 0) goto L17;
        r12 = r11.d;
    L17:
        Bitmap.CompressFormat r6 = r12;
        if ((r15 & 16) == 0) goto L20;
        boolean r7 = r11.e;
    L22:
        if ((r15 & 32) == 0) goto L24;
        r1 = r11.f;
    L24:
        Integer r8 = r1;
        if ((r15 & 64) == 0) goto L27;
        r13 = r11.g;
    L27:
        Bitmap.CompressFormat r9 = r13;
        if ((r15 & 128) == 0) goto L31;
        r14 = r11.h;
    L31:
        return new a(r3, r4, r5, r6, r7, r8, r9, r14);
    L20:
        r7 = false;
        goto L22
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public /* synthetic */ a(Integer r12, Integer r13, Integer r14, Bitmap.CompressFormat r15, boolean r16, int r17) {
        Bitmap.CompressFormat r1 = null;
        if ((r17 & 1) == 0) goto L5;
        Integer r3 = null;
    L7:
        if ((r17 & 2) == 0) goto L9;
        Integer r4 = null;
    L11:
        if ((r17 & 4) == 0) goto L13;
        Integer r5 = null;
    L15:
        if ((r17 & 8) == 0) goto L17;
        Bitmap.CompressFormat r6 = Bitmap.CompressFormat.JPEG;
    L19:
        if ((r17 & 16) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r17 & 64) == 0) goto L25;
        r1 = Bitmap.CompressFormat.JPEG;
    L25:
        this(r3, r4, r5, r6, r7, null, r1, 0);
        return;
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    public a(Integer r1, Integer r2, Integer r3, Bitmap.CompressFormat r4, boolean r5, Integer r6, Bitmap.CompressFormat r7, int r8) {
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
