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
import android.widget.Scroller;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import no1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveMessageRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int[] x = null;
    public View a;
    public SwipeRefreshLayout.f b;
    public e c;
    public boolean d;
    public final int e;
    public float f;
    public boolean g;
    public boolean h;
    public final Scroller i;
    public float j;
    public final NestedScrollingParentHelper k;
    public final NestedScrollingChildHelper l;
    public final int[] m;
    public final int[] n;
    public boolean o;
    public float p;
    public boolean q;
    public int r;
    public BaseHeaderLoader s;
    public final int t;
    public boolean u;
    public final int v;
    public final a w;

    public class a implements Animation.AnimationListener {
        public final /* synthetic */ LiveMessageRefreshLayout a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public a(LiveMessageRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            LiveMessageRefreshLayout r3 = this.a;
            if (r3.d == true) goto L5;
            r3.getClass();
            return;
        L5:
            if (r3.u == false) goto L11;
            SwipeRefreshLayout.f r4 = r3.b;
            if (r4 == null) goto L12;
            r4.onRefresh();
            return;
        L12:
            return;
        }
    }

    public interface b {
    }

    static {
        x = new int[]{R.attr.enabled};
    }

    public int getProgressViewStartOffset() {
        return 0;
    }

    public void setOnChildScrollUpCallback(b r1) {
    }

    public final void a() {
        if (this.a != null) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= getChildCount()) goto L15;
        View r1 = getChildAt(r0);
        if (r1.equals(this.s) == false) goto L9;
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
        if (this.i.computeScrollOffset() == false) goto L6;
        scrollTo(this.i.getCurrX(), this.i.getCurrY());
        invalidate();
        return;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.k.getNestedScrollAxes();
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.l.hasNestedScrollingParent();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.l.isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.l.stopNestedScroll();
    }

    public int getProgressViewEndOffset() {
        return this.t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public LiveMessageRefreshLayout(Context r2) {
        this(r2, null);
    }

    public final void b(float r6) {
        TextMessageWidget.b r0 = this.c;
        if (r0 == null) goto L20;
        TextMessageWidget.b r1 = r0;
        if (r1.a.L.getVisibility() != 0) goto L7;
        r1.a.L.setVisibility(8);
    L7:
        TextMessageWidget r2 = r1.a;
        if (r2.J == null) goto L20;
        aa2.a r3 = r2.r;
        if (r3 != null) goto L13;
    L19:
        r1.a.J.setVisibility(8);
        r1.a.J.setShouldStartAnim(false);
        goto L20
    L13:
        if (r3.canLoadMore() == false) goto L19;
        r1.a.J.setVisibility(0);
        if (r1.a.r.a() == false) goto L18;
        TextMessageWidget r4 = r1.a;
        r4.O = true;
        r4.J.setShouldStartAnim(false);
        goto L20
    L18:
        r1.a.J.setShouldStartAnim(true);
    L20:
        BaseHeaderLoader r5 = this.s;
        if (r5 != null) goto L23;
    L25:
        e r7 = this.c;
        if (r7 == null) goto L29;
        r7.getClass();
        return;
    L29:
        return;
    L23:
        if (r5.getVisibility() != 0) goto L25;
        int r8 = (int) ((-this.f) * ((float) Math.atan(r6 / this.f)));
        scrollTo(0, r8);
        this.s.a(r8);
        goto L25
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        a();
        int r0 = MotionEventCompat.getActionMasked(r6);
        int r2 = 0;
        if (isEnabled() == true) goto L5;
    L44:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L44;
        if (this.d == true) goto L44;
        if (this.o == true) goto L44;
        if (r0 != 0) goto L13;
        int r1 = r6.getPointerId(0);
        this.r = r1;
        this.q = false;
        int r3 = r6.findPointerIndex(r1);
        if (r3 >= 0) goto L41;
        return false;
    L41:
        this.p = r6.getY(r3);
    L43:
        return this.q;
    L13:
        if (r0 != 1) goto L15;
    L37:
        this.q = false;
        this.r = -1;
        goto L43
    L15:
        if (r0 != 2) goto L17;
        int r4 = this.r;
        if (r4 != (-1)) goto L29;
        return false;
    L29:
        int r5 = r6.findPointerIndex(r4);
        if (r5 >= 0) goto L33;
        return false;
    L33:
        if ((r6.getY(r5) - this.p) <= this.e) goto L43;
        if (this.q == true) goto L43;
        this.q = true;
        goto L43
    L17:
        if (r0 == 3) goto L37;
        if (r0 != 6) goto L43;
        int r7 = MotionEventCompat.getActionIndex(r6);
        if (r6.getPointerId(r7) != this.r) goto L43;
        if (r7 != 0) goto L25;
        r2 = 1;
    L25:
        this.r = r6.getPointerId(r2);
        goto L43
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r10) {
        this.k.onStopNestedScroll(r10);
        this.o = false;
        float r0 = this.j;
        if (r0 > 0.0f) goto L5;
    L12:
        stopNestedScroll();
        e r1 = this.c;
        if (r1 == null) goto L15;
        r1.getClass();
    L15:
        BaseHeaderLoader r2 = this.s;
        if (r2 == null) goto L18;
        r2.b();
    L18:
        e r3 = this.c;
        if (r3 == null) goto L21;
        r3.getClass();
    L21:
        this.g = false;
        return;
    L5:
        if (this.g == false) goto L8;
        this.i.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
    L11:
        this.j = 0.0f;
        goto L12
    L8:
        if (r0 <= this.f) goto L10;
        c(true, true);
        goto L11
    L10:
        this.d = false;
        this.i.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
        goto L11
    }

    public void setDistanceToTriggerSync(int r1) {
        this.f = r1;
    }

    public void setEnableBottomOverscroll(boolean r1) {
        this.h = r1;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
    }

    public void setHeaderController(e r1) {
        this.c = r1;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.l.setNestedScrollingEnabled(r2);
    }

    public void setOnRefreshListener(SwipeRefreshLayout.f r1) {
        this.b = r1;
    }

    public void setRefreshing(boolean r4) {
        if (r4 == true) goto L5;
    L10:
        c(r4, false);
        return;
    L5:
        if (this.d == r4) goto L10;
        this.d = r4;
        this.u = false;
        BaseHeaderLoader r5 = this.s;
        if (r5 == null) goto L9;
        r5.getClass();
    L9:
        this.i.startScroll(0, getScrollY(), 0, (int) (-this.f));
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r2) {
        return this.l.startNestedScroll(r2);
    }

    public LiveMessageRefreshLayout(Context r5, AttributeSet r6) {
        super(r5, r6);
        this.d = false;
        this.f = -1.0f;
        this.g = false;
        this.h = false;
        this.m = new int[2];
        this.n = new int[2];
        this.r = -1;
        this.w = new a(this);
        this.e = ViewConfiguration.get(r5).getScaledTouchSlop();
        this.i = new Scroller(r5, new AccelerateDecelerateInterpolator());
        setWillNotDraw(false);
        Resources r1 = getResources();
        DisplayMetrics r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
        this.v = (int) (r2.density * 52.0f);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int r3 = (int) (r2.density * 52.0f);
        this.t = r3;
        this.f = r3;
        this.k = new NestedScrollingParentHelper(this);
        this.l = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        TypedArray r7 = r5.obtainStyledAttributes(r6, x);
        setEnabled(r7.getBoolean(0, true));
        r7.recycle();
    }

    public final void c(boolean r7, boolean r8) {
        if (this.d == r7) goto L11;
        this.u = r8;
        a();
        this.d = r7;
        if (r7 == false) goto L9;
        a r9 = this.w;
        this.i.startScroll(0, getScrollY(), 0, (-getScrollY()) - this.v, Math.abs(((-getScrollY()) - this.v) * 2));
        invalidate();
        if (r9 == null) goto L12;
        r9.onAnimationEnd(null);
        return;
    L12:
        return;
    L9:
        this.i.forceFinished(true);
        this.i.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
        return;
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float r2, float r3) {
        return this.l.dispatchNestedPreFling(r2, r3);
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        if (this.a != null) goto L5;
        a();
    L5:
        View r6 = this.a;
        if (r6 != null) goto L20;
        return;
    L20:
        r6.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));     // Catch: IllegalStateException -> L11
    L14:
        BaseHeaderLoader r7 = this.s;
        if (r7 != null) goto L17;
        return;
    L17:
        r7.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.v, 1073741824));
        return;
    L11:
        e = move-exception;
        if (v.a() == false) goto L14;
        throw e;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.l.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        return dispatchNestedPreFling(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r2, View r3, int r4) {
        this.k.onNestedScrollAccepted(r2, r3, r4);
        startNestedScroll(r4 & 2);
        this.j = 0.0f;
        this.o = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r1, View r2, int r3) {
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.d == true) goto L9;
        if ((r3 & 2) == 0) goto L9;
        return true;
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int r2, int r3, int[] r4, int[] r5) {
        return this.l.dispatchNestedPreScroll(r2, r3, r4, r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        return dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r6, int r7, int r8, int[] r9) {
        if (this.h == false) goto L24;
        if (r8 < 0) goto L6;
    L14:
        if (r8 > 0) goto L16;
    L32:
        int[] r10 = this.m;
        if (dispatchNestedPreScroll(r7 - r9[0], r8 - r9[1], r10, null) == false) goto L36;
        r9[0] = r9[0] + r10[0];
        r9[1] = r9[1] + r10[1];
        return;
    L36:
        return;
    L16:
        if (this.j <= 0.0f) goto L32;
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L32;
        float r11 = r8;
        float r3 = this.j;
        if (r11 <= r3) goto L22;
        r9[1] = r8 - ((int) r3);
        this.j = 0.0f;
    L23:
        b(this.j);
        goto L32
    L22:
        this.j = r3 - r11;
        r9[1] = r8;
        goto L23
    L6:
        if (this.j <= 0.0f) goto L14;
        if (this.g == false) goto L14;
        float r12 = Math.abs(r8);
        float r4 = this.j;
        if (r12 <= r4) goto L12;
        r9[1] = Math.abs(r8) - ((int) this.j);
        this.j = 0.0f;
    L13:
        float r13 = this.j;
        this.g = true;
        scrollTo(0, (int) (this.f * ((float) Math.atan(r13 / this.f))));
        goto L14
    L12:
        this.j = r4 + r8;
        r9[1] = -r8;
        goto L13
    L24:
        if (r8 <= 0) goto L32;
        float r14 = this.j;
        if (r14 <= 0.0f) goto L32;
        float r5 = r8;
        if (r5 <= r14) goto L30;
        r9[1] = r8 - ((int) r14);
        this.j = 0.0f;
    L31:
        b(this.j);
        goto L32
    L30:
        this.j = r14 - r5;
        r9[1] = r8;
        goto L31
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.l.dispatchNestedScroll(r7, r8, r9, r10, r11);
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
        BaseHeaderLoader r13 = this.s;
        if (r13 != null) goto L20;
        return;
    L20:
        int r14 = r13.getMeasuredWidth();
        int r15 = this.s.getMeasuredHeight();
        int r16 = (r8 - r14) / 2;
        int r17 = (this.v + r15) / 2;
        this.s.layout(r16, -r17, r14 + r16, 0);
        return;
    L14:
        e = move-exception;
        if (v.a() == false) goto L17;
        throw e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r7, int r8, int r9, int r10, int r11) {
        dispatchNestedScroll(r8, r9, r10, r11, this.n);
        int r12 = r11 + this.n[1];
        if (r12 >= 0) goto L8;
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L8;
        float r13 = this.j + Math.abs(r12);
        this.j = r13;
        b(r13);
    L8:
        if (this.h == false) goto L14;
        boolean r14 = ViewCompat.canScrollVertically(this.a, 1);
        if (r12 <= 0) goto L15;
        if (r14 == true) goto L16;
        float r15 = this.j + r12;
        this.j = r15;
        this.g = true;
        scrollTo(0, (int) (this.f * ((float) Math.atan(r15 / this.f))));
        return;
    L16:
        return;
    L15:
        return;
    }
}
