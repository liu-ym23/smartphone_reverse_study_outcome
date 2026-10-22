package com.larus.photopicker.v2.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusItemPreviewImageV2Binding implements ViewBinding {
    public final ScaleGestureLayout a;
    public final ScaleGestureLayout b;
    public final SimpleDraweeView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemPreviewImageV2Binding(ScaleGestureLayout r1, ScaleGestureLayout r2, SimpleDraweeView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
