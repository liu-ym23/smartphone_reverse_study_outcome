package com.google.android.material.navigation;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int ITEM_POOL_SIZE = 5;
    private static final int NO_PADDING = -1;

    @NonNull
    private final SparseArray<BadgeDrawable> badgeDrawables;

    @Nullable
    private NavigationBarItemView[] buttons;
    private ColorStateList itemActiveIndicatorColor;
    private boolean itemActiveIndicatorEnabled;
    private int itemActiveIndicatorHeight;
    private int itemActiveIndicatorLabelPadding;
    private int itemActiveIndicatorMarginHorizontal;
    private boolean itemActiveIndicatorResizeable;
    private ShapeAppearanceModel itemActiveIndicatorShapeAppearance;
    private int itemActiveIndicatorWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;

    @Dimension
    private int itemIconSize;

    @Nullable
    private ColorStateList itemIconTint;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private final Pools.Pool<NavigationBarItemView> itemPool;

    @Nullable
    private ColorStateList itemRippleColor;

    @StyleRes
    private int itemTextAppearanceActive;
    private boolean itemTextAppearanceActiveBoldEnabled;

    @StyleRes
    private int itemTextAppearanceInactive;

    @Nullable
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private MenuBuilder menu;

    @NonNull
    private final View.OnClickListener onClickListener;

    @NonNull
    private final SparseArray<View.OnTouchListener> onTouchListeners;
    private NavigationBarPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;

    @Nullable
    private final TransitionSet set;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
    }

    public NavigationBarMenuView(@NonNull Context r5) {
        super(r5);
        this.itemPool = new Pools.SynchronizedPool(5);
        this.onTouchListeners = new SparseArray(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray(5);
        this.itemPaddingTop = -1;
        this.itemPaddingBottom = -1;
        this.itemActiveIndicatorLabelPadding = -1;
        this.itemActiveIndicatorResizeable = false;
        this.itemTextColorDefault = createDefaultColorStateList(R.attr.textColorSecondary);
        if (isInEditMode() == false) goto L5;
        this.set = null;
    L6:
        this.onClickListener = new AnonymousClass1(this);
        ViewCompat.setImportantForAccessibility(this, 1);
        return;
    L5:
        AutoTransition r10 = new AutoTransition();
        this.set = r10;
        r10.setOrdering(0);
        r10.setDuration(MotionUtils.resolveThemeDuration(getContext(), com.google.android.material.R.attr.motionDurationMedium4, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
        r10.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), com.google.android.material.R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        r10.addTransition(new TextScale());
        goto L6
    }

    public static /* synthetic */ NavigationBarPresenter access$000(NavigationBarMenuView r5) {
        return r5.presenter;
    }

    public static /* synthetic */ MenuBuilder access$100(NavigationBarMenuView r5) {
        return r5.menu;
    }

    @Nullable
    private Drawable createItemActiveIndicatorDrawable() {
        if (this.itemActiveIndicatorShapeAppearance != null) goto L5;
        return null;
    L5:
        if (this.itemActiveIndicatorColor == null) goto L10;
        MaterialShapeDrawable r5 = new MaterialShapeDrawable(this.itemActiveIndicatorShapeAppearance);
        r5.setFillColor(this.itemActiveIndicatorColor);
        return r5;
    L10:
        return null;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView r5 = this.itemPool.acquire();
        if (r5 == null) goto L5;
        return r5;
    L5:
        return createNavigationBarItemView(getContext());
    }

    private boolean isValidId(int r5) {
        if (r5 == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void removeUnusedBadges() {
        HashSet r5 = new HashSet();
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= this.menu.size()) goto L7;
        r5.add(Integer.valueOf(this.menu.getItem(r11).getItemId()));
        r11 = r11 + 1;
    L7:
        if (r10 >= this.badgeDrawables.size()) goto L12;
        int r12 = this.badgeDrawables.keyAt(r10);
        if (r5.contains(Integer.valueOf(r12)) == true) goto L11;
        this.badgeDrawables.delete(r12);
    L11:
        r10 = r10 + 1;
        goto L7
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView r5) {
        int r10 = r5.getId();
        if (isValidId(r10) == true) goto L5;
        return;
    L5:
        BadgeDrawable r11 = this.badgeDrawables.get(r10);
        if (r11 == null) goto L9;
        r5.setBadge(r11);
        return;
    }

    private void validateMenuItemId(int r5) {
        if (isValidId(r5) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r5 + " is not a valid view id");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        removeAllViews();
        NavigationBarItemView[] r5 = this.buttons;
        if (r5 == null) goto L11;
        int r10 = r5.length;
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L11;
        NavigationBarItemView r12 = r5[r11];
        if (r12 == null) goto L9;
        this.itemPool.release(r12);
        r12.clear();
    L9:
        r11 = r11 + 1;
    L11:
        if (this.menu.size() != 0) goto L14;
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.buttons = null;
        return;
    L14:
        removeUnusedBadges();
        this.buttons = new NavigationBarItemView[this.menu.size()];
        boolean r13 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r14 = 0;
    L16:
        if (r14 >= this.menu.size()) goto L35;
        this.presenter.setUpdateSuspended(true);
        this.menu.getItem(r14).setCheckable(true);
        this.presenter.setUpdateSuspended(false);
        NavigationBarItemView r15 = getNewItem();
        this.buttons[r14] = r15;
        r15.setIconTintList(this.itemIconTint);
        r15.setIconSize(this.itemIconSize);
        r15.setTextColor(this.itemTextColorDefault);
        r15.setTextAppearanceInactive(this.itemTextAppearanceInactive);
        r15.setTextAppearanceActive(this.itemTextAppearanceActive);
        r15.setTextAppearanceActiveBoldEnabled(this.itemTextAppearanceActiveBoldEnabled);
        r15.setTextColor(this.itemTextColorFromUser);
        int r16 = this.itemPaddingTop;
        if (r16 == (-1)) goto L20;
        r15.setItemPaddingTop(r16);
    L20:
        int r17 = this.itemPaddingBottom;
        if (r17 == (-1)) goto L23;
        r15.setItemPaddingBottom(r17);
    L23:
        int r18 = this.itemActiveIndicatorLabelPadding;
        if (r18 == (-1)) goto L26;
        r15.setActiveIndicatorLabelPadding(r18);
    L26:
        r15.setActiveIndicatorWidth(this.itemActiveIndicatorWidth);
        r15.setActiveIndicatorHeight(this.itemActiveIndicatorHeight);
        r15.setActiveIndicatorMarginHorizontal(this.itemActiveIndicatorMarginHorizontal);
        r15.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        r15.setActiveIndicatorResizeable(this.itemActiveIndicatorResizeable);
        r15.setActiveIndicatorEnabled(this.itemActiveIndicatorEnabled);
        Drawable r19 = this.itemBackground;
        if (r19 == null) goto L29;
        r15.setItemBackground(r19);
    L30:
        r15.setItemRippleColor(this.itemRippleColor);
        r15.setShifting(r13);
        r15.setLabelVisibilityMode(this.labelVisibilityMode);
        MenuItemImpl r20 = (MenuItemImpl) this.menu.getItem(r14);
        r15.initialize(r20, 0);
        r15.setItemPosition(r14);
        int r21 = r20.getItemId();
        r15.setOnTouchListener(this.onTouchListeners.get(r21));
        r15.setOnClickListener(this.onClickListener);
        int r22 = this.selectedItemId;
        if (r22 == 0) goto L34;
        if (r21 != r22) goto L34;
        this.selectedItemPosition = r14;
    L34:
        setBadgeIfNeeded(r15);
        addView(r15);
        r14 = r14 + 1;
        goto L16
    L29:
        r15.setItemBackground(this.itemBackgroundRes);
        goto L30
    L35:
        int r23 = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = r23;
        this.menu.getItem(r23).setChecked(true);
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int r10) {
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
        return new ColorStateList(new int[][]{r14, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{r11.getColorForState(r14, r13), r12, r13});
    }

    @NonNull
    public abstract NavigationBarItemView createNavigationBarItemView(@NonNull Context r5);

    @Nullable
    public NavigationBarItemView findItemView(int r5) {
        validateMenuItemId(r5);
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L10;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L14;
        NavigationBarItemView r13 = r10[r12];
        if (r13.getId() == r5) goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        return r13;
    L14:
        return null;
    L10:
        return null;
    }

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.itemActiveIndicatorLabelPadding;
    }

    @Nullable
    public BadgeDrawable getBadge(int r5) {
        return this.badgeDrawables.get(r5);
    }

    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.itemActiveIndicatorColor;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.itemActiveIndicatorEnabled;
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.itemActiveIndicatorHeight;
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.itemActiveIndicatorMarginHorizontal;
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.itemActiveIndicatorShapeAppearance;
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.itemActiveIndicatorWidth;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] r5 = this.buttons;
        if (r5 == null) goto L9;
        if (r5.length <= 0) goto L9;
        return r5[0].getBackground();
    L9:
        return this.itemBackground;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    @Dimension
    public int getItemIconSize() {
        return this.itemIconSize;
    }

    @Px
    public int getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    @Px
    public int getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    @Nullable
    public MenuBuilder getMenu() {
        return this.menu;
    }

    public BadgeDrawable getOrCreateBadge(int r5) {
        validateMenuItemId(r5);
        BadgeDrawable r10 = this.badgeDrawables.get(r5);
        if (r10 != null) goto L5;
        r10 = BadgeDrawable.create(getContext());
        this.badgeDrawables.put(r5, r10);
    L5:
        NavigationBarItemView r11 = findItemView(r5);
        if (r11 == null) goto L8;
        r11.setBadge(r10);
    L8:
        return r10;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    public int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@NonNull MenuBuilder r5) {
        this.menu = r5;
    }

    public boolean isItemActiveIndicatorResizeable() {
        return this.itemActiveIndicatorResizeable;
    }

    public boolean isShifting(int r5, int r10) {
        if (r5 == (-1)) goto L5;
        if (r5 == 0) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r10 > 3) goto L10;
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        AccessibilityNodeInfoCompat.wrap(r5).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
    }

    public void removeBadge(int r5) {
        validateMenuItemId(r5);
        NavigationBarItemView r10 = findItemView(r5);
        if (r10 == null) goto L5;
        r10.removeBadge();
    L5:
        this.badgeDrawables.put(r5, null);
    }

    public void restoreBadgeDrawables(SparseArray<BadgeDrawable> r10) {
        int r5 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r10.size()) goto L9;
        int r12 = r10.keyAt(r11);
        if (this.badgeDrawables.indexOfKey(r12) >= 0) goto L8;
        this.badgeDrawables.append(r12, r10.get(r12));
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        NavigationBarItemView[] r13 = this.buttons;
        if (r13 == null) goto L17;
        int r14 = r13.length;
    L12:
        if (r5 >= r14) goto L24;
        NavigationBarItemView r15 = r13[r5];
        BadgeDrawable r16 = this.badgeDrawables.get(r15.getId());
        if (r16 == null) goto L16;
        r15.setBadge(r16);
    L16:
        r5 = r5 + 1;
        goto L12
    L24:
        return;
    }

    public void setActiveIndicatorLabelPadding(@Px int r5) {
        this.itemActiveIndicatorLabelPadding = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setActiveIndicatorLabelPadding(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setIconTintList(@Nullable ColorStateList r5) {
        this.itemIconTint = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setIconTintList(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList r5) {
        this.itemActiveIndicatorColor = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorEnabled(boolean r5) {
        this.itemActiveIndicatorEnabled = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setActiveIndicatorEnabled(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorHeight(@Px int r5) {
        this.itemActiveIndicatorHeight = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setActiveIndicatorHeight(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int r5) {
        this.itemActiveIndicatorMarginHorizontal = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setActiveIndicatorMarginHorizontal(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorResizeable(boolean r5) {
        this.itemActiveIndicatorResizeable = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setActiveIndicatorResizeable(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel r5) {
        this.itemActiveIndicatorShapeAppearance = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorWidth(@Px int r5) {
        this.itemActiveIndicatorWidth = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setActiveIndicatorWidth(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackground(@Nullable Drawable r5) {
        this.itemBackground = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setItemBackground(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackgroundRes(int r5) {
        this.itemBackgroundRes = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setItemBackground(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemIconSize(@Dimension int r5) {
        this.itemIconSize = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setIconSize(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int r5, @Nullable View.OnTouchListener r10) {
        if (r10 != null) goto L4;
        this.onTouchListeners.remove(r5);
    L5:
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L13;
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L17;
        NavigationBarItemView r14 = r11[r13];
        if (r14.getItemData().getItemId() != r5) goto L12;
        r14.setOnTouchListener(r10);
    L12:
        r13 = r13 + 1;
        goto L8
    L17:
        return;
    L13:
        return;
    L4:
        this.onTouchListeners.put(r5, r10);
        goto L5
    }

    public void setItemPaddingBottom(@Px int r5) {
        this.itemPaddingBottom = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setItemPaddingBottom(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemPaddingTop(@Px int r5) {
        this.itemPaddingTop = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setItemPaddingTop(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemRippleColor(@Nullable ColorStateList r5) {
        this.itemRippleColor = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setItemRippleColor(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemTextAppearanceActive(@StyleRes int r10) {
        this.itemTextAppearanceActive = r10;
        NavigationBarItemView[] r5 = this.buttons;
        if (r5 == null) goto L10;
        int r11 = r5.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L14;
        NavigationBarItemView r13 = r5[r12];
        r13.setTextAppearanceActive(r10);
        ColorStateList r14 = this.itemTextColorFromUser;
        if (r14 == null) goto L9;
        r13.setTextColor(r14);
    L9:
        r12 = r12 + 1;
        goto L5
    L14:
        return;
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean r5) {
        this.itemTextAppearanceActiveBoldEnabled = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setTextAppearanceActiveBoldEnabled(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemTextAppearanceInactive(@StyleRes int r10) {
        this.itemTextAppearanceInactive = r10;
        NavigationBarItemView[] r5 = this.buttons;
        if (r5 == null) goto L10;
        int r11 = r5.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L14;
        NavigationBarItemView r13 = r5[r12];
        r13.setTextAppearanceInactive(r10);
        ColorStateList r14 = this.itemTextColorFromUser;
        if (r14 == null) goto L9;
        r13.setTextColor(r14);
    L9:
        r12 = r12 + 1;
        goto L5
    L14:
        return;
    }

    public void setItemTextColor(@Nullable ColorStateList r5) {
        this.itemTextColorFromUser = r5;
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].setTextColor(r5);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void setLabelVisibilityMode(int r5) {
        this.labelVisibilityMode = r5;
    }

    public void setPresenter(@NonNull NavigationBarPresenter r5) {
        this.presenter = r5;
    }

    public void tryRestoreSelectedItemId(int r5) {
        int r10 = this.menu.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L11;
        MenuItem r12 = this.menu.getItem(r11);
        if (r5 == r12.getItemId()) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        this.selectedItemId = r5;
        this.selectedItemPosition = r11;
        r12.setChecked(true);
        return;
    }

    public void updateMenuView() {
        MenuBuilder r5 = this.menu;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.buttons == null) goto L30;
        int r10 = r5.size();
        if (r10 == this.buttons.length) goto L11;
        buildMenuView();
        return;
    L11:
        int r11 = this.selectedItemId;
        int r12 = 0;
    L12:
        if (r12 >= r10) goto L18;
        MenuItem r13 = this.menu.getItem(r12);
        if (r13.isChecked() == false) goto L16;
        this.selectedItemId = r13.getItemId();
        this.selectedItemPosition = r12;
    L16:
        r12 = r12 + 1;
        goto L12
    L18:
        if (r11 == this.selectedItemId) goto L22;
        TransitionSet r14 = this.set;
        if (r14 == null) goto L22;
        TransitionManager.beginDelayedTransition(this, r14);
    L22:
        boolean r15 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r16 = 0;
    L23:
        if (r16 >= r10) goto L31;
        this.presenter.setUpdateSuspended(true);
        this.buttons[r16].setLabelVisibilityMode(this.labelVisibilityMode);
        this.buttons[r16].setShifting(r15);
        this.buttons[r16].initialize((MenuItemImpl) this.menu.getItem(r16), 0);
        this.presenter.setUpdateSuspended(false);
        r16 = r16 + 1;
        goto L23
    L31:
        return;
    }
}
