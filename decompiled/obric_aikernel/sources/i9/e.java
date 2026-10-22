package i9;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    double f9436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    double f9437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f9439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f9440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f9441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f9442g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f9443h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f9444i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b.o f9445j;

    public e() {
        this.f9436a = Math.sqrt(1500.0d);
        this.f9437b = 0.5d;
        this.f9438c = false;
        this.f9444i = Double.MAX_VALUE;
        this.f9445j = new b.o();
    }

    private void b() {
        if (this.f9438c == false) goto L6;
        return;
    L6:
        if (this.f9444i == Double.MAX_VALUE) goto L18;
        double r10 = this.f9437b;
        if (r10 <= 1.0d) goto L11;
        double r11 = this.f9436a;
        this.f9441f = ((-r10) * r11) + (r11 * Math.sqrt((r10 * r10) - 1.0d));
        double r12 = this.f9437b;
        double r13 = this.f9436a;
        this.f9442g = ((-r12) * r13) - (r13 * Math.sqrt((r12 * r12) - 1.0d));
    L15:
        this.f9438c = true;
        return;
    L11:
        if (r10 < 0.0d) goto L15;
        if (r10 >= 1.0d) goto L15;
        this.f9443h = this.f9436a * Math.sqrt(1.0d - (r10 * r10));
        goto L15
    L18:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    public float a() {
        return (float) this.f9444i;
    }

    public boolean c(float r10, float r11) {
        if (Math.abs(r11) < this.f9440e) goto L5;
        return false;
    L5:
        if (Math.abs(r10 - a()) >= this.f9439d) goto L10;
        return true;
    L10:
        return false;
    }

    public e d(float r10) {
        if (r10 < 0.0f) goto L7;
        this.f9437b = r10;
        this.f9438c = false;
        return this;
    L7:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public e e(float r10) {
        this.f9444i = r10;
        return this;
    }

    public e f(float r10) {
        if (r10 <= 0.0f) goto L7;
        this.f9436a = Math.sqrt(r10);
        this.f9438c = false;
        return this;
    L7:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    void g(double r10) {
        double r11 = Math.abs(r10);
        this.f9439d = r11;
        this.f9440e = r11 * 62.5d;
    }

    b.o h(double r17, double r19, long r21) {
        b();
        double r10 = r21 / 1000.0d;
        double r11 = r17 - this.f9444i;
        double r12 = this.f9437b;
        if (r12 <= 1.0d) goto L6;
        double r13 = this.f9442g;
        double r14 = this.f9441f;
        double r15 = r11 - (((r13 * r11) - r19) / (r13 - r14));
        double r16 = ((r11 * r13) - r19) / (r13 - r14);
        double r18 = (Math.pow(2.718281828459045d, r13 * r10) * r15) + (Math.pow(2.718281828459045d, this.f9441f * r10) * r16);
        double r110 = this.f9442g;
        double r20 = (r15 * r110) * Math.pow(2.718281828459045d, r110 * r10);
        double r111 = this.f9441f;
        double r22 = r20 + ((r16 * r111) * Math.pow(2.718281828459045d, r111 * r10));
    L9:
        b.o r23 = this.f9445j;
        r23.f9431a = (float) (r18 + this.f9444i);
        r23.f9432b = (float) r22;
        return r23;
    L6:
        if (r12 != 1.0d) goto L8;
        double r24 = this.f9436a;
        double r25 = r19 + (r24 * r11);
        double r26 = r11 + (r25 * r10);
        r18 = Math.pow(2.718281828459045d, (-r24) * r10) * r26;
        double r27 = r26 * Math.pow(2.718281828459045d, (-this.f9436a) * r10);
        double r112 = this.f9436a;
        r22 = (r25 * Math.pow(2.718281828459045d, (-r112) * r10)) + (r27 * (-r112));
        goto L9
    L8:
        double r28 = 1.0d / this.f9443h;
        double r113 = this.f9436a;
        double r29 = r28 * (((r12 * r113) * r11) + r19);
        double r30 = Math.pow(2.718281828459045d, ((-r12) * r113) * r10) * ((Math.cos(this.f9443h * r10) * r11) + (Math.sin(this.f9443h * r10) * r29));
        double r114 = this.f9436a;
        double r115 = this.f9437b;
        double r116 = ((-r114) * r30) * r115;
        double r31 = Math.pow(2.718281828459045d, ((-r115) * r114) * r10);
        double r117 = this.f9443h;
        double r32 = ((-r117) * r11) * Math.sin(r117 * r10);
        double r33 = this.f9443h;
        r22 = r116 + (r31 * (r32 + ((r29 * r33) * Math.cos(r33 * r10))));
        r18 = r30;
        goto L9
    }
}
