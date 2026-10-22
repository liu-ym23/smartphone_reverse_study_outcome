package com.larus.profile.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.view.CreateBotButton;
import com.larus.profile.impl.view.MineTabTitleBar;
import com.larus.profile.impl.view.ProfileHeaderUserInfoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusFragmentMineTabPageBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppBarLayout b;
    public final CreateBotButton c;
    public final ConstraintLayout d;
    public final CoordinatorLayout e;
    public final View f;
    public final ProfileHeaderUserInfoView g;
    public final FrameLayout h;
    public final LarusPageProfileInfoErrorBinding i;
    public final LarusPageProfileTabInfoLoadingBinding j;
    public final LarusPageProfileUserInfoSkeletonBinding k;
    public final TabLayout l;
    public final MineTabTitleBar m;
    public final ViewPager2 n;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentMineTabPageBinding(ConstraintLayout r1, AppBarLayout r2, CreateBotButton r3, ConstraintLayout r4, CoordinatorLayout r5, View r6, ProfileHeaderUserInfoView r7, FrameLayout r8, LarusPageProfileInfoErrorBinding r9, LarusPageProfileTabInfoLoadingBinding r10, LarusPageProfileUserInfoSkeletonBinding r11, TabLayout r12, MineTabTitleBar r13, ViewPager2 r14) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }
}
