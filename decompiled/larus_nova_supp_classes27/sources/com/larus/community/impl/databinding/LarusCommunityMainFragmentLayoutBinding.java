package com.larus.community.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.community.impl.view.CommunityCreateButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusCommunityMainFragmentLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final CommunityCreateButton b;
    public final ImageView c;
    public final SimpleDraweeView d;
    public final FrameLayout e;
    public final ConstraintLayout f;
    public final NovaTitleBarEx g;
    public final ViewPager2 h;

    public final View getRoot() {
        return this.a;
    }

    public LarusCommunityMainFragmentLayoutBinding(ConstraintLayout r1, CommunityCreateButton r2, ImageView r3, SimpleDraweeView r4, FrameLayout r5, ConstraintLayout r6, NovaTitleBarEx r7, ViewPager2 r8) {
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
