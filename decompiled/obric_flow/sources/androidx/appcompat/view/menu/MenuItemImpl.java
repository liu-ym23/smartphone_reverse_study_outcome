package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class MenuItemImpl implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private int mFlags;
    private final int mGroup;
    private boolean mHasIconTint;
    private boolean mHasIconTintMode;
    private Drawable mIconDrawable;
    private int mIconResId;
    private ColorStateList mIconTintList;
    private PorterDuff.Mode mIconTintMode;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded;
    private Runnable mItemCallback;
    MenuBuilder mMenu;
    private ContextMenu.ContextMenuInfo mMenuInfo;
    private boolean mNeedToApplyIconTint;
    private MenuItem.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    public MenuItemImpl(MenuBuilder r5, int r10, int r11, int r12, int r13, CharSequence r14, int r15) {
        this.mShortcutNumericModifiers = 4096;
        this.mShortcutAlphabeticModifiers = 4096;
        this.mIconResId = 0;
        this.mIconTintList = null;
        this.mIconTintMode = null;
        this.mHasIconTint = false;
        this.mHasIconTintMode = false;
        this.mNeedToApplyIconTint = false;
        this.mFlags = 16;
        this.mIsActionViewExpanded = false;
        this.mMenu = r5;
        this.mId = r11;
        this.mGroup = r10;
        this.mCategoryOrder = r12;
        this.mOrdering = r13;
        this.mTitle = r14;
        this.mShowAsAction = r15;
    }

    private static void appendModifier(StringBuilder r5, int r10, int r11, String r12) {
        if ((r10 & r11) != r11) goto L6;
        r5.append(r12);
        return;
    }

    private Drawable applyIconTintIfNecessary(Drawable r5) {
        if (r5 != null) goto L4;
    L16:
        return r5;
    L4:
        if (this.mNeedToApplyIconTint == false) goto L16;
        if (this.mHasIconTint == false) goto L8;
    L9:
        r5 = DrawableCompat.wrap(r5).mutate();
        if (this.mHasIconTint == false) goto L13;
        DrawableCompat.setTintList(r5, this.mIconTintList);
    L13:
        if (this.mHasIconTintMode == false) goto L15;
        DrawableCompat.setTintMode(r5, this.mIconTintMode);
    L15:
        this.mNeedToApplyIconTint = false;
        goto L16
    L8:
        if (this.mHasIconTintMode == false) goto L16;
        goto L9
    }

    public void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.mShowAsAction & 8) != 0) goto L6;
        return false;
    L6:
        if (this.mActionView != null) goto L9;
        return true;
    L9:
        MenuItem.OnActionExpandListener r5 = this.mOnActionExpandListener;
        if (r5 == null) goto L16;
        if (r5.onMenuItemActionCollapse(this) == true) goto L16;
        return false;
    L16:
        return this.mMenu.collapseItemActionView(this);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (hasCollapsibleActionView() == true) goto L5;
        return false;
    L5:
        MenuItem.OnActionExpandListener r5 = this.mOnActionExpandListener;
        if (r5 == null) goto L12;
        if (r5.onMenuItemActionExpand(this) == true) goto L12;
        return false;
    L12:
        return this.mMenu.expandItemActionView(this);
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        View r5 = this.mActionView;
        if (r5 == null) goto L5;
        return r5;
    L5:
        ActionProvider r10 = this.mActionProvider;
        if (r10 == null) goto L9;
        View r11 = r10.onCreateActionView(this);
        this.mActionView = r11;
        return r11;
    L9:
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    public Runnable getCallback() {
        return this.mItemCallback;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.mGroup;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable r5 = this.mIconDrawable;
        if (r5 == null) goto L7;
        return applyIconTintIfNecessary(r5);
    L7:
        if (this.mIconResId == 0) goto L10;
        Drawable r10 = AppCompatResources.getDrawable(this.mMenu.getContext(), this.mIconResId);
        this.mIconResId = 0;
        this.mIconDrawable = r10;
        return applyIconTintIfNecessary(r10);
    L10:
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.mIntent;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.mId;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.mCategoryOrder;
    }

    public int getOrdering() {
        return this.mOrdering;
    }

    public char getShortcut() {
        if (this.mMenu.isQwertyMode() == false) goto L6;
        return this.mShortcutAlphabeticChar;
    L6:
        return this.mShortcutNumericChar;
    }

    public String getShortcutLabel() {
        char r5 = getShortcut();
        if (r5 != 0) goto L6;
        return "";
    L6:
        Resources r10 = this.mMenu.getContext().getResources();
        StringBuilder r11 = new StringBuilder();
        if (ViewConfiguration.get(this.mMenu.getContext()).hasPermanentMenuKey() == false) goto L10;
        r11.append(r10.getString(R.string.abc_prepend_shortcut_label));
    L10:
        if (this.mMenu.isQwertyMode() == false) goto L12;
        int r12 = this.mShortcutAlphabeticModifiers;
    L13:
        appendModifier(r11, r12, 65536, r10.getString(R.string.abc_menu_meta_shortcut_label));
        appendModifier(r11, r12, 4096, r10.getString(R.string.abc_menu_ctrl_shortcut_label));
        appendModifier(r11, r12, 2, r10.getString(R.string.abc_menu_alt_shortcut_label));
        appendModifier(r11, r12, 1, r10.getString(R.string.abc_menu_shift_shortcut_label));
        appendModifier(r11, r12, 4, r10.getString(R.string.abc_menu_sym_shortcut_label));
        appendModifier(r11, r12, 8, r10.getString(R.string.abc_menu_function_shortcut_label));
        if (r5 != '\b') goto L16;
        r11.append(r10.getString(R.string.abc_menu_delete_shortcut_label));
    L24:
        return r11.toString();
    L16:
        if (r5 != '\n') goto L18;
        r11.append(r10.getString(R.string.abc_menu_enter_shortcut_label));
        goto L24
    L18:
        if (r5 == ' ') goto L20;
        r11.append(r5);
        goto L24
    L20:
        r11.append(r10.getString(R.string.abc_menu_space_shortcut_label));
        goto L24
    L12:
        r12 = this.mShortcutNumericModifiers;
        goto L13
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence r5 = this.mTitleCondensed;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return this.mTitle;
    }

    public CharSequence getTitleForItemView(MenuView.ItemView r5) {
        if (r5 == null) goto L7;
        if (r5.prefersCondensedTitle() == false) goto L7;
        return getTitleCondensed();
    L7:
        return getTitle();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public boolean hasCollapsibleActionView() {
        if ((this.mShowAsAction & 8) != 0) goto L5;
        return false;
    L5:
        if (this.mActionView != null) goto L10;
        ActionProvider r5 = this.mActionProvider;
        if (r5 == null) goto L10;
        this.mActionView = r5.onCreateActionView(this);
    L10:
        if (this.mActionView == null) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        if (this.mSubMenu == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener r5 = this.mClickListener;
        if (r5 != null) goto L5;
    L7:
        MenuBuilder r10 = this.mMenu;
        if (r10.dispatchMenuItemSelected(r10, this) == false) goto L10;
        return true;
    L10:
        Runnable r11 = this.mItemCallback;
        if (r11 == null) goto L15;
        r11.run();
        return true;
    L15:
        if (this.mIntent != null) goto L27;
    L20:
        ActionProvider r12 = this.mActionProvider;
        if (r12 != null) goto L23;
        return false;
    L23:
        if (r12.onPerformDefaultAction() == false) goto L29;
        return true;
    L29:
        return false;
    L27:
        this.mMenu.getContext().startActivity(this.mIntent);     // Catch: ActivityNotFoundException -> L18
        return true;
    L18:
        e = move-exception;
        Log.e(TAG, "Can't find activity to handle intent; ignoring", e);
        goto L20
    L5:
        if (r5.onMenuItemClick(this) == false) goto L7;
        return true;
    }

    public boolean isActionButton() {
        if ((this.mFlags & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.mFlags & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.mFlags & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.mFlags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isExclusiveCheckable() {
        if ((this.mFlags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider r5 = this.mActionProvider;
        if (r5 == null) goto L13;
        if (r5.overridesItemVisibility() == false) goto L13;
        if ((this.mFlags & 8) == 0) goto L9;
        return false;
    L9:
        if (this.mActionProvider.isVisible() == true) goto L11;
        return false;
    L11:
        return true;
    L13:
        if ((this.mFlags & 8) == 0) goto L15;
        return false;
    L15:
        return true;
    }

    public boolean requestsActionButton() {
        if ((this.mShowAsAction & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresActionButton() {
        if ((this.mShowAsAction & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresOverflow() {
        if (requiresActionButton() == false) goto L5;
    L7:
        return false;
    L5:
        if (requestsActionButton() == true) goto L7;
        return true;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider r5) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public /* bridge */ /* synthetic */ MenuItem setActionView(int r5) {
        return setActionView(r5);
    }

    public void setActionViewExpanded(boolean r5) {
        this.mIsActionViewExpanded = r5;
        this.mMenu.onItemsChanged(false);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r5) {
        if (this.mShortcutAlphabeticChar != r5) goto L5;
        return this;
    L5:
        this.mShortcutAlphabeticChar = Character.toLowerCase(r5);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setCallback(Runnable r5) {
        this.mItemCallback = r5;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean r5) {
        int r10 = this.mFlags;
        int r11 = r5 ? 1 : 0;
        int r12 = r11 | (r10 & (-2));
        this.mFlags = r12;
        if (r10 == r12) goto L5;
        this.mMenu.onItemsChanged(false);
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean r5) {
        if ((this.mFlags & 4) == 0) goto L5;
        this.mMenu.setExclusiveItemChecked(this);
    L6:
        return this;
    L5:
        setCheckedInt(r5);
        goto L6
    }

    public void setCheckedInt(boolean r5) {
        int r10 = this.mFlags;
        int r11 = r10 & (-3);
        if (r5 == false) goto L5;
        int r12 = 2;
    L6:
        int r13 = r12 | r11;
        this.mFlags = r13;
        if (r10 == r13) goto L10;
        this.mMenu.onItemsChanged(false);
        return;
    L10:
        return;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence r5) {
        return setContentDescription(r5);
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean r5) {
        if (r5 == false) goto L4;
        this.mFlags |= 16;
    L5:
        this.mMenu.onItemsChanged(false);
        return this;
    L4:
        this.mFlags &= -17;
        goto L5
    }

    public void setExclusiveCheckable(boolean r5) {
        int r10 = this.mFlags & (-5);
        if (r5 == false) goto L5;
        int r11 = 4;
    L6:
        this.mFlags = r11 | r10;
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable r5) {
        this.mIconResId = 0;
        this.mIconDrawable = r5;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList r5) {
        this.mIconTintList = r5;
        this.mHasIconTint = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode r5) {
        this.mIconTintMode = r5;
        this.mHasIconTintMode = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent r5) {
        this.mIntent = r5;
        return this;
    }

    public void setIsActionButton(boolean r5) {
        if (r5 == false) goto L4;
        this.mFlags |= 32;
        return;
    L4:
        this.mFlags &= -33;
    }

    public void setMenuInfo(ContextMenu.ContextMenuInfo r5) {
        this.mMenuInfo = r5;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r5) {
        if (this.mShortcutNumericChar != r5) goto L5;
        return this;
    L5:
        this.mShortcutNumericChar = r5;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r5) {
        this.mOnActionExpandListener = r5;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r5) {
        this.mClickListener = r5;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r5, char r10) {
        this.mShortcutNumericChar = r5;
        this.mShortcutAlphabeticChar = Character.toLowerCase(r10);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int r5) {
        int r10 = r5 & 3;
        if (r10 != 0) goto L5;
    L11:
        this.mShowAsAction = r5;
        this.mMenu.onItemActionRequestChanged(this);
        return;
    L5:
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L11;
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int r5) {
        return setShowAsActionFlags(r5);
    }

    public void setSubMenu(SubMenuBuilder r5) {
        this.mSubMenu = r5;
        r5.setHeaderTitle(getTitle());
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    @NonNull
    public SupportMenuItem setSupportActionProvider(ActionProvider r5) {
        ActionProvider r10 = this.mActionProvider;
        if (r10 == null) goto L5;
        r10.reset();
    L5:
        this.mActionView = null;
        this.mActionProvider = r5;
        this.mMenu.onItemsChanged(true);
        ActionProvider r11 = this.mActionProvider;
        if (r11 == null) goto L8;
        r11.setVisibilityListener(new AnonymousClass1(this));
    L8:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence r5) {
        this.mTitle = r5;
        this.mMenu.onItemsChanged(false);
        SubMenuBuilder r10 = this.mSubMenu;
        if (r10 == null) goto L5;
        r10.setHeaderTitle(r5);
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence r5) {
        this.mTitleCondensed = r5;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence r5) {
        return setTooltipText(r5);
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean r5) {
        if (setVisibleInt(r5) == false) goto L5;
        this.mMenu.onItemVisibleChanged(this);
    L5:
        return this;
    }

    public boolean setVisibleInt(boolean r5) {
        int r10 = this.mFlags;
        int r11 = r10 & (-9);
        if (r5 == false) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 | r11;
        this.mFlags = r13;
        if (r10 == r13) goto L10;
        return true;
    L10:
        return false;
    L5:
        r12 = 8;
        goto L6
    }

    public boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }

    public boolean shouldShowShortcut() {
        if (this.mMenu.isShortcutsVisible() == true) goto L5;
    L7:
        return false;
    L5:
        if (getShortcut() == 0) goto L7;
        return true;
    }

    public boolean showsTextAsAction() {
        if ((this.mShowAsAction & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        CharSequence r5 = this.mTitle;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.toString();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public /* bridge */ /* synthetic */ MenuItem setActionView(View r5) {
        return setActionView(r5);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setContentDescription(CharSequence r5) {
        this.mContentDescription = r5;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setShowAsActionFlags(int r5) {
        setShowAsAction(r5);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setTooltipText(CharSequence r5) {
        this.mTooltipText = r5;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setActionView(View r5) {
        this.mActionView = r5;
        this.mActionProvider = null;
        if (r5 != null) goto L5;
    L9:
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    L5:
        if (r5.getId() != (-1)) goto L9;
        int r10 = this.mId;
        if (r10 <= 0) goto L9;
        r5.setId(r10);
        goto L9
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setAlphabeticShortcut(char r5, int r10) {
        if (this.mShortcutAlphabeticChar == r5) goto L5;
    L7:
        this.mShortcutAlphabeticChar = Character.toLowerCase(r5);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r10);
        this.mMenu.onItemsChanged(false);
        return this;
    L5:
        if (this.mShortcutAlphabeticModifiers != r10) goto L7;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setNumericShortcut(char r5, int r10) {
        if (this.mShortcutNumericChar == r5) goto L5;
    L7:
        this.mShortcutNumericChar = r5;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r10);
        this.mMenu.onItemsChanged(false);
        return this;
    L5:
        if (this.mShortcutNumericModifiers != r10) goto L7;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setShortcut(char r5, char r10, int r11, int r12) {
        this.mShortcutNumericChar = r5;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r11);
        this.mShortcutAlphabeticChar = Character.toLowerCase(r10);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r12);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int r5) {
        this.mIconDrawable = null;
        this.mIconResId = r5;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int r5) {
        return setTitle(this.mMenu.getContext().getString(r5));
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setActionView(int r5) {
        Context r10 = this.mMenu.getContext();
        setActionView(LayoutInflater.from(r10).inflate(r5, new LinearLayout(r10), false));
        return this;
    }
}
