package com.mcxtzhang.swipemenulib;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SwipeMenuLayout extends ViewGroup {
    private static SwipeMenuLayout l;
    private static boolean m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5652b;
    private int c;
    private int d;
    private int e;
    private int f;
    private View g;
    private PointF h;
    private boolean i;
    private PointF j;
    private boolean k;
    private VelocityTracker n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private ValueAnimator s;
    private ValueAnimator t;
    private boolean u;

    public SwipeMenuLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public SwipeMenuLayout(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public SwipeMenuLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.h = new PointF();
        this.i = true;
        this.j = new PointF();
        a(r6, r7, r5);
    }

    private void a(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r8.height != (-1)) goto L9;
        int r9 = r8.width;
        r8.width = r3.getMeasuredWidth();
        measureChildWithMargins(r3, r12, 0, r0, 0);
        r8.width = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    private void a(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        this.f5651a = ViewConfiguration.get(r9).getScaledTouchSlop();
        this.f5652b = ViewConfiguration.get(r9).getScaledMaximumFlingVelocity();
        this.o = true;
        this.p = true;
        this.r = true;
        int r2 = 0;
        TypedArray r11 = r9.getTheme().obtainStyledAttributes(r10, R.styleable.SwipeMenuLayout, r8, 0);
        int r12 = r11.getIndexCount();
    L3:
        if (r2 >= r12) goto L14;
        int r13 = r11.getIndex(r2);
        if (r13 != ZeusTransformUtils.mapRes(R.styleable.SwipeMenuLayout_swipeEnable, "styleable", "SwipeMenuLayout_swipeEnable")) goto L8;
        this.o = r11.getBoolean(r13, true);
    L13:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r13 != ZeusTransformUtils.mapRes(R.styleable.SwipeMenuLayout_ios, "styleable", "SwipeMenuLayout_ios")) goto L11;
        this.p = r11.getBoolean(r13, true);
        goto L13
    L11:
        if (r13 != ZeusTransformUtils.mapRes(R.styleable.SwipeMenuLayout_leftSwipe, "styleable", "SwipeMenuLayout_leftSwipe")) goto L13;
        this.r = r11.getBoolean(r13, true);
        goto L13
    L14:
        r11.recycle();
    }

    private void a(MotionEvent r2) {
        if (this.n != null) goto L5;
        this.n = VelocityTracker.obtain();
    L5:
        this.n.addMovement(r2);
    }

    static /* synthetic */ boolean a(SwipeMenuLayout r0, boolean r1) {
        r0.u = r1;
        return r1;
    }

    private void c() {
        ValueAnimator r0 = this.t;
        if (r0 != null) goto L5;
    L7:
        ValueAnimator r1 = this.s;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isRunning() == false) goto L14;
        this.s.cancel();
        return;
    L14:
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        this.t.cancel();
        goto L7
    }

    private void d() {
        VelocityTracker r0 = this.n;
        if (r0 == null) goto L6;
        r0.clear();
        this.n.recycle();
        this.n = null;
        return;
    }

    public static SwipeMenuLayout getViewCache() {
        return l;
    }

    public void a() {
        l = this;
        View r0 = this.g;
        if (r0 == null) goto L5;
        r0.setLongClickable(false);
    L5:
        c();
        int[] r1 = new int[2];
        r1[0] = getScrollX();
        if (this.r == false) goto L8;
        int r2 = this.e;
    L9:
        r1[1] = r2;
        ValueAnimator r3 = ValueAnimator.ofInt(r1);
        this.s = r3;
        r3.addUpdateListener(new AnonymousClass1(this));
        this.s.setInterpolator(new OvershootInterpolator());
        this.s.addListener(new AnonymousClass2(this));
        this.s.setDuration(300).start();
        return;
    L8:
        r2 = -this.e;
        goto L9
    }

    public void b() {
        l = null;
        View r0 = this.g;
        if (r0 == null) goto L5;
        r0.setLongClickable(true);
    L5:
        c();
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{getScrollX(), 0});
        this.t = r1;
        r1.addUpdateListener(new AnonymousClass3(this));
        this.t.setInterpolator(new AccelerateInterpolator());
        this.t.addListener(new AnonymousClass4(this));
        this.t.setDuration(300).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r6) {
        if (this.o == false) goto L68;
        a(r6);
        VelocityTracker r0 = this.n;
        int r1 = r6.getAction();
        if (r1 == 0) goto L58;
        if (r1 == 1) goto L39;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L39;
    L13:
        if (this.q == true) goto L68;
        float r2 = this.h.x - r6.getRawX();
        if (Math.abs(r2) <= 10.0f) goto L18;
    L19:
        getParent().requestDisallowInterceptTouchEvent(true);
    L21:
        if (Math.abs(r2) <= this.f5651a) goto L23;
        this.i = false;
    L23:
        scrollBy((int) r2, 0);
        if (this.r == true) goto L26;
        int r3 = getScrollX();
        int r4 = this.e;
        if (r3 >= (-r4)) goto L35;
        scrollTo(-r4, 0);
    L35:
        if (getScrollX() <= 0) goto L37;
        scrollTo(0, 0);
    L37:
        this.h.set(r6.getRawX(), r6.getRawY());
        goto L68
    L26:
        if (getScrollX() >= 0) goto L28;
        scrollTo(0, 0);
    L28:
        int r5 = getScrollX();
        int r7 = this.e;
        if (r5 <= r7) goto L37;
        scrollTo(r7, 0);
        goto L37
    L18:
        if (Math.abs(getScrollX()) <= 10) goto L21;
    L39:
        if (Math.abs(r6.getRawX() - this.j.x) <= this.f5651a) goto L42;
        this.k = true;
    L42:
        if (this.q == true) goto L57;
        r0.computeCurrentVelocity(1000, this.f5652b);
        float r8 = r0.getXVelocity(this.c);
        if (Math.abs(r8) <= 1000.0f) goto L54;
        if (r8 >= (-1000.0f)) goto L51;
        if (this.r == true) goto L55;
    L56:
        b();
    L55:
        a();
        goto L57
    L51:
        if (this.r == false) goto L55;
    L54:
        if (Math.abs(getScrollX()) <= this.f) goto L56;
    L57:
        d();
        m = false;
        goto L68
    L58:
        this.k = false;
        this.i = true;
        this.q = false;
        if (m == false) goto L61;
        return false;
    L61:
        m = true;
        this.h.set(r6.getRawX(), r6.getRawY());
        this.j.set(r6.getRawX(), r6.getRawY());
        SwipeMenuLayout r9 = l;
        if (r9 == null) goto L66;
        if (r9 == this) goto L65;
        r9.b();
        this.q = this.p;
    L65:
        getParent().requestDisallowInterceptTouchEvent(true);
    L66:
        this.c = r6.getPointerId(0);
    L68:
        return super.dispatchTouchEvent(r6);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new ViewGroup.MarginLayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        SwipeMenuLayout r0 = l;
        if (this != r0) goto L5;
        r0.b();
        l = null;
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        if (this.o == false) goto L37;
        int r0 = r5.getAction();
        if (r0 == 1) goto L13;
        if (r0 != 2) goto L34;
        if (Math.abs(r5.getRawX() - this.j.x) <= this.f5651a) goto L34;
        return true;
    L34:
        if (this.q == false) goto L37;
        return true;
    L13:
        if (this.r == false) goto L23;
        if (getScrollX() <= this.f5651a) goto L31;
        if (r5.getX() >= (getWidth() - getScrollX())) goto L31;
        if (this.i == false) goto L21;
        b();
    L21:
        return true;
    L31:
        if (this.k == false) goto L34;
        return true;
    L23:
        if ((-getScrollX()) <= this.f5651a) goto L31;
        if (r5.getX() <= (-getScrollX())) goto L31;
        if (this.i == false) goto L29;
        b();
    L29:
        return true;
    L37:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        int r10 = getChildCount();
        int r11 = 0;
        int r12 = getPaddingLeft() + 0;
        int r13 = getPaddingLeft() + 0;
    L3:
        if (r11 >= r10) goto L13;
        View r14 = getChildAt(r11);
        if (r14.getVisibility() == 8) goto L12;
        if (r11 != 0) goto L9;
    L7:
        r14.layout(r12, getPaddingTop(), r14.getMeasuredWidth() + r12, getPaddingTop() + r14.getMeasuredHeight());
        r12 = r12 + r14.getMeasuredWidth();
        goto L12
    L9:
        if (this.r == true) goto L7;
        r14.layout(r13 - r14.getMeasuredWidth(), getPaddingTop(), r13, getPaddingTop() + r14.getMeasuredHeight());
        r13 = r13 - r14.getMeasuredWidth();
    L12:
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        setClickable(true);
        int r1 = 0;
        this.e = 0;
        this.d = 0;
        int r2 = getChildCount();
        if (View.MeasureSpec.getMode(r12) == 1073741824) goto L5;
        boolean r3 = true;
    L6:
        int r4 = 0;
        boolean r5 = false;
    L7:
        if (r1 >= r2) goto L19;
        View r6 = getChildAt(r1);
        r6.setClickable(true);
        if (r6.getVisibility() == 8) goto L18;
        measureChild(r6, r11, r12);
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        this.d = Math.max(this.d, r6.getMeasuredHeight());
        if (r3 == true) goto L13;
    L15:
        if (r1 <= 0) goto L17;
        this.e += r6.getMeasuredWidth();
        goto L18
    L17:
        this.g = r6;
        r4 = r6.getMeasuredWidth();
        goto L18
    L13:
        if (r7.height != (-1)) goto L15;
        r5 = true;
    L18:
        r1 = r1 + 1;
        goto L7
    L19:
        setMeasuredDimension((getPaddingLeft() + getPaddingRight()) + r4, (this.d + getPaddingTop()) + getPaddingBottom());
        this.f = (this.e * 4) / 10;
        if (r5 == false) goto L27;
        a(r2, r11);
        return;
    L27:
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.view.View
    public boolean performLongClick() {
        if (Math.abs(getScrollX()) <= this.f5651a) goto L7;
        return false;
    L7:
        return super.performLongClick();
    }

    public void setSwipeEnable(boolean r1) {
        this.o = r1;
    }
}
