package k;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements l.a, k, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PathMeasure f18484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f18485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f18486c;
    public final RectF d;
    public final w e;
    public final r.c f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f18487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j.a f18488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l.f f18489j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l.e f18490k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f18491l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l.f f18492m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l.n f18493n;

    public b(w r5, r.c r10, Paint.Cap r11, Paint.Join r12, float r13, p.a r14, p.b r15, ArrayList r16, p.b r17) {
        this.f18484a = new PathMeasure();
        this.f18485b = new Path();
        this.f18486c = new Path();
        this.d = new RectF();
        this.g = new ArrayList();
        j.a r18 = new j.a(1, 0);
        this.f18488i = r18;
        this.e = r5;
        this.f = r10;
        r18.setStyle(Paint.Style.STROKE);
        r18.setStrokeCap(r11);
        r18.setStrokeJoin(r12);
        r18.setStrokeMiter(r13);
        this.f18490k = (l.e) r14.d();
        this.f18489j = (l.f) r15.d();
        if (r17 != null) goto L5;
        this.f18492m = null;
    L6:
        this.f18491l = new ArrayList(r16.size());
        this.f18487h = new float[r16.size()];
        int r19 = 0;
        int r20 = 0;
    L8:
        if (r20 >= r16.size()) goto L10;
        this.f18491l.add(((p.b) r16.get(r20)).d());
        r20 = r20 + 1;
        goto L8
    L10:
        r10.f(this.f18490k);
        r10.f(this.f18489j);
        int r21 = 0;
    L12:
        if (r21 >= this.f18491l.size()) goto L14;
        r10.f((l.d) this.f18491l.get(r21));
        r21 = r21 + 1;
        goto L12
    L14:
        l.f r22 = this.f18492m;
        if (r22 == null) goto L17;
        r10.f(r22);
    L17:
        this.f18490k.a(this);
        this.f18489j.a(this);
    L19:
        if (r19 >= r16.size()) goto L21;
        ((l.d) this.f18491l.get(r19)).a(this);
        r19 = r19 + 1;
        goto L19
    L21:
        l.f r23 = this.f18492m;
        if (r23 == null) goto L28;
        r23.a(this);
        return;
    L28:
        return;
    L5:
        this.f18492m = (l.f) r17.d();
        goto L6
    }

    @Override // l.a
    public final void a() {
        this.e.invalidateSelf();
    }

    @Override // k.c
    public final void b(List r10, List r11) {
        ArrayList r12 = (ArrayList) r10;
        int r5 = r12.size() - 1;
        a r13 = null;
        u r14 = null;
    L3:
        if (r5 < 0) goto L10;
        c r15 = (c) r12.get(r5);
        if ((r15 instanceof u) == false) goto L9;
        u r16 = (u) r15;
        if (r16.f18571c != ShapeTrimPath$Type.INDIVIDUALLY) goto L9;
        r14 = r16;
    L9:
        r5 = r5 - 1;
        goto L3
    L10:
        if (r14 == null) goto L12;
        r14.c(this);
    L12:
        int r17 = r11.size();
    L13:
        r17 = r17 - 1;
        ArrayList r18 = this.g;
        if (r17 < 0) goto L28;
        c r19 = (c) r11.get(r17);
        if ((r19 instanceof u) == false) goto L23;
        u r20 = (u) r19;
        if (r20.f18571c != ShapeTrimPath$Type.INDIVIDUALLY) goto L23;
        if (r13 == null) goto L21;
        r18.add(r13);
    L21:
        a r21 = new a(r20);
        r20.c(this);
        r13 = r21;
    L23:
        if ((r19 instanceof n) == false) goto L13;
        if (r13 != null) goto L26;
        r13 = new a(r14);
    L26:
        r13.f18482a.add((n) r19);
        goto L13
    L28:
        if (r13 == null) goto L39;
        r18.add(r13);
        return;
    }

    @Override // o.f
    public void c(ColorFilter r5, v.c r10) {
        PointF r11 = z.f1356a;
        if (r5 != 4) goto L6;
        this.f18490k.j(r10);
        return;
    L6:
        if (r5 != z.f1362k) goto L9;
        this.f18489j.j(r10);
        return;
    L9:
        if (r5 != z.f1375y) goto L14;
        l.n r12 = new l.n(r10, null);
        this.f18493n = r12;
        r12.a(this);
        this.f.f(this.f18493n);
        return;
    }

    @Override // o.f
    public final void d(o.e r5, int r10, ArrayList r11, o.e r12) {
        u.e.e(r5, r10, r11, r12, this);
    }

    @Override // k.e
    public final void e(RectF r10, Matrix r11, boolean r12) {
        Path r13 = this.f18485b;
        r13.reset();
        int r5 = 0;
    L3:
        ArrayList r14 = this.g;
        if (r5 >= r14.size()) goto L10;
        a r15 = (a) r14.get(r5);
        int r16 = 0;
    L7:
        if (r16 >= r15.f18482a.size()) goto L9;
        r13.addPath(((n) r15.f18482a.get(r16)).getPath(), r11);
        r16 = r16 + 1;
        goto L7
    L9:
        r5 = r5 + 1;
        goto L3
    L10:
        RectF r17 = this.d;
        r13.computeBounds(r17, false);
        float r18 = this.f18489j.k() / 2.0f;
        r17.set(r17.left - r18, r17.top - r18, r17.right + r18, r17.bottom + r18);
        r10.set(r17);
        r10.set(r10.left - 1.0f, r10.top - 1.0f, r10.right + 1.0f, r10.bottom + 1.0f);
        com.airbnb.lottie.c.a();
    }

    @Override // k.e
    public void g(Canvas r20, Matrix r21, int r22) {
        b r5 = this;
        int r10 = 1;
        float[] r11 = u.f.d;
        boolean r12 = false;
        r11[0] = 0.0f;
        r11[1] = 0.0f;
        r11[2] = 37394.73f;
        r11[3] = 39575.234f;
        r21.mapPoints(r11);
        if (r11[0] != r11[2]) goto L5;
    L88:
        com.airbnb.lottie.c.a();
        return;
    L5:
        if (r11[1] == r11[3]) goto L88;
        l.e r13 = r5.f18490k;
        float r14 = (r22 / 255.0f) * r13.k(r13.b(), r13.d());
        float r15 = 100.0f;
        PointF r16 = u.e.f22190a;
        int r17 = Math.max(0, Math.min(255, (int) ((r14 / 100.0f) * 255.0f)));
        j.a r18 = r5.f18488i;
        r18.setAlpha(r17);
        r18.setStrokeWidth(u.f.d(r21) * r5.f18489j.k());
        if (r18.getStrokeWidth() > 0.0f) goto L11;
        com.airbnb.lottie.c.a();
        return;
    L11:
        ArrayList r19 = r5.f18491l;
        if (r19.isEmpty() == false) goto L14;
        com.airbnb.lottie.c.a();
    L31:
        l.n r23 = r5.f18493n;
        if (r23 == null) goto L34;
        r18.setColorFilter((ColorFilter) r23.f());
    L34:
        int r24 = 0;
    L35:
        ArrayList r25 = r5.g;
        if (r24 >= r25.size()) goto L86;
        a r26 = (a) r25.get(r24);
        u r110 = r26.f18483b;
        Path r111 = r5.f18485b;
        ArrayList r112 = r26.f18482a;
        if (r110 == null) goto L81;
        r111.reset();
        int r113 = r112.size() - r10;
    L40:
        if (r113 < 0) goto L42;
        r111.addPath(((n) r112.get(r113)).getPath(), r21);
        r113 = r113 - 1;
        goto L40
    L42:
        PathMeasure r114 = r5.f18484a;
        r114.setPath(r111, r12);
        float r115 = r114.getLength();
    L44:
        if (r114.nextContour() == false) goto L46;
        r115 = r115 + r114.getLength();
        goto L44
    L46:
        u r27 = r26.f18483b;
        float r116 = (((Float) r27.f.f()).floatValue() * r115) / 360.0f;
        float r117 = ((((Float) r27.d.f()).floatValue() * r115) / r15) + r116;
        float r28 = ((((Float) r27.e.f()).floatValue() * r115) / r15) + r116;
        int r118 = r112.size() - r10;
        float r119 = 0.0f;
    L47:
        if (r118 < 0) goto L79;
        Path r29 = r5.f18486c;
        r29.set(((n) r112.get(r118)).getPath());
        r29.transform(r21);
        r114.setPath(r29, r12);
        float r30 = r114.getLength();
        if (r28 <= r115) goto L59;
        float r120 = r28 - r115;
        if (r120 >= (r119 + r30)) goto L59;
        if (r119 >= r120) goto L59;
        if (r117 <= r115) goto L57;
        float r31 = (r117 - r115) / r30;
    L58:
        u.f.a(r29, r31, Math.min(r120 / r30, 1.0f), 0.0f);
        r20.drawPath(r29, r18);
    L78:
        r119 = r119 + r30;
        r118 = r118 - 1;
        r5 = this;
        r12 = false;
        goto L47
    L57:
        r31 = 0.0f;
    L59:
        float r32 = r119 + r30;
        if (r32 < r117) goto L78;
        if (r119 > r28) goto L78;
        if (r32 > r28) goto L70;
        if (r117 >= r119) goto L70;
        r20.drawPath(r29, r18);
    L70:
        if (r117 >= r119) goto L72;
        float r33 = 0.0f;
    L74:
        if (r28 <= r32) goto L76;
        float r34 = 1.0f;
    L77:
        u.f.a(r29, r33, r34, 0.0f);
        r20.drawPath(r29, r18);
        goto L78
    L76:
        r34 = (r28 - r119) / r30;
        goto L77
    L72:
        r33 = (r117 - r119) / r30;
        goto L74
    L79:
        com.airbnb.lottie.c.a();
    L85:
        r24 = r24 + 1;
        r10 = 1;
        r12 = false;
        r15 = 100.0f;
        r5 = this;
        goto L35
    L81:
        r111.reset();
        int r35 = r112.size() - 1;
    L82:
        if (r35 < 0) goto L84;
        r111.addPath(((n) r112.get(r35)).getPath(), r21);
        r35 = r35 - 1;
        goto L82
    L84:
        com.airbnb.lottie.c.a();
        r20.drawPath(r111, r18);
        com.airbnb.lottie.c.a();
        goto L85
    L86:
        com.airbnb.lottie.c.a();
        return;
    L14:
        float r121 = u.f.d(r21);
        int r122 = 0;
    L15:
        int r123 = r19.size();
        float[] r124 = r5.f18487h;
        if (r122 >= r123) goto L26;
        float r125 = ((Float) ((l.d) r19.get(r122)).f()).floatValue();
        r124[r122] = r125;
        if ((r122 % 2) != 0) goto L23;
        if (r125 >= 1.0f) goto L25;
        r124[r122] = 1.0f;
    L25:
        r124[r122] = r124[r122] * r121;
        r122 = r122 + 1;
        goto L15
    L23:
        if (r125 >= 0.1f) goto L25;
        r124[r122] = 0.1f;
        goto L25
    L26:
        l.f r36 = r5.f18492m;
        if (r36 != null) goto L29;
        float r37 = 0.0f;
    L30:
        r18.setPathEffect(new DashPathEffect(r124, r37));
        com.airbnb.lottie.c.a();
        goto L31
    L29:
        r37 = ((Float) r36.f()).floatValue() * r121;
        goto L30
    }
}
