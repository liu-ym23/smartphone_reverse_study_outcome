package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ c a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ int c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        c r3 = this.a;
        r3.b = null;
        r3.c = 0;
        this.b.invoke(Integer.valueOf(this.c));
    }

    public d(c r1, Function1 r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
