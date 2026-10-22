package com.larus.community.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.community.impl.share.CreationShareSegmentedControlView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusCommunityPictureShareDialogLayoutBinding implements ViewBinding {
    public final RoundLinearLayout a;
    public final AppCompatImageView b;
    public final CreationShareSegmentedControlView c;
    public final FrameLayout d;
    public final ViewPager2 e;

    public final View getRoot() {
        return this.a;
    }

    public LarusCommunityPictureShareDialogLayoutBinding(RoundLinearLayout r1, AppCompatImageView r2, CreationShareSegmentedControlView r3, FrameLayout r4, ViewPager2 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
