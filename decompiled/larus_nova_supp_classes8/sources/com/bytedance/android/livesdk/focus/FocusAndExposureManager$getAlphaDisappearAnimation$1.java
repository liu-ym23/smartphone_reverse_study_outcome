package com.bytedance.android.livesdk.focus;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FocusAndExposureManager$getAlphaDisappearAnimation$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ b a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Function0 c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        Intrinsics.checkNotNullParameter(r8, "animation");
        UtilityKotlinExtentionsKt.s(0, false, false, new FocusAndExposureManager$getAlphaDisappearAnimation$1$onAnimationEnd$1(this), 7);
    }

    public FocusAndExposureManager$getAlphaDisappearAnimation$1(b r1, View r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
