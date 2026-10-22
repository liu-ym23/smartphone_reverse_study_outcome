package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.graphics.drawable.Animatable;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ n a;
    public final /* synthetic */ HSImageView b;
    public final /* synthetic */ FrameLayout c;

    public final void onFailure(String r3, Throwable r4) {
        ALogger.e("InteractAnimation.MicSeatAnimationTasklet", "playReceiverSeatAnimation#load failed:" + r4);
        n r5 = this.a;
        FrameLayout r6 = this.c;
        HSImageView r0 = this.b;
        r5.getClass();
        r6.post(new s(r5, r0, r6));
    }

    public q(n r1, HSImageView r2, FrameLayout r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        Intrinsics.checkNotNullParameter(r1, "id");
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
        com.bytedance.android.live.core.utils.fresco.c.c(r5);
        r5.setAnimationListener(new p(this, r3));
        return;
    }
}
