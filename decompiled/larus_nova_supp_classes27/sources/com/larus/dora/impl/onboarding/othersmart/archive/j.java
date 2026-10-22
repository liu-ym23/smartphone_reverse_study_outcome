package com.larus.dora.impl.onboarding.othersmart.archive;

import android.widget.TextView;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalSmartOnboardingRadioFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements Function1<TextView, Unit> {
    public final /* synthetic */ DoraExternalSmartOnboardingWakeupFragmentOld a;

    public j(DoraExternalSmartOnboardingWakeupFragmentOld r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        Intrinsics.checkNotNullParameter((TextView) r2, "it");
        this.a.Z90(new DoraExternalSmartOnboardingRadioFragment());
        return Unit.INSTANCE;
    }
}
