package com.ss.android.lark.docs.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SwipeMenuLayout extends ViewGroup {
    public static boolean p;
    public static SwipeMenuLayout q;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public View f;
    public final PointF g;
    public boolean h;
    public boolean i;
    public boolean j;
    public VelocityTracker k;
    public ValueAnimator l;
    public ValueAnimator m;
    public DocsLinearLayoutManager n;
    public final List<c> o;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ SwipeMenuLayout a;

        public a(SwipeMenuLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            SwipeMenuLayout r3 = this.a;
            boolean r0 = SwipeMenuLayout.p;
            r3.getClass();
            this.a.c(true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ SwipeMenuLayout a;

        public b(SwipeMenuLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            SwipeMenuLayout r3 = this.a;
            boolean r0 = SwipeMenuLayout.p;
            r3.getClass();
            this.a.c(false);
        }
    }

    public interface c {
        void a();
    }

    public interface d {
    }

    public final void b() {
        q = null;
        DocsLinearLayoutManager r0 = this.n;
        if (r0 == null) goto L5;
        r0.a = true;
    L5:
        View r1 = this.f;
        if (r1 == null) goto L8;
        r1.setLongClickable(true);
    L8:
        a();
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{getScrollX(), 0});
        this.m = r2;
        r2.addUpdateListener(new tbb.a(this));
        this.m.setInterpolator(new AccelerateInterpolator());
        this.m.addListener(new b(this));
        this.m.setDuration(120).start();
    }

    public void setDefaultMenuWidths(int r1) {
    }

    public void setOnUserSwipeMenuListener(d r1) {
    }

    public final void a() {
        ValueAnimator r0 = this.m;
        if (r0 != null) goto L5;
    L7:
        ValueAnimator r1 = this.l;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isRunning() == false) goto L14;
        this.l.cancel();
        return;
    L14:
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        this.m.cancel();
        goto L7
    }

    public final void d() {
        q = this;
        DocsLinearLayoutManager r0 = this.n;
        if (r0 == null) goto L5;
        r0.a = false;
    L5:
        View r1 = this.f;
        if (r1 == null) goto L8;
        r1.setLongClickable(false);
    L8:
        a();
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{getScrollX(), this.d});
        this.l = r2;
        r2.addUpdateListener(new tbb.b(this));
        this.l.setInterpolator(new OvershootInterpolator());
        this.l.addListener(new a(this));
        this.l.setDuration(300).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        SwipeMenuLayout r0 = q;
        if (this != r0) goto L8;
        DocsLinearLayoutManager r1 = r0.n;
        if (r1 == null) goto L7;
        r1.a = true;
    L7:
        r0.a();
        q.scrollTo(0, 0);
        q = null;
        r0.c(false);
        q = null;
    L8:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        if (getScrollX() <= this.a) goto L7;
        return false;
    L7:
        return super.performLongClick();
    }

    public boolean getSwipeEnable() {
        return this.j;
    }

    public SwipeMenuLayout(Context r2) {
        this(r2, null);
    }

    public final void c(boolean r2) {
        Iterator r3 = ((ArrayList) this.o).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((c) r3.next()).a();
        goto L4
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        if (this.j == false) goto L66;
        if (this.k != null) goto L7;
        this.k = VelocityTracker.obtain();
    L7:
        this.k.addMovement(r6);
        int r0 = r6.getAction();
        if (r0 == 0) goto L57;
        if (r0 == 1) goto L32;
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L32;
    L16:
        if (this.i == true) goto L66;
        float r1 = r6.getRawX() - this.g.x;
        if (Math.abs(r1) <= this.a) goto L21;
    L22:
        this.h = true;
        int r2 = (int) (getScrollX() - r1);
        if (r2 >= 0) goto L25;
        r2 = 0;
    L28:
        scrollTo(r2, 0);
        this.g.set(r6.getRawX(), r6.getRawY());
        DocsLinearLayoutManager r3 = this.n;
        if (r3 == null) goto L66;
        r3.a = false;
        goto L66
    L25:
        int r4 = this.d;
        if (r2 <= r4) goto L28;
        r2 = r4;
        goto L28
    L21:
        if (this.h == false) goto L66;
    L32:
        if (this.i == false) goto L34;
    L51:
        VelocityTracker r5 = this.k;
        if (r5 == null) goto L54;
        r5.clear();
        this.k.recycle();
        this.k = null;
    L54:
        p = false;
        DocsLinearLayoutManager r7 = this.n;
        if (r7 == null) goto L66;
        r7.a = true;
        goto L66
    L34:
        if (this.h == false) goto L51;
        this.k.computeCurrentVelocity(ChameleonWebViewClient.DEFAULT_SAFE_TIME);
        float r8 = this.k.getXVelocity(this.b);
        if (r8 < 2000.0f) goto L39;
        b();
        goto L51
    L39:
        if (r8 <= 0.0f) goto L45;
        if (getScrollX() >= (this.d - this.e)) goto L43;
        b();
        goto L51
    L43:
        d();
        goto L51
    L45:
        if (r8 > (-2000.0f)) goto L47;
        d();
        goto L51
    L47:
        if (getScrollX() <= this.e) goto L49;
        d();
        goto L51
    L49:
        b();
        goto L51
    L57:
        this.h = false;
        this.i = false;
        if (p == false) goto L60;
        return false;
    L60:
        p = true;
        this.g.set(r6.getRawX(), r6.getRawY());
        SwipeMenuLayout r9 = q;
        if (r9 == null) goto L64;
        if (r9 == this) goto L64;
        r9.b();
        this.i = true;
    L64:
        this.b = r6.getPointerId(0);
    L66:
        return super.dispatchTouchEvent(r6);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new ViewGroup.MarginLayoutParams(getContext(), r3);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        if (this.j == false) goto L30;
        int r0 = r5.getAction();
        if (r0 == 1) goto L13;
        if (r0 != 2) goto L27;
        if (this.h == false) goto L27;
        return true;
    L27:
        if (this.i == false) goto L30;
        return true;
    L13:
        if (getScrollX() <= this.a) goto L24;
        if (r5.getX() >= (getWidth() - getScrollX())) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == false) goto L24;
        if (this.h == true) goto L22;
        b();
    L22:
        return true;
    L17:
        r1 = false;
    L24:
        if (this.h == false) goto L27;
        return true;
    L30:
        return super.onInterceptTouchEvent(r5);
    }

    public void setLayoutManager(DocsLinearLayoutManager r1) {
        this.n = r1;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        super.setOnClickListener(r1);
    }

    public void setSwipeEnable(boolean r1) {
        this.j = r1;
    }

    public SwipeMenuLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r17, int r18) {
        super.onMeasure(r17, r18);
        setClickable(true);
        this.d = 0;
        this.c = 0;
        int r7 = getChildCount();
        if (View.MeasureSpec.getMode(r18) == 1073741824) goto L5;
        boolean r2 = true;
    L6:
        int r4 = 0;
        int r5 = 0;
        boolean r8 = false;
    L8:
        if (r4 >= r7) goto L21;
        View r11 = getChildAt(r4);
        r11.setClickable(true);
        if (r11.getVisibility() == 8) goto L20;
        measureChild(r11, r17, r18);
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
        this.c = Math.max(this.c, r11.getMeasuredHeight());
        if (r2 == true) goto L14;
    L16:
        if (r4 <= 0) goto L18;
        this.d += r11.getMeasuredWidth();
        goto L20
    L18:
        this.f = r11;
        r5 = r11.getMeasuredWidth();
        goto L20
    L14:
        if (r10.height != (-1)) goto L16;
        r8 = true;
    L20:
        r4 = r4 + 1;
        goto L8
    L21:
        setMeasuredDimension((getPaddingLeft() + getPaddingRight()) + r5, (this.c + getPaddingTop()) + getPaddingBottom());
        this.e = this.d / 5;
        if (r8 == false) goto L31;
        int r9 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int r12 = 0;
    L24:
        if (r12 >= r7) goto L40;
        View r1 = getChildAt(r12);
        if (r1.getVisibility() == 8) goto L30;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        if (r13.height != (-1)) goto L30;
        int r14 = r13.width;
        r13.width = r1.getMeasuredWidth();
        measureChildWithMargins(r1, r17, 0, r9, 0);
        r13.width = r14;
    L30:
        r12 = r12 + 1;
        goto L24
    L40:
        return;
    L31:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public SwipeMenuLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.g = new PointF();
        this.j = true;
        this.o = new ArrayList();
        this.a = ViewConfiguration.get(r1).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = getChildCount();
        int r10 = getPaddingLeft();
        int r11 = 0;
    L3:
        if (r11 >= r9) goto L11;
        View r12 = getChildAt(r11);
        if (r12.getVisibility() == 8) goto L10;
        if (r11 != 0) goto L8;
        r12.layout(r10, getPaddingTop(), r12.getMeasuredWidth() + r10, getPaddingTop() + r12.getMeasuredHeight());
        int r13 = r12.getMeasuredWidth();
    L9:
        r10 = r10 + r13;
        goto L10
    L8:
        r12.layout(r10, getPaddingTop(), r12.getMeasuredWidth() + r10, getPaddingTop() + r12.getMeasuredHeight());
        r13 = r12.getMeasuredWidth();
    L10:
        r11 = r11 + 1;
        goto L3
    }
}
