package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a a;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r0 = this.a.a;     // Catch: Throwable -> L4
            r0.o.a(r0.f.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public b(com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r3 = this.a;
        r3.i = null;
        r3.l = false;
        r3.j = 0;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r4 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r4 == null) goto L5;
        r4.F6();
    L5:
        this.a.a.post(new a(this));
    }
}
