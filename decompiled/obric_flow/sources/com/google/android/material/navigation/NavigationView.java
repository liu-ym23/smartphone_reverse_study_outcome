package com.google.android.material.navigation;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.activity.BackEventCompat;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.inputmethod.a;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeableDelegate;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout implements MaterialBackHandler {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    private final DrawerLayout.DrawerListener backDrawerListener;
    private final MaterialBackOrchestrator backOrchestrator;
    private boolean bottomInsetScrimEnabled;

    @Px
    private int drawerLayoutCornerSize;
    private final boolean drawerLayoutCornerSizeBackAnimationEnabled;

    @Px
    private final int drawerLayoutCornerSizeBackAnimationMax;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;

    @NonNull
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final ShapeableDelegate shapeableDelegate;
    private final MaterialSideContainerBackHelper sideContainerBackHelper;
    private final int[] tmpLocation;
    private boolean topInsetScrimEnabled;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem r5);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        public Bundle menuState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Parcel r5, @Nullable ClassLoader r10) {
            super(r5, r10);
            this.menuState = r5.readBundle(r10);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeBundle(this.menuState);
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
        DEF_STYLE_RES = com.google.android.material.R.style.Widget_Design_NavigationView;
    }

    public NavigationView(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(NavigationView r5, Canvas r10) {
        r5.lambda$dispatchDraw$0(r10);
    }

    public static /* synthetic */ MaterialBackOrchestrator access$000(NavigationView r5) {
        return r5.backOrchestrator;
    }

    public static /* synthetic */ void access$100(NavigationView r5) {
        r5.maybeClearCornerSizeAnimationForDrawerLayout();
    }

    public static /* synthetic */ int[] access$200(NavigationView r5) {
        return r5.tmpLocation;
    }

    public static /* synthetic */ NavigationMenuPresenter access$300(NavigationView r5) {
        return r5.presenter;
    }

    @Nullable
    private ColorStateList createDefaultColorStateList(int r10) {
        TypedValue r5 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(r10, r5, true) == true) goto L5;
        return null;
    L5:
        ColorStateList r11 = AppCompatResources.getColorStateList(getContext(), r5.resourceId);
        if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, r5, true) == true) goto L8;
        return null;
    L8:
        int r12 = r5.data;
        int r13 = r11.getDefaultColor();
        int[] r14 = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{r14, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{r11.getColorForState(r14, r13), r12, r13});
    }

    @NonNull
    private Drawable createDefaultItemBackground(@NonNull TintTypedArray r5) {
        return createDefaultItemDrawable(r5, MaterialResources.getColorStateList(getContext(), r5, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
    }

    @NonNull
    private Drawable createDefaultItemDrawable(@NonNull TintTypedArray r10, @Nullable ColorStateList r11) {
        int r5 = r10.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0);
        int r12 = r10.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0);
        MaterialShapeDrawable r13 = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), r5, r12).build());
        r13.setFillColor(r11);
        return new InsetDrawable(r13, r10.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), r10.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), r10.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), r10.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) goto L6;
        this.menuInflater = new SupportMenuInflater(getContext());
    L6:
        return this.menuInflater;
    }

    private boolean hasShapeAppearance(@NonNull TintTypedArray r5) {
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) == false) goto L5;
    L8:
        return true;
    L5:
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay) == true) goto L8;
        return false;
    }

    private /* synthetic */ void lambda$dispatchDraw$0(Canvas r5) {
        super.dispatchDraw(r5);
    }

    private void maybeClearCornerSizeAnimationForDrawerLayout() {
        if (this.drawerLayoutCornerSizeBackAnimationEnabled == true) goto L5;
        return;
    L5:
        if (this.drawerLayoutCornerSize == 0) goto L9;
        this.drawerLayoutCornerSize = 0;
        maybeUpdateCornerSizeForDrawerLayout(getWidth(), getHeight());
        return;
    }

    private void maybeUpdateCornerSizeForDrawerLayout(@Px int r10, @Px int r11) {
        if ((getParent() instanceof DrawerLayout) == true) goto L5;
        return;
    L5:
        if ((getLayoutParams() instanceof DrawerLayout.LayoutParams) == true) goto L7;
        return;
    L7:
        if (this.drawerLayoutCornerSize > 0) goto L11;
        if (this.drawerLayoutCornerSizeBackAnimationEnabled == true) goto L11;
        return;
    L11:
        if ((getBackground() instanceof MaterialShapeDrawable) == true) goto L13;
        return;
    L13:
        if (GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams) getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this)) != 3) goto L15;
        boolean r5 = true;
    L16:
        MaterialShapeDrawable r12 = (MaterialShapeDrawable) getBackground();
        ShapeAppearanceModel.Builder r13 = r12.getShapeAppearanceModel().toBuilder().setAllCornerSizes(this.drawerLayoutCornerSize);
        if (r5 == false) goto L19;
        r13.setTopLeftCornerSize(0.0f);
        r13.setBottomLeftCornerSize(0.0f);
    L20:
        ShapeAppearanceModel r14 = r13.build();
        r12.setShapeAppearanceModel(r14);
        this.shapeableDelegate.onShapeAppearanceChanged(this, r14);
        this.shapeableDelegate.onMaskChanged(this, new RectF(0.0f, 0.0f, r10, r11));
        this.shapeableDelegate.setOffsetZeroCornerEdgeBoundsEnabled(this, true);
        return;
    L19:
        r13.setTopRightCornerSize(0.0f);
        r13.setBottomRightCornerSize(0.0f);
        goto L20
    L15:
        r5 = false;
        goto L16
    }

    private Pair<DrawerLayout, DrawerLayout.LayoutParams> requireDrawerLayoutParent() {
        ViewParent r5 = getParent();
        ViewGroup.LayoutParams r10 = getLayoutParams();
        if ((r5 instanceof DrawerLayout) == false) goto L9;
        if ((r10 instanceof DrawerLayout.LayoutParams) == false) goto L9;
        return new Pair((DrawerLayout) r5, (DrawerLayout.LayoutParams) r10);
    L9:
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new AnonymousClass3(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void addHeaderView(@NonNull View r5) {
        this.presenter.addHeaderView(r5);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void cancelBackProgress() {
        requireDrawerLayoutParent();
        this.sideContainerBackHelper.cancelBackProgress();
        maybeClearCornerSizeAnimationForDrawerLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas r5) {
        this.shapeableDelegate.maybeClip(r5, new a(this, 5));
    }

    @VisibleForTesting
    public MaterialSideContainerBackHelper getBackHelper() {
        return this.sideContainerBackHelper;
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.presenter.getDividerInsetEnd();
    }

    @Px
    public int getDividerInsetStart() {
        return this.presenter.getDividerInsetStart();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int r5) {
        return this.presenter.getHeaderView(r5);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    @Px
    public int getItemVerticalPadding() {
        return this.presenter.getItemVerticalPadding();
    }

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.presenter.getSubheaderInsetEnd();
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.presenter.getSubheaderInsetStart();
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void handleBackInvoked() {
        Pair<DrawerLayout, DrawerLayout.LayoutParams> r5 = requireDrawerLayoutParent();
        DrawerLayout r10 = (DrawerLayout) r5.first;
        BackEventCompat r11 = this.sideContainerBackHelper.onHandleBackInvoked();
        if (r11 != null) goto L5;
    L9:
        r10.closeDrawer(this);
        return;
    L5:
        if (Build.VERSION.SDK_INT < 34) goto L9;
        int r12 = ((DrawerLayout.LayoutParams) r5.second).gravity;
        Animator.AnimatorListener r13 = DrawerLayoutUtils.getScrimCloseAnimatorListener(r10, this);
        ValueAnimator.AnimatorUpdateListener r14 = DrawerLayoutUtils.getScrimCloseAnimatorUpdateListener(r10);
        this.sideContainerBackHelper.finishBackProgress(r11, r12, r13, r14);
    }

    public View inflateHeaderView(@LayoutRes int r5) {
        return this.presenter.inflateHeaderView(r5);
    }

    public void inflateMenu(int r5) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(r5, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    public boolean isBottomInsetScrimEnabled() {
        return this.bottomInsetScrimEnabled;
    }

    public boolean isTopInsetScrimEnabled() {
        return this.topInsetScrimEnabled;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        ViewParent r5 = getParent();
        if ((r5 instanceof DrawerLayout) == true) goto L5;
        return;
    L5:
        if (this.backOrchestrator.shouldListenForBackCallbacks() == false) goto L11;
        DrawerLayout r10 = (DrawerLayout) r5;
        r10.removeDrawerListener(this.backDrawerListener);
        r10.addDrawerListener(this.backDrawerListener);
        if (r10.isDrawerOpen(this) == false) goto L12;
        this.backOrchestrator.startListeningForBackCallbacksWithPriorityOverlay();
        return;
    L12:
        return;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        ViewParent r5 = getParent();
        if ((r5 instanceof DrawerLayout) == false) goto L6;
        ((DrawerLayout) r5).removeDrawerListener(this.backDrawerListener);
        return;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onInsetsChanged(@NonNull WindowInsetsCompat r5) {
        this.presenter.dispatchApplyWindowInsets(r5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        int r11 = View.MeasureSpec.getMode(r5);
        if (r11 == Integer.MIN_VALUE) goto L7;
        if (r11 != 0) goto L8;
        r5 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, BasicMeasure.EXACTLY);
    L8:
        super.onMeasure(r5, r10);
        return;
    L7:
        r5 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r5), this.maxWidth), BasicMeasure.EXACTLY);
        goto L8
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        this.menu.restorePresenterStates(r10.menuState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        Bundle r10 = new Bundle();
        r5.menuState = r10;
        this.menu.savePresenterStates(r10);
        return r5;
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        maybeUpdateCornerSizeForDrawerLayout(r5, r10);
    }

    public void removeHeaderView(@NonNull View r5) {
        this.presenter.removeHeaderView(r5);
    }

    public void setBottomInsetScrimEnabled(boolean r5) {
        this.bottomInsetScrimEnabled = r5;
    }

    public void setCheckedItem(@IdRes int r5) {
        MenuItem r10 = this.menu.findItem(r5);
        if (r10 == null) goto L6;
        this.presenter.setCheckedItem((MenuItemImpl) r10);
        return;
    }

    public void setDividerInsetEnd(@Px int r5) {
        this.presenter.setDividerInsetEnd(r5);
    }

    public void setDividerInsetStart(@Px int r5) {
        this.presenter.setDividerInsetStart(r5);
    }

    @Override // android.view.View
    public void setElevation(float r5) {
        super.setElevation(r5);
        MaterialShapeUtils.setElevation(this, r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setForceCompatClippingEnabled(boolean r5) {
        this.shapeableDelegate.setForceCompatClippingEnabled(this, r5);
    }

    public void setItemBackground(@Nullable Drawable r5) {
        this.presenter.setItemBackground(r5);
    }

    public void setItemBackgroundResource(@DrawableRes int r5) {
        setItemBackground(ContextCompat.getDrawable(getContext(), r5));
    }

    public void setItemHorizontalPadding(@Dimension int r5) {
        this.presenter.setItemHorizontalPadding(r5);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int r5) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(r5));
    }

    public void setItemIconPadding(@Dimension int r5) {
        this.presenter.setItemIconPadding(r5);
    }

    public void setItemIconPaddingResource(int r5) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(r5));
    }

    public void setItemIconSize(@Dimension int r5) {
        this.presenter.setItemIconSize(r5);
    }

    public void setItemIconTintList(@Nullable ColorStateList r5) {
        this.presenter.setItemIconTintList(r5);
    }

    public void setItemMaxLines(int r5) {
        this.presenter.setItemMaxLines(r5);
    }

    public void setItemTextAppearance(@StyleRes int r5) {
        this.presenter.setItemTextAppearance(r5);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean r5) {
        this.presenter.setItemTextAppearanceActiveBoldEnabled(r5);
    }

    public void setItemTextColor(@Nullable ColorStateList r5) {
        this.presenter.setItemTextColor(r5);
    }

    public void setItemVerticalPadding(@Px int r5) {
        this.presenter.setItemVerticalPadding(r5);
    }

    public void setItemVerticalPaddingResource(@DimenRes int r5) {
        this.presenter.setItemVerticalPadding(getResources().getDimensionPixelSize(r5));
    }

    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener r5) {
        this.listener = r5;
    }

    @Override // android.view.View
    public void setOverScrollMode(int r5) {
        super.setOverScrollMode(r5);
        NavigationMenuPresenter r10 = this.presenter;
        if (r10 == null) goto L6;
        r10.setOverScrollMode(r5);
        return;
    }

    public void setSubheaderInsetEnd(@Px int r5) {
        this.presenter.setSubheaderInsetEnd(r5);
    }

    public void setSubheaderInsetStart(@Px int r5) {
        this.presenter.setSubheaderInsetStart(r5);
    }

    public void setTopInsetScrimEnabled(boolean r5) {
        this.topInsetScrimEnabled = r5;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void startBackProgress(@NonNull BackEventCompat r5) {
        requireDrawerLayoutParent();
        this.sideContainerBackHelper.startBackProgress(r5);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void updateBackProgress(@NonNull BackEventCompat r5) {
        Pair<DrawerLayout, DrawerLayout.LayoutParams> r10 = requireDrawerLayoutParent();
        this.sideContainerBackHelper.updateBackProgress(r5, ((DrawerLayout.LayoutParams) r10.second).gravity);
        if (this.drawerLayoutCornerSizeBackAnimationEnabled == false) goto L6;
        float r11 = this.sideContainerBackHelper.interpolateProgress(r5.getProgress());
        this.drawerLayoutCornerSize = AnimationUtils.lerp(0, this.drawerLayoutCornerSizeBackAnimationMax, r11);
        maybeUpdateCornerSizeForDrawerLayout(getWidth(), getHeight());
        return;
    }

    public NavigationView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, com.google.android.material.R.attr.navigationViewStyle);
    }

    public NavigationView(@NonNull Context r17, @Nullable AttributeSet r18, int r19) {
        int r10 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r17, r18, r19, r10), r18, r19);
        NavigationMenuPresenter r11 = new NavigationMenuPresenter();
        this.presenter = r11;
        this.tmpLocation = new int[2];
        this.topInsetScrimEnabled = true;
        this.bottomInsetScrimEnabled = true;
        this.drawerLayoutCornerSize = 0;
        this.shapeableDelegate = ShapeableDelegate.create(this);
        this.sideContainerBackHelper = new MaterialSideContainerBackHelper(this);
        this.backOrchestrator = new MaterialBackOrchestrator(this);
        this.backDrawerListener = new AnonymousClass1(this);
        Context r13 = getContext();
        NavigationMenu r14 = new NavigationMenu(r13);
        this.menu = r14;
        TintTypedArray r5 = ThemeEnforcement.obtainTintedStyledAttributes(r13, r18, com.google.android.material.R.styleable.NavigationView, r19, r10, new int[0]);
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_android_background) == false) goto L5;
        ViewCompat.setBackground(this, r5.getDrawable(com.google.android.material.R.styleable.NavigationView_android_background));
    L5:
        int r12 = r5.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_drawerLayoutCornerSize, 0);
        this.drawerLayoutCornerSize = r12;
        if (r12 != 0) goto L8;
        boolean r15 = true;
    L9:
        this.drawerLayoutCornerSizeBackAnimationEnabled = r15;
        this.drawerLayoutCornerSizeBackAnimationMax = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.m3_navigation_drawer_layout_corner_size);
        Drawable r16 = getBackground();
        ColorStateList r20 = DrawableUtils.getColorStateListOrNull(r16);
        if (r16 == null) goto L12;
        if (r20 != null) goto L12;
    L17:
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_elevation) == false) goto L19;
        setElevation(r5.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_elevation, 0));
    L19:
        setFitsSystemWindows(r5.getBoolean(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = r5.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_subheaderColor) == false) goto L22;
        ColorStateList r21 = r5.getColorStateList(com.google.android.material.R.styleable.NavigationView_subheaderColor);
    L24:
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance) == false) goto L26;
        int r22 = r5.getResourceId(com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance, 0);
    L28:
        if (r22 != 0) goto L32;
        if (r21 != null) goto L32;
        r21 = createDefaultColorStateList(R.attr.textColorSecondary);
    L32:
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_itemIconTint) == false) goto L34;
        ColorStateList r23 = r5.getColorStateList(com.google.android.material.R.styleable.NavigationView_itemIconTint);
    L36:
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_itemTextAppearance) == false) goto L38;
        int r24 = r5.getResourceId(com.google.android.material.R.styleable.NavigationView_itemTextAppearance, 0);
    L39:
        boolean r25 = r5.getBoolean(com.google.android.material.R.styleable.NavigationView_itemTextAppearanceActiveBoldEnabled, true);
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_itemIconSize) == false) goto L43;
        setItemIconSize(r5.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconSize, 0));
    L43:
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_itemTextColor) == false) goto L45;
        ColorStateList r26 = r5.getColorStateList(com.google.android.material.R.styleable.NavigationView_itemTextColor);
    L46:
        if (r24 != 0) goto L49;
        if (r26 != null) goto L49;
        r26 = createDefaultColorStateList(R.attr.textColorPrimary);
    L49:
        Drawable r27 = r5.getDrawable(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (r27 != null) goto L57;
        if (hasShapeAppearance(r5) == false) goto L57;
        r27 = createDefaultItemBackground(r5);
        ColorStateList r110 = MaterialResources.getColorStateList(r13, r5, com.google.android.material.R.styleable.NavigationView_itemRippleColor);
        if (r110 == null) goto L57;
        r11.setItemForeground(new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(r110), null, createDefaultItemDrawable(r5, null)));
    L57:
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding) == false) goto L59;
        int r111 = 0;
        setItemHorizontalPadding(r5.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding, 0));
    L61:
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_itemVerticalPadding) == false) goto L63;
        setItemVerticalPadding(r5.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemVerticalPadding, r111));
    L63:
        setDividerInsetStart(r5.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_dividerInsetStart, r111));
        setDividerInsetEnd(r5.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_dividerInsetEnd, r111));
        setSubheaderInsetStart(r5.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_subheaderInsetStart, r111));
        setSubheaderInsetEnd(r5.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_subheaderInsetEnd, r111));
        setTopInsetScrimEnabled(r5.getBoolean(com.google.android.material.R.styleable.NavigationView_topInsetScrimEnabled, this.topInsetScrimEnabled));
        setBottomInsetScrimEnabled(r5.getBoolean(com.google.android.material.R.styleable.NavigationView_bottomInsetScrimEnabled, this.bottomInsetScrimEnabled));
        int r28 = r5.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconPadding, r111);
        setItemMaxLines(r5.getInt(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        r14.setCallback(new AnonymousClass2(this));
        r11.setId(1);
        r11.initForMenu(r13, r14);
        if (r22 == 0) goto L66;
        r11.setSubheaderTextAppearance(r22);
    L66:
        r11.setSubheaderColor(r21);
        r11.setItemIconTintList(r23);
        r11.setOverScrollMode(getOverScrollMode());
        if (r24 == 0) goto L69;
        r11.setItemTextAppearance(r24);
    L69:
        r11.setItemTextAppearanceActiveBoldEnabled(r25);
        r11.setItemTextColor(r26);
        r11.setItemBackground(r27);
        r11.setItemIconPadding(r28);
        r14.addMenuPresenter(r11);
        addView((View) r11.getMenuView(this));
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_menu) == false) goto L72;
        int r29 = 0;
        inflateMenu(r5.getResourceId(com.google.android.material.R.styleable.NavigationView_menu, 0));
    L74:
        if (r5.hasValue(com.google.android.material.R.styleable.NavigationView_headerLayout) == false) goto L76;
        inflateHeaderView(r5.getResourceId(com.google.android.material.R.styleable.NavigationView_headerLayout, r29));
    L76:
        r5.recycle();
        setupInsetScrimsListener();
        return;
    L72:
        r29 = 0;
        goto L74
    L59:
        r111 = 0;
        goto L61
    L45:
        r26 = null;
        goto L46
    L38:
        r24 = 0;
        goto L39
    L34:
        r23 = createDefaultColorStateList(R.attr.textColorSecondary);
        goto L36
    L26:
        r22 = 0;
        goto L28
    L22:
        r21 = null;
    L12:
        MaterialShapeDrawable r30 = new MaterialShapeDrawable(ShapeAppearanceModel.builder(r13, r18, r19, r10).build());
        if (r20 == null) goto L15;
        r30.setFillColor(r20);
    L15:
        r30.initializeElevationOverlay(r13);
        ViewCompat.setBackground(this, r30);
        goto L17
    L8:
        r15 = false;
        goto L9
    }

    public void setCheckedItem(@NonNull MenuItem r5) {
        MenuItem r10 = this.menu.findItem(r5.getItemId());
        if (r10 == null) goto L7;
        this.presenter.setCheckedItem((MenuItemImpl) r10);
        return;
    L7:
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
