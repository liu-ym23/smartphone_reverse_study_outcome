package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.k;
import com.google.android.material.resources.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;
import com.google.android.material.shape.l;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavigationBarMenu f3998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NavigationBarMenuView f3999b;
    private final NavigationBarPresenter c;
    private ColorStateList d;
    private MenuInflater e;
    private b f;
    private a g;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Bundle menuPresenterState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r2 != null) goto L5;
            r2 = getClass().getClassLoader();
        L5:
            readFromParcel(r1, r2);
        }

        public SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        private void readFromParcel(Parcel r1, ClassLoader r2) {
            this.menuPresenterState = r1.readBundle(r2);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeBundle(this.menuPresenterState);
        }
    }

    public interface a {
        void a(MenuItem r1);
    }

    public interface b {
        boolean a(MenuItem r1);
    }

    public NavigationBarView(Context r16, AttributeSet r17, int r18, int r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r2 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r17, AttributeSet.class, "com.obric.memorydata.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r1, r2, r18, r19), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2, r18);
        NavigationBarPresenter r8 = new NavigationBarPresenter();
        this.c = r8;
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        TintTypedArray r3 = k.b(r9, r2, R.styleable.NavigationBarView, r18, r19, new int[]{ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextAppearanceInactive, "styleable", "NavigationBarView_itemTextAppearanceInactive"), ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextAppearanceActive, "styleable", "NavigationBarView_itemTextAppearanceActive")});
        NavigationBarMenu r4 = new NavigationBarMenu(r9, getClass(), getMaxItemCount());
        this.f3998a = r4;
        NavigationBarMenuView r5 = a(r9);
        this.f3999b = r5;
        r8.setMenuView(r5);
        r8.setId(1);
        r5.setPresenter(r8);
        r4.addMenuPresenter(r8);
        r8.initForMenu((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemIconTint, "styleable", "NavigationBarView_itemIconTint")) == false) goto L5;
        ColorStateList r6 = r3.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemIconTint, "styleable", "NavigationBarView_itemIconTint"));
    L6:
        r5.setIconTintList(r6);
        setItemIconSize(r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemIconSize, "styleable", "NavigationBarView_itemIconSize"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_navigation_bar_item_default_icon_size, "dimen", "mtrl_navigation_bar_item_default_icon_size"))));
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextAppearanceInactive, "styleable", "NavigationBarView_itemTextAppearanceInactive")) == false) goto L10;
        setItemTextAppearanceInactive(r3.getResourceId(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextAppearanceInactive, "styleable", "NavigationBarView_itemTextAppearanceInactive"), 0));
    L10:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextAppearanceActive, "styleable", "NavigationBarView_itemTextAppearanceActive")) == false) goto L13;
        setItemTextAppearanceActive(r3.getResourceId(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextAppearanceActive, "styleable", "NavigationBarView_itemTextAppearanceActive"), 0));
    L13:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextColor, "styleable", "NavigationBarView_itemTextColor")) == false) goto L16;
        setItemTextColor(r3.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextColor, "styleable", "NavigationBarView_itemTextColor")));
    L16:
        if (getBackground() != null) goto L18;
    L19:
        ViewCompat.setBackground(this, b(r9));
    L21:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemPaddingTop, "styleable", "NavigationBarView_itemPaddingTop")) == false) goto L24;
        setItemPaddingTop(r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemPaddingTop, "styleable", "NavigationBarView_itemPaddingTop"), 0));
    L24:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemPaddingBottom, "styleable", "NavigationBarView_itemPaddingBottom")) == false) goto L27;
        setItemPaddingBottom(r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemPaddingBottom, "styleable", "NavigationBarView_itemPaddingBottom"), 0));
    L27:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_elevation, "styleable", "NavigationBarView_elevation")) == false) goto L29;
        setElevation(r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_elevation, "styleable", "NavigationBarView_elevation"), 0));
    L29:
        DrawableCompat.setTintList(getBackground().mutate(), c.a(r9, r3, ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_backgroundTint, "styleable", "NavigationBarView_backgroundTint")));
        setLabelVisibilityMode(r3.getInteger(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_labelVisibilityMode, "styleable", "NavigationBarView_labelVisibilityMode"), -1));
        int r7 = r3.getResourceId(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemBackground, "styleable", "NavigationBarView_itemBackground"), 0);
        if (r7 == 0) goto L32;
        r5.setItemBackgroundRes(r7);
    L33:
        int r10 = r3.getResourceId(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemActiveIndicatorStyle, "styleable", "NavigationBarView_itemActiveIndicatorStyle"), 0);
        if (r10 == 0) goto L37;
        setItemActiveIndicatorEnabled(true);
        TypedArray r11 = r9.obtainStyledAttributes(r10, R.styleable.NavigationBarActiveIndicator);
        setItemActiveIndicatorWidth(r11.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.NavigationBarActiveIndicator_android_width, "styleable", "NavigationBarActiveIndicator_android_width"), 0));
        setItemActiveIndicatorHeight(r11.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.NavigationBarActiveIndicator_android_height, "styleable", "NavigationBarActiveIndicator_android_height"), 0));
        setItemActiveIndicatorMarginHorizontal(r11.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.NavigationBarActiveIndicator_marginHorizontal, "styleable", "NavigationBarActiveIndicator_marginHorizontal"), 0));
        setItemActiveIndicatorColor(c.a(r9, r11, ZeusTransformUtils.mapRes(R.styleable.NavigationBarActiveIndicator_android_color, "styleable", "NavigationBarActiveIndicator_android_color")));
        setItemActiveIndicatorShapeAppearance(l.a(r9, r11.getResourceId(ZeusTransformUtils.mapRes(R.styleable.NavigationBarActiveIndicator_shapeAppearance, "styleable", "NavigationBarActiveIndicator_shapeAppearance"), 0), 0).a());
        r11.recycle();
    L37:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_menu, "styleable", "NavigationBarView_menu")) == false) goto L39;
        a(r3.getResourceId(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_menu, "styleable", "NavigationBarView_menu"), 0));
    L39:
        r3.recycle();
        addView(r5);
        r4.setCallback(new AnonymousClass1(this));
        return;
    L32:
        setItemRippleColor(c.a(r9, r3, ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemRippleColor, "styleable", "NavigationBarView_itemRippleColor")));
        goto L33
    L18:
        if (ZeusTransformUtils.instanceOf(getBackground(), ColorDrawable.class) == false) goto L21;
    L5:
        r6 = r5.createDefaultColorStateList(android.R.attr.textColorSecondary);
        goto L6
    }

    static /* synthetic */ a a(NavigationBarView r0) {
        return r0.g;
    }

    static /* synthetic */ b b(NavigationBarView r0) {
        return r0.f;
    }

    private MaterialShapeDrawable b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        Drawable r3 = getBackground();
        if (ZeusTransformUtils.instanceOf(r3, ColorDrawable.class) == false) goto L5;
        r0.setFillColor(ColorStateList.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r3, ColorDrawable.class, "com.obric.memorydata.plugin")).getColor()));
    L5:
        r0.initializeElevationOverlay(r5);
        return r0;
    }

    private MenuInflater getMenuInflater() {
        if (this.e != null) goto L6;
        this.e = new SupportMenuInflater((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L6:
        return this.e;
    }

    public abstract NavigationBarMenuView a(Context r1);

    public void a(int r4) {
        this.c.setUpdateSuspended(true);
        getMenuInflater().inflate(r4, this.f3998a);
        this.c.setUpdateSuspended(false);
        this.c.updateMenuView(true);
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f3999b.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f3999b.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f3999b.getItemActiveIndicatorMarginHorizontal();
    }

    public l getItemActiveIndicatorShapeAppearance() {
        return this.f3999b.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f3999b.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.f3999b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f3999b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f3999b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f3999b.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f3999b.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f3999b.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.d;
    }

    public int getItemTextAppearanceActive() {
        return this.f3999b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f3999b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f3999b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f3999b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f3998a;
    }

    public MenuView getMenuView() {
        return this.f3999b;
    }

    public NavigationBarPresenter getPresenter() {
        return this.c;
    }

    public int getSelectedItemId() {
        return this.f3999b.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.a(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        this.f3998a.restorePresenterStates(r5.menuPresenterState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.menuPresenterState = new Bundle();
        this.f3998a.savePresenterStates(r1.menuPresenterState);
        return r1;
    }

    @Override // android.view.View
    public void setElevation(float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        super.setElevation(r3);
    L5:
        h.a(this, r3);
    }

    public void setItemActiveIndicatorColor(ColorStateList r1) {
        this.f3999b.setItemActiveIndicatorColor(r1);
    }

    public void setItemActiveIndicatorEnabled(boolean r1) {
        this.f3999b.setItemActiveIndicatorEnabled(r1);
    }

    public void setItemActiveIndicatorHeight(int r1) {
        this.f3999b.setItemActiveIndicatorHeight(r1);
    }

    public void setItemActiveIndicatorMarginHorizontal(int r1) {
        this.f3999b.setItemActiveIndicatorMarginHorizontal(r1);
    }

    public void setItemActiveIndicatorShapeAppearance(l r1) {
        this.f3999b.setItemActiveIndicatorShapeAppearance(r1);
    }

    public void setItemActiveIndicatorWidth(int r1) {
        this.f3999b.setItemActiveIndicatorWidth(r1);
    }

    public void setItemBackground(Drawable r2) {
        this.f3999b.setItemBackground(r2);
        this.d = null;
    }

    public void setItemBackgroundResource(int r2) {
        this.f3999b.setItemBackgroundRes(r2);
        this.d = null;
    }

    public void setItemIconSize(int r1) {
        this.f3999b.setItemIconSize(r1);
    }

    public void setItemIconSizeRes(int r2) {
        setItemIconSize(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r2));
    }

    public void setItemIconTintList(ColorStateList r1) {
        this.f3999b.setIconTintList(r1);
    }

    public void setItemPaddingBottom(int r1) {
        this.f3999b.setItemPaddingBottom(r1);
    }

    public void setItemPaddingTop(int r1) {
        this.f3999b.setItemPaddingTop(r1);
    }

    public void setItemRippleColor(ColorStateList r4) {
        if (this.d != r4) goto L9;
        if (r4 == null) goto L6;
        return;
    L6:
        if (this.f3999b.getItemBackground() == null) goto L19;
        this.f3999b.setItemBackground(null);
        return;
    L19:
        return;
    L9:
        this.d = r4;
        if (r4 != null) goto L12;
        this.f3999b.setItemBackground(null);
        return;
    L12:
        ColorStateList r5 = com.google.android.material.ripple.a.a(r4);
        if (Build.VERSION.SDK_INT < 21) goto L15;
        NavigationBarMenuView r3 = this.f3999b;
        Drawable r0 = new RippleDrawable(r5, null, null);
    L16:
        r3.setItemBackground(r0);
        return;
    L15:
        GradientDrawable r1 = new GradientDrawable();
        r1.setCornerRadius(1.0E-5f);
        r0 = DrawableCompat.wrap(r1);
        DrawableCompat.setTintList(r0, r5);
        r3 = this.f3999b;
        goto L16
    }

    public void setItemTextAppearanceActive(int r1) {
        this.f3999b.setItemTextAppearanceActive(r1);
    }

    public void setItemTextAppearanceInactive(int r1) {
        this.f3999b.setItemTextAppearanceInactive(r1);
    }

    public void setItemTextColor(ColorStateList r1) {
        this.f3999b.setItemTextColor(r1);
    }

    public void setLabelVisibilityMode(int r2) {
        if (this.f3999b.getLabelVisibilityMode() == r2) goto L6;
        this.f3999b.setLabelVisibilityMode(r2);
        this.c.updateMenuView(false);
        return;
    }

    public void setOnItemReselectedListener(a r3) {
        this.g = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    public void setOnItemSelectedListener(b r3) {
        this.f = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public void setSelectedItemId(int r3) {
        MenuItem r4 = this.f3998a.findItem(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.f3998a.performItemAction(r4, this.c, 0) == true) goto L9;
        r4.setChecked(true);
        return;
    }
}
