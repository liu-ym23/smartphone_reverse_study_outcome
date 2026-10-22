package com.larus.voicecall.impl.utils;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Animation.AnimationListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        this.a.setVisibility(4);
        if (this.b.getVisibility() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L9;
        c.b(this.b);
        return;
    L9:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public b(View r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
