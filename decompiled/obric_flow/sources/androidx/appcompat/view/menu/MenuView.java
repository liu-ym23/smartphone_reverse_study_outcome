package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface MenuView {

    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl r5, int r10);

        boolean prefersCondensedTitle();

        void setCheckable(boolean r5);

        void setChecked(boolean r5);

        void setEnabled(boolean r5);

        void setIcon(Drawable r5);

        void setShortcut(boolean r5, char r10);

        void setTitle(CharSequence r5);

        boolean showsIcon();
    }

    int getWindowAnimations();

    void initialize(MenuBuilder r5);
}
