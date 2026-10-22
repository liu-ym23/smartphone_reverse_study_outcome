package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import q5.b;
import q5.d;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class NavigationRailView extends NavigationBarView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f3489m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private View f3490n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private Boolean f3491o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private Boolean f3492p;

    class a implements ViewUtils.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavigationRailView f3493a;

        a(NavigationRailView r10) {
            this.f3493a = r10;
        }

        @Override // com.google.android.material.internal.ViewUtils.d
        @NonNull
        public WindowInsetsCompat a(View r10, @NonNull WindowInsetsCompat r11, @NonNull ViewUtils.e r12) {
            NavigationRailView r13 = this.f3493a;
            if (NavigationRailView.g(r13, NavigationRailView.f(r13)) == false) goto L5;
            r12.f3374b += r11.getInsets(WindowInsetsCompat.Type.systemBars()).top;
        L5:
            NavigationRailView r14 = this.f3493a;
            if (NavigationRailView.g(r14, NavigationRailView.h(r14)) == false) goto L8;
            r12.f3376d += r11.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        L8:
            boolean r15 = true;
            if (ViewCompat.getLayoutDirection(r10) == 1) goto L12;
            r15 = false;
        L12:
            int r16 = r11.getSystemWindowInsetLeft();
            int r17 = r11.getSystemWindowInsetRight();
            int r18 = r12.f3373a;
            if (r15 == false) goto L15;
            r16 = r17;
        L15:
            r12.f3373a = r18 + r16;
            r12.a(r10);
            return r11;
        }
    }

    public NavigationRailView(@NonNull Context r10) {
        this(r10, null);
    }

    public NavigationRailView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, b.navigationRailStyle);
    }

    public NavigationRailView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        this(r10, r11, r12, k.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.f3491o = null;
        this.f3492p = null;
        this.f3489m = getResources().getDimensionPixelSize(d.mtrl_navigation_rail_margin);
        TintTypedArray r14 = com.google.android.material.internal.k.i(getContext(), r11, l.NavigationRailView, r12, r13, new int[0]);
        int r15 = r14.getResourceId(l.NavigationRailView_headerLayout, 0);
        if (r15 == 0) goto L5;
        i(r15);
    L5:
        setMenuGravity(r14.getInt(l.NavigationRailView_menuGravity, 49));
        int r16 = l.NavigationRailView_itemMinHeight;
        if (r14.hasValue(r16) == false) goto L8;
        setItemMinimumHeight(r14.getDimensionPixelSize(r16, -1));
    L8:
        int r17 = l.NavigationRailView_paddingTopSystemWindowInsets;
        if (r14.hasValue(r17) == false) goto L11;
        this.f3491o = Boolean.valueOf(r14.getBoolean(r17, false));
    L11:
        int r18 = l.NavigationRailView_paddingBottomSystemWindowInsets;
        if (r14.hasValue(r18) == false) goto L14;
        this.f3492p = Boolean.valueOf(r14.getBoolean(r18, false));
    L14:
        r14.recycle();
        k();
    }

    static /* synthetic */ Boolean f(NavigationRailView r10) {
        return r10.f3491o;
    }

    static /* synthetic */ boolean g(NavigationRailView r10, Boolean r11) {
        return r10.p(r11);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    static /* synthetic */ Boolean h(NavigationRailView r10) {
        return r10.f3492p;
    }

    private void k() {
        ViewUtils.b(this, new a(this));
    }

    private boolean m() {
        View r10 = this.f3490n;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getVisibility() == 8) goto L7;
        return true;
    }

    private int n(int r10) {
        int r11 = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(r10) == 1073741824) goto L7;
        if (r11 <= 0) goto L7;
        int r12 = r11 + (getPaddingLeft() + getPaddingRight());
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r10), r12), 1073741824);
    L7:
        return r10;
    }

    private boolean p(Boolean r10) {
        if (r10 == null) goto L5;
        return r10.booleanValue();
    L5:
        return ViewCompat.getFitsSystemWindows(this);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected /* bridge */ /* synthetic */ NavigationBarMenuView d(@NonNull Context r10) {
        return l(r10);
    }

    @Nullable
    public View getHeaderView() {
        return this.f3490n;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public void i(@LayoutRes int r10) {
        j(LayoutInflater.from(getContext()).inflate(r10, this, false));
    }

    public void j(@NonNull View r10) {
        o();
        this.f3490n = r10;
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 49;
        r11.topMargin = this.f3489m;
        addView(r10, 0, r11);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected NavigationRailMenuView l(@NonNull Context r10) {
        return new NavigationRailMenuView(r10);
    }

    public void o() {
        View r10 = this.f3490n;
        if (r10 == null) goto L6;
        removeView(r10);
        this.f3490n = null;
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        NavigationRailMenuView r15 = getNavigationRailMenuView();
        int r16 = 0;
        if (m() == false) goto L8;
        int r17 = this.f3490n.getBottom() + this.f3489m;
        int r18 = r15.getTop();
        if (r18 >= r17) goto L10;
        r16 = r17 - r18;
    L10:
        if (r16 <= 0) goto L13;
        r15.layout(r15.getLeft(), r15.getTop() + r16, r15.getRight(), r15.getBottom() + r16);
        return;
    L13:
        return;
    L8:
        if (r15.isTopGravity() == false) goto L10;
        r16 = this.f3489m;
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = n(r10);
        super.onMeasure(r12, r11);
        if (m() == false) goto L6;
        int r13 = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f3490n.getMeasuredHeight()) - this.f3489m, Integer.MIN_VALUE);
        measureChild(getNavigationRailMenuView(), r12, r13);
        return;
    }

    public void setItemMinimumHeight(@Px int r10) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(r10);
    }

    public void setMenuGravity(int r10) {
        getNavigationRailMenuView().setMenuGravity(r10);
    }
}
