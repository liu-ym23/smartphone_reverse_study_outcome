package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    private static final int[] CHECKED_STATE_SET = null;
    private final AccessibilityDelegateCompat accessibilityDelegate;
    private FrameLayout actionArea;
    boolean checkable;
    private Drawable emptyDrawable;
    private boolean hasIconTintList;
    private int iconSize;
    private ColorStateList iconTintList;
    boolean isBold;
    private MenuItemImpl itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    public NavigationMenuItemView(@NonNull Context r5) {
        this(r5, null);
    }

    private void adjustAppearance() {
        if (shouldExpandActionArea() == false) goto L7;
        this.textView.setVisibility(8);
        FrameLayout r5 = this.actionArea;
        if (r5 == null) goto L11;
        LinearLayoutCompat.LayoutParams r10 = (LinearLayoutCompat.LayoutParams) r5.getLayoutParams();
        ((LinearLayout.LayoutParams) r10).width = -1;
        this.actionArea.setLayoutParams(r10);
        return;
    L11:
        return;
    L7:
        this.textView.setVisibility(0);
        FrameLayout r11 = this.actionArea;
        if (r11 == null) goto L13;
        LinearLayoutCompat.LayoutParams r12 = (LinearLayoutCompat.LayoutParams) r11.getLayoutParams();
        ((LinearLayout.LayoutParams) r12).width = -2;
        this.actionArea.setLayoutParams(r12);
        return;
    }

    @Nullable
    private StateListDrawable createDefaultBackground() {
        TypedValue r5 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, r5, true) == false) goto L6;
        StateListDrawable r10 = new StateListDrawable();
        r10.addState(CHECKED_STATE_SET, new ColorDrawable(r5.data));
        r10.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return r10;
    L6:
        return null;
    }

    private void setActionView(@Nullable View r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.actionArea != null) goto L7;
        this.actionArea = (FrameLayout) ((ViewStub) findViewById(com.google.android.material.R.id.design_menu_item_action_area_stub)).inflate();
    L7:
        if (r5.getParent() == null) goto L9;
        ((ViewGroup) r5.getParent()).removeView(r5);
    L9:
        this.actionArea.removeAllViews();
        this.actionArea.addView(r5);
    }

    private boolean shouldExpandActionArea() {
        if (this.itemData.getTitle() == null) goto L5;
    L9:
        return false;
    L5:
        if (this.itemData.getIcon() != null) goto L9;
        if (this.itemData.getActionView() == null) goto L9;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl r5, int r10) {
        this.itemData = r5;
        if (r5.getItemId() <= 0) goto L6;
        setId(r5.getItemId());
    L6:
        if (r5.isVisible() == false) goto L8;
        int r11 = 0;
    L9:
        setVisibility(r11);
        if (getBackground() != null) goto L12;
        ViewCompat.setBackground(this, createDefaultBackground());
    L12:
        setCheckable(r5.isCheckable());
        setChecked(r5.isChecked());
        setEnabled(r5.isEnabled());
        setTitle(r5.getTitle());
        setIcon(r5.getIcon());
        setActionView(r5.getActionView());
        setContentDescription(r5.getContentDescription());
        TooltipCompat.setTooltipText(this, r5.getTooltipText());
        adjustAppearance();
        return;
    L8:
        r11 = 8;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r5) {
        int[] r10 = super.onCreateDrawableState(r5 + 1);
        MenuItemImpl r11 = this.itemData;
        if (r11 != null) goto L5;
    L9:
        return r10;
    L5:
        if (r11.isCheckable() == false) goto L9;
        if (this.itemData.isChecked() == false) goto L9;
        View.mergeDrawableStates(r10, CHECKED_STATE_SET);
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void recycle() {
        FrameLayout r5 = this.actionArea;
        if (r5 == null) goto L5;
        r5.removeAllViews();
    L5:
        this.textView.setCompoundDrawables(null, null, null, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r5) {
        refreshDrawableState();
        if (this.checkable == r5) goto L6;
        this.checkable = r5;
        this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r5) {
        refreshDrawableState();
        this.textView.setChecked(r5);
        CheckedTextView r10 = this.textView;
        Typeface r11 = r10.getTypeface();
        if (r5 == true) goto L5;
    L7:
        int r12 = 0;
    L8:
        r10.setTypeface(r11, r12);
        return;
    L5:
        if (this.isBold == false) goto L7;
        r12 = 1;
        goto L8
    }

    public void setHorizontalPadding(int r5) {
        setPadding(r5, getPaddingTop(), r5, getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable r5) {
        if (r5 == null) goto L13;
        if (this.hasIconTintList == false) goto L11;
        Drawable.ConstantState r10 = r5.getConstantState();
        if (r10 == null) goto L10;
        r5 = r10.newDrawable();
    L10:
        r5 = DrawableCompat.wrap(r5).mutate();
        DrawableCompat.setTintList(r5, this.iconTintList);
    L11:
        int r11 = this.iconSize;
        r5.setBounds(0, 0, r11, r11);
    L20:
        TextViewCompat.setCompoundDrawablesRelative(this.textView, r5, null, null, null);
        return;
    L13:
        if (this.needsEmptyIcon == false) goto L20;
        if (this.emptyDrawable != null) goto L19;
        Drawable r12 = ResourcesCompat.getDrawable(getResources(), com.google.android.material.R.drawable.navigation_empty_icon, getContext().getTheme());
        this.emptyDrawable = r12;
        if (r12 == null) goto L19;
        int r13 = this.iconSize;
        r12.setBounds(0, 0, r13, r13);
    L19:
        r5 = this.emptyDrawable;
        goto L20
    }

    public void setIconPadding(int r5) {
        this.textView.setCompoundDrawablePadding(r5);
    }

    public void setIconSize(@Dimension int r5) {
        this.iconSize = r5;
    }

    public void setIconTintList(ColorStateList r5) {
        this.iconTintList = r5;
        if (r5 == null) goto L5;
        boolean r10 = true;
    L6:
        this.hasIconTintList = r10;
        MenuItemImpl r11 = this.itemData;
        if (r11 == null) goto L10;
        setIcon(r11.getIcon());
        return;
    L10:
        return;
    L5:
        r10 = false;
        goto L6
    }

    public void setMaxLines(int r5) {
        this.textView.setMaxLines(r5);
    }

    public void setNeedsEmptyIcon(boolean r5) {
        this.needsEmptyIcon = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r5, char r10) {
    }

    public void setTextAppearance(int r5) {
        TextViewCompat.setTextAppearance(this.textView, r5);
    }

    public void setTextColor(ColorStateList r5) {
        this.textView.setTextColor(r5);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r5) {
        this.textView.setText(r5);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public NavigationMenuItemView(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.isBold = true;
        AccessibilityDelegateCompat r12 = new AnonymousClass1(this);
        this.accessibilityDelegate = r12;
        setOrientation(0);
        LayoutInflater.from(r5).inflate(com.google.android.material.R.layout.design_navigation_menu_item, this, true);
        setIconSize(r5.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.design_navigation_icon_size));
        CheckedTextView r13 = (CheckedTextView) findViewById(com.google.android.material.R.id.design_menu_item_text);
        this.textView = r13;
        r13.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(r13, r12);
    }

    public void initialize(@NonNull MenuItemImpl r5, boolean r10) {
        this.isBold = r10;
        initialize(r5, 0);
    }
}
