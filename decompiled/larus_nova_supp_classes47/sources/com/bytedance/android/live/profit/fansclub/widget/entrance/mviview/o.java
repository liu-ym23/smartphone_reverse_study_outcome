package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import eu0.g0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ RightVipMVIView a;

    public o(RightVipMVIView r1) {
        this.a = r1;
    }

    public final void onFailure(String r2, Throwable r3) {
        RightVipMVIView r4 = this.a;
        r4.o(new g0(r4.s));
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        Intrinsics.checkNotNullParameter(r1, "id");
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        ((AnimatedDrawable2) r3).setAnimationListener(new n(this));
        return;
    }
}
