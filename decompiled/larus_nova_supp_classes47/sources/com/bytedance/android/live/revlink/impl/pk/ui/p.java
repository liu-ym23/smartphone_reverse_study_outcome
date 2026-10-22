package com.bytedance.android.live.revlink.impl.pk.ui;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ PkRandomView a;

    public p(PkRandomView r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        super.onFinalImageSet(r2, (ImageInfo) r3, r4);
        if ((r4 instanceof AnimatedDrawable2) == false) goto L6;
        ((AnimatedDrawable2) r4).setAnimationListener(new o(this));
        return;
    }
}
