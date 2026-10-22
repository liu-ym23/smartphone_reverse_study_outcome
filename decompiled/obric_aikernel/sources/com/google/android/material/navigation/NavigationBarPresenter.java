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
import com.google.android.material.badge.a;
import com.google.android.material.badge.b;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationBarPresenter implements MenuPresenter {
    private int id;
    private MenuBuilder menu;
    private NavigationBarMenuView menuView;
    private boolean updateSuspended;

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        ParcelableSparseArray badgeSavedStates;
        int selectedItemId;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @NonNull
            public SavedState a(@NonNull Parcel r10) {
                return new SavedState(r10);
            }

            @NonNull
            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ SavedState createFromParcel(@NonNull Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public /* bridge */ /* synthetic */ SavedState[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        SavedState() {
        }

        SavedState(@NonNull Parcel r10) {
            this.selectedItemId = r10.readInt();
            this.badgeSavedStates = (ParcelableSparseArray) r10.readParcelable(getClass().getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            r10.writeInt(this.selectedItemId);
            r10.writeParcelable(this.badgeSavedStates, 0);
        }
    }

    public NavigationBarPresenter() {
        this.updateSuspended = false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(@Nullable MenuBuilder r10, @Nullable MenuItemImpl r11) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(@Nullable MenuBuilder r10, @Nullable MenuItemImpl r11) {
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
    @Nullable
    public MenuView getMenuView(@Nullable ViewGroup r10) {
        return this.menuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context r10, @NonNull MenuBuilder r11) {
        this.menu = r11;
        this.menuView.initialize(r11);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(@Nullable MenuBuilder r10, boolean r11) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(@NonNull Parcelable r10) {
        if ((r10 instanceof SavedState) == false) goto L6;
        SavedState r11 = (SavedState) r10;
        this.menuView.tryRestoreSelectedItemId(r11.selectedItemId);
        SparseArray<a> r12 = b.b(this.menuView.getContext(), r11.badgeSavedStates);
        this.menuView.restoreBadgeDrawables(r12);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState();
        r10.selectedItemId = this.menuView.getSelectedItemId();
        r10.badgeSavedStates = b.c(this.menuView.getBadgeDrawables());
        return r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(@Nullable SubMenuBuilder r10) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(@Nullable MenuPresenter.Callback r10) {
    }

    public void setId(int r10) {
        this.id = r10;
    }

    public void setMenuView(@NonNull NavigationBarMenuView r10) {
        this.menuView = r10;
    }

    public void setUpdateSuspended(boolean r10) {
        this.updateSuspended = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        if (this.updateSuspended == false) goto L5;
        return;
    L5:
        NavigationBarMenuView r11 = this.menuView;
        if (r10 == false) goto L8;
        r11.buildMenuView();
        return;
    L8:
        r11.updateMenuView();
    }
}
