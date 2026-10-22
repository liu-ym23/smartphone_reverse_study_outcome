package com.larus.dora.obric.onboarding;

import android.widget.FrameLayout;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v1 implements AlphaPlayerAction {
    public final /* synthetic */ int a;
    public final /* synthetic */ ObricDoraGOnboardingWelcomeStateFragment b;
    public final /* synthetic */ long c;
    public final /* synthetic */ FrameLayout d;

    public final void a() {
    }

    public final void c(int r1, int r2, DataSource.ScaleType r3) {
        Intrinsics.checkNotNullParameter(r3, "scaleType");
    }

    public final void b() {
        final int r0 = this.a;
        final ObricDoraGOnboardingWelcomeStateFragment r1 = this.b;
        if (r0 != r1.N) goto L6;
        long r2 = this.c;
        final FrameLayout r4 = this.d;
        ObricDoraGOnboardingWelcomeStateFragment.ya0(r1, r2, 112, new u1(r1, r4, r0));
        return;
    }

    public v1(int r1, ObricDoraGOnboardingWelcomeStateFragment r2, long r3, FrameLayout r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}
