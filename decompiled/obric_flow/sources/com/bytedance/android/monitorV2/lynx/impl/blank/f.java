package com.bytedance.android.monitorV2.lynx.impl.blank;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f3672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3674c;
    public final int d;
    public final int e;
    public final int f;
    public final Map g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f3675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f3676i;

    public f(float r5, float r10, String r11, int r12, int r13, int r14, Map r15, Map r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r11, "blankBitmap");
        Intrinsics.checkNotNullParameter(r15, "elements");
        Intrinsics.checkNotNullParameter(r16, "validElements");
        this.f3672a = r5;
        this.f3673b = r10;
        this.f3674c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f3675h = r16;
        this.f3676i = r17;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r10 = (f) r5;
        float r11 = r10.f3672a;
        if (Float.compare(this.f3672a, r11) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f3673b, r10.f3673b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f3674c, r10.f3674c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f3675h, r10.f3675h) == true) goto L33;
        return false;
    L33:
        if (this.f3676i == r10.f3676i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r5 = Float.hashCode(this.f3672a) * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.b(this.f3673b, r5, 31);
        int r11 = kk.a.b(this.f3674c, r10, 31);
        int r12 = k5.d.a(this.d, r11);
        int r13 = k5.d.a(this.e, r12);
        int r14 = k5.d.a(this.f, r13);
        int r15 = (this.g.hashCode() + r14) * 31;
        int r16 = (this.f3675h.hashCode() + r15) * 31;
        return Boolean.hashCode(this.f3676i) + r16;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("CheckResult(effectiveAreaRatio=");
        r5.append(this.f3672a);
        r5.append(", maxBlankAreaRatio=");
        r5.append(this.f3673b);
        r5.append(", blankBitmap=");
        r5.append(this.f3674c);
        r5.append(", blankBitmapWidth=");
        r5.append(this.d);
        r5.append(", blankBitmapHeight=");
        r5.append(this.e);
        r5.append(", validViewCount=");
        r5.append(this.f);
        r5.append(", elements=");
        r5.append(this.g);
        r5.append(", validElements=");
        r5.append(this.f3675h);
        r5.append(", validChildNode=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.f3676i, ')');
    }
}
