package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ z a;
    public final /* synthetic */ HSImageView b;

    public b0(z r1, HSImageView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r1, Throwable r2) {
        super.onFailure(r1, r2);
    }

    public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
        super.onFinalImageSet(r3, (ImageInfo) r4, r5);
        if ((r5 instanceof AnimatedDrawable2) == false) goto L6;
        z r6 = this.a;
        HSImageView r7 = this.b;
        AnimatedDrawable2 r0 = (AnimatedDrawable2) r5;
        r6.getClass();
        r0.setAnimationListener(new a0(r6, r7));
        com.bytedance.android.live.core.utils.fresco.c.c(r0);
        r5.start();
        return;
    }
}
