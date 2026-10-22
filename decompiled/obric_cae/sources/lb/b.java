package lb;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f9189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f9190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f9191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f9192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f9193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f9194f;

    public b(float r8, float r10, float r11, float r12, float r13, float r14) {
        this.f9189a = r8;
        this.f9190b = r10;
        this.f9191c = r11;
        this.f9192d = r12;
        this.f9193e = r13;
        this.f9194f = r14;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L4;
        return true;
    L4:
        if ((r8 instanceof b) == false) goto L18;
        b r10 = (b) r8;
        float r11 = r10.f9189a;
        if (Float.compare(this.f9189a, r11) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f9190b, r10.f9190b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f9191c, r10.f9191c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f9192d, r10.f9192d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f9193e, r10.f9193e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f9194f, r10.f9194f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r8 = Float.hashCode(this.f9189a) * 31;
        int r10 = (Float.hashCode(this.f9190b) + r8) * 31;
        int r11 = (Float.hashCode(this.f9191c) + r10) * 31;
        int r12 = (Float.hashCode(this.f9192d) + r11) * 31;
        int r13 = (Float.hashCode(this.f9193e) + r12) * 31;
        return Float.hashCode(this.f9194f) + r13;
    }

    public final String toString() {
        return "ControlPoint(handleLarge=" + this.f9189a + ", distanceOuter=" + this.f9190b + ", distanceInner=" + this.f9191c + ", handleMedium=" + this.f9192d + ", curveInner=" + this.f9193e + ", curveOuter=" + this.f9194f + ")";
    }
}
