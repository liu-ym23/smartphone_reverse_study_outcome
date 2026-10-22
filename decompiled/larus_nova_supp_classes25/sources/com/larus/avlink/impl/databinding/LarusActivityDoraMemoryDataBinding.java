package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LarusActivityDoraMemoryDataBinding implements ViewBinding {
    public final LinearLayout a;
    public final TabLayout b;
    public final NovaTitleBarEx c;
    public final ViewPager2 d;

    public final View getRoot() {
        return this.a;
    }

    public LarusActivityDoraMemoryDataBinding(LinearLayout r1, TabLayout r2, NovaTitleBarEx r3, ViewPager2 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
