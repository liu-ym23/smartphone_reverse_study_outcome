package gb;

import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import com.qualcomm.qti.qesdk.QesdkUtils;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements fb.a<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ab.c f7788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f7789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f7790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f7791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f7793f;

    public b(float r8, float r10, int r11) {
        this.f7790c = r8;
        this.f7791d = r10;
        this.f7792e = r11;
        this.f7793f = 0.01f;
        ab.c r12 = new ab.c();
        float r13 = 0;
        if (r8 < r13) goto L11;
        r12.f254f = r8;
        r12.f250b = false;
        double r14 = r12.f249a;
        if (((float) (r14 * r14)) <= r13) goto L9;
        r12.f249a = Math.sqrt(r10);
        r12.f250b = false;
        j r15 = j.f13877a;
        this.f7788a = r12;
        this.f7789b = 1.0f;
        return;
    L9:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    L11:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    @Override // fb.a
    public final /* bridge */ /* synthetic */ long a(float r8, Object r10, Object r11) {
        return g(((Number) r10).floatValue(), ((Number) r11).floatValue(), r8);
    }

    @Override // fb.a
    public final float b(long r8, Number r10, Number r11, float r12) {
        float r13 = r10.floatValue();
        float r14 = r11.floatValue();
        long r15 = f(r8, r13, r14, r12) / BwdlDropUtils.DROP_SHOW_MEGABYTES;
        ab.c r16 = this.f7788a;
        r16.f255g = r14;
        return Float.intBitsToFloat((int) (r16.a(r13, r12, r15).f248a & QesdkUtils.LIMITS.UINT_32_UPPER));
    }

    @Override // fb.a
    public final String c() {
        return "FloatSpringSpec(dampingRatio: " + this.f7790c + ", stiffness: " + this.f7791d + ", delay: " + this.f7792e + ", visibilityThreshold: " + this.f7793f + ", delta: " + this.f7789b + ')';
    }

    @Override // fb.a
    public final Float d(long r8, Number r10, Number r11, float r12) {
        float r13 = r10.floatValue();
        float r14 = r11.floatValue();
        long r15 = f(r8, r13, r14, r12) / BwdlDropUtils.DROP_SHOW_MEGABYTES;
        ab.c r16 = this.f7788a;
        r16.f255g = r14;
        return Float.valueOf(Float.intBitsToFloat((int) (r16.a(r13, r12, r15).f248a >> 32)));
    }

    @Override // fb.a
    public final boolean e(long r8, long r10) {
        if (r8 < ((((long) this.f7792e) * BwdlDropUtils.DROP_SHOW_MEGABYTES) + r10)) goto L5;
        return true;
    L5:
        return false;
    }

    public final long f(long r10, float r11, float r12, float r13) {
        long r14 = g(r11, r12, r13);
        long r8 = r10 - (((long) this.f7792e) * BwdlDropUtils.DROP_SHOW_MEGABYTES);
        if (r14 < 0) goto L5;
        long r15 = r14;
    L7:
        return l6.a.y(r8, 0, r15);
    L5:
        r15 = 0;
        goto L7
    }

    public final long g(float r35, float r36, float r37) {
        ab.c r8 = this.f7788a;
        double r10 = r8.f249a;
        float r11 = (float) (r10 * r10);
        float r12 = r8.f254f;
        float r13 = this.f7793f;
        float r14 = (r35 - r36) / r13;
        float r15 = r37 / r13;
        float r16 = this.f7789b;
        if (r12 != 0.0f) goto L5;
        long r17 = 9223372036854L;
    L111:
        return r17 * BwdlDropUtils.DROP_SHOW_MEGABYTES;
    L5:
        double r18 = r11;
        double r19 = r12;
        double r20 = r15;
        double r21 = r14;
        double r22 = r16;
        double r110 = (r19 * 2.0d) * Math.sqrt(r18);
        double r111 = (r110 * r110) - (r18 * 4.0d);
        double r23 = -r110;
        a r24 = defpackage.c.B(r111);
        r24.f7786a = (r24.f7786a + r23) * 0.5d;
        r24.f7787b *= 0.5d;
        a r112 = defpackage.c.B(r111);
        double r113 = -1;
        double r114 = r112.f7786a * r113;
        double r25 = r112.f7787b * r113;
        r112.f7786a = (r114 + r23) * 0.5d;
        r112.f7787b = r25 * 0.5d;
        if (r21 == 0.0d) goto L8;
    L10:
        double r115 = 0;
        if (r21 >= r115) goto L13;
        r20 = -r20;
    L13:
        double r26 = Math.abs(r21);
        double r27 = Double.MAX_VALUE;
        if (r19 <= 1.0d) goto L61;
        double r28 = r24.f7786a;
        double r116 = r112.f7786a;
        double r117 = (r28 * r26) - r20;
        double r29 = r28 - r116;
        double r118 = r117 / r29;
        double r30 = r26 - r118;
        double r31 = r22;
        double r119 = Math.log(Math.abs(r31 / r30)) / r28;
        double r32 = Math.log(Math.abs(r31 / r118)) / r116;
        if (Double.isInfinite(r119) == false) goto L18;
    L20:
        boolean r33 = false;
    L22:
        if ((!r33) == false) goto L25;
    L35:
        double r120 = r30 * r28;
        double r38 = r32;
        double r34 = Math.log(r120 / ((-r118) * r116)) / (r116 - r28);
        new c(r30, r28, r34, r118, r116);
        if (Double.isNaN(r34) == false) goto L38;
    L50:
        double r121 = r38;
    L51:
        r31 = -r31;
        double r39 = r121;
    L52:
        double r210 = r118 * r116;
        if (Math.abs((Math.exp(r116 * r39) * r210) + (Math.exp(r28 * r39) * r120)) < 1.0E-4d) goto L109;
        int r40 = 0;
    L57:
        if (r27 <= 0.001d) goto L109;
        if (r40 >= 100) goto L109;
        r40 = r40 + 1;
        double r122 = r28 * r39;
        double r211 = r116 * r39;
        double r123 = r39 - ((((Math.exp(r211) * r118) + (Math.exp(r122) * r30)) + r31) / ((Math.exp(r211) * r210) + (Math.exp(r122) * r120)));
        r27 = Math.abs(r39 - r123);
        r39 = r123;
    L109:
        r17 = (long) (r39 * 1000.0d);
        goto L111
    L38:
        if (r34 <= 0.0d) goto L50;
        if (r34 > 0.0d) goto L43;
    L49:
        r39 = Math.log((-((r118 * r116) * r116)) / (r120 * r28)) / r29;
        goto L52
    L43:
        if ((-((Math.exp(r34 * r116) * r118) + (Math.exp(r28 * r34) * r30))) >= r31) goto L49;
        if (r118 <= 0.0d) goto L50;
        if (r30 >= 0.0d) goto L50;
        r121 = 0.0d;
        goto L51
    L25:
        if (Double.isInfinite(r32) == false) goto L27;
    L29:
        boolean r41 = false;
    L31:
        if ((!r41) == true) goto L34;
        r119 = Math.max(r119, r32);
    L34:
        r32 = r119;
        goto L35
    L27:
        if (Double.isNaN(r32) == true) goto L29;
        r41 = true;
        goto L31
    L18:
        if (Double.isNaN(r119) == true) goto L20;
        r33 = true;
        goto L22
    L61:
        if (r19 >= 1.0d) goto L63;
        double r42 = r24.f7786a;
        double r43 = (r20 - (r42 * r26)) / r24.f7787b;
        r39 = Math.log(r22 / Math.sqrt((r43 * r43) + (r26 * r26))) / r42;
        goto L109
    L63:
        double r44 = r24.f7786a;
        double r124 = r44 * r26;
        double r45 = r20 - r124;
        double r125 = Math.log(Math.abs(r22 / r26)) / r44;
        double r212 = Math.log(Math.abs(r22 / r45));
        double r213 = r212;
        int r46 = 0;
    L64:
        double r47 = r213 / r44;
        if (r46 > 5) goto L68;
        r213 = r212 - Math.log(Math.abs(r47));
        r46 = r46 + 1;
        goto L64
    L68:
        if (Double.isInfinite(r125) == false) goto L70;
    L72:
        boolean r48 = false;
    L74:
        if ((!r48) == false) goto L77;
        r125 = r47;
    L86:
        double r49 = (-(r124 + r45)) / (r44 * r45);
        double r214 = r44 * r49;
        double r215 = Math.exp(r214) * r26;
        double r216 = r125;
        double r126 = (Math.exp(r214) * (r45 * r49)) + r215;
        if (Double.isNaN(r49) == false) goto L89;
    L101:
        double r50 = -r22;
    L102:
        int r51 = 0;
    L104:
        if (r27 <= 0.001d) goto L108;
        if (r51 >= 100) goto L108;
        r51 = r51 + 1;
        double r127 = r44 * r216;
        double r128 = r216 - (((Math.exp(r127) * ((r45 * r216) + r26)) + r50) / (Math.exp(r127) * (((((double) 1) + r127) * r45) + r124)));
        r27 = Math.abs(r216 - r128);
        r216 = r128;
    L108:
        r39 = r216;
        goto L109
    L89:
        if (r49 <= 0.0d) goto L101;
        if (r49 > 0.0d) goto L94;
    L100:
        r216 = (-(2.0d / r44)) - (r26 / r45);
        r50 = r22;
        goto L102
    L94:
        if ((-r126) >= r22) goto L100;
        if (r45 >= r115) goto L101;
        if (r26 <= r115) goto L101;
        r216 = 0.0d;
        goto L101
    L77:
        if (Double.isInfinite(r47) == false) goto L79;
    L81:
        boolean r52 = false;
    L83:
        if ((!r52) == true) goto L86;
        r125 = Math.max(r125, r47);
        goto L86
    L79:
        if (Double.isNaN(r47) == true) goto L81;
        r52 = true;
        goto L83
    L70:
        if (Double.isNaN(r125) == true) goto L72;
        r48 = true;
        goto L74
    L8:
        if (r20 != 0.0d) goto L10;
        r17 = 0;
        goto L111
    }
}
