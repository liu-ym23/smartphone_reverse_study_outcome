package rc0;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final RectF a;
    public final boolean b;
    public final Integer c;
    public final boolean d;
    public final Matrix e;
    public final String f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L18;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
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
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        RectF r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        Integer r8 = this.c;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r11 = (r7 + r9) * 31;
        boolean r12 = this.d;
        if (r12 == true) goto L17;
        r5 = r12;
    L17:
        int r13 = (r11 + r5) * 31;
        Matrix r14 = this.e;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f;
        if (r17 == null) goto L25;
        r1 = r17.hashCode();
    L25:
        return r16 + r1;
    L20:
        r15 = 0;
        goto L21
    L12:
        r9 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ExtraStreamRenderData(contentInScreen=" + this.a + ", needBackGround=" + this.b + ", version=" + this.c + ", isPortrait=" + this.d + ", gridMatrix=" + this.e + ", seiRaw=" + this.f + ")";
    }

    public c(RectF r2, boolean r3, Integer r4, boolean r5, Matrix r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "gridMatrix");
        Intrinsics.checkNotNullParameter(r7, "seiRaw");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
