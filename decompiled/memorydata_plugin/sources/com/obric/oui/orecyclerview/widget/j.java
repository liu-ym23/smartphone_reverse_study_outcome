package com.obric.oui.orecyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
class j extends RecyclerView.g implements RecyclerView.l {
    private static final int[] k = null;
    private static final int[] l = null;
    private int A;
    private final int[] B;
    private final int[] C;
    private final Runnable D;
    private final RecyclerView.m E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final StateListDrawable f14198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Drawable f14199b;
    int c;
    int d;
    float e;
    int f;
    int g;
    float h;
    final ValueAnimator i;
    int j;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final StateListDrawable q;
    private final Drawable r;
    private final int s;
    private final int t;
    private int u;
    private int v;
    private RecyclerView w;
    private boolean x;
    private boolean y;
    private int z;

    private class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f14202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f14203b;

        a(j r1) {
            this.f14202a = r1;
            this.f14203b = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            this.f14203b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r4) {
            if (this.f14203b == false) goto L7;
            this.f14203b = false;
            return;
        L7:
            if (((Float) ZeusTransformUtils.preCheckCast(this.f14202a.i.getAnimatedValue(), Float.class, "com.obric.memorydata.plugin")).floatValue() != 0.0f) goto L9;
            this.f14202a.j = 0;
            this.f14202a.a(0);
            return;
        L9:
            this.f14202a.j = 2;
            this.f14202a.a();
        }
    }

    private class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f14204a;

        b(j r1) {
            this.f14204a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r3) {
            int r4 = (int) (((Float) ZeusTransformUtils.preCheckCast(r3.getAnimatedValue(), Float.class, "com.obric.memorydata.plugin")).floatValue() * 255.0f);
            this.f14204a.f14198a.setAlpha(r4);
            this.f14204a.f14199b.setAlpha(r4);
            this.f14204a.a();
        }
    }

    static {
        k = new int[]{R.attr.state_pressed};
        l = new int[0];
    }

    j(RecyclerView r4, StateListDrawable r5, Drawable r6, StateListDrawable r7, Drawable r8, int r9, int r10, int r11) {
        this.u = 0;
        this.v = 0;
        this.x = false;
        this.y = false;
        this.z = 0;
        this.A = 0;
        this.B = new int[2];
        this.C = new int[2];
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.i = r1;
        this.j = 0;
        this.D = new AnonymousClass1(this);
        this.E = new AnonymousClass2(this);
        this.f14198a = r5;
        this.f14199b = r6;
        this.q = r7;
        this.r = r8;
        this.o = Math.max(r9, r5.getIntrinsicWidth());
        this.p = Math.max(r9, r6.getIntrinsicWidth());
        this.s = Math.max(r9, r7.getIntrinsicWidth());
        this.t = Math.max(r9, r8.getIntrinsicWidth());
        this.m = r10;
        this.n = r11;
        r5.setAlpha(255);
        r6.setAlpha(255);
        r1.addListener(new a(this));
        r1.addUpdateListener(new b(this));
        a(r4);
    }

    private int a(float r2, float r3, int[] r4, int r5, int r6, int r7) {
        int r1 = r4[1] - r4[0];
        if (r1 != 0) goto L5;
        return 0;
    L5:
        int r8 = r5 - r7;
        int r9 = (int) (((r3 - r2) / r1) * r8);
        int r10 = r6 + r9;
        if (r10 >= r8) goto L9;
        if (r10 < 0) goto L9;
        return r9;
    L9:
        return 0;
    }

    private void a(float r9) {
        int[] r3 = g();
        float r10 = Math.max(r3[0], Math.min(r3[1], r9));
        if (Math.abs(this.d - r10) >= 2.0f) goto L5;
        return;
    L5:
        int r0 = a(this.e, r10, r3, this.w.computeVerticalScrollRange(), this.w.computeVerticalScrollOffset(), this.v);
        if (r0 == 0) goto L8;
        this.w.scrollBy(0, r0);
    L8:
        this.e = r10;
    }

    private void a(Canvas r7) {
        int r0 = this.u;
        int r1 = this.o;
        int r2 = r0 - r1;
        int r3 = this.d;
        int r4 = this.c;
        int r5 = r3 - (r4 / 2);
        this.f14198a.setBounds(0, 0, r1, r4);
        this.f14199b.setBounds(0, 0, this.p, this.v);
        if (e() == false) goto L5;
        this.f14199b.draw(r7);
        r7.translate(this.o, r5);
        r7.scale(-1.0f, 1.0f);
        this.f14198a.draw(r7);
        r7.scale(-1.0f, 1.0f);
        int r6 = -this.o;
    L6:
        r7.translate(r6, -r5);
        return;
    L5:
        r7.translate(r2, 0.0f);
        this.f14199b.draw(r7);
        r7.translate(0.0f, r5);
        this.f14198a.draw(r7);
        r6 = -r2;
        goto L6
    }

    private void b(float r9) {
        int[] r3 = h();
        float r10 = Math.max(r3[0], Math.min(r3[1], r9));
        if (Math.abs(this.g - r10) >= 2.0f) goto L5;
        return;
    L5:
        int r0 = a(this.h, r10, r3, this.w.computeHorizontalScrollRange(), this.w.computeHorizontalScrollOffset(), this.u);
        if (r0 == 0) goto L8;
        this.w.scrollBy(r0, 0);
    L8:
        this.h = r10;
    }

    private void b(Canvas r7) {
        int r0 = this.v;
        int r1 = this.s;
        int r2 = r0 - r1;
        int r3 = this.g;
        int r4 = this.f;
        int r5 = r3 - (r4 / 2);
        this.q.setBounds(0, 0, r4, r1);
        this.r.setBounds(0, 0, this.u, this.t);
        r7.translate(0.0f, r2);
        this.r.draw(r7);
        r7.translate(r5, 0.0f);
        this.q.draw(r7);
        r7.translate(-r5, -r2);
    }

    private void c() {
        this.w.addItemDecoration(this);
        this.w.addOnItemTouchListener(this);
        this.w.addOnScrollListener(this.E);
    }

    private void c(int r4) {
        f();
        this.w.postDelayed(this.D, r4);
    }

    private void d() {
        this.w.removeItemDecoration(this);
        this.w.removeOnItemTouchListener(this);
        this.w.removeOnScrollListener(this.E);
        f();
    }

    private boolean e() {
        if (ViewCompat.getLayoutDirection(this.w) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void f() {
        this.w.removeCallbacks(this.D);
    }

    private int[] g() {
        int[] r0 = this.B;
        int r1 = this.n;
        r0[0] = r1;
        r0[1] = this.v - r1;
        return r0;
    }

    private int[] h() {
        int[] r0 = this.C;
        int r1 = this.n;
        r0[0] = r1;
        r0[1] = this.u - r1;
        return r0;
    }

    void a() {
        this.w.invalidate();
    }

    void a(int r4) {
        if (r4 == 2) goto L5;
    L7:
        if (r4 != 0) goto L9;
        a();
    L11:
        if (this.z != 2) goto L15;
        if (r4 == 2) goto L15;
        this.f14198a.setState(l);
        int r0 = 1200;
    L17:
        c(r0);
    L18:
        this.z = r4;
        return;
    L15:
        if (r4 != 1) goto L18;
        r0 = NearElevator.WIFI_SCAN_INTERVAL_WHEN_OUT_ELEVATOR;
        goto L17
    L9:
        b();
        goto L11
    L5:
        if (this.z == 2) goto L7;
        this.f14198a.setState(k);
        f();
        goto L7
    }

    void a(int r9, int r10) {
        int r0 = this.w.computeVerticalScrollRange();
        int r1 = this.v;
        if ((r0 - r1) > 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        this.x = r2;
        int r3 = this.w.computeHorizontalScrollRange();
        int r5 = this.u;
        if ((r3 - r5) > 0) goto L11;
    L13:
        boolean r6 = false;
    L14:
        this.y = r6;
        boolean r7 = this.x;
        if (r7 == true) goto L22;
        if (r6 == true) goto L22;
        if (this.z == 0) goto L32;
        a(0);
        return;
    L32:
        return;
    L22:
        if (r7 == false) goto L25;
        float r8 = r1;
        this.d = (int) ((r8 * (r10 + (r8 / 2.0f))) / r0);
        this.c = Math.min(r1, (r1 * r1) / r0);
    L25:
        if (this.y == false) goto L27;
        float r11 = r5;
        this.g = (int) ((r11 * (r9 + (r11 / 2.0f))) / r3);
        this.f = Math.min(r5, (r5 * r5) / r3);
    L27:
        int r12 = this.z;
        if (r12 == 0) goto L30;
        if (r12 == 1) goto L30;
        return;
    L30:
        a(1);
        return;
    L11:
        if (r5 < this.m) goto L13;
        r6 = true;
        goto L14
    L5:
        if (r1 < this.m) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
    public void a(Canvas r1, RecyclerView r2, RecyclerView.s r3) {
        if (this.u == this.w.getWidth()) goto L5;
    L16:
        this.u = this.w.getWidth();
        this.v = this.w.getHeight();
        a(0);
        return;
    L5:
        if (this.v != this.w.getHeight()) goto L16;
        if (this.j != 0) goto L10;
        return;
    L10:
        if (this.x == false) goto L13;
        a(r1);
    L13:
        if (this.y == false) goto L19;
        b(r1);
        return;
    }

    public void a(RecyclerView r2) {
        RecyclerView r0 = this.w;
        if (r0 != r2) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        d();
    L7:
        this.w = r2;
        if (r2 == null) goto L11;
        c();
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
    public void a(boolean r1) {
    }

    boolean a(float r3, float r4) {
        if (e() == false) goto L8;
        if (r3 <= this.o) goto L9;
    L14:
        return false;
    L9:
        int r5 = this.d;
        int r2 = this.c;
        if (r4 < (r5 - (r2 / 2))) goto L14;
        if (r4 > (r5 + (r2 / 2))) goto L14;
        return true;
    L8:
        if (r3 < (this.u - this.o)) goto L14;
        goto L9
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView r6, MotionEvent r7) {
        int r8 = this.z;
        if (r8 != 1) goto L13;
        boolean r9 = a(r7.getX(), r7.getY());
        boolean r3 = b(r7.getX(), r7.getY());
        if (r7.getAction() != 0) goto L16;
        if (r9 == true) goto L8;
        if (r3 == true) goto L8;
        return false;
    L8:
        if (r3 == false) goto L10;
        this.A = 1;
        this.h = (int) r7.getX();
    L12:
        a(2);
    L15:
        return true;
    L10:
        if (r9 == false) goto L12;
        this.A = 2;
        this.e = (int) r7.getY();
        goto L12
    L16:
        return false;
    L13:
        if (r8 == 2) goto L15;
        return false;
    }

    public void b() {
        int r0 = this.j;
        if (r0 != 0) goto L5;
    L8:
        this.j = 1;
        ValueAnimator r1 = this.i;
        r1.setFloatValues(new float[]{((Float) ZeusTransformUtils.preCheckCast(r1.getAnimatedValue(), Float.class, "com.obric.memorydata.plugin")).floatValue(), 1.0f});
        this.i.setDuration(500);
        this.i.setStartDelay(0);
        this.i.start();
        return;
    L5:
        if (r0 != 3) goto L10;
        this.i.cancel();
        goto L8
    }

    void b(int r8) {
        int r0 = this.j;
        if (r0 == 1) goto L6;
        if (r0 != 2) goto L9;
    L7:
        this.j = 3;
        ValueAnimator r1 = this.i;
        r1.setFloatValues(new float[]{((Float) ZeusTransformUtils.preCheckCast(r1.getAnimatedValue(), Float.class, "com.obric.memorydata.plugin")).floatValue(), 0.0f});
        this.i.setDuration(r8);
        this.i.start();
        return;
    L9:
        return;
    L6:
        this.i.cancel();
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
    public void b(RecyclerView r5, MotionEvent r6) {
        if (this.z != 0) goto L6;
        return;
    L6:
        if (r6.getAction() != 0) goto L16;
        boolean r7 = a(r6.getX(), r6.getY());
        boolean r2 = b(r6.getX(), r6.getY());
        if (r7 == true) goto L10;
        if (r2 == true) goto L10;
        return;
    L10:
        if (r2 == false) goto L12;
        this.A = 1;
        this.h = (int) r6.getX();
    L14:
        a(2);
        return;
    L12:
        if (r7 == false) goto L14;
        this.A = 2;
        this.e = (int) r6.getY();
        goto L14
    L16:
        if (r6.getAction() != 1) goto L21;
        if (this.z != 2) goto L21;
        this.e = 0.0f;
        this.h = 0.0f;
        a(1);
        this.A = 0;
        return;
    L21:
        if (r6.getAction() == 2) goto L23;
        return;
    L23:
        if (this.z != 2) goto L35;
        b();
        if (this.A != 1) goto L28;
        b(r6.getX());
    L28:
        if (this.A != 2) goto L36;
        a(r6.getY());
        return;
    L36:
        return;
    }

    boolean b(float r3, float r4) {
        if (r4 < (this.v - this.s)) goto L9;
        int r5 = this.g;
        int r2 = this.f;
        if (r3 < (r5 - (r2 / 2))) goto L9;
        if (r3 > (r5 + (r2 / 2))) goto L9;
        return true;
    L9:
        return false;
    }
}
