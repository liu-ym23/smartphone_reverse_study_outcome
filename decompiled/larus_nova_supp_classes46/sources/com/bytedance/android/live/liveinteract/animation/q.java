package com.bytedance.android.live.liveinteract.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q extends AnimatorListenerAdapter {
    public final /* synthetic */ o a;
    public final /* synthetic */ int b;
    public final /* synthetic */ EPointF c;
    public final /* synthetic */ EPointF d;
    public final /* synthetic */ AnimatedDrawable2 e;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (this.a.m != null) goto L6;
        ALogger.i("InteractAnimation.InteractEmojiAnimationTask" + this.a.b, "path animation end since emoji cleared");
        return;
    L6:
        AnimatedDrawable2 r4 = this.e;
        if (r4 == null) goto L9;
        r4.stop();
    L9:
        HSImageView r5 = this.a.e;
        Intrinsics.checkNotNull(r5);
        UtilityKotlinExtentionsKt.u(r5);
        o r6 = this.a;
        InteractAnimationController.c r0 = r6.m;
        if (r0 != null) goto L12;
    L14:
        r6.i();
        o.n(this.a);
        return;
    L12:
        if (r0.d != true) goto L14;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        AnimatedDrawable2 r5 = this.e;
        if (r5 == null) goto L5;
        r5.start();
    L5:
        e r6 = this.a.d;
        if (r6 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNull(r6);
        EPointF r0 = this.c;
        boolean r7 = r6.Mk(r0, r0, this.d);
        if (r7 == true) goto L14;
        o r1 = this.a;
        HSImageView r2 = r1.e;
        if (r2 == null) goto L15;
        Intrinsics.checkNotNull(r2);
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.width = 1;
        r3.height = 1;
        HSImageView r8 = r1.e;
        Intrinsics.checkNotNull(r8);
        r8.setLayoutParams(r3);
    L15:
        InteractAnimationController.c r9 = this.a.m;
        if (r9 == null) goto L18;
        r9.c = r7;
    L18:
        ALogger.i("InteractAnimation.InteractEmojiAnimationTask" + this.a.b, "path emoji showWhenStart=" + r7);
        return;
    L14:
        this.a.p(this.b);
        goto L15
    }

    public q(o r1, int r2, EPointF r3, EPointF r4, AnimatedDrawable2 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
