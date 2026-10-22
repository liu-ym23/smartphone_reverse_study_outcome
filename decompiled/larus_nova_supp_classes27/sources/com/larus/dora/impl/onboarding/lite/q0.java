package com.larus.dora.impl.onboarding.lite;

import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q0 implements Function1<TextView, Unit> {
    public final /* synthetic */ DoraLiteOnboardingWakeupFragment a;

    public q0(DoraLiteOnboardingWakeupFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        Intrinsics.checkNotNullParameter((TextView) r2, "it");
        DoraLiteOnboardingWakeupFragment r3 = this.a;
        int r0 = DoraLiteOnboardingWakeupFragment.s;
        r3.ea0();
        return Unit.INSTANCE;
    }
}
