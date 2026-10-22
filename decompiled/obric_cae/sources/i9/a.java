package i9;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<V extends View> extends c<V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RunnableC0092a f8282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OverScroller f8283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VelocityTracker f8288i;

    /* JADX INFO: renamed from: i9.a$a, reason: collision with other inner class name */
    public class RunnableC0092a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoordinatorLayout f8289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f8290b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ a f8291m;

        public RunnableC0092a(a r8, CoordinatorLayout r10, V r11) {
            this.f8291m = r8;
            this.f8289a = r10;
            this.f8290b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            V r8 = this.f8290b;
            if (r8 == null) goto L11;
            a r10 = this.f8291m;
            OverScroller r11 = r10.f8283d;
            if (r11 == null) goto L12;
            boolean r12 = r11.computeScrollOffset();
            CoordinatorLayout r13 = this.f8289a;
            if (r12 == false) goto L9;
            r10.H(r13, r8, r10.f8283d.getCurrY());
            WeakHashMap<View, h0> r14 = w.f8437a;
            w.d.m(r8, this);
            return;
        L9:
            r10.F(r8, r13);
            return;
        L12:
            return;
        }
    }

    public a() {
        this.f8285f = -1;
        this.f8287h = -1;
    }

    public boolean C(V r8) {
        return false;
    }

    public int D(V r8) {
        return -r8.getHeight();
    }

    public int E(V r8) {
        return r8.getHeight();
    }

    public void F(View r8, CoordinatorLayout r10) {
    }

    public int G(CoordinatorLayout r8, V r10, int r11, int r12, int r13) {
        int r14 = y();
        if (r12 == 0) goto L9;
        if (r14 < r12) goto L9;
        if (r14 > r13) goto L9;
        int r15 = t2.b.p(r11, r12, r13);
        if (r14 == r15) goto L9;
        B(r15);
        return r14 - r15;
    L9:
        return 0;
    }

    public final void H(CoordinatorLayout r8, View r10, int r11) {
        G(r8, r10, r11, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean g(CoordinatorLayout r8, V r10, MotionEvent r11) {
        if (this.f8287h >= 0) goto L6;
        this.f8287h = ViewConfiguration.get(r8.getContext()).getScaledTouchSlop();
    L6:
        if (r11.getActionMasked() != 2) goto L20;
        if (this.f8284e == false) goto L20;
        int r12 = this.f8285f;
        if (r12 != (-1)) goto L12;
        return false;
    L12:
        int r13 = r11.findPointerIndex(r12);
        if (r13 != (-1)) goto L15;
        return false;
    L15:
        int r14 = (int) r11.getY(r13);
        if (Math.abs(r14 - this.f8286g) <= this.f8287h) goto L20;
        this.f8286g = r14;
        return true;
    L20:
        if (r11.getActionMasked() != 0) goto L38;
        this.f8285f = -1;
        int r15 = (int) r11.getX();
        int r16 = (int) r11.getY();
        if (C(r10) == true) goto L24;
    L26:
        boolean r17 = false;
    L27:
        this.f8284e = r17;
        if (r17 == false) goto L38;
        this.f8286g = r16;
        this.f8285f = r11.getPointerId(0);
        if (this.f8288i != null) goto L32;
        this.f8288i = VelocityTracker.obtain();
    L32:
        OverScroller r18 = this.f8283d;
        if (r18 == null) goto L38;
        if (r18.isFinished() == true) goto L38;
        this.f8283d.abortAnimation();
        return true;
    L24:
        if (r8.l(r10, r15, r16) == false) goto L26;
        r17 = true;
    L38:
        VelocityTracker r19 = this.f8288i;
        if (r19 == null) goto L41;
        r19.addMovement(r11);
    L41:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean x(CoordinatorLayout r20, V r21, MotionEvent r22) {
        int r8 = r22.getActionMasked();
        if (r8 != 1) goto L5;
        VelocityTracker r10 = this.f8288i;
        if (r10 == null) goto L34;
        r10.addMovement(r22);
        this.f8288i.computeCurrentVelocity(1000);
        float r11 = this.f8288i.getYVelocity(this.f8285f);
        int r12 = -E(r21);
        RunnableC0092a r13 = this.f8282c;
        if (r13 == null) goto L27;
        r21.removeCallbacks(r13);
        this.f8282c = null;
    L27:
        if (this.f8283d != null) goto L29;
        this.f8283d = new OverScroller(r21.getContext());
    L29:
        this.f8283d.fling(0, y(), 0, Math.round(r11), 0, 0, r12, 0);
        if (this.f8283d.computeScrollOffset() == false) goto L32;
        RunnableC0092a r14 = new RunnableC0092a(this, r20, r21);
        this.f8282c = r14;
        WeakHashMap<View, h0> r15 = w.f8437a;
        w.d.m(r21, r14);
    L33:
        boolean r16 = true;
    L35:
        this.f8284e = false;
        this.f8285f = -1;
        VelocityTracker r17 = this.f8288i;
        if (r17 == null) goto L38;
        r17.recycle();
        this.f8288i = null;
    L38:
        VelocityTracker r18 = this.f8288i;
        if (r18 == null) goto L42;
        r18.addMovement(r22);
    L42:
        if (this.f8284e == true) goto L47;
        if (r16 == false) goto L46;
        return true;
    L46:
        return false;
    L47:
        return true;
    L32:
        F(r21, r20);
    L34:
        r16 = false;
        goto L35
    L5:
        if (r8 != 2) goto L7;
        int r19 = r22.findPointerIndex(this.f8285f);
        if (r19 != (-1)) goto L19;
        return false;
    L19:
        int r23 = (int) r22.getY(r19);
        int r24 = this.f8286g - r23;
        this.f8286g = r23;
        G(r20, r21, z() - r24, D(r21), 0);
    L20:
        r16 = false;
        goto L38
    L7:
        if (r8 == 3) goto L34;
        if (r8 != 6) goto L20;
        if (r22.getActionIndex() != 0) goto L14;
        int r25 = 1;
    L15:
        this.f8285f = r22.getPointerId(r25);
        this.f8286g = (int) (r22.getY(r25) + 0.5f);
        goto L20
    L14:
        r25 = 0;
        goto L15
    }

    public a(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f8285f = -1;
        this.f8287h = -1;
    }
}
