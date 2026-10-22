package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private boolean itemHorizontalTranslationEnabled;
    private final List<Integer> tempChildWidths;

    public BottomNavigationMenuView(@NonNull Context r5) {
        super(r5);
        this.tempChildWidths = new ArrayList();
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2);
        r10.gravity = 17;
        setLayoutParams(r10);
        Resources r11 = getResources();
        this.inactiveItemMaxWidth = r11.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = r11.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = r11.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = r11.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context r5) {
        return new BottomNavigationItemView(r5);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        int r14 = getChildCount();
        int r15 = r12 - r10;
        int r16 = r13 - r11;
        int r17 = 0;
        int r18 = 0;
    L3:
        if (r17 >= r14) goto L13;
        View r19 = getChildAt(r17);
        if (r19.getVisibility() == 8) goto L12;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
        int r20 = r15 - r18;
        r19.layout(r20 - r19.getMeasuredWidth(), 0, r20, r16);
    L11:
        r18 = r18 + r19.getMeasuredWidth();
        goto L12
    L10:
        r19.layout(r18, 0, r19.getMeasuredWidth() + r18, r16);
    L12:
        r17 = r17 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r12, int r13) {
        MenuBuilder r5 = getMenu();
        int r14 = View.MeasureSpec.getSize(r12);
        int r10 = r5.getVisibleItems().size();
        int r11 = getChildCount();
        this.tempChildWidths.clear();
        int r15 = View.MeasureSpec.getSize(r13);
        int r16 = View.MeasureSpec.makeMeasureSpec(r15, BasicMeasure.EXACTLY);
        int r17 = 0;
        int r18 = 1;
        if (isShifting(getLabelVisibilityMode(), r10) == true) goto L5;
    L29:
        if (r10 == 0) goto L32;
        r18 = r10;
    L32:
        int r19 = Math.min(r14 / r18, this.activeItemMaxWidth);
        int r110 = r14 - (r10 * r19);
        int r20 = 0;
    L33:
        if (r20 >= r11) goto L41;
        if (getChildAt(r20).getVisibility() == 8) goto L39;
        if (r110 <= 0) goto L38;
        int r21 = r19 + 1;
        r110 = r110 - 1;
    L40:
        this.tempChildWidths.add(Integer.valueOf(r21));
        r20 = r20 + 1;
        goto L33
    L38:
        r21 = r19;
        goto L40
    L39:
        r21 = 0;
    L41:
        int r111 = 0;
    L42:
        if (r17 >= r11) goto L48;
        View r22 = getChildAt(r17);
        if (r22.getVisibility() == 8) goto L47;
        r22.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths.get(r17).intValue(), BasicMeasure.EXACTLY), r16);
        r22.getLayoutParams().width = r22.getMeasuredWidth();
        r111 = r22.getMeasuredWidth() + r111;
    L47:
        r17 = r17 + 1;
        goto L42
    L48:
        setMeasuredDimension(r111, r15);
        return;
    L5:
        if (isItemHorizontalTranslationEnabled() == false) goto L29;
        View r23 = getChildAt(getSelectedItemPosition());
        int r24 = this.activeItemMinWidth;
        if (r23.getVisibility() == 8) goto L10;
        r23.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), r16);
        r24 = Math.max(r24, r23.getMeasuredWidth());
    L10:
        if (r23.getVisibility() == 8) goto L12;
        int r25 = 1;
    L13:
        int r26 = r10 - r25;
        int r27 = Math.min(r14 - (this.inactiveItemMinWidth * r26), Math.min(r24, this.activeItemMaxWidth));
        int r112 = r14 - r27;
        if (r26 == 0) goto L17;
        r18 = r26;
    L17:
        int r28 = Math.min(r112 / r18, this.inactiveItemMaxWidth);
        int r113 = r112 - (r26 * r28);
        int r29 = 0;
    L18:
        if (r29 >= r11) goto L41;
        if (getChildAt(r29).getVisibility() != 8) goto L22;
        int r30 = 0;
    L28:
        this.tempChildWidths.add(Integer.valueOf(r30));
        r29 = r29 + 1;
        goto L18
    L22:
        if (r29 != getSelectedItemPosition()) goto L24;
        r30 = r27;
    L25:
        if (r113 <= 0) goto L28;
        r30 = r30 + 1;
        r113 = r113 - 1;
        goto L28
    L24:
        r30 = r28;
        goto L25
    L12:
        r25 = 0;
        goto L13
    }

    public void setItemHorizontalTranslationEnabled(boolean r5) {
        this.itemHorizontalTranslationEnabled = r5;
    }
}
