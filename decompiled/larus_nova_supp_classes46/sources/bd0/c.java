package bd0;

import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final View a;
    public final View b;
    public final String c;
    public final boolean d;
    public final float e;
    public final float f;
    public final String g;
    public final boolean h;
    public final String i;
    public final Integer j;
    public final String k;
    public final Integer l;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L30;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Float.compare(this.e, r4.e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f, r4.f) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        View r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        View r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.d;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L17;
        r12 = 1;
    L17:
        int r13 = (((((r9 + r12) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31;
        String r14 = this.g;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.h;
        if (r17 == true) goto L25;
        r11 = r17;
    L25:
        int r18 = (r16 + r11) * 31;
        String r19 = this.i;
        if (r19 == null) goto L28;
        int r20 = r19.hashCode();
    L29:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.j;
        if (r22 == null) goto L32;
        int r23 = r22.hashCode();
    L33:
        int r24 = (r21 + r23) * 31;
        String r25 = this.k;
        if (r25 == null) goto L36;
        int r26 = r25.hashCode();
    L37:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.l;
        if (r28 == null) goto L41;
        r1 = r28.hashCode();
    L41:
        return r27 + r1;
    L36:
        r26 = 0;
        goto L37
    L32:
        r23 = 0;
        goto L33
    L28:
        r20 = 0;
        goto L29
    L20:
        r15 = 0;
        goto L21
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TakeOverInfo(takeOverView=" + this.a + ", takeOverBgView=" + this.b + ", uid=" + this.c + ", useCustomVector=" + this.d + ", customX=" + this.e + ", customY=" + this.f + ", avatarUrl=" + this.g + ", noAvatar=" + this.h + ", shape=" + this.i + ", radius=" + this.j + ", linkType=" + this.k + ", position=" + this.l + ")";
    }

    public c(View r12, HSImageView r13, String r14, boolean r15, float r16, float r17, String r18, boolean r19, String r20, Integer r21, String r22, Integer r23, int r24) {
        if ((r24 & 8) == 0) goto L5;
        boolean r2 = false;
    L6:
        float r5 = 0.0f;
        if ((r24 & 16) == 0) goto L9;
        float r4 = 0.0f;
    L11:
        if ((r24 & 32) != 0) goto L15;
        r5 = r17;
    L15:
        if ((r24 & 64) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r24 & 128) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r24 & 256) == 0) goto L25;
        String r8 = "circle";
    L27:
        if ((r24 & 512) == 0) goto L29;
        Integer r3 = 0;
    L31:
        if ((r24 & 1024) == 0) goto L33;
        String r9 = "";
    L35:
        if ((r24 & 2048) == 0) goto L37;
        Integer r1 = -1;
    L38:
        Intrinsics.checkNotNullParameter(r9, "linkType");
        this.a = r12;
        this.b = r13;
        this.c = r14;
        this.d = r2;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r3;
        this.k = r9;
        this.l = r1;
        return;
    L37:
        r1 = r23;
        goto L38
    L33:
        r9 = r22;
        goto L35
    L29:
        r3 = r21;
        goto L31
    L25:
        r8 = r20;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L9:
        r4 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L6
    }
}
