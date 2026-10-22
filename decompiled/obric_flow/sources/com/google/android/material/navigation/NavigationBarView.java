package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NavigationBarView extends FrameLayout {
    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;
    private static final int MENU_PRESENTER_ID = 1;

    @NonNull
    private final NavigationBarMenu menu;
    private MenuInflater menuInflater;

    @NonNull
    private final NavigationBarMenuView menuView;

    @NonNull
    private final NavigationBarPresenter presenter;
    private OnItemReselectedListener reselectedListener;
    private OnItemSelectedListener selectedListener;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface LabelVisibility {
    }

    public interface OnItemReselectedListener {
        void onNavigationItemReselected(@NonNull MenuItem r5);
    }

    public interface OnItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem r5);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        Bundle menuPresenterState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }

        private void readFromParcel(@NonNull Parcel r5, ClassLoader r10) {
            this.menuPresenterState = r5.readBundle(r10);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeBundle(this.menuPresenterState);
        }

        public SavedState(@NonNull Parcel r5, ClassLoader r10) {
            super(r5, r10);
            if (r10 != null) goto L5;
            r10 = getClass().getClassLoader();
        L5:
            readFromParcel(r5, r10);
        }
    }

    public NavigationBarView(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        NavigationBarPresenter r14 = new NavigationBarPresenter();
        this.presenter = r14;
        Context r15 = getContext();
        TintTypedArray r5 = ThemeEnforcement.obtainTintedStyledAttributes(r15, r11, R.styleable.NavigationBarView, r12, r13, new int[]{R.styleable.NavigationBarView_itemTextAppearanceInactive, R.styleable.NavigationBarView_itemTextAppearanceActive});
        NavigationBarMenu r16 = new NavigationBarMenu(r15, getClass(), getMaxItemCount());
        this.menu = r16;
        NavigationBarMenuView r17 = createNavigationBarMenuView(r15);
        this.menuView = r17;
        r14.setMenuView(r17);
        r14.setId(1);
        r17.setPresenter(r14);
        r16.addMenuPresenter(r14);
        r14.initForMenu(getContext(), r16);
        if (r5.hasValue(R.styleable.NavigationBarView_itemIconTint) == false) goto L5;
        r17.setIconTintList(r5.getColorStateList(R.styleable.NavigationBarView_itemIconTint));
    L6:
        setItemIconSize(r5.getDimensionPixelSize(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (r5.hasValue(R.styleable.NavigationBarView_itemTextAppearanceInactive) == false) goto L10;
        setItemTextAppearanceInactive(r5.getResourceId(R.styleable.NavigationBarView_itemTextAppearanceInactive, 0));
    L10:
        if (r5.hasValue(R.styleable.NavigationBarView_itemTextAppearanceActive) == false) goto L12;
        setItemTextAppearanceActive(r5.getResourceId(R.styleable.NavigationBarView_itemTextAppearanceActive, 0));
    L12:
        setItemTextAppearanceActiveBoldEnabled(r5.getBoolean(R.styleable.NavigationBarView_itemTextAppearanceActiveBoldEnabled, true));
        if (r5.hasValue(R.styleable.NavigationBarView_itemTextColor) == false) goto L15;
        setItemTextColor(r5.getColorStateList(R.styleable.NavigationBarView_itemTextColor));
    L15:
        Drawable r18 = getBackground();
        ColorStateList r19 = DrawableUtils.getColorStateListOrNull(r18);
        if (r18 == null) goto L18;
        if (r19 != null) goto L18;
    L23:
        if (r5.hasValue(R.styleable.NavigationBarView_itemPaddingTop) == false) goto L26;
        setItemPaddingTop(r5.getDimensionPixelSize(R.styleable.NavigationBarView_itemPaddingTop, 0));
    L26:
        if (r5.hasValue(R.styleable.NavigationBarView_itemPaddingBottom) == false) goto L29;
        setItemPaddingBottom(r5.getDimensionPixelSize(R.styleable.NavigationBarView_itemPaddingBottom, 0));
    L29:
        if (r5.hasValue(R.styleable.NavigationBarView_activeIndicatorLabelPadding) == false) goto L32;
        setActiveIndicatorLabelPadding(r5.getDimensionPixelSize(R.styleable.NavigationBarView_activeIndicatorLabelPadding, 0));
    L32:
        if (r5.hasValue(R.styleable.NavigationBarView_elevation) == false) goto L34;
        setElevation(r5.getDimensionPixelSize(R.styleable.NavigationBarView_elevation, 0));
    L34:
        DrawableCompat.setTintList(getBackground().mutate(), MaterialResources.getColorStateList(r15, r5, R.styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(r5.getInteger(R.styleable.NavigationBarView_labelVisibilityMode, -1));
        int r20 = r5.getResourceId(R.styleable.NavigationBarView_itemBackground, 0);
        if (r20 == 0) goto L37;
        r17.setItemBackgroundRes(r20);
    L38:
        int r21 = r5.getResourceId(R.styleable.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (r21 == 0) goto L42;
        setItemActiveIndicatorEnabled(true);
        TypedArray r22 = r15.obtainStyledAttributes(r21, R.styleable.NavigationBarActiveIndicator);
        setItemActiveIndicatorWidth(r22.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_width, 0));
        setItemActiveIndicatorHeight(r22.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_height, 0));
        setItemActiveIndicatorMarginHorizontal(r22.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_marginHorizontal, 0));
        setItemActiveIndicatorColor(MaterialResources.getColorStateList(r15, r22, R.styleable.NavigationBarActiveIndicator_android_color));
        setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel.builder(r15, r22.getResourceId(R.styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).build());
        r22.recycle();
    L42:
        if (r5.hasValue(R.styleable.NavigationBarView_menu) == false) goto L44;
        inflateMenu(r5.getResourceId(R.styleable.NavigationBarView_menu, 0));
    L44:
        r5.recycle();
        addView(r17);
        r16.setCallback(new AnonymousClass1(this));
        return;
    L37:
        setItemRippleColor(MaterialResources.getColorStateList(r15, r5, R.styleable.NavigationBarView_itemRippleColor));
    L18:
        MaterialShapeDrawable r23 = new MaterialShapeDrawable(ShapeAppearanceModel.builder(r15, r11, r12, r13).build());
        if (r19 == null) goto L21;
        r23.setFillColor(r19);
    L21:
        r23.initializeElevationOverlay(r15);
        ViewCompat.setBackground(this, r23);
        goto L23
    L5:
        r17.setIconTintList(r17.createDefaultColorStateList(android.R.attr.textColorSecondary));
        goto L6
    }

    public static /* synthetic */ OnItemReselectedListener access$000(NavigationBarView r5) {
        return r5.reselectedListener;
    }

    public static /* synthetic */ OnItemSelectedListener access$100(NavigationBarView r5) {
        return r5.selectedListener;
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) goto L6;
        this.menuInflater = new SupportMenuInflater(getContext());
    L6:
        return this.menuInflater;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract NavigationBarMenuView createNavigationBarMenuView(@NonNull Context r5);

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.menuView.getActiveIndicatorLabelPadding();
    }

    @Nullable
    public BadgeDrawable getBadge(int r5) {
        return this.menuView.getBadge(r5);
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.menuView.getItemActiveIndicatorColor();
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.menuView.getItemActiveIndicatorHeight();
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.menuView.getItemActiveIndicatorMarginHorizontal();
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.menuView.getItemActiveIndicatorShapeAppearance();
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.menuView.getItemActiveIndicatorWidth();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    @Px
    public int getItemPaddingBottom() {
        return this.menuView.getItemPaddingBottom();
    }

    @Px
    public int getItemPaddingTop() {
        return this.menuView.getItemPaddingTop();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.menuView.getItemRippleColor();
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuView getMenuView() {
        return this.menuView;
    }

    @NonNull
    public BadgeDrawable getOrCreateBadge(int r5) {
        return this.menuView.getOrCreateBadge(r5);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarPresenter getPresenter() {
        return this.presenter;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void inflateMenu(int r5) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(r5, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(true);
    }

    public boolean isItemActiveIndicatorEnabled() {
        return this.menuView.getItemActiveIndicatorEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        this.menu.restorePresenterStates(r10.menuPresenterState);
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        Bundle r10 = new Bundle();
        r5.menuPresenterState = r10;
        this.menu.savePresenterStates(r10);
        return r5;
    }

    public void removeBadge(int r5) {
        this.menuView.removeBadge(r5);
    }

    public void setActiveIndicatorLabelPadding(@Px int r5) {
        this.menuView.setActiveIndicatorLabelPadding(r5);
    }

    @Override // android.view.View
    public void setElevation(float r5) {
        super.setElevation(r5);
        MaterialShapeUtils.setElevation(this, r5);
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList r5) {
        this.menuView.setItemActiveIndicatorColor(r5);
    }

    public void setItemActiveIndicatorEnabled(boolean r5) {
        this.menuView.setItemActiveIndicatorEnabled(r5);
    }

    public void setItemActiveIndicatorHeight(@Px int r5) {
        this.menuView.setItemActiveIndicatorHeight(r5);
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int r5) {
        this.menuView.setItemActiveIndicatorMarginHorizontal(r5);
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel r5) {
        this.menuView.setItemActiveIndicatorShapeAppearance(r5);
    }

    public void setItemActiveIndicatorWidth(@Px int r5) {
        this.menuView.setItemActiveIndicatorWidth(r5);
    }

    public void setItemBackground(@Nullable Drawable r5) {
        this.menuView.setItemBackground(r5);
    }

    public void setItemBackgroundResource(@DrawableRes int r5) {
        this.menuView.setItemBackgroundRes(r5);
    }

    public void setItemIconSize(@Dimension int r5) {
        this.menuView.setItemIconSize(r5);
    }

    public void setItemIconSizeRes(@DimenRes int r5) {
        setItemIconSize(getResources().getDimensionPixelSize(r5));
    }

    public void setItemIconTintList(@Nullable ColorStateList r5) {
        this.menuView.setIconTintList(r5);
    }

    public void setItemOnTouchListener(int r5, @Nullable View.OnTouchListener r10) {
        this.menuView.setItemOnTouchListener(r5, r10);
    }

    public void setItemPaddingBottom(@Px int r5) {
        this.menuView.setItemPaddingBottom(r5);
    }

    public void setItemPaddingTop(@Px int r5) {
        this.menuView.setItemPaddingTop(r5);
    }

    public void setItemRippleColor(@Nullable ColorStateList r5) {
        this.menuView.setItemRippleColor(r5);
    }

    public void setItemTextAppearanceActive(@StyleRes int r5) {
        this.menuView.setItemTextAppearanceActive(r5);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean r5) {
        this.menuView.setItemTextAppearanceActiveBoldEnabled(r5);
    }

    public void setItemTextAppearanceInactive(@StyleRes int r5) {
        this.menuView.setItemTextAppearanceInactive(r5);
    }

    public void setItemTextColor(@Nullable ColorStateList r5) {
        this.menuView.setItemTextColor(r5);
    }

    public void setLabelVisibilityMode(int r5) {
        if (this.menuView.getLabelVisibilityMode() == r5) goto L6;
        this.menuView.setLabelVisibilityMode(r5);
        this.presenter.updateMenuView(false);
        return;
    }

    public void setOnItemReselectedListener(@Nullable OnItemReselectedListener r5) {
        this.reselectedListener = r5;
    }

    public void setOnItemSelectedListener(@Nullable OnItemSelectedListener r5) {
        this.selectedListener = r5;
    }

    public void setSelectedItemId(@IdRes int r5) {
        MenuItem r10 = this.menu.findItem(r5);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.menu.performItemAction(r10, this.presenter, 0) == true) goto L9;
        r10.setChecked(true);
        return;
    }
}
