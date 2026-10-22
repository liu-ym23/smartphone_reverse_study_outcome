package com.larus.community.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.community.impl.widget.CreationLoadingAndRetryView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusCommunityTemplateCreationFragmentLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final CreationLoadingAndRetryView c;
    public final SimpleDraweeView d;
    public final FrameLayout e;
    public final ConstraintLayout f;
    public final AppCompatImageView g;
    public final TextView h;
    public final ViewPager2 i;

    public final View getRoot() {
        return this.a;
    }

    public LarusCommunityTemplateCreationFragmentLayoutBinding(ConstraintLayout r1, View r2, CreationLoadingAndRetryView r3, SimpleDraweeView r4, FrameLayout r5, ConstraintLayout r6, AppCompatImageView r7, TextView r8, ViewPager2 r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
