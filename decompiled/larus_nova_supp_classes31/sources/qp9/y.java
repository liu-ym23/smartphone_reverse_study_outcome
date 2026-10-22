package qp9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y extends AnimatorListenerAdapter {
    public final /* synthetic */ ScaleGestureLayout a;

    public y(ScaleGestureLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        ScaleGestureLayout r3 = this.a;
        int r0 = ScaleGestureLayout.M;
        r3.l();
    }
}
