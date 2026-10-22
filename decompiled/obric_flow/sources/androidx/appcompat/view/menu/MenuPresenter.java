package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface MenuPresenter {

    public interface Callback {
        void onCloseMenu(@NonNull MenuBuilder r5, boolean r10);

        boolean onOpenSubMenu(@NonNull MenuBuilder r5);
    }

    boolean collapseItemActionView(MenuBuilder r5, MenuItemImpl r10);

    boolean expandItemActionView(MenuBuilder r5, MenuItemImpl r10);

    boolean flagActionItems();

    int getId();

    MenuView getMenuView(ViewGroup r5);

    void initForMenu(Context r5, MenuBuilder r10);

    void onCloseMenu(MenuBuilder r5, boolean r10);

    void onRestoreInstanceState(Parcelable r5);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(SubMenuBuilder r5);

    void setCallback(Callback r5);

    void updateMenuView(boolean r5);
}
