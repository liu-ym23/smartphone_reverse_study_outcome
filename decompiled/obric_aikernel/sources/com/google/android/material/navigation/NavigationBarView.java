package com.google.android.material.navigation;

import android.R;
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
import com.google.android.material.internal.k;
import com.google.android.material.resources.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;
import q5.d;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final NavigationBarMenu f3465c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    private final NavigationBarMenuView f3466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    private final NavigationBarPresenter f3467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private ColorStateList f3468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MenuInflater f3469j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private b f3470k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a f3471l;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        Bundle menuPresenterState;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Nullable
            public SavedState a(@NonNull Parcel r10) {
                return new SavedState(r10, null);
            }

            @NonNull
            public SavedState b(@NonNull Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            @NonNull
            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public /* bridge */ /* synthetic */ Object createFromParcel(@NonNull Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public /* bridge */ /* synthetic */ SavedState createFromParcel(@NonNull Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            if (r11 != null) goto L5;
            r11 = getClass().getClassLoader();
        L5:
            readFromParcel(r10, r11);
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        private void readFromParcel(@NonNull Parcel r10, ClassLoader r11) {
            this.menuPresenterState = r10.readBundle(r11);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeBundle(this.menuPresenterState);
        }
    }

    public interface a {
        void a(@NonNull MenuItem r10);
    }

    public interface b {
        boolean a(@NonNull MenuItem r10);
    }

    public NavigationBarView(@NonNull Context r12, @Nullable AttributeSet r13, @AttrRes int r14, @StyleRes int r15) {
        super(b6.a.c(r12, r13, r14, r15), r13, r14);
        NavigationBarPresenter r16 = new NavigationBarPresenter();
        this.f3467h = r16;
        Context r10 = getContext();
        int[] r11 = l.NavigationBarView;
        int r17 = l.NavigationBarView_itemTextAppearanceInactive;
        int r18 = l.NavigationBarView_itemTextAppearanceActive;
        TintTypedArray r19 = k.i(r10, r13, r11, r14, r15, new int[]{r17, r18});
        NavigationBarMenu r110 = new NavigationBarMenu(r10, getClass(), getMaxItemCount());
        this.f3465c = r110;
        NavigationBarMenuView r111 = d(r10);
        this.f3466g = r111;
        r16.setMenuView(r111);
        r16.setId(1);
        r111.setPresenter(r16);
        r110.addMenuPresenter(r16);
        r16.initForMenu(getContext(), r110);
        int r112 = l.NavigationBarView_itemIconTint;
        if (r19.hasValue(r112) == false) goto L5;
        ColorStateList r113 = r19.getColorStateList(r112);
    L6:
        r111.setIconTintList(r113);
        setItemIconSize(r19.getDimensionPixelSize(l.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(d.mtrl_navigation_bar_item_default_icon_size)));
        if (r19.hasValue(r17) == false) goto L10;
        setItemTextAppearanceInactive(r19.getResourceId(r17, 0));
    L10:
        if (r19.hasValue(r18) == false) goto L12;
        setItemTextAppearanceActive(r19.getResourceId(r18, 0));
    L12:
        int r114 = l.NavigationBarView_itemTextColor;
        if (r19.hasValue(r114) == false) goto L16;
        setItemTextColor(r19.getColorStateList(r114));
    L16:
        if (getBackground() != null) goto L18;
    L19:
        ViewCompat.setBackground(this, c(r10));
    L20:
        int r115 = l.NavigationBarView_itemPaddingTop;
        if (r19.hasValue(r115) == false) goto L23;
        setItemPaddingTop(r19.getDimensionPixelSize(r115, 0));
    L23:
        int r116 = l.NavigationBarView_itemPaddingBottom;
        if (r19.hasValue(r116) == false) goto L26;
        setItemPaddingBottom(r19.getDimensionPixelSize(r116, 0));
    L26:
        int r117 = l.NavigationBarView_elevation;
        if (r19.hasValue(r117) == false) goto L29;
        setElevation(r19.getDimensionPixelSize(r117, 0));
    L29:
        DrawableCompat.setTintList(getBackground().mutate(), c.b(r10, r19, l.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(r19.getInteger(l.NavigationBarView_labelVisibilityMode, -1));
        int r118 = r19.getResourceId(l.NavigationBarView_itemBackground, 0);
        if (r118 == 0) goto L32;
        r111.setItemBackgroundRes(r118);
    L33:
        int r119 = r19.getResourceId(l.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (r119 == 0) goto L36;
        setItemActiveIndicatorEnabled(true);
        TypedArray r120 = r10.obtainStyledAttributes(r119, l.NavigationBarActiveIndicator);
        setItemActiveIndicatorWidth(r120.getDimensionPixelSize(l.NavigationBarActiveIndicator_android_width, 0));
        setItemActiveIndicatorHeight(r120.getDimensionPixelSize(l.NavigationBarActiveIndicator_android_height, 0));
        setItemActiveIndicatorMarginHorizontal(r120.getDimensionPixelOffset(l.NavigationBarActiveIndicator_marginHorizontal, 0));
        setItemActiveIndicatorColor(c.a(r10, r120, l.NavigationBarActiveIndicator_android_color));
        setItemActiveIndicatorShapeAppearance(com.google.android.material.shape.l.b(r10, r120.getResourceId(l.NavigationBarActiveIndicator_shapeAppearance, 0), 0).m());
        r120.recycle();
    L36:
        int r121 = l.NavigationBarView_menu;
        if (r19.hasValue(r121) == false) goto L39;
        e(r19.getResourceId(r121, 0));
    L39:
        r19.recycle();
        addView(r111);
        r110.setCallback(new AnonymousClass1(this));
        return;
    L32:
        setItemRippleColor(c.b(r10, r19, l.NavigationBarView_itemRippleColor));
        goto L33
    L18:
        if ((getBackground() instanceof ColorDrawable) == false) goto L20;
    L5:
        r113 = r111.createDefaultColorStateList(R.attr.textColorSecondary);
        goto L6
    }

    static /* synthetic */ a a(NavigationBarView r10) {
        return r10.f3471l;
    }

    static /* synthetic */ b b(NavigationBarView r10) {
        return r10.f3470k;
    }

    @NonNull
    private MaterialShapeDrawable c(Context r10) {
        MaterialShapeDrawable r11 = new MaterialShapeDrawable();
        Drawable r12 = getBackground();
        if ((r12 instanceof ColorDrawable) == false) goto L5;
        r11.setFillColor(ColorStateList.valueOf(((ColorDrawable) r12).getColor()));
    L5:
        r11.initializeElevationOverlay(r10);
        return r11;
    }

    private MenuInflater getMenuInflater() {
        if (this.f3469j != null) goto L6;
        this.f3469j = new SupportMenuInflater(getContext());
    L6:
        return this.f3469j;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract NavigationBarMenuView d(@NonNull Context r10);

    public void e(int r10) {
        this.f3467h.setUpdateSuspended(true);
        getMenuInflater().inflate(r10, this.f3465c);
        this.f3467h.setUpdateSuspended(false);
        this.f3467h.updateMenuView(true);
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.f3466g.getItemActiveIndicatorColor();
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.f3466g.getItemActiveIndicatorHeight();
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f3466g.getItemActiveIndicatorMarginHorizontal();
    }

    @Nullable
    public com.google.android.material.shape.l getItemActiveIndicatorShapeAppearance() {
        return this.f3466g.getItemActiveIndicatorShapeAppearance();
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.f3466g.getItemActiveIndicatorWidth();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f3466g.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.f3466g.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.f3466g.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f3466g.getIconTintList();
    }

    @Px
    public int getItemPaddingBottom() {
        return this.f3466g.getItemPaddingBottom();
    }

    @Px
    public int getItemPaddingTop() {
        return this.f3466g.getItemPaddingTop();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f3468i;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.f3466g.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.f3466g.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f3466g.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f3466g.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.f3465c;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuView getMenuView() {
        return this.f3466g;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarPresenter getPresenter() {
        return this.f3467h;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.f3466g.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.f3465c.restorePresenterStates(r11.menuPresenterState);
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        Bundle r11 = new Bundle();
        r10.menuPresenterState = r11;
        this.f3465c.savePresenterStates(r11);
        return r10;
    }

    @Override // android.view.View
    public void setElevation(float r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        super.setElevation(r10);
    L5:
        h.d(this, r10);
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList r10) {
        this.f3466g.setItemActiveIndicatorColor(r10);
    }

    public void setItemActiveIndicatorEnabled(boolean r10) {
        this.f3466g.setItemActiveIndicatorEnabled(r10);
    }

    public void setItemActiveIndicatorHeight(@Px int r10) {
        this.f3466g.setItemActiveIndicatorHeight(r10);
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int r10) {
        this.f3466g.setItemActiveIndicatorMarginHorizontal(r10);
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable com.google.android.material.shape.l r10) {
        this.f3466g.setItemActiveIndicatorShapeAppearance(r10);
    }

    public void setItemActiveIndicatorWidth(@Px int r10) {
        this.f3466g.setItemActiveIndicatorWidth(r10);
    }

    public void setItemBackground(@Nullable Drawable r10) {
        this.f3466g.setItemBackground(r10);
        this.f3468i = null;
    }

    public void setItemBackgroundResource(@DrawableRes int r10) {
        this.f3466g.setItemBackgroundRes(r10);
        this.f3468i = null;
    }

    public void setItemIconSize(@Dimension int r10) {
        this.f3466g.setItemIconSize(r10);
    }

    public void setItemIconSizeRes(@DimenRes int r10) {
        setItemIconSize(getResources().getDimensionPixelSize(r10));
    }

    public void setItemIconTintList(@Nullable ColorStateList r10) {
        this.f3466g.setIconTintList(r10);
    }

    public void setItemPaddingBottom(@Px int r10) {
        this.f3466g.setItemPaddingBottom(r10);
    }

    public void setItemPaddingTop(@Px int r10) {
        this.f3466g.setItemPaddingTop(r10);
    }

    public void setItemRippleColor(@Nullable ColorStateList r10) {
        if (this.f3468i != r10) goto L9;
        if (r10 == null) goto L6;
        return;
    L6:
        if (this.f3466g.getItemBackground() == null) goto L19;
        this.f3466g.setItemBackground(null);
        return;
    L19:
        return;
    L9:
        this.f3468i = r10;
        if (r10 != null) goto L12;
        this.f3466g.setItemBackground(null);
        return;
    L12:
        ColorStateList r11 = com.google.android.material.ripple.a.a(r10);
        if (Build.VERSION.SDK_INT < 21) goto L15;
        NavigationBarMenuView r12 = this.f3466g;
        Drawable r13 = new RippleDrawable(r11, null, null);
    L16:
        r12.setItemBackground(r13);
        return;
    L15:
        GradientDrawable r14 = new GradientDrawable();
        r14.setCornerRadius(1.0E-5f);
        r13 = DrawableCompat.wrap(r14);
        DrawableCompat.setTintList(r13, r11);
        r12 = this.f3466g;
        goto L16
    }

    public void setItemTextAppearanceActive(@StyleRes int r10) {
        this.f3466g.setItemTextAppearanceActive(r10);
    }

    public void setItemTextAppearanceInactive(@StyleRes int r10) {
        this.f3466g.setItemTextAppearanceInactive(r10);
    }

    public void setItemTextColor(@Nullable ColorStateList r10) {
        this.f3466g.setItemTextColor(r10);
    }

    public void setLabelVisibilityMode(int r10) {
        if (this.f3466g.getLabelVisibilityMode() == r10) goto L6;
        this.f3466g.setLabelVisibilityMode(r10);
        this.f3467h.updateMenuView(false);
        return;
    }

    public void setOnItemReselectedListener(@Nullable a r10) {
        this.f3471l = r10;
    }

    public void setOnItemSelectedListener(@Nullable b r10) {
        this.f3470k = r10;
    }

    public void setSelectedItemId(@IdRes int r10) {
        MenuItem r11 = this.f3465c.findItem(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.f3465c.performItemAction(r11, this.f3467h, 0) == true) goto L9;
        r11.setChecked(true);
        return;
    }
}
