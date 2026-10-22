package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ KtvMidiViewV2 a;

    public c(KtvMidiViewV2 r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        KtvMidiViewV2.S5(this.a.n);
        KtvMidiViewV2.S5(this.a.l);
    }
}
