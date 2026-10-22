package com.larus.ugc.feed.impl.detail.bottomtools;

import android.view.animation.Animation;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j implements Animation.AnimationListener {
    public j() {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r3) {
        FLogger.a.i("CreationDetailBottomToolsView", "onAnimationEnd");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r3) {
        FLogger.a.i("CreationDetailBottomToolsView", "onAnimationRepeat");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r3) {
        FLogger.a.i("CreationDetailBottomToolsView", "onAnimationStart");
    }
}
