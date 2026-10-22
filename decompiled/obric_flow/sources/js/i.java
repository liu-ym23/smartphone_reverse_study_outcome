package js;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends f8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f8.b f18467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f8.b f18468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f18469c;

    public i(f8.b r5, f8.b r10, float r11) {
        Intrinsics.checkNotNullParameter(r5, "from");
        Intrinsics.checkNotNullParameter(r10, "to");
        this.f18467a = r5;
        this.f18468b = r10;
        this.f18469c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r10 = (i) r5;
        f8.b r11 = r10.f18467a;
        if (Intrinsics.areEqual(this.f18467a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18468b, r10.f18468b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.f18469c), Float.valueOf(r10.f18469c)) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f18467a.hashCode() * 31;
        int r10 = (this.f18468b.hashCode() + r5) * 31;
        return Float.hashCode(this.f18469c) + r10;
    }

    public final String toString() {
        return "InterpolatedDimension(from=" + this.f18467a + ", to=" + this.f18468b + ", progress=" + this.f18469c + ')';
    }
}
