package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AudioPopupWindowImpl a;

    public a(AudioPopupWindowImpl r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        AudioPopupWindowImpl.b r0 = this.a.c;
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r0.setAlpha(((Float) r4).floatValue());
    }
}
