package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.enteranim.view.GameDownloadEnterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends s72.c {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ GameDownloadEnterView b;
    public final /* synthetic */ a c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        this.a.removeView(this.b);
        ((v72.c.a) this.c).a();
    }

    @Override // s72.c, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
        a r2 = this.c;
        if (r2 == null) goto L6;
        ((v72.c.a) r2).b();
        return;
    }

    public j(ViewGroup r1, GameDownloadEnterView r2, a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
