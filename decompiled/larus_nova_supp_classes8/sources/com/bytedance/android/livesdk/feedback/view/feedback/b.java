package com.bytedance.android.livesdk.feedback.view.feedback;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ GlobalQuestionFeedback a;
    public final /* synthetic */ ArrayList b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        this.a.g(true);
    }

    public b(GlobalQuestionFeedback r1, ArrayList r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationStart(r2, r3);
        GlobalQuestionFeedback r4 = this.a;
        if (r4.l == null) goto L8;
        ViewGroup r5 = r4.b;
        if (r5 == null) goto L9;
        r5.setVisibility(0);
        return;
    L9:
        return;
    }
}
