package com.larus.uaigc.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.bigimg.widget.LeftCreationEditView;
import com.larus.bmhome.bigimg.widget.NumericIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusBigImageDetailLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LeftCreationEditView b;
    public final ViewPager2 c;
    public final NumericIndicator d;

    public final View getRoot() {
        return this.a;
    }

    public LarusBigImageDetailLayoutBinding(ConstraintLayout r1, LeftCreationEditView r2, ViewPager2 r3, NumericIndicator r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
