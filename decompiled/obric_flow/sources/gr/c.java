package gr;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends qo.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f17140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double[] f17141b;

    @Override // qo.a
    public final double[] A() {
        return new double[]{this.f17140a};
    }

    @Override // qo.a
    public final double v(double r5) {
        return this.f17141b[0];
    }

    @Override // qo.a
    public final void w(double r5, double[] r10) {
        double[] r11 = this.f17141b;
        System.arraycopy(r11, 0, r10, 0, r11.length);
    }

    @Override // qo.a
    public final void x(double r5, float[] r10) {
        int r11 = 0;
    L3:
        double[] r12 = this.f17141b;
        if (r11 >= r12.length) goto L6;
        r10[r11] = (float) r12[r11];
        r11 = r11 + 1;
        goto L3
    }

    @Override // qo.a
    public final double y(double r5) {
        return 0.0d;
    }

    @Override // qo.a
    public final void z(double r5, double[] r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f17141b.length) goto L6;
        r10[r11] = 0.0d;
        r11 = r11 + 1;
        goto L4
    }
}
