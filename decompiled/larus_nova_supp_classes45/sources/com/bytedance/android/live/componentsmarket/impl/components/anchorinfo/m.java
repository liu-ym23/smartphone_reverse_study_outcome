package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ CommonMergeAnchorInfoWidget a;

    public m(CommonMergeAnchorInfoWidget r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
        r5.getFrameCount();
        r5.setAnimationListener(new l(this));
        return;
    }
}
