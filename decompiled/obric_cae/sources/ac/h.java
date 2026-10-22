package ac;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements b {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public Paint J;
    public float K;
    public Paint L;
    public int M;
    public float[] N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public RectF T;
    public int U;
    public int V;
    public int W;
    public WeakReference<View> X;
    public boolean Y;
    public final Path Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f290a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f291a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f292b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f293b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f294c0;
    public int d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f295e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f296f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f297g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f298h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final AttributeSet f299i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final int f300j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final int f301k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f302l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f303m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public n f304m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f305n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public n f306n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f307o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public float f308o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f309p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f310q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f311r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f312s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f313t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f314u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f315v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f316w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f317x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f318y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f319z;

    public h(Context r8, AttributeSet r10, int r11, int r12) {
        this.f292b = 0;
        this.f303m = 0;
        this.f305n = 0;
        this.f307o = 0;
        this.f309p = 0;
        this.f310q = 0;
        this.f311r = 0;
        this.f313t = 255;
        this.f314u = 0;
        this.f315v = 0;
        this.f316w = 0;
        this.f318y = 255;
        this.f319z = 0;
        this.A = 0;
        this.B = 0;
        this.D = 255;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.I = 255;
        this.K = 1.0f;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.U = 0;
        this.V = 1;
        this.W = 0;
        this.Y = false;
        this.Z = new Path();
        this.f291a0 = true;
        this.f293b0 = 0;
        this.d0 = -16777216;
        this.f295e0 = 0;
        this.f296f0 = 0;
        this.f297g0 = 0;
        this.f298h0 = 0;
        this.f302l0 = false;
        this.f304m0 = new n(Color.parseColor("#00000000"));
        this.f306n0 = new n(Color.parseColor("#00000000"));
        this.f308o0 = 0.0f;
        this.f290a = r8;
        this.f299i0 = r10;
        this.f300j0 = r11;
        this.f301k0 = r12;
    }

    public static ArrayList j(Context r10, int r11) {
        ArrayList r8 = new ArrayList();
        TypedArray r12 = r10.obtainStyledAttributes(r11, nb.a.f9509w);
        n r13 = new n(Color.parseColor("#00000000"));
        n r14 = new n(Color.parseColor("#00000000"));
        p(r12, r13, 13, 12, 10, 11, 14);
        p(r12, r14, 35, 34, 32, 33, 36);
        r12.recycle();
        r8.add(r13);
        r8.add(r14);
        return r8;
    }

    public static void p(TypedArray r8, n r10, int r11, int r12, int r13, int r14, int r15) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.f334a = r8.getColor(r11, Color.parseColor("#00000000"));
        r10.f335b = r8.getDimension(r12, 0.0f);
        r10.f336c = r8.getDimension(r13, 0.0f);
        r10.f337d = r8.getDimension(r14, 0.0f);
        r10.f338e = r8.getDimension(r15, 0.0f);
    }

    public final void A(n r8, n r10) {
        this.f304m0 = r8;
        this.f306n0 = r10;
        View r11 = this.X.get();
        if (r11 == null) goto L7;
        r11.invalidate();
        return;
    }

    public final void B(float r8) {
        if (this.f294c0 != r8) goto L5;
        return;
    L5:
        this.f294c0 = r8;
        View r10 = this.X.get();
        if (r10 == null) goto L14;
        int r11 = this.f293b0;
        if (r11 != 0) goto L11;
        float r12 = 0.0f;
    L12:
        r10.setElevation(r12);
        r10.invalidateOutline();
        return;
    L11:
        r12 = r11;
        goto L12
    }

    public final void C(int r8) {
        if (this.d0 != r8) goto L5;
        return;
    L5:
        this.d0 = r8;
        View r10 = this.X.get();
        if (r10 == null) goto L10;
        r10.setOutlineAmbientShadowColor(r8);
        r10.setOutlineSpotShadowColor(r8);
        return;
    }

    public final void D(int r8) {
        if (this.f293b0 != r8) goto L5;
        return;
    L5:
        this.f293b0 = r8;
        View r10 = this.X.get();
        if (r10 == null) goto L14;
        int r11 = this.f293b0;
        if (r11 != 0) goto L11;
        float r12 = 0.0f;
    L12:
        r10.setElevation(r12);
        r10.invalidateOutline();
        return;
    L11:
        r12 = r11;
        goto L12
    }

    public final void E(int r8) {
        if (r8 != 0) goto L4;
        return;
    L4:
        a(this.f290a, r8);
    }

    public final void F(boolean r8) {
        this.f291a0 = r8;
        View r10 = this.X.get();
        if (r10 == null) goto L7;
        r10.invalidate();
        return;
    }

    public final void G(int r8) {
        this.f313t = r8;
        q();
    }

    public final void H(int r8, int r10, int r11) {
        this.f315v = r8;
        this.f316w = 0;
        this.f317x = r11;
        this.f314u = r10;
        q();
    }

    public final void a(Context r10, int r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, nb.a.f9509w);
        p(r12, this.f304m0, 13, 12, 10, 11, 14);
        p(r12, this.f306n0, 35, 34, 32, 33, 36);
        r12.recycle();
    }

    public final void b(Canvas r13) {
        View r8 = this.X.get();
        if (r8 != null) goto L5;
        return;
    L5:
        int r10 = m();
        if (this.V > 0) goto L8;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == true) goto L14;
        return;
    L14:
        if (this.f291a0 == true) goto L16;
    L18:
        int r12 = r13.getWidth();
        int r14 = r13.getHeight();
        r13.save();
        r13.translate(r8.getScrollX(), r8.getScrollY());
        float r15 = this.V / 2.0f;
        if (this.Y == false) goto L21;
        this.T.set(r8.getPaddingLeft() + r15, r8.getPaddingTop() + r15, (r12 - r8.getPaddingRight()) - r15, (r14 - r8.getPaddingBottom()) - r15);
    L23:
        if (this.S == true) goto L25;
    L28:
        if (r11 == false) goto L36;
        this.L.setColor(this.U);
        this.L.setStrokeWidth(this.V);
        this.L.setStyle(Paint.Style.STROKE);
        if (this.S == false) goto L32;
        RectF r16 = this.T;
        float[] r17 = this.N;
        Paint r18 = this.L;
        Path r19 = this.Z;
        r19.reset();
        r19.addRoundRect(r16, r17, Path.Direction.CW);
        r13.drawPath(r19, r18);
        goto L36
    L32:
        RectF r20 = this.T;
        Paint r110 = this.L;
        if (r10 > 0) goto L35;
        r13.drawRect(r20, r110);
        goto L36
    L35:
        o.e(r13, r20, r10 * 1.0f, r110);
    L36:
        r13.restore();
        return;
    L25:
        if (this.N != null) goto L27;
        this.N = new float[8];
    L27:
        float[] r21 = this.N;
        float r22 = this.O;
        r21[0] = r22;
        r21[1] = r22;
        float r23 = this.P;
        r21[2] = r23;
        r21[3] = r23;
        float r24 = this.Q;
        r21[4] = r24;
        r21[5] = r24;
        float r25 = this.R;
        r21[6] = r25;
        r21[7] = r25;
        goto L28
    L21:
        this.T.set(r15, r15, r12 - r15, r14 - r15);
        goto L23
    L16:
        if (this.f293b0 == 0) goto L18;
        return;
    L8:
        if (this.U == 0) goto L10;
        r11 = true;
        goto L11
    }

    @Override // ac.b
    public final boolean c() {
        return false;
    }

    public final void d(Canvas r8) {
        View r10 = this.X.get();
        if (r10 != null) goto L5;
        return;
    L5:
        n r11 = this.f304m0;
        boolean r12 = true;
        if (r11 != null) goto L8;
    L10:
        boolean r13 = false;
    L11:
        n r14 = this.f306n0;
        if (r14 != null) goto L14;
    L16:
        r12 = false;
    L17:
        if (r13 == true) goto L21;
        if (r12 == true) goto L21;
    L28:
        if (r10.isHardwareAccelerated() == false) goto L31;
        return;
    L31:
        if (this.S == false) goto L33;
        return;
    L33:
        Drawable r15 = r10.getBackground();
        Context r16 = this.f290a;
        if (r15 != null) goto L36;
    L38:
        Drawable r17 = r10.getForeground();
        if (r17 != null) goto L41;
        return;
    L41:
        if ((r17 instanceof m) == true) goto L45;
        m r18 = new m(r17, r16.getResources().getDisplayMetrics());
        r18.f332n = this.M;
        r10.setForeground(r18);
        return;
    L45:
        return;
    L36:
        if ((r15 instanceof m) == true) goto L38;
        m r19 = new m(r15, r16.getResources().getDisplayMetrics());
        r19.f332n = this.M;
        r10.setBackground(r19);
    L21:
        if (this.M == 0) goto L23;
    L26:
        Log.e("OUILayoutHelper", " 阴影和圆角同时存在阴影不生效");
        goto L28
    L23:
        if (this.S == true) goto L26;
        i(r8, this.f304m0);
        i(r8, this.f306n0);
        goto L28
    L14:
        if (r14.a() == false) goto L16;
    L8:
        if (r11.a() == false) goto L10;
        r13 = true;
        goto L11
    }

    @Override // ac.b
    public final void e(int r8) {
    }

    @Override // ac.b
    public final boolean f() {
        return false;
    }

    @Override // ac.b
    public final void g(float r8) {
        if (this.K == r8) goto L9;
        this.K = r8;
        View r10 = this.X.get();
        if (r10 == null) goto L10;
        r10.invalidate();
        return;
    L10:
        return;
    }

    public final void h(Canvas r12, int r13, int r14) {
        View r8 = this.X.get();
        if (r8 != null) goto L6;
        return;
    L6:
        if (this.J == null) goto L8;
    L16:
        r12.save();
        r12.translate(r8.getScrollX(), r8.getScrollY());
        int r10 = this.f309p;
        if (r10 <= 0) goto L22;
        this.J.setStrokeWidth(r10);
        this.J.setColor(t2.b.h(this.f312s, this.K));
        int r11 = this.f313t;
        if (r11 >= 255) goto L21;
        this.J.setAlpha(r11);
    L21:
        float r15 = this.f309p / 2.0f;
        r12.drawLine(this.f310q, r15, r13 - this.f311r, r15, this.J);
    L22:
        int r16 = this.f314u;
        if (r16 <= 0) goto L28;
        this.J.setStrokeWidth(r16);
        this.J.setColor(t2.b.h(this.f317x, this.K));
        int r17 = this.f318y;
        if (r17 >= 255) goto L27;
        this.J.setAlpha(r17);
    L27:
        float r18 = (float) Math.floor(r14 - (this.f314u / 2.0f));
        r12.drawLine(this.f315v, r18, r13 - this.f316w, r18, this.J);
    L28:
        int r19 = this.f319z;
        if (r19 <= 0) goto L34;
        this.J.setStrokeWidth(r19);
        this.J.setColor(t2.b.h(this.C, this.K));
        int r20 = this.D;
        if (r20 >= 255) goto L33;
        this.J.setAlpha(r20);
    L33:
        float r21 = this.f319z / 2.0f;
        r12.drawLine(r21, this.A, r21, r14 - this.B, this.J);
    L34:
        int r22 = this.E;
        if (r22 <= 0) goto L40;
        this.J.setStrokeWidth(r22);
        this.J.setColor(t2.b.h(this.H, this.K));
        int r23 = this.I;
        if (r23 >= 255) goto L39;
        this.J.setAlpha(r23);
    L39:
        float r24 = (float) Math.floor(r13 - (this.E / 2.0f));
        r12.drawLine(r24, this.F, r24, r14 - this.G, this.J);
    L40:
        r12.restore();
        return;
    L8:
        if (this.f309p <= 0) goto L10;
    L15:
        this.J = new Paint();
        goto L16
    L10:
        if (this.f314u > 0) goto L15;
        if (this.f319z > 0) goto L15;
        if (this.E <= 0) goto L16;
        goto L15
    }

    public final void i(Canvas r8, n r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        float r11 = r10.f340g;
        if (r11 > 0.0f) goto L8;
        r11 = this.f308o0;
    L8:
        View r12 = this.X.get();
        Path r13 = new Path();
        RectF r14 = new RectF(0.0f, 0.0f, r12.getWidth(), r12.getHeight());
        r13.addPath(o.b(r11, r14));
        int r15 = r8.save();
        RectF r16 = new RectF(r14);
        r16.offset(r10.f336c, r10.f337d);
        float r17 = -r10.f338e;
        r16.inset(r17, r17);
        r8.clipOutPath(r13);
        int r18 = r10.f334a;
        Paint r19 = r10.f339f;
        r19.setColor(r18);
        if (r10.f335b <= 0.0f) goto L11;
        r19.setMaskFilter(new BlurMaskFilter(r10.f335b, BlurMaskFilter.Blur.NORMAL));
    L11:
        o.e(r8, r16, r11, r19);
        r8.restoreToCount(r15);
    }

    public final int k(int r8) {
        if (this.f303m > 0) goto L5;
        return r8;
    L5:
        if (View.MeasureSpec.getSize(r8) <= this.f303m) goto L12;
        int r10 = View.MeasureSpec.getMode(r8);
        int r11 = this.f303m;
        if (r10 != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(r11, 1073741824);
    L12:
        return r8;
    }

    public final int l(int r8) {
        if (this.f292b > 0) goto L5;
        return r8;
    L5:
        if (View.MeasureSpec.getSize(r8) <= this.f292b) goto L12;
        int r10 = View.MeasureSpec.getMode(r8);
        int r11 = this.f292b;
        if (r10 != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(r11, 1073741824);
    L12:
        return r8;
    }

    public final int m() {
        View r8 = this.X.get();
        int r10 = this.M;
        if (r8 != null) goto L6;
        return r10;
    L6:
        if (r10 != (-1)) goto L10;
        int r11 = r8.getHeight();
    L12:
        return r11 / 2;
    L10:
        if (r10 != (-2)) goto L13;
        r11 = r8.getWidth();
        goto L12
    L13:
        return r10;
    }

    public final int n(int r8, int r10) {
        if (View.MeasureSpec.getMode(r8) == 1073741824) goto L8;
        int r11 = this.f307o;
        if (r10 >= r11) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r11, 1073741824);
    L8:
        return r8;
    }

    public final int o(int r8, int r10) {
        if (View.MeasureSpec.getMode(r8) == 1073741824) goto L8;
        int r11 = this.f305n;
        if (r10 >= r11) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r11, 1073741824);
    L8:
        return r8;
    }

    public final void q() {
        View r8 = this.X.get();
        if (r8 == null) goto L6;
        r8.invalidate();
        return;
    }

    public final void r(int r8) {
        this.U = r8;
        q();
    }

    public final void s(int r8) {
        this.V = r8;
        q();
    }

    @Override // ac.b
    public final void setWidthMin(int r8) {
        this.f305n = r8;
    }

    public final void t(int r8) {
        this.f318y = r8;
        q();
    }

    public final void u(int r8) {
        this.D = r8;
        q();
    }

    public final void v(int r8) {
        this.W = r8;
        q();
    }

    public final void w(boolean r8) {
        View r10 = this.X.get();
        if (r10 != null) goto L5;
        return;
    L5:
        this.Y = r8;
        r10.invalidateOutline();
    }

    public final void x(int r8) {
        if (this.M == r8) goto L6;
        int r10 = this.f293b0;
        y(this.f294c0, r8, r10);
        return;
    }

    public final void y(float r8, int r10, int r11) {
        int r12 = this.d0;
        View r13 = this.X.get();
        if (r13 == null) goto L37;
        this.M = r10;
        if (this.f308o0 != 0.0f) goto L8;
        this.f308o0 = r10;
    L8:
        boolean r14 = false;
        if (this.Q <= 0) goto L11;
    L18:
        boolean r15 = true;
    L19:
        this.S = r15;
        this.f293b0 = r11;
        this.f294c0 = r8;
        this.d0 = r12;
        if (r11 == 0) goto L24;
        if (r15 == true) goto L24;
        r13.setElevation(r11);
    L25:
        int r16 = this.d0;
        View r17 = this.X.get();
        if (r17 == null) goto L29;
        r17.setOutlineAmbientShadowColor(r16);
        r17.setOutlineSpotShadowColor(r16);
    L29:
        r13.setOutlineProvider(new g(this));
        int r18 = this.M;
        if (r18 != (-2)) goto L32;
    L34:
        r14 = true;
    L35:
        r13.setClipToOutline(r14);
        r13.invalidate();
        return;
    L32:
        if (r18 == (-1)) goto L34;
        if (r18 <= 0) goto L35;
    L24:
        r13.setElevation(0.0f);
        goto L25
    L11:
        if (this.P > 0) goto L18;
        if (this.O > 0) goto L18;
        if (this.R > 0) goto L18;
        r15 = false;
        goto L19
    }

    public final void z(int r8) {
        this.I = r8;
        q();
    }
}
