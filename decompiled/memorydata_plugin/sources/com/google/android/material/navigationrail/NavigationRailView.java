package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.k;
import com.google.android.material.internal.r;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationRailView extends NavigationBarView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f4002b;
    private Boolean c;
    private Boolean d;

    public NavigationRailView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public NavigationRailView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.navigationRailStyle, "attr", "navigationRailStyle"));
    }

    public NavigationRailView(Context r4, AttributeSet r5, int r6) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), r6, ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_NavigationRailView, "style", "Widget_MaterialComponents_NavigationRailView"));
    }

    public NavigationRailView(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r13, r3, r11, r12);
        this.c = null;
        this.d = null;
        this.f4001a = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_navigation_rail_margin, "dimen", "mtrl_navigation_rail_margin"));
        TintTypedArray r14 = k.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, R.styleable.NavigationRailView, r11, r12, new int[0]);
        int r15 = r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_headerLayout, "styleable", "NavigationRailView_headerLayout"), 0);
        if (r15 == 0) goto L5;
        b(r15);
    L5:
        setMenuGravity(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_menuGravity, "styleable", "NavigationRailView_menuGravity"), 49));
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_itemMinHeight, "styleable", "NavigationRailView_itemMinHeight")) == false) goto L9;
        setItemMinimumHeight(r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_itemMinHeight, "styleable", "NavigationRailView_itemMinHeight"), -1));
    L9:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_paddingTopSystemWindowInsets, "styleable", "NavigationRailView_paddingTopSystemWindowInsets")) == false) goto L12;
        this.c = Boolean.valueOf(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_paddingTopSystemWindowInsets, "styleable", "NavigationRailView_paddingTopSystemWindowInsets"), false));
    L12:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets, "styleable", "NavigationRailView_paddingBottomSystemWindowInsets")) == false) goto L14;
        this.d = Boolean.valueOf(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets, "styleable", "NavigationRailView_paddingBottomSystemWindowInsets"), false));
    L14:
        r14.recycle();
        b();
    }

    static /* synthetic */ Boolean a(NavigationRailView r0) {
        return r0.c;
    }

    static /* synthetic */ boolean a(NavigationRailView r0, Boolean r1) {
        return r0.a(r1);
    }

    private boolean a(Boolean r1) {
        if (r1 == null) goto L5;
        return r1.booleanValue();
    L5:
        return ViewCompat.getFitsSystemWindows(this);
    }

    static /* synthetic */ Boolean b(NavigationRailView r0) {
        return r0.d;
    }

    private void b() {
        r.a(this, new AnonymousClass1(this));
    }

    private int c(int r4) {
        int r0 = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(r4) == 1073741824) goto L7;
        if (r0 <= 0) goto L7;
        int r1 = r0 + (getPaddingLeft() + getPaddingRight());
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r4), r1), 1073741824);
    L7:
        return r4;
    }

    private boolean c() {
        View r1 = this.f4002b;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.getVisibility() == 8) goto L7;
        return true;
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) ZeusTransformUtils.preCheckCast(getMenuView(), NavigationRailMenuView.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public /* synthetic */ NavigationBarMenuView a(Context r3) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public void a() {
        View r0 = this.f4002b;
        if (r0 == null) goto L6;
        removeView(r0);
        this.f4002b = null;
        return;
    }

    public void a(View r3) {
        a();
        this.f4002b = r3;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 49;
        r0.topMargin = this.f4001a;
        addView(r3, 0, r0);
    }

    public NavigationRailMenuView b(Context r2) {
        return new NavigationRailMenuView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public void b(int r4) {
        a(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r4, this, false, "com.obric.memorydata.plugin"));
    }

    public View getHeaderView() {
        return this.f4002b;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) ZeusTransformUtils.preCheckCast(getMenuView(), NavigationRailMenuView.class, "com.obric.memorydata.plugin")).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        NavigationRailMenuView r6 = getNavigationRailMenuView();
        int r7 = 0;
        if (c() == false) goto L8;
        int r8 = this.f4002b.getBottom() + this.f4001a;
        int r0 = r6.getTop();
        if (r0 >= r8) goto L10;
        r7 = r8 - r0;
    L10:
        if (r7 <= 0) goto L13;
        r6.layout(r6.getLeft(), r6.getTop() + r7, r6.getRight(), r6.getBottom() + r7);
        return;
    L13:
        return;
    L8:
        if (r6.isTopGravity() == false) goto L10;
        r7 = this.f4001a;
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r2, int r3) {
        int r4 = c(r2);
        super.onMeasure(r4, r3);
        if (c() == false) goto L6;
        int r5 = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f4002b.getMeasuredHeight()) - this.f4001a, Integer.MIN_VALUE);
        measureChild(getNavigationRailMenuView(), r4, r5);
        return;
    }

    public void setItemMinimumHeight(int r3) {
        ((NavigationRailMenuView) ZeusTransformUtils.preCheckCast(getMenuView(), NavigationRailMenuView.class, "com.obric.memorydata.plugin")).setItemMinimumHeight(r3);
    }

    public void setMenuGravity(int r1) {
        getNavigationRailMenuView().setMenuGravity(r1);
    }
}
