package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.transition.Transition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements Transition.TransitionListener {
    public final /* synthetic */ DoraHStreamlinedInterruptFragment a;

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
    }

    public j(DoraHStreamlinedInterruptFragment r1) {
        this.a = r1;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
        r2.removeListener(this);
        DoraHStreamlinedInterruptFragment r3 = this.a;
        float r0 = DoraHStreamlinedInterruptFragment.z;
        r3.ia0();
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
        r2.removeListener(this);
        DoraHStreamlinedInterruptFragment r3 = this.a;
        float r0 = DoraHStreamlinedInterruptFragment.z;
        r3.ia0();
    }
}
