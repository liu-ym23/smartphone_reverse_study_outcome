package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.enteranim.view.EcomEnterTrayView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends s72.c {
    public final /* synthetic */ a a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ View c;

    @Override // s72.c
    public final void a() {
        this.a.getClass();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        this.b.removeView(this.c);
        ((v72.c.a) this.a).a();
    }

    @Override // s72.c, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
        a r2 = this.a;
        if (r2 == null) goto L6;
        ((v72.c.a) r2).b();
        return;
    }

    public h(a r1, ViewGroup r2, EcomEnterTrayView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
