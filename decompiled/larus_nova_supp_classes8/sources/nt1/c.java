package nt1;

import com.bytedance.android.live.base.model.ImageModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public final int a;
    public final int b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final ImageModel g;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L20;
        c r4 = (c) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.d;
        ?? r6 = 1;
        ?? r7 = r5;
        if (r5 == false) goto L9;
        r7 = 1;
    L9:
        int r8 = (r4 + r7) * 31;
        boolean r9 = this.e;
        ?? r10 = r9;
        if (r9 == false) goto L12;
        r10 = 1;
    L12:
        int r11 = (r8 + r10) * 31;
        boolean r12 = this.f;
        if (r12 == true) goto L16;
        r6 = r12;
    L16:
        int r13 = (r11 + r6) * 31;
        ImageModel r14 = this.g;
        if (r14 == null) goto L20;
        r2 = r14.hashCode();
    L20:
        return r13 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "OptionDescVO(imageResId=" + this.a + ", textResId=" + this.b + ", textStr=" + this.c + ", showDot=" + this.d + ", isEmpty=" + this.e + ", forceShowDot=" + this.f + ", imageModel=" + this.g + ")";
    }

    public final boolean a(c r5) {
        Intrinsics.checkNotNullParameter(r5, "vo");
        if (r5.a == this.a) goto L5;
    L16:
        boolean r0 = true;
    L17:
        if (r0 == true) goto L20;
        r5 = null;
    L20:
        if (r5 == null) goto L22;
        return false;
    L22:
        return true;
    L5:
        if (r5.b != this.b) goto L16;
        if ((!Intrinsics.areEqual(r5.c, this.c)) == true) goto L16;
        if (r5.d != this.d) goto L16;
        if (r5.e != this.e) goto L16;
        if (r5.f != this.f) goto L16;
        r0 = false;
        goto L17
    }

    public c(int r3, int r4, String r5, boolean r6, boolean r7, boolean r8, ImageModel r9, int r10) {
        if ((r10 & 4) == 0) goto L6;
        r5 = "";
    L6:
        if ((r10 & 8) == 0) goto L9;
        r6 = false;
    L9:
        if ((r10 & 16) == 0) goto L12;
        r7 = false;
    L12:
        if ((r10 & 32) == 0) goto L15;
        r8 = false;
    L15:
        if ((r10 & 64) == 0) goto L17;
        r9 = null;
    L17:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
