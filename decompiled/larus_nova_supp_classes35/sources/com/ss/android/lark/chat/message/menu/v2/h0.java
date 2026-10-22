package com.ss.android.lark.chat.message.menu.v2;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ b0 a;

    public h0(b0 r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        RecyclerView r0 = this.a.c;
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r0.setTranslationY(((Float) r4).floatValue());
    }
}
