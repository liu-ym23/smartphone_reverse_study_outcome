package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends AnimatorListenerAdapter {
    public final /* synthetic */ n a;
    public final /* synthetic */ QuickInteractTask b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.c.clearAnimation();
        this.a.d.clearAnimation();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.b.setVisibility(0);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r3 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r3 == null) goto L6;
        r3.Xb(this.b);
        return;
    }

    public l(n r1, QuickInteractTask r2) {
        this.a = r1;
        this.b = r2;
    }
}
