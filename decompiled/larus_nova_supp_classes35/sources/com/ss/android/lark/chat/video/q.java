package com.ss.android.lark.chat.video;

import android.transition.Transition;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements Transition.TransitionListener {
    public final /* synthetic */ p a;
    public final /* synthetic */ VideoPreviewActivity b;

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition r1) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition r1) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition r1) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition r1) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition r2) {
        this.a.tD();
        this.b.setRequestedOrientation(-1);
        this.b.getWindow().getSharedElementEnterTransition().removeListener(this);
    }

    public q(p r1, VideoPreviewActivity r2) {
        this.a = r1;
        this.b = r2;
    }
}
