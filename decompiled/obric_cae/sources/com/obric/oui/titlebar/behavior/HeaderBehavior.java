package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;
import t2.b;
import vc.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HeaderBehavior<V extends View> extends d<V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f6670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OverScroller f6671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VelocityTracker f6676i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoordinatorLayout f6677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f6678b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ HeaderBehavior f6679m;

        public a(HeaderBehavior r8, CoordinatorLayout r10, V r11) {
            this.f6679m = r8;
            this.f6677a = r10;
            this.f6678b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            V r8 = this.f6678b;
            if (r8 == null) goto L11;
            HeaderBehavior r10 = this.f6679m;
            if (r10.f6671d == null) goto L12;
            Log.i("djd ", "FlingRunnable: " + r8.getClass().getName() + "  scroller.getCurrY：" + r10.f6671d.getCurrY());
            boolean r11 = r10.f6671d.computeScrollOffset();
            CoordinatorLayout r12 = this.f6677a;
            if (r11 == false) goto L9;
            r10.J(r12, r8, r10.f6671d.getCurrY());
            WeakHashMap<View, h0> r13 = w.f8437a;
            w.d.m(r8, this);
            return;
        L9:
            r10.G(r8, r12);
            return;
        L12:
            return;
        }
    }

    public HeaderBehavior() {
        this.f6673f = -1;
        this.f6675h = -1;
    }

    public boolean C(V r8) {
        return false;
    }

    public boolean D(CoordinatorLayout r15, V r16, int r17, int r18, float r19) {
        a r8 = this.f6670c;
        if (r8 == null) goto L6;
        r16.removeCallbacks(r8);
        this.f6670c = null;
    L6:
        if (this.f6671d != null) goto L8;
        this.f6671d = new OverScroller(r16.getContext());
    L8:
        this.f6671d.fling(0, y(), 0, Math.round(r19), 0, 0, r17, r18);
        if (this.f6671d.computeScrollOffset() == false) goto L12;
        a r10 = new a(this, r15, r16);
        this.f6670c = r10;
        WeakHashMap<View, h0> r11 = w.f8437a;
        w.d.m(r16, r10);
        return true;
    L12:
        G(r16, r15);
        return false;
    }

    public int E(V r8) {
        return -r8.getHeight();
    }

    public int F(V r8) {
        return r8.getHeight();
    }

    public void G(View r8, CoordinatorLayout r10) {
    }

    public final int H(CoordinatorLayout r8, V r10, int r11, int r12, int r13) {
        return I(r8, r10, z() - r11, r12, r13);
    }

    public int I(CoordinatorLayout r8, V r10, int r11, int r12, int r13) {
        int r14 = y();
        if (r12 == 0) goto L9;
        if (r14 < r12) goto L9;
        if (r14 > r13) goto L9;
        int r15 = b.p(r11, r12, r13);
        if (r14 == r15) goto L9;
        B(r15);
        return r14 - r15;
    L9:
        return 0;
    }

    public final void J(CoordinatorLayout r8, View r10, int r11) {
        I(r8, r10, r11, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean g(CoordinatorLayout r8, V r10, MotionEvent r11) {
        if (this.f6675h >= 0) goto L6;
        this.f6675h = ViewConfiguration.get(r8.getContext()).getScaledTouchSlop();
    L6:
        if (r11.getActionMasked() != 2) goto L20;
        if (this.f6672e == false) goto L20;
        int r12 = this.f6673f;
        if (r12 != (-1)) goto L12;
        return false;
    L12:
        int r13 = r11.findPointerIndex(r12);
        if (r13 != (-1)) goto L15;
        return false;
    L15:
        int r14 = (int) r11.getY(r13);
        if (Math.abs(r14 - this.f6674g) <= this.f6675h) goto L20;
        this.f6674g = r14;
        return true;
    L20:
        if (r11.getActionMasked() != 0) goto L38;
        this.f6673f = -1;
        int r15 = (int) r11.getX();
        int r16 = (int) r11.getY();
        if (C(r10) == true) goto L24;
    L26:
        boolean r17 = false;
    L27:
        this.f6672e = r17;
        if (r17 == false) goto L38;
        this.f6674g = r16;
        this.f6673f = r11.getPointerId(0);
        if (this.f6676i != null) goto L32;
        this.f6676i = VelocityTracker.obtain();
    L32:
        OverScroller r18 = this.f6671d;
        if (r18 == null) goto L38;
        if (r18.isFinished() == true) goto L38;
        this.f6671d.abortAnimation();
        return true;
    L24:
        if (r8.l(r10, r15, r16) == false) goto L26;
        r17 = true;
    L38:
        VelocityTracker r19 = this.f6676i;
        if (r19 == null) goto L41;
        r19.addMovement(r11);
    L41:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean x(CoordinatorLayout r12, V r13, MotionEvent r14) {
        int r8 = r14.getActionMasked();
        if (r8 != 1) goto L5;
        VelocityTracker r10 = this.f6676i;
        if (r10 == null) goto L24;
        r10.addMovement(r14);
        this.f6676i.computeCurrentVelocity(1000);
        D(r12, r13, -F(r13), 0, this.f6676i.getYVelocity(this.f6673f));
        boolean r15 = true;
    L25:
        this.f6672e = false;
        this.f6673f = -1;
        VelocityTracker r16 = this.f6676i;
        if (r16 == null) goto L28;
        r16.recycle();
        this.f6676i = null;
    L28:
        VelocityTracker r17 = this.f6676i;
        if (r17 == null) goto L32;
        r17.addMovement(r14);
    L32:
        if (this.f6672e == true) goto L37;
        if (r15 == false) goto L36;
        return true;
    L36:
        return false;
    L37:
        return true;
    L24:
        r15 = false;
        goto L25
    L5:
        if (r8 != 2) goto L7;
        int r11 = r14.findPointerIndex(this.f6673f);
        if (r11 != (-1)) goto L19;
        return false;
    L19:
        int r18 = (int) r14.getY(r11);
        int r19 = this.f6674g - r18;
        this.f6674g = r18;
        H(r12, r13, r19, E(r13), 0);
    L20:
        r15 = false;
        goto L28
    L7:
        if (r8 == 3) goto L24;
        if (r8 != 6) goto L20;
        if (r14.getActionIndex() != 0) goto L14;
        int r110 = 1;
    L15:
        this.f6673f = r14.getPointerId(r110);
        this.f6674g = (int) (r14.getY(r110) + 0.5f);
        goto L20
    L14:
        r110 = 0;
        goto L15
    }

    public HeaderBehavior(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f6673f = -1;
        this.f6675h = -1;
    }
}
