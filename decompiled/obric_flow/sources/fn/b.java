package fn;

import ai.j0;
import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f16933q = 0.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float[] f16934r = null;
    public static final float[] s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16937c;
    public int d;
    public int e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f16938h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16939i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16940j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f16941k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f16942l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f16943m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f16944n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f16945o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f16946p;

    static {
        f16933q = (float) (Math.log(0.78d) / Math.log(0.9d));
        f16934r = new float[101];
        s = new float[101];
        float r5 = 0.0f;
        int r10 = 0;
        float r11 = 0.0f;
    L3:
        float r12 = 1.0f;
        if (r10 >= 100) goto L22;
        float r13 = r10 / 100.0f;
        float r14 = 1.0f;
    L6:
        float r15 = androidx.constraintlayout.motion.widget.a.a(r14, r5, 2.0f, r5);
        float r16 = r12 - r15;
        float r17 = (r15 * 3.0f) * r16;
        float r18 = (r15 * r15) * r15;
        float r19 = (((r15 * 0.35000002f) + (r16 * 0.175f)) * r17) + r18;
        if (Math.abs(r19 - r13) < 1.0E-5d) goto L8;
        float r110 = r13;
        if (r19 <= r110) goto L21;
        r14 = r15;
    L20:
        r13 = r110;
        r12 = 1.0f;
        goto L6
    L21:
        r5 = r15;
        goto L20
    L8:
        f16934r[r10] = (((r16 * 0.5f) + r15) * r17) + r18;
        float r20 = r12;
    L9:
        float r21 = androidx.constraintlayout.motion.widget.a.a(r20, r11, 2.0f, r11);
        float r111 = r12 - r21;
        float r22 = (r21 * 3.0f) * r111;
        float r112 = (r21 * r21) * r21;
        float r113 = (((r111 * 0.5f) + r21) * r22) + r112;
        float r114 = r13;
        if (Math.abs(r113 - r13) < 1.0E-5d) goto L11;
        if (r113 <= r114) goto L16;
        r20 = r21;
    L15:
        r13 = r114;
        r12 = 1.0f;
        goto L9
    L16:
        r11 = r21;
        goto L15
    L11:
        s[r10] = (((r21 * 0.35000002f) + (r111 * 0.175f)) * r22) + r112;
        r10 = r10 + 1;
        goto L3
    L22:
        float[] r23 = f16934r;
        s[100] = 1.0f;
        r23[100] = 1.0f;
    }

    public b(Context r5) {
        this.f16944n = ViewConfiguration.getScrollFriction();
        this.f16945o = 0;
        this.f16942l = true;
        this.f16946p = ((r5.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
    }

    public final void a(int r5, int r10) {
        this.f16942l = false;
        this.f16945o = 1;
        this.f16937c = this.f16936b;
        this.f16935a = r5;
        this.f16936b = r5;
        this.d = r10;
        int r11 = r5 - r10;
        if (r11 <= 0) goto L5;
        float r12 = -2000.0f;
    L6:
        this.g = r12;
        this.e = -r11;
        this.f16943m = Math.abs(r11);
        this.f16939i = (int) (Math.sqrt((((double) r11) * (-2.0d)) / ((double) this.g)) * 1000.0d);
        return;
    L5:
        r12 = 2000.0f;
        goto L6
    }

    public final void b(int r5, int r10, int r11) {
        float r12 = Math.abs((r11 - r5) / (r10 - r5));
        int r13 = (int) (r12 * 100.0f);
        if (r13 >= 100) goto L6;
        float r14 = r13 / 100.0f;
        int r15 = r13 + 1;
        float[] r16 = s;
        float r17 = r16[r13];
        this.f16939i = (int) (this.f16939i * j0.b(r16[r15], r17, (r12 - r14) / ((r15 / 100.0f) - r14), r17));
        return;
    }

    public final void c(int r22, int r23, int r24, int r25, int r26, int r27) {
        int r5 = r24;
        int r10 = r25;
        this.f16943m = r26;
        boolean r11 = false;
        this.f16942l = false;
        this.e = r23;
        float r12 = r23;
        this.f = r12;
        this.f16940j = 0;
        this.f16939i = 0;
        this.f16938h = AnimationUtils.currentAnimationTimeMillis();
        this.f16935a = r22;
        this.f16937c = r22;
        this.f16936b = r22;
        float r13 = f16933q;
        float r14 = this.f16946p;
        float r15 = this.f16944n;
        if (r22 > r10) goto L23;
        if (r22 < r5) goto L23;
        this.f16945o = 0;
        if (r23 == 0) goto L9;
        int r16 = (int) (Math.exp(Math.log((Math.abs(r23) * 0.35f) / (r15 * r14)) / (((double) r13) - 1.0d)) * 1000.0d);
        this.f16940j = r16;
        this.f16939i = r16;
        double r17 = r13;
        double r18 = Math.exp((r17 / (r17 - 1.0d)) * Math.log((Math.abs(r23) * 0.35f) / (r15 * r14))) * ((double) (r15 * r14));
    L10:
        if (r23 != 0) goto L12;
    L14:
        this.f16941k = (int) (r18 * ((double) Math.signum(r12)));
    L15:
        int r19 = r22 + this.f16941k;
        this.d = r19;
        if (r19 >= r5) goto L18;
        b(this.f16935a, r19, r5);
        this.d = r5;
    L18:
        int r20 = this.d;
        if (r20 <= r25) goto L53;
        b(this.f16935a, r20, r25);
        this.d = r25;
        return;
    L53:
        return;
    L12:
        if (r27 >= r18) goto L14;
        float r21 = r27;
        double r28 = r13;
        double r110 = r28 - 1.0d;
        int r29 = (int) (((double) (((float) (Math.exp((Math.log(r21 / (r15 * r14)) / (r28 / r110)) / r110) * 1000.0d)) + ((float) (((((double) this.f16939i) * 1.0d) * ((double) r21)) / ((double) ((float) r18)))))) / 2.0d);
        this.f16940j = r29;
        this.f16939i = r29;
        this.f16941k = (int) (Math.signum(r12) * r21);
        goto L15
    L9:
        r18 = 0.0d;
    L23:
        if (r22 <= r5) goto L27;
        if (r22 >= r10) goto L27;
        this.f16942l = true;
        return;
    L27:
        if (r22 <= r10) goto L29;
        r11 = true;
    L29:
        if (r11 == false) goto L31;
        int r30 = r10;
    L32:
        int r31 = r22 - r30;
        if ((r31 * r23) < 0) goto L42;
        if (r23 == 0) goto L37;
        r31 = r23;
    L37:
        if (r31 <= 0) goto L39;
        float r32 = -2000.0f;
    L40:
        this.g = r32;
        float r33 = (float) Math.sqrt((((double) ((((r12 * r12) / 2.0f) / Math.abs(r32)) + Math.abs(r30 - r22))) * 2.0d) / ((double) Math.abs(this.g)));
        this.f16938h -= (long) ((int) ((r33 - ((-r23) / r32)) * 1000.0f));
        this.f16937c = this.f16936b;
        this.f16935a = r30;
        this.f16936b = r30;
        this.e = (int) ((-this.g) * r33);
        e();
        return;
    L39:
        r32 = 2000.0f;
        goto L40
    L42:
        double r34 = r13;
        if ((Math.exp((r34 / (r34 - 1.0d)) * Math.log((Math.abs(r23) * 0.35f) / (r15 * r14))) * ((double) (r15 * r14))) <= Math.abs(r31)) goto L51;
        if (r11 == true) goto L47;
        r5 = r22;
    L47:
        if (r11 == false) goto L49;
        r10 = r22;
    L49:
        c(r22, r23, r5, r10, this.f16943m, Integer.MAX_VALUE);
        return;
    L51:
        a(r22, r30);
        return;
    L31:
        r30 = r5;
        goto L32
    }

    public final boolean d() {
        int r5 = this.f16945o;
        if (r5 == 0) goto L10;
        if (r5 != 1) goto L6;
        return false;
    L6:
        if (r5 != 2) goto L17;
        this.f16938h += (long) this.f16939i;
        a(this.d, this.f16935a);
    L17:
        f();
        return true;
    L10:
        int r10 = this.f16939i;
        if (r10 >= this.f16940j) goto L19;
        this.f16937c = this.f16936b;
        int r11 = this.d;
        this.f16935a = r11;
        this.f16936b = r11;
        int r12 = (int) this.f;
        this.e = r12;
        if (r12 <= 0) goto L15;
        float r13 = -2000.0f;
    L16:
        this.g = r13;
        this.f16938h += (long) r10;
        e();
        goto L17
    L15:
        r13 = 2000.0f;
        goto L16
    L19:
        return false;
    }

    public final void e() {
        float r5 = this.e;
        float r10 = r5 * r5;
        float r11 = r10 / (Math.abs(this.g) * 2.0f);
        float r12 = Math.signum(this.e);
        float r13 = this.f16943m;
        if (r11 <= r13) goto L5;
        this.g = ((-r12) * r10) / (2.0f * r13);
        r11 = r13;
    L5:
        this.f16943m = (int) r11;
        this.f16945o = 2;
        int r14 = this.f16935a;
        int r15 = this.e;
        if (r15 > 0) goto L9;
        r11 = -r11;
    L9:
        this.d = r14 + ((int) r11);
        this.f16939i = -((int) ((r15 * 1000.0f) / this.g));
    }

    public final boolean f() {
        long r5 = AnimationUtils.currentAnimationTimeMillis() - this.f16938h;
        if (r5 == 0) goto L5;
        int r10 = this.f16939i;
        if (r5 <= r10) goto L11;
        return false;
    L11:
        int r11 = this.f16945o;
        if (r11 != 0) goto L14;
        float r12 = this.f16940j;
        float r13 = r5 / r12;
        int r14 = (int) (r13 * 100.0f);
        if (r14 >= 100) goto L23;
        float r15 = r14 / 100.0f;
        int r16 = r14 + 1;
        float[] r17 = f16934r;
        float r18 = r17[r14];
        float r19 = (r17[r16] - r18) / ((r16 / 100.0f) - r15);
        float r20 = j0.b(r13, r15, r19, r18);
    L24:
        float r21 = this.f16941k;
        this.f = ((r19 * r21) / r12) * 1000.0f;
        double r22 = r20 * r21;
    L25:
        this.f16937c = this.f16936b;
        this.f16936b = this.f16935a + ((int) Math.round(r22));
        return true;
    L23:
        r20 = 1.0f;
        r19 = 0.0f;
        goto L24
    L14:
        if (r11 != 1) goto L16;
        float r23 = r5 / r10;
        float r24 = r23 * r23;
        float r25 = Math.signum(this.e) * this.f16943m;
        double r26 = ((3.0f * r24) - ((2.0f * r23) * r24)) * r25;
        this.f = ((-r23) + r24) * (r25 * 6.0f);
        r22 = r26;
        goto L25
    L16:
        if (r11 == 2) goto L18;
        r22 = 0.0d;
        goto L25
    L18:
        float r27 = r5 / 1000.0f;
        float r28 = this.e;
        float r29 = this.g * r27;
        this.f = r29 + r28;
        r22 = ((r29 * r27) / 2.0f) + (r28 * r27);
        goto L25
    L5:
        if (this.f16939i <= 0) goto L7;
        return true;
    L7:
        return false;
    }
}
