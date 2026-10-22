package gr;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends e {
    public double e;
    public double f;

    @Override // gr.e
    public final double a(double r12) {
        double r5 = this.f;
        double r10 = this.e;
        if (r12 < r5) goto L7;
        double r11 = r12 - 1.0d;
        return (r11 * (1.0d - r5)) / ((1.0d - r12) - ((r5 - r12) * r10));
    L7:
        return (r5 * r12) / (((r5 - r12) * r10) + r12);
    }

    @Override // gr.e
    public final double b(double r12) {
        double r5 = this.f;
        double r10 = this.e;
        if (r12 >= r5) goto L5;
        double r11 = (r10 * r5) * r5;
        double r13 = ((r5 - r12) * r10) + r12;
        return r11 / (r13 * r13);
    L5:
        double r14 = r5 - 1.0d;
        double r15 = r5 - r12;
        double r16 = ((r15 * (-r10)) - r12) + 1.0d;
        return ((r14 * r10) * r14) / (r16 * r16);
    }
}
