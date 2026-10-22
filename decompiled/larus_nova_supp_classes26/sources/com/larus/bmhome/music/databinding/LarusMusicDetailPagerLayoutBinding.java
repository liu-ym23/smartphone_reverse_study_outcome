package com.larus.bmhome.music.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.common_ui.view.DotsIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusMusicDetailPagerLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final DotsIndicator b;
    public final ViewPager2 c;

    public final View getRoot() {
        return this.a;
    }

    public LarusMusicDetailPagerLayoutBinding(ConstraintLayout r1, DotsIndicator r2, ViewPager2 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
