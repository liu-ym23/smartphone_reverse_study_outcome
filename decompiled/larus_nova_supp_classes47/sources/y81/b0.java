package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0 extends AnimatorListenerAdapter {
    public final /* synthetic */ LottieAnimationView a;
    public final /* synthetic */ l b;

    public b0(LottieAnimationView r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ViewGroup.LayoutParams r4 = this.a.getLayoutParams();
        ViewGroup r5 = this.b.k;
        if (r5 == null) goto L5;
        int r6 = r5.getWidth();
    L6:
        r4.width = r6;
        ViewGroup r7 = this.b.k;
        if (r7 == null) goto L9;
        int r8 = r7.getHeight();
    L10:
        r4.height = r8;
        this.a.setLayoutParams(r4);
        this.a.setVisibility(0);
        return;
    L9:
        r8 = 0;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }
}
