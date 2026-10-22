package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.a;
import com.google.android.material.badge.b;
import com.google.android.material.internal.ParcelableSparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationBarPresenter implements MenuPresenter {
    private int id;
    private MenuBuilder menu;
    private NavigationBarMenuView menuView;
    private boolean updateSuspended;

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        ParcelableSparseArray badgeSavedStates;
        int selectedItemId;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState() {
        }

        SavedState(Parcel r3) {
            this.selectedItemId = r3.readInt();
            this.badgeSavedStates = (ParcelableSparseArray) ZeusTransformUtils.preCheckCast(r3.readParcelable(getClass().getClassLoader()), ParcelableSparseArray.class, "com.obric.memorydata.plugin");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.selectedItemId);
            r1.writeParcelable(this.badgeSavedStates, 0);
        }
    }

    public NavigationBarPresenter() {
        this.updateSuspended = false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.id;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r1) {
        return this.menuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r3, MenuBuilder r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.menu = r4;
        this.menuView.initialize(r4);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r1, boolean r2) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, SavedState.class) == false) goto L6;
        this.menuView.tryRestoreSelectedItemId(((SavedState) ZeusTransformUtils.preCheckCast(r5, SavedState.class, "com.obric.memorydata.plugin")).selectedItemId);
        SparseArray<a> r6 = b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.menuView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ((SavedState) ZeusTransformUtils.preCheckCast(r5, SavedState.class, "com.obric.memorydata.plugin")).badgeSavedStates);
        this.menuView.restoreBadgeDrawables(r6);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState();
        r0.selectedItemId = this.menuView.getSelectedItemId();
        r0.badgeSavedStates = b.a(this.menuView.getBadgeDrawables());
        return r0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r1) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r2) {
        MenuPresenter.Callback r1 = (MenuPresenter.Callback) ZeusTransformUtils.wrapperContextForParams(r2, MenuPresenter.Callback.class, "com.obric.memorydata.plugin");
    }

    public void setId(int r1) {
        this.id = r1;
    }

    public void setMenuView(NavigationBarMenuView r1) {
        this.menuView = r1;
    }

    public void setUpdateSuspended(boolean r1) {
        this.updateSuspended = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r2) {
        if (this.updateSuspended == false) goto L5;
        return;
    L5:
        NavigationBarMenuView r1 = this.menuView;
        if (r2 == false) goto L8;
        r1.buildMenuView();
        return;
    L8:
        r1.updateMenuView();
    }
}
