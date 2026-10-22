package m2;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f11020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f11022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11023d;

    public c(double r10) {
        this.f11022c = -1.0d;
        this.f11020a = r10;
        if (r10 != 0.0d) goto L5;
        int r11 = Integer.MAX_VALUE;
    L6:
        this.f11021b = r11;
        return;
    L5:
        r11 = (int) Math.ceil(1.0d / r10);
        goto L6
    }

    public void a(double r10) {
        double r11 = 1.0d - this.f11020a;
        int r12 = this.f11023d;
        if (r12 <= this.f11021b) goto L7;
        double r13 = r11 * Math.log(this.f11022c);
        double r14 = this.f11020a;
    L5:
        r10 = Math.exp(r13 + (r14 * Math.log(r10)));
    L6:
        this.f11022c = r10;
        this.f11023d++;
        return;
    L7:
        if (r12 <= 0) goto L6;
        double r15 = (r11 * ((double) r12)) / (((double) r12) + 1.0d);
        r14 = 1.0d - r15;
        r13 = r15 * Math.log(this.f11022c);
        goto L5
    }

    public double b() {
        return this.f11022c;
    }
}
