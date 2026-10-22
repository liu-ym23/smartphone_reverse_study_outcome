package com.larus.photopicker.v2.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusItemPreviewVideoV2Binding implements ViewBinding {
    public final ScaleGestureLayout a;
    public final ScaleGestureLayout b;
    public final SimpleDraweeView c;
    public final AppCompatImageView d;
    public final ProgressBar e;
    public final VideoView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemPreviewVideoV2Binding(ScaleGestureLayout r1, ScaleGestureLayout r2, SimpleDraweeView r3, AppCompatImageView r4, ProgressBar r5, VideoView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
