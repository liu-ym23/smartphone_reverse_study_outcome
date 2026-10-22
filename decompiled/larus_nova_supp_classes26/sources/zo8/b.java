package zo8;

import com.larus.bmhome.bigimg.n1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements a {
    public final n1 a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final boolean f;
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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
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
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        int r8 = 1231;
        if (this.e == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.f == true) goto L18;
        r8 = 1237;
    L18:
        int r11 = (r10 + r8) * 31;
        String r12 = this.g;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.h;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        String r18 = this.i;
        if (r18 == null) goto L31;
        r2 = r18.hashCode();
    L31:
        return r17 + r2;
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L13:
        r9 = 1237;
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageContent(imageUrl=" + this.a + ", thumbImageUrl=" + this.b + ", creationIndex=" + this.c + ", creationTaskId=" + this.d + ", canPublish=" + this.e + ", isBlockContent=" + this.f + ", canvasId=" + this.g + ", canvasSubId=" + this.h + ", imageResourceKey=" + this.i + ')';
    }

    @Override // zo8.a
    public final String a() {
        return this.d;
    }

    @Override // zo8.a
    public final String b() {
        return this.c;
    }

    public b(n1 r2, String r3, String r4, String r5, boolean r6, boolean r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "imageUrl");
        Intrinsics.checkNotNullParameter(r3, "thumbImageUrl");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public /* synthetic */ b(n1 r14, String r15, String r16, String r17, boolean r18, boolean r19, String r20, String r21, String r22, int r23) {
        if ((r23 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r23 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r23 & 16) == 0) goto L13;
        boolean r8 = true;
    L15:
        if ((r23 & 32) == 0) goto L17;
        boolean r9 = false;
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
}
