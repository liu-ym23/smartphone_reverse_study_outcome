package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.shape.MaterialShapeDrawable;
import q5.d;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationView extends NavigationBarView {

    class a implements ViewUtils.d {
        a(BottomNavigationView r10) {
        }

        @Override // com.google.android.material.internal.ViewUtils.d
        @NonNull
        public WindowInsetsCompat a(View r10, @NonNull WindowInsetsCompat r11, @NonNull ViewUtils.e r12) {
            r12.f3376d += r11.getSystemWindowInsetBottom();
            boolean r13 = true;
            if (ViewCompat.getLayoutDirection(r10) == 1) goto L6;
            r13 = false;
        L6:
            int r14 = r11.getSystemWindowInsetLeft();
            int r15 = r11.getSystemWindowInsetRight();
            int r16 = r12.f3373a;
            if (r13 == false) goto L9;
            int r17 = r15;
        L10:
            r12.f3373a = r16 + r17;
            int r18 = r12.f3375c;
            if (r13 == true) goto L14;
            r14 = r15;
        L14:
            r12.f3375c = r18 + r14;
            r12.a(r10);
            return r11;
        L9:
            r17 = r14;
            goto L10
        }
    }

    @Deprecated
    public interface b extends NavigationBarView.a {
    }

    @Deprecated
    public interface c extends NavigationBarView.b {
    }

    public BottomNavigationView(@NonNull Context r10) {
        this(r10, null);
    }

    public BottomNavigationView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        this(r10, r11, r12, k.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        Context r14 = getContext();
        TintTypedArray r15 = com.google.android.material.internal.k.i(r14, r11, l.BottomNavigationView, r12, r13, new int[0]);
        setItemHorizontalTranslationEnabled(r15.getBoolean(l.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int r16 = l.BottomNavigationView_android_minHeight;
        if (r15.hasValue(r16) == false) goto L5;
        setMinimumHeight(r15.getDimensionPixelSize(r16, 0));
    L5:
        r15.recycle();
        if (i() == false) goto L8;
        f(r14);
    L8:
        g();
    }

    private void f(@NonNull Context r10) {
        View r11 = new View(r10);
        r11.setBackgroundColor(ContextCompat.getColor(r10, q5.c.design_bottom_navigation_shadow_color));
        r11.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.design_bottom_navigation_shadow_height)));
        addView(r11);
    }

    private void g() {
        ViewUtils.b(this, new a(this));
    }

    private int h(int r10) {
        int r11 = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(r10) == 1073741824) goto L7;
        if (r11 <= 0) goto L7;
        int r12 = r11 + (getPaddingTop() + getPaddingBottom());
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r10), r12), 1073741824);
    L7:
        return r10;
    }

    private boolean i() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L7:
        return false;
    L5:
        if ((getBackground() instanceof MaterialShapeDrawable) == true) goto L7;
        return true;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected NavigationBarMenuView d(@NonNull Context r10) {
        return new BottomNavigationMenuView(r10);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, h(r11));
    }

    public void setItemHorizontalTranslationEnabled(boolean r10) {
        BottomNavigationMenuView r11 = (BottomNavigationMenuView) getMenuView();
        if (r11.isItemHorizontalTranslationEnabled() == r10) goto L6;
        r11.setItemHorizontalTranslationEnabled(r10);
        getPresenter().updateMenuView(false);
        return;
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable b r10) {
        setOnItemReselectedListener(r10);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable c r10) {
        setOnItemSelectedListener(r10);
    }
}
