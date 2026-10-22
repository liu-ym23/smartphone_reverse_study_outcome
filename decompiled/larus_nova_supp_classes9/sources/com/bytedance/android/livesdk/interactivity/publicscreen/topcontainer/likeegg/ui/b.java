package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ LikeEggView a;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.likeegg.a b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        LikeEggView r0 = this.a;
        if (r0.h != 2) goto L5;
        LikeEggView.d(r0, this.b);
    L5:
        super.onAnimationCancel(r4);
    }

    public b(LikeEggView r1, com.bytedance.android.livesdk.chatroom.likeegg.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        LikeEggView r0 = this.a;
        if (r0.h != 2) goto L5;
        LikeEggView.d(r0, this.b);
    L5:
        super.onAnimationEnd(r4, r5);
    }
}
