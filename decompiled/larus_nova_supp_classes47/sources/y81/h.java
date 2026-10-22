package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends AnimatorListenerAdapter {
    public final /* synthetic */ c a;

    public h(c r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        c r4 = this.a;
        r4.r(r4.r, 0.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ViewGroup r4 = this.a.r;
        if (r4 == null) goto L5;
        r4.setVisibility(0);
    L5:
        c r5 = this.a;
        r5.r(r5.r, 1.0f);
    }
}
