package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    private static final ActiveIndicatorTransform ACTIVE_INDICATOR_LABELED_TRANSFORM = null;
    private static final ActiveIndicatorTransform ACTIVE_INDICATOR_UNLABELED_TRANSFORM = null;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int INVALID_ITEM_POSITION = -1;
    private ValueAnimator activeIndicatorAnimator;
    private int activeIndicatorDesiredHeight;
    private int activeIndicatorDesiredWidth;
    private boolean activeIndicatorEnabled;
    private int activeIndicatorLabelPadding;
    private int activeIndicatorMarginHorizontal;
    private float activeIndicatorProgress;
    private boolean activeIndicatorResizeable;
    private ActiveIndicatorTransform activeIndicatorTransform;

    @Nullable
    private final View activeIndicatorView;

    @StyleRes
    private int activeTextAppearance;

    @Nullable
    private BadgeDrawable badgeDrawable;
    private final ImageView icon;

    @Nullable
    private final FrameLayout iconContainer;

    @Nullable
    private ColorStateList iconTint;
    private boolean initialized;
    private boolean isShifting;

    @Nullable
    Drawable itemBackground;

    @Nullable
    private MenuItemImpl itemData;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private int itemPosition;
    private ColorStateList itemRippleColor;
    private final ViewGroup labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;

    @Nullable
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;

    @Nullable
    private Drawable wrappedIconDrawable;

    public static class ActiveIndicatorTransform {
        private static final float ALPHA_FRACTION = 0.2f;
        private static final float SCALE_X_HIDDEN = 0.4f;
        private static final float SCALE_X_SHOWN = 1.0f;

        private ActiveIndicatorTransform() {
        }

        public float calculateAlpha(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r10) {
            if (r10 != 0.0f) goto L5;
            float r11 = 0.8f;
        L7:
            if (r10 != 0.0f) goto L9;
            float r12 = 1.0f;
        L11:
            return AnimationUtils.lerp(0.0f, 1.0f, r11, r12, r5);
        L9:
            r12 = 0.2f;
            goto L11
        L5:
            r11 = 0.0f;
            goto L7
        }

        public float calculateScaleX(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r10) {
            return AnimationUtils.lerp(SCALE_X_HIDDEN, 1.0f, r5);
        }

        public float calculateScaleY(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r10) {
            return 1.0f;
        }

        public void updateForProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r10, @NonNull View r11) {
            r11.setScaleX(calculateScaleX(r5, r10));
            r11.setScaleY(calculateScaleY(r5, r10));
            r11.setAlpha(calculateAlpha(r5, r10));
        }

        public /* synthetic */ ActiveIndicatorTransform(AnonymousClass1 r5) {
            this();
        }
    }

    public static class ActiveIndicatorUnlabeledTransform extends ActiveIndicatorTransform {
        private ActiveIndicatorUnlabeledTransform() {
            super(null);
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.ActiveIndicatorTransform
        public float calculateScaleY(float r5, float r10) {
            return calculateScaleX(r5, r10);
        }

        public /* synthetic */ ActiveIndicatorUnlabeledTransform(AnonymousClass1 r5) {
            this();
        }
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        AnonymousClass1 r5 = null;
        ACTIVE_INDICATOR_LABELED_TRANSFORM = new ActiveIndicatorTransform(r5);
        ACTIVE_INDICATOR_UNLABELED_TRANSFORM = new ActiveIndicatorUnlabeledTransform(r5);
    }

    public NavigationBarItemView(@NonNull Context r10) {
        super(r10);
        this.initialized = false;
        this.itemPosition = -1;
        this.activeTextAppearance = 0;
        this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        this.activeIndicatorProgress = 0.0f;
        this.activeIndicatorEnabled = false;
        this.activeIndicatorDesiredWidth = 0;
        this.activeIndicatorDesiredHeight = 0;
        this.activeIndicatorResizeable = false;
        this.activeIndicatorMarginHorizontal = 0;
        LayoutInflater.from(r10).inflate(getItemLayoutResId(), this, true);
        this.iconContainer = (FrameLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_container);
        this.activeIndicatorView = findViewById(com.google.android.material.R.id.navigation_bar_item_active_indicator_view);
        ImageView r11 = (ImageView) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view);
        this.icon = r11;
        ViewGroup r5 = (ViewGroup) findViewById(com.google.android.material.R.id.navigation_bar_item_labels_group);
        this.labelGroup = r5;
        TextView r12 = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_small_label_view);
        this.smallLabel = r12;
        TextView r13 = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_large_label_view);
        this.largeLabel = r13;
        setBackgroundResource(getItemBackgroundResId());
        this.itemPaddingTop = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.itemPaddingBottom = r5.getPaddingBottom();
        this.activeIndicatorLabelPadding = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.m3_navigation_item_active_indicator_label_padding);
        ViewCompat.setImportantForAccessibility(r12, 2);
        ViewCompat.setImportantForAccessibility(r13, 2);
        setFocusable(true);
        calculateTextScaleFactors(r12.getTextSize(), r13.getTextSize());
        if (r11 == null) goto L6;
        r11.addOnLayoutChangeListener(new AnonymousClass1(this));
        return;
    }

    public static /* synthetic */ ImageView access$200(NavigationBarItemView r5) {
        return r5.icon;
    }

    public static /* synthetic */ void access$300(NavigationBarItemView r5, View r10) {
        r5.tryUpdateBadgeBounds(r10);
    }

    public static /* synthetic */ void access$400(NavigationBarItemView r5, int r10) {
        r5.updateActiveIndicatorLayoutParams(r10);
    }

    public static /* synthetic */ void access$500(NavigationBarItemView r5, float r10, float r11) {
        r5.setActiveIndicatorProgress(r10, r11);
    }

    private void calculateTextScaleFactors(float r5, float r10) {
        this.shiftAmount = r5 - r10;
        this.scaleUpFactor = (r10 * 1.0f) / r5;
        this.scaleDownFactor = (r5 * 1.0f) / r10;
    }

    private static Drawable createItemBackgroundCompat(@NonNull ColorStateList r5) {
        return new RippleDrawable(RippleUtils.convertToRippleDrawableColor(r5), null, null);
    }

    @Nullable
    private FrameLayout getCustomParentForBadge(View r5) {
        ImageView r10 = this.icon;
        if (r5 == r10) goto L5;
        return null;
    L5:
        if (BadgeUtils.USE_COMPAT_PARENT == true) goto L7;
        return null;
    L7:
        return (FrameLayout) r10.getParent();
    }

    private View getIconOrContainer() {
        FrameLayout r5 = this.iconContainer;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return this.icon;
    }

    private int getItemVisiblePosition() {
        ViewGroup r5 = (ViewGroup) getParent();
        int r10 = r5.indexOfChild(this);
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L10;
        View r13 = r5.getChildAt(r11);
        if ((r13 instanceof NavigationBarItemView) == false) goto L9;
        if (r13.getVisibility() != 0) goto L9;
        r12 = r12 + 1;
    L9:
        r11 = r11 + 1;
        goto L3
    L10:
        return r12;
    }

    private int getSuggestedIconHeight() {
        int r5 = ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin;
        return getIconOrContainer().getMeasuredHeight() + r5;
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable r5 = this.badgeDrawable;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        int r12 = Math.max(r10, r11.leftMargin);
        int r13 = this.icon.getMeasuredWidth() + r12;
        return Math.max(r10, r11.rightMargin) + r13;
    L5:
        r10 = r5.getMinimumWidth() - this.badgeDrawable.getHorizontalOffset();
        goto L6
    }

    private boolean hasBadge() {
        if (this.badgeDrawable == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isActiveIndicatorResizeableAndUnlabeled() {
        if (this.activeIndicatorResizeable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.labelVisibilityMode != 2) goto L7;
        return true;
    }

    private void maybeAnimateActiveIndicatorToProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) final float r5) {
        if (this.activeIndicatorEnabled == true) goto L5;
    L14:
        setActiveIndicatorProgress(r5, r5);
        return;
    L5:
        if (this.initialized == false) goto L14;
        if (ViewCompat.isAttachedToWindow(this) == false) goto L14;
        ValueAnimator r10 = this.activeIndicatorAnimator;
        if (r10 == null) goto L12;
        r10.cancel();
        this.activeIndicatorAnimator = null;
    L12:
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{this.activeIndicatorProgress, r5});
        this.activeIndicatorAnimator = r11;
        r11.addUpdateListener(new AnonymousClass3(this, r5));
        this.activeIndicatorAnimator.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), com.google.android.material.R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        this.activeIndicatorAnimator.setDuration(MotionUtils.resolveThemeDuration(getContext(), com.google.android.material.R.attr.motionDurationLong2, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
        this.activeIndicatorAnimator.start();
    }

    private void refreshChecked() {
        MenuItemImpl r5 = this.itemData;
        if (r5 == null) goto L6;
        setChecked(r5.isChecked());
        return;
    }

    private void refreshItemBackground() {
        Drawable r5 = this.itemBackground;
        RippleDrawable r10 = null;
        boolean r11 = true;
        if (this.itemRippleColor == null) goto L14;
        Drawable r12 = getActiveIndicatorDrawable();
        if (this.activeIndicatorEnabled == true) goto L7;
    L12:
        if (r5 != null) goto L14;
        r5 = createItemBackgroundCompat(this.itemRippleColor);
        goto L14
    L7:
        if (getActiveIndicatorDrawable() == null) goto L12;
        if (this.iconContainer == null) goto L12;
        if (r12 == null) goto L12;
        r10 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.itemRippleColor), null, r12);
        r11 = false;
    L14:
        FrameLayout r13 = this.iconContainer;
        if (r13 == null) goto L17;
        r13.setPadding(0, 0, 0, 0);
        this.iconContainer.setForeground(r10);
    L17:
        ViewCompat.setBackground(this, r5);
        setDefaultFocusHighlightEnabled(r11);
    }

    private void setActiveIndicatorProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5, float r10) {
        View r11 = this.activeIndicatorView;
        if (r11 == null) goto L5;
        this.activeIndicatorTransform.updateForProgress(r5, r10, r11);
    L5:
        this.activeIndicatorProgress = r5;
    }

    private static void setTextAppearanceWithoutFontScaling(TextView r5, @StyleRes int r10) {
        TextViewCompat.setTextAppearance(r5, r10);
        int r11 = MaterialResources.getUnscaledTextSize(r5.getContext(), r10, 0);
        if (r11 == 0) goto L6;
        r5.setTextSize(0, r11);
        return;
    }

    private static void setViewScaleValues(@NonNull View r5, float r10, float r11, int r12) {
        r5.setScaleX(r10);
        r5.setScaleY(r11);
        r5.setVisibility(r12);
    }

    private static void setViewTopMarginAndGravity(@NonNull View r5, int r10, int r11) {
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r5.getLayoutParams();
        r12.topMargin = r10;
        r12.bottomMargin = r10;
        r12.gravity = r11;
        r5.setLayoutParams(r12);
    }

    private void tryAttachBadgeToAnchor(@Nullable View r5) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L8;
        setClipChildren(false);
        setClipToPadding(false);
        BadgeUtils.attachBadgeDrawable(this.badgeDrawable, r5, getCustomParentForBadge(r5));
        return;
    }

    private void tryRemoveBadgeFromAnchor(@Nullable View r5) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L7;
        setClipChildren(true);
        setClipToPadding(true);
        BadgeUtils.detachBadgeDrawable(this.badgeDrawable, r5);
    L7:
        this.badgeDrawable = null;
    }

    private void tryUpdateBadgeBounds(View r5) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, r5, getCustomParentForBadge(r5));
    }

    private void updateActiveIndicatorLayoutParams(int r5) {
        if (this.activeIndicatorView == null) goto L12;
        if (r5 <= 0) goto L13;
        int r10 = Math.min(this.activeIndicatorDesiredWidth, r5 - (this.activeIndicatorMarginHorizontal * 2));
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) this.activeIndicatorView.getLayoutParams();
        if (isActiveIndicatorResizeableAndUnlabeled() == false) goto L9;
        int r12 = r10;
    L10:
        r11.height = r12;
        r11.width = r10;
        this.activeIndicatorView.setLayoutParams(r11);
        return;
    L9:
        r12 = this.activeIndicatorDesiredHeight;
        goto L10
    L13:
        return;
    }

    private void updateActiveIndicatorTransform() {
        if (isActiveIndicatorResizeableAndUnlabeled() == false) goto L5;
        this.activeIndicatorTransform = ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
        return;
    L5:
        this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
    }

    private static void updateViewPaddingBottom(@NonNull View r5, int r10) {
        r5.setPadding(r5.getPaddingLeft(), r5.getPaddingTop(), r5.getPaddingRight(), r10);
    }

    public void clear() {
        removeBadge();
        this.itemData = null;
        this.activeIndicatorProgress = 0.0f;
        this.initialized = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r5) {
        FrameLayout r10 = this.iconContainer;
        if (r10 == null) goto L8;
        if (this.activeIndicatorEnabled == false) goto L8;
        r10.dispatchTouchEvent(r5);
    L8:
        return super.dispatchTouchEvent(r5);
    }

    @Nullable
    public Drawable getActiveIndicatorDrawable() {
        View r5 = this.activeIndicatorView;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getBackground();
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    @DrawableRes
    public int getItemBackgroundResId() {
        return com.google.android.material.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    @Nullable
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    @DimenRes
    public int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    @LayoutRes
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.itemPosition;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        int r10 = getSuggestedIconHeight();
        if (this.labelGroup.getVisibility() != 0) goto L5;
        int r11 = this.activeIndicatorLabelPadding;
    L6:
        int r12 = (r10 + r11) + r5.topMargin;
        return (this.labelGroup.getMeasuredHeight() + r12) + r5.bottomMargin;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        int r10 = r5.leftMargin;
        int r11 = (this.labelGroup.getMeasuredWidth() + r10) + r5.rightMargin;
        return Math.max(getSuggestedIconWidth(), r11);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl r5, int r10) {
        this.itemData = r5;
        setCheckable(r5.isCheckable());
        setChecked(r5.isChecked());
        setEnabled(r5.isEnabled());
        setIcon(r5.getIcon());
        setTitle(r5.getTitle());
        setId(r5.getItemId());
        if (TextUtils.isEmpty(r5.getContentDescription()) == true) goto L6;
        setContentDescription(r5.getContentDescription());
    L6:
        if (TextUtils.isEmpty(r5.getTooltipText()) == true) goto L8;
        CharSequence r11 = r5.getTooltipText();
    L9:
        TooltipCompat.setTooltipText(this, r11);
        if (r5.isVisible() == false) goto L12;
        int r12 = 0;
    L13:
        setVisibility(r12);
        this.initialized = true;
        return;
    L12:
        r12 = 8;
        goto L13
    L8:
        r11 = r5.getTitle();
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
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

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        BadgeDrawable r5 = this.badgeDrawable;
        if (r5 != null) goto L5;
    L10:
        AccessibilityNodeInfoCompat r11 = AccessibilityNodeInfoCompat.wrap(r10);
        r11.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected() == false) goto L13;
        r11.setClickable(false);
        r11.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
    L13:
        r11.setRoleDescription(getResources().getString(com.google.android.material.R.string.item_view_role_description));
        return;
    L5:
        if (r5.isVisible() == false) goto L10;
        CharSequence r12 = this.itemData.getTitle();
        if (TextUtils.isEmpty(this.itemData.getContentDescription()) == true) goto L9;
        r12 = this.itemData.getContentDescription();
    L9:
        r10.setContentDescription(r12 + ", " + this.badgeDrawable.getContentDescription());
        goto L10
    }

    @Override // android.view.View
    public void onSizeChanged(final int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        post(new AnonymousClass2(this, r5));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setActiveIndicatorDrawable(@Nullable Drawable r5) {
        View r10 = this.activeIndicatorView;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setBackgroundDrawable(r5);
        refreshItemBackground();
    }

    public void setActiveIndicatorEnabled(boolean r5) {
        this.activeIndicatorEnabled = r5;
        refreshItemBackground();
        View r10 = this.activeIndicatorView;
        if (r10 == null) goto L9;
        if (r5 == false) goto L6;
        int r11 = 0;
    L7:
        r10.setVisibility(r11);
        requestLayout();
        return;
    L6:
        r11 = 8;
        goto L7
    }

    public void setActiveIndicatorHeight(int r5) {
        this.activeIndicatorDesiredHeight = r5;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int r5) {
        if (this.activeIndicatorLabelPadding == r5) goto L6;
        this.activeIndicatorLabelPadding = r5;
        refreshChecked();
        return;
    }

    public void setActiveIndicatorMarginHorizontal(@Px int r5) {
        this.activeIndicatorMarginHorizontal = r5;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean r5) {
        this.activeIndicatorResizeable = r5;
    }

    public void setActiveIndicatorWidth(int r5) {
        this.activeIndicatorDesiredWidth = r5;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setBadge(@NonNull BadgeDrawable r5) {
        if (this.badgeDrawable != r5) goto L6;
        return;
    L6:
        if (hasBadge() == true) goto L8;
    L10:
        this.badgeDrawable = r5;
        ImageView r10 = this.icon;
        if (r10 == null) goto L14;
        tryAttachBadgeToAnchor(r10);
        return;
    L14:
        return;
    L8:
        if (this.icon == null) goto L10;
        Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
        tryRemoveBadgeFromAnchor(this.icon);
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r5) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r10) {
        TextView r5 = this.largeLabel;
        r5.setPivotX(r5.getWidth() / 2);
        TextView r11 = this.largeLabel;
        r11.setPivotY(r11.getBaseline());
        TextView r12 = this.smallLabel;
        r12.setPivotX(r12.getWidth() / 2);
        TextView r13 = this.smallLabel;
        r13.setPivotY(r13.getBaseline());
        if (r10 == false) goto L5;
        float r14 = 1.0f;
    L6:
        maybeAnimateActiveIndicatorToProgress(r14);
        int r15 = this.labelVisibilityMode;
        if (r15 == (-1)) goto L23;
        if (r15 != 0) goto L10;
        if (r10 == false) goto L20;
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        this.largeLabel.setVisibility(0);
    L21:
        this.smallLabel.setVisibility(4);
    L32:
        refreshDrawableState();
        setSelected(r10);
        return;
    L20:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.largeLabel.setVisibility(4);
        goto L21
    L10:
        if (r15 == 1) goto L14;
        if (r15 != 2) goto L32;
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
        this.largeLabel.setVisibility(8);
        this.smallLabel.setVisibility(8);
        goto L32
    L14:
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        if (r10 == false) goto L17;
        setViewTopMarginAndGravity(getIconOrContainer(), (int) (this.itemPaddingTop + this.shiftAmount), 49);
        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r16 = this.smallLabel;
        float r17 = this.scaleUpFactor;
        setViewScaleValues(r16, r17, r17, 4);
        goto L32
    L17:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        TextView r18 = this.largeLabel;
        float r19 = this.scaleDownFactor;
        setViewScaleValues(r18, r19, r19, 4);
        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L32
    L23:
        if (this.isShifting == false) goto L28;
        if (r10 == false) goto L26;
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        this.largeLabel.setVisibility(0);
    L27:
        this.smallLabel.setVisibility(4);
        goto L32
    L26:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.largeLabel.setVisibility(4);
        goto L27
    L28:
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        if (r10 == false) goto L31;
        setViewTopMarginAndGravity(getIconOrContainer(), (int) (this.itemPaddingTop + this.shiftAmount), 49);
        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r20 = this.smallLabel;
        float r21 = this.scaleUpFactor;
        setViewScaleValues(r20, r21, r21, 4);
        goto L32
    L31:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        TextView r22 = this.largeLabel;
        float r23 = this.scaleDownFactor;
        setViewScaleValues(r22, r23, r23, 4);
        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L32
    L5:
        r14 = 0.0f;
        goto L6
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        this.smallLabel.setEnabled(r5);
        this.largeLabel.setEnabled(r5);
        this.icon.setEnabled(r5);
        if (r5 == false) goto L5;
        ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        return;
    L5:
        ViewCompat.setPointerIcon(this, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable r5) {
        if (r5 != this.originalIconDrawable) goto L5;
        return;
    L5:
        this.originalIconDrawable = r5;
        if (r5 == null) goto L14;
        Drawable.ConstantState r10 = r5.getConstantState();
        if (r10 == null) goto L11;
        r5 = r10.newDrawable();
    L11:
        r5 = DrawableCompat.wrap(r5).mutate();
        this.wrappedIconDrawable = r5;
        ColorStateList r11 = this.iconTint;
        if (r11 == null) goto L14;
        DrawableCompat.setTintList(r5, r11);
    L14:
        this.icon.setImageDrawable(r5);
    }

    public void setIconSize(int r5) {
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        r10.width = r5;
        r10.height = r5;
        this.icon.setLayoutParams(r10);
    }

    public void setIconTintList(@Nullable ColorStateList r5) {
        this.iconTint = r5;
        if (this.itemData == null) goto L8;
        Drawable r10 = this.wrappedIconDrawable;
        if (r10 == null) goto L9;
        DrawableCompat.setTintList(r10, r5);
        this.wrappedIconDrawable.invalidateSelf();
        return;
    L9:
        return;
    }

    public void setItemBackground(int r5) {
        if (r5 != 0) goto L4;
        Drawable r10 = null;
    L5:
        setItemBackground(r10);
        return;
    L4:
        r10 = ContextCompat.getDrawable(getContext(), r5);
        goto L5
    }

    public void setItemPaddingBottom(int r5) {
        if (this.itemPaddingBottom == r5) goto L6;
        this.itemPaddingBottom = r5;
        refreshChecked();
        return;
    }

    public void setItemPaddingTop(int r5) {
        if (this.itemPaddingTop == r5) goto L6;
        this.itemPaddingTop = r5;
        refreshChecked();
        return;
    }

    public void setItemPosition(int r5) {
        this.itemPosition = r5;
    }

    public void setItemRippleColor(@Nullable ColorStateList r5) {
        this.itemRippleColor = r5;
        refreshItemBackground();
    }

    public void setLabelVisibilityMode(int r5) {
        if (this.labelVisibilityMode == r5) goto L6;
        this.labelVisibilityMode = r5;
        updateActiveIndicatorTransform();
        updateActiveIndicatorLayoutParams(getWidth());
        refreshChecked();
        return;
    }

    public void setShifting(boolean r5) {
        if (this.isShifting == r5) goto L6;
        this.isShifting = r5;
        refreshChecked();
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r5, char r10) {
    }

    public void setTextAppearanceActive(@StyleRes int r5) {
        this.activeTextAppearance = r5;
        setTextAppearanceWithoutFontScaling(this.largeLabel, r5);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean r5) {
        setTextAppearanceActive(this.activeTextAppearance);
        TextView r10 = this.largeLabel;
        r10.setTypeface(r10.getTypeface(), r5 ? 1 : 0);
    }

    public void setTextAppearanceInactive(@StyleRes int r5) {
        setTextAppearanceWithoutFontScaling(this.smallLabel, r5);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList r5) {
        if (r5 == null) goto L5;
        this.smallLabel.setTextColor(r5);
        this.largeLabel.setTextColor(r5);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(@Nullable CharSequence r5) {
        this.smallLabel.setText(r5);
        this.largeLabel.setText(r5);
        MenuItemImpl r10 = this.itemData;
        if (r10 != null) goto L5;
    L6:
        setContentDescription(r5);
    L7:
        MenuItemImpl r11 = this.itemData;
        if (r11 != null) goto L10;
    L13:
        TooltipCompat.setTooltipText(this, r5);
        return;
    L10:
        if (TextUtils.isEmpty(r11.getTooltipText()) == true) goto L13;
        r5 = this.itemData.getTooltipText();
        goto L13
    L5:
        if (TextUtils.isEmpty(r10.getContentDescription()) == false) goto L7;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public void setItemBackground(@Nullable Drawable r5) {
        if (r5 != null) goto L4;
    L6:
        this.itemBackground = r5;
        refreshItemBackground();
        return;
    L4:
        if (r5.getConstantState() == null) goto L6;
        r5 = r5.getConstantState().newDrawable().mutate();
        goto L6
    }
}
