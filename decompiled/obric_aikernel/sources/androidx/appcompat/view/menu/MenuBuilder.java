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
        boolean onMenuItemSelected(@NonNull MenuBuilder r10, @NonNull MenuItem r11);

        void onMenuModeChange(@NonNull MenuBuilder r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl r10);
    }

    static {
        sCategoryToOrder = new int[]{1, 4, 5, 3, 2, 0};
    }

    public MenuBuilder(Context r10) {
        this.mDefaultShowAsAction = 0;
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        this.mOptionalIconsVisible = false;
        this.mIsClosing = false;
        this.mTempShortcutItemList = new ArrayList();
        this.mPresenters = new CopyOnWriteArrayList();
        this.mGroupDividerEnabled = false;
        this.mContext = r10;
        this.mResources = r10.getResources();
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

    private void dispatchPresenterUpdate(boolean r10) {
        if (this.mPresenters.isEmpty() == false) goto L5;
        return;
    L5:
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r11 = this.mPresenters.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        WeakReference<MenuPresenter> r12 = r11.next();
        MenuPresenter r13 = r12.get();
        if (r13 == null) goto L10;
        r13.updateMenuView(r10);
        goto L7
    L10:
        this.mPresenters.remove(r12);
        goto L7
    L12:
        startDispatchingItemsChanged();
    }

    private void dispatchRestoreInstanceState(Bundle r10) {
        SparseArray r11 = r10.getSparseParcelableArray(PRESENTER_KEY);
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.mPresenters.isEmpty() == true) goto L29;
        Iterator<WeakReference<MenuPresenter>> r12 = this.mPresenters.iterator();
    L9:
        if (r12.hasNext() == false) goto L30;
        WeakReference<MenuPresenter> r13 = r12.next();
        MenuPresenter r14 = r13.get();
        if (r14 == null) goto L12;
        int r15 = r14.getId();
        if (r15 <= 0) goto L9;
        Parcelable r16 = (Parcelable) r11.get(r15);
        if (r16 == null) goto L9;
        r14.onRestoreInstanceState(r16);
        goto L9
    L12:
        this.mPresenters.remove(r13);
        goto L9
    L30:
        return;
    }

    private void dispatchSaveInstanceState(Bundle r10) {
        if (this.mPresenters.isEmpty() == false) goto L5;
        return;
    L5:
        SparseArray<? extends Parcelable> r11 = new SparseArray();
        Iterator<WeakReference<MenuPresenter>> r12 = this.mPresenters.iterator();
    L7:
        if (r12.hasNext() == false) goto L16;
        WeakReference<MenuPresenter> r13 = r12.next();
        MenuPresenter r14 = r13.get();
        if (r14 == null) goto L10;
        int r15 = r14.getId();
        if (r15 <= 0) goto L7;
        Parcelable r16 = r14.onSaveInstanceState();
        if (r16 == null) goto L7;
        r11.put(r15, r16);
        goto L7
    L10:
        this.mPresenters.remove(r13);
        goto L7
    L16:
        r10.putSparseParcelableArray(PRESENTER_KEY, r11);
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder r10, MenuPresenter r11) {
        boolean r12 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
        return false;
    L5:
        if (r11 == null) goto L7;
        r12 = r11.onSubMenuSelected(r10);
    L7:
        Iterator<WeakReference<MenuPresenter>> r13 = this.mPresenters.iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        WeakReference<MenuPresenter> r14 = r13.next();
        MenuPresenter r15 = r14.get();
        if (r15 == null) goto L12;
        if (r12 == true) goto L9;
        r12 = r15.onSubMenuSelected(r10);
        goto L9
    L12:
        this.mPresenters.remove(r14);
        goto L9
    L15:
        return r12;
    }

    private static int findInsertIndex(ArrayList<MenuItemImpl> r10, int r11) {
        int r12 = r10.size() - 1;
    L3:
        if (r12 < 0) goto L9;
        if (r10.get(r12).getOrdering() <= r11) goto L7;
        r12 = r12 - 1;
        goto L3
    L7:
        return r12 + 1;
    L9:
        return 0;
    }

    private static int getOrdering(int r10) {
        int r11 = ((-65536) & r10) >> 16;
        if (r11 < 0) goto L9;
        int[] r12 = sCategoryToOrder;
        if (r11 >= r12.length) goto L9;
        int r13 = r12[r11] << 16;
        return (r10 & SupportMenu.USER_MASK) | r13;
    L9:
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void removeItemAtInt(int r10, boolean r11) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (r10 >= this.mItems.size()) goto L12;
        this.mItems.remove(r10);
        if (r11 == false) goto L11;
        onItemsChanged(true);
        return;
    L11:
        return;
    }

    private void setHeaderInternal(int r10, CharSequence r11, int r12, Drawable r13, View r14) {
        Resources r15 = getResources();
        if (r14 == null) goto L5;
        this.mHeaderView = r14;
        this.mHeaderTitle = null;
        this.mHeaderIcon = null;
    L14:
        onItemsChanged(false);
        return;
    L5:
        if (r10 <= 0) goto L7;
        this.mHeaderTitle = r15.getText(r10);
    L9:
        if (r12 <= 0) goto L11;
        this.mHeaderIcon = ContextCompat.getDrawable(getContext(), r12);
    L13:
        this.mHeaderView = null;
        goto L14
    L11:
        if (r13 == null) goto L13;
        this.mHeaderIcon = r13;
        goto L13
    L7:
        if (r11 == null) goto L9;
        this.mHeaderTitle = r11;
        goto L9
    }

    private void setShortcutsVisibleInner(boolean r10) {
        boolean r11 = true;
        if (r10 == true) goto L5;
    L9:
        r11 = false;
    L10:
        this.mShortcutsVisible = r11;
        return;
    L5:
        if (this.mResources.getConfiguration().keyboard == 1) goto L9;
        if (ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.mContext), this.mContext) == false) goto L9;
        goto L9
    }

    @Override // android.view.Menu
    public MenuItem add(int r10) {
        return addInternal(0, 0, 0, this.mResources.getString(r10));
    }

    @Override // android.view.Menu
    public MenuItem add(int r10, int r11, int r12, int r13) {
        return addInternal(r10, r11, r12, this.mResources.getString(r13));
    }

    @Override // android.view.Menu
    public MenuItem add(int r10, int r11, int r12, CharSequence r13) {
        return addInternal(r10, r11, r12, r13);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence r10) {
        return addInternal(0, 0, 0, r10);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int r10, int r11, int r12, ComponentName r13, Intent[] r14, Intent r15, int r16, MenuItem[] r17) {
        PackageManager r18 = this.mContext.getPackageManager();
        int r19 = 0;
        List<ResolveInfo> r110 = r18.queryIntentActivityOptions(r13, r14, r15, 0);
        if (r110 == null) goto L5;
        int r20 = r110.size();
    L7:
        if ((r16 & 1) != 0) goto L9;
        removeGroup(r10);
    L9:
        if (r19 >= r20) goto L20;
        ResolveInfo r111 = r110.get(r19);
        int r21 = r111.specificIndex;
        if (r21 >= 0) goto L13;
        Intent r22 = r15;
    L14:
        Intent r23 = new Intent(r22);
        ActivityInfo r24 = r111.activityInfo;
        r23.setComponent(new ComponentName(r24.applicationInfo.packageName, r24.name));
        MenuItem r25 = add(r10, r11, r12, r111.loadLabel(r18)).setIcon(r111.loadIcon(r18)).setIntent(r23);
        if (r17 == null) goto L19;
        int r112 = r111.specificIndex;
        if (r112 < 0) goto L19;
        r17[r112] = r25;
    L19:
        r19 = r19 + 1;
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

    protected MenuItem addInternal(int r10, int r11, int r12, CharSequence r13) {
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

    public void addMenuPresenter(MenuPresenter r10) {
        addMenuPresenter(r10, this.mContext);
    }

    public void addMenuPresenter(MenuPresenter r10, Context r11) {
        this.mPresenters.add(new WeakReference(r10));
        r10.initForMenu(r11, this);
        this.mIsActionItemsStale = true;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r10) {
        return addSubMenu(0, 0, 0, this.mResources.getString(r10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r10, int r11, int r12, int r13) {
        return addSubMenu(r10, r11, r12, this.mResources.getString(r13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r10, int r11, int r12, CharSequence r13) {
        MenuItemImpl r14 = (MenuItemImpl) addInternal(r10, r11, r12, r13);
        SubMenuBuilder r15 = new SubMenuBuilder(this.mContext, this, r14);
        r14.setSubMenu(r15);
        return r15;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence r10) {
        return addSubMenu(0, 0, 0, r10);
    }

    public void changeMenuMode() {
        Callback r10 = this.mCallback;
        if (r10 == null) goto L6;
        r10.onMenuModeChange(this);
        return;
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl r10 = this.mExpandedItem;
        if (r10 == null) goto L5;
        collapseItemActionView(r10);
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

    @Override // android.view.Menu
    public void close() {
        close(true);
    }

    public final void close(boolean r10) {
        if (this.mIsClosing == false) goto L5;
        return;
    L5:
        this.mIsClosing = true;
        Iterator<WeakReference<MenuPresenter>> r11 = this.mPresenters.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        WeakReference<MenuPresenter> r12 = r11.next();
        MenuPresenter r13 = r12.get();
        if (r13 == null) goto L10;
        r13.onCloseMenu(this, r10);
        goto L7
    L10:
        this.mPresenters.remove(r12);
        goto L7
    L12:
        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(MenuItemImpl r10) {
        boolean r11 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
    L18:
        return r11;
    L5:
        if (this.mExpandedItem != r10) goto L18;
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r12 = this.mPresenters.iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        WeakReference<MenuPresenter> r13 = r12.next();
        MenuPresenter r14 = r13.get();
        if (r14 == null) goto L12;
        r11 = r14.collapseItemActionView(this, r10);
        if (r11 == false) goto L9;
    L12:
        this.mPresenters.remove(r13);
    L15:
        startDispatchingItemsChanged();
        if (r11 == false) goto L18;
        this.mExpandedItem = null;
        goto L18
    }

    boolean dispatchMenuItemSelected(@NonNull MenuBuilder r10, @NonNull MenuItem r11) {
        Callback r12 = this.mCallback;
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r12.onMenuItemSelected(r10, r11) == false) goto L7;
        return true;
    }

    public boolean expandItemActionView(MenuItemImpl r10) {
        boolean r11 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
        return false;
    L5:
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r12 = this.mPresenters.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        WeakReference<MenuPresenter> r13 = r12.next();
        MenuPresenter r14 = r13.get();
        if (r14 == null) goto L10;
        r11 = r14.expandItemActionView(this, r10);
        if (r11 == false) goto L7;
    L10:
        this.mPresenters.remove(r13);
    L13:
        startDispatchingItemsChanged();
        if (r11 == false) goto L16;
        this.mExpandedItem = r10;
    L16:
        return r11;
    }

    public int findGroupIndex(int r10) {
        return findGroupIndex(r10, 0);
    }

    public int findGroupIndex(int r10, int r11) {
        int r12 = size();
        if (r11 >= 0) goto L5;
        r11 = 0;
    L5:
        if (r11 >= r12) goto L10;
        if (this.mItems.get(r11).getGroupId() == r10) goto L8;
        r11 = r11 + 1;
        goto L5
    L8:
        return r11;
    L10:
        return -1;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int r10) {
        int r11 = size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L13;
        MenuItemImpl r13 = this.mItems.get(r12);
        if (r13.getItemId() == r10) goto L6;
        if (r13.hasSubMenu() == false) goto L12;
        MenuItem r14 = r13.getSubMenu().findItem(r10);
        if (r14 == null) goto L12;
        return r14;
    L12:
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L13:
        return null;
    }

    public int findItemIndex(int r10) {
        int r11 = size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (this.mItems.get(r12).getItemId() == r10) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r12;
    L8:
        return -1;
    }

    MenuItemImpl findItemWithShortcutForKey(int r11, KeyEvent r12) {
        ArrayList<MenuItemImpl> r10 = this.mTempShortcutItemList;
        r10.clear();
        findItemsWithShortcutForKey(r10, r11, r12);
        if (r10.isEmpty() == false) goto L5;
        return null;
    L5:
        int r13 = r12.getMetaState();
        KeyCharacterMap.KeyData r14 = new KeyCharacterMap.KeyData();
        r12.getKeyData(r14);
        int r15 = r10.size();
        if (r15 == 1) goto L8;
        boolean r16 = isQwertyMode();
        int r17 = 0;
    L10:
        if (r17 >= r15) goto L30;
        MenuItemImpl r18 = r10.get(r17);
        if (r16 == false) goto L14;
        char r19 = r18.getAlphabeticShortcut();
    L15:
        char[] r20 = r14.meta;
        if (r19 != r20[0]) goto L20;
        if ((r13 & 2) != 0) goto L20;
    L28:
        return r18;
    L20:
        if (r19 == r20[2]) goto L22;
    L23:
        if (r16 == false) goto L29;
        if (r19 != '\b') goto L29;
        if (r11 == 67) goto L28;
    L29:
        r17 = r17 + 1;
        goto L10
    L22:
        if ((r13 & 2) != 0) goto L28;
    L14:
        r19 = r18.getNumericShortcut();
        goto L15
    L30:
        return null;
    L8:
        return r10.get(0);
    }

    void findItemsWithShortcutForKey(List<MenuItemImpl> r13, int r14, KeyEvent r15) {
        boolean r10 = isQwertyMode();
        int r11 = r15.getModifiers();
        KeyCharacterMap.KeyData r12 = new KeyCharacterMap.KeyData();
        if (r15.getKeyData(r12) == true) goto L6;
        if (r14 == 67) goto L6;
        return;
    L6:
        int r16 = this.mItems.size();
        int r17 = 0;
    L7:
        if (r17 >= r16) goto L35;
        MenuItemImpl r18 = this.mItems.get(r17);
        if (r18.hasSubMenu() == false) goto L11;
        ((MenuBuilder) r18.getSubMenu()).findItemsWithShortcutForKey(r13, r14, r15);
    L11:
        if (r10 == false) goto L13;
        char r19 = r18.getAlphabeticShortcut();
    L14:
        if (r10 == false) goto L16;
        int r20 = r18.getAlphabeticModifiers();
    L18:
        if ((r11 & SupportMenu.SUPPORTED_MODIFIERS_MASK) != (r20 & SupportMenu.SUPPORTED_MODIFIERS_MASK)) goto L20;
        boolean r21 = true;
    L21:
        if (r21 == false) goto L34;
        if (r19 == 0) goto L34;
        char[] r22 = r12.meta;
        if (r19 == r22[0]) goto L32;
        if (r19 == r22[2]) goto L32;
        if (r10 == false) goto L34;
        if (r19 != '\b') goto L34;
        if (r14 != 67) goto L34;
    L32:
        if (r18.isEnabled() == false) goto L34;
        r13.add(r18);
    L34:
        r17 = r17 + 1;
        goto L7
    L20:
        r21 = false;
        goto L21
    L16:
        r20 = r18.getNumericModifiers();
        goto L18
    L13:
        r19 = r18.getNumericShortcut();
        goto L14
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> r10 = getVisibleItems();
        if (this.mIsActionItemsStale == true) goto L5;
        return;
    L5:
        Iterator<WeakReference<MenuPresenter>> r11 = this.mPresenters.iterator();
        boolean r12 = false;
    L7:
        if (r11.hasNext() == false) goto L12;
        WeakReference<MenuPresenter> r13 = r11.next();
        MenuPresenter r14 = r13.get();
        if (r14 == null) goto L10;
        r12 = r12 | r14.flagActionItems();
        goto L7
    L10:
        this.mPresenters.remove(r13);
        goto L7
    L12:
        if (r12 == false) goto L20;
        this.mActionItems.clear();
        this.mNonActionItems.clear();
        int r15 = r10.size();
        int r16 = 0;
    L14:
        if (r16 >= r15) goto L21;
        MenuItemImpl r17 = r10.get(r16);
        if (r17.isActionButton() == false) goto L18;
        ArrayList<MenuItemImpl> r18 = this.mActionItems;
    L19:
        r18.add(r17);
        r16 = r16 + 1;
        goto L14
    L18:
        r18 = this.mNonActionItems;
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

    protected String getActionViewStatesKey() {
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
    public MenuItem getItem(int r10) {
        return this.mItems.get(r10);
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    Resources getResources() {
        return this.mResources;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    @NonNull
    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (this.mIsVisibleItemsStale == false) goto L5;
        this.mVisibleItems.clear();
        int r10 = this.mItems.size();
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L12;
        MenuItemImpl r12 = this.mItems.get(r11);
        if (r12.isVisible() == false) goto L11;
        this.mVisibleItems.add(r12);
    L11:
        r11 = r11 + 1;
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
        int r10 = size();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L11;
        if (this.mItems.get(r11).isVisible() == true) goto L9;
        r11 = r11 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int r10, KeyEvent r11) {
        if (findItemWithShortcutForKey(r10, r11) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    void onItemActionRequestChanged(MenuItemImpl r10) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    void onItemVisibleChanged(MenuItemImpl r10) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean r10) {
        if (this.mPreventDispatchingItemsChanged == true) goto L7;
        if (r10 == false) goto L6;
        this.mIsVisibleItemsStale = true;
        this.mIsActionItemsStale = true;
    L6:
        dispatchPresenterUpdate(r10);
        return;
    L7:
        this.mItemsChangedWhileDispatchPrevented = true;
        if (r10 == false) goto L12;
        this.mStructureChangedWhileDispatchPrevented = true;
        return;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int r10, int r11) {
        return performItemAction(findItem(r10), r11);
    }

    public boolean performItemAction(MenuItem r10, int r11) {
        return performItemAction(r10, null, r11);
    }

    public boolean performItemAction(MenuItem r10, MenuPresenter r11, int r12) {
        MenuItemImpl r13 = (MenuItemImpl) r10;
        if (r13 != null) goto L5;
    L38:
        return false;
    L5:
        if (r13.isEnabled() == false) goto L38;
        boolean r14 = r13.invoke();
        ActionProvider r15 = r13.getSupportActionProvider();
        if (r15 != null) goto L10;
    L12:
        boolean r16 = false;
    L14:
        if (r13.hasCollapsibleActionView() == false) goto L19;
        r14 = r14 | r13.expandActionView();
        if (r14 == false) goto L37;
    L17:
        close(true);
    L37:
        return r14;
    L19:
        if (r13.hasSubMenu() == true) goto L26;
        if (r16 == true) goto L26;
        if ((r12 & 1) != 0) goto L37;
    L26:
        if ((r12 & 4) != 0) goto L29;
        close(false);
    L29:
        if (r13.hasSubMenu() == true) goto L31;
        r13.setSubMenu(new SubMenuBuilder(getContext(), this, r13));
    L31:
        SubMenuBuilder r17 = (SubMenuBuilder) r13.getSubMenu();
        if (r16 == false) goto L34;
        r15.onPrepareSubMenu(r17);
    L34:
        r14 = r14 | dispatchSubMenuSelected(r17, r11);
        if (r14 == true) goto L37;
    L10:
        if (r15.hasSubMenu() == false) goto L12;
        r16 = true;
        goto L14
    }

    @Override // android.view.Menu
    public boolean performShortcut(int r10, KeyEvent r11, int r12) {
        MenuItemImpl r13 = findItemWithShortcutForKey(r10, r11);
        if (r13 == null) goto L5;
        boolean r14 = performItemAction(r13, r12);
    L7:
        if ((r12 & 2) == 0) goto L9;
        close(true);
    L9:
        return r14;
    L5:
        r14 = false;
        goto L7
    }

    @Override // android.view.Menu
    public void removeGroup(int r10) {
        int r11 = findGroupIndex(r10);
        if (r11 < 0) goto L14;
        int r12 = this.mItems.size() - r11;
        int r13 = 0;
    L5:
        int r14 = r13 + 1;
        if (r13 >= r12) goto L10;
        if (this.mItems.get(r11).getGroupId() != r10) goto L10;
        removeItemAtInt(r11, false);
        r13 = r14;
    L10:
        onItemsChanged(true);
        return;
    }

    @Override // android.view.Menu
    public void removeItem(int r10) {
        removeItemAtInt(findItemIndex(r10), true);
    }

    public void removeItemAt(int r10) {
        removeItemAtInt(r10, true);
    }

    public void removeMenuPresenter(MenuPresenter r10) {
        Iterator<WeakReference<MenuPresenter>> r11 = this.mPresenters.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        WeakReference<MenuPresenter> r12 = r11.next();
        MenuPresenter r13 = r12.get();
        if (r13 == null) goto L8;
        if (r13 != r10) goto L4;
    L8:
        this.mPresenters.remove(r12);
        goto L4
    }

    public void restoreActionViewStates(Bundle r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        SparseArray<Parcelable> r11 = r10.getSparseParcelableArray(getActionViewStatesKey());
        int r12 = size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L15;
        MenuItem r14 = getItem(r13);
        View r15 = r14.getActionView();
        if (r15 == null) goto L12;
        if (r15.getId() == (-1)) goto L12;
        r15.restoreHierarchyState(r11);
    L12:
        if (r14.hasSubMenu() == false) goto L14;
        ((SubMenuBuilder) r14.getSubMenu()).restoreActionViewStates(r10);
    L14:
        r13 = r13 + 1;
        goto L5
    L15:
        int r16 = r10.getInt(EXPANDED_ACTION_VIEW_ID);
        if (r16 <= 0) goto L24;
        MenuItem r17 = findItem(r16);
        if (r17 == null) goto L25;
        r17.expandActionView();
        return;
    L25:
        return;
    }

    public void restorePresenterStates(Bundle r10) {
        dispatchRestoreInstanceState(r10);
    }

    public void saveActionViewStates(Bundle r10) {
        int r11 = size();
        SparseArray<? extends Parcelable> r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L17;
        MenuItem r14 = getItem(r13);
        View r15 = r14.getActionView();
        if (r15 == null) goto L14;
        if (r15.getId() == (-1)) goto L14;
        if (r12 != null) goto L10;
        r12 = new SparseArray();
    L10:
        r15.saveHierarchyState(r12);
        if (r14.isActionViewExpanded() == false) goto L14;
        r10.putInt(EXPANDED_ACTION_VIEW_ID, r14.getItemId());
    L14:
        if (r14.hasSubMenu() == false) goto L16;
        ((SubMenuBuilder) r14.getSubMenu()).saveActionViewStates(r10);
    L16:
        r13 = r13 + 1;
        goto L3
    L17:
        if (r12 == null) goto L23;
        r10.putSparseParcelableArray(getActionViewStatesKey(), r12);
        return;
    }

    public void savePresenterStates(Bundle r10) {
        dispatchSaveInstanceState(r10);
    }

    public void setCallback(Callback r10) {
        this.mCallback = r10;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo r10) {
        this.mCurrentMenuInfo = r10;
    }

    public MenuBuilder setDefaultShowAsAction(int r10) {
        this.mDefaultShowAsAction = r10;
        return this;
    }

    void setExclusiveItemChecked(MenuItem r10) {
        int r11 = r10.getGroupId();
        int r12 = this.mItems.size();
        stopDispatchingItemsChanged();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L17;
        MenuItemImpl r14 = this.mItems.get(r13);
        if (r14.getGroupId() != r11) goto L16;
        if (r14.isExclusiveCheckable() == false) goto L16;
        if (r14.isCheckable() == false) goto L16;
        if (r14 != r10) goto L14;
        boolean r15 = true;
    L15:
        r14.setCheckedInt(r15);
        goto L16
    L14:
        r15 = false;
    L16:
        r13 = r13 + 1;
        goto L3
    L17:
        startDispatchingItemsChanged();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int r10, boolean r11, boolean r12) {
        int r13 = this.mItems.size();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        MenuItemImpl r15 = this.mItems.get(r14);
        if (r15.getGroupId() != r10) goto L7;
        r15.setExclusiveCheckable(r12);
        r15.setCheckable(r11);
    L7:
        r14 = r14 + 1;
        goto L3
    }

    @Override // androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean r10) {
        this.mGroupDividerEnabled = r10;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int r10, boolean r11) {
        int r12 = this.mItems.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        MenuItemImpl r14 = this.mItems.get(r13);
        if (r14.getGroupId() != r10) goto L7;
        r14.setEnabled(r11);
    L7:
        r13 = r13 + 1;
        goto L3
    }

    @Override // android.view.Menu
    public void setGroupVisible(int r10, boolean r11) {
        int r12 = this.mItems.size();
        int r13 = 0;
        boolean r14 = false;
    L4:
        if (r13 >= r12) goto L11;
        MenuItemImpl r15 = this.mItems.get(r13);
        if (r15.getGroupId() != r10) goto L10;
        if (r15.setVisibleInt(r11) == false) goto L10;
        r14 = true;
    L10:
        r13 = r13 + 1;
        goto L4
    L11:
        if (r14 == false) goto L18;
        onItemsChanged(true);
        return;
    }

    protected MenuBuilder setHeaderIconInt(int r10) {
        setHeaderInternal(0, null, r10, null, null);
        return this;
    }

    protected MenuBuilder setHeaderIconInt(Drawable r10) {
        setHeaderInternal(0, null, 0, r10, null);
        return this;
    }

    protected MenuBuilder setHeaderTitleInt(int r10) {
        setHeaderInternal(r10, null, 0, null, null);
        return this;
    }

    protected MenuBuilder setHeaderTitleInt(CharSequence r10) {
        setHeaderInternal(0, r10, 0, null, null);
        return this;
    }

    protected MenuBuilder setHeaderViewInt(View r10) {
        setHeaderInternal(0, null, 0, null, r10);
        return this;
    }

    public void setOptionalIconsVisible(boolean r10) {
        this.mOptionalIconsVisible = r10;
    }

    public void setOverrideVisibleItems(boolean r10) {
        this.mOverrideVisibleItems = r10;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean r10) {
        this.mQwertyMode = r10;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean r10) {
        if (this.mShortcutsVisible != r10) goto L5;
        return;
    L5:
        setShortcutsVisibleInner(r10);
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
}
