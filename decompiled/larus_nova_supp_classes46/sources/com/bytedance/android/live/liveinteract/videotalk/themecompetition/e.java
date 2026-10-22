package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ Function0 a;

    public e(Function0 r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, (ImageInfo) r2, r3);
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        je0.b.a((AnimatedDrawable2) r3, new ThemedCompetitionUtilKt$loadWebp$1$onFinalImageSet$1(this));
        return;
    }
}
