package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g extends AnimatorListenerAdapter {
    public final /* synthetic */ MmAINotePanelAnimator a;

    public g(MmAINotePanelAnimator r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        MmAINotePanelAnimator r0 = this.a;
        if (r0.q == r3) goto L5;
        return;
    L5:
        r0.q = null;
        r0.o = MmAINoteSheetState.FULL;
        r0.g(r0.q(), 0.0f);
    }
}
