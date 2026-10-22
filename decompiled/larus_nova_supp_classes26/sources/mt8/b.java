package mt8;

import com.larus.im.bean.message.Image;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final Image a;
    public final float b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        Image r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((r2 * 31) + Float.floatToIntBits(this.b)) * 31) + this.c) * 31) + this.d) * 31;
        String r4 = this.e;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.h;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.i;
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
        return "VideoMeta(coverImage=" + this.a + ", duration=" + this.b + ", width=" + this.c + ", height=" + this.d + ", localFilePath=" + this.e + ", vid=" + this.f + ", resourceId=" + this.g + ", videoModel=" + this.h + ", downloadUrl=" + this.i + ')';
    }

    public b(Image r1, float r2, int r3, int r4, String r5, String r6, String r7, String r8, String r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public /* synthetic */ b(Image r14, float r15, int r16, int r17, String r18, String r19, String r20, String r21, String r22, int r23) {
        if ((r23 & 4) == 0) goto L5;
        int r6 = 0;
    L7:
        if ((r23 & 8) == 0) goto L9;
        int r7 = 0;
    L11:
        if ((r23 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r23 & 32) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r23 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r23 & 128) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r23 & 256) == 0) goto L29;
        String r12 = null;
    L30:
        this(r14, r15, r6, r7, r8, r9, r10, r11, r12);
        return;
    L29:
        r12 = r22;
        goto L30
    L25:
        r11 = r21;
        goto L27
    L21:
        r10 = r20;
        goto L23
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public static b a(b r10, Image r11, float r12, int r13, int r14, String r15, String r16, String r17, String r18, String r19, int r20) {
        if ((r20 & 1) == 0) goto L5;
        Image r2 = r10.a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        float r3 = r10.b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r4 = r10.c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        int r5 = r10.d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.f;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.g;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = r10.h;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r0 = r10.i;
    L39:
        return new b(r2, r3, r4, r5, r6, r7, r8, r9, r0);
    L37:
        r0 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }
}
