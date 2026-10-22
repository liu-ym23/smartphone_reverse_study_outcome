package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BottomSelfDiggOptimizeView.b a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Ref.IntRef c;

    public b(BottomSelfDiggOptimizeView.b r1, long r2, Ref.IntRef r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        BottomSelfDiggOptimizeView.b r0 = this.a;
        r0.getClass();
        ImageView r1 = r0.e;
        if (r1 != null) goto L5;
        return;
    L5:
        long r2 = r10.getCurrentPlayTime();
        Object r5 = null;
        if (0 <= r2) goto L9;
    L18:
        long r3 = this.b;
        long r4 = r3 - (r3 / ((long) 4));
        long r6 = r10.getCurrentPlayTime();
        if (r4 <= r6) goto L22;
    L32:
        Object r11 = r10.getAnimatedValue();
        if (r11 == null) goto L37;
        PointF r13 = (PointF) r11;
        r1.setTranslationX(r13.x - (this.a.f.i * 0.5f));
        r1.setTranslationY(r13.y - (this.a.f.j * 0.5f));
        r1.setScaleX(this.a.a);
        r1.setScaleY(this.a.a);
        this.c.element++;
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    L22:
        if (r3 < r6) goto L32;
        Object r7 = r10.getAnimatedValue("iconAlpha");
        if ((r7 instanceof Integer) == false) goto L27;
        r5 = r7;
    L27:
        Integer r8 = (Integer) r5;
        if (r8 == null) goto L30;
        int r9 = r8.intValue();
    L31:
        r1.setAlpha(r9 / 255.0f);
        goto L32
    L30:
        r9 = (int) (r1.getAlpha() * 255);
        goto L31
    L9:
        if (250 < r2) goto L18;
        BottomSelfDiggOptimizeView.b r14 = this.a;
        Object r15 = r10.getAnimatedValue("iconScale");
        if ((r15 instanceof Float) == true) goto L13;
        r15 = null;
    L13:
        Float r16 = (Float) r15;
        if (r16 == null) goto L16;
        float r17 = r16.floatValue();
    L17:
        r14.a = r17;
        goto L18
    L16:
        r17 = this.a.a;
        goto L17
    }
}
