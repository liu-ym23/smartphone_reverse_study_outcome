package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ SingleVipMVIView a;

    public t(SingleVipMVIView r1) {
        this.a = r1;
    }

    public final void onFailure(String r1, Throwable r2) {
        this.a.q.setVisibility(8);
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        ((AnimatedDrawable2) r3).setAnimationListener(new s(this));
        return;
    }
}
