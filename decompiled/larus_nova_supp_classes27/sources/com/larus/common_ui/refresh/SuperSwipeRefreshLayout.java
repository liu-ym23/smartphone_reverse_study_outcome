package com.larus.common_ui.refresh;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public class SuperSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int[] x = null;
    public View a;
    public AbsRefreshHeaderLayout b;
    public boolean c;
    public boolean d;
    public e e;
    public boolean f;
    public final int g;
    public int h;
    public final NestedScrollingParentHelper i;
    public final NestedScrollingChildHelper j;
    public final int[] k;
    public final int[] l;
    public boolean m;
    public boolean n;
    public float o;
    public float p;
    public float q;
    public boolean r;
    public int s;
    public int t;
    public final DecelerateInterpolator u;
    public ValueAnimator v;
    public ValueAnimator w;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ SuperSwipeRefreshLayout a;

        public a(SuperSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            super.onAnimationEnd(r3);
            SuperSwipeRefreshLayout r4 = this.a;
            if (r4.d == false) goto L5;
            FLogger.a.d("SuperSwipeRefreshLayout", "still scrolling，pending again");
            return;
        L5:
            r4.b.a(r4, new q19.c(r4));
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ SuperSwipeRefreshLayout a;

        public b(SuperSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            super.onAnimationEnd(r1);
            this.a.g();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ SuperSwipeRefreshLayout a;

        public c(SuperSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            int r3 = ((Integer) r2.getAnimatedValue()).intValue() - this.a.getTargetView().getTop();
            this.a.setTargetTopAndBottomOffset(r3);
        }
    }

    public interface d {
    }

    public interface e {
        void a(boolean r1);
    }

    static {
        x = new int[]{R.attr.enabled};
    }

    public void setOnChildScrollUpCallback(d r1) {
    }

    public final void c() {
        ValueAnimator r0 = this.w;
        if (r0 != null) goto L5;
    L8:
        ValueAnimator r1 = getToStartPositionAnimator();
        this.w = r1;
        if (r1 == null) goto L12;
        r1.start();
        return;
    L12:
        return;
    L5:
        if (r0.isRunning() == false) goto L8;
        FLogger.a.d("SuperSwipeRefreshLayout", "animateOffsetToStartPosition: animation is running");
    }

    public final void e() {
        FLogger.a.d("SuperSwipeRefreshLayout", "finishSpinner,top = " + getTargetView().getTop() + ", mTriggerRefreshDistance = " + this.h + ",isCancelPending = " + this.c);
        if (this.c == false) goto L9;
        if (getTargetView().getTop() <= this.h) goto L7;
        b(new a(this));
        return;
    L7:
        this.b.a(this, new q19.c(this));
        return;
    L9:
        if (getTargetView().getTop() > this.h) goto L11;
        c();
        return;
    L11:
        if (this.f == false) goto L13;
        b(null);
        return;
    L13:
        h(true, true);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.i.getNestedScrollAxes();
    }

    public View getTargetView() {
        if (this.a != null) goto L12;
        int r0 = 0;
    L6:
        if (r0 >= getChildCount()) goto L12;
        View r1 = getChildAt(r0);
        if (r1 != this.b) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        this.a = r1;
    L12:
        return this.a;
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

    public final boolean d() {
        View r0 = getTargetView();
        if ((r0 instanceof ListView) == false) goto L7;
        return ListViewCompat.canScrollList((ListView) r0, -1);
    L7:
        return r0.canScrollVertically(-1);
    }

    public final void g() {
        setTargetTopAndBottomOffset(-getTargetView().getTop());
        this.r = false;
        this.m = false;
        this.o = -1.0f;
        this.p = -1.0f;
        this.t = 0;
        this.c = false;
        this.d = false;
        this.b.d();
        FLogger.a.d("SuperSwipeRefreshLayout", "swipe reset");
    }

    public ValueAnimator getToStartPositionAnimator() {
        int r0 = getTargetView().getTop();
        FLogger.a.d("SuperSwipeRefreshLayout", "animateOffsetToStartPosition, startOffset = " + r0);
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{r0, 0});
        r1.setInterpolator(this.u);
        r1.setDuration(400);
        r1.addListener(new b(this));
        r1.addUpdateListener(new c(this));
        return r1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    public SuperSwipeRefreshLayout(Context r2) {
        this(r2, null);
    }

    public static String a(int r4) {
        switch(r4) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L3;
            case 6: goto L3;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            case 10: goto L4;
            default: goto L3;
        };
    L3:
        int r0 = (65280 & r4) >> 8;
        int r1 = r4 & 255;
        if (r1 == 5) goto L31;
        if (r1 == 6) goto L29;
        return MotionEvent.actionToString(r4);
    L29:
        return "ACTION_POINTER_UP(" + r0 + ")";
    L31:
        return "ACTION_POINTER_DOWN(" + r0 + ")";
    L4:
        return "ACTION_HOVER_EXIT";
    L6:
        return "ACTION_HOVER_ENTER";
    L8:
        return "ACTION_SCROLL";
    L10:
        return "ACTION_HOVER_MOVE";
    L12:
        return "ACTION_OUTSIDE";
    L14:
        return "ACTION_CANCEL";
    L16:
        return "ACTION_MOVE";
    L18:
        return "ACTION_UP";
    L20:
        return "ACTION_DOWN";
    }

    public final void b(a r6) {
        ValueAnimator r0 = this.v;
        if (r0 != null) goto L5;
    L8:
        int r1 = getTargetView().getTop();
        FLogger.a.d("SuperSwipeRefreshLayout", "animateOffsetToCorrectPosition, startOffset = " + r1);
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{r1, this.h});
        r2.setInterpolator(this.u);
        r2.setDuration(300);
        if (r6 == null) goto L11;
        r2.addListener(r6);
    L11:
        r2.addUpdateListener(new q19.d(this));
        this.v = r2;
        r2.start();
        return;
    L5:
        if (r0.isRunning() == false) goto L8;
        FLogger.a.d("SuperSwipeRefreshLayout", "animateOffsetToCorrectPosition: animation is running");
    }

    public final boolean f(int r5) {
        FLogger.a.d("SuperSwipeRefreshLayout", "moveSpinner, offset = " + r5);
        if (r5 <= 0) goto L7;
        setTargetTopAndBottomOffset((int) (r5 * 0.6f));
        return true;
    L7:
        if (r5 >= 0) goto L16;
        View r2 = getTargetView();
        if (r2.getTop() > 0) goto L12;
        return false;
    L12:
        if ((r2.getTop() + r5) < 0.0f) goto L14;
        setTargetTopAndBottomOffset(r5);
    L15:
        return true;
    L14:
        setTargetTopAndBottomOffset(-r2.getTop());
        goto L15
    L16:
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r9) {
        FLogger r0 = FLogger.a;
        r0.d("SuperSwipeRefreshLayout", "onInterceptTouchEvent , MotionEvent = " + a(r9.getAction()) + ",mIsBeingDragged = " + this.r);
        int r1 = r9.getActionMasked();
        int r5 = 0;
        if (r9.getActionMasked() != 1) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.d = r3;
        if (isEnabled() == true) goto L11;
    L45:
        r0.d("SuperSwipeRefreshLayout", "onInterceptTouchEvent , canChildScrollUp = " + d() + ",mRefreshing = " + this.f + ", mNestedScrollInProgress = " + this.m);
        return false;
    L11:
        if (d() == true) goto L45;
        if (this.m == true) goto L45;
        if (r1 != 0) goto L17;
        int r2 = r9.getPointerId(0);
        this.s = r2;
        this.r = false;
        int r4 = r9.findPointerIndex(r2);
        if (r4 >= 0) goto L42;
        return false;
    L42:
        this.o = r9.getY(r4);
        this.p = r9.getX(r4);
    L44:
        return this.r;
    L17:
        if (r1 != 1) goto L19;
    L38:
        this.r = false;
        this.s = -1;
        goto L44
    L19:
        if (r1 == 2) goto L29;
        if (r1 == 3) goto L38;
        if (r1 != 6) goto L44;
        int r6 = r9.getActionIndex();
        if (r9.getPointerId(r6) != this.s) goto L44;
        if (r6 != 0) goto L28;
        r5 = 1;
    L28:
        this.s = r9.getPointerId(r5);
        goto L44
    L29:
        int r7 = this.s;
        if (r7 != (-1)) goto L33;
        r0.e("SuperSwipeRefreshLayout", "Got ACTION_MOVE event but don't have an active pointer id.");
        return false;
    L33:
        int r8 = r9.findPointerIndex(r7);
        if (r8 >= 0) goto L37;
        r0.d("SuperSwipeRefreshLayout", "onInterceptTouchEvent ACTION_MOVE - pointerIndex = " + r8);
        return false;
    L37:
        i(r9.getY(r8), r9.getX(r8));
        r0.d("SuperSwipeRefreshLayout", "onInterceptTouchEvent ACTION_MOVE - mIsBeingDragged - " + this.r);
        goto L44
    L5:
        if (r9.getActionMasked() == 3) goto L7;
        r3 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r4) {
        FLogger.a.d("SuperSwipeRefreshLayout", "onStopNestedScroll - mRefreshing = " + this.f + ",mIsBeingDragged = " + this.r + "mNestedScrollInProgress=" + this.m);
        this.i.onStopNestedScroll(r4);
        this.m = false;
        if (this.n == false) goto L7;
        this.n = false;
        if (getTargetView().getTop() <= 0) goto L7;
        e();
    L7:
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        int r2 = 0;
        if (r8.getActionMasked() != 1) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.d = r0;
        int r1 = r8.getActionMasked();
        FLogger r4 = FLogger.a;
        r4.d("SuperSwipeRefreshLayout", "onTouchEvent , MotionEvent = " + a(r8.getAction()) + ",mIsBeingDragged = " + this.r);
        r4.d("SuperSwipeRefreshLayout", "onTouchEvent allowInterceptAll = false");
        if (isEnabled() == true) goto L11;
    L55:
        r4.d("SuperSwipeRefreshLayout", "onTouchEvent , isEnabled = " + isEnabled() + ", canChildScrollUp = " + d() + ", mNestedScrollInProgress = " + this.m);
        return false;
    L11:
        if (d() == true) goto L55;
        if (this.m == true) goto L55;
        if (r1 == 0) goto L53;
        if (r1 == 1) goto L45;
        if (r1 == 2) goto L36;
        if (r1 != 3) goto L21;
        return false;
    L21:
        if (r1 != 5) goto L23;
        int r3 = r8.getActionIndex();
        if (r3 >= 0) goto L34;
        r4.d("SuperSwipeRefreshLayout", "Got ACTION_POINTER_DOWN event but have an invalid action index.");
        return false;
    L34:
        this.s = r8.getPointerId(r3);
    L54:
        return true;
    L23:
        if (r1 == 6) goto L25;
        return true;
    L25:
        int r5 = r8.getActionIndex();
        if (r8.getPointerId(r5) != this.s) goto L54;
        if (r5 != 0) goto L29;
        r2 = 1;
    L29:
        this.s = r8.getPointerId(r2);
        goto L54
    L36:
        int r6 = r8.findPointerIndex(this.s);
        if (r6 >= 0) goto L40;
        r4.d("SuperSwipeRefreshLayout", "Got ACTION_MOVE event but have an invalid active pointer id.");
        return false;
    L40:
        float r7 = r8.getY(r6);
        i(r7, r8.getX(r6));
        if (this.r == false) goto L54;
        int r9 = (int) (r7 - this.q);
        this.q = r7;
        return f(r9);
    L45:
        if (r8.findPointerIndex(this.s) >= 0) goto L49;
        r4.e("SuperSwipeRefreshLayout", "Got ACTION_UP event but don't have an active pointer id.");
        return false;
    L49:
        if (this.r == false) goto L51;
        this.r = false;
        e();
    L51:
        this.s = -1;
        return false;
    L53:
        this.s = r8.getPointerId(0);
        this.r = false;
        goto L54
    L5:
        if (r8.getActionMasked() == 3) goto L7;
        r0 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r2) {
        if (this.r == false) goto L5;
        return;
    L5:
        View r0 = getTargetView();
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L13;
        return;
    L13:
        super.requestDisallowInterceptTouchEvent(r2);
        return;
    L8:
        if (ViewCompat.isNestedScrollingEnabled(r0) == true) goto L10;
        r1 = true;
        goto L11
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == true) goto L6;
        g();
        return;
    }

    public void setIsUserTouching(boolean r1) {
        this.d = r1;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.j.setNestedScrollingEnabled(r2);
    }

    public void setOnRefreshListener(e r1) {
        this.e = r1;
    }

    public void setRefreshHeader(AbsRefreshHeaderLayout r2) {
        removeViewAt(0);
        this.b = r2;
        addView(r2);
    }

    public void setRefreshing(boolean r2) {
        h(r2, false);
    }

    public void setRefreshingForce(boolean r2) {
        this.d = false;
        setRefreshing(r2);
    }

    public void setTargetTopAndBottomOffset(int r6) {
        View r0 = getTargetView();
        if (r0 == null) goto L15;
        FLogger.a.d("SuperSwipeRefreshLayout", "setTargetTopAndBottomOffset , offset = " + r6 + ", top = " + r0.getTop());
        if (r6 > 0) goto L7;
    L13:
        if (r6 == 0) goto L17;
        ViewCompat.offsetTopAndBottom(r0, r6);
        this.b.c(this, r6);
        this.t += r6;
        return;
    L17:
        return;
    L7:
        if (r0.getTop() <= this.h) goto L13;
        if (r0.getTop() <= (this.h * 2)) goto L11;
        float r7 = r6;
        float r1 = 0.2f;
    L12:
        r6 = (int) (r7 * r1);
        goto L13
    L11:
        r7 = r6;
        r1 = 0.5f;
        goto L12
    L15:
        FLogger.a.d("SuperSwipeRefreshLayout", "setTargetTopDistance ,mTarget is null, offset = " + r6);
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r2) {
        return this.j.startNestedScroll(r2);
    }

    public SuperSwipeRefreshLayout(Context r5, AttributeSet r6) {
        super(r5, r6);
        this.c = false;
        this.d = false;
        this.f = false;
        this.h = -1;
        this.k = new int[2];
        this.l = new int[2];
        this.o = -1.0f;
        this.p = -1.0f;
        this.s = -1;
        this.t = 0;
        this.v = null;
        this.w = null;
        setWillNotDraw(false);
        this.g = ViewConfiguration.get(r5).getScaledTouchSlop();
        this.u = new DecelerateInterpolator(2.0f);
        this.i = new NestedScrollingParentHelper(this);
        this.j = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        setChildrenDrawingOrderEnabled(true);
        TypedArray r7 = r5.obtainStyledAttributes(r6, x);
        setEnabled(r7.getBoolean(0, true));
        r7.recycle();
        RefreshHeaderLayout r8 = new RefreshHeaderLayout(r5);
        this.b = r8;
        addView(r8);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float r2, float r3) {
        return this.j.dispatchNestedPreFling(r2, r3);
    }

    public final void h(boolean r5, boolean r6) {
        if (this.f != r5) goto L6;
        FLogger.a.d("SuperSwipeRefreshLayout", "refresh status consistent，do not need refresh，refreshing = " + r5);
        return;
    L6:
        FLogger.a.d("SuperSwipeRefreshLayout", "refresh status，refreshing = " + r5 + ", mIsBeingDragged=" + this.r + ",mIsNestedScrollReallyHappened=" + this.n + ",isUserTouching=" + this.d);
        this.f = r5;
        if (r5 == false) goto L13;
        e r7 = this.e;
        if (r7 == null) goto L11;
        r7.a(r6);
    L11:
        this.b.b(this);
        b(null);
        return;
    L13:
        if (this.d == false) goto L16;
        this.c = true;
        return;
    L16:
        this.b.a(this, new q19.c(this));
    }

    public final void i(float r5, float r6) {
        if (this.o >= 0.0f) goto L5;
        this.o = (r5 - this.g) - 1.0f;
    L5:
        float r0 = r5 - this.o;
        float r7 = r6 - this.p;
        if (Math.abs(r0) > this.g) goto L8;
        return;
    L8:
        if (Math.abs(r0) > Math.abs(r7)) goto L10;
        return;
    L10:
        if (this.r == false) goto L12;
        return;
    L12:
        if (r0 <= 0.0f) goto L15;
        this.q = this.o + this.g;
        this.r = true;
    L19:
        FLogger.a.d("SuperSwipeRefreshLayout", "startDragging, y = " + r5 + ", yDiff = " + r0 + ",mIsBeingDragged = " + this.r);
        return;
    L15:
        if (r0 >= 0.0f) goto L19;
        this.q = this.o - this.g;
        this.r = true;
        if (getTargetView().getTop() > 0) goto L19;
        this.r = false;
        goto L19
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        if (getTargetView() != null) goto L5;
        return;
    L5:
        int r7 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int r8 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r1 = View.MeasureSpec.makeMeasureSpec(r7, 1073741824);
        int r2 = View.MeasureSpec.makeMeasureSpec(r8, 1073741824);
        getTargetView().measure(r1, r2);
        int r9 = View.MeasureSpec.makeMeasureSpec(r7, 1073741824);
        int r10 = View.MeasureSpec.makeMeasureSpec(r8, Integer.MIN_VALUE);
        this.b.measure(r9, r10);
        if (this.h > 0) goto L9;
        this.h = this.b.getMeasuredHeight();
        return;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.j.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        if (isEnabled() == false) goto L11;
        if (getTargetView() == null) goto L11;
        if (getTargetView().getTop() <= 0) goto L11;
        return true;
    L11:
        return dispatchNestedPreFling(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r2, View r3, int r4) {
        this.i.onNestedScrollAccepted(r2, r3, r4);
        startNestedScroll(r4 & 2);
        this.m = true;
        FLogger.a.d("SuperSwipeRefreshLayout", "onNestedScrollAccepted");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r3, View r4, int r5) {
        if (isEnabled() == true) goto L5;
    L9:
        boolean r6 = false;
    L10:
        FLogger.a.d("SuperSwipeRefreshLayout", "onStartNestedScroll top = " + getTargetView().getTop() + " axes = " + (r5 & 2) + ", result = " + r6);
        return r6;
    L5:
        if (getTargetView().getTop() < 0) goto L9;
        if ((r5 & 2) == 0) goto L9;
        r6 = true;
        goto L10
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
    public final void onNestedPreScroll(View r8, int r9, int r10, int[] r11) {
        this.n = true;
        int r0 = getTargetView().getTop();
        if (r10 <= 0) goto L9;
        if (r0 <= 0) goto L9;
        if ((r0 - r10) < 0) goto L8;
        f(-r10);
        r11[1] = r10;
        goto L9
    L8:
        int r1 = -r0;
        r11[1] = r1;
        f(r1);
    L9:
        int r2 = r11[1];
        int[] r3 = this.k;
        if (dispatchNestedPreScroll(r9 - r11[0], r10 - r2, r3, null) == false) goto L12;
        r11[0] = r11[0] + r3[0];
        r11[1] = r11[1] + r3[1];
    L12:
        FLogger.a.d("SuperSwipeRefreshLayout", "onNestedPreScroll, dx = " + r9 + ", dy = " + r10 + " ,targetTop = " + r0 + ",beforeY=" + r2 + ",afterY=" + r11[1]);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.j.dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = getMeasuredWidth();
        int r10 = getMeasuredHeight();
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        View r11 = getTargetView();
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop() + this.t;
        int r12 = ((r9 - getPaddingLeft()) - getPaddingRight()) + r0;
        r11.layout(r0, r1, r12, ((r10 - getPaddingTop()) - getPaddingBottom()) + r1);
        AbsRefreshHeaderLayout r13 = this.b;
        r13.layout(r0, r1 - r13.getMeasuredHeight(), r12, r1);
        FLogger.a.d("SuperSwipeRefreshLayout", "onLayout changed = " + r4 + ",top = " + r6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r7, int r8, int r9, int r10, int r11) {
        this.n = true;
        dispatchNestedScroll(r8, r9, r10, r11, this.l);
        int r12 = this.l[1] + r11;
        FLogger.a.d("SuperSwipeRefreshLayout", "onNestedScroll, dyConsumed = " + r9 + ", dyUnconsumed = " + r11 + ", dy = " + r12 + ", canChildScrollUp = %s" + d());
        if (r12 < 0) goto L5;
        return;
    L5:
        if (d() == true) goto L9;
        f(Math.abs(r12));
        return;
    }
}
