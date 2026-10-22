package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p5 implements Runnable {
    public final /* synthetic */ CameraTransitionViewHolder a;
    public final /* synthetic */ View b;

    public p5(CameraTransitionViewHolder r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        CameraTransitionViewHolder r0 = this.a;
        CameraTransitionViewHolder.State r1 = CameraTransitionViewHolder.State.IDLE;
        r0.getClass();
        UtilityKotlinExtentionsKt.t(this.b);
        this.b.setAlpha(0.0f);
        CameraTransitionViewHolder r2 = this.a;
        r2.e = false;
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, r2.d, 0, 2);
        if (r3 == null) goto L7;
        com.bytedance.live.datacontext.m r4 = r3.getStreamTransitionAnimating();
        if (r4 == null) goto L7;
        r4.setValue(Boolean.FALSE);
    L7:
        CameraTransitionViewHolder r5 = this.a;
        View r6 = r5.b;
        if (r6 == null) goto L10;
        UtilityKotlinExtentionsKt.t(r6);
    L10:
        LiveDoubleColorBallAnimationView r7 = r5.c;
        if (r7 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r7);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
