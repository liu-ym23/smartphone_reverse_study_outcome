package jd8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h extends AnimatorListenerAdapter {
    public final /* synthetic */ g a;

    public h(g r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        g r3 = this.a;
        r3.M = null;
        r3.f();
        s r4 = this.a.I;
        if (r4 == null) goto L6;
        r4.e();
        return;
    }
}
