package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewConfigurationCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuBuilder implements SupportMenu {
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder = null;
    private ArrayList<MenuItemImpl> mActionItems;
    private Callback mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private int mDefaultShowAsAction;
    private MenuItemImpl mExpandedItem;
    private boolean mGroupDividerEnabled;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mIsActionItemsStale;
    private boolean mIsClosing;
    private boolean mIsVisibleItemsStale;
    private ArrayList<MenuItemImpl> mItems;
    private boolean mItemsChangedWhileDispatchPrevented;
    private ArrayList<MenuItemImpl> mNonActionItems;
    private boolean mOptionalIconsVisible;
    private boolean mOverrideVisibleItems;
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters;
    private boolean mPreventDispatchingItemsChanged;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private boolean mStructureChangedWhileDispatchPrevented;
    private ArrayList<MenuItemImpl> mTempShortcutItemList;
    private ArrayList<MenuItemImpl> mVisibleItems;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface Callback {
        boolean onMenuItemSelected(@NonNull MenuBuilder r5, @NonNull MenuItem r10);

        void onMenuModeChange(@NonNull MenuBuilder r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl r5);
    }

    static {
        sCategoryToOrder = new int[]{1, 4, 5, 3, 2, 0};
    }

    public MenuBuilder(Context r5) {
        this.mDefaultShowAsAction = 0;
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        this.mOptionalIconsVisible = false;
        this.mIsClosing = false;
        this.mTempShortcutItemList = new ArrayList();
        this.mPresenters = new CopyOnWriteArrayList();
        this.mGroupDividerEnabled = false;
        this.mContext = r5;
        this.mResources = r5.getResources();
        this.mItems = new ArrayList();
        this.mVisibleItems = new ArrayList();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList();
        this.mNonActionItems = new ArrayList();
        this.mIsActionItemsStale = true;
        setShortcutsVisibleInner(true);
    }

    private MenuItemImpl createNewMenuItem(int r10, int r11, int r12, int r13, CharSequence r14, int r15) {
        return new MenuItemImpl(this, r10, r11, r12, r13, r14, r15);
    }

    private void dispatchPresenterUpdate(boolean r5) {
        if (this.mPresenters.isEmpty() == false) goto L5;
        return;
    L5:
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r10 = this.mPresenters.iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        WeakReference<MenuPresenter> r11 = r10.next();
        MenuPresenter r12 = r11.get();
        if (r12 == null) goto L10;
        r12.updateMenuView(r5);
        goto L7
    L10:
        this.mPresenters.remove(r11);
        goto L7
    L12:
        startDispatchingItemsChanged();
    }

    private void dispatchRestoreInstanceState(Bundle r5) {
        SparseArray r10 = r5.getSparseParcelableArray(PRESENTER_KEY);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mPresenters.isEmpty() == true) goto L29;
        Iterator<WeakReference<MenuPresenter>> r11 = this.mPresenters.iterator();
    L9:
        if (r11.hasNext() == false) goto L30;
        WeakReference<MenuPresenter> r12 = r11.next();
        MenuPresenter r13 = r12.get();
        if (r13 == null) goto L12;
        int r14 = r13.getId();
        if (r14 <= 0) goto L9;
        Parcelable r15 = (Parcelable) r10.get(r14);
        if (r15 == null) goto L9;
        r13.onRestoreInstanceState(r15);
        goto L9
    L12:
        this.mPresenters.remove(r12);
        goto L9
    L30:
        return;
    }

    private void dispatchSaveInstanceState(Bundle r5) {
        if (this.mPresenters.isEmpty() == false) goto L5;
        return;
    L5:
        SparseArray<? extends Parcelable> r10 = new SparseArray();
        Iterator<WeakReference<MenuPresenter>> r11 = this.mPresenters.iterator();
    L7:
        if (r11.hasNext() == false) goto L16;
        WeakReference<MenuPresenter> r12 = r11.next();
        MenuPresenter r13 = r12.get();
        if (r13 == null) goto L10;
        int r14 = r13.getId();
        if (r14 <= 0) goto L7;
        Parcelable r15 = r13.onSaveInstanceState();
        if (r15 == null) goto L7;
        r10.put(r14, r15);
        goto L7
    L10:
        this.mPresenters.remove(r12);
        goto L7
    L16:
        r5.putSparseParcelableArray(PRESENTER_KEY, r10);
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder r5, MenuPresenter r10) {
        boolean r11 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
        return false;
    L5:
        if (r10 == null) goto L7;
        r11 = r10.onSubMenuSelected(r5);
    L7:
        Iterator<WeakReference<MenuPresenter>> r12 = this.mPresenters.iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        WeakReference<MenuPresenter> r13 = r12.next();
        MenuPresenter r14 = r13.get();
        if (r14 == null) goto L12;
        if (r11 == true) goto L9;
        r11 = r14.onSubMenuSelected(r5);
        goto L9
    L12:
        this.mPresenters.remove(r13);
        goto L9
    L15:
        return r11;
    }

    private static int findInsertIndex(ArrayList<MenuItemImpl> r5, int r10) {
        int r11 = r5.size() - 1;
    L3:
        if (r11 < 0) goto L9;
        if (r5.get(r11).getOrdering() <= r10) goto L7;
        r11 = r11 - 1;
        goto L3
    L7:
        return r11 + 1;
    L9:
        return 0;
    }

    private static int getOrdering(int r5) {
        int r10 = ((-65536) & r5) >> 16;
        if (r10 < 0) goto L9;
        int[] r11 = sCategoryToOrder;
        if (r10 >= r11.length) goto L9;
        int r12 = r5 & 65535;
        return r12 | (r11[r10] << 16);
    L9:
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void removeItemAtInt(int r5, boolean r10) {
        if (r5 >= 0) goto L4;
        return;
    L4:
        if (r5 >= this.mItems.size()) goto L12;
        this.mItems.remove(r5);
        if (r10 == false) goto L11;
        onItemsChanged(true);
        return;
    L11:
        return;
    }

    private void setHeaderInternal(int r5, CharSequence r10, int r11, Drawable r12, View r13) {
        Resources r14 = getResources();
        if (r13 == null) goto L5;
        this.mHeaderView = r13;
        this.mHeaderTitle = null;
        this.mHeaderIcon = null;
    L14:
        onItemsChanged(false);
        return;
    L5:
        if (r5 <= 0) goto L7;
        this.mHeaderTitle = r14.getText(r5);
    L9:
        if (r11 <= 0) goto L11;
        this.mHeaderIcon = ContextCompat.getDrawable(getContext(), r11);
    L13:
        this.mHeaderView = null;
        goto L14
    L11:
        if (r12 == null) goto L13;
        this.mHeaderIcon = r12;
        goto L13
    L7:
        if (r10 == null) goto L9;
        this.mHeaderTitle = r10;
        goto L9
    }

    private void setShortcutsVisibleInner(boolean r5) {
        if (r5 == false) goto L8;
        boolean r10 = true;
        if (this.mResources.getConfiguration().keyboard == 1) goto L8;
        if (ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.mContext), this.mContext) == false) goto L8;
    L9:
        this.mShortcutsVisible = r10;
        return;
    L8:
        r10 = false;
        goto L9
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence r5) {
        return addInternal(0, 0, 0, r5);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int r10, int r11, int r12, ComponentName r13, Intent[] r14, Intent r15, int r16, MenuItem[] r17) {
        PackageManager r5 = this.mContext.getPackageManager();
        int r18 = 0;
        List<ResolveInfo> r19 = r5.queryIntentActivityOptions(r13, r14, r15, 0);
        if (r19 == null) goto L5;
        int r20 = r19.size();
    L7:
        if ((r16 & 1) != 0) goto L9;
        removeGroup(r10);
    L9:
        if (r18 >= r20) goto L20;
        ResolveInfo r110 = r19.get(r18);
        int r21 = r110.specificIndex;
        if (r21 >= 0) goto L13;
        Intent r22 = r15;
    L14:
        Intent r23 = new Intent(r22);
        ActivityInfo r24 = r110.activityInfo;
        r23.setComponent(new ComponentName(r24.applicationInfo.packageName, r24.name));
        MenuItem r25 = add(r10, r11, r12, r110.loadLabel(r5)).setIcon(r110.loadIcon(r5)).setIntent(r23);
        if (r17 == null) goto L19;
        int r111 = r110.specificIndex;
        if (r111 < 0) goto L19;
        r17[r111] = r25;
    L19:
        r18 = r18 + 1;
        goto L9
    L13:
        r22 = r14[r21];
        goto L14
    L20:
        return r20;
    L5:
        r20 = 0;
        goto L7
    }

    public MenuItem addInternal(int r10, int r11, int r12, CharSequence r13) {
        int r14 = getOrdering(r12);
        MenuItemImpl r15 = createNewMenuItem(r10, r11, r12, r14, r13, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo r16 = this.mCurrentMenuInfo;
        if (r16 == null) goto L5;
        r15.setMenuInfo(r16);
    L5:
        ArrayList<MenuItemImpl> r17 = this.mItems;
        r17.add(findInsertIndex(r17, r14), r15);
        onItemsChanged(true);
        return r15;
    }

    public void addMenuPresenter(MenuPresenter r5) {
        addMenuPresenter(r5, this.mContext);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence r5) {
        return addSubMenu(0, 0, 0, r5);
    }

    public void changeMenuMode() {
        Callback r5 = this.mCallback;
        if (r5 == null) goto L6;
        r5.onMenuModeChange(this);
        return;
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl r5 = this.mExpandedItem;
        if (r5 == null) goto L5;
        collapseItemActionView(r5);
    L5:
        this.mItems.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    public final void close(boolean r5) {
        if (this.mIsClosing == false) goto L5;
        return;
    L5:
        this.mIsClosing = true;
        Iterator<WeakReference<MenuPresenter>> r10 = this.mPresenters.iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        WeakReference<MenuPresenter> r11 = r10.next();
        MenuPresenter r12 = r11.get();
        if (r12 == null) goto L10;
        r12.onCloseMenu(this, r5);
        goto L7
    L10:
        this.mPresenters.remove(r11);
        goto L7
    L12:
        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(MenuItemImpl r5) {
        boolean r10 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
    L18:
        return r10;
    L5:
        if (this.mExpandedItem != r5) goto L18;
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r11 = this.mPresenters.iterator();
    L9:
        if (r11.hasNext() == false) goto L15;
        WeakReference<MenuPresenter> r12 = r11.next();
        MenuPresenter r13 = r12.get();
        if (r13 == null) goto L12;
        r10 = r13.collapseItemActionView(this, r5);
        if (r10 == false) goto L9;
    L12:
        this.mPresenters.remove(r12);
    L15:
        startDispatchingItemsChanged();
        if (r10 == false) goto L18;
        this.mExpandedItem = null;
        goto L18
    }

    public boolean dispatchMenuItemSelected(@NonNull MenuBuilder r5, @NonNull MenuItem r10) {
        Callback r11 = this.mCallback;
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.onMenuItemSelected(r5, r10) == false) goto L7;
        return true;
    }

    public boolean expandItemActionView(MenuItemImpl r5) {
        boolean r10 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
        return false;
    L5:
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r11 = this.mPresenters.iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        WeakReference<MenuPresenter> r12 = r11.next();
        MenuPresenter r13 = r12.get();
        if (r13 == null) goto L10;
        r10 = r13.expandItemActionView(this, r5);
        if (r10 == false) goto L7;
    L10:
        this.mPresenters.remove(r12);
    L13:
        startDispatchingItemsChanged();
        if (r10 == false) goto L16;
        this.mExpandedItem = r5;
    L16:
        return r10;
    }

    public int findGroupIndex(int r5) {
        return findGroupIndex(r5, 0);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int r5) {
        int r10 = size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L13;
        MenuItemImpl r12 = this.mItems.get(r11);
        if (r12.getItemId() == r5) goto L6;
        if (r12.hasSubMenu() == false) goto L12;
        MenuItem r13 = r12.getSubMenu().findItem(r5);
        if (r13 == null) goto L12;
        return r13;
    L12:
        r11 = r11 + 1;
        goto L3
    L6:
        return r12;
    L13:
        return null;
    }

    public int findItemIndex(int r5) {
        int r10 = size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (this.mItems.get(r11).getItemId() == r5) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r11;
    L8:
        return -1;
    }

    public MenuItemImpl findItemWithShortcutForKey(int r11, KeyEvent r12) {
        ArrayList<MenuItemImpl> r5 = this.mTempShortcutItemList;
        r5.clear();
        findItemsWithShortcutForKey(r5, r11, r12);
        if (r5.isEmpty() == false) goto L5;
        return null;
    L5:
        int r10 = r12.getMetaState();
        KeyCharacterMap.KeyData r13 = new KeyCharacterMap.KeyData();
        r12.getKeyData(r13);
        int r14 = r5.size();
        if (r14 == 1) goto L8;
        boolean r15 = isQwertyMode();
        int r16 = 0;
    L10:
        if (r16 >= r14) goto L30;
        MenuItemImpl r17 = r5.get(r16);
        if (r15 == false) goto L14;
        char r18 = r17.getAlphabeticShortcut();
    L15:
        char[] r19 = r13.meta;
        if (r18 != r19[0]) goto L20;
        if ((r10 & 2) != 0) goto L20;
    L28:
        return r17;
    L20:
        if (r18 == r19[2]) goto L22;
    L23:
        if (r15 == false) goto L29;
        if (r18 != '\b') goto L29;
        if (r11 == 67) goto L28;
    L29:
        r16 = r16 + 1;
        goto L10
    L22:
        if ((r10 & 2) != 0) goto L28;
    L14:
        r18 = r17.getNumericShortcut();
        goto L15
    L30:
        return null;
    L8:
        return r5.get(0);
    }

    public void findItemsWithShortcutForKey(List<MenuItemImpl> r13, int r14, KeyEvent r15) {
        boolean r5 = isQwertyMode();
        int r10 = r15.getModifiers();
        KeyCharacterMap.KeyData r11 = new KeyCharacterMap.KeyData();
        if (r15.getKeyData(r11) == true) goto L6;
        if (r14 == 67) goto L6;
        return;
    L6:
        int r12 = this.mItems.size();
        int r16 = 0;
    L7:
        if (r16 >= r12) goto L32;
        MenuItemImpl r17 = this.mItems.get(r16);
        if (r17.hasSubMenu() == false) goto L11;
        ((MenuBuilder) r17.getSubMenu()).findItemsWithShortcutForKey(r13, r14, r15);
    L11:
        if (r5 == false) goto L13;
        char r18 = r17.getAlphabeticShortcut();
    L14:
        if (r5 == false) goto L16;
        int r19 = r17.getAlphabeticModifiers();
    L18:
        if ((r10 & SupportMenu.SUPPORTED_MODIFIERS_MASK) != (r19 & SupportMenu.SUPPORTED_MODIFIERS_MASK)) goto L31;
        if (r18 == 0) goto L31;
        char[] r20 = r11.meta;
        if (r18 == r20[0]) goto L29;
        if (r18 == r20[2]) goto L29;
        if (r5 == false) goto L31;
        if (r18 != '\b') goto L31;
        if (r14 != 67) goto L31;
    L29:
        if (r17.isEnabled() == false) goto L31;
        r13.add(r17);
    L31:
        r16 = r16 + 1;
        goto L7
    L16:
        r19 = r17.getNumericModifiers();
        goto L18
    L13:
        r18 = r17.getNumericShortcut();
        goto L14
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> r5 = getVisibleItems();
        if (this.mIsActionItemsStale == true) goto L5;
        return;
    L5:
        Iterator<WeakReference<MenuPresenter>> r10 = this.mPresenters.iterator();
        boolean r11 = false;
    L7:
        if (r10.hasNext() == false) goto L12;
        WeakReference<MenuPresenter> r12 = r10.next();
        MenuPresenter r13 = r12.get();
        if (r13 == null) goto L10;
        r11 = r11 | r13.flagActionItems();
        goto L7
    L10:
        this.mPresenters.remove(r12);
        goto L7
    L12:
        if (r11 == false) goto L20;
        this.mActionItems.clear();
        this.mNonActionItems.clear();
        int r14 = r5.size();
        int r15 = 0;
    L14:
        if (r15 >= r14) goto L21;
        MenuItemImpl r16 = r5.get(r15);
        if (r16.isActionButton() == false) goto L18;
        this.mActionItems.add(r16);
    L19:
        r15 = r15 + 1;
        goto L14
    L18:
        this.mNonActionItems.add(r16);
    L21:
        this.mIsActionItemsStale = false;
        return;
    L20:
        this.mActionItems.clear();
        this.mNonActionItems.clear();
        this.mNonActionItems.addAll(getVisibleItems());
        goto L21
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    public String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public MenuItemImpl getExpandedItem() {
        return this.mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int r5) {
        return this.mItems.get(r5);
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    public boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    @NonNull
    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (this.mIsVisibleItemsStale == false) goto L5;
        this.mVisibleItems.clear();
        int r5 = this.mItems.size();
        int r10 = 0;
    L7:
        if (r10 >= r5) goto L12;
        MenuItemImpl r11 = this.mItems.get(r10);
        if (r11.isVisible() == false) goto L11;
        this.mVisibleItems.add(r11);
    L11:
        r10 = r10 + 1;
        goto L7
    L12:
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    L5:
        return this.mVisibleItems;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems == false) goto L5;
        return true;
    L5:
        int r5 = size();
        int r10 = 0;
    L6:
        if (r10 >= r5) goto L11;
        if (this.mItems.get(r10).isVisible() == true) goto L9;
        r10 = r10 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int r5, KeyEvent r10) {
        if (findItemWithShortcutForKey(r5, r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    public void onItemActionRequestChanged(MenuItemImpl r5) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemVisibleChanged(MenuItemImpl r5) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean r5) {
        if (this.mPreventDispatchingItemsChanged == true) goto L7;
        if (r5 == false) goto L6;
        this.mIsVisibleItemsStale = true;
        this.mIsActionItemsStale = true;
    L6:
        dispatchPresenterUpdate(r5);
        return;
    L7:
        this.mItemsChangedWhileDispatchPrevented = true;
        if (r5 == false) goto L12;
        this.mStructureChangedWhileDispatchPrevented = true;
        return;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int r5, int r10) {
        return performItemAction(findItem(r5), r10);
    }

    public boolean performItemAction(MenuItem r5, int r10) {
        return performItemAction(r5, null, r10);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int r5, KeyEvent r10, int r11) {
        MenuItemImpl r12 = findItemWithShortcutForKey(r5, r10);
        if (r12 == null) goto L5;
        boolean r13 = performItemAction(r12, r11);
    L7:
        if ((r11 & 2) == 0) goto L9;
        close(true);
    L9:
        return r13;
    L5:
        r13 = false;
        goto L7
    }

    @Override // android.view.Menu
    public void removeGroup(int r10) {
        int r5 = findGroupIndex(r10);
        if (r5 < 0) goto L14;
        int r11 = this.mItems.size() - r5;
        int r12 = 0;
    L5:
        int r13 = r12 + 1;
        if (r12 >= r11) goto L10;
        if (this.mItems.get(r5).getGroupId() != r10) goto L10;
        removeItemAtInt(r5, false);
        r12 = r13;
    L10:
        onItemsChanged(true);
        return;
    }

    @Override // android.view.Menu
    public void removeItem(int r5) {
        removeItemAtInt(findItemIndex(r5), true);
    }

    public void removeItemAt(int r5) {
        removeItemAtInt(r5, true);
    }

    public void removeMenuPresenter(MenuPresenter r5) {
        Iterator<WeakReference<MenuPresenter>> r10 = this.mPresenters.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        WeakReference<MenuPresenter> r11 = r10.next();
        MenuPresenter r12 = r11.get();
        if (r12 == null) goto L8;
        if (r12 != r5) goto L4;
    L8:
        this.mPresenters.remove(r11);
        goto L4
    }

    public void restoreActionViewStates(Bundle r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        SparseArray<Parcelable> r5 = r10.getSparseParcelableArray(getActionViewStatesKey());
        int r11 = size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L15;
        MenuItem r13 = getItem(r12);
        View r14 = r13.getActionView();
        if (r14 == null) goto L12;
        if (r14.getId() == (-1)) goto L12;
        r14.restoreHierarchyState(r5);
    L12:
        if (r13.hasSubMenu() == false) goto L14;
        ((SubMenuBuilder) r13.getSubMenu()).restoreActionViewStates(r10);
    L14:
        r12 = r12 + 1;
        goto L5
    L15:
        int r15 = r10.getInt(EXPANDED_ACTION_VIEW_ID);
        if (r15 <= 0) goto L24;
        MenuItem r16 = findItem(r15);
        if (r16 == null) goto L25;
        r16.expandActionView();
        return;
    L25:
        return;
    }

    public void restorePresenterStates(Bundle r5) {
        dispatchRestoreInstanceState(r5);
    }

    public void saveActionViewStates(Bundle r10) {
        int r5 = size();
        SparseArray<? extends Parcelable> r11 = null;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L17;
        MenuItem r13 = getItem(r12);
        View r14 = r13.getActionView();
        if (r14 == null) goto L14;
        if (r14.getId() == (-1)) goto L14;
        if (r11 != null) goto L10;
        r11 = new SparseArray();
    L10:
        r14.saveHierarchyState(r11);
        if (r13.isActionViewExpanded() == false) goto L14;
        r10.putInt(EXPANDED_ACTION_VIEW_ID, r13.getItemId());
    L14:
        if (r13.hasSubMenu() == false) goto L16;
        ((SubMenuBuilder) r13.getSubMenu()).saveActionViewStates(r10);
    L16:
        r12 = r12 + 1;
        goto L3
    L17:
        if (r11 == null) goto L23;
        r10.putSparseParcelableArray(getActionViewStatesKey(), r11);
        return;
    }

    public void savePresenterStates(Bundle r5) {
        dispatchSaveInstanceState(r5);
    }

    public void setCallback(Callback r5) {
        this.mCallback = r5;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo r5) {
        this.mCurrentMenuInfo = r5;
    }

    public MenuBuilder setDefaultShowAsAction(int r5) {
        this.mDefaultShowAsAction = r5;
        return this;
    }

    public void setExclusiveItemChecked(MenuItem r10) {
        int r5 = r10.getGroupId();
        int r11 = this.mItems.size();
        stopDispatchingItemsChanged();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L17;
        MenuItemImpl r13 = this.mItems.get(r12);
        if (r13.getGroupId() != r5) goto L16;
        if (r13.isExclusiveCheckable() == false) goto L16;
        if (r13.isCheckable() == false) goto L16;
        if (r13 != r10) goto L14;
        boolean r14 = true;
    L15:
        r13.setCheckedInt(r14);
        goto L16
    L14:
        r14 = false;
    L16:
        r12 = r12 + 1;
        goto L3
    L17:
        startDispatchingItemsChanged();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int r5, boolean r10, boolean r11) {
        int r12 = this.mItems.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        MenuItemImpl r14 = this.mItems.get(r13);
        if (r14.getGroupId() != r5) goto L7;
        r14.setExclusiveCheckable(r11);
        r14.setCheckable(r10);
    L7:
        r13 = r13 + 1;
        goto L3
    }

    @Override // androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean r5) {
        this.mGroupDividerEnabled = r5;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int r5, boolean r10) {
        int r11 = this.mItems.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        MenuItemImpl r13 = this.mItems.get(r12);
        if (r13.getGroupId() != r5) goto L7;
        r13.setEnabled(r10);
    L7:
        r12 = r12 + 1;
        goto L3
    }

    @Override // android.view.Menu
    public void setGroupVisible(int r10, boolean r11) {
        int r5 = this.mItems.size();
        int r12 = 0;
        boolean r13 = false;
    L4:
        if (r12 >= r5) goto L11;
        MenuItemImpl r14 = this.mItems.get(r12);
        if (r14.getGroupId() != r10) goto L10;
        if (r14.setVisibleInt(r11) == false) goto L10;
        r13 = true;
    L10:
        r12 = r12 + 1;
        goto L4
    L11:
        if (r13 == false) goto L18;
        onItemsChanged(true);
        return;
    }

    public MenuBuilder setHeaderIconInt(Drawable r10) {
        setHeaderInternal(0, null, 0, r10, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(CharSequence r10) {
        setHeaderInternal(0, r10, 0, null, null);
        return this;
    }

    public MenuBuilder setHeaderViewInt(View r10) {
        setHeaderInternal(0, null, 0, null, r10);
        return this;
    }

    public void setOptionalIconsVisible(boolean r5) {
        this.mOptionalIconsVisible = r5;
    }

    public void setOverrideVisibleItems(boolean r5) {
        this.mOverrideVisibleItems = r5;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean r5) {
        this.mQwertyMode = r5;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean r5) {
        if (this.mShortcutsVisible != r5) goto L5;
        return;
    L5:
        setShortcutsVisibleInner(r5);
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.mItems.size();
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented == false) goto L6;
        this.mItemsChangedWhileDispatchPrevented = false;
        onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        return;
    }

    public void stopDispatchingItemsChanged() {
        if (this.mPreventDispatchingItemsChanged == true) goto L6;
        this.mPreventDispatchingItemsChanged = true;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        return;
    }

    @Override // android.view.Menu
    public MenuItem add(int r5) {
        return addInternal(0, 0, 0, this.mResources.getString(r5));
    }

    public void addMenuPresenter(MenuPresenter r5, Context r10) {
        this.mPresenters.add(new WeakReference(r5));
        r5.initForMenu(r10, this);
        this.mIsActionItemsStale = true;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r5) {
        return addSubMenu(0, 0, 0, this.mResources.getString(r5));
    }

    public int findGroupIndex(int r5, int r10) {
        int r11 = size();
        if (r10 >= 0) goto L5;
        r10 = 0;
    L5:
        if (r10 >= r11) goto L10;
        if (this.mItems.get(r10).getGroupId() == r5) goto L8;
        r10 = r10 + 1;
        goto L5
    L8:
        return r10;
    L10:
        return -1;
    }

    public boolean performItemAction(MenuItem r10, MenuPresenter r11, int r12) {
        MenuItemImpl r13 = (MenuItemImpl) r10;
        if (r13 != null) goto L5;
    L38:
        return false;
    L5:
        if (r13.isEnabled() == false) goto L38;
        boolean r5 = r13.invoke();
        ActionProvider r14 = r13.getSupportActionProvider();
        if (r14 != null) goto L10;
    L12:
        boolean r15 = false;
    L14:
        if (r13.hasCollapsibleActionView() == false) goto L19;
        r5 = r5 | r13.expandActionView();
        if (r5 == false) goto L37;
        close(true);
    L37:
        return r5;
    L19:
        if (r13.hasSubMenu() == true) goto L26;
        if (r15 == true) goto L26;
        if ((r12 & 1) != 0) goto L37;
        close(true);
    L26:
        if ((r12 & 4) != 0) goto L29;
        close(false);
    L29:
        if (r13.hasSubMenu() == true) goto L31;
        r13.setSubMenu(new SubMenuBuilder(getContext(), this, r13));
    L31:
        SubMenuBuilder r16 = (SubMenuBuilder) r13.getSubMenu();
        if (r15 == false) goto L34;
        r14.onPrepareSubMenu(r16);
    L34:
        r5 = r5 | dispatchSubMenuSelected(r16, r11);
        if (r5 == true) goto L37;
        close(true);
        goto L37
    L10:
        if (r14.hasSubMenu() == false) goto L12;
        r15 = true;
        goto L14
    }

    public MenuBuilder setHeaderIconInt(int r10) {
        setHeaderInternal(0, null, r10, null, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(int r10) {
        setHeaderInternal(r10, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int r5, int r10, int r11, CharSequence r12) {
        return addInternal(r5, r10, r11, r12);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r5, int r10, int r11, CharSequence r12) {
        MenuItemImpl r13 = (MenuItemImpl) addInternal(r5, r10, r11, r12);
        SubMenuBuilder r14 = new SubMenuBuilder(this.mContext, this, r13);
        r13.setSubMenu(r14);
        return r14;
    }

    @Override // android.view.Menu
    public MenuItem add(int r5, int r10, int r11, int r12) {
        return addInternal(r5, r10, r11, this.mResources.getString(r12));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r5, int r10, int r11, int r12) {
        return addSubMenu(r5, r10, r11, this.mResources.getString(r12));
    }

    @Override // android.view.Menu
    public void close() {
        close(true);
    }
}
