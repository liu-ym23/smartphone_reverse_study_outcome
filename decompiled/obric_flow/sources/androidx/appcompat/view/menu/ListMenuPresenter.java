package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    private static final String TAG = "ListMenuPresenter";
    public static final String VIEWS_TAG = "android:menu:list";
    MenuAdapter mAdapter;
    private MenuPresenter.Callback mCallback;
    Context mContext;
    private int mId;
    LayoutInflater mInflater;
    int mItemIndexOffset;
    int mItemLayoutRes;
    MenuBuilder mMenu;
    ExpandedMenuView mMenuView;
    int mThemeRes;

    public class MenuAdapter extends BaseAdapter {
        private int mExpandedIndex;
        final /* synthetic */ ListMenuPresenter this$0;

        public MenuAdapter(ListMenuPresenter r5) {
            this.this$0 = r5;
            this.mExpandedIndex = -1;
            findExpandedIndex();
        }

        public void findExpandedIndex() {
            MenuItemImpl r5 = this.this$0.mMenu.getExpandedItem();
            if (r5 == null) goto L11;
            ArrayList<MenuItemImpl> r10 = this.this$0.mMenu.getNonActionItems();
            int r11 = r10.size();
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L11;
            if (r10.get(r12) == r5) goto L8;
            r12 = r12 + 1;
            goto L5
        L8:
            this.mExpandedIndex = r12;
            return;
        L11:
            this.mExpandedIndex = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int r5 = this.this$0.mMenu.getNonActionItems().size() - this.this$0.mItemIndexOffset;
            if (this.mExpandedIndex >= 0) goto L6;
            return r5;
        L6:
            return r5 - 1;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r5) {
            return getItem(r5);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r5) {
            return r5;
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r10, ViewGroup r11) {
            if (r10 != null) goto L5;
            ListMenuPresenter r12 = this.this$0;
            r10 = r12.mInflater.inflate(r12.mItemLayoutRes, r11, false);
        L5:
            ((MenuView.ItemView) r10).initialize(getItem(r5), 0);
            return r10;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            findExpandedIndex();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public MenuItemImpl getItem(int r5) {
            ArrayList<MenuItemImpl> r10 = this.this$0.mMenu.getNonActionItems();
            int r11 = r5 + this.this$0.mItemIndexOffset;
            int r12 = this.mExpandedIndex;
            if (r12 < 0) goto L7;
            if (r11 < r12) goto L7;
            r11 = r11 + 1;
        L7:
            return r10.get(r11);
        }
    }

    public ListMenuPresenter(Context r5, int r10) {
        this(r10, 0);
        this.mContext = r5;
        this.mInflater = LayoutInflater.from(r5);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r5, MenuItemImpl r10) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r5, MenuItemImpl r10) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public ListAdapter getAdapter() {
        if (this.mAdapter != null) goto L6;
        this.mAdapter = new MenuAdapter(this);
    L6:
        return this.mAdapter;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.mId;
    }

    public int getItemIndexOffset() {
        return this.mItemIndexOffset;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r5) {
        if (this.mMenuView != null) goto L9;
        this.mMenuView = (ExpandedMenuView) this.mInflater.inflate(R.layout.abc_expanded_menu_layout, r5, false);
        if (this.mAdapter != null) goto L7;
        this.mAdapter = new MenuAdapter(this);
    L7:
        this.mMenuView.setAdapter(this.mAdapter);
        this.mMenuView.setOnItemClickListener(this);
    L9:
        return this.mMenuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r5, MenuBuilder r10) {
        if (this.mThemeRes == 0) goto L6;
        ContextThemeWrapper r11 = new ContextThemeWrapper(r5, this.mThemeRes);
        this.mContext = r11;
        this.mInflater = LayoutInflater.from(r11);
    L10:
        this.mMenu = r10;
        MenuAdapter r12 = this.mAdapter;
        if (r12 == null) goto L14;
        r12.notifyDataSetChanged();
        return;
    L14:
        return;
    L6:
        if (this.mContext == null) goto L10;
        this.mContext = r5;
        if (this.mInflater != null) goto L10;
        this.mInflater = LayoutInflater.from(r5);
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r5, boolean r10) {
        MenuPresenter.Callback r11 = this.mCallback;
        if (r11 == null) goto L6;
        r11.onCloseMenu(r5, r10);
        return;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r5, View r10, int r11, long r12) {
        this.mMenu.performItemAction(this.mAdapter.getItem(r11), this, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r5) {
        restoreHierarchyState((Bundle) r5);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        if (this.mMenuView != null) goto L6;
        return null;
    L6:
        Bundle r5 = new Bundle();
        saveHierarchyState(r5);
        return r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r5) {
        if (r5.hasVisibleItems() == true) goto L6;
        return false;
    L6:
        new MenuDialogHelper(r5).show(null);
        MenuPresenter.Callback r10 = this.mCallback;
        if (r10 == null) goto L11;
        r10.onOpenSubMenu(r5);
        return true;
    L11:
        return true;
    }

    public void restoreHierarchyState(Bundle r5) {
        SparseArray<Parcelable> r10 = r5.getSparseParcelableArray(VIEWS_TAG);
        if (r10 == null) goto L6;
        this.mMenuView.restoreHierarchyState(r10);
        return;
    }

    public void saveHierarchyState(Bundle r5) {
        SparseArray<Parcelable> r10 = new SparseArray();
        ExpandedMenuView r11 = this.mMenuView;
        if (r11 == null) goto L5;
        r11.saveHierarchyState(r10);
    L5:
        r5.putSparseParcelableArray(VIEWS_TAG, r10);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r5) {
        this.mCallback = r5;
    }

    public void setId(int r5) {
        this.mId = r5;
    }

    public void setItemIndexOffset(int r5) {
        this.mItemIndexOffset = r5;
        if (this.mMenuView == null) goto L6;
        updateMenuView(false);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r5) {
        MenuAdapter r10 = this.mAdapter;
        if (r10 == null) goto L6;
        r10.notifyDataSetChanged();
        return;
    }

    public ListMenuPresenter(int r5, int r10) {
        this.mItemLayoutRes = r5;
        this.mThemeRes = r10;
    }
}
