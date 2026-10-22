package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.video.view.CreationVideoDetailPlayControlView;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.common_ui.video.VideoPlayView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusCreationVideoDetailFragmentLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final ConstraintLayout c;
    public final FrameLayout d;
    public final TextView e;
    public final CreationOperateContainerView f;
    public final CommonDownLoadLayout g;
    public final View h;
    public final TextView i;
    public final ConstraintLayout j;

    public final View getRoot() {
        return this.a;
    }

    public LarusCreationVideoDetailFragmentLayoutBinding(ConstraintLayout r1, TextView r2, ConstraintLayout r3, FrameLayout r4, TextView r5, CreationOperateContainerView r6, CommonDownLoadLayout r7, View r8, TextView r9, RelativeLayout r10, ConstraintLayout r11, CreationVideoDetailPlayControlView r12, VideoPlayView r13) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r11;
    }
}
