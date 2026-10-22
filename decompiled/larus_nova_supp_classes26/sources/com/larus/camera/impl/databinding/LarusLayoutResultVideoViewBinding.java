package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.video.progress.PlayerProgressView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutResultVideoViewBinding implements ViewBinding {
    public final View a;
    public final ImageView b;
    public final ImageView c;
    public final PlayerProgressView d;
    public final RelativeLayout e;
    public final VideoPlayView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutResultVideoViewBinding(View r1, ImageView r2, ImageView r3, PlayerProgressView r4, RelativeLayout r5, VideoPlayView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
