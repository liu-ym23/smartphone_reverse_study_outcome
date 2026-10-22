package gb;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f7786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f7787b;

    public a(double r8, double r10) {
        this.f7786a = r8;
        this.f7787b = r10;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L4;
        return true;
    L4:
        if ((r8 instanceof a) == false) goto L10;
        a r10 = (a) r8;
        if (Double.compare(this.f7786a, r10.f7786a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.f7787b, r10.f7787b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r8 = Double.hashCode(this.f7786a) * 31;
        return Double.hashCode(this.f7787b) + r8;
    }

    public final String toString() {
        return "ComplexDouble(_real=" + this.f7786a + ", _imaginary=" + this.f7787b + ")";
    }
}
