package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CustomDiggTapView.c a;
    public final /* synthetic */ Ref.IntRef b;

    public i(CustomDiggTapView.c r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r9) {
        Intrinsics.checkNotNullParameter(r9, "it");
        CustomDiggTapView.c r0 = this.a;
        Object r1 = r9.getAnimatedValue("scale");
        Object r3 = null;
        if ((r1 instanceof Float) == true) goto L5;
        r1 = null;
    L5:
        Float r2 = (Float) r1;
        if (r2 == null) goto L8;
        float r4 = r2.floatValue();
    L9:
        r0.c = r4;
        ImageView r5 = r0.d;
        if (r5 == null) goto L12;
        r5.setScaleX(r4);
        r5.setScaleY(r4);
    L12:
        long r6 = r9.getCurrentPlayTime();
        if (0 <= r6) goto L16;
    L27:
        long r7 = r9.getCurrentPlayTime();
        if (400 <= r7) goto L31;
    L43:
        this.b.element++;
        return;
    L31:
        if (650 < r7) goto L43;
        CustomDiggTapView.c r8 = this.a;
        Object r10 = r9.getAnimatedValue("alpha");
        if ((r10 instanceof Integer) == false) goto L36;
        r3 = r10;
    L36:
        Integer r11 = (Integer) r3;
        if (r11 == null) goto L39;
        int r13 = r11.intValue();
    L40:
        r8.a = r13;
        CustomDiggTapView.c r14 = this.a;
        ImageView r15 = r14.d;
        if (r15 == null) goto L43;
        r15.setAlpha(r14.a / 255.0f);
        goto L43
    L39:
        r13 = this.a.a;
        goto L40
    L16:
        if (400 < r6) goto L27;
        CustomDiggTapView.c r16 = this.a;
        Object r17 = r9.getAnimatedValue("rotate");
        if ((r17 instanceof Float) == true) goto L20;
        r17 = null;
    L20:
        Float r18 = (Float) r17;
        if (r18 == null) goto L23;
        float r19 = r18.floatValue();
    L24:
        r16.b = r19;
        CustomDiggTapView.c r20 = this.a;
        ImageView r21 = r20.d;
        if (r21 == null) goto L27;
        r21.setRotation(r20.b);
        goto L27
    L23:
        r19 = this.a.b;
        goto L24
    L8:
        r4 = this.a.c;
        goto L9
    }
}
