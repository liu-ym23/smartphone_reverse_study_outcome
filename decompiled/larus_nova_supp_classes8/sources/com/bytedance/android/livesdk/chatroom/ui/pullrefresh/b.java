package com.bytedance.android.livesdk.chatroom.ui.pullrefresh;

import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements Animation.AnimationListener {
    public final /* synthetic */ MaterialProgressDrawable.b a;
    public final /* synthetic */ MaterialProgressDrawable b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r5) {
        MaterialProgressDrawable.b r0 = this.a;
        r0.l = r0.e;
        r0.m = r0.f;
        r0.n = r0.g;
        r0.b((r0.k + 1) % r0.j.length);
        MaterialProgressDrawable.b r1 = this.a;
        r1.e = r1.f;
        r1.a();
        MaterialProgressDrawable r2 = this.b;
        if (r2.j == false) goto L7;
        r2.j = false;
        r5.setDuration(1332);
        MaterialProgressDrawable.b r6 = this.a;
        if (r6.o == false) goto L9;
        r6.o = false;
        r6.a();
        return;
    L9:
        return;
    L7:
        r2.g = (r2.g + 1.0f) % 5.0f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r2) {
        this.b.g = 0.0f;
    }

    public b(MaterialProgressDrawable r1, MaterialProgressDrawable.b r2) {
        this.b = r1;
        this.a = r2;
    }
}
