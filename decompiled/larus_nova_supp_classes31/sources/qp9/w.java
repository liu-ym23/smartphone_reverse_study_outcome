package qp9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w extends AnimatorListenerAdapter {
    public final /* synthetic */ ScaleGestureLayout a;
    public final /* synthetic */ Function0<Unit> b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationEnd(r3);
        this.a.v = null;
        FLogger.a.d("ScaleGestureLayout", "animateDisappear Step2 appearOrDisAppearAnimator end");
        this.b.invoke();
    }

    public w(ScaleGestureLayout r1, vp9.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
