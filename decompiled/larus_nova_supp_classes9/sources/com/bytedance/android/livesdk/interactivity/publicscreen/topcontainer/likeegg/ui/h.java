package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.view.animation.Animation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements Animation.AnimationListener {
    public final /* synthetic */ Animation a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        Function0 r3 = this.b;
        if (r3 == null) goto L5;
        Unit r4 = (Unit) r3.invoke();
    L5:
        this.a.setAnimationListener(null);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
        Function0 r2 = this.c;
        if (r2 == null) goto L6;
        Unit r3 = (Unit) r2.invoke();
        return;
    }

    public h(Animation r1, Function0 r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
