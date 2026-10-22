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

    private class MenuAdapter extends BaseAdapter {
        private int mExpandedIndex;
        final /* synthetic */ ListMenuPresenter this$0;

        public MenuAdapter(ListMenuPresenter r10) {
            this.this$0 = r10;
            this.mExpandedIndex = -1;
            findExpandedIndex();
        }

        void findExpandedIndex() {
            MenuItemImpl r10 = this.this$0.mMenu.getExpandedItem();
            if (r10 == null) goto L11;
            ArrayList<MenuItemImpl> r11 = this.this$0.mMenu.getNonActionItems();
            int r12 = r11.size();
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L11;
            if (r11.get(r13) == r10) goto L8;
            r13 = r13 + 1;
            goto L5
        L8:
            this.mExpandedIndex = r13;
            return;
        L11:
            this.mExpandedIndex = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int r10 = this.this$0.mMenu.getNonActionItems().size() - this.this$0.mItemIndexOffset;
            if (this.mExpandedIndex >= 0) goto L6;
            return r10;
        L6:
            return r10 - 1;
        }

        @Override // android.widget.Adapter
        public MenuItemImpl getItem(int r10) {
            ArrayList<MenuItemImpl> r11 = this.this$0.mMenu.getNonActionItems();
            int r12 = r10 + this.this$0.mItemIndexOffset;
            int r13 = this.mExpandedIndex;
            if (r13 < 0) goto L7;
            if (r12 < r13) goto L7;
            r12 = r12 + 1;
        L7:
            return r11.get(r12);
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r10) {
            return getItem(r10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            return r10;
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            if (r11 != null) goto L5;
            ListMenuPresenter r13 = this.this$0;
            r11 = r13.mInflater.inflate(r13.mItemLayoutRes, r12, false);
        L5:
            ((MenuView.ItemView) r11).initialize(getItem(r10), 0);
            return r11;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            findExpandedIndex();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(int r10, int r11) {
        this.mItemLayoutRes = r10;
        this.mThemeRes = r11;
    }

    public ListMenuPresenter(Context r10, int r11) {
        this(r11, 0);
        this.mContext = r10;
        this.mInflater = LayoutInflater.from(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r10, MenuItemImpl r11) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r10, MenuItemImpl r11) {
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

    int getItemIndexOffset() {
        return this.mItemIndexOffset;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r10) {
        if (this.mMenuView != null) goto L9;
        this.mMenuView = (ExpandedMenuView) this.mInflater.inflate(R.layout.abc_expanded_menu_layout, r10, false);
        if (this.mAdapter != null) goto L7;
        this.mAdapter = new MenuAdapter(this);
    L7:
        this.mMenuView.setAdapter(this.mAdapter);
        this.mMenuView.setOnItemClickListener(this);
    L9:
        return this.mMenuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r10, MenuBuilder r11) {
        if (this.mThemeRes == 0) goto L7;
        ContextThemeWrapper r12 = new ContextThemeWrapper(r10, this.mThemeRes);
        this.mContext = r12;
        LayoutInflater r13 = LayoutInflater.from(r12);
    L5:
        this.mInflater = r13;
    L11:
        this.mMenu = r11;
        MenuAdapter r14 = this.mAdapter;
        if (r14 == null) goto L15;
        r14.notifyDataSetChanged();
        return;
    L15:
        return;
    L7:
        if (this.mContext == null) goto L11;
        this.mContext = r10;
        if (this.mInflater != null) goto L11;
        r13 = LayoutInflater.from(r10);
        goto L5
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r10, boolean r11) {
        MenuPresenter.Callback r12 = this.mCallback;
        if (r12 == null) goto L6;
        r12.onCloseMenu(r10, r11);
        return;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r10, View r11, int r12, long r13) {
        this.mMenu.performItemAction(this.mAdapter.getItem(r12), this, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r10) {
        restoreHierarchyState((Bundle) r10);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        if (this.mMenuView != null) goto L6;
        return null;
    L6:
        Bundle r10 = new Bundle();
        saveHierarchyState(r10);
        return r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r10) {
        if (r10.hasVisibleItems() == true) goto L6;
        return false;
    L6:
        new MenuDialogHelper(r10).show(null);
        MenuPresenter.Callback r11 = this.mCallback;
        if (r11 == null) goto L11;
        r11.onOpenSubMenu(r10);
        return true;
    L11:
        return true;
    }

    public void restoreHierarchyState(Bundle r10) {
        SparseArray<Parcelable> r11 = r10.getSparseParcelableArray(VIEWS_TAG);
        if (r11 == null) goto L6;
        this.mMenuView.restoreHierarchyState(r11);
        return;
    }

    public void saveHierarchyState(Bundle r10) {
        SparseArray<Parcelable> r11 = new SparseArray();
        ExpandedMenuView r12 = this.mMenuView;
        if (r12 == null) goto L5;
        r12.saveHierarchyState(r11);
    L5:
        r10.putSparseParcelableArray(VIEWS_TAG, r11);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r10) {
        this.mCallback = r10;
    }

    public void setId(int r10) {
        this.mId = r10;
    }

    public void setItemIndexOffset(int r10) {
        this.mItemIndexOffset = r10;
        if (this.mMenuView == null) goto L6;
        updateMenuView(false);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        MenuAdapter r11 = this.mAdapter;
        if (r11 == null) goto L6;
        r11.notifyDataSetChanged();
        return;
    }
}
