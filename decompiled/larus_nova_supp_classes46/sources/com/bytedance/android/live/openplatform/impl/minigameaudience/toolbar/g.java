package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Function2 e;

    public final void onFailure(String r1, Throwable r2) {
        super.onFailure(r1, r2);
        this.a.invoke();
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        if ((r3 instanceof AnimatedDrawable2) == false) goto L5;
        ((AnimatedDrawable2) r3).setAnimationListener(new f(this, r3));
    L5:
        if (r3 == null) goto L8;
        r3.start();
        return;
    }

    public g(Function0 r1, Function0 r2, Function0 r3, Function2 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = true;
        this.e = r4;
    }
}
