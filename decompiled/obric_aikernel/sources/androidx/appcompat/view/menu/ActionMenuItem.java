package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionMenuItem implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private Context mContext;
    private int mFlags;
    private final int mGroup;
    private boolean mHasIconTint;
    private boolean mHasIconTintMode;
    private Drawable mIconDrawable;
    private ColorStateList mIconTintList;
    private PorterDuff.Mode mIconTintMode;
    private final int mId;
    private Intent mIntent;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    public ActionMenuItem(Context r10, int r11, int r12, int r13, int r14, CharSequence r15) {
        this.mShortcutNumericModifiers = 4096;
        this.mShortcutAlphabeticModifiers = 4096;
        this.mIconTintList = null;
        this.mIconTintMode = null;
        this.mHasIconTint = false;
        this.mHasIconTintMode = false;
        this.mFlags = 16;
        this.mContext = r10;
        this.mId = r12;
        this.mGroup = r11;
        this.mOrdering = r14;
        this.mTitle = r15;
    }

    private void applyIconTint() {
        Drawable r10 = this.mIconDrawable;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mHasIconTint == false) goto L7;
    L8:
        Drawable r11 = DrawableCompat.wrap(r10);
        this.mIconDrawable = r11;
        Drawable r12 = r11.mutate();
        this.mIconDrawable = r12;
        if (this.mHasIconTint == false) goto L12;
        DrawableCompat.setTintList(r12, this.mIconTintList);
    L12:
        if (this.mHasIconTintMode == false) goto L17;
        DrawableCompat.setTintMode(this.mIconDrawable, this.mIconTintMode);
        return;
    L17:
        return;
    L7:
        if (this.mHasIconTintMode == true) goto L8;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
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
        return this.mIconDrawable;
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
    public int getItemId() {
        return this.mId;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
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
        return this.mOrdering;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public androidx.core.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence r10 = this.mTitleCondensed;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.mTitle;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener r10 = this.mClickListener;
        if (r10 != null) goto L5;
    L7:
        Intent r11 = this.mIntent;
        if (r11 == null) goto L11;
        this.mContext.startActivity(r11);
        return true;
    L11:
        return false;
    L5:
        if (r10.onMenuItemClick(this) == false) goto L7;
        return true;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.mFlags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.mFlags & 2) == 0) goto L5;
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

    @Override // android.view.MenuItem
    public boolean isVisible() {
        if ((this.mFlags & 8) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresActionButton() {
        return true;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresOverflow() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider r10) {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public SupportMenuItem setActionView(View r10) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r10) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(r10);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setAlphabeticShortcut(char r10, int r11) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(r10);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean r10) {
        int r11 = this.mFlags & (-2);
        this.mFlags = (r10 ? 1 : 0) | r11;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean r10) {
        int r11 = this.mFlags & (-3);
        if (r10 == false) goto L5;
        int r12 = 2;
    L6:
        this.mFlags = r12 | r11;
        return this;
    L5:
        r12 = 0;
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
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean r10) {
        int r11 = this.mFlags & (-17);
        if (r10 == false) goto L5;
        int r12 = 16;
    L6:
        this.mFlags = r12 | r11;
        return this;
    L5:
        r12 = 0;
        goto L6
    }

    public ActionMenuItem setExclusiveCheckable(boolean r10) {
        int r11 = this.mFlags & (-5);
        if (r10 == false) goto L5;
        int r12 = 4;
    L6:
        this.mFlags = r12 | r11;
        return this;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int r10) {
        this.mIconDrawable = ContextCompat.getDrawable(this.mContext, r10);
        applyIconTint();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable r10) {
        this.mIconDrawable = r10;
        applyIconTint();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList r10) {
        this.mIconTintList = r10;
        this.mHasIconTint = true;
        applyIconTint();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode r10) {
        this.mIconTintMode = r10;
        this.mHasIconTintMode = true;
        applyIconTint();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent r10) {
        this.mIntent = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r10) {
        this.mShortcutNumericChar = r10;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setNumericShortcut(char r10, int r11) {
        this.mShortcutNumericChar = r10;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r10) {
        throw new UnsupportedOperationException();
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
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setShortcut(char r10, char r11, int r12, int r13) {
        this.mShortcutNumericChar = r10;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r12);
        this.mShortcutAlphabeticChar = Character.toLowerCase(r11);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r13);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int r10) {
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

    @Override // androidx.core.internal.view.SupportMenuItem
    @NonNull
    public SupportMenuItem setSupportActionProvider(androidx.core.view.ActionProvider r10) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int r10) {
        this.mTitle = this.mContext.getResources().getString(r10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence r10) {
        this.mTitle = r10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence r10) {
        this.mTitleCondensed = r10;
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
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean r10) {
        int r11 = 8;
        int r12 = this.mFlags & 8;
        if (r10 == false) goto L5;
        r11 = 0;
    L5:
        this.mFlags = r12 | r11;
        return this;
    }
}
