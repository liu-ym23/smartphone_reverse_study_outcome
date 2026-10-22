package com.bytedance.android.live.revlink.link.core.service;

import android.graphics.Matrix;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public final Map<String, n> a;
    public final List<n> b;
    public final n c;
    public final t51.c d;
    public final int e;
    public final o51.e f;
    public final Matrix g;
    public final g h;
    public final Integer i;
    public final Integer j;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p) == false) goto L26;
        p r4 = (p) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        Map<String, n> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<n> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        n r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        t51.c r10 = this.d;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (((r9 + r12) * 31) + this.e) * 31;
        o51.e r14 = this.f;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        Matrix r17 = this.g;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        g r20 = this.h;
        if (r20 == null) goto L29;
        int r22 = r20.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        Integer r24 = this.i;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        Integer r27 = this.j;
        if (r27 == null) goto L38;
        r1 = r27.hashCode();
    L38:
        return r26 + r1;
    L33:
        r25 = 0;
        goto L34
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
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
        return "LayoutFrame(layoutConfigFrames=" + this.a + ", audienceConfigFrames=" + this.b + ", gameConfigFrame=" + this.c + ", canvasTransform=" + this.d + ", count=" + this.e + ", uiLayout=" + this.f + ", gridMatrix=" + this.g + ", containerMargin=" + this.h + ", realContainerHeight=" + this.i + ", realContainerWidth=" + this.j + ")";
    }

    public p(Map<String, n> r2, List<n> r3, n r4, t51.c r5, int r6, o51.e r7, Matrix r8, g r9, Integer r10, Integer r12) {
        Intrinsics.checkNotNullParameter(r2, "layoutConfigFrames");
        Intrinsics.checkNotNullParameter(r3, "audienceConfigFrames");
        Intrinsics.checkNotNullParameter(r5, "canvasTransform");
        Intrinsics.checkNotNullParameter(r7, "uiLayout");
        Intrinsics.checkNotNullParameter(r8, "gridMatrix");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r12;
    }
}
