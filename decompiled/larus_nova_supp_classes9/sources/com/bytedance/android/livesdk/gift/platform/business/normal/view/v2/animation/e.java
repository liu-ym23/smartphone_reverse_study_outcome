package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ b a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ Long c;

    public final void onFailure(String r2, Throwable r3) {
        b r4 = this.a;
        HSImageView r5 = r4.c;
        if (r5 == null) goto L5;
        r5.setVisibility(8);
    L5:
        r4.a(false);
        AnimatedDrawable2 r6 = r4.a;
        if (r6 == null) goto L8;
        r6.stop();
    L8:
        r4.a = null;
        this.b.element = true;
    }

    public e(b r1, Ref.BooleanRef r2, Long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
        ImageInfo r6 = (ImageInfo) r4;
        if ((r5 instanceof AnimatedDrawable2) == true) goto L5;
        r5 = null;
    L5:
        AnimatedDrawable2 r7 = (AnimatedDrawable2) r5;
        if (r7 == null) goto L21;
        final Ref.BooleanRef r8 = new Ref.BooleanRef();
        r8.element = false;
        this.b.element = true;
        this.a.a = r7;
        com.bytedance.android.live.core.utils.fresco.c.c(r7);
        AnimatedDrawable2 r9 = this.a.a;
        if (r9 == null) goto L10;
        j.a(r9, new EntryAnimationTask$startAnim$listener$1$onFinalImageSet$$inlined$let$lambda$1(r8, this), EntryAnimationTask$startAnim$listener$1$onFinalImageSet$1$2.INSTANCE);
    L10:
        AnimatedDrawable2 r10 = this.a.a;
        if (r10 == null) goto L13;
        r10.start();
    L13:
        ViewGroup r11 = this.a.d;
        if (r11 == null) goto L22;
        d r13 = new d(this);
        Long r14 = this.c;
        if (r14 == null) goto L18;
        long r0 = r14.longValue();
    L19:
        r11.postDelayed(r13, r0);
        return;
    L18:
        r0 = 2250;
        goto L19
    L22:
        return;
    }
}
