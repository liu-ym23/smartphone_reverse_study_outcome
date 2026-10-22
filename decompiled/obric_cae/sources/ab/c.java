package ab;

import com.qualcomm.qti.qesdk.QesdkUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f255g;

    public c() {
        this.f255g = 1.0f;
        this.f249a = Math.sqrt(50.0f);
        this.f254f = 1.0f;
    }

    public final b a(float r17, float r18, long r19) {
        if (this.f250b == false) goto L6;
    L16:
        double r8 = r19 / 1000.0d;
        float r10 = r17 - this.f255g;
        float r11 = this.f254f;
        if (r11 <= 1) goto L20;
        double r12 = r10;
        double r13 = this.f252d;
        double r14 = r18;
        double r15 = this.f251c;
        double r16 = r12 - (((r13 * r12) - r14) / (r13 - r15));
        double r20 = ((r12 * r13) - r14) / (r13 - r15);
        double r110 = (Math.exp(this.f251c * r8) * r20) + (Math.exp(r13 * r8) * r16);
        double r21 = this.f252d;
        double r22 = Math.exp(r21 * r8) * (r16 * r21);
        double r23 = this.f251c;
        double r24 = (Math.exp(r23 * r8) * (r20 * r23)) + r22;
    L23:
        long r25 = Float.floatToRawIntBits((float) (r110 + ((double) this.f255g)));
        return new b((((long) Float.floatToRawIntBits((float) r24)) & QesdkUtils.LIMITS.UINT_32_UPPER) | (r25 << 32));
    L20:
        if (r11 != 1.0f) goto L22;
        double r26 = this.f249a;
        double r27 = r10;
        double r111 = (r26 * r27) + ((double) r18);
        double r28 = (r111 * r8) + r27;
        double r29 = Math.exp((-r26) * r8) * r28;
        double r30 = Math.exp((-this.f249a) * r8) * r28;
        double r31 = this.f249a;
        r24 = (Math.exp((-r31) * r8) * r111) + (r30 * (-r31));
        r110 = r29;
        goto L23
    L22:
        double r32 = ((double) 1) / this.f253e;
        double r112 = this.f249a;
        double r33 = r10;
        double r34 = (((((double) r11) * r112) * r33) + ((double) r18)) * r32;
        double r35 = Math.exp((((double) (-r11)) * r112) * r8) * ((Math.sin(this.f253e * r8) * r34) + (Math.cos(this.f253e * r8) * r33));
        double r113 = this.f249a;
        float r36 = this.f254f;
        double r114 = ((-r113) * r35) * ((double) r36);
        double r37 = Math.exp((((double) (-r36)) * r113) * r8);
        double r115 = this.f253e;
        double r38 = Math.sin(r115 * r8) * ((-r115) * r33);
        double r116 = this.f253e;
        r24 = (((Math.cos(r116 * r8) * (r34 * r116)) + r38) * r37) + r114;
        r110 = r35;
        goto L23
    L6:
        if (this.f255g == Float.MAX_VALUE) goto L26;
        float r39 = this.f254f;
        double r40 = r39;
        double r41 = r40 * r40;
        float r42 = 1;
        if (r39 <= r42) goto L11;
        double r43 = this.f249a;
        double r44 = r41 - ((double) 1);
        this.f251c = (Math.sqrt(r44) * r43) + (((double) (-r39)) * r43);
        double r45 = -this.f254f;
        double r46 = this.f249a;
        this.f252d = (r45 * r46) - (Math.sqrt(r44) * r46);
    L15:
        this.f250b = true;
        goto L16
    L11:
        if (r39 < 0) goto L15;
        if (r39 >= r42) goto L15;
        this.f253e = Math.sqrt(((double) 1) - r41) * this.f249a;
        goto L15
    L26:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
}
