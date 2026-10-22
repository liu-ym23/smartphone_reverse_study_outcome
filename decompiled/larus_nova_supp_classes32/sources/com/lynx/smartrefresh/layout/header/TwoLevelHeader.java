package com.lynx.smartrefresh.layout.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import m6a.f;
import m6a.g;
import m6a.h;
import m6a.i;
import p6a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class TwoLevelHeader extends b implements f {
    public int d;
    public float e;
    public final float f;
    public final float g;
    public final float h;
    public final boolean i;
    public final boolean j;
    public final int k;
    public int l;
    public g m;
    public h n;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RefreshState.values().length];
            a = r0;
            r0[RefreshState.TwoLevelReleased.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[RefreshState.TwoLevel.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[RefreshState.TwoLevelFinish.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[RefreshState.PullDownToRefresh.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = n6a.b.g;
        if (this.m != null) goto L6;
        g(new ClassicsHeader(getContext()));
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = n6a.b.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        View r2 = getChildAt(r1);
        if ((r2 instanceof f) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        this.m = (f) r2;
        this.c = (g) r2;
        bringChildToFront(r2);
    L9:
        if (this.m != null) goto L14;
        g(new ClassicsHeader(getContext()));
        return;
    }

    public TwoLevelHeader(Context r2) {
        this(r2, null);
    }

    @Override // p6a.b
    public final boolean equals(Object r2) {
        g r0 = this.m;
        if (r0 == null) goto L7;
        if (r0.equals(r2) == false) goto L7;
    L8:
        return true;
    L7:
        if (super.equals(r2) == true) goto L8;
        return false;
    }

    public final void g(ClassicsHeader r6) {
        g r0 = this.m;
        if (r0 == null) goto L6;
        removeView(r0.getView());
    L6:
        if (r6.getSpinnerStyle() != n6a.b.e) goto L8;
        addView(r6.getView(), 0, new RelativeLayout.LayoutParams(-1, -2));
    L9:
        this.m = r6;
        this.c = r6;
        return;
    L8:
        addView(r6.getView(), getChildCount(), new RelativeLayout.LayoutParams(-1, -2));
        goto L9
    }

    public TwoLevelHeader(Context r8, AttributeSet r9) {
        super(r8, r9, 0);
        this.e = 0.0f;
        this.f = 2.5f;
        this.g = 1.9f;
        this.h = 1.0f;
        this.i = true;
        this.j = true;
        this.k = 1000;
        this.b = n6a.b.e;
        TypedArray r10 = r8.obtainStyledAttributes(r9, new int[]{2130974173, 2130974178, 2130974182, 2130974183, 2130974194, 2130974198});
        this.f = r10.getFloat(4, 2.5f);
        this.g = r10.getFloat(3, 1.9f);
        this.h = r10.getFloat(5, 1.0f);
        this.k = r10.getInt(2, 1000);
        this.i = r10.getBoolean(1, true);
        this.j = r10.getBoolean(0, true);
        r10.recycle();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        g r0 = this.m;
        if (r0 != null) goto L5;
        super.onMeasure(r4, r5);
        return;
    L5:
        if (View.MeasureSpec.getMode(r5) != Integer.MIN_VALUE) goto L7;
        r0.getView().measure(r4, r5);
        int r6 = r0.getView().getMeasuredHeight();
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), r4), r6);
        return;
    L7:
        super.onMeasure(r4, r5);
    }

    @Override // p6a.b, q6a.e
    public final void i(i r3, RefreshState r4, RefreshState r5) {
        g r0 = this.m;
        if (r0 == null) goto L31;
        r0.i(r3, r4, r5);
        int r6 = a.a[r5.ordinal()];
        if (r6 == 1) goto L20;
        if (r6 == 3) goto L17;
        if (r6 == 4) goto L12;
        return;
    L12:
        if (r0.getView().getAlpha() == 0.0f) goto L14;
        return;
    L14:
        if (r0.getView() == this) goto L33;
        r0.getView().setAlpha(1.0f);
        return;
    L33:
        return;
    L17:
        if (r0.getView() == this) goto L35;
        r0.getView().animate().alpha(1.0f).setDuration(this.k / 2);
        return;
    L35:
        return;
    L20:
        if (r0.getView() == this) goto L22;
        r0.getView().animate().alpha(0.0f).setDuration(this.k / 2);
    L22:
        h r7 = this.n;
        if (r7 == null) goto L37;
        SmartRefreshLayout.i r8 = (SmartRefreshLayout.i) r7;
        com.lynx.smartrefresh.layout.a r9 = new com.lynx.smartrefresh.layout.a(r8);
        ValueAnimator r10 = r8.a(r8.a.getMeasuredHeight());
        if (r10 == null) goto L29;
        SmartRefreshLayout r11 = r8.a;
        if (r10 != r11.I2) goto L29;
        r10.setDuration(r11.e);
        r10.addListener(r9);
        return;
    L29:
        r9.onAnimationEnd(null);
        return;
    L37:
        return;
    }

    @Override // p6a.b, m6a.g
    public final void j(SmartRefreshLayout.i r7, int r8, int r9) {
        g r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = ((r9 + r8) * 1.0f) / r8;
        float r2 = this.f;
        if (r1 == r2) goto L17;
        if (this.l != 0) goto L17;
        this.l = r8;
        this.m = null;
        SmartRefreshLayout r3 = r7.a;
        r3.x1 = r2;
        f r4 = r3.L1;
        if (r4 != null) goto L12;
    L14:
        r3.g1 = r3.g1.b();
    L15:
        this.m = r0;
        goto L17
    L12:
        if (r3.y2 == false) goto L14;
        SmartRefreshLayout.i r5 = r3.T1;
        int r6 = r3.b1;
        r4.j(r5, r6, (int) (r2 * r6));
    L17:
        if (this.n == null) goto L19;
    L23:
        this.l = r8;
        this.n = r7;
        int r10 = this.k;
        SmartRefreshLayout r11 = r7.a;
        r11.e = r10;
        boolean r12 = !this.j;
        if (equals(r11.L1) == false) goto L27;
        r7.a.v2 = r12;
    L29:
        r0.j(r7, r8, r9);
        return;
    L27:
        if (equals(r7.a.M1) == false) goto L29;
        r7.a.x2 = r12;
        goto L29
    L19:
        if (r0.getSpinnerStyle() != n6a.b.d) goto L23;
        if (isInEditMode() == true) goto L23;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r0.getView().getLayoutParams();
        r13.topMargin -= r8;
        r0.getView().setLayoutParams(r13);
        goto L23
    }

    @Override // p6a.b, m6a.g
    public final void b(boolean r8, float r9, int r10, int r11, int r12) {
        g r0 = this.m;
        if (this.d == r10) goto L11;
        if (r0 == null) goto L11;
        this.d = r10;
        n6a.b r1 = r0.getSpinnerStyle();
        if (r1 != n6a.b.d) goto L9;
        r0.getView().setTranslationY(r10);
        goto L11
    L9:
        if (r1.c == false) goto L11;
        View r2 = r0.getView();
        r2.layout(r2.getLeft(), r2.getTop(), r2.getRight(), r2.getTop() + Math.max(0, r10));
    L11:
        g r3 = this.m;
        h r6 = this.n;
        if (r3 == null) goto L14;
        r3.b(r8, r9, r10, r11, r12);
    L14:
        if (r8 == false) goto L33;
        float r4 = this.e;
        float r5 = this.g;
        if (r4 >= r5) goto L23;
        if (r9 < r5) goto L23;
        if (this.i == false) goto L23;
        ((SmartRefreshLayout.i) r6).d(RefreshState.ReleaseToTwoLevel);
    L31:
        this.e = r9;
        return;
    L23:
        if (r4 >= r5) goto L25;
    L27:
        if (r4 < r5) goto L31;
        if (r9 >= r5) goto L31;
        ((SmartRefreshLayout.i) r6).d(RefreshState.ReleaseToRefresh);
        goto L31
    L25:
        if (r9 >= this.h) goto L27;
        ((SmartRefreshLayout.i) r6).d(RefreshState.PullDownToRefresh);
        goto L31
    }
}
