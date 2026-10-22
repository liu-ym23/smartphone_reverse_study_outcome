package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
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
import q5.f;
import q5.g;
import q5.j;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    private static final d ACTIVE_INDICATOR_LABELED_TRANSFORM = null;
    private static final d ACTIVE_INDICATOR_UNLABELED_TRANSFORM = null;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int INVALID_ITEM_POSITION = -1;
    private ValueAnimator activeIndicatorAnimator;
    private int activeIndicatorDesiredHeight;
    private int activeIndicatorDesiredWidth;
    private boolean activeIndicatorEnabled;
    private int activeIndicatorMarginHorizontal;
    private float activeIndicatorProgress;
    private boolean activeIndicatorResizeable;
    private d activeIndicatorTransform;

    @Nullable
    private final View activeIndicatorView;

    @Nullable
    private com.google.android.material.badge.a badgeDrawable;
    private final ImageView icon;

    @Nullable
    private final FrameLayout iconContainer;

    @Nullable
    private ColorStateList iconTint;
    private boolean initialized;
    private boolean isShifting;

    @Nullable
    private MenuItemImpl itemData;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private int itemPosition;
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

    class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavigationBarItemView f3459a;

        a(NavigationBarItemView r10) {
            this.f3459a = r10;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
            if (NavigationBarItemView.access$200(this.f3459a).getVisibility() != 0) goto L6;
            NavigationBarItemView r19 = this.f3459a;
            NavigationBarItemView.access$300(r19, NavigationBarItemView.access$200(r19));
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3460c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ NavigationBarItemView f3461g;

        b(NavigationBarItemView r10, int r11) {
            this.f3461g = r10;
            this.f3460c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            NavigationBarItemView.access$400(this.f3461g, this.f3460c);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f3462c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ NavigationBarItemView f3463g;

        c(NavigationBarItemView r10, float r11) {
            this.f3463g = r10;
            this.f3462c = r11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            NavigationBarItemView.access$500(this.f3463g, r11, this.f3462c);
        }
    }

    private static class d {
        private d() {
        }

        /* synthetic */ d(a r10) {
            this();
        }

        protected float a(@FloatRange(from = 0.0d, to = 1.0d) float r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
            if (r11 != 0.0f) goto L5;
            float r12 = 0.8f;
        L7:
            if (r11 != 0.0f) goto L9;
            float r13 = 1.0f;
        L11:
            return r5.a.b(0.0f, 1.0f, r12, r13, r10);
        L9:
            r13 = 0.2f;
            goto L11
        L5:
            r12 = 0.0f;
            goto L7
        }

        protected float b(@FloatRange(from = 0.0d, to = 1.0d) float r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
            return r5.a.a(0.4f, 1.0f, r10);
        }

        protected float c(@FloatRange(from = 0.0d, to = 1.0d) float r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
            return 1.0f;
        }

        public void d(@FloatRange(from = 0.0d, to = 1.0d) float r10, @FloatRange(from = 0.0d, to = 1.0d) float r11, @NonNull View r12) {
            r12.setScaleX(b(r10, r11));
            r12.setScaleY(c(r10, r11));
            r12.setAlpha(a(r10, r11));
        }
    }

    private static class e extends d {
        private e() {
            super(null);
        }

        /* synthetic */ e(a r10) {
            this();
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.d
        protected float c(float r10, float r11) {
            return b(r10, r11);
        }
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        a r10 = null;
        ACTIVE_INDICATOR_LABELED_TRANSFORM = new d(r10);
        ACTIVE_INDICATOR_UNLABELED_TRANSFORM = new e(r10);
    }

    public NavigationBarItemView(@NonNull Context r10) {
        super(r10);
        this.initialized = false;
        this.itemPosition = -1;
        this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        this.activeIndicatorProgress = 0.0f;
        this.activeIndicatorEnabled = false;
        this.activeIndicatorDesiredWidth = 0;
        this.activeIndicatorDesiredHeight = 0;
        this.activeIndicatorResizeable = false;
        this.activeIndicatorMarginHorizontal = 0;
        LayoutInflater.from(r10).inflate(getItemLayoutResId(), this, true);
        this.iconContainer = (FrameLayout) findViewById(f.navigation_bar_item_icon_container);
        this.activeIndicatorView = findViewById(f.navigation_bar_item_active_indicator_view);
        ImageView r11 = (ImageView) findViewById(f.navigation_bar_item_icon_view);
        this.icon = r11;
        ViewGroup r12 = (ViewGroup) findViewById(f.navigation_bar_item_labels_group);
        this.labelGroup = r12;
        TextView r13 = (TextView) findViewById(f.navigation_bar_item_small_label_view);
        this.smallLabel = r13;
        TextView r14 = (TextView) findViewById(f.navigation_bar_item_large_label_view);
        this.largeLabel = r14;
        setBackgroundResource(getItemBackgroundResId());
        this.itemPaddingTop = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.itemPaddingBottom = r12.getPaddingBottom();
        ViewCompat.setImportantForAccessibility(r13, 2);
        ViewCompat.setImportantForAccessibility(r14, 2);
        setFocusable(true);
        calculateTextScaleFactors(r13.getTextSize(), r14.getTextSize());
        if (r11 == null) goto L6;
        r11.addOnLayoutChangeListener(new a(this));
        return;
    }

    static /* synthetic */ ImageView access$200(NavigationBarItemView r10) {
        return r10.icon;
    }

    static /* synthetic */ void access$300(NavigationBarItemView r10, View r11) {
        r10.tryUpdateBadgeBounds(r11);
    }

    static /* synthetic */ void access$400(NavigationBarItemView r10, int r11) {
        r10.updateActiveIndicatorLayoutParams(r11);
    }

    static /* synthetic */ void access$500(NavigationBarItemView r10, float r11, float r12) {
        r10.setActiveIndicatorProgress(r11, r12);
    }

    private void calculateTextScaleFactors(float r10, float r11) {
        this.shiftAmount = r10 - r11;
        this.scaleUpFactor = (r11 * 1.0f) / r10;
        this.scaleDownFactor = (r10 * 1.0f) / r11;
    }

    @Nullable
    private FrameLayout getCustomParentForBadge(View r10) {
        ImageView r11 = this.icon;
        if (r10 == r11) goto L5;
        return null;
    L5:
        if (com.google.android.material.badge.b.f3015a == true) goto L7;
        return null;
    L7:
        return (FrameLayout) r11.getParent();
    }

    private View getIconOrContainer() {
        FrameLayout r10 = this.iconContainer;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.icon;
    }

    private int getItemVisiblePosition() {
        ViewGroup r10 = (ViewGroup) getParent();
        int r11 = r10.indexOfChild(this);
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L10;
        View r14 = r10.getChildAt(r12);
        if ((r14 instanceof NavigationBarItemView) == false) goto L9;
        if (r14.getVisibility() != 0) goto L9;
        r13 = r13 + 1;
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        return r13;
    }

    private int getSuggestedIconHeight() {
        com.google.android.material.badge.a r10 = this.badgeDrawable;
        if (r10 == null) goto L5;
        int r11 = r10.getMinimumHeight() / 2;
    L7:
        return (Math.max(r11, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + this.icon.getMeasuredWidth()) + r11;
    L5:
        r11 = 0;
        goto L7
    }

    private int getSuggestedIconWidth() {
        com.google.android.material.badge.a r10 = this.badgeDrawable;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return (Math.max(r11, r12.leftMargin) + this.icon.getMeasuredWidth()) + Math.max(r11, r12.rightMargin);
    L5:
        r11 = r10.getMinimumWidth() - this.badgeDrawable.h();
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

    private void maybeAnimateActiveIndicatorToProgress(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        if (this.activeIndicatorEnabled == true) goto L5;
    L14:
        setActiveIndicatorProgress(r10, r10);
        return;
    L5:
        if (this.initialized == false) goto L14;
        if (ViewCompat.isAttachedToWindow(this) == false) goto L14;
        ValueAnimator r11 = this.activeIndicatorAnimator;
        if (r11 == null) goto L12;
        r11.cancel();
        this.activeIndicatorAnimator = null;
    L12:
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{this.activeIndicatorProgress, r10});
        this.activeIndicatorAnimator = r12;
        r12.addUpdateListener(new c(this, r10));
        this.activeIndicatorAnimator.setInterpolator(z5.a.e(getContext(), q5.b.motionEasingStandard, r5.a.f12674b));
        this.activeIndicatorAnimator.setDuration(z5.a.d(getContext(), q5.b.motionDurationLong1, getResources().getInteger(g.material_motion_duration_long_1)));
        this.activeIndicatorAnimator.start();
    }

    private void refreshChecked() {
        MenuItemImpl r10 = this.itemData;
        if (r10 == null) goto L6;
        setChecked(r10.isChecked());
        return;
    }

    private void setActiveIndicatorProgress(@FloatRange(from = 0.0d, to = 1.0d) float r10, float r11) {
        View r12 = this.activeIndicatorView;
        if (r12 == null) goto L5;
        this.activeIndicatorTransform.d(r10, r11, r12);
    L5:
        this.activeIndicatorProgress = r10;
    }

    private static void setTextAppearanceWithoutFontScaling(TextView r10, @StyleRes int r11) {
        TextViewCompat.setTextAppearance(r10, r11);
        int r12 = com.google.android.material.resources.c.h(r10.getContext(), r11, 0);
        if (r12 == 0) goto L6;
        r10.setTextSize(0, r12);
        return;
    }

    private static void setViewScaleValues(@NonNull View r10, float r11, float r12, int r13) {
        r10.setScaleX(r11);
        r10.setScaleY(r12);
        r10.setVisibility(r13);
    }

    private static void setViewTopMarginAndGravity(@NonNull View r10, int r11, int r12) {
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r10.getLayoutParams();
        r13.topMargin = r11;
        r13.bottomMargin = r11;
        r13.gravity = r12;
        r10.setLayoutParams(r13);
    }

    private void tryAttachBadgeToAnchor(@Nullable View r10) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        if (r10 == null) goto L8;
        setClipChildren(false);
        setClipToPadding(false);
        com.google.android.material.badge.b.a(this.badgeDrawable, r10, getCustomParentForBadge(r10));
        return;
    }

    private void tryRemoveBadgeFromAnchor(@Nullable View r10) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        if (r10 == null) goto L7;
        setClipChildren(true);
        setClipToPadding(true);
        com.google.android.material.badge.b.d(this.badgeDrawable, r10);
    L7:
        this.badgeDrawable = null;
    }

    private void tryUpdateBadgeBounds(View r10) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        com.google.android.material.badge.b.e(this.badgeDrawable, r10, getCustomParentForBadge(r10));
    }

    private void updateActiveIndicatorLayoutParams(int r10) {
        if (this.activeIndicatorView != null) goto L5;
        return;
    L5:
        int r11 = Math.min(this.activeIndicatorDesiredWidth, r10 - (this.activeIndicatorMarginHorizontal * 2));
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) this.activeIndicatorView.getLayoutParams();
        if (isActiveIndicatorResizeableAndUnlabeled() == false) goto L8;
        int r13 = r11;
    L9:
        r12.height = r13;
        r12.width = r11;
        this.activeIndicatorView.setLayoutParams(r12);
        return;
    L8:
        r13 = this.activeIndicatorDesiredHeight;
        goto L9
    }

    private void updateActiveIndicatorTransform() {
        if (isActiveIndicatorResizeableAndUnlabeled() == false) goto L5;
        d r10 = ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
    L6:
        this.activeIndicatorTransform = r10;
        return;
    L5:
        r10 = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        goto L6
    }

    private static void updateViewPaddingBottom(@NonNull View r10, int r11) {
        r10.setPadding(r10.getPaddingLeft(), r10.getPaddingTop(), r10.getPaddingRight(), r11);
    }

    void clear() {
        removeBadge();
        this.itemData = null;
        this.activeIndicatorProgress = 0.0f;
        this.initialized = false;
    }

    @Nullable
    public Drawable getActiveIndicatorDrawable() {
        View r10 = this.activeIndicatorView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getBackground();
    }

    @Nullable
    public com.google.android.material.badge.a getBadge() {
        return this.badgeDrawable;
    }

    @DrawableRes
    protected int getItemBackgroundResId() {
        return q5.e.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    @Nullable
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    @DimenRes
    protected int getItemDefaultMarginResId() {
        return q5.d.mtrl_navigation_bar_item_default_margin;
    }

    @LayoutRes
    protected abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.itemPosition;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return ((getSuggestedIconHeight() + r10.topMargin) + this.labelGroup.getMeasuredHeight()) + r10.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        int r11 = (r10.leftMargin + this.labelGroup.getMeasuredWidth()) + r10.rightMargin;
        return Math.max(getSuggestedIconWidth(), r11);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl r10, int r11) {
        this.itemData = r10;
        setCheckable(r10.isCheckable());
        setChecked(r10.isChecked());
        setEnabled(r10.isEnabled());
        setIcon(r10.getIcon());
        setTitle(r10.getTitle());
        setId(r10.getItemId());
        if (TextUtils.isEmpty(r10.getContentDescription()) == true) goto L6;
        setContentDescription(r10.getContentDescription());
    L6:
        if (TextUtils.isEmpty(r10.getTooltipText()) == true) goto L8;
        CharSequence r12 = r10.getTooltipText();
    L9:
        int r13 = Build.VERSION.SDK_INT;
        if (r13 >= 21) goto L12;
    L13:
        TooltipCompat.setTooltipText(this, r12);
    L15:
        if (r10.isVisible() == false) goto L17;
        int r14 = 0;
    L18:
        setVisibility(r14);
        this.initialized = true;
        return;
    L17:
        r14 = 8;
        goto L18
    L12:
        if (r13 <= 23) goto L15;
    L8:
        r12 = r10.getTitle();
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    public int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 1);
        MenuItemImpl r12 = this.itemData;
        if (r12 != null) goto L5;
    L9:
        return r11;
    L5:
        if (r12.isCheckable() == false) goto L9;
        if (this.itemData.isChecked() == false) goto L9;
        FrameLayout.mergeDrawableStates(r11, CHECKED_STATE_SET);
        goto L9
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        com.google.android.material.badge.a r11 = this.badgeDrawable;
        if (r11 != null) goto L5;
    L10:
        AccessibilityNodeInfoCompat r12 = AccessibilityNodeInfoCompat.wrap(r10);
        r12.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected() == false) goto L13;
        r12.setClickable(false);
        r12.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
    L13:
        r12.setRoleDescription(getResources().getString(j.item_view_role_description));
        return;
    L5:
        if (r11.isVisible() == false) goto L10;
        CharSequence r13 = this.itemData.getTitle();
        if (TextUtils.isEmpty(this.itemData.getContentDescription()) == true) goto L9;
        r13 = this.itemData.getContentDescription();
    L9:
        r10.setContentDescription(r13 + ", " + this.badgeDrawable.f());
        goto L10
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        post(new b(this, r10));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setActiveIndicatorDrawable(@Nullable Drawable r10) {
        View r11 = this.activeIndicatorView;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setBackgroundDrawable(r10);
    }

    public void setActiveIndicatorEnabled(boolean r10) {
        this.activeIndicatorEnabled = r10;
        View r11 = this.activeIndicatorView;
        if (r11 == null) goto L9;
        if (r10 == false) goto L6;
        int r12 = 0;
    L7:
        r11.setVisibility(r12);
        requestLayout();
        return;
    L6:
        r12 = 8;
        goto L7
    }

    public void setActiveIndicatorHeight(int r10) {
        this.activeIndicatorDesiredHeight = r10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(@Px int r10) {
        this.activeIndicatorMarginHorizontal = r10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean r10) {
        this.activeIndicatorResizeable = r10;
    }

    public void setActiveIndicatorWidth(int r10) {
        this.activeIndicatorDesiredWidth = r10;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    void setBadge(@NonNull com.google.android.material.badge.a r10) {
        if (this.badgeDrawable != r10) goto L6;
        return;
    L6:
        if (hasBadge() == true) goto L8;
    L10:
        this.badgeDrawable = r10;
        ImageView r11 = this.icon;
        if (r11 == null) goto L14;
        tryAttachBadgeToAnchor(r11);
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
    public void setCheckable(boolean r10) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r10) {
        TextView r11 = this.largeLabel;
        r11.setPivotX(r11.getWidth() / 2);
        TextView r12 = this.largeLabel;
        r12.setPivotY(r12.getBaseline());
        TextView r13 = this.smallLabel;
        r13.setPivotX(r13.getWidth() / 2);
        TextView r14 = this.smallLabel;
        r14.setPivotY(r14.getBaseline());
        if (r10 == false) goto L5;
        float r15 = 1.0f;
    L6:
        maybeAnimateActiveIndicatorToProgress(r15);
        int r16 = this.labelVisibilityMode;
        if (r16 == (-1)) goto L24;
        if (r16 != 0) goto L10;
        View r17 = getIconOrContainer();
        int r18 = this.itemPaddingTop;
        if (r10 == false) goto L21;
    L20:
        setViewTopMarginAndGravity(r17, r18, 49);
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        this.largeLabel.setVisibility(0);
    L22:
        this.smallLabel.setVisibility(4);
    L31:
        refreshDrawableState();
        setSelected(r10);
        return;
    L21:
        setViewTopMarginAndGravity(r17, r18, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.largeLabel.setVisibility(4);
        goto L22
    L10:
        if (r16 == 1) goto L14;
        if (r16 != 2) goto L31;
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
        this.largeLabel.setVisibility(8);
        this.smallLabel.setVisibility(8);
        goto L31
    L14:
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        if (r10 == false) goto L17;
    L16:
        setViewTopMarginAndGravity(getIconOrContainer(), (int) (this.itemPaddingTop + this.shiftAmount), 49);
        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r19 = this.smallLabel;
        float r20 = this.scaleUpFactor;
        setViewScaleValues(r19, r20, r20, 4);
    L17:
        setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
        TextView r21 = this.largeLabel;
        float r22 = this.scaleDownFactor;
        setViewScaleValues(r21, r22, r22, 4);
        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L31
    L24:
        if (this.isShifting == false) goto L28;
        r17 = getIconOrContainer();
        r18 = this.itemPaddingTop;
        if (r10 == false) goto L21;
    L28:
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        if (r10 == false) goto L17;
    L5:
        r15 = 0.0f;
        goto L6
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        this.smallLabel.setEnabled(r10);
        this.largeLabel.setEnabled(r10);
        this.icon.setEnabled(r10);
        if (r10 == false) goto L5;
        PointerIconCompat r11 = PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND);
    L6:
        ViewCompat.setPointerIcon(this, r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable r10) {
        if (r10 != this.originalIconDrawable) goto L5;
        return;
    L5:
        this.originalIconDrawable = r10;
        if (r10 == null) goto L14;
        Drawable.ConstantState r11 = r10.getConstantState();
        if (r11 == null) goto L11;
        r10 = r11.newDrawable();
    L11:
        r10 = DrawableCompat.wrap(r10).mutate();
        this.wrappedIconDrawable = r10;
        ColorStateList r12 = this.iconTint;
        if (r12 == null) goto L14;
        DrawableCompat.setTintList(r10, r12);
    L14:
        this.icon.setImageDrawable(r10);
    }

    public void setIconSize(int r10) {
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        r11.width = r10;
        r11.height = r10;
        this.icon.setLayoutParams(r11);
    }

    public void setIconTintList(@Nullable ColorStateList r10) {
        this.iconTint = r10;
        if (this.itemData == null) goto L8;
        Drawable r11 = this.wrappedIconDrawable;
        if (r11 == null) goto L9;
        DrawableCompat.setTintList(r11, r10);
        this.wrappedIconDrawable.invalidateSelf();
        return;
    L9:
        return;
    }

    public void setItemBackground(int r10) {
        if (r10 != 0) goto L4;
        Drawable r11 = null;
    L5:
        setItemBackground(r11);
        return;
    L4:
        r11 = ContextCompat.getDrawable(getContext(), r10);
        goto L5
    }

    public void setItemBackground(@Nullable Drawable r10) {
        if (r10 != null) goto L4;
    L6:
        ViewCompat.setBackground(this, r10);
        return;
    L4:
        if (r10.getConstantState() == null) goto L6;
        r10 = r10.getConstantState().newDrawable().mutate();
        goto L6
    }

    public void setItemPaddingBottom(int r10) {
        if (this.itemPaddingBottom == r10) goto L6;
        this.itemPaddingBottom = r10;
        refreshChecked();
        return;
    }

    public void setItemPaddingTop(int r10) {
        if (this.itemPaddingTop == r10) goto L6;
        this.itemPaddingTop = r10;
        refreshChecked();
        return;
    }

    public void setItemPosition(int r10) {
        this.itemPosition = r10;
    }

    public void setLabelVisibilityMode(int r10) {
        if (this.labelVisibilityMode == r10) goto L6;
        this.labelVisibilityMode = r10;
        updateActiveIndicatorTransform();
        updateActiveIndicatorLayoutParams(getWidth());
        refreshChecked();
        return;
    }

    public void setShifting(boolean r10) {
        if (this.isShifting == r10) goto L6;
        this.isShifting = r10;
        refreshChecked();
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r10, char r11) {
    }

    public void setTextAppearanceActive(@StyleRes int r10) {
        setTextAppearanceWithoutFontScaling(this.largeLabel, r10);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int r10) {
        setTextAppearanceWithoutFontScaling(this.smallLabel, r10);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList r10) {
        if (r10 == null) goto L5;
        this.smallLabel.setTextColor(r10);
        this.largeLabel.setTextColor(r10);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(@Nullable CharSequence r10) {
        this.smallLabel.setText(r10);
        this.largeLabel.setText(r10);
        MenuItemImpl r11 = this.itemData;
        if (r11 != null) goto L5;
    L6:
        setContentDescription(r10);
    L7:
        MenuItemImpl r12 = this.itemData;
        if (r12 != null) goto L10;
    L13:
        int r13 = Build.VERSION.SDK_INT;
        if (r13 >= 21) goto L16;
    L17:
        TooltipCompat.setTooltipText(this, r10);
        return;
    L16:
        if (r13 > 23) goto L17;
        return;
    L10:
        if (TextUtils.isEmpty(r12.getTooltipText()) == true) goto L13;
        r10 = this.itemData.getTooltipText();
        goto L13
    L5:
        if (TextUtils.isEmpty(r11.getContentDescription()) == false) goto L7;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }
}
