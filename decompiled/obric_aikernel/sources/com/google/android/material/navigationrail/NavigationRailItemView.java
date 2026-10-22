package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import androidx.annotation.DimenRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import q5.d;
import q5.h;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class NavigationRailItemView extends NavigationBarItemView {
    public NavigationRailItemView(@NonNull Context r10) {
        super(r10);
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @DimenRes
    protected int getItemDefaultMarginResId() {
        return d.mtrl_navigation_rail_icon_margin;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @LayoutRes
    protected int getItemLayoutResId() {
        return h.mtrl_navigation_rail_item;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (View.MeasureSpec.getMode(r11) != 0) goto L6;
        int r12 = View.MeasureSpec.getSize(r11);
        int r13 = Math.max(getMeasuredHeight(), r12);
        setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(r13, r11, 0));
        return;
    }
}
