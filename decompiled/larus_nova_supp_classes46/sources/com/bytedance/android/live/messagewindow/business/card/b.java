package com.bytedance.android.live.messagewindow.business.card;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomRightCommonCard a;

    public b(BottomRightCommonCard r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        t61.c r3 = this.a.r;
        if (r3 == null) goto L8;
        Function0 r4 = r3.b;
        if (r4 == null) goto L9;
        Unit r5 = (Unit) r4.invoke();
        return;
    L9:
        return;
    }
}
