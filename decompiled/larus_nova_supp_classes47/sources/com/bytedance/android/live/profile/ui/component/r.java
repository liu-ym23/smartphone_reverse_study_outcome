package com.bytedance.android.live.profile.ui.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r extends AnimatorListenerAdapter {
    public final /* synthetic */ LottieAnimationView a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Ref.IntRef c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        View r3 = this.b;
        if (r3 == null) goto L5;
        UtilityKotlinExtentionsKt.A(r3, true);
    L5:
        UtilityKotlinExtentionsKt.z(this.a, false);
        int r4 = com.bytedance.android.live.profile.ui.util.u.a;
        int r5 = this.c.element;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = ts0.a.f;
        Integer r6 = Integer.valueOf(r5);
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r6);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        View r4 = this.b;
        if (r4 == null) goto L5;
        UtilityKotlinExtentionsKt.A(r4, true);
    L5:
        UtilityKotlinExtentionsKt.z(this.a, false);
        Ref.IntRef r5 = this.c;
        int r1 = r5.element + 1;
        r5.element = r1;
        int r6 = com.bytedance.android.live.profile.ui.util.u.a;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r7 = ts0.a.f;
        Integer r0 = Integer.valueOf(r1);
        r7.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r7, r0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.c.element++;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        View r3 = this.b;
        if (r3 == null) goto L6;
        UtilityKotlinExtentionsKt.A(r3, false);
        return;
    }

    public r(LottieAnimationView r1, View r2, Ref.IntRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
