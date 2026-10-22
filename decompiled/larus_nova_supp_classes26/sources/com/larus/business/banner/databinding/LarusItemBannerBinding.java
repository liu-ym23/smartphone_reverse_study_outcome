package com.larus.business.banner.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.banner.BannerViewPager;
import com.zhpan.bannerview.indicator.DrawableIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusItemBannerBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final BannerViewPager b;
    public final DrawableIndicator c;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemBannerBinding a(LayoutInflater r2, ViewGroup r3) {
        ConstraintLayout r4 = r2.inflate(2131562499, r3, false);
        int r5 = 2131363962;
        BannerViewPager r0 = ViewBindings.findChildViewById(r4, 2131363962);
        if (r0 == null) goto L9;
        r5 = 2131375249;
        DrawableIndicator r1 = ViewBindings.findChildViewById(r4, 2131375249);
        if (r1 == null) goto L9;
        return new LarusItemBannerBinding(r4, r0, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r5)));
    }

    public LarusItemBannerBinding(ConstraintLayout r1, BannerViewPager r2, DrawableIndicator r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
