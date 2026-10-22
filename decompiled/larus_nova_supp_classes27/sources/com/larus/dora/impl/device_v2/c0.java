package com.larus.dora.impl.device_v2;

import androidx.fragment.app.FragmentManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.larus.dora.impl.databinding.LarusDoraExternalSmartDeviceBindPageBinding;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalDeviceOnboardingDialogFragment;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c0 implements Function0 {
    public final /* synthetic */ DoraSmartDeviceBindFragment a;

    public /* synthetic */ c0(DoraSmartDeviceBindFragment r1) {
        this.a = r1;
    }

    public final Object invoke() {
        DoraSmartDeviceBindFragment r0 = this.a;
        int r1 = DoraSmartDeviceBindFragment.B;
        if (n1.g() == false) goto L20;
        LarusDoraExternalSmartDeviceBindPageBinding r2 = r0.g;
        if (r2 == null) goto L34;
        e1.o(r2.d);
        e1.x(r2.c);
        Integer r3 = r0.p;
        ProductNameType r4 = ProductNameType.H_FREE_CLIP_2_HE;
        int r5 = r4.id;
        if (r3 != null) goto L10;
    L12:
        Integer r6 = r0.p;
        r4 = ProductNameType.H_FREE_BUDS_PRO_5;
        int r7 = r4.id;
        if (r6 != null) goto L16;
    L18:
        r4 = ProductNameType.H_FREE_CLIP_2;
    L19:
        r0.Y90().startScan(r4, r0.s, 12000);
        goto L34
    L16:
        if (r6.intValue() != r7) goto L18;
    L10:
        if (r3.intValue() != r5) goto L12;
    L34:
        r0.getClass();
        return Unit.INSTANCE;
    L20:
        r0.getClass();
        g49.d.d("DoraDeviceBindFragment", "launchOnboarding");
        DoraExternalDeviceOnboardingDialogFragment r8 = r0.j;
        if (r8 != null) goto L39;
    L28:
        DoraExternalDeviceOnboardingDialogFragment r9 = new DoraExternalDeviceOnboardingDialogFragment();
        r9.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("key_dora_is_new_multi_device", Boolean.TRUE), TuplesKt.to("key_dora_onboarding_origin_from", r0.k), TuplesKt.to("bury_point_source", r0.y)}));
        FragmentManager r10 = r0.getParentFragmentManager();
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r9, "DoraDeviceBindFragment", r11);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r9, r11) == false) goto L37;
    L33:
        r0.j = r9;
        goto L34
    L37:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
    L32:
        r9.show(r10, "DoraDeviceBindFragment");
        goto L33
    L39:
        r8.dismissAllowingStateLoss();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L28;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L28
    }
}
