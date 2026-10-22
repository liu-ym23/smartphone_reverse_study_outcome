package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0 extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ WebPAnimationTasklet a;
    public final /* synthetic */ Function1 b;

    public f0(WebPAnimationTasklet r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r2, Throwable r3) {
        super.onFailure(r2, r3);
        Function1 r4 = this.b;
        if (r4 == null) goto L5;
        Unit r5 = (Unit) r4.invoke(Boolean.FALSE);
    L5:
        WebPAnimationTasklet r6 = this.a;
        Function2<d, Boolean, Unit> r7 = r6.k;
        if (r7 == null) goto L9;
        Unit r8 = (Unit) r7.invoke(r6, Boolean.FALSE);
        return;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, (ImageInfo) r2, r3);
        if ((r3 instanceof AnimatedDrawable2) == false) goto L5;
        AnimatedDrawable2 r4 = (AnimatedDrawable2) r3;
        com.bytedance.android.live.core.utils.fresco.c.c(r4);
        r4.setAnimationListener(new e0(this));
    L5:
        Function1 r5 = this.b;
        if (r5 == null) goto L9;
        Unit r6 = (Unit) r5.invoke(Boolean.TRUE);
        return;
    }
}
