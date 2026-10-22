package com.bytedance.android.livesdk.chatroom.ui.pullrefresh;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.b1;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Objects;
import no1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DoubleBallSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int[] I = null;
    public boolean A;
    public int B;
    public final int C;
    public final int D;
    public final a E;
    public final c F;
    public final d G;
    public final e H;
    public View a;
    public SwipeRefreshLayout.f b;
    public boolean c;
    public final int d;
    public float e;
    public boolean f;
    public final Scroller g;
    public float h;
    public final NestedScrollingParentHelper i;
    public final NestedScrollingChildHelper j;
    public final int[] k;
    public final int[] l;
    public boolean m;
    public final int n;
    public float o;
    public float p;
    public boolean q;
    public int r;
    public final DecelerateInterpolator s;
    public LiveDoubleColorBallAnimationView t;
    public final int u;
    public final int v;
    public MaterialProgressDrawable w;
    public no1.b x;
    public no1.d y;
    public no1.d z;

    public class a implements Animation.AnimationListener {
        public final /* synthetic */ DoubleBallSwipeRefreshLayout a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public a(DoubleBallSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r3) {
            DoubleBallSwipeRefreshLayout r4 = this.a;
            if (r4.c == false) goto L9;
            r4.H.b(false);
            MaterialProgressDrawable r5 = this.a.w;
            r5.b.u = 255;
            r5.start();
            DoubleBallSwipeRefreshLayout r6 = this.a;
            if (r6.A == false) goto L11;
            SwipeRefreshLayout.f r7 = r6.b;
            if (r7 == null) goto L12;
            r7.onRefresh();
            return;
        L12:
            return;
        L11:
            return;
        L9:
            r4.d();
        }
    }

    public class b implements Animation.AnimationListener {
        public final /* synthetic */ DoubleBallSwipeRefreshLayout a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public b(DoubleBallSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r4) {
            this.a.getClass();
            DoubleBallSwipeRefreshLayout r5 = this.a;
            r5.getClass();
            no1.c r0 = new no1.c(r5);
            r5.getClass();
            r0.setDuration(150);
        }
    }

    public class c extends Animation {
        public final /* synthetic */ DoubleBallSwipeRefreshLayout a;

        public c(DoubleBallSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r2, Transformation r3) {
            this.a.getClass();
            DoubleBallSwipeRefreshLayout r4 = this.a;
            int r0 = r4.v;
            Math.abs(r4.u);
            this.a.w.a(1.0f - r2);
        }
    }

    public class d extends Animation {
        public final /* synthetic */ DoubleBallSwipeRefreshLayout a;

        public d(DoubleBallSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r1, Transformation r2) {
            this.a.getClass();
        }
    }

    public class e extends g {
        @Override // no1.g
        public final void a() {
        }

        public e() {
        }
    }

    public interface f {
    }

    public void setAnimationProgress(float r1) {
    }

    public void setColorScheme(int... r1) {
    }

    public void setOnChildScrollUpCallback(f r1) {
    }

    public void setOnSwipeChangeListener(SwipeRefreshLayout.g r1) {
    }

    static {
        I = new int[]{R.attr.enabled};
    }

    public final void a() {
        if (this.a != null) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= getChildCount()) goto L15;
        View r1 = getChildAt(r0);
        if (r1.equals(this.t) == false) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        this.a = r1;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.g.computeScrollOffset() == false) goto L6;
        scrollTo(this.g.getCurrX(), this.g.getCurrY());
        invalidate();
        return;
    }

    public final void d() {
        this.H.b(true);
        this.w.stop();
        setColorViewAlpha(255);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.i.getNestedScrollAxes();
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.j.hasNestedScrollingParent();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.j.isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.j.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public int getProgressCircleDiameter() {
        return this.B;
    }

    public int getProgressViewEndOffset() {
        return this.v;
    }

    public int getProgressViewStartOffset() {
        return this.u;
    }

    public DoubleBallSwipeRefreshLayout(Context r2) {
        this(r2, null);
    }

    private void setColorViewAlpha(int r2) {
        this.w.b.u = r2;
    }

    public final void b(float r9) {
        if (r9 <= this.e) goto L5;
        e(true, true);
        return;
    L5:
        this.c = false;
        MaterialProgressDrawable r0 = this.w;
        MaterialProgressDrawable.b r1 = r0.b;
        r1.e = 0.0f;
        r1.a();
        MaterialProgressDrawable.b r2 = r0.b;
        r2.f = 0.0f;
        r2.a();
        b r3 = new b(this);
        e r4 = this.H;
        r4.getClass();
        no1.f r5 = new no1.f(r4, r3);
        e r6 = this.H;
        r6.getClass();
        Objects.toString(r5);
        r6.b(false);
        this.G.reset();
        this.G.setDuration(200);
        this.G.setInterpolator(this.s);
        r5.onAnimationEnd(this.F);
        MaterialProgressDrawable.b r7 = this.w.b;
        if (r7.o == false) goto L8;
        r7.o = false;
        r7.a();
    L8:
        this.g.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
        this.t.c();
    }

    public final void c(float r13) {
        MaterialProgressDrawable.b r0 = this.w.b;
        boolean r2 = true;
        if (r0.o == true) goto L5;
        r0.o = true;
        r0.a();
    L5:
        float r1 = r13 / this.e;
        float r3 = (((float) Math.max(((double) Math.min(1.0f, Math.abs(r1))) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float r4 = Math.abs(r13) - this.e;
        float r5 = this.v;
        double r7 = Math.max(0.0f, Math.min(r4, r5 * 2.0f) / r5) / 4.0f;
        float r6 = ((float) (r7 - Math.pow(r7, 2.0d))) * 2.0f;
        if (r13 >= this.e) goto L20;
        if (this.w.b.u <= 76) goto L31;
        no1.d r14 = this.y;
        if (r14 != null) goto L12;
    L16:
        r2 = false;
    L17:
        if (r2 == true) goto L31;
        no1.d r8 = new no1.d(this, this.w.b.u, 76);
        r8.setDuration(300);
        this.y = r8;
        goto L31
    L12:
        if (r14.hasStarted() == false) goto L16;
        if (r14.hasEnded() == true) goto L16;
    L31:
        float r15 = (float) Math.atan(r1);
        scrollTo(0, (int) ((-this.e) * r15));
        this.t.setProgress(Math.max(0.0f, Math.min(1.0f, r15 - 0.5f)));
        MaterialProgressDrawable r9 = this.w;
        float r16 = Math.min(0.8f, r3 * 0.8f);
        MaterialProgressDrawable.b r10 = r9.b;
        r10.e = 0.0f;
        r10.a();
        MaterialProgressDrawable.b r11 = r9.b;
        r11.f = r16;
        r11.a();
        this.w.a(Math.min(1.0f, r3));
        MaterialProgressDrawable.b r17 = this.w.b;
        r17.g = (((r3 * 0.4f) - 0.25f) + (r6 * 2.0f)) * 0.5f;
        r17.a();
        e r18 = this.H;
        r18.getClass();
        r18.b(false);
        return;
    L20:
        if (this.w.b.u >= 255) goto L31;
        no1.d r19 = this.z;
        if (r19 != null) goto L24;
    L28:
        r2 = false;
    L29:
        if (r2 == true) goto L31;
        no1.d r12 = new no1.d(this, this.w.b.u, 255);
        r12.setDuration(300);
        this.z = r12;
        goto L31
    L24:
        if (r19.hasStarted() == false) goto L28;
        if (r19.hasEnded() == true) goto L28;
        goto L28
    }

    public final void f(float r4) {
        float r0 = this.p;
        float r5 = r4 - r0;
        int r1 = this.d;
        if (r5 > r1) goto L5;
        return;
    L5:
        if (this.q == true) goto L9;
        this.o = r0 + r1;
        this.q = true;
        this.w.b.u = 76;
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        a();
        int r0 = MotionEventCompat.getActionMasked(r6);
        int r2 = 0;
        if (isEnabled() == true) goto L5;
    L40:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L40;
        if (this.c == true) goto L40;
        if (this.m == true) goto L40;
        if (r0 != 0) goto L13;
        int r1 = r6.getPointerId(0);
        this.r = r1;
        this.q = false;
        int r3 = r6.findPointerIndex(r1);
        if (r3 >= 0) goto L37;
        return false;
    L37:
        this.p = r6.getY(r3);
    L39:
        return this.q;
    L13:
        if (r0 != 1) goto L15;
    L33:
        this.q = false;
        this.r = -1;
        goto L39
    L15:
        if (r0 != 2) goto L17;
        int r4 = this.r;
        if (r4 != (-1)) goto L29;
        return false;
    L29:
        int r5 = r6.findPointerIndex(r4);
        if (r5 >= 0) goto L32;
        return false;
    L32:
        f(r6.getY(r5));
        goto L39
    L17:
        if (r0 == 3) goto L33;
        if (r0 != 6) goto L39;
        int r7 = MotionEventCompat.getActionIndex(r6);
        if (r6.getPointerId(r7) != this.r) goto L39;
        if (r7 != 0) goto L25;
        r2 = 1;
    L25:
        this.r = r6.getPointerId(r2);
        goto L39
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r3) {
        this.i.onStopNestedScroll(r3);
        this.m = false;
        float r4 = this.h;
        if (r4 <= 0.0f) goto L5;
        b(r4);
        this.h = 0.0f;
    L5:
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        int r0 = MotionEventCompat.getActionMasked(r7);
        int r2 = 0;
        if (isEnabled() == true) goto L5;
    L53:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L53;
        if (this.c == true) goto L53;
        if (this.m == true) goto L53;
        if (r0 != 0) goto L14;
        this.r = r7.getPointerId(0);
        this.q = false;
    L52:
        return true;
    L14:
        if (r0 != 1) goto L16;
    L43:
        int r1 = r7.findPointerIndex(this.r);
        if (r1 >= 0) goto L47;
        return false;
    L47:
        if (this.q == false) goto L49;
        float r8 = (r7.getY(r1) - this.o) * 0.5f;
        this.q = false;
        b(r8);
    L49:
        this.r = -1;
        return false;
    L16:
        if (r0 != 2) goto L18;
        int r3 = r7.findPointerIndex(this.r);
        if (r3 >= 0) goto L36;
        return false;
    L36:
        float r9 = r7.getY(r3);
        f(r9);
        if (this.q == false) goto L52;
        float r10 = (r9 - this.o) * 0.5f;
        if (r10 <= 0.0f) goto L41;
        c(r10);
        goto L52
    L41:
        c(0.0f);
        return false;
    L18:
        if (r0 == 3) goto L43;
        if (r0 != 5) goto L22;
        int r4 = MotionEventCompat.getActionIndex(r7);
        if (r4 >= 0) goto L32;
        return false;
    L32:
        this.r = r7.getPointerId(r4);
        goto L52
    L22:
        if (r0 != 6) goto L52;
        int r5 = MotionEventCompat.getActionIndex(r7);
        if (r7.getPointerId(r5) != this.r) goto L52;
        if (r5 != 0) goto L28;
        r2 = 1;
    L28:
        this.r = r7.getPointerId(r2);
        goto L52
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
    }

    public void setColorSchemeColors(int... r3) {
        a();
        MaterialProgressDrawable r0 = this.w;
        MaterialProgressDrawable.b r1 = r0.b;
        r1.j = r3;
        r1.b(0);
        r0.b.b(0);
    }

    public void setColorSchemeResources(int... r5) {
        Context r0 = getContext();
        int[] r1 = new int[r5.length];
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L6;
        r1[r2] = ContextCompat.getColor(r0, r5[r2]);
        r2 = r2 + 1;
        goto L4
    L6:
        setColorSchemeColors(r1);
    }

    public void setDistanceToTriggerSync(int r1) {
        this.e = r1;
    }

    public void setDoNotCatchException(boolean r1) {
        this.f = r1;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == true) goto L6;
        d();
        return;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.j.setNestedScrollingEnabled(r2);
    }

    public void setOnRefreshListener(SwipeRefreshLayout.f r1) {
        this.b = r1;
    }

    public void setProgressBackgroundColor(int r1) {
        setProgressBackgroundColorSchemeResource(r1);
    }

    public void setProgressBackgroundColorSchemeColor(int r2) {
        this.w.b.w = r2;
    }

    public void setProgressBackgroundColorSchemeResource(int r2) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), r2));
    }

    public void setRefreshing(boolean r5) {
        if (r5 == true) goto L5;
    L10:
        e(r5, false);
        return;
    L5:
        if (this.c == r5) goto L10;
        this.c = r5;
        this.A = false;
        a r6 = this.E;
        this.w.b.u = 255;
        no1.b r1 = new no1.b(this);
        this.x = r1;
        r1.setDuration(this.n);
        if (r6 == null) goto L9;
        r6.onAnimationEnd(this.x);
    L9:
        this.t.b();
        this.g.startScroll(0, getScrollY(), 0, (int) (-this.e));
    }

    public void setSize(int r3) {
        if (r3 != 0) goto L4;
    L6:
        Resources r0 = getResources();
        DisplayMetrics r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
        if (r3 != 0) goto L9;
        this.B = (int) (r1.density * 56.0f);
    L10:
        this.w.d(r3);
        return;
    L9:
        this.B = (int) (r1.density * 40.0f);
        goto L10
    L4:
        if (r3 == 1) goto L6;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r2) {
        return this.j.startNestedScroll(r2);
    }

    public DoubleBallSwipeRefreshLayout(Context r6, AttributeSet r7) {
        super(r6, r7);
        this.c = false;
        this.e = -1.0f;
        this.f = false;
        this.k = new int[2];
        this.l = new int[2];
        this.r = -1;
        this.E = new a(this);
        this.F = new c(this);
        this.G = new d(this);
        this.H = new e();
        this.d = ViewConfiguration.get(r6).getScaledTouchSlop();
        this.g = new Scroller(r6, new AccelerateDecelerateInterpolator());
        this.n = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.s = new DecelerateInterpolator(2.0f);
        Resources r1 = getResources();
        DisplayMetrics r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
        float r3 = r2.density;
        this.B = (int) (40.0f * r3);
        this.C = (int) (r3 * 56.0f);
        this.D = (int) (r3 * 32.0f);
        MaterialProgressDrawable r4 = new MaterialProgressDrawable(getContext(), this);
        this.w = r4;
        r4.b.w = -328966;
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int r5 = (int) (r2.density * 56.0f);
        this.v = r5;
        this.e = r5;
        this.i = new NestedScrollingParentHelper(this);
        this.j = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.u = -this.B;
        TypedArray r8 = r6.obtainStyledAttributes(r7, I);
        setEnabled(r8.getBoolean(0, true));
        r8.recycle();
        this.t = new LiveDoubleColorBallAnimationView(getContext());
        if (((b1) LiveInfraSettingKeys.LIVE_ANIMATION_LEAK.getValue()).doubleColorBall == false) goto L5;
        this.t.setStartAnimationAfterAttach(false);
    L5:
        addView(this.t);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float r2, float r3) {
        return this.j.dispatchNestedPreFling(r2, r3);
    }

    public final void e(boolean r7, boolean r8) {
        this.H.getClass();
        if (this.c == r7) goto L11;
        this.A = r8;
        a();
        this.c = r7;
        if (r7 == false) goto L9;
        a r9 = this.E;
        e r0 = this.H;
        r0.getClass();
        Objects.toString(r9);
        r0.b(false);
        this.F.reset();
        this.F.setDuration(200);
        this.F.setInterpolator(this.s);
        this.t.setCycleBias(1);
        this.t.b();
        this.g.startScroll(0, getScrollY(), 0, (-getScrollY()) - this.C, Math.abs(((-getScrollY()) - this.C) * 2));
        invalidate();
        if (r9 == null) goto L12;
        r9.onAnimationEnd(this.F);
        return;
    L12:
        return;
    L9:
        this.g.forceFinished(true);
        this.g.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
        this.t.c();
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        if (this.a != null) goto L5;
        a();
    L5:
        View r6 = this.a;
        if (r6 != null) goto L17;
        return;
    L17:
        r6.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));     // Catch: IllegalStateException -> L11
    L14:
        this.t.measure(View.MeasureSpec.makeMeasureSpec(this.D, 1073741824), View.MeasureSpec.makeMeasureSpec(this.D, 1073741824));
        return;
    L11:
        e = move-exception;
        if (this.f == false) goto L14;
        throw e;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.j.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        return dispatchNestedPreFling(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r2, View r3, int r4) {
        this.i.onNestedScrollAccepted(r2, r3, r4);
        startNestedScroll(r4 & 2);
        this.h = 0.0f;
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r1, View r2, int r3) {
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.c == true) goto L9;
        if ((r3 & 2) == 0) goto L9;
        return true;
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int r2, int r3, int[] r4, int[] r5) {
        return this.j.dispatchNestedPreScroll(r2, r3, r4, r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        return dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r5, int r6, int r7, int[] r8) {
        if (r7 <= 0) goto L11;
        float r0 = this.h;
        if (r0 <= 0.0f) goto L11;
        float r2 = r7;
        if (r2 <= r0) goto L9;
        r8[1] = r7 - ((int) r0);
        this.h = 0.0f;
    L10:
        c(this.h);
        goto L11
    L9:
        this.h = r0 - r2;
        r8[1] = r7;
    L11:
        int[] r1 = this.k;
        if (dispatchNestedPreScroll(r6 - r8[0], r7 - r8[1], r1, null) == false) goto L15;
        r8[0] = r8[0] + r1[0];
        r8[1] = r8[1] + r1[1];
        return;
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.j.dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = getMeasuredWidth();
        int r9 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        a();
    L8:
        View r10 = this.a;
        if (r10 != null) goto L11;
        return;
    L11:
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        int r0 = (r8 - getPaddingLeft()) - getPaddingRight();
        r10.layout(r11, r12, r0 + r11, ((r9 - getPaddingTop()) - getPaddingBottom()) + r12);     // Catch: Exception -> L14
    L17:
        int r13 = this.t.getMeasuredWidth();
        int r14 = this.t.getMeasuredHeight();
        int r15 = (r8 - r13) / 2;
        int r16 = (this.C + r14) / 2;
        this.t.layout(r15, -r16, r13 + r15, 0);
        return;
    L14:
        e = move-exception;
        if (this.f == false) goto L17;
        throw e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r7, int r8, int r9, int r10, int r11) {
        dispatchNestedScroll(r8, r9, r10, r11, this.l);
        int r12 = r11 + this.l[1];
        if (r12 < 0) goto L5;
        return;
    L5:
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L9;
        float r13 = this.h + Math.abs(r12);
        this.h = r13;
        c(r13);
        return;
    }
}
