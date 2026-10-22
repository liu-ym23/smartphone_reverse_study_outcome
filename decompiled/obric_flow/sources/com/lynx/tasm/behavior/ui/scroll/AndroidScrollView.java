package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.b;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.d;
import com.lynx.tasm.n0;
import com.lynx.tasm.p0;
import gn.h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidScrollView extends NestedScrollView implements com.lynx.tasm.behavior.ui.a {
    public static final /* synthetic */ int N = 0;
    public int A;
    public final Rect B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public int K;
    public int L;
    public Rect M;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10595j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f10596k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f10597l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final UIScrollView f10598m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final fn.a f10599n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10600o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CustomHorizontalScrollView f10601p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10602q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10603r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10604t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10605u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10606v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList f10607w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b f10608x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f10609y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f10610z;

    public class CustomHorizontalScrollView extends NestedHorizontalScrollView {
        public final /* synthetic */ AndroidScrollView s;

        public CustomHorizontalScrollView(AndroidScrollView r5, Context r10, UIScrollView r11) {
            this.s = r5;
            super(r10, r11);
        }

        @Override // android.widget.HorizontalScrollView
        public final int computeScrollDeltaToGetChildRectOnScreen(Rect r5) {
            if (this.s.D == false) goto L5;
            return 0;
        L5:
            return super.computeScrollDeltaToGetChildRectOnScreen(r5);
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, android.view.View, androidx.core.view.NestedScrollingChild
        public final boolean dispatchNestedFling(float r5, float r10, boolean r11) {
            boolean r12 = this.f10628q.dispatchNestedFling(r5, r10, r11);
            if (r12 == false) goto L5;
            int r13 = AndroidScrollView.N;
            this.s.g(4);
        L5:
            return r12;
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, android.view.View, androidx.core.view.NestedScrollingChild
        public final boolean dispatchNestedPreFling(float r5, float r10) {
            boolean r11 = this.f10628q.dispatchNestedPreFling(r5, r10);
            if (r11 == false) goto L5;
            int r12 = AndroidScrollView.N;
            this.s.g(4);
        L5:
            return r11;
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, androidx.core.view.NestedScrollingChild2
        public final boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13, int r14) {
            boolean r15 = this.f10628q.dispatchNestedPreScroll(r10, r11, r12, r13, r14);
            if (r15 == false) goto L5;
            int r16 = AndroidScrollView.N;
            this.s.g(4);
        L5:
            return r15;
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, androidx.core.view.NestedScrollingChild2
        public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15) {
            boolean r16 = this.f10628q.dispatchNestedScroll(r10, r11, r12, r13, r14, r15);
            if (r16 == false) goto L5;
            int r17 = AndroidScrollView.N;
            this.s.g(4);
        L5:
            return r16;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchTouchEvent(MotionEvent r5) {
            AndroidScrollView r10 = this.s;
            if (r10.f10598m.isEnableNewGesture() == false) goto L15;
            if (Boolean.FALSE.equals(r10.f10596k) == false) goto L8;
            return true;
        L8:
            if (r5.getActionMasked() != 2) goto L15;
            if (r10.f10596k == null) goto L15;
            if (r10.f10595j == true) goto L15;
            r5.setAction(0);
            r10.f10595j = true;
        L15:
            return super.dispatchTouchEvent(r5);
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, android.widget.HorizontalScrollView
        public final void fling(int r15) {
            AndroidScrollView r5 = this.s;
            if (r5.K != 1) goto L5;
            r5.b(2);
        L5:
            r5.k();
            if (r5.H == true) goto L8;
        L26:
            super.fling(r15);
            return;
        L8:
            if (this.f10616a == true) goto L26;
            Field r10 = HorizontalScrollView.class.getDeclaredField("mScroller");     // Catch: Throwable -> L20
            if (r10 == null) goto L23;
            r10.setAccessible(true);     // Catch: Throwable -> L20
            OverScroller r11 = (OverScroller) r10.get(this);     // Catch: Throwable -> L20
            if (r11 == null) goto L19;
            if (getChildCount() <= 0) goto L29;
            int r12 = (getWidth() - getPaddingRight()) - getPaddingLeft();
            int r13 = getChildAt(0).getWidth();
            r11.fling(getScrollX(), getScrollY(), r15, 0, 0, Math.max(0, r13 - r12), 0, 0, r12 / 2, 0);
            postInvalidateOnAnimation();
            return;
        L29:
            return;
        L19:
            throw new Exception("failed to get mScroller in HorizontalScrollView");     // Catch: Throwable -> L20
        L23:
            throw new Exception("can not find mScroller field in HorizontalScrollView");     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            LynxLog.b(3, "AndroidScrollView", th.getMessage());
            super.fling(r15);
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, android.widget.HorizontalScrollView, android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent r5) {
            AndroidScrollView r10 = this.s;
            if (r10.s == true) goto L5;
            return false;
        L5:
            if (r10.f(r5) == false) goto L8;
            return false;
        L8:
            if (r10.i() == false) goto L11;
            return false;
        L11:
            if (r10.f10598m.isEnableNewGesture() == false) goto L19;
            Boolean r11 = r10.f10597l;
            if (r11 == null) goto L19;
            if (r11.booleanValue() == false) goto L19;
            return r10.f10597l.booleanValue();
        L19:
            return super.onInterceptTouchEvent(r5);
        }

        @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
            int r14 = getScrollX();
            super.onLayout(r5, r10, r11, r12, r13);
            AndroidScrollView r15 = this.s;
            if (r15.s == true) goto L6;
            return;
        L6:
            if (getChildCount() <= 0) goto L8;
            int r16 = getChildAt(0).getMeasuredWidth();
        L9:
            int r17 = Math.max(0, r16 - (((r12 - r10) - getPaddingLeft()) - getPaddingRight()));
            if (r15.G == false) goto L17;
            if (ViewCompat.getLayoutDirection(this) != 1) goto L14;
            int r18 = r17;
        L15:
            setScrollX(r18);
            r15.G = false;
            r15.f10603r = getScrollX();
        L28:
            r15.F = r17;
            int r19 = this.f10629r.f;
            if (this.f10618c == false) goto L35;
            if (r19 > 0) goto L32;
            return;
        L32:
            if (r19 == getScrollX()) goto L37;
            r15.d(r19, getScrollY(), false);
            return;
        L37:
            return;
        L35:
            return;
        L14:
            r18 = 0;
            goto L15
        L17:
            if (ViewCompat.getLayoutDirection(this) != 1) goto L28;
            if (ViewCompat.isLaidOut(this) == false) goto L21;
        L23:
            int r20 = r15.F;
            if (r20 == r17) goto L27;
            if (r20 < 0) goto L27;
            setScrollX(MathUtils.clamp((r17 - r20) + r14, 0, r17));
        L27:
            r15.f10603r = getScrollX();
            goto L28
        L21:
            if (r15.F != r17) goto L23;
            setScrollX(r15.f10603r);
            goto L27
        L8:
            r16 = 0;
            goto L9
        }

        @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r5, int r10) {
            super.onMeasure(r5, r10);
        }

        @Override // android.view.View
        public final void onScrollChanged(int r5, int r10, int r11, int r12) {
            super.onScrollChanged(r5, r10, r11, r12);
            AndroidScrollView r13 = this.s;
            if (r5 == r13.f10603r) goto L16;
            r13.f10603r = getScrollX();
            if (r13.K != 0) goto L8;
            r13.j();
        L8:
            r13.c(r5, r10, r11, r12);
            if (r13.f10604t == false) goto L11;
            return;
        L11:
            if (r13.C == true) goto L15;
            r13.f10598m.N();
            return;
        L15:
            return;
        }

        @Override // com.lynx.tasm.behavior.ui.scroll.NestedHorizontalScrollView, android.widget.HorizontalScrollView, android.view.View
        public final boolean onTouchEvent(MotionEvent r10) {
            AndroidScrollView r5 = this.s;
            if (r5.s == true) goto L5;
        L49:
            return false;
        L5:
            if (r5.i() == false) goto L8;
            return false;
        L8:
            if (r5.f(r10) == true) goto L10;
            UIScrollView r11 = r5.f10598m;
            if (r11.isEnableNewGesture() == false) goto L33;
            if (r5.f10597l == null) goto L33;
            if (r10.getActionMasked() != 0) goto L21;
            getParent().requestDisallowInterceptTouchEvent(true);
            goto L33
        L21:
            if (r10.getActionMasked() != 2) goto L28;
            getParent().requestDisallowInterceptTouchEvent(r5.f10597l.booleanValue());
            boolean r12 = r5.f10597l.booleanValue();
            if (r5.f10597l.booleanValue() == false) goto L25;
            return r12;
        L25:
            return super.onTouchEvent(r10);
        L28:
            if (r10.getActionMasked() != 1) goto L30;
        L31:
            r5.f10597l = null;
            goto L33
        L30:
            if (r10.getActionMasked() == 3) goto L31;
        L33:
            if (r10.getAction() != 2) goto L35;
            boolean r13 = true;
        L36:
            r5.I = r13;
            if (r10.getAction() != 1) goto L40;
            r5.f10604t = false;
            r5.I = false;
            r11.N();
        L51:
            return super.onTouchEvent(r10);
        L47:
            e = move-exception;
            LynxLog.b(4, "LynxUIScrollView", "CustomHorizontalScrollView onTouchEvent: " + r10.getAction() + ", " + e.getMessage());     // Catch: Throwable -> L50
            goto L49
        L40:
            if (r10.getAction() != 0) goto L43;
            r5.f10604t = true;
            r11.u(r5.K);
            goto L51
        L43:
            if (r10.getAction() != 3) goto L51;
            r5.I = false;
            goto L51
        L35:
            r13 = false;
            goto L36
        L10:
            if (r10.getActionMasked() != 1) goto L12;
            r5.f10604t = false;
        L12:
            return false;
        }

        @Override // android.view.View, androidx.core.view.NestedScrollingChild
        public final boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13) {
            boolean r14 = dispatchNestedPreScroll(r10, r11, r12, r13, 0);
            if (r14 == false) goto L5;
            int r15 = AndroidScrollView.N;
            this.s.g(4);
        L5:
            return r14;
        }

        @Override // android.view.View, androidx.core.view.NestedScrollingChild
        public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
            boolean r15 = dispatchNestedScroll(r10, r11, r12, r13, r14, 0);
            if (r15 == false) goto L5;
            int r16 = AndroidScrollView.N;
            this.s.g(4);
        L5:
            return r15;
        }
    }

    public AndroidScrollView(Context r10, UIScrollView r11) {
        super(r10, r11);
        this.f10595j = true;
        this.f10596k = null;
        this.f10597l = null;
        this.f10600o = false;
        this.s = false;
        this.f10604t = false;
        this.f10605u = 0;
        this.f10606v = 0;
        this.f10610z = 0;
        this.A = 0;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = 0;
        this.L = 0;
        this.M = null;
        this.f10598m = r11;
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
        setFadingEdgeLength(0);
        setScrollContainer(false);
        this.B = new Rect();
        this.f10607w = new ArrayList();
        if (this.f10599n != null) goto L5;
        fn.a r5 = new fn.a(this, getContext(), 1);
        this.f10599n = r5;
        r5.setOrientation(1);
        r5.setWillNotDraw(true);
        r5.setFocusableInTouchMode(true);
        CustomHorizontalScrollView r12 = new CustomHorizontalScrollView(this, getContext(), r11);
        this.f10601p = r12;
        r12.setOverScrollMode(2);
        r12.setFadingEdgeLength(0);
        r12.setWillNotDraw(true);
        r12.addView(r5, new FrameLayout.LayoutParams(-1, -1));
        addView(r12, new FrameLayout.LayoutParams(-2, -2));
    L5:
        this.f10609y = new a(this);
    }

    public static void e(View r5) {
    L7:
        th = move-exception;
        LynxLog.b(3, "AndroidScrollView", th.getMessage());
        return;
    L5:
        if ((r5 instanceof HorizontalScrollView) == false) goto L10;
        Field r10 = HorizontalScrollView.class.getDeclaredField("mScroller");     // Catch: Throwable -> L7
    L13:
        if (r10 != null) goto L16;
        LynxLog.b(3, "AndroidScrollView", "did not find mScroller in ".concat(r5.getClass().getName()));     // Catch: Throwable -> L7
        return;
    L16:
        r10.setAccessible(true);     // Catch: Throwable -> L7
        OverScroller r11 = (OverScroller) r10.get(r5);     // Catch: Throwable -> L7
        if (r11.isFinished() == true) goto L23;
        r11.abortAnimation();     // Catch: Throwable -> L7
        return;
    L23:
        return;
    L10:
        if ((r5 instanceof ScrollView) == false) goto L12;
        r10 = ScrollView.class.getDeclaredField("mScroller");     // Catch: Throwable -> L7
        goto L13
    L12:
        r10 = null;
        goto L13
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final void addView(View r5) {
        if (this.f10600o == false) goto L6;
        this.f10599n.addView(r5);
        return;
    L6:
        super.addView(r5);
        this.f10600o = true;
    }

    public final void b(int r5) {
        LynxLog.b(2, "LynxUIScrollView", "notifyStateChange " + this.K + " -> " + r5);
        int r10 = this.K;
        if (r10 == r5) goto L6;
        this.L = r10;
        this.K = r5;
        g(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public final void bindDrawChildHook(b r5) {
        this.f10608x = r5;
    }

    public final void c(int r10, int r11, int r12, int r13) {
        ArrayList r14 = this.f10607w;
        if (r14 == null) goto L36;
        Iterator r15 = r14.iterator();
    L6:
        if (r15.hasNext() == false) goto L45;
        gn.b r5 = (gn.b) r15.next();
        if (r5 == null) goto L6;
        UIScrollView r16 = ((h) r5).f17117b;
        if (r16.f10643l == false) goto L13;
        r16.L();
    L13:
        if (r16.g == false) goto L16;
        r16.o("scroll", r10, r11, r12, r13);
    L16:
        if (r16.d == true) goto L19;
        if (r16.f10637b == false) goto L6;
    L19:
        int r17 = r16.p(r10, r11, r16.f10648q, r16.f10647p);
        if (r16.d == false) goto L28;
        if ((r17 & 2) == 0) goto L28;
        if ((r16.f10649r & 2) != 0) goto L28;
        r16.o("scrolltolower", r16.getScrollX(), r16.getScrollY(), r16.getScrollX(), r16.getScrollY());
    L35:
        r16.f10649r = r17;
    L28:
        if (r16.f10637b == false) goto L35;
        if ((r17 & 1) == 0) goto L35;
        if ((r16.f10649r & 1) != 0) goto L35;
        r16.o("scrolltoupper", r16.getScrollX(), r16.getScrollY(), r16.getScrollX(), r16.getScrollY());
        goto L35
    L45:
        return;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r5) {
        if (this.f10598m.isEnableNewGesture() == false) goto L7;
        return super.canScrollVertically(r5);
    L7:
        if (this.J == false) goto L11;
        if (this.s == true) goto L11;
        return true;
    L11:
        if (super.canScrollVertically(r5) == true) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.widget.ScrollView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        UIScrollView r5 = this.f10598m;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.s == (-1)) goto L7;
        LynxLog.b(2, "LynxUIScrollView", "computeScroll: apply mPendingScrollToIndex when computing scroll " + r5.s);
        setScrollToIndex(r5.s);
        r5.s = -1;
    L7:
        r5.J();
        if (r5.isEnableNewGesture() == false) goto L14;
        sn.a r10 = r5.getGestureArenaManager();
        if (r10 == null) goto L15;
        r10.a();
        return;
    L15:
        return;
    }

    @Override // android.widget.ScrollView
    public final int computeScrollDeltaToGetChildRectOnScreen(Rect r5) {
        if (this.D == false) goto L5;
        return 0;
    L5:
        return super.computeScrollDeltaToGetChildRectOnScreen(r5);
    }

    public final void d(int r5, int r10, boolean r11) {
        if (this.f10603r == r5) goto L5;
    L7:
        CustomHorizontalScrollView r12 = this.f10601p;
        if (r11 == false) goto L16;
        if (this.s == false) goto L13;
        r12.setSmoothScrollingEnabled(true);
        r12.a(r5, r10);
        return;
    L13:
        setSmoothScrollingEnabled(true);
        a(r5, r10);
        return;
    L16:
        if (this.s == false) goto L19;
        e(r12);
        r12.scrollTo(r5, r10);
        return;
    L19:
        e(this);
        scrollTo(r5, r10);
        return;
    L5:
        if (this.f10602q != r10) goto L7;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r11) {
        Drawable r5 = getBackground();
        if ((r5 instanceof BackgroundDrawable) == false) goto L14;
        BackgroundDrawable r10 = (BackgroundDrawable) r5;
        RectF r12 = r10.d();
        d r13 = r10.f10725z;
        Rect r14 = this.M;
        if (r14 != null) goto L7;
        r14 = r5.getBounds();
    L7:
        Path r15 = new Path();
        float r16 = r14.left + r12.left;
        float r17 = r14.top + r12.top;
        float r18 = this.f10602q;
        RectF r19 = new RectF(r16, r17 + r18, r14.right - r12.right, (r14.bottom - r12.bottom) + r18);
        if (r13 != null) goto L10;
        r15.addRect(r19, Path.Direction.CW);
    L11:
        int r20 = r11.save();
        r11.clipPath(r15);
        super.dispatchDraw(r11);
        r11.restoreToCount(r20);
        return;
    L10:
        r15.addRoundRect(r19, com.lynx.tasm.behavior.ui.utils.a.c(r13.c(), r12, 1.0f), Path.Direction.CW);
        goto L11
    L14:
        if ((getParent() instanceof ViewGroup) == false) goto L26;
        ViewGroup r21 = (ViewGroup) getParent();
        if (getClipBounds() != null) goto L26;
        int r22 = getScrollX();
        int r23 = getScrollY();
        int r24 = getScrollX();
        Rect r25 = this.M;
        if (r25 != null) goto L20;
        int r26 = getWidth();
    L21:
        int r27 = r24 + r26;
        int r28 = getScrollY();
        Rect r29 = this.M;
        if (r29 != null) goto L24;
        int r30 = getHeight();
    L25:
        int r31 = r28 + r30;
        Rect r32 = this.B;
        r32.set(r22, r23, r27, r31);
        r11.clipRect(r32);
        goto L26
    L24:
        r30 = r29.height();
        goto L25
    L20:
        r26 = r25.width();
    L26:
        super.dispatchDraw(r11);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r5, float r10, boolean r11) {
        boolean r12 = this.f10631b.dispatchNestedFling(r5, r10, r11);
        if (r12 == false) goto L5;
        g(4);
    L5:
        return r12;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r5, float r10) {
        boolean r11 = this.f10631b.dispatchNestedPreFling(r5, r10);
        if (r11 == false) goto L5;
        g(4);
    L5:
        return r11;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13, int r14) {
        boolean r15 = this.f10631b.dispatchNestedPreScroll(r10, r11, r12, r13, r14);
        if (r15 == false) goto L5;
        g(4);
    L5:
        return r15;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15) {
        boolean r16 = this.f10631b.dispatchNestedScroll(r10, r11, r12, r13, r14, r15);
        if (r16 == false) goto L5;
        g(4);
    L5:
        return r16;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (this.f10598m.isEnableNewGesture() == false) goto L15;
        if (Boolean.FALSE.equals(this.f10596k) == false) goto L8;
        return true;
    L8:
        if (r5.getActionMasked() != 2) goto L15;
        if (this.f10596k == null) goto L15;
        if (this.f10595j == true) goto L15;
        r5.setAction(0);
        this.f10595j = true;
    L15:
        return super.dispatchTouchEvent(r5);
    }

    public final boolean f(MotionEvent r5) {
        if (this.f10598m.isEnableNewGesture() == false) goto L12;
        Boolean r10 = this.f10596k;
        if (r10 != null) goto L7;
        return false;
    L7:
        if (r10.booleanValue() == false) goto L9;
        return false;
    L9:
        if (r5.getActionMasked() == 0) goto L16;
        return true;
    L16:
        return false;
    L12:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.widget.ScrollView
    public final void fling(int r5) {
        super.fling(r5);
        if (this.K != 1) goto L5;
        b(2);
    L5:
        k();
    }

    public final void g(int r5) {
        ArrayList r10 = this.f10607w;
        if (r10 == null) goto L15;
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L27;
        gn.b r12 = (gn.b) r11.next();
        if (r12 == null) goto L6;
        LynxLog.b(2, "LynxUIScrollView", "onScrollStateChanged: " + r5);
        UIScrollView r13 = ((h) r12).f17117b;
        r13.u(r5);
        if (r13.B == null) goto L6;
        if (r5 != 0) goto L6;
        if (((AndroidScrollView) UIScrollView.q(r13)).L != 3) goto L6;
        Callback r14 = r13.B;
        String r15 = r13.C;
        r13.B = null;
        r13.C = "";
        r14.invoke(new Object[]{0, r15});
        goto L6
    L27:
        return;
    }

    public int getContentHeight() {
        return this.f10606v;
    }

    public int getContentWidth() {
        return this.f10605u;
    }

    public CustomHorizontalScrollView getHScrollView() {
        return this.f10601p;
    }

    public LinearLayout getLinearLayout() {
        return this.f10599n;
    }

    public int getOrientation() {
        return this.f10599n.getOrientation();
    }

    public int getRealScrollX() {
        if (this.s == false) goto L7;
        return this.f10601p.getScrollX();
    L7:
        return getScrollX();
    }

    public int getRealScrollY() {
        if (this.s == false) goto L7;
        return this.f10601p.getScrollY();
    L7:
        return getScrollY();
    }

    public final void h(int r10, int r11) {
        UIScrollView r12 = this.f10598m;
        int r13 = r12.p(r10, r11, 0, 0);
        if (r12.e == false) goto L8;
        if ((r13 & 2) == 0) goto L8;
        r12.o("scrolltoloweredge", getScrollX(), getScrollY(), getScrollX(), getScrollY());
    L8:
        if (r12.f10638c == false) goto L13;
        if ((r13 & 1) == 0) goto L13;
        r12.o("scrolltoupperedge", getScrollX(), getScrollY(), getScrollX(), getScrollY());
    L13:
        if (r12.f == true) goto L15;
        return;
    L15:
        if ((r13 & 1) == 0) goto L18;
        return;
    L18:
        if ((r13 & 2) == 0) goto L20;
        return;
    L20:
        r12.o("scrolltonormalstate", getScrollX(), getScrollY(), getScrollX(), getScrollY());
    }

    public final boolean i() {
        UIScrollView r5 = this.f10598m;
        if (r5.isEnableNewGesture() == true) goto L5;
        return false;
    L5:
        if (r5.getIncludeNativeGesture() == true) goto L10;
        return true;
    L10:
        return false;
    }

    public final void j() {
        ArrayList r5 = this.f10607w;
        if (r5 == null) goto L22;
        Iterator r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L22;
        gn.b r11 = (gn.b) r10.next();
        if (r11 == null) goto L6;
        h r12 = (h) r11;
        UIScrollView r13 = r12.f17117b;
        LynxContext r14 = r13.getLynxContext();
        if (r14.C != null) goto L12;
        r14.C = new qn.a(r14);
    L12:
        r14.C.c(r13.getSign(), r13.getScrollMonitorTag());
        if (r13.f10643l == false) goto L16;
        r13.L();
    L16:
        if (r13.f10639h == false) goto L19;
        r13.o("scrollstart", r13.getScrollX(), r13.getScrollY(), r13.getScrollX(), r13.getScrollY());
    L19:
        if (r13.isEnableScrollMonitor() == false) goto L6;
        p0 r15 = r13.getLynxContext().f10150r;
        String r16 = r13.getTagName();
        String r17 = r13.getScrollMonitorTag();
        r15.onScrollStart(new n0(r16, r12.f17116a, r17));
    L22:
        if (this.f10604t == false) goto L24;
    L27:
        int r18 = 1;
    L28:
        b(r18);
        this.f10610z = getScrollY();
        this.A = this.f10601p.getScrollX();
        postDelayed(this.f10609y, 100);
        return;
    L24:
        if (this.I == true) goto L27;
        r18 = 3;
        goto L28
    }

    public final void k() {
        ArrayList r5 = this.f10607w;
        if (r5 == null) goto L15;
        Iterator r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L25;
        gn.b r11 = (gn.b) r10.next();
        if (r11 == null) goto L6;
        UIScrollView r12 = ((h) r11).f17117b;
        View r13 = UIScrollView.k(r12);
        if (r13 == null) goto L6;
        if (r12.isEnableScrollMonitor() == false) goto L6;
        r12.getLynxContext().f10150r.onFling(new n0(r12.getTagName(), r13, r12.getScrollMonitorTag()));
        goto L6
    L25:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.widget.ScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        if (this.s == true) goto L23;
        UIScrollView r10 = this.f10598m;
        if (r10.f10644m == false) goto L8;
        requestDisallowInterceptTouchEvent(true);
    L8:
        if (i() == false) goto L11;
        return false;
    L11:
        if (f(r5) == false) goto L14;
        return false;
    L14:
        if (r10.isEnableNewGesture() == false) goto L22;
        Boolean r11 = this.f10597l;
        if (r11 == null) goto L22;
        if (r11.booleanValue() == false) goto L22;
        return this.f10597l.booleanValue();
    L22:
        return super.onInterceptTouchEvent(r5);
    L23:
        return false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        if (this.s == true) goto L11;
        int r14 = this.f10634i.f;
        if (this.e == false) goto L12;
        if (r14 > 0) goto L8;
        return;
    L8:
        if (r14 == getScrollY()) goto L14;
        d(getScrollX(), r14, false);
        return;
    L14:
        return;
    L12:
        return;
    }

    @Override // android.view.View
    public final void onScrollChanged(int r5, int r10, int r11, int r12) {
        super.onScrollChanged(r5, r10, r11, r12);
        if (r10 != this.f10602q) goto L5;
        return;
    L5:
        this.f10602q = getScrollY();
        if (this.K != 0) goto L8;
        j();
    L8:
        c(r5, r10, r11, r12);
        if (this.f10604t == false) goto L11;
    L13:
        h(r5, r10);
        return;
    L11:
        if (this.C == true) goto L13;
        this.f10598m.N();
        goto L13
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.NestedScrollView, android.widget.ScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        NestedScrollingChildHelper r5 = this.f10631b;
        if (this.s == false) goto L5;
    L70:
        return false;
    L5:
        if (i() == false) goto L8;
        return false;
    L8:
        if (f(r10) == true) goto L10;
        UIScrollView r11 = this.f10598m;
        if (r11.isEnableNewGesture() == false) goto L33;
        if (this.f10597l == null) goto L33;
        if (r10.getActionMasked() != 0) goto L21;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L33
    L21:
        if (r10.getActionMasked() != 2) goto L28;
        getParent().requestDisallowInterceptTouchEvent(this.f10597l.booleanValue());
        boolean r12 = this.f10597l.booleanValue();
        if (this.f10597l.booleanValue() == false) goto L25;
        return r12;
    L25:
        return super.onTouchEvent(r10);
    L28:
        if (r10.getActionMasked() != 1) goto L30;
    L31:
        this.f10597l = null;
        goto L33
    L30:
        if (r10.getActionMasked() == 3) goto L31;
    L33:
        if (r10.getAction() != 2) goto L35;
        boolean r13 = true;
    L36:
        this.I = r13;
        boolean r14 = super.onTouchEvent(r10);     // Catch: IllegalStateException -> L50 Throwable -> L61
        goto L62
    L39:
        if (r10.getAction() != 1) goto L43;
        this.f10604t = false;
        this.I = false;
        r11.N();
        r5.stopNestedScroll(0);
        return r14;
    L43:
        if (r10.getAction() != 0) goto L47;
        this.f10604t = true;
        r11.u(this.K);
        return r14;
    L47:
        if (r10.getAction() != 3) goto L49;
        this.I = false;
        r5.stopNestedScroll(0);
    L49:
        return r14;
    L50:
        e = move-exception;
        LynxLog.b(4, "LynxUIScrollView", "AndroidScrollView onTouchEvent: " + r10.getAction() + ", " + e.getMessage());     // Catch: Throwable -> L61
        if (r10.getAction() != 1) goto L56;
    L63:
        this.f10604t = false;
        this.I = false;
        r11.N();
        r5.stopNestedScroll(0);
        goto L70
    L56:
        if (r10.getAction() != 0) goto L59;
    L66:
        this.f10604t = true;
        r11.u(this.K);
        goto L70
    L59:
        if (r10.getAction() != 3) goto L70;
    L69:
        this.I = false;
        r5.stopNestedScroll(0);
    L62:
        if (r10.getAction() == 1) goto L63;
        if (r10.getAction() == 0) goto L66;
        if (r10.getAction() != 3) goto L70;
    L35:
        r13 = false;
        goto L36
    L10:
        if (r10.getActionMasked() != 1) goto L12;
        this.f10604t = false;
    L12:
        return false;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        if (this.f10600o == false) goto L6;
        this.f10599n.removeAllViews();
        return;
    L6:
        super.removeAllViews();
        this.f10600o = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r5) {
        if (this.f10600o == false) goto L6;
        this.f10599n.removeView(r5);
        return;
    L6:
        super.removeView(r5);
        this.f10600o = true;
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r5) {
        if (this.f10600o == false) goto L6;
        this.f10599n.removeViewAt(r5);
        return;
    L6:
        super.removeViewAt(r5);
        this.f10600o = true;
    }

    public void setBlockDescendantFocusability(boolean r5) {
        this.D = r5;
    }

    @Override // android.view.View
    public void setClipBounds(Rect r5) {
        this.M = r5;
    }

    public void setEnableScroll(boolean r5) {
        fn.d r10 = new fn.d(r5, 1);
        this.f10601p.setOnTouchListener(r10);
        setOnTouchListener(r10);
    }

    public void setForbidFlingFocusChange(boolean r5) {
        this.H = r5;
    }

    public void setForceCanScroll(boolean r5) {
        this.J = r5;
    }

    public void setOnScrollListener(gn.b r5) {
        if (this.f10607w != null) goto L5;
        this.f10607w = new ArrayList();
    L5:
        if (r5 == null) goto L8;
        this.f10607w.add(r5);
        return;
    }

    public void setOrientation(int r5) {
        fn.a r10 = this.f10599n;
        if (r5 != 0) goto L6;
        r10.setOrientation(0);
        this.s = true;
        return;
    L6:
        if (r5 != 1) goto L9;
        r10.setOrientation(1);
        this.s = false;
        return;
    }

    @Override // android.view.View
    public final void setPadding(int r5, int r10, int r11, int r12) {
        this.f10599n.setPadding(r5, r10, r11, r12);
    }

    public void setScrollBarEnable(boolean r5) {
        setVerticalScrollBarEnabled(r5);
    }

    public void setScrollToIndex(int r10) {
        UIScrollView r5 = this.f10598m;
        if (r5 == null) goto L21;
        int r11 = r5.getChildCount();
        if (r11 == 0) goto L22;
        if (r10 < 0) goto L23;
        if (r10 < r11) goto L9;
        return;
    L9:
        if (r5.getChildAt(r10) != null) goto L12;
        return;
    L12:
        if (this.s == false) goto L19;
        CustomHorizontalScrollView r12 = this.f10601p;
        int r13 = r12.getScrollY();
        r12.getScrollX();
        LynxBaseUI r14 = r5.getChildAt(r10);
        if (ViewCompat.getLayoutDirection(this) != 1) goto L16;
        int r15 = r14.getLeft();
        int r16 = (r14.getWidth() + r15) - r5.getWidth();
    L17:
        d(r16, r13, false);
        return;
    L16:
        r16 = r14.getLeft();
        goto L17
    L19:
        d(getScrollX(), r5.getChildAt(r10).getTop(), false);
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13) {
        boolean r14 = dispatchNestedPreScroll(r10, r11, r12, r13, 0);
        if (r14 == false) goto L5;
        g(4);
    L5:
        return r14;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        boolean r15 = dispatchNestedScroll(r10, r11, r12, r13, r14, 0);
        if (r15 == false) goto L5;
        g(4);
    L5:
        return r15;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final void addView(View r5, int r10) {
        if (this.f10600o == false) goto L6;
        this.f10599n.addView(r5, r10);
        return;
    L6:
        super.addView(r5, r10);
        this.f10600o = true;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        if (this.f10600o == false) goto L6;
        this.f10599n.addView(r5, r10, r11);
        return;
    L6:
        super.addView(r5, r10, r11);
        this.f10600o = true;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r5, ViewGroup.LayoutParams r10) {
        if (this.f10600o == false) goto L6;
        this.f10599n.addView(r5, r10);
        return;
    L6:
        super.addView(r5, r10);
        this.f10600o = true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r5, int r10, int r11) {
        if (this.f10600o == false) goto L6;
        this.f10599n.addView(r5, r10, r11);
        return;
    L6:
        super.addView(r5, r10, r11);
        this.f10600o = true;
    }
}
