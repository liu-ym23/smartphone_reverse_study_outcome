package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
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

/* JADX INFO: loaded from: classes.dex */
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
    private MenuItemImpl itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    public NavigationMenuItemView(@NonNull Context r10) {
        this(r10, null);
    }

    public NavigationMenuItemView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public NavigationMenuItemView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        AccessibilityDelegateCompat r13 = new AnonymousClass1(this);
        this.accessibilityDelegate = r13;
        setOrientation(0);
        LayoutInflater.from(r10).inflate(q5.h.design_navigation_menu_item, this, true);
        setIconSize(r10.getResources().getDimensionPixelSize(q5.d.design_navigation_icon_size));
        CheckedTextView r14 = (CheckedTextView) findViewById(q5.f.design_menu_item_text);
        this.textView = r14;
        r14.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(r14, r13);
    }

    private void adjustAppearance() {
        if (shouldExpandActionArea() == false) goto L7;
        this.textView.setVisibility(8);
        FrameLayout r10 = this.actionArea;
        if (r10 == null) goto L12;
        LinearLayoutCompat.LayoutParams r11 = (LinearLayoutCompat.LayoutParams) r10.getLayoutParams();
        int r12 = -1;
    L10:
        ((LinearLayout.LayoutParams) r11).width = r12;
        this.actionArea.setLayoutParams(r11);
        return;
    L12:
        return;
    L7:
        this.textView.setVisibility(0);
        FrameLayout r13 = this.actionArea;
        if (r13 == null) goto L13;
        r11 = (LinearLayoutCompat.LayoutParams) r13.getLayoutParams();
        r12 = -2;
        goto L10
    }

    @Nullable
    private StateListDrawable createDefaultBackground() {
        TypedValue r10 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, r10, true) == false) goto L6;
        StateListDrawable r11 = new StateListDrawable();
        r11.addState(CHECKED_STATE_SET, new ColorDrawable(r10.data));
        r11.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return r11;
    L6:
        return null;
    }

    private void setActionView(@Nullable View r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.actionArea != null) goto L6;
        this.actionArea = (FrameLayout) ((ViewStub) findViewById(q5.f.design_menu_item_action_area_stub)).inflate();
    L6:
        this.actionArea.removeAllViews();
        this.actionArea.addView(r10);
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
    public void initialize(@NonNull MenuItemImpl r10, int r11) {
        this.itemData = r10;
        if (r10.getItemId() <= 0) goto L6;
        setId(r10.getItemId());
    L6:
        if (r10.isVisible() == false) goto L8;
        int r12 = 0;
    L9:
        setVisibility(r12);
        if (getBackground() != null) goto L12;
        ViewCompat.setBackground(this, createDefaultBackground());
    L12:
        setCheckable(r10.isCheckable());
        setChecked(r10.isChecked());
        setEnabled(r10.isEnabled());
        setTitle(r10.getTitle());
        setIcon(r10.getIcon());
        setActionView(r10.getActionView());
        setContentDescription(r10.getContentDescription());
        TooltipCompat.setTooltipText(this, r10.getTooltipText());
        adjustAppearance();
        return;
    L8:
        r12 = 8;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 1);
        MenuItemImpl r12 = this.itemData;
        if (r12 != null) goto L5;
    L9:
        return r11;
    L5:
        if (r12.isCheckable() == false) goto L9;
        if (this.itemData.isChecked() == false) goto L9;
        ViewGroup.mergeDrawableStates(r11, CHECKED_STATE_SET);
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void recycle() {
        FrameLayout r10 = this.actionArea;
        if (r10 == null) goto L5;
        r10.removeAllViews();
    L5:
        this.textView.setCompoundDrawables(null, null, null, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r10) {
        refreshDrawableState();
        if (this.checkable == r10) goto L6;
        this.checkable = r10;
        this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r10) {
        refreshDrawableState();
        this.textView.setChecked(r10);
    }

    public void setHorizontalPadding(int r10) {
        setPadding(r10, getPaddingTop(), r10, getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable r10) {
        if (r10 == null) goto L13;
        if (this.hasIconTintList == false) goto L11;
        Drawable.ConstantState r11 = r10.getConstantState();
        if (r11 == null) goto L10;
        r10 = r11.newDrawable();
    L10:
        r10 = DrawableCompat.wrap(r10).mutate();
        DrawableCompat.setTintList(r10, this.iconTintList);
    L11:
        int r12 = this.iconSize;
        r10.setBounds(0, 0, r12, r12);
    L20:
        TextViewCompat.setCompoundDrawablesRelative(this.textView, r10, null, null, null);
        return;
    L13:
        if (this.needsEmptyIcon == false) goto L20;
        if (this.emptyDrawable != null) goto L19;
        Drawable r13 = ResourcesCompat.getDrawable(getResources(), q5.e.navigation_empty_icon, getContext().getTheme());
        this.emptyDrawable = r13;
        if (r13 == null) goto L19;
        int r14 = this.iconSize;
        r13.setBounds(0, 0, r14, r14);
    L19:
        r10 = this.emptyDrawable;
        goto L20
    }

    public void setIconPadding(int r10) {
        this.textView.setCompoundDrawablePadding(r10);
    }

    public void setIconSize(@Dimension int r10) {
        this.iconSize = r10;
    }

    void setIconTintList(ColorStateList r10) {
        this.iconTintList = r10;
        if (r10 == null) goto L5;
        boolean r11 = true;
    L6:
        this.hasIconTintList = r11;
        MenuItemImpl r12 = this.itemData;
        if (r12 == null) goto L10;
        setIcon(r12.getIcon());
        return;
    L10:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void setMaxLines(int r10) {
        this.textView.setMaxLines(r10);
    }

    public void setNeedsEmptyIcon(boolean r10) {
        this.needsEmptyIcon = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r10, char r11) {
    }

    public void setTextAppearance(int r10) {
        TextViewCompat.setTextAppearance(this.textView, r10);
    }

    public void setTextColor(ColorStateList r10) {
        this.textView.setTextColor(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r10) {
        this.textView.setText(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }
}
