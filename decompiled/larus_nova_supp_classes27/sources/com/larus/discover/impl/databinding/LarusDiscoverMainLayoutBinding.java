package com.larus.discover.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDiscoverMainLayoutBinding implements ViewBinding {
    public final FrameLayout a;
    public final TabLayout b;
    public final ViewPager2 c;

    public final View getRoot() {
        return this.a;
    }

    public LarusDiscoverMainLayoutBinding(FrameLayout r1, TabLayout r2, ViewPager2 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
