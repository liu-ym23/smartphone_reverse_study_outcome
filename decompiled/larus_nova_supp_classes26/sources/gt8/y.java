package gt8;

import android.animation.Animator;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y implements Animator.AnimatorListener {
    public final /* synthetic */ o a;

    public y(o r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        o r3 = this.a;
        r3.v = false;
        r3.e.a();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        o r3 = this.a;
        r3.v = false;
        r3.e.d();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.v = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        FLogger.a.i("PhotoClipRect", "onAnimationStart, clipRectRegion = " + this.a.q);
        o r4 = this.a;
        r4.e.b(r4.q);
        this.a.v = true;
    }
}
