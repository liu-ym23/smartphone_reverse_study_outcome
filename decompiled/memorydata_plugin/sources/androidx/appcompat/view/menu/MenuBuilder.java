package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewConfigurationCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
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

    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder r1, MenuItem r2);

        void onMenuModeChange(MenuBuilder r1);
    }

    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl r1);
    }

    static {
        sCategoryToOrder = new int[]{1, 4, 5, 3, 2, 0};
    }

    public MenuBuilder(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mDefaultShowAsAction = 0;
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        this.mOptionalIconsVisible = false;
        this.mIsClosing = false;
        this.mTempShortcutItemList = new ArrayList();
        this.mPresenters = new CopyOnWriteArrayList();
        this.mGroupDividerEnabled = false;
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.mResources = ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin");
        this.mItems = new ArrayList();
        this.mVisibleItems = new ArrayList();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList();
        this.mNonActionItems = new ArrayList();
        this.mIsActionItemsStale = true;
        setShortcutsVisibleInner(true);
    }

    private MenuItemImpl createNewMenuItem(int r9, int r10, int r11, int r12, CharSequence r13, int r14) {
        return new MenuItemImpl(this, r9, r10, r11, r12, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin"), r14);
    }

    private void dispatchPresenterUpdate(boolean r6) {
        if (this.mPresenters.isEmpty() == false) goto L5;
        return;
    L5:
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r0 = this.mPresenters.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin");
        MenuPresenter r2 = (MenuPresenter) ZeusTransformUtils.preCheckCast(r1.get(), MenuPresenter.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        r2.updateMenuView(r6);
        goto L7
    L10:
        this.mPresenters.remove(r1);
        goto L7
    L12:
        startDispatchingItemsChanged();
    }

    private void dispatchRestoreInstanceState(Bundle r6) {
        SparseArray r7 = r6.getSparseParcelableArray(PRESENTER_KEY);
        if (r7 != null) goto L5;
        return;
    L5:
        if (this.mPresenters.isEmpty() == true) goto L29;
        Iterator<WeakReference<MenuPresenter>> r0 = this.mPresenters.iterator();
    L9:
        if (r0.hasNext() == false) goto L30;
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin");
        MenuPresenter r2 = (MenuPresenter) ZeusTransformUtils.preCheckCast(r1.get(), MenuPresenter.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L12;
        int r3 = r2.getId();
        if (r3 <= 0) goto L9;
        Parcelable r4 = (Parcelable) ZeusTransformUtils.preCheckCast(r7.get(r3), Parcelable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        r2.onRestoreInstanceState(r4);
        goto L9
    L12:
        this.mPresenters.remove(r1);
        goto L9
    L30:
        return;
    }

    private void dispatchSaveInstanceState(Bundle r7) {
        if (this.mPresenters.isEmpty() == false) goto L5;
        return;
    L5:
        SparseArray<? extends Parcelable> r0 = new SparseArray();
        Iterator<WeakReference<MenuPresenter>> r1 = this.mPresenters.iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(r1.next(), WeakReference.class, "com.obric.memorydata.plugin");
        MenuPresenter r3 = (MenuPresenter) ZeusTransformUtils.preCheckCast(r2.get(), MenuPresenter.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        int r4 = r3.getId();
        if (r4 <= 0) goto L7;
        Parcelable r5 = r3.onSaveInstanceState();
        if (r5 == null) goto L7;
        r0.put(r4, r5);
        goto L7
    L10:
        this.mPresenters.remove(r2);
        goto L7
    L16:
        r7.putSparseParcelableArray(PRESENTER_KEY, r0);
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder r6, MenuPresenter r7) {
        MenuPresenter r8 = (MenuPresenter) ZeusTransformUtils.wrapperContextForParams(r7, MenuPresenter.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
        return false;
    L5:
        if (r8 == null) goto L7;
        r2 = r8.onSubMenuSelected(r6);
    L7:
        Iterator<WeakReference<MenuPresenter>> r9 = this.mPresenters.iterator();
    L9:
        if (r9.hasNext() == false) goto L15;
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(r9.next(), WeakReference.class, "com.obric.memorydata.plugin");
        MenuPresenter r3 = (MenuPresenter) ZeusTransformUtils.preCheckCast(r0.get(), MenuPresenter.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        if (r2 == true) goto L9;
        r2 = r3.onSubMenuSelected(r6);
        goto L9
    L12:
        this.mPresenters.remove(r0);
        goto L9
    L15:
        return r2;
    }

    private static int findInsertIndex(ArrayList<MenuItemImpl> r4, int r5) {
        int r0 = r4.size() - 1;
    L3:
        if (r0 < 0) goto L9;
        if (((MenuItemImpl) ZeusTransformUtils.preCheckCast(r4.get(r0), MenuItemImpl.class, "com.obric.memorydata.plugin")).getOrdering() <= r5) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return r0 + 1;
    L9:
        return 0;
    }

    private static int getOrdering(int r3) {
        int r0 = ((-65536) & r3) >> 16;
        if (r0 < 0) goto L9;
        int[] r1 = sCategoryToOrder;
        if (r0 >= r1.length) goto L9;
        int r4 = r3 & 65535;
        return r4 | (r1[r0] << 16);
    L9:
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void removeItemAtInt(int r2, boolean r3) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= this.mItems.size()) goto L12;
        this.mItems.remove(r2);
        if (r3 == false) goto L11;
        onItemsChanged(true);
        return;
    L11:
        return;
    }

    private void setHeaderInternal(int r4, CharSequence r5, int r6, Drawable r7, View r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Resources r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        if (r8 == null) goto L5;
        this.mHeaderView = r8;
        this.mHeaderTitle = null;
        this.mHeaderIcon = null;
    L14:
        onItemsChanged(false);
        return;
    L5:
        if (r4 <= 0) goto L7;
        this.mHeaderTitle = r0.getText(r4);
    L9:
        if (r6 <= 0) goto L11;
        this.mHeaderIcon = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r6);
    L13:
        this.mHeaderView = null;
        goto L14
    L11:
        if (r7 == null) goto L13;
        this.mHeaderIcon = r7;
        goto L13
    L7:
        if (r9 == null) goto L9;
        this.mHeaderTitle = r9;
        goto L9
    }

    private void setShortcutsVisibleInner(boolean r3) {
        boolean r0 = true;
        if (r3 == true) goto L5;
    L9:
        r0 = false;
    L10:
        this.mShortcutsVisible = r0;
        return;
    L5:
        if (this.mResources.getConfiguration().keyboard == 1) goto L9;
        if (ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.mContext), this.mContext) == false) goto L9;
        goto L9
    }

    @Override // android.view.Menu
    public MenuItem add(int r2) {
        return addInternal(0, 0, 0, this.mResources.getString(r2));
    }

    @Override // android.view.Menu
    public MenuItem add(int r2, int r3, int r4, int r5) {
        return addInternal(r2, r3, r4, this.mResources.getString(r5));
    }

    @Override // android.view.Menu
    public MenuItem add(int r3, int r4, int r5, CharSequence r6) {
        return addInternal(r3, r4, r5, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence r3) {
        return addInternal(0, 0, 0, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int r8, int r9, int r10, ComponentName r11, Intent[] r12, Intent r13, int r14, MenuItem[] r15) {
        PackageManager r0 = this.mContext.getPackageManager();
        int r1 = 0;
        List<ResolveInfo> r16 = r0.queryIntentActivityOptions(r11, r12, r13, 0);
        if (r16 == null) goto L5;
        int r2 = r16.size();
    L7:
        if ((r14 & 1) != 0) goto L9;
        removeGroup(r8);
    L9:
        if (r1 >= r2) goto L20;
        ResolveInfo r17 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r16.get(r1), ResolveInfo.class, "com.obric.memorydata.plugin");
        if (r17.specificIndex >= 0) goto L13;
        Intent r4 = r13;
    L14:
        Intent r3 = new Intent(r4);
        r3.setComponent(new ComponentName(r17.activityInfo.applicationInfo.packageName, r17.activityInfo.name));
        MenuItem r5 = add(r8, r9, r10, r17.loadLabel(r0)).setIcon(r17.loadIcon(r0)).setIntent(r3);
        if (r15 == null) goto L19;
        if (r17.specificIndex < 0) goto L19;
        r15[r17.specificIndex] = r5;
    L19:
        r1 = r1 + 1;
        goto L9
    L13:
        r4 = r12[r17.specificIndex];
        goto L14
    L20:
        return r2;
    L5:
        r2 = 0;
        goto L7
    }

    public MenuItem addInternal(int r8, int r9, int r10, CharSequence r11) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        int r12 = getOrdering(r10);
        MenuItemImpl r13 = createNewMenuItem(r8, r9, r10, r12, r5, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo r14 = this.mCurrentMenuInfo;
        if (r14 == null) goto L5;
        r13.setMenuInfo(r14);
    L5:
        ArrayList<MenuItemImpl> r15 = this.mItems;
        r15.add(findInsertIndex(r15, r12), r13);
        onItemsChanged(true);
        return r13;
    }

    public void addMenuPresenter(MenuPresenter r3) {
        addMenuPresenter((MenuPresenter) ZeusTransformUtils.wrapperContextForParams(r3, MenuPresenter.class, "com.obric.memorydata.plugin"), this.mContext);
    }

    public void addMenuPresenter(MenuPresenter r3, Context r4) {
        MenuPresenter r5 = (MenuPresenter) ZeusTransformUtils.wrapperContextForParams(r3, MenuPresenter.class, "com.obric.memorydata.plugin");
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mPresenters.add(new WeakReference(r5));
        r5.initForMenu(r6, this);
        this.mIsActionItemsStale = true;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r2) {
        return addSubMenu(0, 0, 0, this.mResources.getString(r2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r2, int r3, int r4, int r5) {
        return addSubMenu(r2, r3, r4, this.mResources.getString(r5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r3, int r4, int r5, CharSequence r6) {
        MenuItemImpl r7 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(addInternal(r3, r4, r5, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin")), MenuItemImpl.class, "com.obric.memorydata.plugin");
        SubMenuBuilder r8 = new SubMenuBuilder(this.mContext, this, r7);
        r7.setSubMenu(r8);
        return r8;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence r3) {
        return addSubMenu(0, 0, 0, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public void changeMenuMode() {
        Callback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onMenuModeChange(this);
        return;
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl r0 = this.mExpandedItem;
        if (r0 == null) goto L5;
        collapseItemActionView(r0);
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

    public final void close(boolean r6) {
        if (this.mIsClosing == false) goto L5;
        return;
    L5:
        this.mIsClosing = true;
        Iterator<WeakReference<MenuPresenter>> r0 = this.mPresenters.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin");
        MenuPresenter r2 = (MenuPresenter) ZeusTransformUtils.preCheckCast(r1.get(), MenuPresenter.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        r2.onCloseMenu(this, r6);
        goto L7
    L10:
        this.mPresenters.remove(r1);
        goto L7
    L12:
        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(MenuItemImpl r7) {
        boolean r1 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
    L18:
        return r1;
    L5:
        if (this.mExpandedItem != r7) goto L18;
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r0 = this.mPresenters.iterator();
    L9:
        if (r0.hasNext() == false) goto L15;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin");
        MenuPresenter r3 = (MenuPresenter) ZeusTransformUtils.preCheckCast(r2.get(), MenuPresenter.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        r1 = r3.collapseItemActionView(this, r7);
        if (r1 == false) goto L9;
    L12:
        this.mPresenters.remove(r2);
    L15:
        startDispatchingItemsChanged();
        if (r1 == false) goto L18;
        this.mExpandedItem = null;
        goto L18
    }

    boolean dispatchMenuItemSelected(MenuBuilder r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
        Callback r2 = this.mCallback;
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.onMenuItemSelected(r3, r5) == false) goto L7;
        return true;
    }

    public boolean expandItemActionView(MenuItemImpl r7) {
        boolean r1 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
        return false;
    L5:
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r0 = this.mPresenters.iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin");
        MenuPresenter r3 = (MenuPresenter) ZeusTransformUtils.preCheckCast(r2.get(), MenuPresenter.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        r1 = r3.expandItemActionView(this, r7);
        if (r1 == false) goto L7;
    L10:
        this.mPresenters.remove(r2);
    L13:
        startDispatchingItemsChanged();
        if (r1 == false) goto L16;
        this.mExpandedItem = r7;
    L16:
        return r1;
    }

    public int findGroupIndex(int r2) {
        return findGroupIndex(r2, 0);
    }

    public int findGroupIndex(int r5, int r6) {
        int r0 = size();
        if (r6 >= 0) goto L5;
        r6 = 0;
    L5:
        if (r6 >= r0) goto L10;
        if (((MenuItemImpl) ZeusTransformUtils.preCheckCast(this.mItems.get(r6), MenuItemImpl.class, "com.obric.memorydata.plugin")).getGroupId() == r5) goto L8;
        r6 = r6 + 1;
        goto L5
    L8:
        return r6;
    L10:
        return -1;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int r6) {
        int r0 = size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        MenuItemImpl r2 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(this.mItems.get(r1), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r2.getItemId() == r6) goto L6;
        if (r2.hasSubMenu() == false) goto L12;
        MenuItem r3 = r2.getSubMenu().findItem(r6);
        if (r3 == null) goto L12;
        return r3;
    L12:
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L13:
        return null;
    }

    public int findItemIndex(int r6) {
        int r0 = size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (((MenuItemImpl) ZeusTransformUtils.preCheckCast(this.mItems.get(r1), MenuItemImpl.class, "com.obric.memorydata.plugin")).getItemId() == r6) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    MenuItemImpl findItemWithShortcutForKey(int r12, KeyEvent r13) {
        ArrayList<MenuItemImpl> r0 = this.mTempShortcutItemList;
        r0.clear();
        findItemsWithShortcutForKey(r0, r12, r13);
        if (r0.isEmpty() == false) goto L5;
        return null;
    L5:
        int r1 = r13.getMetaState();
        KeyCharacterMap.KeyData r3 = new KeyCharacterMap.KeyData();
        r13.getKeyData(r3);
        int r14 = r0.size();
        if (r14 == 1) goto L8;
        boolean r11 = isQwertyMode();
        int r5 = 0;
    L10:
        if (r5 >= r14) goto L30;
        MenuItemImpl r7 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(r0.get(r5), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r11 == false) goto L14;
        char r8 = r7.getAlphabeticShortcut();
    L16:
        if (r8 != r3.meta[0]) goto L20;
        if ((r1 & 2) != 0) goto L20;
    L28:
        return r7;
    L20:
        if (r8 == r3.meta[2]) goto L22;
    L23:
        if (r11 == false) goto L29;
        if (r8 != '\b') goto L29;
        if (r12 == 67) goto L28;
    L29:
        r5 = r5 + 1;
        goto L10
    L22:
        if ((r1 & 2) != 0) goto L28;
    L14:
        r8 = r7.getNumericShortcut();
        goto L16
    L30:
        return null;
    L8:
        return (MenuItemImpl) ZeusTransformUtils.preCheckCast(r0.get(0), MenuItemImpl.class, "com.obric.memorydata.plugin");
    }

    void findItemsWithShortcutForKey(List<MenuItemImpl> r17, int r18, KeyEvent r19) {
        List<MenuItemImpl> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        boolean r5 = isQwertyMode();
        int r6 = r19.getModifiers();
        KeyCharacterMap.KeyData r7 = new KeyCharacterMap.KeyData();
        if (r19.getKeyData(r7) == true) goto L6;
        if (r18 == 67) goto L6;
        return;
    L6:
        int r8 = this.mItems.size();
        int r11 = 0;
    L7:
        if (r11 >= r8) goto L39;
        MenuItemImpl r12 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(this.mItems.get(r11), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r12.hasSubMenu() == false) goto L11;
        ((MenuBuilder) ZeusTransformUtils.preCheckCast(r12.getSubMenu(), MenuBuilder.class, "com.obric.memorydata.plugin")).findItemsWithShortcutForKey(r3, r18, r19);
    L11:
        if (r5 == false) goto L13;
        char r13 = r12.getAlphabeticShortcut();
    L14:
        if (r5 == false) goto L16;
        int r14 = r12.getAlphabeticModifiers();
    L18:
        if ((r6 & SupportMenu.SUPPORTED_MODIFIERS_MASK) != (r14 & SupportMenu.SUPPORTED_MODIFIERS_MASK)) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L38;
        if (r13 == 0) goto L38;
        if (r13 == r7.meta[0]) goto L35;
        if (r13 == r7.meta[2]) goto L35;
        if (r5 == false) goto L38;
        if (r13 != '\b') goto L38;
        if (r18 != 67) goto L38;
    L35:
        if (r12.isEnabled() == false) goto L38;
        r3.add(r12);
    L38:
        r11 = r11 + 1;
        goto L7
    L20:
        r9 = false;
        goto L21
    L16:
        r14 = r12.getNumericModifiers();
        goto L18
    L13:
        r13 = r12.getNumericShortcut();
        goto L14
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> r0 = getVisibleItems();
        if (this.mIsActionItemsStale == true) goto L5;
        return;
    L5:
        Iterator<WeakReference<MenuPresenter>> r1 = this.mPresenters.iterator();
        boolean r3 = false;
    L7:
        if (r1.hasNext() == false) goto L12;
        WeakReference r4 = (WeakReference) ZeusTransformUtils.preCheckCast(r1.next(), WeakReference.class, "com.obric.memorydata.plugin");
        MenuPresenter r5 = (MenuPresenter) ZeusTransformUtils.preCheckCast(r4.get(), MenuPresenter.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L10;
        r3 = r3 | r5.flagActionItems();
        goto L7
    L10:
        this.mPresenters.remove(r4);
        goto L7
    L12:
        if (r3 == false) goto L20;
        this.mActionItems.clear();
        this.mNonActionItems.clear();
        int r2 = r0.size();
        int r6 = 0;
    L14:
        if (r6 >= r2) goto L21;
        MenuItemImpl r7 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(r0.get(r6), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r7.isActionButton() == false) goto L18;
        ArrayList<MenuItemImpl> r8 = this.mActionItems;
    L19:
        r8.add(r7);
        r6 = r6 + 1;
        goto L14
    L18:
        r8 = this.mNonActionItems;
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
    public MenuItem getItem(int r2) {
        return (MenuItem) ZeusTransformUtils.preCheckCast(this.mItems.get(r2), MenuItem.class, "com.obric.memorydata.plugin");
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

    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (this.mIsVisibleItemsStale == false) goto L5;
        this.mVisibleItems.clear();
        int r0 = this.mItems.size();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L12;
        MenuItemImpl r3 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(this.mItems.get(r2), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r3.isVisible() == false) goto L11;
        this.mVisibleItems.add(r3);
    L11:
        r2 = r2 + 1;
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
        int r0 = size();
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L11;
        if (((MenuItemImpl) ZeusTransformUtils.preCheckCast(this.mItems.get(r3), MenuItemImpl.class, "com.obric.memorydata.plugin")).isVisible() == true) goto L9;
        r3 = r3 + 1;
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
    public boolean isShortcutKey(int r1, KeyEvent r2) {
        if (findItemWithShortcutForKey(r1, r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    void onItemActionRequestChanged(MenuItemImpl r1) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    void onItemVisibleChanged(MenuItemImpl r1) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean r3) {
        if (this.mPreventDispatchingItemsChanged == true) goto L7;
        if (r3 == false) goto L6;
        this.mIsVisibleItemsStale = true;
        this.mIsActionItemsStale = true;
    L6:
        dispatchPresenterUpdate(r3);
        return;
    L7:
        this.mItemsChangedWhileDispatchPrevented = true;
        if (r3 == false) goto L12;
        this.mStructureChangedWhileDispatchPrevented = true;
        return;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int r1, int r2) {
        return performItemAction(findItem(r1), r2);
    }

    public boolean performItemAction(MenuItem r3, int r4) {
        return performItemAction((MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin"), null, r4);
    }

    public boolean performItemAction(MenuItem r8, MenuPresenter r9, int r10) {
        MenuItem r11 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r8, MenuItem.class, "com.obric.memorydata.plugin");
        MenuPresenter r12 = (MenuPresenter) ZeusTransformUtils.wrapperContextForParams(r9, MenuPresenter.class, "com.obric.memorydata.plugin");
        MenuItemImpl r13 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(r11, MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L5;
    L38:
        return false;
    L5:
        if (r13.isEnabled() == false) goto L38;
        boolean r2 = r13.invoke();
        ActionProvider r3 = r13.getSupportActionProvider();
        if (r3 != null) goto L10;
    L12:
        boolean r5 = false;
    L14:
        if (r13.hasCollapsibleActionView() == false) goto L19;
        r2 = r2 | r13.expandActionView();
        if (r2 == false) goto L37;
    L17:
        close(true);
    L37:
        return r2;
    L19:
        if (r13.hasSubMenu() == true) goto L26;
        if (r5 == true) goto L26;
        if ((r10 & 1) != 0) goto L37;
    L26:
        if ((r10 & 4) != 0) goto L29;
        close(false);
    L29:
        if (r13.hasSubMenu() == true) goto L31;
        r13.setSubMenu(new SubMenuBuilder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this, r13));
    L31:
        SubMenuBuilder r14 = (SubMenuBuilder) ZeusTransformUtils.preCheckCast(r13.getSubMenu(), SubMenuBuilder.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L34;
        r3.onPrepareSubMenu(r14);
    L34:
        r2 = r2 | dispatchSubMenuSelected(r14, r12);
        if (r2 == true) goto L37;
    L10:
        if (r3.hasSubMenu() == false) goto L12;
        r5 = true;
        goto L14
    }

    @Override // android.view.Menu
    public boolean performShortcut(int r1, KeyEvent r2, int r3) {
        MenuItemImpl r4 = findItemWithShortcutForKey(r1, r2);
        if (r4 == null) goto L5;
        boolean r5 = performItemAction(r4, r3);
    L7:
        if ((r3 & 2) == 0) goto L9;
        close(true);
    L9:
        return r5;
    L5:
        r5 = false;
        goto L7
    }

    @Override // android.view.Menu
    public void removeGroup(int r8) {
        int r0 = findGroupIndex(r8);
        if (r0 < 0) goto L14;
        int r1 = this.mItems.size() - r0;
        int r3 = 0;
    L5:
        int r4 = r3 + 1;
        if (r3 >= r1) goto L10;
        if (((MenuItemImpl) ZeusTransformUtils.preCheckCast(this.mItems.get(r0), MenuItemImpl.class, "com.obric.memorydata.plugin")).getGroupId() != r8) goto L10;
        removeItemAtInt(r0, false);
        r3 = r4;
    L10:
        onItemsChanged(true);
        return;
    }

    @Override // android.view.Menu
    public void removeItem(int r2) {
        removeItemAtInt(findItemIndex(r2), true);
    }

    public void removeItemAt(int r2) {
        removeItemAtInt(r2, true);
    }

    public void removeMenuPresenter(MenuPresenter r6) {
        MenuPresenter r7 = (MenuPresenter) ZeusTransformUtils.wrapperContextForParams(r6, MenuPresenter.class, "com.obric.memorydata.plugin");
        Iterator<WeakReference<MenuPresenter>> r0 = this.mPresenters.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin");
        MenuPresenter r3 = (MenuPresenter) ZeusTransformUtils.preCheckCast(r2.get(), MenuPresenter.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        if (r3 != r7) goto L4;
    L8:
        this.mPresenters.remove(r2);
        goto L4
    }

    public void restoreActionViewStates(Bundle r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        SparseArray<Parcelable> r0 = r8.getSparseParcelableArray(getActionViewStatesKey());
        int r1 = size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L15;
        MenuItem r3 = getItem(r2);
        View r4 = r3.getActionView();
        if (r4 == null) goto L12;
        if (r4.getId() == (-1)) goto L12;
        r4.restoreHierarchyState(r0);
    L12:
        if (r3.hasSubMenu() == false) goto L14;
        ((SubMenuBuilder) ZeusTransformUtils.preCheckCast(r3.getSubMenu(), SubMenuBuilder.class, "com.obric.memorydata.plugin")).restoreActionViewStates(r8);
    L14:
        r2 = r2 + 1;
        goto L5
    L15:
        int r9 = r8.getInt(EXPANDED_ACTION_VIEW_ID);
        if (r9 <= 0) goto L24;
        MenuItem r7 = findItem(r9);
        if (r7 == null) goto L25;
        r7.expandActionView();
        return;
    L25:
        return;
    }

    public void restorePresenterStates(Bundle r1) {
        dispatchRestoreInstanceState(r1);
    }

    public void saveActionViewStates(Bundle r8) {
        int r0 = size();
        SparseArray<? extends Parcelable> r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L17;
        MenuItem r3 = getItem(r2);
        View r4 = r3.getActionView();
        if (r4 == null) goto L14;
        if (r4.getId() == (-1)) goto L14;
        if (r1 != null) goto L10;
        r1 = new SparseArray();
    L10:
        r4.saveHierarchyState(r1);
        if (r3.isActionViewExpanded() == false) goto L14;
        r8.putInt(EXPANDED_ACTION_VIEW_ID, r3.getItemId());
    L14:
        if (r3.hasSubMenu() == false) goto L16;
        ((SubMenuBuilder) ZeusTransformUtils.preCheckCast(r3.getSubMenu(), SubMenuBuilder.class, "com.obric.memorydata.plugin")).saveActionViewStates(r8);
    L16:
        r2 = r2 + 1;
        goto L3
    L17:
        if (r1 == null) goto L23;
        r8.putSparseParcelableArray(getActionViewStatesKey(), r1);
        return;
    }

    public void savePresenterStates(Bundle r1) {
        dispatchSaveInstanceState(r1);
    }

    public void setCallback(Callback r3) {
        this.mCallback = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo r3) {
        this.mCurrentMenuInfo = (ContextMenu.ContextMenuInfo) ZeusTransformUtils.wrapperContextForParams(r3, ContextMenu.ContextMenuInfo.class, "com.obric.memorydata.plugin");
    }

    public MenuBuilder setDefaultShowAsAction(int r1) {
        this.mDefaultShowAsAction = r1;
        return this;
    }

    void setExclusiveItemChecked(MenuItem r8) {
        MenuItem r9 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r8, MenuItem.class, "com.obric.memorydata.plugin");
        int r0 = r9.getGroupId();
        int r2 = this.mItems.size();
        stopDispatchingItemsChanged();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L17;
        MenuItemImpl r5 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(this.mItems.get(r4), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r5.getGroupId() != r0) goto L16;
        if (r5.isExclusiveCheckable() == false) goto L16;
        if (r5.isCheckable() == false) goto L16;
        if (r5 != r9) goto L14;
        boolean r6 = true;
    L15:
        r5.setCheckedInt(r6);
        goto L16
    L14:
        r6 = false;
    L16:
        r4 = r4 + 1;
        goto L3
    L17:
        startDispatchingItemsChanged();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int r6, boolean r7, boolean r8) {
        int r0 = this.mItems.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        MenuItemImpl r2 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(this.mItems.get(r1), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r2.getGroupId() != r6) goto L7;
        r2.setExclusiveCheckable(r8);
        r2.setCheckable(r7);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean r1) {
        this.mGroupDividerEnabled = r1;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int r6, boolean r7) {
        int r0 = this.mItems.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        MenuItemImpl r2 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(this.mItems.get(r1), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r2.getGroupId() != r6) goto L7;
        r2.setEnabled(r7);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.view.Menu
    public void setGroupVisible(int r8, boolean r9) {
        int r0 = this.mItems.size();
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= r0) goto L11;
        MenuItemImpl r4 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(this.mItems.get(r1), MenuItemImpl.class, "com.obric.memorydata.plugin");
        if (r4.getGroupId() != r8) goto L10;
        if (r4.setVisibleInt(r9) == false) goto L10;
        r2 = true;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        if (r2 == false) goto L18;
        onItemsChanged(true);
        return;
    }

    public MenuBuilder setHeaderIconInt(int r7) {
        setHeaderInternal(0, null, r7, null, null);
        return this;
    }

    public MenuBuilder setHeaderIconInt(Drawable r7) {
        setHeaderInternal(0, null, 0, r7, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(int r7) {
        setHeaderInternal(r7, null, 0, null, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(CharSequence r7) {
        setHeaderInternal(0, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null);
        return this;
    }

    public MenuBuilder setHeaderViewInt(View r7) {
        setHeaderInternal(0, null, 0, null, r7);
        return this;
    }

    public void setOptionalIconsVisible(boolean r1) {
        this.mOptionalIconsVisible = r1;
    }

    public void setOverrideVisibleItems(boolean r1) {
        this.mOverrideVisibleItems = r1;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean r1) {
        this.mQwertyMode = r1;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean r2) {
        if (this.mShortcutsVisible != r2) goto L5;
        return;
    L5:
        setShortcutsVisibleInner(r2);
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
