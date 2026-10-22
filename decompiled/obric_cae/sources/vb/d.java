package vb;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f12817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f12818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f12820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f12821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f12822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f12823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f12824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f12825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b.h f12826j;

    public d() {
        this.f12817a = Math.sqrt(1500.0d);
        this.f12818b = 0.5d;
        this.f12819c = false;
        this.f12825i = Double.MAX_VALUE;
        this.f12826j = new b.h();
    }

    public final b.h a(double r17, double r19, long r21) {
        if (this.f12819c == false) goto L6;
    L16:
        double r8 = r21 / 1000.0d;
        double r10 = r17 - this.f12825i;
        double r11 = this.f12818b;
        if (r11 <= 1.0d) goto L20;
        double r12 = this.f12823g;
        double r13 = this.f12822f;
        double r14 = r10 - (((r12 * r10) - r19) / (r12 - r13));
        double r15 = ((r10 * r12) - r19) / (r12 - r13);
        double r16 = (Math.pow(2.718281828459045d, this.f12822f * r8) * r15) + (Math.pow(2.718281828459045d, r12 * r8) * r14);
        double r18 = this.f12823g;
        double r20 = Math.pow(2.718281828459045d, r18 * r8) * (r14 * r18);
        double r22 = this.f12822f;
        double r23 = (Math.pow(2.718281828459045d, r22 * r8) * (r15 * r22)) + r20;
    L23:
        float r24 = (float) (r16 + this.f12825i);
        b.h r25 = this.f12826j;
        r25.f12812a = r24;
        r25.f12813b = (float) r23;
        return r25;
    L20:
        if (r11 != 1.0d) goto L22;
        double r26 = this.f12817a;
        double r27 = (r26 * r10) + r19;
        double r110 = (r27 * r8) + r10;
        double r28 = Math.pow(2.718281828459045d, (-r26) * r8) * r110;
        double r29 = Math.pow(2.718281828459045d, (-this.f12817a) * r8) * r110;
        double r111 = this.f12817a;
        r23 = (Math.pow(2.718281828459045d, (-r111) * r8) * r27) + (r29 * (-r111));
        r16 = r28;
        goto L23
    L22:
        double r30 = 1.0d / this.f12824h;
        double r112 = this.f12817a;
        double r113 = (((r11 * r112) * r10) + r19) * r30;
        double r114 = ((Math.sin(this.f12824h * r8) * r113) + (Math.cos(this.f12824h * r8) * r10)) * Math.pow(2.718281828459045d, ((-r11) * r112) * r8);
        double r31 = this.f12817a;
        double r115 = this.f12818b;
        double r32 = ((-r31) * r114) * r115;
        double r33 = Math.pow(2.718281828459045d, ((-r115) * r31) * r8);
        double r116 = this.f12824h;
        double r34 = Math.sin(r116 * r8) * ((-r116) * r10);
        double r117 = this.f12824h;
        r23 = (((Math.cos(r117 * r8) * (r113 * r117)) + r34) * r33) + r32;
        r16 = r114;
        goto L23
    L6:
        if (this.f12825i == Double.MAX_VALUE) goto L26;
        double r35 = this.f12818b;
        if (r35 <= 1.0d) goto L11;
        double r36 = this.f12817a;
        this.f12822f = (Math.sqrt((r35 * r35) - 1.0d) * r36) + ((-r35) * r36);
        double r37 = this.f12818b;
        double r38 = this.f12817a;
        this.f12823g = ((-r37) * r38) - (Math.sqrt((r37 * r37) - 1.0d) * r38);
    L15:
        this.f12819c = true;
        goto L16
    L11:
        if (r35 < 0.0d) goto L15;
        if (r35 >= 1.0d) goto L15;
        this.f12824h = Math.sqrt(1.0d - (r35 * r35)) * this.f12817a;
        goto L15
    L26:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
}
