package com.larus.dora.impl.device_v2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.onboarding.g.v2.DoraGOnboardingDialogFragmentV2;
import com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class m implements Function0 {
    public final /* synthetic */ DoraDeviceBindFragment a;

    public /* synthetic */ m(DoraDeviceBindFragment r1) {
        this.a = r1;
    }

    public final Object invoke() {
        final DoraDeviceBindFragment r0 = this.a;
        r0.getClass();
        g49.d.d("DoraDeviceBindFragment", "launchOnboarding");
        BottomSheetDialogFragment r1 = r0.i;
        if (r1 != null) goto L55;
    L10:
        Integer r2 = r0.o;
        if (r2 == null) goto L13;
        int r3 = r2.intValue();
    L15:
        if (o59.a.o(Integer.valueOf(r3)) == false) goto L22;
        int r4 = com.larus.dora.impl.util.s.a;
        if (com.larus.dora.impl.util.s.c(Integer.valueOf(r3)) == true) goto L22;
        g49.d.d("DoraDeviceBindFragment", "Dora G product=" + r3 + " is disabled, block G onboarding dialog");
        FragmentActivity r5 = r0.getActivity();
        if (r5 == null) goto L49;
        r5.finish();
    L49:
        return Unit.INSTANCE;
    L22:
        if (r3 != ProductNameType.DORA_LITE.id) goto L25;
        Fragment r6 = new DoraLiteOnboardingDialogFragment();
    L33:
        if (r6 == null) goto L47;
        Bundle r7 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("key_dora_is_new_multi_device", Boolean.TRUE), TuplesKt.to("key_dora_product_id", Integer.valueOf(r3)), TuplesKt.to("key_dora_onboarding_origin_from", r0.j), TuplesKt.to("bury_point_source", r0.q)});
        Bundle r8 = r0.getArguments();
        if (r8 == null) goto L37;
        r7.putAll(r8);
    L37:
        r6.setArguments(r7);
        FragmentManager r9 = r0.getParentFragmentManager();     // Catch: Exception -> L45
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L45
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "DoraDeviceBindFragment", r10);     // Catch: Exception -> L45
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r6, r10) == false) goto L53;
    L43:
        r0.i = r6;     // Catch: Exception -> L45
        goto L47
    L53:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50
    L42:
        r6.show(r9, "DoraDeviceBindFragment");     // Catch: Exception -> L45
    L45:
        e = move-exception;
        g49.d.c("DoraDeviceBindFragment", "launchOnboarding show dialog exception", e);
    L47:
        o5.b(r0, "fragment_request_key_onboarding_start", new n(r0));
        goto L49
    L25:
        if (r3 != ProductNameType.DORA_G.id) goto L27;
    L32:
        r6 = new DoraGOnboardingDialogFragmentV2();
        goto L33
    L27:
        if (r3 == ProductNameType.DORA_G2.id) goto L32;
        if (r3 == ProductNameType.DORA_G_AIR.id) goto L32;
        r6 = null;
        goto L33
    L13:
        r3 = 0;
        goto L15
    L55:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r11 = DialogFragmentLancet.sLastShowStack;
        if (r11 == null) goto L10;
        com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }
}
