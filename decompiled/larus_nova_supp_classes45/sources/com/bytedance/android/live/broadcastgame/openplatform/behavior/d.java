package com.bytedance.android.live.broadcastgame.openplatform.behavior;

import android.animation.ObjectAnimator;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ ToolbarInteractPlayControlBehavior a;

    public d(ToolbarInteractPlayControlBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        ObjectAnimator r3 = this.a.c;
        if (r3 == null) goto L6;
        r3.start();
        return;
    }
}
