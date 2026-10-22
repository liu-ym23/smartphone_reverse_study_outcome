package q19;

import android.animation.Animator;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b implements Animator.AnimatorListener {
    public b() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        FLogger.a.d("RefreshHeaderLayout", "fakeRefreshingAnimator onAnimationCancel");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        FLogger.a.d("RefreshHeaderLayout", "fakeRefreshingAnimator onAnimationEnd");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        FLogger.a.d("RefreshHeaderLayout", "fakeRefreshingAnimator onAnimationRepeat");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        FLogger.a.d("RefreshHeaderLayout", "fakeRefreshingAnimator onAnimationStart");
    }
}
