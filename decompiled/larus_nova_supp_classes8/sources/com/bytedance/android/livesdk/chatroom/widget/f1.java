package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f1 extends AnimatorListenerAdapter {
    public final /* synthetic */ LiveVisibilityControlWidget a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ AnimatorSet c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        LiveVisibilityControlContext r3 = this.a.p;
        if (r3 == null) goto L7;
        com.bytedance.live.datacontext.k r4 = r3.getControlAnimEndEvent();
        if (r4 == null) goto L7;
        r4.post(Boolean.valueOf(this.b));
    L7:
        this.c.removeAllListeners();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        LiveVisibilityControlContext r3 = this.a.p;
        if (r3 == null) goto L7;
        com.bytedance.live.datacontext.k r4 = r3.getControlAnimEndEvent();
        if (r4 == null) goto L7;
        r4.post(Boolean.valueOf(this.b));
    L7:
        this.c.removeAllListeners();
    }

    public f1(LiveVisibilityControlWidget r1, boolean r2, AnimatorSet r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
