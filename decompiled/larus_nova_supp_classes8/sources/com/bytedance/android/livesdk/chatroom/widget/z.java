package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.drawable.Animatable;
import com.bytedance.ies.sdk.widgets.Widget;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ FansRankListAnimationWidget a;

    public z(FansRankListAnimationWidget r1) {
        this.a = r1;
    }

    public final void onFailure(String r1, Throwable r2) {
        FansRankListAnimationWidget r3 = this.a;
        int r4 = FansRankListAnimationWidget.o;
        r3.wq();
    }

    public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
        ImageInfo r6 = (ImageInfo) r4;
        if (r5 != null) goto L5;
    L7:
        FansRankListAnimationWidget r7 = this.a;
        if (r7.n == null) goto L15;
        AnimatedDrawable2 r8 = r7.m;
        if (r8 == null) goto L15;
        r8.start();
        AnimatedDrawable2 r9 = r7.n;
        if (r9 == null) goto L14;
        r9.start();
    L14:
        ((Widget) r7).contentView.postDelayed(new d0(r7), 4000);
        return;
    L15:
        r7.wq();
        return;
    L5:
        if ((r5 instanceof AnimatedDrawable2) == false) goto L7;
        AnimatedDrawable2 r10 = (AnimatedDrawable2) r5;
        this.a.n = r10;
        r10.setAnimationListener(new y(this));
        goto L7
    }
}
