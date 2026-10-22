package com.bytedance.android.live.room.discovery.inspector;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends AnimatorListenerAdapter {
    public final /* synthetic */ OfficialInspectorWidget a;

    public h(OfficialInspectorWidget r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        this.a.i = null;
    }
}
