package c69;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.larus.dora.impl.onboarding.g.DoraGOnboardingShimmerTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ DoraGOnboardingShimmerTextView a;

    public d(DoraGOnboardingShimmerTextView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        DoraGOnboardingShimmerTextView r3 = this.a;
        r3.b = null;
        r3.i.invoke();
    }
}
