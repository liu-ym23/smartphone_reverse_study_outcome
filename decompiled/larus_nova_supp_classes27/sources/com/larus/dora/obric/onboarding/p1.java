package com.larus.dora.obric.onboarding;

import android.widget.FrameLayout;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IPrepareListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p1 implements IPrepareListener {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ObricDoraGOnboardingWelcomeStateFragment c;
    public final /* synthetic */ IPlayerController d;
    public final /* synthetic */ String e;

    public final void a() {
    }

    public final void onPrepared() {
        final FrameLayout r6 = this.a;
        final int r1 = this.b;
        final ObricDoraGOnboardingWelcomeStateFragment r2 = this.c;
        final IPlayerController r3 = this.d;
        final String r4 = this.e;
        r6.post(new o1(r1, r2, r3, r4, r6));
    }

    public p1(FrameLayout r1, int r2, ObricDoraGOnboardingWelcomeStateFragment r3, IPlayerController r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
