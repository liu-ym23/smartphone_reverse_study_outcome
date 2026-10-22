package mr9;

import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l {
    public final String a;
    public final String b;
    public final String c;
    public final d d;
    public final n e;
    public final boolean f;
    public final ResourceUploadInstantInfo g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
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
        d r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        n r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.f == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        ResourceUploadInstantInfo r18 = this.g;
        if (r18 == null) goto L31;
        r1 = r18.hashCode();
    L31:
        return r17 + r1;
    L25:
        r16 = 1237;
        goto L26
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
        return "ResourceUploadResult(tosKey=" + this.a + ", aliasName=" + this.b + ", resourceId=" + this.c + ", imageResult=" + this.d + ", videoResult=" + this.e + ", isInstantUploadHit=" + this.f + ", instantUploadInfo=" + this.g + ')';
    }

    public static l a(l r8, String r9, String r10, String r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r9 = r8.a;
    L5:
        String r1 = r9;
        if ((r12 & 2) == 0) goto L8;
        r10 = r8.b;
    L8:
        String r2 = r10;
        if ((r12 & 4) == 0) goto L11;
        r11 = r8.c;
    L11:
        String r3 = r11;
        if ((r12 & 8) == 0) goto L14;
        d r4 = r8.d;
    L16:
        if ((r12 & 16) == 0) goto L18;
        n r5 = r8.e;
    L20:
        if ((r12 & 32) == 0) goto L22;
        boolean r6 = r8.f;
    L24:
        if ((r12 & 64) == 0) goto L26;
        ResourceUploadInstantInfo r7 = r8.g;
    L27:
        r8.getClass();
        return new l(r1, r2, r3, r4, r5, r6, r7);
    L26:
        r7 = null;
        goto L27
    L22:
        r6 = false;
        goto L24
    L18:
        r5 = null;
        goto L20
    L14:
        r4 = null;
        goto L16
    }

    public l(String r1, String r2, String r3, d r4, n r5, boolean r6, ResourceUploadInstantInfo r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public /* synthetic */ l(String r11, String r12, String r13, d r14, n r15, boolean r16, ResourceUploadInstantInfo r17, int r18) {
        if ((r18 & 2) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r18 & 4) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r18 & 8) == 0) goto L13;
        d r6 = null;
    L15:
        if ((r18 & 16) == 0) goto L17;
        n r7 = null;
    L19:
        if ((r18 & 32) == 0) goto L21;
        boolean r8 = false;
    L23:
        if ((r18 & 64) == 0) goto L25;
        ResourceUploadInstantInfo r9 = null;
    L26:
        this(r11, r4, r5, r6, r7, r8, r9);
        return;
    L25:
        r9 = r17;
        goto L26
    L21:
        r8 = r16;
        goto L23
    L17:
        r7 = r15;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }
}
