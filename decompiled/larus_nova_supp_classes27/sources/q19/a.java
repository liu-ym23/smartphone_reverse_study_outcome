package q19;

import android.animation.Animator;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements Animator.AnimatorListener {
    public a() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        FLogger.a.d("RefreshHeaderLayout", "fakeFinishAnimator onAnimationCancel");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        FLogger.a.d("RefreshHeaderLayout", "fakeFinishAnimator onAnimationEnd");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        FLogger.a.d("RefreshHeaderLayout", "fakeFinishAnimator onAnimationRepeat");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        FLogger.a.d("RefreshHeaderLayout", "fakeFinishAnimator onAnimationStart");
    }
}
