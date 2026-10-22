package qp;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f21555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f21556b;

    public d(float r5, float r10) {
        this.f21555a = r5;
        this.f21556b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof d) == false) goto L10;
        d r10 = (d) r5;
        float r11 = r10.f21555a;
        if (Float.compare(this.f21555a, r11) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f21556b, r10.f21556b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r5 = Float.hashCode(this.f21555a) * 31;
        return Float.hashCode(this.f21556b) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Point(x=");
        r5.append(this.f21555a);
        r5.append(", y=");
        return androidx.constraintlayout.motion.widget.a.r(r5, this.f21556b, ")");
    }
}
