package com.bytedance.android.livesdk.gift.fastgift;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.uikit.rtl.AutoRTLImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ FastGiftViewV3 a;
    public final /* synthetic */ int b;

    public final void onFailure(String r1, Throwable r2) {
    }

    public v(FastGiftViewV3 r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        ImageInfo r5 = (ImageInfo) r3;
        if (this.b != 1) goto L8;
        AutoRTLImageView r6 = this.a.a(2131372145);
        if (r6 == null) goto L8;
        r6.setVisibility(8);
    L8:
        if ((r4 instanceof AnimatedDrawable2) == true) goto L10;
        Animatable r7 = null;
    L11:
        AnimatedDrawable2 r8 = (AnimatedDrawable2) r7;
        if (r8 == null) goto L14;
        int r9 = r8.getFrameCount();
    L15:
        if (r8 == null) goto L18;
        r8.setAnimationListener(new u(this, r9));
    L18:
        if (this.a.j == false) goto L22;
        if (r4 == null) goto L23;
        r4.start();
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r9 = 0;
        goto L15
    L10:
        r7 = r4;
        goto L11
    }
}
