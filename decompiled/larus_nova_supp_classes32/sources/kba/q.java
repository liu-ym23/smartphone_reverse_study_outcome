package kba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ o b;

    public q(o r1) {
        this.b = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        o r0 = this.b;
        if (r0.p == r3) goto L5;
        return;
    L5:
        r0.p = null;
        if (this.a == false) goto L8;
        return;
    L8:
        if (r0.j == false) goto L12;
        r0.c();
        return;
    }
}
