package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements Animation.AnimationListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ w91.c.a b;
    public final /* synthetic */ View c;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r1) {
        if (this.a == false) goto L7;
        w91.c.a r2 = this.b;
        if (r2 == null) goto L11;
        r2.a();
        return;
    L11:
        return;
    L7:
        w91.c.a r3 = this.b;
        if (r3 == null) goto L13;
        r3.c();
        return;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
        if (this.a == false) goto L7;
        w91.c.a r2 = this.b;
        if (r2 == null) goto L11;
        r2.d();
        return;
    L11:
        return;
    L7:
        w91.c.a r3 = this.b;
        if (r3 == null) goto L13;
        r3.b();
        return;
    }

    public g(boolean r1, f r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
