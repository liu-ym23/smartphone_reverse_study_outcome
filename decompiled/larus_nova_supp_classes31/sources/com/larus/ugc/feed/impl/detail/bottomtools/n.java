package com.larus.ugc.feed.impl.detail.bottomtools;

import android.view.animation.Animation;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n implements Animation.AnimationListener {
    public n() {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r3) {
        FLogger.a.i("CreationDetailBottomToolsViewV2", "onAnimationEnd");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r3) {
        FLogger.a.i("CreationDetailBottomToolsViewV2", "onAnimationRepeat");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r3) {
        FLogger.a.i("CreationDetailBottomToolsViewV2", "onAnimationStart");
    }
}
