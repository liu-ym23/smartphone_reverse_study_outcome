package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ KtvRoomMidiViewV2 a;

    public e(KtvRoomMidiViewV2 r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Animator r3 = this.a.l;
        if (r3 == null) goto L6;
        r3.start();
        return;
    }
}
