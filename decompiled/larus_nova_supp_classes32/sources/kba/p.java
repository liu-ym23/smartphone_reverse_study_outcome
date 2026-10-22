package kba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p extends AnimatorListenerAdapter {
    public final /* synthetic */ o a;

    public p(o r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        o r0 = this.a;
        if (r0.q == r3) goto L5;
        return;
    L5:
        r0.q = null;
        r0.c();
    }
}
