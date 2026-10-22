package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.ValueAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Function1<Float, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super Float, Unit> r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        Function1<Float, Unit> r0 = this.a;
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r0.invoke((Float) r4);
    }
}
