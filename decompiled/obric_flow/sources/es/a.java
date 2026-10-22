package es;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f16858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f16859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f16860c;
    public final int d;
    public final float e;
    public int f;

    public a(int r5, int r10, float r11, float r12, float r13, float r14) {
        this.f16858a = r11;
        this.f16859b = r12;
        this.f16860c = r13;
        this.d = r5;
        this.e = r14;
        this.f = r10;
    }

    public final b a() {
        float r10 = this.e;
        int r5 = this.f;
        float r11 = this.f16858a;
        float r12 = this.f16859b;
        float r13 = this.f16860c;
        return new b(this.d, r5, r11, r12, r13, r10);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.f16858a), Float.valueOf(r10.f16858a)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.f16859b), Float.valueOf(r10.f16859b)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.f16860c), Float.valueOf(r10.f16860c)) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.e), Float.valueOf(r10.e)) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r5 = Float.hashCode(this.f16858a) * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.b(this.f16859b, r5, 31);
        int r11 = androidx.constraintlayout.motion.widget.a.b(this.f16860c, r10, 31);
        int r12 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.d, r11, 31);
        int r13 = androidx.constraintlayout.motion.widget.a.b(this.e, r12, 31);
        return Integer.hashCode(this.f) + r13;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ShadowConfig(x=");
        r5.append(this.f16858a);
        r5.append(", y=");
        r5.append(this.f16859b);
        r5.append(", blurRadius=");
        r5.append(this.f16860c);
        r5.append(", color=");
        r5.append(this.d);
        r5.append(", spread=");
        r5.append(this.e);
        r5.append(", blendMode=");
        return j0.n(r5, this.f, ')');
    }
}
