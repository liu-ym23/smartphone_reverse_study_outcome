package com.larus.dora.obric.device_management.device_bind;

import androidx.fragment.app.FragmentManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalDeviceOnboardingDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class n implements Function0 {
    public final /* synthetic */ DoraObricSmartDeviceBindFragment a;

    public /* synthetic */ n(DoraObricSmartDeviceBindFragment r1) {
        this.a = r1;
    }

    public final Object invoke() {
        DoraObricSmartDeviceBindFragment r0 = this.a;
        int r1 = DoraObricSmartDeviceBindFragment.v;
        if (n1.g() == false) goto L12;
        DoraOnboardingDialogViewModel r2 = r0.ba0();
        int r3 = r0.l;
        ProductNameType r4 = ProductNameType.H_FREE_CLIP_2_HE;
        if (r3 == r4.id) goto L11;
        r4 = ProductNameType.H_FREE_BUDS_PRO_5;
        if (r3 == r4.id) goto L11;
        r4 = ProductNameType.H_FREE_CLIP_2;
    L11:
        r2.startScan(r4, r0.p, 12000);
    L27:
        return Unit.INSTANCE;
    L12:
        r0.getClass();
        g49.d.d("DoraObricSmartDeviceBindFragment", "launchOnboarding");
        DoraExternalDeviceOnboardingDialogFragment r5 = r0.h;
        if (r5 != null) goto L31;
    L20:
        DoraExternalDeviceOnboardingDialogFragment r6 = new DoraExternalDeviceOnboardingDialogFragment();
        r6.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("key_dora_is_new_multi_device", Boolean.TRUE), TuplesKt.to("key_dora_onboarding_origin_from", r0.m), TuplesKt.to("bury_point_source", r0.n)}));
        FragmentManager r7 = r0.getParentFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "DoraObricSmartDeviceBindFragment", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r6, r8) == false) goto L29;
    L25:
        r0.h = r6;
        goto L27
    L29:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L24:
        r6.show(r7, "DoraObricSmartDeviceBindFragment");
        goto L25
    L31:
        r5.dismissAllowingStateLoss();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L20;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L20
    }
}
