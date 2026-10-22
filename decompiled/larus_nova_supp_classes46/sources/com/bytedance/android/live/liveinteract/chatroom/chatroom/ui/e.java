package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements Animator.AnimatorListener {
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

    public e(LinkSucAnimationView r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r7) {
        Intrinsics.checkNotNullParameter(r7, "animation");
        LinkSucAnimationView r8 = this.a;
        int r0 = LinkSucAnimationView.j;
        r8.getClass();
        ALogger.i("LinkSucAnimationView", "startUserNameAnimation, viewDetached=" + r8.h + ", guestName=" + r8.b);
        if (r8.h == false) goto L5;
    L19:
        Function0<Unit> r1 = r8.g;
        if (r1 == null) goto L22;
        r1.invoke();
    L22:
        LinkSucAnimationView.a r9 = r8.f;
        if (r9 == null) goto L27;
        r9.h();
        return;
    L27:
        return;
    L5:
        if (r8.b == null) goto L19;
        String r2 = r8.d;
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L18;
        TextView r4 = r8.b;
        if (r4 == null) goto L18;
        m.a r5 = m.q0;
        String r6 = r8.d;
        r5.getClass();
        r4.setText(m.a.a(r6));
    L18:
        TextView r10 = r8.b;
        Intrinsics.checkNotNull(r10);
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r10, "alpha", new float[]{0.1f, 1.0f});
        TextView r12 = r8.b;
        Intrinsics.checkNotNull(r12);
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r12, "translationY", new float[]{-10.0f, 0.0f});
        AnimatorSet r14 = new AnimatorSet();
        r14.playTogether(new Animator[]{r11, r13});
        r14.setDuration(200);
        r14.start();
        return;
    L10:
        if (r2.length() == 0) goto L13;
        r3 = false;
        goto L14
    }
}
