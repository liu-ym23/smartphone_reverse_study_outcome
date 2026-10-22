package com.larus.profile.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.larus.profile.impl.view.ProfileHeaderUserInfoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusPageTabProfileInfoBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppBarLayout b;
    public final LarusProfileBlockCoverBinding c;
    public final CoordinatorLayout d;
    public final ProfileHeaderUserInfoView e;
    public final LarusPageProfileInfoErrorBinding f;
    public final AppCompatImageView g;
    public final AppCompatTextView h;
    public final View i;
    public final AppCompatImageView j;
    public final LarusPageProfileTabInfoLoadingBinding k;
    public final LarusPageProfileUserInfoSkeletonBinding l;
    public final ConstraintLayout m;
    public final View n;
    public final TabLayout o;
    public final ViewPager2 p;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageTabProfileInfoBinding(ConstraintLayout r3, AppBarLayout r4, LarusProfileBlockCoverBinding r5, CoordinatorLayout r6, ProfileHeaderUserInfoView r7, LarusPageProfileInfoErrorBinding r8, AppCompatImageView r9, AppCompatTextView r10, View r11, AppCompatImageView r12, LarusPageProfileTabInfoLoadingBinding r13, LarusPageProfileUserInfoSkeletonBinding r14, ConstraintLayout r15, View r16, TabLayout r17, ViewPager2 r18) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
    }
}
