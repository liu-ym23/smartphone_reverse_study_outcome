package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.animation.n0;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ PathEffectAnimationTasklet a;
    public final /* synthetic */ HSImageView b;
    public final /* synthetic */ py.k c;
    public final /* synthetic */ EPointF d;
    public final /* synthetic */ EPointF e;
    public final /* synthetic */ FrameLayout f;

    public final void onFailure(String r3, Throwable r4) {
        super.onFailure(r3, r4);
        PathEffectAnimationTasklet r5 = this.a;
        FrameLayout r6 = this.f;
        HSImageView r0 = this.b;
        r5.getClass();
        r6.post(new y(r5, r0, r6));
    }

    public final void onFinalImageSet(String r9, Object r10, Animatable r11) {
        ImageInfo r12 = (ImageInfo) r10;
        if ((r11 instanceof AnimatedDrawable2) == false) goto L14;
        AnimatedDrawable2 r13 = (AnimatedDrawable2) r11;
        com.bytedance.android.live.core.utils.fresco.c.c(r13);
        PathEffectAnimationTasklet r14 = this.a;
        HSImageView r15 = this.b;
        py.k r0 = this.c;
        EPointF r1 = this.d;
        EPointF r2 = this.e;
        r14.getClass();
        if (r1 != null) goto L7;
        return;
    L7:
        if (com.bytedance.android.live.liveinteract.utils.v.a(r1) == true) goto L16;
        if (r2 != null) goto L10;
        return;
    L10:
        if (com.bytedance.android.live.liveinteract.utils.v.a(r2) == true) goto L18;
        UtilityKotlinExtentionsKt.w(r15);
        float r3 = n0.a(r1, r2);
        float r4 = ((PointF) r1).x;
        float r5 = ((PointF) r2).x;
        float r6 = r4 - r5;
        float r7 = ((PointF) r1).y;
        float r8 = ((PointF) r2).y;
        float r16 = r7 - r8;
        float r17 = r4 + r5;
        float r18 = 2;
        float r19 = r17 / r18;
        float r20 = (r7 + r8) / r18;
        int r21 = (int) Math.sqrt((r6 * r6) + (r16 * r16));
        int r22 = (int) ((r21 / r0.getHeight()) * r0.getWidth());
        r15.setX(r19 - (r22 / 2));
        r15.setY(r20 - (r21 / 2));
        r15.setRotation(r3);
        ViewGroup.LayoutParams r23 = r15.getLayoutParams();
        r23.width = r22;
        r23.height = r21;
        r15.setLayoutParams(r23);
        r13.setAnimationListener(new w(r14, r15));
        r13.start();
        return;
    L18:
        return;
    L16:
        return;
    }

    public u(PathEffectAnimationTasklet r1, HSImageView r2, py.k r3, EPointF r4, EPointF r5, FrameLayout r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
