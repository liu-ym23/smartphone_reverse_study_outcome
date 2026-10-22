package com.google.android.material.navigation;

import ai.j0;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class NavigationBarMenu extends MenuBuilder {
    private final int maxItemCount;

    @NonNull
    private final Class<?> viewClass;

    public NavigationBarMenu(@NonNull Context r5, @NonNull Class<?> r10, int r11) {
        super(r5);
        this.viewClass = r10;
        this.maxItemCount = r11;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    @NonNull
    public MenuItem addInternal(int r5, int r10, int r11, @NonNull CharSequence r12) {
        if ((size() + 1) > this.maxItemCount) goto L9;
        stopDispatchingItemsChanged();
        MenuItem r13 = super.addInternal(r5, r10, r11, r12);
        if ((r13 instanceof MenuItemImpl) == false) goto L7;
        ((MenuItemImpl) r13).setExclusiveCheckable(true);
    L7:
        startDispatchingItemsChanged();
        return r13;
    L9:
        String r14 = this.viewClass.getSimpleName();
        StringBuilder r15 = j0.x("Maximum number of items supported by ", r14, " is ");
        r15.append(this.maxItemCount);
        r15.append(". Limit can be checked with ");
        r15.append(r14);
        r15.append("#getMaxItemCount()");
        throw new IllegalArgumentException(r15.toString());
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int r5, int r10, int r11, @NonNull CharSequence r12) {
        throw new UnsupportedOperationException(this.viewClass.getSimpleName().concat(" does not support submenus"));
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }
}
