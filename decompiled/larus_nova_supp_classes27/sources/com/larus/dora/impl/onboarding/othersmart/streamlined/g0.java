package com.larus.dora.impl.onboarding.othersmart.streamlined;

import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g0<T> implements FlowCollector {
    public final /* synthetic */ DoraHStreamlinedWakeupFragment a;

    public g0(DoraHStreamlinedWakeupFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        if ((((com.larus.dora.impl.onboarding.othersmart.a) r3) instanceof com.larus.dora.impl.onboarding.othersmart.a.C0089a) == false) goto L9;
        DoraHStreamlinedWakeupFragment r5 = this.a;
        if (r5.D == true) goto L7;
        r5.D = true;
        goto L9
    L7:
        DoraExternalOnboardingViewModel.enterOnboardingMode$default(r5.ca0(), false, 1, null);
        this.a.ca0().enterVoiceOnlyMode(true);
    L9:
        return Unit.INSTANCE;
    }
}
