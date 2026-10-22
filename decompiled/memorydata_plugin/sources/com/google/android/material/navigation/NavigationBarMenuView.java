package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.badge.a;
import com.google.android.material.internal.TextScale;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int ITEM_POOL_SIZE = 5;
    private static final int NO_PADDING = -1;
    private final SparseArray<a> badgeDrawables;
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
    private int itemIconSize;
    private ColorStateList itemIconTint;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private final Pools.Pool<NavigationBarItemView> itemPool;
    private int itemTextAppearanceActive;
    private int itemTextAppearanceInactive;
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private MenuBuilder menu;
    private final View.OnClickListener onClickListener;
    private final SparseArray<View.OnTouchListener> onTouchListeners;
    private NavigationBarPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;
    private final TransitionSet set;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
    }

    public NavigationBarMenuView(Context r9) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"));
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
        this.onClickListener = new AnonymousClass1(this);
        ViewCompat.setImportantForAccessibility(this, 1);
        return;
    L5:
        AutoTransition r0 = new AutoTransition();
        this.set = r0;
        r0.setOrdering(0);
        r0.setDuration(com.google.android.material.g.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.motionDurationLong1, "attr", "motionDurationLong1"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getInteger(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.integer.material_motion_duration_long_1, TypedValues.Custom.S_INT, "material_motion_duration_long_1"))));
        r0.setInterpolator(com.google.android.material.g.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.motionEasingStandard, "attr", "motionEasingStandard"), com.google.android.material.a.a.f3742b));
        r0.addTransition(new TextScale());
        goto L6
    }

    static /* synthetic */ NavigationBarPresenter access$000(NavigationBarMenuView r0) {
        return r0.presenter;
    }

    static /* synthetic */ MenuBuilder access$100(NavigationBarMenuView r0) {
        return r0.menu;
    }

    private Drawable createItemActiveIndicatorDrawable() {
        if (this.itemActiveIndicatorShapeAppearance != null) goto L5;
        return null;
    L5:
        if (this.itemActiveIndicatorColor == null) goto L10;
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(this.itemActiveIndicatorShapeAppearance);
        r0.setFillColor(this.itemActiveIndicatorColor);
        return r0;
    L10:
        return null;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView r0 = (NavigationBarItemView) ZeusTransformUtils.preCheckCast(this.itemPool.acquire(), NavigationBarItemView.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return createNavigationBarItemView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    private boolean isValidId(int r1) {
        if (r1 == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void removeUnusedBadges() {
        HashSet r0 = new HashSet();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= this.menu.size()) goto L7;
        r0.add(Integer.valueOf(this.menu.getItem(r2).getItemId()));
        r2 = r2 + 1;
    L7:
        if (r1 >= this.badgeDrawables.size()) goto L12;
        int r3 = this.badgeDrawables.keyAt(r1);
        if (r0.contains(Integer.valueOf(r3)) == true) goto L11;
        this.badgeDrawables.delete(r3);
    L11:
        r1 = r1 + 1;
        goto L7
    }

    private void setBadgeIfNeeded(NavigationBarItemView r3) {
        int r0 = r3.getId();
        if (isValidId(r0) == true) goto L5;
        return;
    L5:
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.badgeDrawables.get(r0), a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r3.setBadge(r2);
        return;
    }

    private void validateMenuItemId(int r2) {
        if (isValidId(r2) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r2 + " is not a valid view id");
    }

    public void buildMenuView() {
        removeAllViews();
        NavigationBarItemView[] r0 = this.buttons;
        if (r0 == null) goto L11;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        NavigationBarItemView r4 = r0[r3];
        if (r4 == null) goto L9;
        this.itemPool.release(r4);
        r4.clear();
    L9:
        r3 = r3 + 1;
    L11:
        if (this.menu.size() != 0) goto L14;
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.buttons = null;
        return;
    L14:
        removeUnusedBadges();
        this.buttons = new NavigationBarItemView[this.menu.size()];
        boolean r1 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r5 = 0;
    L16:
        if (r5 >= this.menu.size()) goto L32;
        this.presenter.setUpdateSuspended(true);
        this.menu.getItem(r5).setCheckable(true);
        this.presenter.setUpdateSuspended(false);
        NavigationBarItemView r6 = getNewItem();
        this.buttons[r5] = r6;
        r6.setIconTintList(this.itemIconTint);
        r6.setIconSize(this.itemIconSize);
        r6.setTextColor(this.itemTextColorDefault);
        r6.setTextAppearanceInactive(this.itemTextAppearanceInactive);
        r6.setTextAppearanceActive(this.itemTextAppearanceActive);
        r6.setTextColor(this.itemTextColorFromUser);
        int r7 = this.itemPaddingTop;
        if (r7 == (-1)) goto L20;
        r6.setItemPaddingTop(r7);
    L20:
        int r8 = this.itemPaddingBottom;
        if (r8 == (-1)) goto L23;
        r6.setItemPaddingBottom(r8);
    L23:
        r6.setActiveIndicatorWidth(this.itemActiveIndicatorWidth);
        r6.setActiveIndicatorHeight(this.itemActiveIndicatorHeight);
        r6.setActiveIndicatorMarginHorizontal(this.itemActiveIndicatorMarginHorizontal);
        r6.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        r6.setActiveIndicatorResizeable(this.itemActiveIndicatorResizeable);
        r6.setActiveIndicatorEnabled(this.itemActiveIndicatorEnabled);
        Drawable r9 = this.itemBackground;
        if (r9 == null) goto L26;
        r6.setItemBackground(r9);
    L27:
        r6.setShifting(r1);
        r6.setLabelVisibilityMode(this.labelVisibilityMode);
        MenuItemImpl r10 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(this.menu.getItem(r5), MenuItemImpl.class, "com.obric.memorydata.plugin");
        r6.initialize(r10, 0);
        r6.setItemPosition(r5);
        int r11 = r10.getItemId();
        r6.setOnTouchListener((View.OnTouchListener) ZeusTransformUtils.preCheckCast(this.onTouchListeners.get(r11), View.OnTouchListener.class, "com.obric.memorydata.plugin"));
        r6.setOnClickListener(this.onClickListener);
        int r12 = this.selectedItemId;
        if (r12 == 0) goto L31;
        if (r11 != r12) goto L31;
        this.selectedItemPosition = r5;
    L31:
        setBadgeIfNeeded(r6);
        addView(r6);
        r5 = r5 + 1;
        goto L16
    L26:
        r6.setItemBackground(this.itemBackgroundRes);
        goto L27
    L32:
        int r13 = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = r13;
        this.menu.getItem(r13).setChecked(true);
    }

    public ColorStateList createDefaultColorStateList(int r10) {
        TypedValue r0 = new TypedValue();
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().resolveAttribute(r10, r0, true) == true) goto L5;
        return null;
    L5:
        ColorStateList r11 = AppCompatResources.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r0.resourceId);
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().resolveAttribute(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.colorPrimary, "attr", "colorPrimary"), r0, true) == true) goto L8;
        return null;
    L8:
        int r9 = r0.data;
        int r1 = r11.getDefaultColor();
        int[] r5 = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{r5, CHECKED_STATE_SET, EMPTY_STATE_SET}, new int[]{r11.getColorForState(r5, r1), r9, r1});
    }

    public abstract NavigationBarItemView createNavigationBarItemView(Context r1);

    public NavigationBarItemView findItemView(int r5) {
        validateMenuItemId(r5);
        NavigationBarItemView[] r4 = this.buttons;
        if (r4 == null) goto L10;
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        NavigationBarItemView r2 = r4[r1];
        if (r2.getId() == r5) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        return r2;
    L14:
        return null;
    L10:
        return null;
    }

    public a getBadge(int r2) {
        return (a) ZeusTransformUtils.preCheckCast(this.badgeDrawables.get(r2), a.class, "com.obric.memorydata.plugin");
    }

    SparseArray<a> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.itemActiveIndicatorColor;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.itemActiveIndicatorEnabled;
    }

    public int getItemActiveIndicatorHeight() {
        return this.itemActiveIndicatorHeight;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.itemActiveIndicatorMarginHorizontal;
    }

    public l getItemActiveIndicatorShapeAppearance() {
        return this.itemActiveIndicatorShapeAppearance;
    }

    public int getItemActiveIndicatorWidth() {
        return this.itemActiveIndicatorWidth;
    }

    public Drawable getItemBackground() {
        NavigationBarItemView[] r0 = this.buttons;
        if (r0 == null) goto L9;
        if (r0.length <= 0) goto L9;
        return r0[0].getBackground();
    L9:
        return this.itemBackground;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    public int getItemIconSize() {
        return this.itemIconSize;
    }

    public int getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    public int getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    public MenuBuilder getMenu() {
        return this.menu;
    }

    a getOrCreateBadge(int r4) {
        validateMenuItemId(r4);
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.badgeDrawables.get(r4), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.badgeDrawables.put(r4, r0);
    L5:
        NavigationBarItemView r3 = findItemView(r4);
        if (r3 == null) goto L8;
        r3.setBadge(r0);
    L8:
        return r0;
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
    public void initialize(MenuBuilder r1) {
        this.menu = r1;
    }

    public boolean isItemActiveIndicatorResizeable() {
        return this.itemActiveIndicatorResizeable;
    }

    public boolean isShifting(int r3, int r4) {
        if (r3 == (-1)) goto L5;
        if (r3 != 0) goto L10;
        return true;
    L10:
        return false;
    L5:
        if (r4 <= 3) goto L10;
        return true;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r3) {
        super.onInitializeAccessibilityNodeInfo(r3);
        AccessibilityNodeInfoCompat.wrap(r3).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
    }

    void removeBadge(int r4) {
        validateMenuItemId(r4);
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.badgeDrawables.get(r4), a.class, "com.obric.memorydata.plugin");
        NavigationBarItemView r1 = findItemView(r4);
        if (r1 == null) goto L5;
        r1.removeBadge();
    L5:
        if (r0 == null) goto L8;
        this.badgeDrawables.remove(r4);
        return;
    }

    void restoreBadgeDrawables(SparseArray<a> r7) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= r7.size()) goto L9;
        int r2 = r7.keyAt(r1);
        if (this.badgeDrawables.indexOfKey(r2) >= 0) goto L8;
        this.badgeDrawables.append(r2, r7.get(r2));
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        NavigationBarItemView[] r8 = this.buttons;
        if (r8 == null) goto L14;
        int r3 = r8.length;
    L12:
        if (r0 >= r3) goto L19;
        NavigationBarItemView r4 = r8[r0];
        r4.setBadge((a) ZeusTransformUtils.preCheckCast(this.badgeDrawables.get(r4.getId()), a.class, "com.obric.memorydata.plugin"));
        r0 = r0 + 1;
        goto L12
    L19:
        return;
    }

    public void setIconTintList(ColorStateList r4) {
        this.itemIconTint = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setIconTintList(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorColor(ColorStateList r5) {
        this.itemActiveIndicatorColor = r5;
        NavigationBarItemView[] r6 = this.buttons;
        if (r6 == null) goto L7;
        int r0 = r6.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r6[r1].setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorEnabled(boolean r4) {
        this.itemActiveIndicatorEnabled = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setActiveIndicatorEnabled(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorHeight(int r4) {
        this.itemActiveIndicatorHeight = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setActiveIndicatorHeight(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorMarginHorizontal(int r4) {
        this.itemActiveIndicatorMarginHorizontal = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setActiveIndicatorMarginHorizontal(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorResizeable(boolean r4) {
        this.itemActiveIndicatorResizeable = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setActiveIndicatorResizeable(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorShapeAppearance(l r5) {
        this.itemActiveIndicatorShapeAppearance = r5;
        NavigationBarItemView[] r6 = this.buttons;
        if (r6 == null) goto L7;
        int r0 = r6.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r6[r1].setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemActiveIndicatorWidth(int r4) {
        this.itemActiveIndicatorWidth = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setActiveIndicatorWidth(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackground(Drawable r4) {
        this.itemBackground = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setItemBackground(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackgroundRes(int r4) {
        this.itemBackgroundRes = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setItemBackground(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemIconSize(int r4) {
        this.itemIconSize = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setIconSize(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemOnTouchListener(int r5, View.OnTouchListener r6) {
        View.OnTouchListener r7 = (View.OnTouchListener) ZeusTransformUtils.wrapperContextForParams(r6, View.OnTouchListener.class, "com.obric.memorydata.plugin");
        SparseArray<View.OnTouchListener> r0 = this.onTouchListeners;
        if (r7 != null) goto L5;
        r0.remove(r5);
    L6:
        NavigationBarItemView[] r4 = this.buttons;
        if (r4 == null) goto L14;
        int r1 = r4.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L18;
        NavigationBarItemView r3 = r4[r2];
        if (r3.getItemData().getItemId() != r5) goto L13;
        r3.setOnTouchListener(r7);
    L13:
        r2 = r2 + 1;
        goto L9
    L18:
        return;
    L14:
        return;
    L5:
        r0.put(r5, r7);
        goto L6
    }

    public void setItemPaddingBottom(int r4) {
        this.itemPaddingBottom = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setItemPaddingBottom(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemPaddingTop(int r4) {
        this.itemPaddingTop = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setItemPaddingTop(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemTextAppearanceActive(int r6) {
        this.itemTextAppearanceActive = r6;
        NavigationBarItemView[] r0 = this.buttons;
        if (r0 == null) goto L10;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        NavigationBarItemView r3 = r0[r2];
        r3.setTextAppearanceActive(r6);
        ColorStateList r4 = this.itemTextColorFromUser;
        if (r4 == null) goto L9;
        r3.setTextColor(r4);
    L9:
        r2 = r2 + 1;
        goto L5
    L14:
        return;
    }

    public void setItemTextAppearanceInactive(int r6) {
        this.itemTextAppearanceInactive = r6;
        NavigationBarItemView[] r0 = this.buttons;
        if (r0 == null) goto L10;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        NavigationBarItemView r3 = r0[r2];
        r3.setTextAppearanceInactive(r6);
        ColorStateList r4 = this.itemTextColorFromUser;
        if (r4 == null) goto L9;
        r3.setTextColor(r4);
    L9:
        r2 = r2 + 1;
        goto L5
    L14:
        return;
    }

    public void setItemTextColor(ColorStateList r4) {
        this.itemTextColorFromUser = r4;
        NavigationBarItemView[] r3 = this.buttons;
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].setTextColor(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void setLabelVisibilityMode(int r1) {
        this.labelVisibilityMode = r1;
    }

    public void setPresenter(NavigationBarPresenter r1) {
        this.presenter = r1;
    }

    void tryRestoreSelectedItemId(int r5) {
        int r0 = this.menu.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        MenuItem r2 = this.menu.getItem(r1);
        if (r5 == r2.getItemId()) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        this.selectedItemId = r5;
        this.selectedItemPosition = r1;
        r2.setChecked(true);
        return;
    }

    public void updateMenuView() {
        MenuBuilder r0 = this.menu;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.buttons == null) goto L30;
        int r1 = r0.size();
        if (r1 == this.buttons.length) goto L11;
        buildMenuView();
        return;
    L11:
        int r2 = this.selectedItemId;
        int r3 = 0;
    L12:
        if (r3 >= r1) goto L18;
        MenuItem r4 = this.menu.getItem(r3);
        if (r4.isChecked() == false) goto L16;
        this.selectedItemId = r4.getItemId();
        this.selectedItemPosition = r3;
    L16:
        r3 = r3 + 1;
        goto L12
    L18:
        if (r2 == this.selectedItemId) goto L22;
        TransitionSet r5 = this.set;
        if (r5 == null) goto L22;
        TransitionManager.beginDelayedTransition(this, r5);
    L22:
        boolean r6 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r7 = 0;
    L23:
        if (r7 >= r1) goto L31;
        this.presenter.setUpdateSuspended(true);
        this.buttons[r7].setLabelVisibilityMode(this.labelVisibilityMode);
        this.buttons[r7].setShifting(r6);
        this.buttons[r7].initialize((MenuItemImpl) ZeusTransformUtils.preCheckCast(this.menu.getItem(r7), MenuItemImpl.class, "com.obric.memorydata.plugin"), 0);
        this.presenter.setUpdateSuspended(false);
        r7 = r7 + 1;
        goto L23
    L31:
        return;
    }
}
