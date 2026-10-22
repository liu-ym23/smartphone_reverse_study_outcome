package com.larus.community.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.video.progress.PlayerProgressView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusCommunityCreationDetailVideoLayoutBinding implements ViewBinding {
    public final View a;
    public final ConstraintLayout b;
    public final PlayerProgressView c;
    public final VideoPlayView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusCommunityCreationDetailVideoLayoutBinding(View r1, ConstraintLayout r2, PlayerProgressView r3, VideoPlayView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
