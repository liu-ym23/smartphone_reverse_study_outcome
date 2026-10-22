package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ GiftRareShopComboView a;

    public g(GiftRareShopComboView r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        if ((r3 instanceof AnimatedDrawable2) == true) goto L5;
        r3 = null;
    L5:
        AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
        if (r5 == null) goto L9;
        r5.setAnimationBackend(new q(r5.getAnimationBackend()));
        this.a.z = r5;
        return;
    }
}
