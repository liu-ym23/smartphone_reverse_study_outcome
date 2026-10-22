package qp9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x extends AnimatorListenerAdapter {
    public final /* synthetic */ ScaleGestureLayout a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ Function0<Unit> c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationEnd(r3);
        FLogger.a.i("ScaleGestureLayout", "animateDisappear Step3 appearOrDisAppearAnimator end");
        this.a.v = null;
        this.b.element = true;
        this.c.invoke();
    }

    public x(ScaleGestureLayout r1, Ref.BooleanRef r2, vp9.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
