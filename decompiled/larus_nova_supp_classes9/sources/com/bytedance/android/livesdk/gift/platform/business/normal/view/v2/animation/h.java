package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ f a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ Ref.ObjectRef c;

    public final void onFailure(String r1, Throwable r2) {
        this.a.b();
        this.b.element = true;
    }

    public h(f r1, Ref.BooleanRef r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        ImageInfo r5 = (ImageInfo) r3;
        if ((r4 instanceof AnimatedDrawable2) == true) goto L5;
        r4 = null;
    L5:
        AnimatedDrawable2 r6 = (AnimatedDrawable2) r4;
        if (r6 == null) goto L17;
        final Ref.BooleanRef r7 = new Ref.BooleanRef();
        r7.element = false;
        this.b.element = true;
        this.a.a = r6;
        com.bytedance.android.live.core.utils.fresco.c.c(r6);
        AnimatedDrawable2 r8 = this.a.a;
        if (r8 == null) goto L10;
        j.a(r8, new ExitAnimationTask$playAchievementWebp$listener$1$onFinalImageSet$$inlined$let$lambda$1(r7, this), ExitAnimationTask$playAchievementWebp$listener$1$onFinalImageSet$1$2.INSTANCE);
    L10:
        AnimatedDrawable2 r9 = this.a.a;
        if (r9 == null) goto L13;
        r9.start();
    L13:
        ObjectAnimator r10 = (ObjectAnimator) this.c.element;
        if (r10 == null) goto L18;
        r10.start();
        return;
    L18:
        return;
    }
}
