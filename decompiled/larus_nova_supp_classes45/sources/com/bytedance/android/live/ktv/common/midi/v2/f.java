package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends AnimatorListenerAdapter {
    public final /* synthetic */ KtvRoomMidiViewV2 a;

    public f(KtvRoomMidiViewV2 r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        KtvRoomMidiViewV2 r3 = this.a;
        if (r3.r == false) goto L8;
        Animator r4 = r3.k;
        if (r4 == null) goto L9;
        r4.start();
        return;
    L9:
        return;
    }
}
