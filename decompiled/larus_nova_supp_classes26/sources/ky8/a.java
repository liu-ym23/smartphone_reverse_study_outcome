package ky8;

import com.larus.platform.api.creation.UserCreationFromIM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String a;
    public final Long b;
    public final String c;
    public final Long d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final Integer i;
    public final Integer j;
    public final int k;
    public final String l;
    public final Long m;
    public final String n;
    public final UserCreationFromIM o;
    public final String p;

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
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
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
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Long r1 = this.b;
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
        Long r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((((r10 + r12) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        String r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.i;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.j;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (((r19 + r21) * 31) + this.k) * 31;
        String r23 = this.l;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        Long r26 = this.m;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.n;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        UserCreationFromIM r32 = this.o;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        String r35 = this.p;
        if (r35 == null) goto L51;
        r2 = r35.hashCode();
    L51:
        return r34 + r2;
    L45:
        r33 = r32.hashCode();
        goto L46
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
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
        return "CanvasGalleryDataItem(localId=" + this.a + ", canvasId=" + this.b + ", taskId=" + this.c + ", canvasSubId=" + this.d + ", canvasSubReplyId=" + this.e + ", downloadUrl=" + this.f + ", previewUrl=" + this.g + ", thumbUrl=" + this.h + ", width=" + this.i + ", height=" + this.j + ", position=" + this.k + ", imageEditFunctionId=" + this.l + ", createTime=" + this.m + ", prompt=" + this.n + ", creation=" + this.o + ", messageId=" + this.p + ')';
    }

    public a(String r6, Long r7, String r8, Long r9, String r10, String r11, String r12, String r13, Integer r14, Integer r15, int r16, String r17, Long r18, String r19, UserCreationFromIM r20, String r21) {
        Intrinsics.checkNotNullParameter(r6, "localId");
        Intrinsics.checkNotNullParameter(r11, "downloadUrl");
        Intrinsics.checkNotNullParameter(r12, "previewUrl");
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
        this.m = r18;
        this.n = r19;
        this.o = r20;
        this.p = r21;
    }
}
