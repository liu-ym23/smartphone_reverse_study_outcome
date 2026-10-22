package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import q5.d;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private boolean itemHorizontalTranslationEnabled;
    private int[] tempChildWidths;

    public BottomNavigationMenuView(@NonNull Context r10) {
        super(r10);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 17;
        setLayoutParams(r11);
        Resources r12 = getResources();
        this.inactiveItemMaxWidth = r12.getDimensionPixelSize(d.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = r12.getDimensionPixelSize(d.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = r12.getDimensionPixelSize(d.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = r12.getDimensionPixelSize(d.design_bottom_navigation_active_item_min_width);
        this.tempChildWidths = new int[5];
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    protected NavigationBarItemView createNavigationBarItemView(@NonNull Context r10) {
        return new BottomNavigationItemView(r10);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        int r16 = r13 - r11;
        int r17 = r14 - r12;
        int r18 = 0;
        int r19 = 0;
    L3:
        if (r18 >= r15) goto L13;
        View r20 = getChildAt(r18);
        if (r20.getVisibility() == 8) goto L12;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
        int r21 = r16 - r19;
        r20.layout(r21 - r20.getMeasuredWidth(), 0, r21, r17);
    L11:
        r19 = r19 + r20.getMeasuredWidth();
        goto L12
    L10:
        r20.layout(r19, 0, r20.getMeasuredWidth() + r19, r17);
    L12:
        r18 = r18 + 1;
        goto L3
    }

    @Override // android.view.View
    protected void onMeasure(int r13, int r14) {
        MenuBuilder r10 = getMenu();
        int r15 = View.MeasureSpec.getSize(r13);
        int r11 = r10.getVisibleItems().size();
        int r12 = getChildCount();
        int r16 = View.MeasureSpec.getSize(r14);
        int r17 = View.MeasureSpec.makeMeasureSpec(r16, 1073741824);
        if (isShifting(getLabelVisibilityMode(), r11) == true) goto L5;
    L30:
        if (r11 != 0) goto L32;
        int r18 = 1;
    L33:
        int r19 = Math.min(r15 / r18, this.activeItemMaxWidth);
        int r110 = r15 - (r11 * r19);
        int r20 = 0;
    L34:
        if (r20 >= r12) goto L42;
        if (getChildAt(r20).getVisibility() == 8) goto L40;
        int[] r21 = this.tempChildWidths;
        r21[r20] = r19;
        if (r110 <= 0) goto L41;
        r21[r20] = r21[r20] + 1;
        r110 = r110 - 1;
    L41:
        r20 = r20 + 1;
        goto L34
    L40:
        this.tempChildWidths[r20] = 0;
    L42:
        int r111 = 0;
        int r22 = 0;
    L43:
        if (r111 >= r12) goto L49;
        View r23 = getChildAt(r111);
        if (r23.getVisibility() == 8) goto L48;
        r23.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[r111], 1073741824), r17);
        r23.getLayoutParams().width = r23.getMeasuredWidth();
        r22 = r22 + r23.getMeasuredWidth();
    L48:
        r111 = r111 + 1;
        goto L43
    L49:
        setMeasuredDimension(View.resolveSizeAndState(r22, View.MeasureSpec.makeMeasureSpec(r22, 1073741824), 0), View.resolveSizeAndState(r16, r14, 0));
        return;
    L32:
        r18 = r11;
        goto L33
    L5:
        if (isItemHorizontalTranslationEnabled() == false) goto L30;
        View r24 = getChildAt(getSelectedItemPosition());
        int r25 = this.activeItemMinWidth;
        if (r24.getVisibility() == 8) goto L10;
        r24.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), r17);
        r25 = Math.max(r25, r24.getMeasuredWidth());
    L10:
        if (r24.getVisibility() == 8) goto L12;
        int r26 = 1;
    L13:
        int r27 = r11 - r26;
        int r28 = Math.min(r15 - (this.inactiveItemMinWidth * r27), Math.min(r25, this.activeItemMaxWidth));
        int r112 = r15 - r28;
        if (r27 != 0) goto L16;
        int r29 = 1;
    L17:
        int r30 = Math.min(r112 / r29, this.inactiveItemMaxWidth);
        int r113 = r112 - (r27 * r30);
        int r31 = 0;
    L18:
        if (r31 >= r12) goto L42;
        if (getChildAt(r31).getVisibility() == 8) goto L28;
        int[] r114 = this.tempChildWidths;
        if (r31 != getSelectedItemPosition()) goto L24;
        int r115 = r28;
    L25:
        r114[r31] = r115;
        if (r113 <= 0) goto L29;
        int[] r116 = this.tempChildWidths;
        r116[r31] = r116[r31] + 1;
        r113 = r113 - 1;
    L29:
        r31 = r31 + 1;
        goto L18
    L24:
        r115 = r30;
        goto L25
    L28:
        this.tempChildWidths[r31] = 0;
        goto L29
    L16:
        r29 = r27;
        goto L17
    L12:
        r26 = 0;
        goto L13
    }

    public void setItemHorizontalTranslationEnabled(boolean r10) {
        this.itemHorizontalTranslationEnabled = r10;
    }
}
