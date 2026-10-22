package ib8;

import com.larus.bmhome.block.newheader.foldcontainer.HeadTitleLoadingTarget;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w0 {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final List<String> d;
    public final String e;
    public final float f;
    public final boolean g;
    public final boolean h;
    public final HeadTitleLoadingTarget i;

    public w0() {
        this(false, false, null, null, null, 0.0f, false, false, 511);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w0) == true) goto L8;
        return false;
    L8:
        w0 r6 = (w0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (Float.compare(this.f, r6.f) == 0) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        String r5 = this.c;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r4 + r7) * 31;
        List<String> r9 = this.d;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        String r12 = this.e;
        if (r12 == null) goto L22;
        r6 = r12.hashCode();
    L22:
        int r13 = (((r11 + r6) * 31) + Float.floatToIntBits(this.f)) * 31;
        if (this.g == false) goto L25;
        int r14 = 1231;
    L26:
        int r15 = (r13 + r14) * 31;
        if (this.h == true) goto L31;
        r1 = 1237;
    L31:
        return ((r15 + r1) * 31) + this.i.hashCode();
    L25:
        r14 = 1237;
        goto L26
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r5.hashCode();
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "HeadTitleInfo(headNeedTopMargin=" + this.a + ", startShimmerAnimation=" + this.b + ", headTitle=" + this.c + ", headTitleList=" + this.d + ", headIcon=" + this.e + ", arrowRotation=" + this.f + ", arrowVisible=" + this.g + ", showLoadingIndicator=" + this.h + ", loadingTarget=" + this.i + ')';
    }

    public static w0 a(w0 r12, HeadTitleLoadingTarget r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        boolean r3 = r12.a;
    L7:
        if ((r14 & 2) == 0) goto L9;
        boolean r4 = r12.b;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r5 = r12.c;
    L15:
        if ((r14 & 8) == 0) goto L17;
        List<String> r6 = r12.d;
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r7 = r12.e;
    L23:
        if ((r14 & 32) == 0) goto L25;
        float r8 = r12.f;
    L27:
        if ((r14 & 64) == 0) goto L29;
        boolean r9 = r12.g;
    L31:
        if ((r14 & 128) == 0) goto L33;
        boolean r10 = r12.h;
    L35:
        if ((r14 & 256) == 0) goto L37;
        r13 = r12.i;
    L37:
        HeadTitleLoadingTarget r11 = r13;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "loadingTarget");
        return new w0(r3, r4, r5, r6, r7, r8, r9, r10, r11);
    L33:
        r10 = false;
        goto L35
    L29:
        r9 = false;
        goto L31
    L25:
        r8 = 0.0f;
        goto L27
    L21:
        r7 = null;
        goto L23
    L17:
        r6 = null;
        goto L19
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = false;
        goto L11
    L5:
        r3 = false;
        goto L7
    }

    public /* synthetic */ w0(boolean r14, boolean r15, String r16, List r17, String r18, float r19, boolean r20, boolean r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r22 & 2) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        List r7 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        float r9 = 0.0f;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r10 = true;
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r11 = false;
    L35:
        if ((r22 & 256) == 0) goto L37;
        HeadTitleLoadingTarget r12 = HeadTitleLoadingTarget.CONTAINER;
    L38:
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12);
        return;
    L37:
        r12 = null;
        goto L38
    L33:
        r11 = r21;
        goto L35
    L29:
        r10 = r20;
        goto L31
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    public w0(boolean r2, boolean r3, String r4, List<String> r5, String r6, float r7, boolean r8, boolean r9, HeadTitleLoadingTarget r10) {
        Intrinsics.checkNotNullParameter(r10, "loadingTarget");
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
}
