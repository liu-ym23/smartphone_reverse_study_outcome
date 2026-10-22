package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Animator.AnimatorListener {
    public final /* synthetic */ LinkSucAnimationView a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public d(LinkSucAnimationView r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        LinkSucAnimationView r6 = this.a;
        int r0 = LinkSucAnimationView.j;
        r6.getClass();
        ALogger.i("LinkSucAnimationView", "prepareMatchAnimation2, viewDetached=" + r6.h + ", guestName=" + r6.b);
        if (r6.h == true) goto L8;
        TextView r1 = r6.b;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNull(r1);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{0.0f, 1.0f});
        TextView r7 = r6.b;
        Intrinsics.checkNotNull(r7);
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r7, "translationY", new float[]{-20.0f, 0.0f});
        AnimatorSet r3 = new AnimatorSet();
        r3.playTogether(new Animator[]{r2, r8});
        r3.setDuration(100);
        r3.start();
        return;
    L8:
        Function0<Unit> r4 = r6.g;
        if (r4 == null) goto L11;
        r4.invoke();
    L11:
        LinkSucAnimationView.a r9 = r6.f;
        if (r9 == null) goto L16;
        r9.h();
        return;
    }
}
