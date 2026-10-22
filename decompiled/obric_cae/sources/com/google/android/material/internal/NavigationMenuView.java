package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements androidx.appcompat.view.menu.k {
    public NavigationMenuView(Context r8, AttributeSet r10) {
        this(r8, r10, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public final void a(androidx.appcompat.view.menu.f r8) {
    }

    public int getWindowAnimations() {
        return 0;
    }

    public NavigationMenuView(Context r8, AttributeSet r10, int r11) {
        super(r8, r10, 0);
        setLayoutManager(new LinearLayoutManager(1));
    }
}
