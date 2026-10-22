package js;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends f4.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f18453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f18454c;
    public final float d;

    public a(float r5, float r10, float r11) {
        this.f18453b = r5;
        this.f18454c = r10;
        this.d = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.f18453b), Float.valueOf(r10.f18453b)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(0.0f), Float.valueOf(0.0f)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.f18454c), Float.valueOf(r10.f18454c)) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(Float.valueOf(this.d), Float.valueOf(r10.d)) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.b(0.0f, Float.hashCode(this.f18453b) * 31, 31);
        int r10 = androidx.constraintlayout.motion.widget.a.b(this.f18454c, r5, 31);
        return Float.hashCode(this.d) + r10;
    }

    public final String toString() {
        return "CubicBezier(x1=" + this.f18453b + ", y1=0.0, x2=" + this.f18454c + ", y2=" + this.d + ')';
    }
}
