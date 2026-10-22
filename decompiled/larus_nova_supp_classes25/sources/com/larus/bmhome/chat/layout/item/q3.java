package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q3 extends AnimatorListenerAdapter {
    public final /* synthetic */ l3 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        if (Intrinsics.areEqual(this.a.g, r4) == false) goto L5;
        this.a.g = null;
    L5:
        int r5 = this.b;
        l3 r0 = this.a;
        if (r5 == r0.o) goto L8;
        return;
    L8:
        r0.a.setAlpha(1.0f);
        FLogger.a.i(this.a.b, "refreshCombinedEnd contentKey=" + this.c);
    }

    public q3(l3 r1, int r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
