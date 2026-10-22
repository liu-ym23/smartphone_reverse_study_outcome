package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements Animator.AnimatorListener {
    public final /* synthetic */ XplayFloatWindowView.ViewHolder a;
    public final /* synthetic */ ObjectAnimator b;
    public final /* synthetic */ boolean c;

    public static final class a implements Runnable {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b.start();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animator");
        NoMoreSpaceTextView r5 = this.a.d;
        a r0 = new a(this);
        if (this.c == false) goto L5;
        long r1 = 500;
    L6:
        r5.postDelayed(r0, r1);
        return;
    L5:
        r1 = 1000;
        goto L6
    }

    public g(XplayFloatWindowView.ViewHolder r1, ObjectAnimator r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
