package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import android.animation.ValueAnimator;
import com.larus.platform.api.IVideoController;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ l a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Function0 c;

    public /* synthetic */ g(l r1, long r2, Function0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final l r0 = this.a;
        long r1 = this.b;
        final Function0 r3 = this.c;
        StringBuilder r4 = new StringBuilder("stopPlayWithAnim: isPlaying=");
        IVideoController r5 = r0.a();
        if (r5 == null) goto L5;
        Boolean r6 = Boolean.valueOf(r5.p3());
    L6:
        r4.append(r6);
        g49.d.d("DoraOnboardingBgMusicPlayerV2", r4.toString());
        ValueAnimator r7 = r0.d;
        if (r7 == null) goto L11;
        boolean r8 = true;
        if (r7.isRunning() != true) goto L11;
    L12:
        if (r8 == false) goto L14;
        g49.d.d("DoraOnboardingBgMusicPlayerV2", "stopPlayWithAnim: stopAnim is running");
    L14:
        IVideoController r9 = r0.a();
        if (r9 == null) goto L17;
        float r10 = r9.g();
    L18:
        ValueAnimator r2 = com.larus.dora.impl.onboarding.v.a(r10, r1, new j(r0), new k(r0, r3));
        r0.d = r2;
        r2.start();
        return;
    L17:
        r10 = 1.0f;
    L11:
        r8 = false;
        goto L12
    L5:
        r6 = null;
        goto L6
    }
}
