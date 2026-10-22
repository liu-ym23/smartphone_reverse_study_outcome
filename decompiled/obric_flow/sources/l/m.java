package l;

import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.z;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f19500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f19501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f19502c;
    public final Matrix d;
    public final float[] e;
    public d f;
    public d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f19503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f19504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f19505j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f19506k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f19507l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f19508m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f19509n;

    public m(p.d r5) {
        this.f19500a = new Matrix();
        m0.b r10 = r5.f21311a;
        if (r10 != null) goto L5;
        d r11 = null;
    L6:
        this.f = r11;
        p.e r12 = r5.f21312b;
        if (r12 != null) goto L9;
        d r13 = null;
    L10:
        this.g = r13;
        p.a r14 = r5.f21313c;
        if (r14 != null) goto L13;
        d r15 = null;
    L14:
        this.f19503h = r15;
        p.b r16 = r5.d;
        if (r16 != null) goto L17;
        d r17 = null;
    L18:
        this.f19504i = r17;
        p.b r18 = r5.f;
        if (r18 != null) goto L21;
        f r19 = null;
    L22:
        this.f19506k = r19;
        if (r19 == null) goto L25;
        this.f19501b = new Matrix();
        this.f19502c = new Matrix();
        this.d = new Matrix();
        this.e = new float[9];
    L26:
        p.b r20 = r5.g;
        if (r20 != null) goto L29;
        f r21 = null;
    L30:
        this.f19507l = r21;
        p.a r22 = r5.e;
        if (r22 == null) goto L33;
        this.f19505j = r22.d();
    L33:
        p.b r23 = r5.f21314h;
        if (r23 == null) goto L36;
        this.f19508m = r23.d();
    L37:
        p.b r24 = r5.f21315i;
        if (r24 == null) goto L40;
        this.f19509n = r24.d();
        return;
    L40:
        this.f19509n = null;
        return;
    L36:
        this.f19508m = null;
        goto L37
    L29:
        r21 = (f) r20.d();
        goto L30
    L25:
        this.f19501b = null;
        this.f19502c = null;
        this.d = null;
        this.e = null;
        goto L26
    L21:
        r19 = (f) r18.d();
        goto L22
    L17:
        r17 = r16.d();
        goto L18
    L13:
        r15 = r14.d();
        goto L14
    L9:
        r13 = r12.d();
        goto L10
    L5:
        r11 = r10.d();
        goto L6
    }

    public final void a(r.c r5) {
        r5.f(this.f19505j);
        r5.f(this.f19508m);
        r5.f(this.f19509n);
        r5.f(this.f);
        r5.f(this.g);
        r5.f(this.f19503h);
        r5.f(this.f19504i);
        r5.f(this.f19506k);
        r5.f(this.f19507l);
    }

    public final void b(a r5) {
        d r10 = this.f19505j;
        if (r10 == null) goto L5;
        r10.a(r5);
    L5:
        d r11 = this.f19508m;
        if (r11 == null) goto L8;
        r11.a(r5);
    L8:
        d r12 = this.f19509n;
        if (r12 == null) goto L11;
        r12.a(r5);
    L11:
        d r13 = this.f;
        if (r13 == null) goto L14;
        r13.a(r5);
    L14:
        d r14 = this.g;
        if (r14 == null) goto L17;
        r14.a(r5);
    L17:
        d r15 = this.f19503h;
        if (r15 == null) goto L20;
        r15.a(r5);
    L20:
        d r16 = this.f19504i;
        if (r16 == null) goto L23;
        r16.a(r5);
    L23:
        f r17 = this.f19506k;
        if (r17 == null) goto L26;
        r17.a(r5);
    L26:
        f r18 = this.f19507l;
        if (r18 == null) goto L30;
        r18.a(r5);
        return;
    }

    public final boolean c(ColorFilter r5, v.c r10) {
        if (r5 != z.f1356a) goto L9;
        d r11 = this.f;
        if (r11 != null) goto L7;
        this.f = new n(r10, new PointF());
        return true;
    L7:
        r11.j(r10);
        return true;
    L9:
        if (r5 != z.f1357b) goto L15;
        d r12 = this.g;
        if (r12 != null) goto L13;
        this.g = new n(r10, new PointF());
        return true;
    L13:
        r12.j(r10);
        return true;
    L15:
        if (r5 != z.g) goto L21;
        d r13 = this.f19503h;
        if (r13 != null) goto L19;
        this.f19503h = new n(r10, new v.d());
        return true;
    L19:
        r13.j(r10);
        return true;
    L21:
        if (r5 != z.f1359h) goto L27;
        d r14 = this.f19504i;
        if (r14 != null) goto L25;
        this.f19504i = new n(r10, Float.valueOf(0.0f));
        return true;
    L25:
        r14.j(r10);
        return true;
    L27:
        if (r5 != 3) goto L33;
        d r15 = this.f19505j;
        if (r15 != null) goto L31;
        this.f19505j = new n(r10, 100);
        return true;
    L31:
        r15.j(r10);
        return true;
    L33:
        if (r5 != z.f1371u) goto L38;
        d r16 = this.f19508m;
        if (r16 == null) goto L38;
        r16.j(r10);
        return true;
    L38:
        if (r5 != z.f1372v) goto L43;
        d r17 = this.f19509n;
        if (r17 == null) goto L43;
        r17.j(r10);
        return true;
    L43:
        if (r5 != z.f1360i) goto L48;
        f r18 = this.f19506k;
        if (r18 == null) goto L48;
        r18.j(r10);
        return true;
    L48:
        if (r5 != z.f1361j) goto L54;
        f r19 = this.f19507l;
        if (r19 == null) goto L69;
        r19.j(r10);
        return true;
    L69:
        return false;
    L54:
        return false;
    }

    public final void d() {
        int r5 = 0;
    L4:
        if (r5 >= 9) goto L6;
        this.e[r5] = 0.0f;
        r5 = r5 + 1;
        goto L4
    }

    public final Matrix e() {
        Matrix r5 = this.f19500a;
        r5.reset();
        d r10 = this.g;
        if (r10 == null) goto L9;
        PointF r11 = (PointF) r10.f();
        float r12 = r11.x;
        if (r12 == 0.0f) goto L7;
    L8:
        r5.preTranslate(r12, r11.y);
        goto L9
    L7:
        if (r11.y != 0.0f) goto L8;
    L9:
        d r13 = this.f19504i;
        if (r13 == null) goto L19;
        if ((r13 instanceof n) == false) goto L14;
        float r14 = ((Float) r13.f()).floatValue();
    L16:
        if (r14 == 0.0f) goto L19;
        r5.preRotate(r14);
        goto L19
    L14:
        r14 = ((f) r13).k();
    L19:
        if (this.f19506k == null) goto L29;
        f r15 = this.f19507l;
        if (r15 != null) goto L23;
        float r16 = 0.0f;
    L24:
        f r17 = this.f19507l;
        if (r17 != null) goto L27;
        float r18 = 1.0f;
    L28:
        float r19 = (float) Math.tan(Math.toRadians(this.f19506k.k()));
        d();
        float[] r20 = this.e;
        r20[0] = r16;
        r20[1] = r18;
        float r21 = -r18;
        r20[3] = r21;
        r20[4] = r16;
        r20[8] = 1.0f;
        Matrix r110 = this.f19501b;
        r110.setValues(r20);
        d();
        r20[0] = 1.0f;
        r20[3] = r19;
        r20[4] = 1.0f;
        r20[8] = 1.0f;
        Matrix r22 = this.f19502c;
        r22.setValues(r20);
        d();
        r20[0] = r16;
        r20[1] = r21;
        r20[3] = r18;
        r20[4] = r16;
        r20[8] = 1.0f;
        Matrix r23 = this.d;
        r23.setValues(r20);
        r22.preConcat(r110);
        r23.preConcat(r22);
        r5.preConcat(r23);
        goto L29
    L27:
        r18 = (float) Math.sin(Math.toRadians((-r17.k()) + 90.0f));
        goto L28
    L23:
        r16 = (float) Math.cos(Math.toRadians((-r15.k()) + 90.0f));
    L29:
        d r24 = this.f19503h;
        if (r24 == null) goto L36;
        v.d r25 = (v.d) r24.f();
        float r26 = r25.f22484a;
        if (r26 == 1.0f) goto L34;
    L35:
        r5.preScale(r26, r25.f22485b);
        goto L36
    L34:
        if (r25.f22485b != 1.0f) goto L35;
    L36:
        d r111 = this.f;
        if (r111 == null) goto L43;
        PointF r112 = (PointF) r111.f();
        float r27 = r112.x;
        if (r27 == 0.0f) goto L41;
    L42:
        r5.preTranslate(-r27, -r112.y);
        goto L43
    L41:
        if (r112.y != 0.0f) goto L42;
    L43:
        return r5;
    }

    public final Matrix f(float r10) {
        d r5 = this.g;
        PointF r11 = null;
        if (r5 != null) goto L5;
        PointF r12 = null;
    L6:
        d r13 = this.f19503h;
        if (r13 != null) goto L9;
        v.d r14 = null;
    L10:
        Matrix r15 = this.f19500a;
        r15.reset();
        if (r12 == null) goto L13;
        r15.preTranslate(r12.x * r10, r12.y * r10);
    L13:
        if (r14 == null) goto L15;
        double r16 = r10;
        r15.preScale((float) Math.pow(r14.f22484a, r16), (float) Math.pow(r14.f22485b, r16));
    L15:
        d r17 = this.f19504i;
        if (r17 == null) goto L29;
        float r18 = ((Float) r17.f()).floatValue();
        d r19 = this.f;
        if (r19 == null) goto L21;
        r11 = (PointF) r19.f();
    L21:
        float r20 = r18 * r10;
        float r21 = 0.0f;
        if (r11 != null) goto L24;
        float r22 = 0.0f;
    L25:
        if (r11 == null) goto L28;
        r21 = r11.y;
    L28:
        r15.preRotate(r20, r22, r21);
        goto L29
    L24:
        r22 = r11.x;
    L29:
        return r15;
    L9:
        r14 = (v.d) r13.f();
        goto L10
    L5:
        r12 = (PointF) r5.f();
        goto L6
    }
}
