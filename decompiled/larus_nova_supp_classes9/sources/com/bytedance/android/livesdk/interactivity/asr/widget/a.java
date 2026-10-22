package com.bytedance.android.livesdk.interactivity.asr.widget;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements Animator.AnimatorListener {
    public final /* synthetic */ long a;
    public final /* synthetic */ AnchorAsrHintWidget b;
    public final /* synthetic */ String c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        AnchorAsrHintWidget r3 = this.b;
        int r0 = AnchorAsrHintWidget.l;
        r3.zq("anim cancel");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        long r0 = System.currentTimeMillis() - this.a;
        int r1 = AnchorAsrHintWidget.l;
        this.b.zq("anim end. cost=" + r0);
        AnchorAsrHintWidget r6 = this.b;
        if (r6.g == 3) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r6.e, this.c) == false) goto L9;
        this.b.reset();
        return;
    }

    public a(long r1, AnchorAsrHintWidget r3, String r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }
}
