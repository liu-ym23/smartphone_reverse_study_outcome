package com.obric.oui.indicator;

import ai.j0;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f13485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f13486c;
    public final int[] d;
    public final int e;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f13487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f13488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f13489j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f13490k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f13491l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f13492m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f13493n;

    public j(float r5, float r10, float r11, int[] r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r12, "styleableId");
        this.f13484a = r5;
        this.f13485b = r10;
        this.f13486c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f13487h = r16;
        this.f13488i = r17;
        this.f13489j = r18;
        this.f13490k = r19;
        this.f13491l = r110;
        this.f13492m = r111;
        this.f13493n = r112;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r10 = (j) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.f13484a), Float.valueOf(r10.f13484a)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.f13485b), Float.valueOf(r10.f13485b)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.f13486c), Float.valueOf(r10.f13486c)) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.f13487h == r10.f13487h) goto L33;
        return false;
    L33:
        if (this.f13488i == r10.f13488i) goto L36;
        return false;
    L36:
        if (this.f13489j == r10.f13489j) goto L39;
        return false;
    L39:
        if (this.f13490k == r10.f13490k) goto L42;
        return false;
    L42:
        if (this.f13491l == r10.f13491l) goto L45;
        return false;
    L45:
        if (this.f13492m == r10.f13492m) goto L48;
        return false;
    L48:
        if (this.f13493n == r10.f13493n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r5 = Float.hashCode(this.f13484a) * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.b(this.f13485b, r5, 31);
        int r11 = androidx.constraintlayout.motion.widget.a.b(this.f13486c, r10, 31);
        int r12 = (Arrays.hashCode(this.d) + r11) * 31;
        int r13 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.e, r12, 31);
        int r14 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f, r13, 31);
        int r15 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.g, r14, 31);
        int r16 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f13487h, r15, 31);
        int r17 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f13488i, r16, 31);
        int r18 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f13489j, r17, 31);
        int r19 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f13490k, r18, 31);
        int r20 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f13491l, r19, 31);
        int r21 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f13492m, r20, 31);
        return Integer.hashCode(this.f13493n) + r21;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("CustomDot(defaultWidth=");
        r5.append(this.f13484a);
        r5.append(", defaultHeight=");
        r5.append(this.f13485b);
        r5.append(", defaultSpacing=");
        r5.append(this.f13486c);
        r5.append(", styleableId=");
        r5.append(Arrays.toString(this.d));
        r5.append(", typeId=");
        r5.append(this.e);
        r5.append(", layoutHeightId=");
        r5.append(this.f);
        r5.append(", dotsWidthId=");
        r5.append(this.g);
        r5.append(", dotsHeightId=");
        r5.append(this.f13487h);
        r5.append(", dotsSpacingId=");
        r5.append(this.f13488i);
        r5.append(", dotsColorId=");
        r5.append(this.f13489j);
        r5.append(", dotsCornerRadiusId=");
        r5.append(this.f13490k);
        r5.append(", dotsClickableId=");
        r5.append(this.f13491l);
        r5.append(", dotsStrokeColorId=");
        r5.append(this.f13492m);
        r5.append(", dotsStrokeWidthId=");
        return j0.n(r5, this.f13493n, ')');
    }
}
