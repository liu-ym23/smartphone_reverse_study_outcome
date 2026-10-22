package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraGPageOptionsBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final ImageView c;
    public final LottieAnimationView d;
    public final ItemGroup e;
    public final ItemGroupTitle f;
    public final View g;
    public final NovaTitleBarEx h;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraGPageOptionsBinding(ConstraintLayout r1, View r2, ImageView r3, LottieAnimationView r4, ItemGroup r5, ItemGroupTitle r6, View r7, NovaTitleBarEx r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
