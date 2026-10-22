package com.bytedance.android.livesdk.gift.fastgift;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.view.View;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 implements p0 {
    public final /* synthetic */ FastGiftViewV3 a;
    public final /* synthetic */ HSImageView b;
    public final /* synthetic */ View c;

    public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
    }

    public final void b(py.k r1, Exception r2) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(py.k r1) {
    }

    public a0(FastGiftViewV3 r1, HSImageView r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void c(py.k r11, int r13, int r14, boolean r15) {
        FastGiftViewV3 r16 = this.a;
        r16.w = true;
        HSImageView r17 = this.b;
        View r18 = this.c;
        AnimatorSet r0 = r16.u;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        r16.u = new AnimatorSet();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r18, "scaleX", new float[]{1.0f, 0.2f});
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r18, "scaleY", new float[]{1.0f, 0.2f});
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r18, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r17, "scaleX", new float[]{0.2f, 1.0f});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r17, "scaleY", new float[]{0.2f, 1.0f});
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r17, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet r7 = r16.u;
        if (r7 == null) goto L8;
        r7.playTogether(new Animator[]{r1, r3, r5, r2, r4, r6});
    L8:
        AnimatorSet r19 = r16.u;
        if (r19 == null) goto L11;
        r19.setDuration(400);
    L11:
        AnimatorSet r110 = r16.u;
        if (r110 == null) goto L14;
        r110.setInterpolator(new com.bytedance.android.live.core.widget.h());
    L14:
        AnimatorSet r111 = r16.u;
        if (r111 == null) goto L17;
        r111.addListener(new j(r16, r17, r18));
    L17:
        AnimatorSet r112 = r16.u;
        if (r112 == null) goto L21;
        r112.start();
        return;
    }
}
