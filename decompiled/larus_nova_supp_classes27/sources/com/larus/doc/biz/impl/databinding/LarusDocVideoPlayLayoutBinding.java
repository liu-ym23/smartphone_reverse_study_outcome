package com.larus.doc.biz.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.doc.impl.video.widget.VideoPlayView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDocVideoPlayLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final FrameLayout c;
    public final RelativeLayout d;
    public final ImageView e;
    public final VideoPlayView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDocVideoPlayLayoutBinding(ConstraintLayout r1, ImageView r2, FrameLayout r3, RelativeLayout r4, ImageView r5, VideoPlayView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
