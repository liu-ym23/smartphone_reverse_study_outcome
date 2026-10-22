package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationBarPresenter implements MenuPresenter {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f8561id;
    private MenuBuilder menu;
    private NavigationBarMenuView menuView;
    private boolean updateSuspended;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        ParcelableSparseArray badgeSavedStates;
        int selectedItemId;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r5, int r10) {
            r5.writeInt(this.selectedItemId);
            r5.writeParcelable(this.badgeSavedStates, 0);
        }

        public SavedState(@NonNull Parcel r5) {
            this.selectedItemId = r5.readInt();
            this.badgeSavedStates = (ParcelableSparseArray) r5.readParcelable(getClass().getClassLoader());
        }
    }

    public NavigationBarPresenter() {
        this.updateSuspended = false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(@Nullable MenuBuilder r5, @Nullable MenuItemImpl r10) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(@Nullable MenuBuilder r5, @Nullable MenuItemImpl r10) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f8561id;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @Nullable
    public MenuView getMenuView(@Nullable ViewGroup r5) {
        return this.menuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context r5, @NonNull MenuBuilder r10) {
        this.menu = r10;
        this.menuView.initialize(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(@Nullable MenuBuilder r5, boolean r10) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(@NonNull Parcelable r5) {
        if ((r5 instanceof SavedState) == false) goto L6;
        SavedState r10 = (SavedState) r5;
        this.menuView.tryRestoreSelectedItemId(r10.selectedItemId);
        SparseArray<BadgeDrawable> r11 = BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), r10.badgeSavedStates);
        this.menuView.restoreBadgeDrawables(r11);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState();
        r5.selectedItemId = this.menuView.getSelectedItemId();
        r5.badgeSavedStates = BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
        return r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(@Nullable SubMenuBuilder r5) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(@Nullable MenuPresenter.Callback r5) {
    }

    public void setId(int r5) {
        this.f8561id = r5;
    }

    public void setMenuView(@NonNull NavigationBarMenuView r5) {
        this.menuView = r5;
    }

    public void setUpdateSuspended(boolean r5) {
        this.updateSuspended = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r5) {
        if (this.updateSuspended == false) goto L5;
        return;
    L5:
        if (r5 == false) goto L7;
        this.menuView.buildMenuView();
        return;
    L7:
        this.menuView.updateMenuView();
    }
}
