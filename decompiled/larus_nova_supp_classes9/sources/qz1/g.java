package qz1;

import android.animation.Animator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends o12.b {
    public final /* synthetic */ Runnable a;

    public g(e r1) {
        this.a = r1;
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
        this.a.run();
    }
}
