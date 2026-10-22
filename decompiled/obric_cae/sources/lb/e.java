package lb;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f9198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f9199b;

    public e(float r8, float r10) {
        this.f9198a = r8;
        this.f9199b = r10;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L4;
        return true;
    L4:
        if ((r8 instanceof e) == false) goto L10;
        e r10 = (e) r8;
        float r11 = r10.f9198a;
        if (Float.compare(this.f9198a, r11) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f9199b, r10.f9199b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r8 = Float.hashCode(this.f9198a) * 31;
        return Float.hashCode(this.f9199b) + r8;
    }

    public final String toString() {
        return "Point(x=" + this.f9198a + ", y=" + this.f9199b + ")";
    }
}
