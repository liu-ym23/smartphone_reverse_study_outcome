package com.ss.android.lark.chat.message.menu.v2.popup;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PopupMenuMainContent a;

    public i(PopupMenuMainContent r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
        Object r3 = r2.getAnimatedValue();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Float");
        float r4 = ((Float) r3).floatValue();
        PopupMenuMainContent r0 = this.a;
        r0.g = r4;
        r0.invalidate();
    }
}
