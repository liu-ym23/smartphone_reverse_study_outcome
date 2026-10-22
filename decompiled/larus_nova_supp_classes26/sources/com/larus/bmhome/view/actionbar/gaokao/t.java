package com.larus.bmhome.view.actionbar.gaokao;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t implements Animation.AnimationListener {
    public final /* synthetic */ View a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    public t(View r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r2) {
        this.a.setVisibility(0);
    }
}
