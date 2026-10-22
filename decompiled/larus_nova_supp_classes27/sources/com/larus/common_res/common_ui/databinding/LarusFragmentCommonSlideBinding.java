package com.larus.common_res.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.common_ui.view.CommonSlideRootContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusFragmentCommonSlideBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final ViewPager2 c;
    public final FrameLayout d;
    public final CommonSlideRootContainer e;
    public final ImageView f;
    public final ImageView g;

    public final View getRoot() {
        return this.a;
    }

    public static LarusFragmentCommonSlideBinding a(LayoutInflater r9, ViewGroup r10) {
        View r11 = r9.inflate(2131562364, r10, false);
        int r12 = 2131363762;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r11, 2131363762);
        if (r3 == null) goto L17;
        r12 = 2131367565;
        ViewPager2 r4 = ViewBindings.findChildViewById(r11, 2131367565);
        if (r4 == null) goto L17;
        r12 = 2131367728;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131367728);
        if (r5 == null) goto L17;
        r12 = 2131369149;
        CommonSlideRootContainer r6 = (CommonSlideRootContainer) ViewBindings.findChildViewById(r11, 2131369149);
        if (r6 == null) goto L17;
        r12 = 2131380286;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r11, 2131380286);
        if (r7 == null) goto L17;
        r12 = 2131386047;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r11, 2131386047);
        if (r8 == null) goto L17;
        return new LarusFragmentCommonSlideBinding((FrameLayout) r11, r3, r4, r5, r6, r7, r8);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public LarusFragmentCommonSlideBinding(FrameLayout r1, ImageView r2, ViewPager2 r3, FrameLayout r4, CommonSlideRootContainer r5, ImageView r6, ImageView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
