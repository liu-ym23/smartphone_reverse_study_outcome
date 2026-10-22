package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.p;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class d {
    static final TimeInterpolator D = null;
    static final int[] E = null;
    static final int[] F = null;
    static final int[] G = null;
    static final int[] H = null;
    static final int[] I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    static final int[] f3280J = null;
    private final RectF A;
    private final Matrix B;

    @Nullable
    private ViewTreeObserver.OnPreDrawListener C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    com.google.android.material.shape.l f3281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    MaterialShapeDrawable f3282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    Drawable f3283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    com.google.android.material.floatingactionbutton.c f3284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    Drawable f3285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f3286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f3287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f3288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f3289i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f3290j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f3291k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.internal.h f3292l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private Animator f3293m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private r5.h f3294n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private r5.h f3295o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f3296p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f3297q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f3298r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f3299s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f3300t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f3301u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ArrayList<j> f3302v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final FloatingActionButton f3303w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final a6.b f3304x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Rect f3305y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final RectF f3306z;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3307c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f3308g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ k f3309h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ d f3310i;

        a(d r10, boolean r11, k r12) {
            this.f3310i = r10;
            this.f3308g = r11;
            this.f3309h = r12;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.f3307c = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            d.a(this.f3310i, 0);
            d.b(this.f3310i, null);
            if (this.f3307c == true) goto L12;
            FloatingActionButton r11 = this.f3310i.f3303w;
            boolean r12 = this.f3308g;
            if (r12 == false) goto L7;
            int r13 = 8;
        L8:
            r11.internalSetVisibility(r13, r12);
            k r14 = this.f3309h;
            if (r14 == null) goto L13;
            r14.b();
            return;
        L13:
            return;
        L7:
            r13 = 4;
            goto L8
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f3310i.f3303w.internalSetVisibility(0, this.f3308g);
            d.a(this.f3310i, 1);
            d.b(this.f3310i, r10);
            this.f3307c = false;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f3311c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ k f3312g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d f3313h;

        b(d r10, boolean r11, k r12) {
            this.f3313h = r10;
            this.f3311c = r11;
            this.f3312g = r12;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            d.a(this.f3313h, 0);
            d.b(this.f3313h, null);
            k r11 = this.f3312g;
            if (r11 == null) goto L6;
            r11.a();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f3313h.f3303w.internalSetVisibility(0, this.f3311c);
            d.a(this.f3313h, 2);
            d.b(this.f3313h, r10);
        }
    }

    class c extends r5.g {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f3314d;

        c(d r10) {
            this.f3314d = r10;
        }

        @Override // r5.g
        public Matrix a(float r10, @NonNull Matrix r11, @NonNull Matrix r12) {
            d.c(this.f3314d, r10);
            return super.a(r10, r11, r12);
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Matrix evaluate(float r10, @NonNull Matrix r11, @NonNull Matrix r12) {
            return a(r10, r11, r12);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.d$d, reason: collision with other inner class name */
    class C0080d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f3315c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f3316g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f3317h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f3318i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ float f3319j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ float f3320k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ float f3321l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ Matrix f3322m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ d f3323n;

        C0080d(d r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17, Matrix r18) {
            this.f3323n = r10;
            this.f3315c = r11;
            this.f3316g = r12;
            this.f3317h = r13;
            this.f3318i = r14;
            this.f3319j = r15;
            this.f3320k = r16;
            this.f3321l = r17;
            this.f3322m = r18;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            this.f3323n.f3303w.setAlpha(r5.a.b(this.f3315c, this.f3316g, 0.0f, 0.2f, r11));
            this.f3323n.f3303w.setScaleX(r5.a.a(this.f3317h, this.f3318i, r11));
            this.f3323n.f3303w.setScaleY(r5.a.a(this.f3319j, this.f3318i, r11));
            d.c(this.f3323n, r5.a.a(this.f3320k, this.f3321l, r11));
            d.d(this.f3323n, r5.a.a(this.f3320k, this.f3321l, r11), this.f3322m);
            this.f3323n.f3303w.setImageMatrix(this.f3322m);
        }
    }

    class e implements TypeEvaluator<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        FloatEvaluator f3324a;

        e(d r10) {
            this.f3324a = new FloatEvaluator();
        }

        public Float a(float r10, Float r11, Float r12) {
            float r13 = this.f3324a.evaluate(r10, r11, r12).floatValue();
            if (r13 >= 0.1f) goto L6;
            r13 = 0.0f;
        L6:
            return Float.valueOf(r13);
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Float evaluate(float r10, Float r11, Float r12) {
            return a(r10, r11, r12);
        }
    }

    class f implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f3325c;

        f(d r10) {
            this.f3325c = r10;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f3325c.H();
            return true;
        }
    }

    private class g extends m {
        g(d r10) {
            super(r10, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            return 0.0f;
        }
    }

    private class h extends m {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ d f3326j;

        h(d r10) {
            this.f3326j = r10;
            super(r10, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            d r10 = this.f3326j;
            return r10.f3288h + r10.f3289i;
        }
    }

    private class i extends m {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ d f3327j;

        i(d r10) {
            this.f3327j = r10;
            super(r10, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            d r10 = this.f3327j;
            return r10.f3288h + r10.f3290j;
        }
    }

    interface j {
        void a();

        void b();
    }

    interface k {
        void a();

        void b();
    }

    private class l extends m {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ d f3328j;

        l(d r10) {
            this.f3328j = r10;
            super(r10, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            return this.f3328j.f3288h;
        }
    }

    private abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3329c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f3330g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f3331h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ d f3332i;

        private m(d r10) {
            this.f3332i = r10;
        }

        /* synthetic */ m(d r10, a r11) {
            this(r10);
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.f3332i.j0((int) this.f3331h);
            this.f3329c = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            if (this.f3329c == true) goto L9;
            MaterialShapeDrawable r11 = this.f3332i.f3282b;
            if (r11 != null) goto L7;
            float r12 = 0.0f;
        L8:
            this.f3330g = r12;
            this.f3331h = a();
            this.f3329c = true;
            goto L9
        L7:
            r12 = r11.getElevation();
        L9:
            d r13 = this.f3332i;
            float r14 = this.f3330g;
            r13.j0((int) (r14 + ((this.f3331h - r14) * r10.getAnimatedFraction())));
        }
    }

    static {
        D = r5.a.f12675c;
        E = new int[]{R.attr.state_pressed, R.attr.state_enabled};
        F = new int[]{R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
        G = new int[]{R.attr.state_focused, R.attr.state_enabled};
        H = new int[]{R.attr.state_hovered, R.attr.state_enabled};
        I = new int[]{R.attr.state_enabled};
        f3280J = new int[0];
    }

    d(FloatingActionButton r10, a6.b r11) {
        this.f3287g = true;
        this.f3297q = 1.0f;
        this.f3299s = 0;
        this.f3305y = new Rect();
        this.f3306z = new RectF();
        this.A = new RectF();
        this.B = new Matrix();
        this.f3303w = r10;
        this.f3304x = r11;
        com.google.android.material.internal.h r12 = new com.google.android.material.internal.h();
        this.f3292l = r12;
        r12.a(E, k(new i(this)));
        r12.a(F, k(new h(this)));
        r12.a(G, k(new h(this)));
        r12.a(H, k(new h(this)));
        r12.a(I, k(new l(this)));
        r12.a(f3280J, k(new g(this)));
        this.f3296p = r10.getRotation();
    }

    static /* synthetic */ int a(d r10, int r11) {
        r10.f3299s = r11;
        return r11;
    }

    static /* synthetic */ Animator b(d r10, Animator r11) {
        r10.f3293m = r11;
        return r11;
    }

    static /* synthetic */ float c(d r10, float r11) {
        r10.f3297q = r11;
        return r11;
    }

    static /* synthetic */ void d(d r10, float r11, Matrix r12) {
        r10.h(r11, r12);
    }

    private boolean d0() {
        if (ViewCompat.isLaidOut(this.f3303w) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f3303w.isInEditMode() == true) goto L7;
        return true;
    }

    private void h(float r10, @NonNull Matrix r11) {
        r11.reset();
        Drawable r12 = this.f3303w.getDrawable();
        if (r12 != null) goto L5;
        return;
    L5:
        if (this.f3298r == 0) goto L9;
        RectF r13 = this.f3306z;
        RectF r14 = this.A;
        r13.set(0.0f, 0.0f, r12.getIntrinsicWidth(), r12.getIntrinsicHeight());
        int r15 = this.f3298r;
        r14.set(0.0f, 0.0f, r15, r15);
        r11.setRectToRect(r13, r14, Matrix.ScaleToFit.CENTER);
        int r16 = this.f3298r;
        r11.postScale(r10, r10, r16 / 2.0f, r16 / 2.0f);
        return;
    }

    @NonNull
    private AnimatorSet i(@NonNull r5.h r10, float r11, float r12, float r13) {
        ArrayList r14 = new ArrayList();
        ObjectAnimator r15 = ObjectAnimator.ofFloat(this.f3303w, View.ALPHA, new float[]{r11});
        r10.h("opacity").a(r15);
        r14.add(r15);
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this.f3303w, View.SCALE_X, new float[]{r12});
        r10.h("scale").a(r16);
        k0(r16);
        r14.add(r16);
        ObjectAnimator r17 = ObjectAnimator.ofFloat(this.f3303w, View.SCALE_Y, new float[]{r12});
        r10.h("scale").a(r17);
        k0(r17);
        r14.add(r17);
        h(r13, this.B);
        ObjectAnimator r18 = ObjectAnimator.ofObject(this.f3303w, new r5.f(), new c(this), new Matrix[]{new Matrix(this.B)});
        r10.h("iconScale").a(r18);
        r14.add(r18);
        AnimatorSet r19 = new AnimatorSet();
        r5.b.a(r19, r14);
        return r19;
    }

    private AnimatorSet j(float r16, float r17, float r18) {
        AnimatorSet r11 = new AnimatorSet();
        ArrayList r12 = new ArrayList();
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r13.addUpdateListener(new C0080d(this, this.f3303w.getAlpha(), r16, this.f3303w.getScaleX(), r17, this.f3303w.getScaleY(), this.f3297q, r18, new Matrix(this.B)));
        r12.add(r13);
        r5.b.a(r11, r12);
        r11.setDuration(z5.a.d(this.f3303w.getContext(), q5.b.motionDurationLong1, this.f3303w.getContext().getResources().getInteger(q5.g.material_motion_duration_long_1)));
        r11.setInterpolator(z5.a.e(this.f3303w.getContext(), q5.b.motionEasingStandard, r5.a.f12674b));
        return r11;
    }

    @NonNull
    private ValueAnimator k(@NonNull m r10) {
        ValueAnimator r11 = new ValueAnimator();
        r11.setInterpolator(D);
        r11.setDuration(100);
        r11.addListener(r10);
        r11.addUpdateListener(r10);
        r11.setFloatValues(new float[]{0.0f, 1.0f});
        return r11;
    }

    private void k0(ObjectAnimator r10) {
        if (Build.VERSION.SDK_INT == 26) goto L5;
        return;
    L5:
        r10.setEvaluator(new e(this));
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener r() {
        if (this.C != null) goto L6;
        this.C = new f(this);
    L6:
        return this.C;
    }

    void A() {
        this.f3292l.c();
    }

    void B() {
        MaterialShapeDrawable r10 = this.f3282b;
        if (r10 == null) goto L6;
        com.google.android.material.shape.h.f(this.f3303w, r10);
    L6:
        if (N() == false) goto L9;
        this.f3303w.getViewTreeObserver().addOnPreDrawListener(r());
        return;
    }

    void C() {
    }

    void D() {
        ViewTreeObserver r10 = this.f3303w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener r11 = this.C;
        if (r11 == null) goto L6;
        r10.removeOnPreDrawListener(r11);
        this.C = null;
        return;
    }

    void E(int[] r10) {
        this.f3292l.d(r10);
    }

    void F(float r10, float r11, float r12) {
        i0();
        j0(r10);
    }

    void G(@NonNull Rect r10) {
        Preconditions.checkNotNull(this.f3285e, "Didn't initialize content background");
        if (c0() == false) goto L5;
        InsetDrawable r11 = new InsetDrawable(this.f3285e, r10.left, r10.top, r10.right, r10.bottom);
        this.f3304x.setBackgroundDrawable(r11);
        return;
    L5:
        this.f3304x.setBackgroundDrawable(this.f3285e);
    }

    void H() {
        float r10 = this.f3303w.getRotation();
        if (this.f3296p == r10) goto L6;
        this.f3296p = r10;
        g0();
        return;
    }

    void I() {
        ArrayList<j> r10 = this.f3302v;
        if (r10 == null) goto L8;
        Iterator<j> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        r11.next().b();
        goto L6
    L10:
        return;
    }

    void J() {
        ArrayList<j> r10 = this.f3302v;
        if (r10 == null) goto L8;
        Iterator<j> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        r11.next().a();
        goto L6
    L10:
        return;
    }

    public void K(@NonNull Animator.AnimatorListener r10) {
        ArrayList<Animator.AnimatorListener> r11 = this.f3301u;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.remove(r10);
    }

    void L(@NonNull Animator.AnimatorListener r10) {
        ArrayList<Animator.AnimatorListener> r11 = this.f3300t;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.remove(r10);
    }

    void M(@NonNull j r10) {
        ArrayList<j> r11 = this.f3302v;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.remove(r10);
    }

    boolean N() {
        return true;
    }

    void O(@Nullable ColorStateList r10) {
        MaterialShapeDrawable r11 = this.f3282b;
        if (r11 == null) goto L5;
        r11.setTintList(r10);
    L5:
        com.google.android.material.floatingactionbutton.c r12 = this.f3284d;
        if (r12 == null) goto L9;
        r12.c(r10);
        return;
    }

    void P(@Nullable PorterDuff.Mode r10) {
        MaterialShapeDrawable r11 = this.f3282b;
        if (r11 == null) goto L6;
        r11.setTintMode(r10);
        return;
    }

    final void Q(float r10) {
        if (this.f3288h == r10) goto L6;
        this.f3288h = r10;
        F(r10, this.f3289i, this.f3290j);
        return;
    }

    void R(boolean r10) {
        this.f3286f = r10;
    }

    final void S(@Nullable r5.h r10) {
        this.f3295o = r10;
    }

    final void T(float r10) {
        if (this.f3289i == r10) goto L6;
        this.f3289i = r10;
        F(this.f3288h, r10, this.f3290j);
        return;
    }

    final void U(float r10) {
        this.f3297q = r10;
        Matrix r11 = this.B;
        h(r10, r11);
        this.f3303w.setImageMatrix(r11);
    }

    final void V(int r10) {
        if (this.f3298r == r10) goto L6;
        this.f3298r = r10;
        h0();
        return;
    }

    void W(int r10) {
        this.f3291k = r10;
    }

    final void X(float r10) {
        if (this.f3290j == r10) goto L6;
        this.f3290j = r10;
        F(this.f3288h, this.f3289i, r10);
        return;
    }

    void Y(@Nullable ColorStateList r10) {
        Drawable r11 = this.f3283c;
        if (r11 == null) goto L6;
        DrawableCompat.setTintList(r11, com.google.android.material.ripple.a.d(r10));
        return;
    }

    void Z(boolean r10) {
        this.f3287g = r10;
        i0();
    }

    final void a0(@NonNull com.google.android.material.shape.l r10) {
        this.f3281a = r10;
        MaterialShapeDrawable r11 = this.f3282b;
        if (r11 == null) goto L5;
        r11.setShapeAppearanceModel(r10);
    L5:
        Object r12 = this.f3283c;
        if ((r12 instanceof p) == false) goto L8;
        ((p) r12).setShapeAppearanceModel(r10);
    L8:
        com.google.android.material.floatingactionbutton.c r13 = this.f3284d;
        if (r13 == null) goto L12;
        r13.f(r10);
        return;
    }

    final void b0(@Nullable r5.h r10) {
        this.f3294n = r10;
    }

    boolean c0() {
        return true;
    }

    public void e(@NonNull Animator.AnimatorListener r10) {
        if (this.f3301u != null) goto L5;
        this.f3301u = new ArrayList();
    L5:
        this.f3301u.add(r10);
    }

    final boolean e0() {
        if (this.f3286f == true) goto L5;
    L8:
        return true;
    L5:
        if (this.f3303w.getSizeDimension() >= this.f3291k) goto L8;
        return false;
    }

    void f(@NonNull Animator.AnimatorListener r10) {
        if (this.f3300t != null) goto L5;
        this.f3300t = new ArrayList();
    L5:
        this.f3300t.add(r10);
    }

    void f0(@Nullable k r10, boolean r11) {
        if (z() == false) goto L5;
        return;
    L5:
        Animator r12 = this.f3293m;
        if (r12 == null) goto L9;
        r12.cancel();
    L9:
        if (this.f3294n != null) goto L11;
        boolean r13 = true;
    L13:
        if (d0() == true) goto L15;
        this.f3303w.internalSetVisibility(0, r11);
        this.f3303w.setAlpha(1.0f);
        this.f3303w.setScaleY(1.0f);
        this.f3303w.setScaleX(1.0f);
        U(1.0f);
        if (r10 == null) goto L45;
        r10.a();
        return;
    L45:
        return;
    L15:
        if (this.f3303w.getVisibility() == 0) goto L28;
        float r14 = 0.0f;
        this.f3303w.setAlpha(0.0f);
        FloatingActionButton r15 = this.f3303w;
        if (r13 == false) goto L19;
        float r16 = 0.4f;
    L20:
        r15.setScaleY(r16);
        FloatingActionButton r17 = this.f3303w;
        if (r13 == false) goto L23;
        float r18 = 0.4f;
    L24:
        r17.setScaleX(r18);
        if (r13 == false) goto L27;
        r14 = 0.4f;
    L27:
        U(r14);
        goto L28
    L23:
        r18 = 0.0f;
        goto L24
    L19:
        r16 = 0.0f;
    L28:
        r5.h r19 = this.f3294n;
        if (r19 == null) goto L31;
        AnimatorSet r20 = i(r19, 1.0f, 1.0f, 1.0f);
    L32:
        r20.addListener(new b(this, r11, r10));
        ArrayList<Animator.AnimatorListener> r21 = this.f3300t;
        if (r21 == null) goto L38;
        Iterator<Animator.AnimatorListener> r22 = r21.iterator();
    L36:
        if (r22.hasNext() == false) goto L38;
        r20.addListener(r22.next());
    L38:
        r20.start();
        return;
    L31:
        r20 = j(1.0f, 1.0f, 1.0f);
        goto L32
    L11:
        r13 = false;
        goto L13
    }

    void g(@NonNull j r10) {
        if (this.f3302v != null) goto L5;
        this.f3302v = new ArrayList();
    L5:
        this.f3302v.add(r10);
    }

    void g0() {
        if (Build.VERSION.SDK_INT == 19) goto L5;
    L13:
        MaterialShapeDrawable r10 = this.f3282b;
        if (r10 == null) goto L17;
        r10.setShadowCompatRotation((int) this.f3296p);
        return;
    L17:
        return;
    L5:
        if ((this.f3296p % 90.0f) == 0.0f) goto L10;
        int r11 = 1;
        if (this.f3303w.getLayerType() == 1) goto L13;
        FloatingActionButton r12 = this.f3303w;
    L12:
        r12.setLayerType(r11, null);
        goto L13
    L10:
        if (this.f3303w.getLayerType() == 0) goto L13;
        r12 = this.f3303w;
        r11 = 0;
        goto L12
    }

    final void h0() {
        U(this.f3297q);
    }

    final void i0() {
        Rect r10 = this.f3305y;
        s(r10);
        G(r10);
        this.f3304x.setShadowPadding(r10.left, r10.top, r10.right, r10.bottom);
    }

    void j0(float r10) {
        MaterialShapeDrawable r11 = this.f3282b;
        if (r11 == null) goto L6;
        r11.setElevation(r10);
        return;
    }

    MaterialShapeDrawable l() {
        return new MaterialShapeDrawable((com.google.android.material.shape.l) Preconditions.checkNotNull(this.f3281a));
    }

    @Nullable
    final Drawable m() {
        return this.f3285e;
    }

    float n() {
        return this.f3288h;
    }

    boolean o() {
        return this.f3286f;
    }

    @Nullable
    final r5.h p() {
        return this.f3295o;
    }

    float q() {
        return this.f3289i;
    }

    void s(@NonNull Rect r10) {
        if (this.f3286f == false) goto L5;
        int r11 = (this.f3291k - this.f3303w.getSizeDimension()) / 2;
    L7:
        if (this.f3287g == false) goto L9;
        float r12 = n() + this.f3290j;
    L10:
        int r13 = Math.max(r11, (int) Math.ceil(r12));
        int r14 = Math.max(r11, (int) Math.ceil(r12 * 1.5f));
        r10.set(r13, r14, r13, r14);
        return;
    L9:
        r12 = 0.0f;
        goto L10
    L5:
        r11 = 0;
        goto L7
    }

    float t() {
        return this.f3290j;
    }

    @Nullable
    final com.google.android.material.shape.l u() {
        return this.f3281a;
    }

    @Nullable
    final r5.h v() {
        return this.f3294n;
    }

    void w(@Nullable k r10, boolean r11) {
        if (y() == false) goto L5;
        return;
    L5:
        Animator r12 = this.f3293m;
        if (r12 == null) goto L9;
        r12.cancel();
    L9:
        if (d0() == false) goto L21;
        r5.h r13 = this.f3295o;
        if (r13 == null) goto L13;
        AnimatorSet r14 = i(r13, 0.0f, 0.0f, 0.0f);
    L14:
        r14.addListener(new a(this, r11, r10));
        ArrayList<Animator.AnimatorListener> r15 = this.f3301u;
        if (r15 == null) goto L20;
        Iterator<Animator.AnimatorListener> r16 = r15.iterator();
    L18:
        if (r16.hasNext() == false) goto L20;
        r14.addListener(r16.next());
    L20:
        r14.start();
        return;
    L13:
        r14 = j(0.0f, 0.4f, 0.4f);
        goto L14
    L21:
        FloatingActionButton r17 = this.f3303w;
        if (r11 == false) goto L24;
        int r18 = 8;
    L25:
        r17.internalSetVisibility(r18, r11);
        if (r10 == null) goto L31;
        r10.b();
        return;
    L31:
        return;
    L24:
        r18 = 4;
        goto L25
    }

    void x(ColorStateList r10, @Nullable PorterDuff.Mode r11, ColorStateList r12, int r13) {
        MaterialShapeDrawable r14 = l();
        this.f3282b = r14;
        r14.setTintList(r10);
        if (r11 == null) goto L5;
        this.f3282b.setTintMode(r11);
    L5:
        this.f3282b.setShadowColor(-12303292);
        this.f3282b.initializeElevationOverlay(this.f3303w.getContext());
        RippleDrawableCompat r15 = new RippleDrawableCompat(this.f3282b.getShapeAppearanceModel());
        r15.setTintList(com.google.android.material.ripple.a.d(r12));
        this.f3283c = r15;
        this.f3285e = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f3282b), r15});
    }

    boolean y() {
        int r10 = this.f3303w.getVisibility();
        int r11 = this.f3299s;
        if (r10 != 0) goto L8;
        if (r11 == 1) goto L6;
        return false;
    L6:
        return true;
    L8:
        if (r11 != 2) goto L10;
        return false;
    L10:
        return true;
    }

    boolean z() {
        int r10 = this.f3303w.getVisibility();
        int r11 = this.f3299s;
        if (r10 != 0) goto L5;
        if (r11 != 1) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r11 == 2) goto L7;
        return false;
    L7:
        return true;
    }
}
