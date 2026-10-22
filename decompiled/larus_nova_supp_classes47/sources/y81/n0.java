package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n0 extends AnimatorListenerAdapter {
    public final /* synthetic */ d0 a;

    public n0(d0 r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        d0.v(this.a.m, 0.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "animation");
        ViewGroup r3 = this.a.m;
        if (r3 == null) goto L5;
        r3.setVisibility(0);
    L5:
        d0.v(this.a.m, 1.0f);
    }
}
