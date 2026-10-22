package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOActivityMemoryDataBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final OFloatingTitleBar c;
    public final ViewPager2 d;

    public final View getRoot() {
        return this.a;
    }

    public DoraOActivityMemoryDataBinding(ConstraintLayout r1, FrameLayout r2, OFloatingTitleBar r3, ViewPager2 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
