package com.bytedance.android.livesdk.interactivity.like;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 extends AnimatorListenerAdapter {
    public final /* synthetic */ DiggWidget a;
    public final /* synthetic */ View b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        View r3 = this.b;
        if (r3 == null) goto L6;
        r3.setAlpha(1.0f);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationStart(r2);
        this.a.G1.getClass();
        ALogger.i("PanelCoverListener", "listener = DiggWidget, onAnimationStart VISIBLE");
        UtilityKotlinExtentionsKt.w(this.b);
    }

    public b0(DiggWidget r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
