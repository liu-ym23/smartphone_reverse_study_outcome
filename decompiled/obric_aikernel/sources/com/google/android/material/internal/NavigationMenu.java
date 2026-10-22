package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenu extends MenuBuilder {
    public NavigationMenu(Context r10) {
        super(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int r10, int r11, int r12, CharSequence r13) {
        MenuItemImpl r14 = (MenuItemImpl) addInternal(r10, r11, r12, r13);
        NavigationSubMenu r15 = new NavigationSubMenu(getContext(), this, r14);
        r14.setSubMenu(r15);
        return r15;
    }
}
