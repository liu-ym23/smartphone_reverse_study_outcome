package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DiggTapOptimizeView.b a;
    public final /* synthetic */ Ref.IntRef b;

    public t(DiggTapOptimizeView.b r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r9) {
        Intrinsics.checkNotNullParameter(r9, "it");
        DiggTapOptimizeView.b r0 = this.a;
        Object r2 = null;
        if (r0.h.d == true) goto L15;
        Object r1 = r9.getAnimatedValue("scale");
        if ((r1 instanceof Float) == true) goto L7;
        r1 = null;
    L7:
        Float r3 = (Float) r1;
        if (r3 == null) goto L10;
        float r4 = r3.floatValue();
    L11:
        r0.c = r4;
        ImageView r5 = r0.d;
        if (r5 == null) goto L15;
        r5.setScaleX(r4);
        r5.setScaleY(r4);
        goto L15
    L10:
        r4 = this.a.c;
    L15:
        if (this.a.h.e == true) goto L32;
        long r6 = r9.getCurrentPlayTime();
        if (0 > r6) goto L32;
        if (400 < r6) goto L32;
        DiggTapOptimizeView.b r7 = this.a;
        Object r8 = r9.getAnimatedValue("rotate");
        if ((r8 instanceof Float) == true) goto L24;
        r8 = null;
    L24:
        Float r10 = (Float) r8;
        if (r10 == null) goto L27;
        float r11 = r10.floatValue();
    L28:
        r7.b = r11;
        DiggTapOptimizeView.b r13 = this.a;
        ImageView r14 = r13.d;
        if (r14 == null) goto L32;
        r14.setRotation(r13.b);
        goto L32
    L27:
        r11 = this.a.b;
    L32:
        if (this.a.h.f == true) goto L49;
        long r15 = r9.getCurrentPlayTime();
        if (400 > r15) goto L49;
        if (650 < r15) goto L49;
        DiggTapOptimizeView.b r16 = this.a;
        Object r17 = r9.getAnimatedValue("alpha");
        if ((r17 instanceof Integer) == false) goto L42;
        r2 = r17;
    L42:
        Integer r18 = (Integer) r2;
        if (r18 == null) goto L45;
        int r19 = r18.intValue();
    L46:
        r16.a = r19;
        DiggTapOptimizeView.b r20 = this.a;
        ImageView r21 = r20.d;
        if (r21 == null) goto L49;
        r21.setAlpha(r20.a / 255.0f);
        goto L49
    L45:
        r19 = this.a.a;
    L49:
        this.b.element++;
    }
}
