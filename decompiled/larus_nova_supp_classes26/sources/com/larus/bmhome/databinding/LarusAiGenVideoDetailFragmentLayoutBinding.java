package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.video.view.AiGenVideoPlayControlView;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.common_ui.video.VideoPlayView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusAiGenVideoDetailFragmentLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final CreationOperateContainerView c;
    public final CommonDownLoadLayout d;
    public final ConstraintLayout e;

    public final View getRoot() {
        return this.a;
    }

    public LarusAiGenVideoDetailFragmentLayoutBinding(ConstraintLayout r1, ConstraintLayout r2, CreationOperateContainerView r3, CommonDownLoadLayout r4, RelativeLayout r5, ConstraintLayout r6, AiGenVideoPlayControlView r7, VideoPlayView r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }
}
