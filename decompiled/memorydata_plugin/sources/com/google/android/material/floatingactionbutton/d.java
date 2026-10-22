package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.h;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.google.android.material.shape.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final TimeInterpolator f3925a = null;
    static final int[] m = null;
    static final int[] n = null;
    static final int[] o = null;
    static final int[] p = null;
    static final int[] q = null;
    static final int[] r = null;
    private int A;
    private int B;
    private ArrayList<Animator.AnimatorListener> C;
    private ArrayList<Animator.AnimatorListener> D;
    private ArrayList<InterfaceC0184d> E;
    private final Rect F;
    private final RectF G;
    private final RectF H;
    private final Matrix I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private ViewTreeObserver.OnPreDrawListener f3926J;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    l f3927b;
    MaterialShapeDrawable c;
    Drawable d;
    com.google.android.material.floatingactionbutton.c e;
    Drawable f;
    boolean g;
    boolean h;
    float i;
    float j;
    float k;
    int l;
    final FloatingActionButton s;
    final com.google.android.material.h.b t;
    private final h u;
    private Animator v;
    private com.google.android.material.a.h w;
    private com.google.android.material.a.h x;
    private float y;
    private float z;

    private class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f3938a;

        a(d r2) {
            this.f3938a = r2;
            super(r2, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.g
        public float a() {
            return 0.0f;
        }
    }

    private class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f3939a;

        b(d r2) {
            this.f3939a = r2;
            super(r2, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.g
        public float a() {
            return this.f3939a.i + this.f3939a.j;
        }
    }

    private class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f3940a;

        c(d r2) {
            this.f3940a = r2;
            super(r2, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.g
        public float a() {
            return this.f3940a.i + this.f3940a.k;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.d$d, reason: collision with other inner class name */
    interface InterfaceC0184d {
        void a();

        void b();
    }

    interface e {
        void a();

        void b();
    }

    private class f extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f3941a;

        f(d r2) {
            this.f3941a = r2;
            super(r2, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.g
        public float a() {
            return this.f3941a.i;
        }
    }

    private abstract class g extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f3942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f3943b;
        private float c;
        private float d;

        private g(d r1) {
            this.f3943b = r1;
        }

        /* synthetic */ g(d r1, AnonymousClass1 r2) {
            this(r1);
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            this.f3943b.e((int) this.d);
            this.f3942a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r3) {
            if (this.f3942a == false) goto L5;
        L9:
            d r0 = this.f3943b;
            float r1 = this.c;
            r0.e((int) (r1 + ((this.d - r1) * r3.getAnimatedFraction())));
            return;
        L5:
            if (this.f3943b.c != null) goto L7;
            float r2 = 0.0f;
        L8:
            this.c = r2;
            this.d = a();
            this.f3942a = true;
            goto L9
        L7:
            r2 = this.f3943b.c.getElevation();
            goto L8
        }
    }

    static {
        f3925a = com.google.android.material.a.a.c;
        m = new int[]{R.attr.state_pressed, R.attr.state_enabled};
        n = new int[]{R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
        o = new int[]{R.attr.state_focused, R.attr.state_enabled};
        p = new int[]{R.attr.state_hovered, R.attr.state_enabled};
        q = new int[]{R.attr.state_enabled};
        r = new int[0];
    }

    d(FloatingActionButton r3, com.google.android.material.h.b r4) {
        com.google.android.material.h.b r5 = (com.google.android.material.h.b) ZeusTransformUtils.wrapperContextForParams(r4, com.google.android.material.h.b.class, "com.obric.memorydata.plugin");
        this.h = true;
        this.z = 1.0f;
        this.B = 0;
        this.F = new Rect();
        this.G = new RectF();
        this.H = new RectF();
        this.I = new Matrix();
        this.s = r3;
        this.t = r5;
        h r6 = new h();
        this.u = r6;
        r6.a(m, a(new c(this)));
        r6.a(n, a(new b(this)));
        r6.a(o, a(new b(this)));
        r6.a(p, a(new b(this)));
        r6.a(q, a(new f(this)));
        r6.a(r, a(new a(this)));
        this.y = r3.getRotation();
    }

    static /* synthetic */ float a(d r0, float r1) {
        r0.z = r1;
        return r1;
    }

    static /* synthetic */ int a(d r0, int r1) {
        r0.B = r1;
        return r1;
    }

    static /* synthetic */ Animator a(d r0, Animator r1) {
        r0.v = r1;
        return r1;
    }

    private AnimatorSet a(com.google.android.material.a.h r7, float r8, float r9, float r10) {
        ArrayList r0 = new ArrayList();
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this.s, View.ALPHA, new float[]{r8});
        r7.b("opacity").a(r11);
        r0.add(r11);
        ObjectAnimator r12 = ObjectAnimator.ofFloat(this.s, View.SCALE_X, new float[]{r9});
        r7.b("scale").a(r12);
        a(r12);
        r0.add(r12);
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this.s, View.SCALE_Y, new float[]{r9});
        r7.b("scale").a(r13);
        a(r13);
        r0.add(r13);
        a(r10, this.I);
        ObjectAnimator r6 = ObjectAnimator.ofObject(this.s, new com.google.android.material.a.f(), new AnonymousClass3(this), new Matrix[]{new Matrix(this.I)});
        r7.b("iconScale").a(r6);
        r0.add(r6);
        AnimatorSet r14 = new AnimatorSet();
        com.google.android.material.a.b.a(r14, r0);
        return r14;
    }

    private ValueAnimator a(g r3) {
        ValueAnimator r2 = new ValueAnimator();
        r2.setInterpolator(f3925a);
        r2.setDuration(100);
        r2.addListener(r3);
        r2.addUpdateListener(r3);
        r2.setFloatValues(new float[]{0.0f, 1.0f});
        return r2;
    }

    private void a(float r6, Matrix r7) {
        r7.reset();
        Drawable r0 = this.s.getDrawable();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.A == 0) goto L9;
        RectF r1 = this.G;
        RectF r2 = this.H;
        r1.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int r3 = this.A;
        r2.set(0.0f, 0.0f, r3, r3);
        r7.setRectToRect(r1, r2, Matrix.ScaleToFit.CENTER);
        int r5 = this.A;
        r7.postScale(r6, r6, r5 / 2.0f, r5 / 2.0f);
        return;
    }

    private void a(ObjectAnimator r3) {
        if (Build.VERSION.SDK_INT == 26) goto L5;
        return;
    L5:
        r3.setEvaluator(new AnonymousClass5(this));
    }

    static /* synthetic */ void a(d r0, float r1, Matrix r2) {
        r0.a(r1, r2);
    }

    private AnimatorSet b(final float r16, final float r17, final float r18) {
        AnimatorSet r11 = new AnimatorSet();
        ArrayList r12 = new ArrayList();
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        final float r2 = this.s.getAlpha();
        final float r4 = this.s.getScaleX();
        final float r6 = this.s.getScaleY();
        final float r7 = this.z;
        final Matrix r9 = new Matrix(this.I);
        r13.addUpdateListener(new AnonymousClass4(this, r2, r16, r4, r17, r6, r7, r18, r9));
        r12.add(r13);
        com.google.android.material.a.b.a(r11, r12);
        r11.setDuration(com.google.android.material.g.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.motionDurationLong1, "attr", "motionDurationLong1"), ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getInteger(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.integer.material_motion_duration_long_1, TypedValues.Custom.S_INT, "material_motion_duration_long_1"))));
        r11.setInterpolator(com.google.android.material.g.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.motionEasingStandard, "attr", "motionEasingStandard"), com.google.android.material.a.a.f3742b));
        return r11;
    }

    private ViewTreeObserver.OnPreDrawListener y() {
        if (this.f3926J != null) goto L6;
        this.f3926J = new AnonymousClass6(this);
    L6:
        return this.f3926J;
    }

    private boolean z() {
        if (ViewCompat.isLaidOut(this.s) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.s.isInEditMode() == true) goto L7;
        return true;
    }

    float a() {
        return this.i;
    }

    final void a(float r3) {
        if (this.i == r3) goto L6;
        this.i = r3;
        a(r3, this.j, this.k);
        return;
    }

    void a(float r1, float r2, float r3) {
        o();
        e(r1);
    }

    void a(int r1) {
        this.l = r1;
    }

    void a(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        if (this.C != null) goto L5;
        this.C = new ArrayList();
    L5:
        this.C.add(r4);
    }

    void a(ColorStateList r2) {
        MaterialShapeDrawable r0 = this.c;
        if (r0 == null) goto L5;
        r0.setTintList(r2);
    L5:
        com.google.android.material.floatingactionbutton.c r1 = this.e;
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    }

    void a(ColorStateList r3, PorterDuff.Mode r4, ColorStateList r5, int r6) {
        MaterialShapeDrawable r7 = u();
        this.c = r7;
        r7.setTintList(r3);
        if (r4 == null) goto L5;
        this.c.setTintMode(r4);
    L5:
        this.c.setShadowColor(-12303292);
        this.c.initializeElevationOverlay((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        RippleDrawableCompat r8 = new RippleDrawableCompat(this.c.getShapeAppearanceModel());
        r8.setTintList(com.google.android.material.ripple.a.b(r5));
        this.d = r8;
        this.f = new LayerDrawable(new Drawable[]{(Drawable) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(this.c), Drawable.class, "com.obric.memorydata.plugin"), r8});
    }

    void a(PorterDuff.Mode r1) {
        MaterialShapeDrawable r0 = this.c;
        if (r0 == null) goto L6;
        r0.setTintMode(r1);
        return;
    }

    void a(Rect r5) {
        if (this.g == false) goto L5;
        int r0 = (this.l - this.s.getSizeDimension()) / 2;
    L7:
        if (this.h == false) goto L9;
        float r1 = a() + this.k;
    L10:
        int r4 = Math.max(r0, (int) Math.ceil(r1));
        int r2 = Math.max(r0, (int) Math.ceil(r1 * 1.5f));
        r5.set(r4, r2, r4, r2);
        return;
    L9:
        r1 = 0.0f;
        goto L10
    L5:
        r0 = 0;
        goto L7
    }

    final void a(com.google.android.material.a.h r1) {
        this.w = r1;
    }

    void a(InterfaceC0184d r3) {
        InterfaceC0184d r4 = (InterfaceC0184d) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0184d.class, "com.obric.memorydata.plugin");
        if (this.E != null) goto L5;
        this.E = new ArrayList();
    L5:
        this.E.add(r4);
    }

    void a(e r4, final boolean r5) {
        final e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        if (w() == false) goto L5;
        return;
    L5:
        Animator r0 = this.v;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        if (z() == false) goto L21;
        com.google.android.material.a.h r1 = this.x;
        if (r1 == null) goto L13;
        AnimatorSet r2 = a(r1, 0.0f, 0.0f, 0.0f);
    L14:
        r2.addListener(new AnonymousClass1(this, r5, r6));
        ArrayList<Animator.AnimatorListener> r3 = this.D;
        if (r3 == null) goto L20;
        Iterator<Animator.AnimatorListener> r7 = r3.iterator();
    L18:
        if (r7.hasNext() == false) goto L20;
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r7.next(), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
    L20:
        r2.start();
        return;
    L13:
        r2 = b(0.0f, 0.4f, 0.4f);
        goto L14
    L21:
        FloatingActionButton r8 = this.s;
        if (r5 == false) goto L24;
        int r9 = 8;
    L25:
        r8.internalSetVisibility(r9, r5);
        if (r6 == null) goto L31;
        r6.b();
        return;
    L31:
        return;
    L24:
        r9 = 4;
        goto L25
    }

    final void a(l r4) {
        this.f3927b = r4;
        MaterialShapeDrawable r0 = this.c;
        if (r0 == null) goto L6;
        r0.setShapeAppearanceModel(r4);
    L6:
        if (ZeusTransformUtils.instanceOf(this.d, p.class) == false) goto L8;
        ((p) ZeusTransformUtils.preCheckCast(this.d, p.class, "com.obric.memorydata.plugin")).setShapeAppearanceModel(r4);
    L8:
        com.google.android.material.floatingactionbutton.c r3 = this.e;
        if (r3 == null) goto L12;
        r3.a(r4);
        return;
    }

    void a(boolean r1) {
        this.g = r1;
    }

    void a(int[] r1) {
        this.u.a(r1);
    }

    float b() {
        return this.j;
    }

    final void b(float r3) {
        if (this.j == r3) goto L6;
        this.j = r3;
        a(this.i, r3, this.k);
        return;
    }

    final void b(int r2) {
        if (this.A == r2) goto L6;
        this.A = r2;
        d();
        return;
    }

    void b(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        ArrayList<Animator.AnimatorListener> r2 = this.C;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.remove(r4);
    }

    void b(ColorStateList r1) {
        Drawable r0 = this.d;
        if (r0 == null) goto L6;
        DrawableCompat.setTintList(r0, com.google.android.material.ripple.a.b(r1));
        return;
    }

    void b(Rect r8) {
        Preconditions.checkNotNull(this.f, "Didn't initialize content background");
        if (p() == false) goto L5;
        InsetDrawable r0 = new InsetDrawable(this.f, r8.left, r8.top, r8.right, r8.bottom);
        this.t.a(r0);
        return;
    L5:
        this.t.a(this.f);
    }

    final void b(com.google.android.material.a.h r1) {
        this.x = r1;
    }

    void b(InterfaceC0184d r3) {
        InterfaceC0184d r4 = (InterfaceC0184d) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0184d.class, "com.obric.memorydata.plugin");
        ArrayList<InterfaceC0184d> r2 = this.E;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.remove(r4);
    }

    void b(e r8, final boolean r9) {
        final e r10 = (e) ZeusTransformUtils.wrapperContextForParams(r8, e.class, "com.obric.memorydata.plugin");
        if (v() == false) goto L5;
        return;
    L5:
        Animator r0 = this.v;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        if (this.w != null) goto L11;
        boolean r1 = true;
    L13:
        if (z() == true) goto L15;
        this.s.internalSetVisibility(0, r9);
        this.s.setAlpha(1.0f);
        this.s.setScaleY(1.0f);
        this.s.setScaleX(1.0f);
        d(1.0f);
        if (r10 == null) goto L45;
        r10.a();
        return;
    L45:
        return;
    L15:
        if (this.s.getVisibility() == 0) goto L28;
        float r3 = 0.0f;
        this.s.setAlpha(0.0f);
        FloatingActionButton r2 = this.s;
        if (r1 == false) goto L19;
        float r6 = 0.4f;
    L20:
        r2.setScaleY(r6);
        FloatingActionButton r4 = this.s;
        if (r1 == false) goto L23;
        float r7 = 0.4f;
    L24:
        r4.setScaleX(r7);
        if (r1 == false) goto L27;
        r3 = 0.4f;
    L27:
        d(r3);
        goto L28
    L23:
        r7 = 0.0f;
        goto L24
    L19:
        r6 = 0.0f;
    L28:
        com.google.android.material.a.h r5 = this.w;
        if (r5 == null) goto L31;
        AnimatorSet r11 = a(r5, 1.0f, 1.0f, 1.0f);
    L32:
        r11.addListener(new AnonymousClass2(this, r9, r10));
        ArrayList<Animator.AnimatorListener> r12 = this.C;
        if (r12 == null) goto L38;
        Iterator<Animator.AnimatorListener> r13 = r12.iterator();
    L36:
        if (r13.hasNext() == false) goto L38;
        r11.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r13.next(), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
    L38:
        r11.start();
        return;
    L31:
        r11 = b(1.0f, 1.0f, 1.0f);
        goto L32
    L11:
        r1 = false;
        goto L13
    }

    void b(boolean r1) {
        this.h = r1;
        o();
    }

    float c() {
        return this.k;
    }

    final void c(float r3) {
        if (this.k == r3) goto L6;
        this.k = r3;
        a(this.i, this.j, r3);
        return;
    }

    public void c(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        if (this.D != null) goto L5;
        this.D = new ArrayList();
    L5:
        this.D.add(r4);
    }

    final void d() {
        d(this.z);
    }

    final void d(float r2) {
        this.z = r2;
        Matrix r0 = this.I;
        a(r2, r0);
        this.s.setImageMatrix(r0);
    }

    public void d(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        ArrayList<Animator.AnimatorListener> r2 = this.D;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.remove(r4);
    }

    final l e() {
        return this.f3927b;
    }

    void e(float r1) {
        MaterialShapeDrawable r0 = this.c;
        if (r0 == null) goto L6;
        r0.setElevation(r1);
        return;
    }

    final com.google.android.material.a.h f() {
        return this.w;
    }

    final com.google.android.material.a.h g() {
        return this.x;
    }

    final boolean h() {
        if (this.g == true) goto L5;
    L8:
        return true;
    L5:
        if (this.s.getSizeDimension() >= this.l) goto L8;
        return false;
    }

    boolean i() {
        return this.g;
    }

    void j() {
        this.u.a();
    }

    void k() {
        ArrayList<InterfaceC0184d> r3 = this.E;
        if (r3 == null) goto L8;
        Iterator<InterfaceC0184d> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        ((InterfaceC0184d) ZeusTransformUtils.preCheckCast(r4.next(), InterfaceC0184d.class, "com.obric.memorydata.plugin")).a();
        goto L6
    L10:
        return;
    }

    void l() {
        ArrayList<InterfaceC0184d> r3 = this.E;
        if (r3 == null) goto L8;
        Iterator<InterfaceC0184d> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        ((InterfaceC0184d) ZeusTransformUtils.preCheckCast(r4.next(), InterfaceC0184d.class, "com.obric.memorydata.plugin")).b();
        goto L6
    L10:
        return;
    }

    final Drawable m() {
        return this.f;
    }

    void n() {
    }

    final void o() {
        Rect r0 = this.F;
        a(r0);
        b(r0);
        this.t.a(r0.left, r0.top, r0.right, r0.bottom);
    }

    boolean p() {
        return true;
    }

    void q() {
        MaterialShapeDrawable r0 = this.c;
        if (r0 == null) goto L6;
        com.google.android.material.shape.h.a(this.s, r0);
    L6:
        if (s() == false) goto L9;
        this.s.getViewTreeObserver().addOnPreDrawListener(y());
        return;
    }

    void r() {
        ViewTreeObserver r0 = this.s.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener r1 = this.f3926J;
        if (r1 == null) goto L6;
        r0.removeOnPreDrawListener(r1);
        this.f3926J = null;
        return;
    }

    boolean s() {
        return true;
    }

    void t() {
        float r0 = this.s.getRotation();
        if (this.y == r0) goto L6;
        this.y = r0;
        x();
        return;
    }

    MaterialShapeDrawable u() {
        return new MaterialShapeDrawable((l) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(this.f3927b), l.class, "com.obric.memorydata.plugin"));
    }

    boolean v() {
        int r0 = this.s.getVisibility();
        int r3 = this.B;
        if (r0 != 0) goto L5;
        if (r3 != 1) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r3 == 2) goto L7;
        return false;
    L7:
        return true;
    }

    boolean w() {
        int r0 = this.s.getVisibility();
        int r3 = this.B;
        if (r0 != 0) goto L8;
        if (r3 == 1) goto L6;
        return false;
    L6:
        return true;
    L8:
        if (r3 != 2) goto L10;
        return false;
    L10:
        return true;
    }

    void x() {
        if (Build.VERSION.SDK_INT == 19) goto L5;
    L13:
        MaterialShapeDrawable r0 = this.c;
        if (r0 == null) goto L17;
        r0.setShadowCompatRotation((int) this.y);
        return;
    L17:
        return;
    L5:
        if ((this.y % 90.0f) == 0.0f) goto L10;
        int r2 = 1;
        if (this.s.getLayerType() == 1) goto L13;
        FloatingActionButton r1 = this.s;
    L12:
        r1.setLayerType(r2, null);
        goto L13
    L10:
        if (this.s.getLayerType() == 0) goto L13;
        r1 = this.s;
        r2 = 0;
        goto L12
    }
}
