package com.ss.android.lark.imageqrcode.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Animator.AnimatorListener {
    public final /* synthetic */ ImageQRCodeSelectActivity a;
    public final /* synthetic */ AnimatorSet b;

    public static final class a implements Runnable {
        public final /* synthetic */ AnimatorSet a;

        public a(AnimatorSet r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.start();     // Catch: Throwable -> L4
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

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        this.a.c.postDelayed(new a(this.b), 2000);
    }

    public f(ImageQRCodeSelectActivity r1, AnimatorSet r2) {
        this.a = r1;
        this.b = r2;
    }
}
