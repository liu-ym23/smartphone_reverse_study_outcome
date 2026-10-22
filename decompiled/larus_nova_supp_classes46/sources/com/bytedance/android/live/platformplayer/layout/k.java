package com.bytedance.android.live.platformplayer.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k extends AnimatorListenerAdapter {
    public final /* synthetic */ l.a a;

    public k(l.a r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationEnd(r3);
        this.a.a.c.setAlpha(1.0f);
        this.a.a.c.setVisibility(0);
        this.a.a.b.setAlpha(0.0f);
        this.a.a.b.setVisibility(8);
        this.a.a.a.Q = null;
        ALogger.i("ServerBlur", "change background anim done room id " + this.a.a.a.U2.x());
    }
}
