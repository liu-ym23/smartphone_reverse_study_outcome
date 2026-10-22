package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ MiniAppHotAtmosphereView a;

    public c(MiniAppHotAtmosphereView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.setAlpha(1.0f);
        this.a.setVisibility(4);
    }
}
