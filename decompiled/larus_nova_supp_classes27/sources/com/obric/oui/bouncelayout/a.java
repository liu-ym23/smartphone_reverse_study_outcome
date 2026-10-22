package com.obric.oui.bouncelayout;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.AbsListView;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final AbsListView a;
    public final Function0<Boolean> b;
    public final Function0<BounceEdgeEffect> c;
    public final Function0<BounceEdgeEffect> d;
    public final Function0<Unit> e;
    public final Function0<Unit> f;
    public final Function0<Float> g;
    public final int h;
    public final int i;
    public final int j;
    public boolean k;
    public boolean l;
    public float m;
    public float n;
    public boolean o;
    public int p;
    public float q;
    public float r;
    public VelocityTracker s;
    public long t;

    /* JADX INFO: renamed from: com.obric.oui.bouncelayout.a$a, reason: collision with other inner class name */
    public static final class C0122a {
    }

    static {
    }

    public final void l() {
        boolean r0 = false;
        this.o = false;
        int r1 = this.p;
        VelocityTracker r2 = this.s;
        if (r2 == null) goto L9;
        if (r1 == (-1)) goto L9;
        r2.computeCurrentVelocity(1000, this.j);
        float r3 = r2.getYVelocity(r1);
        if (Math.abs(r3) < this.i) goto L9;
        int r4 = MathKt.roundToInt(-r3);
    L11:
        BounceEdgeEffect r5 = (BounceEdgeEffect) this.c.invoke();
        BounceEdgeEffect r6 = (BounceEdgeEffect) this.d.invoke();
        boolean r7 = b(r5);
        boolean r8 = b(r6);
        if (r7 == false) goto L15;
        if (r8 == true) goto L15;
    L24:
        byte r9 = 0;
    L32:
        this.p = -1;
        this.t = -1;
        int r10 = c.a;
        BounceEdgeEffect r11 = (BounceEdgeEffect) this.c.invoke();
        BounceEdgeEffect r12 = (BounceEdgeEffect) this.d.invoke();
        if (r4 == 0) goto L73;
        if (r9 != 0) goto L39;
        if (r4 >= 0) goto L39;
        if (r11 == null) goto L82;
        r11.onAbsorb(r4);
    L82:
        if (r0 == true) goto L84;
        this.f.invoke();
    L84:
        VelocityTracker r13 = this.s;
        if (r13 == null) goto L88;
        r13.recycle();
    L88:
        this.s = null;
        this.a.invalidate();
        return;
    L39:
        if (r9 != 1) goto L44;
        if (r4 <= 0) goto L44;
        if (r12 == null) goto L82;
        r12.onAbsorb(r4);
    L44:
        if (r4 > 0) goto L46;
    L48:
        if (r4 < 0) goto L50;
    L53:
        if (r9 != 1) goto L58;
        if (r4 >= 0) goto L58;
        if (r12 == null) goto L82;
        r12.onRelease();
    L58:
        if (r9 != 0) goto L63;
        if (r4 <= 0) goto L63;
        if (r11 == null) goto L82;
        r11.onRelease();
    L63:
        if (r9 != (-1)) goto L68;
        if (r4 <= 0) goto L68;
        if (r12 == null) goto L82;
        r12.onAbsorb(r4);
    L68:
        if (r9 != (-1)) goto L73;
        if (r4 >= 0) goto L73;
        if (r11 == null) goto L82;
        r11.onAbsorb(r4);
        goto L82
    L50:
        if (this.a.canScrollList(-1) == false) goto L53;
        this.a.fling(r4);
    L52:
        r0 = true;
        goto L82
    L46:
        if (this.a.canScrollList(1) == false) goto L48;
        this.a.fling(r4);
    L73:
        if (r9 == 0) goto L79;
        if (r9 != 1) goto L82;
        if (r12 == null) goto L82;
        r12.onRelease();
        goto L82
    L79:
        if (r11 == null) goto L82;
        r11.onRelease();
    L15:
        if (r8 == false) goto L19;
        if (r7 == true) goto L19;
    L30:
        r9 = 1;
    L19:
        if (r5 != null) goto L21;
        float r14 = 0.0f;
    L23:
        if (r14 > 0.0f) goto L24;
        if (r6 != null) goto L27;
        float r15 = 0.0f;
    L29:
        if (r15 < 0.0f) goto L30;
        r9 = -1;
        goto L32
    L27:
        r15 = r6.f;
        goto L29
    L21:
        r14 = r5.f;
    L9:
        r4 = 0;
        goto L11
    }

    public static boolean b(BounceEdgeEffect r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
    L16:
        return true;
    L10:
        if (r4.f != 0.0f) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        if (r4.isFinished() == false) goto L16;
        return false;
    L12:
        r2 = false;
        goto L13
    L7:
        r1 = false;
        goto L8
    }

    public final int a(int r12) {
        if (r12 != 0) goto L4;
    L49:
        return r12;
    L4:
        if (this.a.getChildCount() == 0) goto L49;
        if (this.a.canScrollList(r12) == false) goto L49;
        int r0 = RangesKt.coerceAtLeast(((this.a.getHeight() - this.a.getListPaddingTop()) - this.a.getListPaddingBottom()) - 1, 1);
        int r2 = this.a.getChildCount();
        int r5 = 0;
        int r6 = Integer.MAX_VALUE;
    L9:
        if (r5 >= r2) goto L15;
        int r7 = r5 + 1;
        int r8 = this.a.getChildAt(r5).getHeight();
        if (r8 <= 0) goto L14;
        if (r8 >= r6) goto L14;
        r6 = r8;
    L14:
        r5 = r7;
        goto L9
    L15:
        if (r6 == Integer.MAX_VALUE) goto L18;
        r0 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r6 / 2, 1), r0);
    L18:
        int r3 = 0;
    L19:
        if (r12 == 0) goto L49;
        if (this.a.canScrollList(r12) == false) goto L49;
        if (r12 <= 0) goto L24;
        int r4 = RangesKt.coerceAtMost(r12, r0);
    L25:
        int r9 = this.a.getChildCount();
        int[] r10 = new int[r9];
        int r11 = 0;
    L26:
        if (r11 >= r9) goto L28;
        r10[r11] = this.a.getFirstVisiblePosition() + r11;
        r11 = r11 + 1;
        goto L26
    L28:
        int[] r13 = new int[r9];
        int r14 = 0;
    L29:
        if (r14 >= r9) goto L31;
        r13[r14] = this.a.getChildAt(r14).getTop();
        r14 = r14 + 1;
        goto L29
    L31:
        this.a.scrollListBy(r4);
        int r15 = this.a.getChildCount();
        int r16 = 0;
    L32:
        if (r16 >= r15) goto L37;
        int r17 = r16 + 1;
        int r18 = ArraysKt.indexOf(r10, this.a.getFirstVisiblePosition() + r16);
        if (r18 >= 0) goto L35;
        r16 = r17;
        goto L32
    L35:
        Integer r20 = Integer.valueOf(r13[r18] - this.a.getChildAt(r16).getTop());
    L38:
        if (r20 == null) goto L39;
        r3 = r3 + 1;
        if (r4 <= 0) goto L43;
        int r21 = RangesKt.coerceIn(r20.intValue(), 0, r4);
    L44:
        if (r21 == 0) goto L49;
        r12 = r12 - r21;
        if (r3 <= ((this.a.getCount() + this.a.getChildCount()) + 1)) goto L19;
        return 0;
    L43:
        r21 = RangesKt.coerceIn(r20.intValue(), r4, 0);
        goto L44
    L39:
        int r1 = c.a;
        goto L49
    L37:
        r20 = null;
        goto L38
    L24:
        r4 = RangesKt.coerceAtLeast(r12, -r0);
        goto L25
    }

    public final void c(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        this.k = false;
        this.l = false;
        this.o = false;
        this.p = r3.getPointerId(0);
        float r0 = r3.getY(0);
        this.q = r0;
        this.r = r0;
        this.t = -1;
        VelocityTracker r1 = this.s;
        if (r1 != null) goto L5;
        this.s = VelocityTracker.obtain();
    L6:
        VelocityTracker r2 = this.s;
        if (r2 == null) goto L11;
        r2.addMovement(r3);
        return;
    L11:
        return;
    L5:
        r1.clear();
        goto L6
    }

    public final boolean d(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (this.o == true) goto L6;
        return false;
    L6:
        int r0 = r3.getActionIndex();
        if (r0 >= 0) goto L9;
        return true;
    L9:
        if (r0 >= r3.getPointerCount()) goto L15;
        this.p = r3.getPointerId(r0);
        this.r = r3.getY(r0);
        return true;
    L15:
        return true;
    }

    public final boolean e(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        int r1 = 0;
        if (this.o == true) goto L5;
        return false;
    L5:
        int r0 = r6.getActionIndex();
        if (r0 >= 0) goto L8;
    L23:
        return true;
    L8:
        if (r0 >= r6.getPointerCount()) goto L23;
        if (r6.getPointerId(r0) != this.p) goto L23;
        if (r0 != 0) goto L16;
        r1 = 1;
    L16:
        if (r1 >= r6.getPointerCount()) goto L22;
        if (r1 < 0) goto L23;
        if (r1 >= r6.getPointerCount()) goto L23;
        this.p = r6.getPointerId(r1);
        this.r = r6.getY(r1);
        goto L23
    L22:
        this.p = -1;
        goto L23
    }

    public final boolean f(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (((Boolean) this.b.invoke()).booleanValue() == true) goto L5;
    L10:
        boolean r0 = false;
    L11:
        if (r0 == false) goto L14;
        this.k = true;
        this.l = false;
        this.m = r6.getY();
        this.n = r6.getY();
        return true;
    L14:
        c(r6);
        return false;
    L5:
        if (this.a.getHeight() <= 0) goto L10;
        if (this.a.pointToPosition((int) r6.getX(), (int) r6.getY()) != (-1)) goto L10;
        r0 = true;
        goto L11
    }

    public final boolean g(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (this.o == false) goto L11;
        VelocityTracker r0 = this.s;
        if (r0 == null) goto L8;
        r0.addMovement(r3);
    L8:
        l();
        return true;
    L11:
        if (this.k == false) goto L22;
        this.k = false;
        this.l = false;
        int r4 = c.a;
        BounceEdgeEffect r5 = (BounceEdgeEffect) this.c.invoke();
        if (r5 == null) goto L16;
        r5.onRelease();
    L16:
        BounceEdgeEffect r6 = (BounceEdgeEffect) this.d.invoke();
        if (r6 == null) goto L20;
        r6.onRelease();
    L20:
        this.a.invalidate();
        return true;
    L22:
        return false;
    }

    public final boolean h(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        boolean r2 = false;
        if (this.o == false) goto L23;
        if (r9.getEventTime() != this.t) goto L7;
        return true;
    L7:
        int r0 = r9.findPointerIndex(this.p);
        if (r0 >= 0) goto L11;
        l();
        return true;
    L11:
        float r1 = r9.getY(r0);
        float r4 = r1 - this.r;
        if (r4 != 0.0f) goto L14;
        r2 = true;
    L14:
        if (r2 == true) goto L20;
        VelocityTracker r3 = this.s;
        if (r3 == null) goto L19;
        r3.addMovement(r9);
    L19:
        j(r4);
    L20:
        this.r = r1;
        return true;
    L23:
        if (n(r9) == false) goto L26;
        return true;
    L26:
        if (this.k == false) goto L51;
        float r10 = r9.getY();
        float r5 = r10 - this.m;
        float r6 = r10 - this.n;
        if (this.l == true) goto L33;
        if (Math.abs(r5) <= this.h) goto L33;
        this.l = true;
    L33:
        if (this.l == true) goto L35;
    L49:
        this.n = r10;
        return true;
    L35:
        if (r6 != 0.0f) goto L37;
        r2 = true;
    L37:
        if (r2 == true) goto L49;
        if (this.a.getHeight() <= 0) goto L49;
        if (i(r6 / this.a.getHeight()) == false) goto L44;
    L48:
        this.a.invalidate();
        goto L49
    L44:
        if (r6 <= 0.0f) goto L46;
        k(MathKt.roundToInt(-r6));
        goto L48
    L46:
        if (r6 >= 0.0f) goto L48;
        k(MathKt.roundToInt(-r6));
        goto L48
    L51:
        return false;
    }

    public final boolean i(float r8) {
        BounceEdgeEffect r0 = (BounceEdgeEffect) this.c.invoke();
        BounceEdgeEffect r1 = (BounceEdgeEffect) this.d.invoke();
        boolean r2 = b(r0);
        boolean r3 = b(r1);
        if (r2 == false) goto L10;
        if (r0 != null) goto L6;
        float r4 = 0.0f;
    L7:
        float r9 = r8 - r4;
        if (r9 >= 0.0f) goto L18;
        m(MathKt.roundToInt((-r9) * this.a.getHeight()), 1);
    L18:
        return true;
    L6:
        r4 = r0.j(r8, false);
        goto L7
    L10:
        if (r3 == false) goto L19;
        float r10 = -r8;
        if (r1 != null) goto L14;
        float r5 = 0.0f;
    L15:
        float r11 = r10 - r5;
        if (r11 >= 0.0f) goto L18;
        m(MathKt.roundToInt(r11 * this.a.getHeight()), 0);
        goto L18
    L14:
        r5 = r1.j(r10, false);
        goto L15
    L19:
        return false;
    }

    public final void j(float r3) {
        if (this.a.getHeight() > 0) goto L6;
        return;
    L6:
        if (i(r3 / this.a.getHeight()) == false) goto L8;
    L13:
        this.a.invalidate();
        return;
    L8:
        if (r3 <= 0.0f) goto L11;
        k(MathKt.roundToInt(-r3));
        goto L13
    L11:
        if (r3 >= 0.0f) goto L13;
        k(MathKt.roundToInt(-r3));
        goto L13
    }

    public final void k(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        if (this.a.getHeight() <= 0) goto L26;
        int r5 = a(r4);
        int r0 = c.a;
        if (r5 < 0) goto L9;
    L14:
        if (r5 > 0) goto L16;
        return;
    L16:
        if (this.a.getHeight() <= 0) goto L25;
        BounceEdgeEffect r1 = (BounceEdgeEffect) this.d.invoke();
        if (r1 == null) goto L28;
        r1.j(r5 / this.a.getHeight(), true);
        return;
    L28:
        return;
    L25:
        return;
    L9:
        if (this.a.getHeight() <= 0) goto L14;
        BounceEdgeEffect r2 = (BounceEdgeEffect) this.c.invoke();
        if (r2 == null) goto L27;
        r2.j((-r5) / this.a.getHeight(), true);
        return;
    L27:
        return;
    }

    public final boolean n(MotionEvent r5) {
        boolean r1 = false;
        if (((Boolean) this.b.invoke()).booleanValue() == true) goto L5;
    L27:
        return r1;
    L5:
        if (this.a.getHeight() <= 0) goto L27;
        if (b((BounceEdgeEffect) this.c.invoke()) == false) goto L10;
    L12:
        int r0 = r5.findPointerIndex(this.p);
        if (r0 >= 0) goto L16;
        return false;
    L16:
        if (Math.abs(r5.getY(r0) - this.q) > this.h) goto L18;
        return false;
    L18:
        this.e.invoke();
        VelocityTracker r2 = this.s;
        if (r2 == null) goto L22;
        r2.addMovement(r5);
    L22:
        r1 = true;
        this.o = true;
        this.r = this.q;
        j(r5.getY(r0) - this.r);
        this.r = r5.getY(r0);
        this.t = r5.getEventTime();
        ViewParent r6 = this.a.getParent();
        if (r6 == null) goto L26;
        r6.requestDisallowInterceptTouchEvent(true);
    L26:
        int r7 = c.a;
        goto L27
    L10:
        if (b((BounceEdgeEffect) this.d.invoke()) == true) goto L12;
        return false;
    }

    public final void m(int r3, int r4) {
        if (r3 != 0) goto L4;
        return;
    L4:
        if (this.a.getHeight() <= 0) goto L27;
        int r5 = a(r3);
        int r0 = c.a;
        if (r5 != 0) goto L10;
        return;
    L10:
        if (r4 != 0) goto L16;
        if (r5 >= 0) goto L16;
        BounceEdgeEffect r6 = (BounceEdgeEffect) this.c.invoke();
        if (r6 == null) goto L28;
        r6.j((-r5) / this.a.getHeight(), true);
        return;
    L28:
        return;
    L16:
        if (r4 != 1) goto L25;
        if (r5 <= 0) goto L26;
        BounceEdgeEffect r7 = (BounceEdgeEffect) this.d.invoke();
        if (r7 == null) goto L29;
        r7.j(r5 / this.a.getHeight(), true);
        return;
    L29:
        return;
    L26:
        return;
    L25:
        return;
    }

    public a(AbsListView r2, Function0<Boolean> r3, Function0<BounceEdgeEffect> r4, Function0<BounceEdgeEffect> r5, Function0<Unit> r6, Function0<Unit> r7, Function0<Float> r8) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r3, "edgeEffectsInstalledProvider");
        Intrinsics.checkNotNullParameter(r4, "bounceTopProvider");
        Intrinsics.checkNotNullParameter(r5, "bounceBottomProvider");
        Intrinsics.checkNotNullParameter(r6, "stopBounceIfNeeded");
        Intrinsics.checkNotNullParameter(r7, "resetAbsListViewTouchMode");
        Intrinsics.checkNotNullParameter(r8, "getBounceTranslation");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = ViewConfiguration.get(r2.getContext()).getScaledTouchSlop();
        this.i = ViewConfiguration.get(r2.getContext()).getScaledMinimumFlingVelocity();
        this.j = ViewConfiguration.get(r2.getContext()).getScaledMaximumFlingVelocity();
        this.p = -1;
        this.t = -1;
    }
}
