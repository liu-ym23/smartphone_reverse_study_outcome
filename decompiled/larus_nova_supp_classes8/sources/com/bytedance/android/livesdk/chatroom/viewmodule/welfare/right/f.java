package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements Animation.AnimationListener {
    public final /* synthetic */ g a;
    public final /* synthetic */ View b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        this.b.setVisibility(8);
        this.a.d.invoke();
    }

    public f(g r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
