package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenu extends MenuBuilder {
    public NavigationMenu(Context r5) {
        super(r5);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int r5, int r10, int r11, CharSequence r12) {
        MenuItemImpl r13 = (MenuItemImpl) addInternal(r5, r10, r11, r12);
        NavigationSubMenu r14 = new NavigationSubMenu(getContext(), this, r13);
        r13.setSubMenu(r14);
        return r14;
    }
}
