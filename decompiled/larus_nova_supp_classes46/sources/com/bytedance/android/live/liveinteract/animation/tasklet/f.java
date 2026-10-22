package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends AnimatorListenerAdapter {
    public final /* synthetic */ IconMoveAnimationTasklet a;
    public final /* synthetic */ HSImageView b;
    public final /* synthetic */ EPointF c;
    public final /* synthetic */ EPointF d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Animatable f;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        Animatable r3 = this.f;
        if (r3 == null) goto L6;
        r3.stop();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationStart(r3);
        Animatable r4 = this.f;
        if (r4 == null) goto L5;
        r4.start();
    L5:
        com.bytedance.android.live.liveinteract.animation.e r5 = this.a.m;
        EPointF r0 = this.c;
        if (r5.Mk(r0, r0, this.d) == true) goto L8;
        IconMoveAnimationTasklet r6 = this.a;
        HSImageView r1 = this.b;
        r6.getClass();
        ViewGroup.LayoutParams r7 = r1.getLayoutParams();
        r7.width = 1;
        r7.height = 1;
        r1.setLayoutParams(r7);
        return;
    L8:
        this.a.d(this.b, this.e);
    }

    public f(IconMoveAnimationTasklet r1, HSImageView r2, EPointF r3, EPointF r4, int r5, Animatable r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
