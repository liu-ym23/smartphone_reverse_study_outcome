package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.z;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.EnterAnimAppLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends AnimatorListenerAdapter {
    public final /* synthetic */ WindScreenRebirthAnimTrayView a;

    public l(WindScreenRebirthAnimTrayView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        com.bytedance.android.livesdk.interactivity.enteranim.utils.i r3 = this.a.j;
        if (r3 == null) goto L6;
        ((z) r3).a();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        com.bytedance.android.livesdk.interactivity.enteranim.utils.i r5 = this.a.j;
        if (r5 == null) goto L5;
        z r6 = (z) r5;
        r6.a.getClass();
        r6.b.l1(System.currentTimeMillis());
        EnterAnimAppLogger.f(r6.b);
    L5:
        com.bytedance.android.livesdk.interactivity.enteranim.utils.i r7 = this.a.j;
        if (r7 == null) goto L9;
        ((z) r7).b();
        return;
    }
}
