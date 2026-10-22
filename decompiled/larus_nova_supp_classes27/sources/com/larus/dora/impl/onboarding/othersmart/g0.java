package com.larus.dora.impl.onboarding.othersmart;

import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g0 implements Function1<TextView, Unit> {
    public final /* synthetic */ DoraExternalSmartOnboardingWakeupFragment a;

    public g0(DoraExternalSmartOnboardingWakeupFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        Intrinsics.checkNotNullParameter((TextView) r2, "it");
        DoraExternalSmartOnboardingWakeupFragment r3 = this.a;
        int r0 = DoraExternalSmartOnboardingWakeupFragment.s;
        r3.fa0();
        return Unit.INSTANCE;
    }
}
