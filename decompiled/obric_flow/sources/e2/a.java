package e2;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f16741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f16742b;

    public a(double r5, double r10) {
        this.f16741a = r5;
        this.f16742b = r10;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        double r5 = r11.f16741a;
        if (Double.compare(this.f16741a, r5) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f16742b, r11.f16742b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Double.hashCode(this.f16741a) * 31;
        return Double.hashCode(this.f16742b) + r5;
    }

    public final String toString() {
        return "AILatLng(lat=" + this.f16741a + ", lng=" + this.f16742b + ')';
    }
}
