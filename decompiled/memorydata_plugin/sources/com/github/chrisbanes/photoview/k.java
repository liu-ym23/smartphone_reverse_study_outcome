package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class k implements View.OnLayoutChangeListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f3729a = 3.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static float f3730b = 1.75f;
    private static float c = 1.0f;
    private static int d = 200;
    private static int e = 1;
    private g A;
    private h B;
    private i C;
    private b D;
    private int E;
    private int F;
    private float G;
    private boolean H;
    private ImageView.ScaleType I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private c f3731J;
    private Interpolator f;
    private int g;
    private float h;
    private float i;
    private float j;
    private boolean k;
    private boolean l;
    private ImageView m;
    private GestureDetector n;
    private com.github.chrisbanes.photoview.b o;
    private final Matrix p;
    private final Matrix q;
    private final Matrix r;
    private final RectF s;
    private final float[] t;
    private d u;
    private f v;
    private e w;
    private j x;
    private View.OnClickListener y;
    private View.OnLongClickListener z;

    /* JADX INFO: renamed from: com.github.chrisbanes.photoview.k$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3735a = null;

        static {
            int[] r0 = new int[ImageView.ScaleType.values().length];
            f3735a = r0;
            r0[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f3735a[ImageView.ScaleType.FIT_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f3735a[ImageView.ScaleType.FIT_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f3735a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f3736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f3737b;
        private final float c;
        private final long d;
        private final float e;
        private final float f;

        public a(k r1, float r2, float r3, float r4, float r5) {
            this.f3736a = r1;
            this.f3737b = r4;
            this.c = r5;
            this.d = System.currentTimeMillis();
            this.e = r2;
            this.f = r3;
        }

        private float a() {
            return k.u(this.f3736a).getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.d) * 1.0f) / k.t(this.f3736a)));
        }

        @Override // java.lang.Runnable
        public void run() {
            float r0 = a();
            float r1 = this.e;
            float r2 = (r1 + ((this.f - r1) * r0)) / this.f3736a.e();
            k.s(this.f3736a).a(r2, this.f3737b, this.c);
            if (r0 >= 1.0f) goto L6;
            com.github.chrisbanes.photoview.a.a(k.e(this.f3736a), this);
            return;
        }
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f3738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OverScroller f3739b;
        private int c;
        private int d;

        public b(k r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.f3738a = r3;
            this.f3739b = new OverScroller(r5);
        }

        public void a() {
            this.f3739b.forceFinished(true);
        }

        public void a(int r15, int r16, int r17, int r18) {
            RectF r1 = this.f3738a.a();
            if (r1 != null) goto L5;
            return;
        L5:
            int r4 = Math.round(-r1.left);
            float r2 = r15;
            if (r2 >= r1.width()) goto L8;
            int r9 = Math.round(r1.width() - r2);
            int r8 = 0;
        L9:
            int r3 = Math.round(-r1.top);
            float r5 = r16;
            if (r5 >= r1.height()) goto L12;
            int r11 = Math.round(r1.height() - r5);
            int r10 = 0;
        L13:
            this.c = r4;
            this.d = r3;
            if (r4 != r9) goto L16;
            if (r3 != r11) goto L16;
            return;
        L16:
            this.f3739b.fling(r4, r3, r17, r18, r8, r9, r10, r11, 0, 0);
            return;
        L12:
            r10 = r3;
            r11 = r10;
            goto L13
        L8:
            r8 = r4;
            r9 = r8;
            goto L9
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3739b.isFinished() == false) goto L6;
            return;
        L6:
            if (this.f3739b.computeScrollOffset() == false) goto L9;
            int r0 = this.f3739b.getCurrX();
            int r1 = this.f3739b.getCurrY();
            k.c(this.f3738a).postTranslate(this.c - r0, this.d - r1);
            k.d(this.f3738a);
            this.c = r0;
            this.d = r1;
            com.github.chrisbanes.photoview.a.a(k.e(this.f3738a), this);
            return;
        }
    }

    static {
    }

    public k(ImageView r5) {
        this.f = new AccelerateDecelerateInterpolator();
        this.g = d;
        this.h = c;
        this.i = f3730b;
        this.j = f3729a;
        this.k = true;
        this.l = false;
        this.p = new Matrix();
        this.q = new Matrix();
        this.r = new Matrix();
        this.s = new RectF();
        this.t = new float[9];
        this.E = 2;
        this.F = 2;
        this.H = true;
        this.I = ImageView.ScaleType.FIT_CENTER;
        this.f3731J = new AnonymousClass1(this);
        this.m = r5;
        r5.setOnTouchListener(this);
        r5.addOnLayoutChangeListener(this);
        if (r5.isInEditMode() == false) goto L5;
        return;
    L5:
        this.G = 0.0f;
        this.o = new com.github.chrisbanes.photoview.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.f3731J);
        GestureDetector r0 = new GestureDetector((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), new AnonymousClass2(this));
        this.n = r0;
        r0.setOnDoubleTapListener(new AnonymousClass3(this));
    }

    private float a(Matrix r2, int r3) {
        r2.getValues(this.t);
        return this.t[r3];
    }

    private int a(ImageView r2) {
        return (r2.getWidth() - r2.getPaddingLeft()) - r2.getPaddingRight();
    }

    static /* synthetic */ int a(k r0, ImageView r1) {
        return r0.a(r1);
    }

    static /* synthetic */ com.github.chrisbanes.photoview.b a(k r0) {
        return r0.o;
    }

    static /* synthetic */ b a(k r0, b r1) {
        r0.D = r1;
        return r1;
    }

    private void a(Drawable r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        float r0 = a(this.m);
        float r1 = b(this.m);
        int r2 = r9.getIntrinsicWidth();
        int r10 = r9.getIntrinsicHeight();
        this.p.reset();
        float r3 = r2;
        float r4 = r0 / r3;
        float r11 = r10;
        float r5 = r1 / r11;
        if (this.I != ImageView.ScaleType.CENTER) goto L8;
        this.p.postTranslate((r0 - r3) / 2.0f, (r1 - r11) / 2.0f);
    L31:
        l();
        return;
    L8:
        if (this.I != ImageView.ScaleType.CENTER_CROP) goto L12;
        float r6 = Math.max(r4, r5);
    L10:
        this.p.postScale(r6, r6);
        this.p.postTranslate((r0 - (r3 * r6)) / 2.0f, (r1 - (r11 * r6)) / 2.0f);
        goto L31
    L12:
        if (this.I != ImageView.ScaleType.CENTER_INSIDE) goto L14;
        r6 = Math.min(1.0f, Math.min(r4, r5));
        goto L10
    L14:
        RectF r7 = new RectF(0.0f, 0.0f, r3, r11);
        RectF r8 = new RectF(0.0f, 0.0f, r0, r1);
        if ((((int) this.G) % SubsamplingScaleImageView.ORIENTATION_180) == 0) goto L17;
        r7 = new RectF(0.0f, 0.0f, r11, r3);
    L17:
        int r12 = AnonymousClass4.f3735a[this.I.ordinal()];
        if (r12 != 1) goto L20;
        Matrix r13 = this.p;
        Matrix.ScaleToFit r14 = Matrix.ScaleToFit.CENTER;
    L30:
        r13.setRectToRect(r7, r8, r14);
        goto L31
    L20:
        if (r12 != 2) goto L22;
        r13 = this.p;
        r14 = Matrix.ScaleToFit.START;
        goto L30
    L22:
        if (r12 != 3) goto L24;
        r13 = this.p;
        r14 = Matrix.ScaleToFit.END;
        goto L30
    L24:
        if (r12 != 4) goto L31;
        r13 = this.p;
        r14 = Matrix.ScaleToFit.FILL;
        goto L30
    }

    private int b(ImageView r2) {
        return (r2.getHeight() - r2.getPaddingTop()) - r2.getPaddingBottom();
    }

    static /* synthetic */ int b(k r0, ImageView r1) {
        return r0.b(r1);
    }

    static /* synthetic */ i b(k r0) {
        return r0.C;
    }

    static /* synthetic */ Matrix c(k r0) {
        return r0.r;
    }

    private void d(Matrix r2) {
        this.m.setImageMatrix(r2);
        if (this.u == null) goto L8;
        RectF r3 = e(r2);
        if (r3 == null) goto L9;
        this.u.onMatrixChanged(r3);
        return;
    L9:
        return;
    }

    static /* synthetic */ void d(k r0) {
        r0.m();
    }

    private RectF e(Matrix r5) {
        Drawable r0 = this.m.getDrawable();
        if (r0 == null) goto L6;
        this.s.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        r5.mapRect(this.s);
        return this.s;
    L6:
        return null;
    }

    static /* synthetic */ ImageView e(k r0) {
        return r0.m;
    }

    static /* synthetic */ boolean f(k r0) {
        return r0.k;
    }

    static /* synthetic */ boolean g(k r0) {
        return r0.l;
    }

    static /* synthetic */ int h(k r0) {
        return r0.E;
    }

    static /* synthetic */ float i() {
        return c;
    }

    static /* synthetic */ int i(k r0) {
        return r0.F;
    }

    static /* synthetic */ int j() {
        return e;
    }

    static /* synthetic */ b j(k r0) {
        return r0.D;
    }

    static /* synthetic */ float k(k r0) {
        return r0.j;
    }

    private Matrix k() {
        this.q.set(this.p);
        this.q.postConcat(this.r);
        return this.q;
    }

    static /* synthetic */ g l(k r0) {
        return r0.A;
    }

    private void l() {
        this.r.reset();
        b(this.G);
        d(k());
        n();
    }

    static /* synthetic */ View.OnLongClickListener m(k r0) {
        return r0.z;
    }

    private void m() {
        if (n() == false) goto L6;
        d(k());
        return;
    }

    static /* synthetic */ h n(k r0) {
        return r0.B;
    }

    private boolean n() {
        RectF r0 = e(k());
        if (r0 != null) goto L5;
        return false;
    L5:
        float r2 = r0.height();
        float r3 = r0.width();
        float r4 = b(this.m);
        float r11 = 0.0f;
        if (r2 > r4) goto L16;
        int r5 = AnonymousClass4.f3735a[this.I.ordinal()];
        if (r5 == 2) goto L13;
        float r6 = r4 - r2;
        if (r5 == 3) goto L12;
        r6 = r6 / 2.0f;
    L12:
        float r7 = r6 - r0.top;
    L14:
        this.F = 2;
    L22:
        float r8 = a(this.m);
        if (r3 > r8) goto L33;
        int r1 = AnonymousClass4.f3735a[this.I.ordinal()];
        if (r1 == 2) goto L30;
        float r9 = r8 - r3;
        if (r1 == 3) goto L29;
        r9 = r9 / 2.0f;
    L29:
        r11 = r9 - r0.left;
    L31:
        this.E = 2;
    L39:
        this.r.postTranslate(r11, r7);
        return true;
    L30:
        r11 = -r0.left;
        goto L31
    L33:
        if (r0.left <= 0.0f) goto L36;
        this.E = 0;
        r11 = -r0.left;
        goto L39
    L36:
        if (r0.right >= r8) goto L38;
        r11 = r8 - r0.right;
        this.E = 1;
        goto L39
    L38:
        this.E = -1;
        goto L39
    L13:
        r7 = -r0.top;
        goto L14
    L16:
        if (r0.top <= 0.0f) goto L19;
        this.F = 0;
        r7 = -r0.top;
        goto L22
    L19:
        if (r0.bottom >= r4) goto L21;
        this.F = 1;
        r7 = r4 - r0.bottom;
        goto L22
    L21:
        this.F = -1;
        r7 = 0.0f;
        goto L22
    }

    static /* synthetic */ View.OnClickListener o(k r0) {
        return r0.y;
    }

    private void o() {
        b r0 = this.D;
        if (r0 == null) goto L6;
        r0.a();
        this.D = null;
        return;
    }

    static /* synthetic */ j p(k r0) {
        return r0.x;
    }

    static /* synthetic */ f q(k r0) {
        return r0.v;
    }

    static /* synthetic */ e r(k r0) {
        return r0.w;
    }

    static /* synthetic */ c s(k r0) {
        return r0.f3731J;
    }

    static /* synthetic */ int t(k r0) {
        return r0.g;
    }

    static /* synthetic */ Interpolator u(k r0) {
        return r0.f;
    }

    public RectF a() {
        n();
        return e(k());
    }

    public void a(float r3) {
        this.r.setRotate(r3 % 360.0f);
        m();
    }

    public void a(float r1, float r2, float r3) {
        l.a(r1, r2, r3);
        this.h = r1;
        this.i = r2;
        this.j = r3;
    }

    public void a(float r8, float r9, float r10, boolean r11) {
        if (r8 < this.h) goto L11;
        if (r8 > this.j) goto L11;
        if (r11 == false) goto L8;
        this.m.post(new a(this, e(), r8, r9, r10));
        return;
    L8:
        this.r.setScale(r8, r8, r9, r10);
        m();
        return;
    L11:
        throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
    }

    public void a(float r3, boolean r4) {
        a(r3, this.m.getRight() / 2, this.m.getBottom() / 2, r4);
    }

    public void a(int r1) {
        this.g = r1;
    }

    public void a(GestureDetector.OnDoubleTapListener r3) {
        GestureDetector.OnDoubleTapListener r4 = (GestureDetector.OnDoubleTapListener) ZeusTransformUtils.wrapperContextForParams(r3, GestureDetector.OnDoubleTapListener.class, "com.obric.memorydata.plugin");
        this.n.setOnDoubleTapListener(r4);
    }

    public void a(View.OnClickListener r3) {
        this.y = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
    }

    public void a(View.OnLongClickListener r3) {
        this.z = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.memorydata.plugin");
    }

    public void a(ImageView.ScaleType r2) {
        if (l.a(r2) == true) goto L5;
        return;
    L5:
        if (r2 == this.I) goto L9;
        this.I = r2;
        update();
        return;
    }

    public void a(d r3) {
        this.u = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
    }

    public void a(e r3) {
        this.w = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
    }

    public void a(f r3) {
        this.v = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
    }

    public void a(g r3) {
        this.A = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
    }

    public void a(h r3) {
        this.B = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
    }

    public void a(i r3) {
        this.C = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
    }

    public void a(j r3) {
        this.x = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
    }

    public void a(boolean r1) {
        this.k = r1;
    }

    public boolean a(Matrix r2) {
        if (r2 == null) goto L10;
        if (this.m.getDrawable() != null) goto L7;
        return false;
    L7:
        this.r.set(r2);
        m();
        return true;
    L10:
        throw new IllegalArgumentException("Matrix cannot be null");
    }

    public float b() {
        return this.h;
    }

    public void b(float r3) {
        this.r.postRotate(r3 % 360.0f);
        m();
    }

    public void b(Matrix r1) {
        r1.set(k());
    }

    public void b(boolean r1) {
        this.H = r1;
        update();
    }

    public float c() {
        return this.i;
    }

    public void c(float r3) {
        l.a(r3, this.i, this.j);
        this.h = r3;
    }

    public void c(Matrix r1) {
        r1.set(this.r);
    }

    public float d() {
        return this.j;
    }

    public void d(float r3) {
        l.a(this.h, r3, this.j);
        this.i = r3;
    }

    public float e() {
        return (float) Math.sqrt(((float) Math.pow(a(this.r, 0), 2.0d)) + ((float) Math.pow(a(this.r, 3), 2.0d)));
    }

    public void e(float r3) {
        l.a(this.h, this.i, r3);
        this.j = r3;
    }

    public ImageView.ScaleType f() {
        return this.I;
    }

    public void f(float r2) {
        a(r2, false);
    }

    public boolean g() {
        return this.H;
    }

    public Matrix h() {
        return this.q;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r2 != r6) goto L6;
        if (r3 != r7) goto L6;
        if (r4 != r8) goto L6;
        if (r5 != r9) goto L6;
        return;
    L6:
        a(this.m.getDrawable());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r11, MotionEvent r12) {
        boolean r1 = false;
        if (this.H == true) goto L5;
        return false;
    L5:
        if (l.a((ImageView) ZeusTransformUtils.preCheckCast(r11, ImageView.class, "com.obric.memorydata.plugin")) == false) goto L53;
        int r0 = r12.getAction();
        if (r0 == 0) goto L23;
        if (r0 == 1) goto L13;
        if (r0 == 3) goto L13;
    L27:
        boolean r13 = false;
    L28:
        com.github.chrisbanes.photoview.b r2 = this.o;
        if (r2 == null) goto L45;
        boolean r14 = r2.a();
        boolean r3 = this.o.b();
        boolean r4 = this.o.a(r12);
        if (r14 == false) goto L33;
    L35:
        boolean r15 = false;
    L36:
        if (r3 == false) goto L38;
    L40:
        boolean r5 = false;
    L41:
        if (r15 == false) goto L44;
        if (r5 == false) goto L44;
        r1 = true;
    L44:
        this.l = r1;
        boolean r6 = r4;
    L46:
        GestureDetector r10 = this.n;
        if (r10 != null) goto L49;
        return r6;
    L49:
        if (r10.onTouchEvent(r12) == true) goto L51;
        return r6;
    L51:
        return true;
    L38:
        if (this.o.b() == true) goto L40;
        r5 = true;
        goto L41
    L33:
        if (this.o.a() == true) goto L35;
        r15 = true;
        goto L36
    L45:
        r6 = r13;
    L13:
        if (e() >= this.h) goto L18;
        RectF r7 = a();
        if (r7 == null) goto L27;
        a r9 = new a(this, e(), this.h, r7.centerX(), r7.centerY());
    L22:
        r11.post(r9);
        r13 = true;
        goto L28
    L18:
        if (e() <= this.j) goto L27;
        RectF r8 = a();
        if (r8 == null) goto L27;
        r9 = new a(this, e(), this.j, r8.centerX(), r8.centerY());
        goto L22
    L23:
        ViewParent r16 = r11.getParent();
        if (r16 == null) goto L26;
        r16.requestDisallowInterceptTouchEvent(true);
    L26:
        o();
        goto L27
    L53:
        return false;
    }

    public void update() {
        if (this.H == false) goto L5;
        a(this.m.getDrawable());
        return;
    L5:
        l();
    }
}
