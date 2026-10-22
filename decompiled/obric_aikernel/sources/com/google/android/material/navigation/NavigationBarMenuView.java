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
import com.google.android.material.internal.TextScale;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import java.util.HashSet;
import q5.b;
import q5.g;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int ITEM_POOL_SIZE = 5;
    private static final int NO_PADDING = -1;

    @NonNull
    private final SparseArray<com.google.android.material.badge.a> badgeDrawables;

    @Nullable
    private NavigationBarItemView[] buttons;
    private ColorStateList itemActiveIndicatorColor;
    private boolean itemActiveIndicatorEnabled;
    private int itemActiveIndicatorHeight;
    private int itemActiveIndicatorMarginHorizontal;
    private boolean itemActiveIndicatorResizeable;
    private l itemActiveIndicatorShapeAppearance;
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

    @StyleRes
    private int itemTextAppearanceActive;

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

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ NavigationBarMenuView f3464c;

        a(NavigationBarMenuView r10) {
            this.f3464c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            MenuItemImpl r11 = ((NavigationBarItemView) r10).getItemData();
            if (NavigationBarMenuView.access$100(this.f3464c).performItemAction(r11, NavigationBarMenuView.access$000(this.f3464c), 0) == true) goto L6;
            r11.setChecked(true);
            return;
        }
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
    }

    public NavigationBarMenuView(@NonNull Context r10) {
        super(r10);
        this.itemPool = new Pools.SynchronizedPool(5);
        this.onTouchListeners = new SparseArray(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray(5);
        this.itemPaddingTop = -1;
        this.itemPaddingBottom = -1;
        this.itemActiveIndicatorResizeable = false;
        this.itemTextColorDefault = createDefaultColorStateList(R.attr.textColorSecondary);
        if (isInEditMode() == false) goto L5;
        this.set = null;
    L6:
        this.onClickListener = new a(this);
        ViewCompat.setImportantForAccessibility(this, 1);
        return;
    L5:
        AutoTransition r11 = new AutoTransition();
        this.set = r11;
        r11.setOrdering(0);
        r11.setDuration(z5.a.d(getContext(), b.motionDurationLong1, getResources().getInteger(g.material_motion_duration_long_1)));
        r11.setInterpolator(z5.a.e(getContext(), b.motionEasingStandard, r5.a.f12674b));
        r11.addTransition(new TextScale());
        goto L6
    }

    static /* synthetic */ NavigationBarPresenter access$000(NavigationBarMenuView r10) {
        return r10.presenter;
    }

    static /* synthetic */ MenuBuilder access$100(NavigationBarMenuView r10) {
        return r10.menu;
    }

    @Nullable
    private Drawable createItemActiveIndicatorDrawable() {
        if (this.itemActiveIndicatorShapeAppearance != null) goto L5;
        return null;
    L5:
        if (this.itemActiveIndicatorColor == null) goto L10;
        MaterialShapeDrawable r10 = new MaterialShapeDrawable(this.itemActiveIndicatorShapeAppearance);
        r10.setFillColor(this.itemActiveIndicatorColor);
        return r10;
    L10:
        return null;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView r10 = this.itemPool.acquire();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return createNavigationBarItemView(getContext());
    }

    private boolean isValidId(int r10) {
        if (r10 == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void removeUnusedBadges() {
        HashSet r10 = new HashSet();
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= this.menu.size()) goto L7;
        r10.add(Integer.valueOf(this.menu.getItem(r12).getItemId()));
        r12 = r12 + 1;
    L7:
        if (r11 >= this.badgeDrawables.size()) goto L12;
        int r13 = this.badgeDrawables.keyAt(r11);
        if (r10.contains(Integer.valueOf(r13)) == true) goto L11;
        this.badgeDrawables.delete(r13);
    L11:
        r11 = r11 + 1;
        goto L7
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView r10) {
        int r11 = r10.getId();
        if (isValidId(r11) == true) goto L5;
        return;
    L5:
        com.google.android.material.badge.a r12 = this.badgeDrawables.get(r11);
        if (r12 == null) goto L9;
        r10.setBadge(r12);
        return;
    }

    private void validateMenuItemId(int r10) {
        if (isValidId(r10) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r10 + " is not a valid view id");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        removeAllViews();
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L11;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L11;
        NavigationBarItemView r13 = r10[r12];
        if (r13 == null) goto L9;
        this.itemPool.release(r13);
        r13.clear();
    L9:
        r12 = r12 + 1;
    L11:
        if (this.menu.size() != 0) goto L14;
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.buttons = null;
        return;
    L14:
        removeUnusedBadges();
        this.buttons = new NavigationBarItemView[this.menu.size()];
        boolean r14 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r15 = 0;
    L16:
        if (r15 >= this.menu.size()) goto L32;
        this.presenter.setUpdateSuspended(true);
        this.menu.getItem(r15).setCheckable(true);
        this.presenter.setUpdateSuspended(false);
        NavigationBarItemView r16 = getNewItem();
        this.buttons[r15] = r16;
        r16.setIconTintList(this.itemIconTint);
        r16.setIconSize(this.itemIconSize);
        r16.setTextColor(this.itemTextColorDefault);
        r16.setTextAppearanceInactive(this.itemTextAppearanceInactive);
        r16.setTextAppearanceActive(this.itemTextAppearanceActive);
        r16.setTextColor(this.itemTextColorFromUser);
        int r17 = this.itemPaddingTop;
        if (r17 == (-1)) goto L20;
        r16.setItemPaddingTop(r17);
    L20:
        int r18 = this.itemPaddingBottom;
        if (r18 == (-1)) goto L23;
        r16.setItemPaddingBottom(r18);
    L23:
        r16.setActiveIndicatorWidth(this.itemActiveIndicatorWidth);
        r16.setActiveIndicatorHeight(this.itemActiveIndicatorHeight);
        r16.setActiveIndicatorMarginHorizontal(this.itemActiveIndicatorMarginHorizontal);
        r16.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        r16.setActiveIndicatorResizeable(this.itemActiveIndicatorResizeable);
        r16.setActiveIndicatorEnabled(this.itemActiveIndicatorEnabled);
        Drawable r19 = this.itemBackground;
        if (r19 == null) goto L26;
        r16.setItemBackground(r19);
    L27:
        r16.setShifting(r14);
        r16.setLabelVisibilityMode(this.labelVisibilityMode);
        MenuItemImpl r20 = (MenuItemImpl) this.menu.getItem(r15);
        r16.initialize(r20, 0);
        r16.setItemPosition(r15);
        int r21 = r20.getItemId();
        r16.setOnTouchListener(this.onTouchListeners.get(r21));
        r16.setOnClickListener(this.onClickListener);
        int r22 = this.selectedItemId;
        if (r22 == 0) goto L31;
        if (r21 != r22) goto L31;
        this.selectedItemPosition = r15;
    L31:
        setBadgeIfNeeded(r16);
        addView(r16);
        r15 = r15 + 1;
        goto L16
    L26:
        r16.setItemBackground(this.itemBackgroundRes);
        goto L27
    L32:
        int r23 = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = r23;
        this.menu.getItem(r23).setChecked(true);
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int r10) {
        TypedValue r11 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(r10, r11, true) == true) goto L5;
        return null;
    L5:
        ColorStateList r12 = AppCompatResources.getColorStateList(getContext(), r11.resourceId);
        if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, r11, true) == true) goto L8;
        return null;
    L8:
        int r13 = r11.data;
        int r14 = r12.getDefaultColor();
        int[] r15 = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{r15, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{r12.getColorForState(r15, r14), r13, r14});
    }

    @NonNull
    protected abstract NavigationBarItemView createNavigationBarItemView(@NonNull Context r10);

    @Nullable
    public NavigationBarItemView findItemView(int r10) {
        validateMenuItemId(r10);
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L10;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L14;
        NavigationBarItemView r14 = r11[r13];
        if (r14.getId() == r10) goto L8;
        r13 = r13 + 1;
        goto L5
    L8:
        return r14;
    L14:
        return null;
    L10:
        return null;
    }

    @Nullable
    public com.google.android.material.badge.a getBadge(int r10) {
        return this.badgeDrawables.get(r10);
    }

    SparseArray<com.google.android.material.badge.a> getBadgeDrawables() {
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
    public l getItemActiveIndicatorShapeAppearance() {
        return this.itemActiveIndicatorShapeAppearance;
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.itemActiveIndicatorWidth;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L9;
        if (r10.length <= 0) goto L9;
        return r10[0].getBackground();
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
    protected MenuBuilder getMenu() {
        return this.menu;
    }

    com.google.android.material.badge.a getOrCreateBadge(int r10) {
        validateMenuItemId(r10);
        com.google.android.material.badge.a r11 = this.badgeDrawables.get(r10);
        if (r11 != null) goto L5;
        r11 = com.google.android.material.badge.a.b(getContext());
        this.badgeDrawables.put(r10, r11);
    L5:
        NavigationBarItemView r12 = findItemView(r10);
        if (r12 == null) goto L8;
        r12.setBadge(r11);
    L8:
        return r11;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    protected int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@NonNull MenuBuilder r10) {
        this.menu = r10;
    }

    protected boolean isItemActiveIndicatorResizeable() {
        return this.itemActiveIndicatorResizeable;
    }

    protected boolean isShifting(int r10, int r11) {
        if (r10 == (-1)) goto L5;
        if (r10 != 0) goto L10;
        return true;
    L10:
        return false;
    L5:
        if (r11 <= 3) goto L10;
        return true;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        AccessibilityNodeInfoCompat.wrap(r10).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
    }

    void removeBadge(int r10) {
        validateMenuItemId(r10);
        com.google.android.material.badge.a r11 = this.badgeDrawables.get(r10);
        NavigationBarItemView r12 = findItemView(r10);
        if (r12 == null) goto L5;
        r12.removeBadge();
    L5:
        if (r11 == null) goto L8;
        this.badgeDrawables.remove(r10);
        return;
    }

    void restoreBadgeDrawables(SparseArray<com.google.android.material.badge.a> r10) {
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L9;
        int r13 = r10.keyAt(r12);
        if (this.badgeDrawables.indexOfKey(r13) >= 0) goto L8;
        this.badgeDrawables.append(r13, r10.get(r13));
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        NavigationBarItemView[] r14 = this.buttons;
        if (r14 == null) goto L14;
        int r15 = r14.length;
    L12:
        if (r11 >= r15) goto L19;
        NavigationBarItemView r16 = r14[r11];
        r16.setBadge(this.badgeDrawables.get(r16.getId()));
        r11 = r11 + 1;
        goto L12
    L19:
        return;
    }

    public void setIconTintList(@Nullable ColorStateList r10) {
        this.itemIconTint = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setIconTintList(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList r10) {
        this.itemActiveIndicatorColor = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorEnabled(boolean r10) {
        this.itemActiveIndicatorEnabled = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setActiveIndicatorEnabled(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorHeight(@Px int r10) {
        this.itemActiveIndicatorHeight = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setActiveIndicatorHeight(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int r10) {
        this.itemActiveIndicatorMarginHorizontal = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setActiveIndicatorMarginHorizontal(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    protected void setItemActiveIndicatorResizeable(boolean r10) {
        this.itemActiveIndicatorResizeable = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setActiveIndicatorResizeable(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable l r10) {
        this.itemActiveIndicatorShapeAppearance = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorWidth(@Px int r10) {
        this.itemActiveIndicatorWidth = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setActiveIndicatorWidth(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackground(@Nullable Drawable r10) {
        this.itemBackground = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setItemBackground(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackgroundRes(int r10) {
        this.itemBackgroundRes = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setItemBackground(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemIconSize(@Dimension int r10) {
        this.itemIconSize = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setIconSize(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int r10, @Nullable View.OnTouchListener r11) {
        SparseArray<View.OnTouchListener> r12 = this.onTouchListeners;
        if (r11 != null) goto L5;
        r12.remove(r10);
    L6:
        NavigationBarItemView[] r13 = this.buttons;
        if (r13 == null) goto L14;
        int r14 = r13.length;
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L18;
        NavigationBarItemView r16 = r13[r15];
        if (r16.getItemData().getItemId() != r10) goto L13;
        r16.setOnTouchListener(r11);
    L13:
        r15 = r15 + 1;
        goto L9
    L18:
        return;
    L14:
        return;
    L5:
        r12.put(r10, r11);
        goto L6
    }

    public void setItemPaddingBottom(@Px int r10) {
        this.itemPaddingBottom = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setItemPaddingBottom(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemPaddingTop(@Px int r10) {
        this.itemPaddingTop = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setItemPaddingTop(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemTextAppearanceActive(@StyleRes int r10) {
        this.itemTextAppearanceActive = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L10;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L14;
        NavigationBarItemView r14 = r11[r13];
        r14.setTextAppearanceActive(r10);
        ColorStateList r15 = this.itemTextColorFromUser;
        if (r15 == null) goto L9;
        r14.setTextColor(r15);
    L9:
        r13 = r13 + 1;
        goto L5
    L14:
        return;
    }

    public void setItemTextAppearanceInactive(@StyleRes int r10) {
        this.itemTextAppearanceInactive = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L10;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L14;
        NavigationBarItemView r14 = r11[r13];
        r14.setTextAppearanceInactive(r10);
        ColorStateList r15 = this.itemTextColorFromUser;
        if (r15 == null) goto L9;
        r14.setTextColor(r15);
    L9:
        r13 = r13 + 1;
        goto L5
    L14:
        return;
    }

    public void setItemTextColor(@Nullable ColorStateList r10) {
        this.itemTextColorFromUser = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setTextColor(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setLabelVisibilityMode(int r10) {
        this.labelVisibilityMode = r10;
    }

    public void setPresenter(@NonNull NavigationBarPresenter r10) {
        this.presenter = r10;
    }

    void tryRestoreSelectedItemId(int r10) {
        int r11 = this.menu.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        MenuItem r13 = this.menu.getItem(r12);
        if (r10 == r13.getItemId()) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        this.selectedItemId = r10;
        this.selectedItemPosition = r12;
        r13.setChecked(true);
        return;
    }

    public void updateMenuView() {
        MenuBuilder r10 = this.menu;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.buttons == null) goto L30;
        int r11 = r10.size();
        if (r11 == this.buttons.length) goto L11;
        buildMenuView();
        return;
    L11:
        int r12 = this.selectedItemId;
        int r13 = 0;
    L12:
        if (r13 >= r11) goto L18;
        MenuItem r14 = this.menu.getItem(r13);
        if (r14.isChecked() == false) goto L16;
        this.selectedItemId = r14.getItemId();
        this.selectedItemPosition = r13;
    L16:
        r13 = r13 + 1;
        goto L12
    L18:
        if (r12 == this.selectedItemId) goto L22;
        TransitionSet r15 = this.set;
        if (r15 == null) goto L22;
        TransitionManager.beginDelayedTransition(this, r15);
    L22:
        boolean r16 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r17 = 0;
    L23:
        if (r17 >= r11) goto L31;
        this.presenter.setUpdateSuspended(true);
        this.buttons[r17].setLabelVisibilityMode(this.labelVisibilityMode);
        this.buttons[r17].setShifting(r16);
        this.buttons[r17].initialize((MenuItemImpl) this.menu.getItem(r17), 0);
        this.presenter.setUpdateSuspended(false);
        r17 = r17 + 1;
        goto L23
    L31:
        return;
    }
}
