package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public v(l r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        l r4 = this.a;
        r4.r(r4.m, 0.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ViewGroup r4 = this.a.m;
        if (r4 == null) goto L5;
        r4.setVisibility(0);
    L5:
        l r5 = this.a;
        r5.r(r5.m, 1.0f);
    }
}
