package com.obric.oui.panel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Interpolator f6953o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OverScroller f6954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.AbstractC0130c f6955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f6956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f6957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f6958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewGroup f6959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6962i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6963j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6964k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f6965l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f6966m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Runnable f6967n;

    /* JADX INFO: renamed from: com.obric.oui.panel.a$a, reason: collision with other inner class name */
    class InterpolatorC0129a implements Interpolator {
        InterpolatorC0129a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            float r11 = r10 - 1.0f;
            return ((((r11 * r11) * r11) * r11) * r11) + 1.0f;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f6968c;

        b(a r10) {
            this.f6968c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b(this.f6968c).removeCallbacks(a.a(this.f6968c));
            a.c(this.f6968c, false);
        }
    }

    static {
        f6953o = new InterpolatorC0129a();
    }

    public a(Context r10, ViewGroup r11, c.AbstractC0130c r12) {
        this.f6966m = false;
        this.f6967n = new b(this);
        this.f6954a = new OverScroller(r10, f6953o);
        this.f6959f = r11;
        this.f6955b = r12;
        ViewConfiguration r13 = ViewConfiguration.get(r10);
        this.f6958e = r13.getScaledTouchSlop();
        this.f6956c = r13.getScaledMaximumFlingVelocity();
        this.f6957d = r13.getScaledMinimumFlingVelocity();
    }

    static /* synthetic */ Runnable a(a r10) {
        return r10.f6967n;
    }

    static /* synthetic */ ViewGroup b(a r10) {
        return r10.f6959f;
    }

    static /* synthetic */ boolean c(a r10, boolean r11) {
        r10.f6966m = r11;
        return r11;
    }

    private float d(float r10, float r11, float r12) {
        float r13 = Math.abs(r10);
        if (r13 >= r11) goto L6;
        return 0.0f;
    L6:
        if (r13 > r12) goto L8;
        return r10;
    L8:
        if (r10 <= 0.0f) goto L11;
        return r12;
    L11:
        return -r12;
    }

    private int e(int r10, int r11, int r12) {
        int r13 = Math.abs(r10);
        if (r13 >= r11) goto L6;
        return 0;
    L6:
        if (r13 <= r12) goto L11;
        if (r10 <= 0) goto L10;
        return r12;
    L10:
        return -r12;
    L11:
        return r10;
    }

    private int f(int r10, int r11, int r12) {
        if (r10 != 0) goto L5;
        return 0;
    L5:
        int r13 = this.f6959f.getWidth();
        float r14 = r13 / 2;
        float r15 = r14 + (i(Math.min(1.0f, Math.abs(r10) / r13)) * r14);
        int r16 = Math.abs(r11);
        if (r16 <= 0) goto L8;
        int r17 = Math.round(Math.abs(r15 / r16) * 1000.0f) * 4;
    L10:
        return Math.min(r17, 600);
    L8:
        r17 = (int) (((Math.abs(r10) / r12) + 1.0f) * 256.0f);
        goto L10
    }

    private int g(View r10, int r11, int r12, int r13, int r14) {
        int r15 = e(r13, (int) this.f6957d, (int) this.f6956c);
        int r16 = e(r14, (int) this.f6957d, (int) this.f6956c);
        int r17 = Math.abs(r11);
        int r18 = Math.abs(r12);
        int r19 = Math.abs(r15);
        int r20 = Math.abs(r16);
        int r21 = r19 + r20;
        int r22 = r17 + r18;
        if (r15 == 0) goto L5;
        float r23 = r19;
        float r24 = r21;
    L6:
        float r25 = r23 / r24;
        if (r16 == 0) goto L9;
        float r26 = r20;
        float r27 = r21;
    L10:
        float r28 = r26 / r27;
        return (int) ((f(r11, r15, this.f6955b.d(r10)) * r25) + (f(r12, r16, this.f6955b.e(r10)) * r28));
    L9:
        r26 = r18;
        r27 = r22;
        goto L10
    L5:
        r23 = r17;
        r24 = r22;
        goto L6
    }

    private float i(float r10) {
        return (float) Math.sin((r10 - 0.5f) * 0.47123894f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View k(@Nullable View r10) {
        if (r10 != 0) goto L6;
        return null;
    L6:
        if (r10.canScrollHorizontally(-this.f6965l) == false) goto L8;
    L21:
        return r10;
    L8:
        if ((r10 instanceof com.obric.oui.panel.b) == false) goto L13;
        if (((com.obric.oui.panel.b) r10).a(-this.f6965l) == true) goto L21;
    L13:
        if ((r10 instanceof ViewGroup) == false) goto L20;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = 0;
        int r13 = r11.getChildCount();
    L15:
        if (r12 >= r13) goto L20;
        View r14 = k(r11.getChildAt(r12));
        if (r14 != null) goto L18;
        r12 = r12 + 1;
        goto L15
    L18:
        return r14;
    L20:
        return null;
    }

    private boolean l(View r10, int r11, int r12, int r13, int r14) {
        int r15 = r10.getLeft();
        int r16 = r10.getTop();
        int r17 = r11 - r15;
        int r18 = r12 - r16;
        if (r17 != 0) goto L7;
        if (r18 != 0) goto L7;
        this.f6954a.abortAnimation();
        return false;
    L7:
        int r19 = g(r10, r17, r18, r13, r14);
        this.f6954a.startScroll(r15, r16, r17, r18, r19);
        this.f6966m = true;
        return true;
    }

    private float m(VelocityTracker r10) {
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        r10.computeCurrentVelocity(1000, this.f6956c);
        return r10.getXVelocity(this.f6963j);
    }

    private boolean o(float r10, float r11) {
        if (Math.abs(r10) > this.f6958e) goto L5;
    L7:
        return false;
    L5:
        if ((Math.abs(r10) * 0.5f) <= Math.abs(r11)) goto L7;
        return true;
    }

    public boolean h(View r10, boolean r11) {
        if (this.f6966m == false) goto L24;
        boolean r12 = this.f6954a.computeScrollOffset();
        int r13 = this.f6954a.getCurrX();
        int r14 = this.f6954a.getCurrY();
        int r15 = r13 - r10.getLeft();
        int r16 = r14 - r10.getTop();
        if (r15 == 0) goto L7;
        ViewCompat.offsetLeftAndRight(r10, r15);
    L7:
        if (r16 == 0) goto L9;
        ViewCompat.offsetTopAndBottom(r10, r16);
    L9:
        if (r15 != 0) goto L11;
        if (r16 != 0) goto L11;
    L13:
        if (r12 == true) goto L15;
    L19:
        if (r12 == true) goto L24;
        if (r11 == false) goto L22;
        this.f6959f.post(this.f6967n);
        goto L24
    L22:
        this.f6966m = false;
        goto L24
    L15:
        if (r13 != this.f6954a.getFinalX()) goto L19;
        if (r14 != this.f6954a.getFinalY()) goto L19;
        this.f6954a.abortAnimation();
        r12 = false;
    L11:
        this.f6955b.k(r10, r13, r14, r15, r16);
    L24:
        return this.f6966m;
    }

    public void j(View r10, int r11, int r12, int r13, int r14) {
        int r15 = r10.getLeft();
        int r16 = r10.getTop();
        if (r13 == 0) goto L5;
        r11 = this.f6955b.a(r10, r11, r13);
        ViewCompat.offsetLeftAndRight(r10, r11 - r15);
    L5:
        int r17 = r11;
        if (r14 == 0) goto L8;
        r12 = this.f6955b.b(r10, r12, r14);
        ViewCompat.offsetTopAndBottom(r10, r12 - r16);
    L8:
        int r18 = r12;
        if (r13 != 0) goto L11;
        if (r14 != 0) goto L11;
        return;
    L11:
        c.AbstractC0130c r19 = this.f6955b;
        r19.k(r10, r17, r18, r17 - r15, r18 - r16);
    }

    public boolean n() {
        return this.f6964k;
    }

    public void p(MotionEvent r10, View r11, int r12, VelocityTracker r13) {
        int r14 = r10.getActionMasked();
        if (r14 != 2) goto L6;
        int r15 = (int) r10.getX();
        int r16 = r15 - this.f6962i;
        this.f6962i = r15;
        int r17 = (int) ((r16 * (r11.getHeight() / r11.getWidth())) * 1.2f);
        j(r11, r11.getLeft(), r11.getTop() + r17, 0, r17);
    L6:
        if (r14 != 1) goto L10;
        if (r12 != 1) goto L10;
        q(r11, r13);
    L10:
        if (r14 != 3) goto L14;
        if (r12 != 1) goto L15;
        this.f6955b.l(r11, 0.0f, 0.0f);
        return;
    L15:
        return;
    }

    public void q(View r10, VelocityTracker r11) {
        r11.computeCurrentVelocity(1000, this.f6956c);
        float r12 = d(m(r11), this.f6957d, this.f6956c);
        this.f6955b.l(r10, 0.0f, r12);
    }

    public boolean r(View r10, int r11, int r12, int r13, int r14) {
        return l(r10, r11, r12, r13, r14);
    }

    public boolean s(View r10, MotionEvent r11) {
        this.f6962i = (int) r11.getX();
        boolean r12 = false;
        this.f6964k = false;
        int r13 = r11.getActionMasked();
        if (r13 != 0) goto L5;
        this.f6960g = (int) r11.getX();
        this.f6961h = (int) r11.getY();
    L5:
        int r14 = ((int) r11.getX()) - this.f6960g;
        int r15 = ((int) r11.getY()) - this.f6961h;
        if (r13 == 2) goto L8;
    L12:
        if (r12 == false) goto L17;
        if (r14 <= 0) goto L15;
        int r16 = 1;
    L16:
        this.f6965l = r16;
        this.f6955b.j(1);
        this.f6964k = true;
        goto L17
    L15:
        r16 = -1;
    L17:
        return r12;
    L8:
        if (o(r14, r15) == false) goto L12;
        if (k(r10) != null) goto L12;
        r12 = true;
        goto L12
    }
}
