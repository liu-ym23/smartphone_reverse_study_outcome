package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
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

    MenuItemImpl(MenuBuilder r10, int r11, int r12, int r13, int r14, CharSequence r15, int r16) {
        this.mShortcutNumericModifiers = 4096;
        this.mShortcutAlphabeticModifiers = 4096;
        this.mIconResId = 0;
        this.mIconTintList = null;
        this.mIconTintMode = null;
        this.mHasIconTint = false;
        this.mHasIconTintMode = false;
        this.mNeedToApplyIconTint = false;
        this.mFlags = 16;
        this.mShowAsAction = 0;
        this.mIsActionViewExpanded = false;
        this.mMenu = r10;
        this.mId = r12;
        this.mGroup = r11;
        this.mCategoryOrder = r13;
        this.mOrdering = r14;
        this.mTitle = r15;
        this.mShowAsAction = r16;
    }

    private static void appendModifier(StringBuilder r10, int r11, int r12, String r13) {
        if ((r11 & r12) != r12) goto L6;
        r10.append(r13);
        return;
    }

    private Drawable applyIconTintIfNecessary(Drawable r10) {
        if (r10 != null) goto L4;
    L16:
        return r10;
    L4:
        if (this.mNeedToApplyIconTint == false) goto L16;
        if (this.mHasIconTint == false) goto L8;
    L9:
        r10 = DrawableCompat.wrap(r10).mutate();
        if (this.mHasIconTint == false) goto L13;
        DrawableCompat.setTintList(r10, this.mIconTintList);
    L13:
        if (this.mHasIconTintMode == false) goto L15;
        DrawableCompat.setTintMode(r10, this.mIconTintMode);
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
        MenuItem.OnActionExpandListener r10 = this.mOnActionExpandListener;
        if (r10 == null) goto L16;
        if (r10.onMenuItemActionCollapse(this) == true) goto L16;
        return false;
    L16:
        return this.mMenu.collapseItemActionView(this);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (hasCollapsibleActionView() == true) goto L5;
        return false;
    L5:
        MenuItem.OnActionExpandListener r10 = this.mOnActionExpandListener;
        if (r10 == null) goto L12;
        if (r10.onMenuItemActionExpand(this) == true) goto L12;
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
        View r10 = this.mActionView;
        if (r10 == null) goto L5;
        return r10;
    L5:
        ActionProvider r11 = this.mActionProvider;
        if (r11 == null) goto L9;
        View r12 = r11.onCreateActionView(this);
        this.mActionView = r12;
        return r12;
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

    Runnable getCallback() {
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
        Drawable r10 = this.mIconDrawable;
        if (r10 == null) goto L7;
        return applyIconTintIfNecessary(r10);
    L7:
        if (this.mIconResId == 0) goto L10;
        Drawable r11 = AppCompatResources.getDrawable(this.mMenu.getContext(), this.mIconResId);
        this.mIconResId = 0;
        this.mIconDrawable = r11;
        return applyIconTintIfNecessary(r11);
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

    char getShortcut() {
        if (this.mMenu.isQwertyMode() == false) goto L6;
        return this.mShortcutAlphabeticChar;
    L6:
        return this.mShortcutNumericChar;
    }

    String getShortcutLabel() {
        char r10 = getShortcut();
        if (r10 != 0) goto L6;
        return "";
    L6:
        Resources r11 = this.mMenu.getContext().getResources();
        StringBuilder r12 = new StringBuilder();
        if (ViewConfiguration.get(this.mMenu.getContext()).hasPermanentMenuKey() == false) goto L10;
        r12.append(r11.getString(R.string.abc_prepend_shortcut_label));
    L10:
        if (this.mMenu.isQwertyMode() == false) goto L12;
        int r13 = this.mShortcutAlphabeticModifiers;
    L13:
        appendModifier(r12, r13, 65536, r11.getString(R.string.abc_menu_meta_shortcut_label));
        appendModifier(r12, r13, 4096, r11.getString(R.string.abc_menu_ctrl_shortcut_label));
        appendModifier(r12, r13, 2, r11.getString(R.string.abc_menu_alt_shortcut_label));
        appendModifier(r12, r13, 1, r11.getString(R.string.abc_menu_shift_shortcut_label));
        appendModifier(r12, r13, 4, r11.getString(R.string.abc_menu_sym_shortcut_label));
        appendModifier(r12, r13, 8, r11.getString(R.string.abc_menu_function_shortcut_label));
        if (r10 != '\b') goto L16;
        int r14 = R.string.abc_menu_delete_shortcut_label;
    L23:
        r12.append(r11.getString(r14));
    L25:
        return r12.toString();
    L16:
        if (r10 != '\n') goto L18;
        r14 = R.string.abc_menu_enter_shortcut_label;
        goto L23
    L18:
        if (r10 == ' ') goto L20;
        r12.append(r10);
        goto L25
    L20:
        r14 = R.string.abc_menu_space_shortcut_label;
        goto L23
    L12:
        r13 = this.mShortcutNumericModifiers;
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
        CharSequence r10 = this.mTitleCondensed;
        if (r10 != null) goto L7;
        r10 = this.mTitle;
    L7:
        if (Build.VERSION.SDK_INT >= 18) goto L13;
        if (r10 == null) goto L13;
        if ((r10 instanceof String) == true) goto L13;
        return r10.toString();
    L13:
        return r10;
    }

    CharSequence getTitleForItemView(MenuView.ItemView r10) {
        if (r10 == null) goto L7;
        if (r10.prefersCondensedTitle() == false) goto L7;
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
        ActionProvider r10 = this.mActionProvider;
        if (r10 == null) goto L10;
        this.mActionView = r10.onCreateActionView(this);
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
        MenuItem.OnMenuItemClickListener r10 = this.mClickListener;
        if (r10 != null) goto L5;
    L7:
        MenuBuilder r11 = this.mMenu;
        if (r11.dispatchMenuItemSelected(r11, this) == false) goto L10;
        return true;
    L10:
        Runnable r12 = this.mItemCallback;
        if (r12 == null) goto L15;
        r12.run();
        return true;
    L15:
        if (this.mIntent != null) goto L27;
    L20:
        ActionProvider r13 = this.mActionProvider;
        if (r13 != null) goto L23;
        return false;
    L23:
        if (r13.onPerformDefaultAction() == false) goto L29;
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
        if (r10.onMenuItemClick(this) == false) goto L7;
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
        ActionProvider r10 = this.mActionProvider;
        if (r10 == null) goto L14;
        if (r10.overridesItemVisibility() == false) goto L14;
        if ((this.mFlags & 8) != 0) goto L12;
        if (this.mActionProvider.isVisible() == false) goto L12;
        return true;
    L12:
        return false;
    L14:
        if ((this.mFlags & 8) != 0) goto L17;
        return true;
    L17:
        return false;
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
    public MenuItem setActionProvider(android.view.ActionProvider r10) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public /* bridge */ /* synthetic */ MenuItem setActionView(int r10) {
        return setActionView(r10);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public /* bridge */ /* synthetic */ MenuItem setActionView(View r10) {
        return setActionView(r10);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setActionView(int r10) {
        Context r11 = this.mMenu.getContext();
        setActionView(LayoutInflater.from(r11).inflate(r10, new LinearLayout(r11), false));
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setActionView(View r10) {
        this.mActionView = r10;
        this.mActionProvider = null;
        if (r10 != null) goto L5;
    L9:
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    L5:
        if (r10.getId() != (-1)) goto L9;
        int r11 = this.mId;
        if (r11 <= 0) goto L9;
        r10.setId(r11);
        goto L9
    }

    public void setActionViewExpanded(boolean r10) {
        this.mIsActionViewExpanded = r10;
        this.mMenu.onItemsChanged(false);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r10) {
        if (this.mShortcutAlphabeticChar != r10) goto L5;
        return this;
    L5:
        this.mShortcutAlphabeticChar = Character.toLowerCase(r10);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setAlphabeticShortcut(char r10, int r11) {
        if (this.mShortcutAlphabeticChar == r10) goto L5;
    L7:
        this.mShortcutAlphabeticChar = Character.toLowerCase(r10);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r11);
        this.mMenu.onItemsChanged(false);
        return this;
    L5:
        if (this.mShortcutAlphabeticModifiers != r11) goto L7;
        return this;
    }

    public MenuItem setCallback(Runnable r10) {
        this.mItemCallback = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean r10) {
        int r11 = this.mFlags;
        int r12 = r10 ? 1 : 0;
        int r13 = r12 | (r11 & (-2));
        this.mFlags = r13;
        if (r11 == r13) goto L5;
        this.mMenu.onItemsChanged(false);
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean r10) {
        if ((this.mFlags & 4) == 0) goto L5;
        this.mMenu.setExclusiveItemChecked(this);
    L6:
        return this;
    L5:
        setCheckedInt(r10);
        goto L6
    }

    void setCheckedInt(boolean r10) {
        int r11 = this.mFlags;
        int r12 = r11 & (-3);
        if (r10 == false) goto L5;
        int r13 = 2;
    L6:
        int r14 = r13 | r12;
        this.mFlags = r14;
        if (r11 == r14) goto L10;
        this.mMenu.onItemsChanged(false);
        return;
    L10:
        return;
    L5:
        r13 = 0;
        goto L6
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence r10) {
        return setContentDescription(r10);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setContentDescription(CharSequence r10) {
        this.mContentDescription = r10;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean r10) {
        if (r10 == false) goto L4;
        int r11 = this.mFlags | 16;
    L5:
        this.mFlags = r11;
        this.mMenu.onItemsChanged(false);
        return this;
    L4:
        r11 = this.mFlags & (-17);
        goto L5
    }

    public void setExclusiveCheckable(boolean r10) {
        int r11 = this.mFlags & (-5);
        if (r10 == false) goto L5;
        int r12 = 4;
    L6:
        this.mFlags = r12 | r11;
        return;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int r10) {
        this.mIconDrawable = null;
        this.mIconResId = r10;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable r10) {
        this.mIconResId = 0;
        this.mIconDrawable = r10;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList r10) {
        this.mIconTintList = r10;
        this.mHasIconTint = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode r10) {
        this.mIconTintMode = r10;
        this.mHasIconTintMode = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent r10) {
        this.mIntent = r10;
        return this;
    }

    public void setIsActionButton(boolean r10) {
        if (r10 == false) goto L4;
        int r11 = this.mFlags | 32;
    L5:
        this.mFlags = r11;
        return;
    L4:
        r11 = this.mFlags & (-33);
        goto L5
    }

    void setMenuInfo(ContextMenu.ContextMenuInfo r10) {
        this.mMenuInfo = r10;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r10) {
        if (this.mShortcutNumericChar != r10) goto L5;
        return this;
    L5:
        this.mShortcutNumericChar = r10;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setNumericShortcut(char r10, int r11) {
        if (this.mShortcutNumericChar == r10) goto L5;
    L7:
        this.mShortcutNumericChar = r10;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r11);
        this.mMenu.onItemsChanged(false);
        return this;
    L5:
        if (this.mShortcutNumericModifiers != r11) goto L7;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r10) {
        this.mOnActionExpandListener = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r10) {
        this.mClickListener = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r10, char r11) {
        this.mShortcutNumericChar = r10;
        this.mShortcutAlphabeticChar = Character.toLowerCase(r11);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setShortcut(char r10, char r11, int r12, int r13) {
        this.mShortcutNumericChar = r10;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r12);
        this.mShortcutAlphabeticChar = Character.toLowerCase(r11);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r13);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int r10) {
        int r11 = r10 & 3;
        if (r11 != 0) goto L5;
    L11:
        this.mShowAsAction = r10;
        this.mMenu.onItemActionRequestChanged(this);
        return;
    L5:
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L11;
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int r10) {
        return setShowAsActionFlags(r10);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setShowAsActionFlags(int r10) {
        setShowAsAction(r10);
        return this;
    }

    public void setSubMenu(SubMenuBuilder r10) {
        this.mSubMenu = r10;
        r10.setHeaderTitle(getTitle());
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    @NonNull
    public SupportMenuItem setSupportActionProvider(ActionProvider r10) {
        ActionProvider r11 = this.mActionProvider;
        if (r11 == null) goto L5;
        r11.reset();
    L5:
        this.mActionView = null;
        this.mActionProvider = r10;
        this.mMenu.onItemsChanged(true);
        ActionProvider r12 = this.mActionProvider;
        if (r12 == null) goto L8;
        r12.setVisibilityListener(new AnonymousClass1(this));
    L8:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int r10) {
        return setTitle(this.mMenu.getContext().getString(r10));
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence r10) {
        this.mTitle = r10;
        this.mMenu.onItemsChanged(false);
        SubMenuBuilder r11 = this.mSubMenu;
        if (r11 == null) goto L5;
        r11.setHeaderTitle(r10);
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence r10) {
        this.mTitleCondensed = r10;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence r10) {
        return setTooltipText(r10);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setTooltipText(CharSequence r10) {
        this.mTooltipText = r10;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean r10) {
        if (setVisibleInt(r10) == false) goto L5;
        this.mMenu.onItemVisibleChanged(this);
    L5:
        return this;
    }

    boolean setVisibleInt(boolean r10) {
        int r11 = this.mFlags;
        int r12 = r11 & (-9);
        if (r10 == false) goto L5;
        int r13 = 0;
    L6:
        int r14 = r13 | r12;
        this.mFlags = r14;
        if (r11 == r14) goto L10;
        return true;
    L10:
        return false;
    L5:
        r13 = 8;
        goto L6
    }

    public boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }

    boolean shouldShowShortcut() {
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
        CharSequence r10 = this.mTitle;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.toString();
    }
}
