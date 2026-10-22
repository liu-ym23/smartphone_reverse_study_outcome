package gr;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends e {
    public final double e;
    public final double f;
    public final double g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f17142h;

    public d(String r10) {
        super(0);
        this.f17145b = r10;
        int r5 = r10.indexOf(40);
        int r11 = r10.indexOf(44, r5);
        this.e = Double.parseDouble(r10.substring(r5 + 1, r11).trim());
        int r12 = r11 + 1;
        int r13 = r10.indexOf(44, r12);
        this.f = Double.parseDouble(r10.substring(r12, r13).trim());
        int r14 = r13 + 1;
        int r15 = r10.indexOf(44, r14);
        this.g = Double.parseDouble(r10.substring(r14, r15).trim());
        int r16 = r15 + 1;
        this.f17142h = Double.parseDouble(r10.substring(r16, r10.indexOf(41, r16)).trim());
    }

    @Override // gr.e
    public final double a(double r10) {
        if (r10 > 0.0d) goto L6;
        return 0.0d;
    L6:
        if (r10 < 1.0d) goto L8;
        return 1.0d;
    L8:
        double r5 = 0.5d;
        double r11 = 0.5d;
    L10:
        if (r5 <= 0.01d) goto L15;
        r5 = r5 * 0.5d;
        if (e(r11) < r10) goto L13;
        r11 = r11 - r5;
        goto L10
    L13:
        r11 = r11 + r5;
        goto L10
    L15:
        double r12 = r11 - r5;
        double r13 = e(r12);
        double r14 = r11 + r5;
        double r15 = e(r14);
        double r16 = f(r12);
        return (((r10 - r13) * (f(r14) - r16)) / (r15 - r13)) + r16;
    }

    @Override // gr.e
    public final double b(double r10) {
        double r5 = 0.5d;
        double r11 = 0.5d;
    L4:
        if (r5 <= 1.0E-4d) goto L9;
        r5 = r5 * 0.5d;
        if (e(r11) < r10) goto L7;
        r11 = r11 - r5;
        goto L4
    L7:
        r11 = r11 + r5;
        goto L4
    L9:
        double r12 = r11 - r5;
        double r13 = e(r12);
        double r14 = r11 + r5;
        double r15 = e(r14);
        return (f(r14) - f(r12)) / (r15 - r13);
    }

    public final double e(double r10) {
        double r5 = 1.0d - r10;
        double r11 = 3.0d * r5;
        double r12 = (r5 * r11) * r10;
        double r13 = (r11 * r10) * r10;
        double r14 = (r10 * r10) * r10;
        double r15 = this.e * r12;
        return ((this.g * r13) + r15) + r14;
    }

    public final double f(double r10) {
        double r5 = 1.0d - r10;
        double r11 = 3.0d * r5;
        double r12 = (r5 * r11) * r10;
        double r13 = (r11 * r10) * r10;
        double r14 = (r10 * r10) * r10;
        double r15 = this.f * r12;
        return ((this.f17142h * r13) + r15) + r14;
    }
}
