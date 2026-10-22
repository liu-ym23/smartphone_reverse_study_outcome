package com.google.android.material.floatingactionbutton;

import aa.j;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import com.obric.cae.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final int A = 0;
    public static final int B = 0;
    public static final int[] C = null;
    public static final int[] D = null;
    public static final int[] E = null;
    public static final int[] F = null;
    public static final int[] G = null;
    public static final int[] H = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final s0.a f4774x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f4775y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f4776z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f4777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f4780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f4781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f4782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animator f4783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h9.g f4784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h9.g f4785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f4786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f4787k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4788l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4789m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f4790n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f4791o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<f> f4792p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FloatingActionButton f4793q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final z9.b f4794r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f4795s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RectF f4796t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RectF f4797u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Matrix f4798v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public u9.a f4799w;

    public class a extends h9.f {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f4800d;

        public a(d r8) {
            this.f4800d = r8;
        }

        @Override // android.animation.TypeEvaluator
        public final Matrix evaluate(float r8, Matrix r10, Matrix r11) {
            this.f4800d.f4787k = r8;
            float[] r12 = this.f7952a;
            r10.getValues(r12);
            float[] r13 = this.f7953b;
            r11.getValues(r13);
            int r14 = 0;
        L4:
            if (r14 >= 9) goto L6;
            float r15 = r13[r14];
            float r16 = r12[r14];
            r13[r14] = defpackage.a.a(r15, r16, r8, r16);
            r14 = r14 + 1;
            goto L4
        L6:
            Matrix r17 = this.f7954c;
            r17.setValues(r13);
            return r17;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f4801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f4802b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ float f4803m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ float f4804n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ float f4805o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ float f4806p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ float f4807q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ Matrix f4808r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ d f4809s;

        public b(d r8, float r10, float r11, float r12, float r13, float r14, float r15, float r16, Matrix r17) {
            this.f4809s = r8;
            this.f4801a = r10;
            this.f4802b = r11;
            this.f4803m = r12;
            this.f4804n = r13;
            this.f4805o = r14;
            this.f4806p = r15;
            this.f4807q = r16;
            this.f4808r = r17;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r8) {
            float r10 = ((Float) r8.getAnimatedValue()).floatValue();
            d r11 = this.f4809s;
            r11.f4793q.setAlpha(h9.a.a(this.f4801a, this.f4802b, 0.0f, 0.2f, r10));
            FloatingActionButton r12 = r11.f4793q;
            float r13 = this.f4804n;
            float r14 = this.f4803m;
            r12.setScaleX(((r13 - r14) * r10) + r14);
            FloatingActionButton r15 = r11.f4793q;
            float r16 = this.f4805o;
            r15.setScaleY(((r13 - r16) * r10) + r16);
            float r17 = this.f4807q;
            float r18 = this.f4806p;
            r11.f4787k = defpackage.a.a(r17, r18, r10, r18);
            float r19 = defpackage.a.a(r17, r18, r10, r18);
            Matrix r20 = this.f4808r;
            r11.a(r19, r20);
            r11.f4793q.setImageMatrix(r20);
        }
    }

    public class c extends i {
        @Override // com.google.android.material.floatingactionbutton.d.i
        public final float a() {
            return 0.0f;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.d$d, reason: collision with other inner class name */
    public class C0051d extends i {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ d f4810m;

        public C0051d(u9.b r8) {
            this.f4810m = r8;
            super(r8);
        }

        @Override // com.google.android.material.floatingactionbutton.d.i
        public final float a() {
            d r8 = this.f4810m;
            return r8.f4780d + r8.f4781e;
        }
    }

    public class e extends i {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ d f4811m;

        public e(u9.b r8) {
            this.f4811m = r8;
            super(r8);
        }

        @Override // com.google.android.material.floatingactionbutton.d.i
        public final float a() {
            d r8 = this.f4811m;
            return r8.f4780d + r8.f4782f;
        }
    }

    public interface f {
        void a();

        void b();
    }

    public interface g {
    }

    public class h extends i {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ d f4812m;

        public h(u9.b r8) {
            this.f4812m = r8;
            super(r8);
        }

        @Override // com.google.android.material.floatingactionbutton.d.i
        public final float a() {
            return this.f4812m.f4780d;
        }
    }

    public abstract class i extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f4814b;

        public i(u9.b r8) {
            this.f4814b = r8;
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            this.f4814b.getClass();
            this.f4813a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r8) {
            boolean r10 = this.f4813a;
            d r11 = this.f4814b;
            if (r10 == true) goto L5;
            r11.getClass();
            a();
            this.f4813a = true;
        L5:
            r8.getAnimatedFraction();
            r11.getClass();
        }
    }

    static {
        f4774x = h9.a.f7945c;
        f4775y = R.attr.motionDurationLong2;
        f4776z = R.attr.motionEasingEmphasizedInterpolator;
        A = R.attr.motionDurationMedium1;
        B = R.attr.motionEasingEmphasizedAccelerateInterpolator;
        C = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        D = new int[]{android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
        E = new int[]{android.R.attr.state_focused, android.R.attr.state_enabled};
        F = new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled};
        G = new int[]{android.R.attr.state_enabled};
        H = new int[0];
    }

    public d(FloatingActionButton r8, FloatingActionButton.b r10) {
        this.f4779c = true;
        this.f4787k = 1.0f;
        this.f4789m = 0;
        this.f4795s = new Rect();
        this.f4796t = new RectF();
        this.f4797u = new RectF();
        this.f4798v = new Matrix();
        this.f4793q = r8;
        this.f4794r = r10;
        com.google.android.material.internal.h r11 = new com.google.android.material.internal.h();
        u9.b r12 = (u9.b) this;
        ValueAnimator r13 = d(new e(r12));
        r11.a(C, r13);
        ValueAnimator r14 = d(new C0051d(r12));
        r11.a(D, r14);
        ValueAnimator r15 = d(new C0051d(r12));
        r11.a(E, r15);
        ValueAnimator r16 = d(new C0051d(r12));
        r11.a(F, r16);
        ValueAnimator r17 = d(new h(r12));
        r11.a(G, r17);
        ValueAnimator r18 = d(new c(r12));
        r11.a(H, r18);
        this.f4786j = r8.getRotation();
    }

    public static ValueAnimator d(i r8) {
        ValueAnimator r10 = new ValueAnimator();
        r10.setInterpolator(f4774x);
        r10.setDuration(100);
        r10.addListener(r8);
        r10.addUpdateListener(r8);
        r10.setFloatValues(new float[]{0.0f, 1.0f});
        return r10;
    }

    public final void a(float r8, Matrix r10) {
        r10.reset();
        Drawable r11 = this.f4793q.getDrawable();
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.f4788l == 0) goto L9;
        RectF r12 = this.f4796t;
        RectF r13 = this.f4797u;
        r12.set(0.0f, 0.0f, r11.getIntrinsicWidth(), r11.getIntrinsicHeight());
        int r14 = this.f4788l;
        r13.set(0.0f, 0.0f, r14, r14);
        r10.setRectToRect(r12, r13, Matrix.ScaleToFit.CENTER);
        int r15 = this.f4788l;
        r10.postScale(r8, r8, r15 / 2.0f, r15 / 2.0f);
        return;
    }

    public final AnimatorSet b(h9.g r8, float r10, float r11, float r12) {
        ArrayList r13 = new ArrayList();
        Property r14 = View.ALPHA;
        float[] r15 = {r10};
        FloatingActionButton r16 = this.f4793q;
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r16, r14, r15);
        r8.c("opacity").a(r17);
        r13.add(r17);
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r16, View.SCALE_X, new float[]{r11});
        r8.c("scale").a(r18);
        r13.add(r18);
        ObjectAnimator r19 = ObjectAnimator.ofFloat(r16, View.SCALE_Y, new float[]{r11});
        r8.c("scale").a(r19);
        r13.add(r19);
        Matrix r20 = this.f4798v;
        a(r12, r20);
        ObjectAnimator r21 = ObjectAnimator.ofObject(r16, new h9.e(), new a(this), new Matrix[]{new Matrix(r20)});
        r8.c("iconScale").a(r21);
        r13.add(r21);
        AnimatorSet r22 = new AnimatorSet();
        t2.b.R(r22, r13);
        return r22;
    }

    public final AnimatorSet c(float r16, float r17, float r18, int r19, int r20) {
        AnimatorSet r10 = new AnimatorSet();
        ArrayList r11 = new ArrayList();
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        FloatingActionButton r13 = this.f4793q;
        r12.addUpdateListener(new b(this, r13.getAlpha(), r16, r13.getScaleX(), r17, r13.getScaleY(), this.f4787k, r18, new Matrix(this.f4798v)));
        r11.add(r12);
        t2.b.R(r10, r11);
        r10.setDuration(v9.d.c(r13.getContext(), r19, r13.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        r10.setInterpolator(v9.d.d(r13.getContext(), r20, h9.a.f7944b));
        return r10;
    }

    public float e() {
        throw null;
    }

    public void f(Rect r8) {
        int r10 = 0;
        if (this.f4778b == false) goto L6;
        r10 = Math.max((0 - this.f4793q.getSizeDimension()) / 2, 0);
    L6:
        if (this.f4779c == false) goto L8;
        float r11 = e() + this.f4782f;
    L9:
        int r12 = Math.max(r10, (int) Math.ceil(r11));
        int r13 = Math.max(r10, (int) Math.ceil(r11 * 1.5f));
        r8.set(r12, r13, r12, r13);
        return;
    L8:
        r11 = 0.0f;
        goto L9
    }

    public void g() {
        throw null;
    }

    public void h() {
        throw null;
    }

    public void i(int[] r8) {
        throw null;
    }

    public void j(float r8, float r10, float r11) {
        throw null;
    }

    public final void k() {
        ArrayList<f> r8 = this.f4792p;
        if (r8 == null) goto L8;
        Iterator<f> r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        r10.next().a();
        goto L6
    L10:
        return;
    }

    public void l() {
        throw null;
    }

    public void m() {
        throw null;
    }

    public final void n() {
        f(this.f4795s);
        t2.b.n(null, "Didn't initialize content background");
        throw null;
    }
}
