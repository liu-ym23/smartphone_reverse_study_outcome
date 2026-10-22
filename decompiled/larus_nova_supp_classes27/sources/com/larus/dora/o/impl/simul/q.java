package com.larus.dora.o.impl.simul;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.dora.o.impl.databinding.DoraOFragmentSimulInterpretBinding;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q extends AnimatorListenerAdapter {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ ODoraSimulInterpretFragment b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.element = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (this.a.element == false) goto L5;
        return;
    L5:
        final ODoraSimulInterpretFragment r4 = this.b;
        DoraOFragmentSimulInterpretBinding r0 = r4.d;
        if (r0 == null) goto L11;
        ConstraintLayout r1 = r0.C;
        if (r1 == null) goto L12;
        r1.post(new p(r4));
        return;
    L12:
        return;
    }

    public q(Ref.BooleanRef r1, ODoraSimulInterpretFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
