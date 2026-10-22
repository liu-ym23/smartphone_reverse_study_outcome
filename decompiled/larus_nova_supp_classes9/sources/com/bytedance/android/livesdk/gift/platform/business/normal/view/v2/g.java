package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ NormalGiftCombViewV2 a;

    public g(NormalGiftCombViewV2 r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        if ((r3 instanceof AnimatedDrawable2) == true) goto L5;
        r3 = null;
    L5:
        AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
        if (r5 == null) goto L9;
        this.a.B = r5;
        com.bytedance.android.live.core.utils.fresco.c.b(r5);
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.j.a(r5, NormalGiftCombViewV2$loadTrayEffect$1$onFinalImageSet$1$1.INSTANCE, new NormalGiftCombViewV2$loadTrayEffect$1$onFinalImageSet$$inlined$let$lambda$1(this));
        return;
    }
}
