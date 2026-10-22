package fd0;

import android.animation.Animator;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements Animator.AnimatorListener {
    public final /* synthetic */ LiveAnimator a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    public g(LiveAnimator r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
        b r2 = this.a.i;
        if (r2 == null) goto L5;
        r2.onStop();
    L5:
        this.a.getClass();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
        a r2 = this.a.h;
        if (r2 == null) goto L6;
        r2.onStart();
        return;
    }
}
