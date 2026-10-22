package k;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h implements e, l.a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r.c f18513c;
    public final LongSparseArray d;
    public final LongSparseArray e;
    public final Path f;
    public final j.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f18514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f18515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GradientType f18516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l.g f18517k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l.e f18518l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l.g f18519m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final l.g f18520n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public l.n f18521o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public l.n f18522p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final w f18523q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f18524r;

    public h(w r5, r.c r10, q.d r11) {
        this.d = new LongSparseArray();
        this.e = new LongSparseArray();
        Path r12 = new Path();
        this.f = r12;
        this.g = new j.a(1, 0);
        this.f18514h = new RectF();
        this.f18515i = new ArrayList();
        this.f18513c = r10;
        this.f18511a = r11.g;
        this.f18512b = r11.f21399h;
        this.f18523q = r5;
        this.f18516j = r11.f21396a;
        r12.setFillType(r11.f21397b);
        this.f18524r = (int) (r5.f1340b.b() / 32.0f);
        l.d r13 = r11.f21398c.d();
        this.f18517k = (l.g) r13;
        r13.a(this);
        r10.f(r13);
        l.d r14 = r11.d.d();
        this.f18518l = (l.e) r14;
        r14.a(this);
        r10.f(r14);
        l.d r15 = r11.e.d();
        this.f18519m = (l.g) r15;
        r15.a(this);
        r10.f(r15);
        l.d r16 = r11.f.d();
        this.f18520n = (l.g) r16;
        r16.a(this);
        r10.f(r16);
    }

    @Override // l.a
    public final void a() {
        this.f18523q.invalidateSelf();
    }

    @Override // k.c
    public final void b(List r5, List r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.size()) goto L9;
        c r12 = (c) r10.get(r11);
        if ((r12 instanceof n) == false) goto L8;
        this.f18515i.add((n) r12);
    L8:
        r11 = r11 + 1;
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // o.f
    public final void c(ColorFilter r5, v.c r10) {
        PointF r11 = z.f1356a;
        if (r5 != 4) goto L5;
        this.f18518l.j(r10);
        return;
    L5:
        ColorFilter r12 = z.f1375y;
        r.c r13 = this.f18513c;
        if (r5 != r12) goto L9;
        l.n r14 = new l.n(r10, null);
        this.f18521o = r14;
        r14.a(this);
        r13.f(this.f18521o);
        return;
    L9:
        if (r5 != z.f1376z) goto L14;
        l.n r15 = new l.n(r10, null);
        this.f18522p = r15;
        r15.a(this);
        r13.f(this.f18522p);
        return;
    }

    @Override // o.f
    public final void d(o.e r5, int r10, ArrayList r11, o.e r12) {
        u.e.e(r5, r10, r11, r12, this);
    }

    @Override // k.e
    public final void e(RectF r5, Matrix r10, boolean r11) {
        Path r12 = this.f;
        r12.reset();
        int r13 = 0;
    L3:
        ArrayList r14 = this.f18515i;
        if (r13 >= r14.size()) goto L6;
        r12.addPath(((n) r14.get(r13)).getPath(), r10);
        r13 = r13 + 1;
        goto L3
    L6:
        r12.computeBounds(r5, false);
        r5.set(r5.left - 1.0f, r5.top - 1.0f, r5.right + 1.0f, r5.bottom + 1.0f);
    }

    public final int[] f(int[] r5) {
        l.n r10 = this.f18522p;
        if (r10 == null) goto L13;
        Integer[] r11 = (Integer[]) r10.f();
        int r12 = 0;
        if (r5.length == r11.length) goto L7;
        r5 = new int[r11.length];
    L11:
        if (r12 >= r11.length) goto L13;
        r5[r12] = r11[r12].intValue();
        r12 = r12 + 1;
    L7:
        if (r12 >= r5.length) goto L13;
        r5[r12] = r11[r12].intValue();
        r12 = r12 + 1;
    L13:
        return r5;
    }

    @Override // k.e
    public final void g(Canvas r20, Matrix r21, int r22) {
        if (this.f18512b == false) goto L5;
        return;
    L5:
        Path r5 = this.f;
        r5.reset();
        int r10 = 0;
    L6:
        ArrayList r11 = this.f18515i;
        if (r10 >= r11.size()) goto L9;
        r5.addPath(((n) r11.get(r10)).getPath(), r21);
        r10 = r10 + 1;
        goto L6
    L9:
        r5.computeBounds(this.f18514h, false);
        GradientType r12 = GradientType.LINEAR;
        GradientType r13 = this.f18516j;
        l.g r14 = this.f18517k;
        l.g r15 = this.f18520n;
        l.g r16 = this.f18519m;
        if (r13 != r12) goto L15;
        long r17 = h();
        LongSparseArray r18 = this.d;
        Shader r19 = (LinearGradient) r18.get(r17);
        if (r19 != null) goto L22;
        PointF r23 = (PointF) r16.f();
        PointF r24 = (PointF) r15.f();
        q.c r25 = (q.c) r14.f();
        int[] r110 = f(r25.f21395b);
        r19 = new LinearGradient(r23.x, r23.y, r24.x, r24.y, r110, r25.f21394a, Shader.TileMode.CLAMP);
        r18.put(r17, r19);
    L22:
        r19.setLocalMatrix(r21);
        j.a r26 = this.g;
        r26.setShader(r19);
        l.n r27 = this.f18521o;
        if (r27 == null) goto L25;
        r26.setColorFilter((ColorFilter) r27.f());
    L25:
        int r28 = (int) ((((r22 / 255.0f) * ((Integer) this.f18518l.f()).intValue()) / 100.0f) * 255.0f);
        PointF r29 = u.e.f22190a;
        r26.setAlpha(Math.max(0, Math.min(255, r28)));
        r20.drawPath(r5, r26);
        com.airbnb.lottie.c.a();
        return;
    L15:
        long r30 = h();
        LongSparseArray r31 = this.e;
        r19 = (RadialGradient) r31.get(r30);
        if (r19 != null) goto L22;
        PointF r32 = (PointF) r16.f();
        PointF r33 = (PointF) r15.f();
        q.c r34 = (q.c) r14.f();
        int[] r111 = f(r34.f21395b);
        float r112 = r32.x;
        float r113 = r32.y;
        float r35 = (float) Math.hypot(r33.x - r112, r33.y - r113);
        if (r35 > 0.0f) goto L21;
        r35 = 0.001f;
    L21:
        RadialGradient r36 = new RadialGradient(r112, r113, r35, r111, r34.f21394a, Shader.TileMode.CLAMP);
        r31.put(r30, r36);
        r19 = r36;
        goto L22
    }

    @Override // k.c
    public final String getName() {
        return this.f18511a;
    }

    public final int h() {
        float r5 = this.f18519m.d;
        float r10 = this.f18524r;
        int r11 = Math.round(r5 * r10);
        int r12 = Math.round(this.f18520n.d * r10);
        int r13 = Math.round(this.f18517k.d * r10);
        if (r11 == 0) goto L5;
        int r14 = 527 * r11;
    L6:
        if (r12 == 0) goto L8;
        r14 = (r14 * 31) * r12;
    L8:
        if (r13 != 0) goto L10;
        return r14;
    L10:
        return (r14 * 31) * r13;
    L5:
        r14 = 17;
        goto L6
    }
}
