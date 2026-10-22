package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingKeepAliveFragment;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalSmartOnboardingRadioFragment;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m<T> implements FlowCollector {
    public final /* synthetic */ DoraHStreamlinedInterruptFragment a;

    public m(DoraHStreamlinedInterruptFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        ((Boolean) r3).booleanValue();
        DoraHStreamlinedInterruptFragment r5 = this.a;
        float r6 = DoraHStreamlinedInterruptFragment.z;
        if (com.larus.dora.impl.onboarding.x.a(r5.ca0().getDoraOnboardingDevice()) == false) goto L20;
        this.a.getClass();
        if (DoraOnboardingBaseFragment.Y90() == false) goto L19;
        this.a.getClass();
        DoraUserSettingsManager r7 = DoraUserSettingsManager.a;
        IObricDoraService r8 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r8 == null) goto L11;
        boolean r9 = true;
        if (r8.n() != true) goto L11;
    L12:
        if (r9 == false) goto L14;
        g49.d.d("DoraExternalOnboardingBaseFragment", "skip notification guide for OBRIC proactive setting hidden");
    L14:
        if (r9 == false) goto L19;
        this.a.getClass();
        if (DoraOnboardingBaseFragment.X90() == false) goto L18;
        Fragment r10 = new DoraExternalOnboardingKeepAliveFragment();
    L21:
        this.a.Z90(r10);
        return Unit.INSTANCE;
    L18:
        r10 = new DoraHStreamlinedCompletionFragment();
    L11:
        r9 = false;
    L19:
        r10 = new DoraHStreamlinedNotificationFragment();
        Bundle r11 = new Bundle();
        r11.putString("arg_card_name", "new_broadcast_intro_card");
        r10.setArguments(r11);
        goto L21
    L20:
        r10 = new DoraExternalSmartOnboardingRadioFragment();
        goto L21
    }
}
