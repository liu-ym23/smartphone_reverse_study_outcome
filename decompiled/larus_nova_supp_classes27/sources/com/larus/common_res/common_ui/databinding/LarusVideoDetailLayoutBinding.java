package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.video.VideoPlayView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusVideoDetailLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;

    public final View getRoot() {
        return this.a;
    }

    public LarusVideoDetailLayoutBinding(ConstraintLayout r1, FrameLayout r2, RelativeLayout r3, VideoPlayView r4) {
        this.a = r1;
        this.b = r2;
    }
}
