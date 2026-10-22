package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.camera.impl.ui.component.result.video.ResultVideoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusItemPreviewVideoBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ResultVideoView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemPreviewVideoBinding(ConstraintLayout r1, ImageView r2, ResultVideoView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
