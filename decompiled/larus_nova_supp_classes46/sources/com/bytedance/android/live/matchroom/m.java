package com.bytedance.android.live.matchroom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends AnimatorListenerAdapter {
    public final /* synthetic */ Function0 a;

    public m(Function0 r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        boolean r3 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.e.removeListener(this);
        Function0 r4 = this.a;
        if (r4 == null) goto L6;
        Unit r5 = (Unit) r4.invoke();
        return;
    }
}
