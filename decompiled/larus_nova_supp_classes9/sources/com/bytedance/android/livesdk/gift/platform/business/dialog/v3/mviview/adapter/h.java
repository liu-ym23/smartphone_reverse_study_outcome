package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends BaseControllerListener<ImageInfo> {
    public h() {
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        if ((r3 instanceof AnimatedDrawable2) == true) goto L5;
        r3 = null;
    L5:
        AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
        if (r5 == null) goto L9;
        com.bytedance.android.live.core.utils.fresco.c.c(r5);
        r5.start();
        return;
    }
}
