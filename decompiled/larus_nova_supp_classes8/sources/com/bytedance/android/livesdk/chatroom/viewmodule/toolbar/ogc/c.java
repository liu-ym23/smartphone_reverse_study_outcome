package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ OgcVSWebActivityBehavior a;
    public final /* synthetic */ HSImageView b;

    public final void onFailure(String r1, Throwable r2) {
    }

    public c(OgcVSWebActivityBehavior r1, HSImageView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        ImageInfo r5 = (ImageInfo) r3;
        if ((r4 instanceof AnimatedDrawable2) == true) goto L5;
        Animatable r6 = null;
    L6:
        AnimatedDrawable2 r7 = (AnimatedDrawable2) r6;
        if (r7 == null) goto L9;
        int r8 = r7.getFrameCount();
    L10:
        if (r7 == null) goto L12;
        r7.setAnimationListener(new b(this, r8));
    L12:
        if (r4 == null) goto L15;
        r4.start();
        return;
    L15:
        return;
    L9:
        r8 = 0;
        goto L10
    L5:
        r6 = r4;
        goto L6
    }
}
