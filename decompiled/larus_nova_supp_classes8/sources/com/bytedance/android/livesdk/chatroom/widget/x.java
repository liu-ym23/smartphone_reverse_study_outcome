package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.ve1;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ FansRankListAnimationWidget a;

    public x(FansRankListAnimationWidget r1) {
        this.a = r1;
    }

    public final void onFailure(String r1, Throwable r2) {
        FansRankListAnimationWidget r3 = this.a;
        int r4 = FansRankListAnimationWidget.o;
        r3.wq();
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if ((r3 instanceof AnimatedDrawable2) == false) goto L12;
        FansRankListAnimationWidget r5 = this.a;
        r5.m = (AnimatedDrawable2) r3;
        z r6 = new z(r5);
        AbstractDraweeController r7 = Fresco.newDraweeControllerBuilder().setControllerListener(r6).setUri(UriProtector.parse(ve1.a.getValue())).setAutoPlayAnimations(false).build();
        HSImageView r8 = r5.b;
        if (r8 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRankListAwardAnimationLight");
    L9:
        r8.setController(r7);
        return;
    }
}
