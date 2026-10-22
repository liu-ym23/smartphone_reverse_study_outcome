package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BottomSelfDiggOptimizeView.c a;
    public final /* synthetic */ long b;

    public e(BottomSelfDiggOptimizeView.c r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        ImageView r0 = this.a.e;
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = r10.getCurrentPlayTime();
        Object r3 = null;
        if (0 <= r1) goto L9;
    L18:
        long r2 = this.b;
        long r4 = r2 - (r2 / ((long) 4));
        long r6 = r10.getCurrentPlayTime();
        if (r4 <= r6) goto L22;
    L32:
        Object r11 = r10.getAnimatedValue();
        if (r11 == null) goto L37;
        PointF r13 = (PointF) r11;
        r0.setTranslationX(r13.x - (this.a.f.a * 0.5f));
        r0.setTranslationY(r13.y - (this.a.f.b * 0.5f));
        r0.setScaleX(this.a.b);
        r0.setScaleY(this.a.b);
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    L22:
        if (r2 < r6) goto L32;
        Object r5 = r10.getAnimatedValue("iconAlpha");
        if ((r5 instanceof Integer) == false) goto L27;
        r3 = r5;
    L27:
        Integer r7 = (Integer) r3;
        if (r7 == null) goto L30;
        int r8 = r7.intValue();
    L31:
        r0.setAlpha(r8 / 255.0f);
        goto L32
    L30:
        r8 = (int) (r0.getAlpha() * 255);
        goto L31
    L9:
        if (250 < r1) goto L18;
        BottomSelfDiggOptimizeView.c r9 = this.a;
        Object r14 = r10.getAnimatedValue("iconScale");
        if ((r14 instanceof Float) == true) goto L13;
        r14 = null;
    L13:
        Float r15 = (Float) r14;
        if (r15 == null) goto L16;
        float r16 = r15.floatValue();
    L17:
        r9.b = r16;
        goto L18
    L16:
        r16 = this.a.b;
        goto L17
    }
}
