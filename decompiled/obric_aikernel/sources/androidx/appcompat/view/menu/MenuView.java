package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface MenuView {

    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl r10, int r11);

        boolean prefersCondensedTitle();

        void setCheckable(boolean r10);

        void setChecked(boolean r10);

        void setEnabled(boolean r10);

        void setIcon(Drawable r10);

        void setShortcut(boolean r10, char r11);

        void setTitle(CharSequence r10);

        boolean showsIcon();
    }

    int getWindowAnimations();

    void initialize(MenuBuilder r10);
}
