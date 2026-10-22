package com.larus.dora.obric.device_management.device_bind;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingDialogFragment;
import com.larus.dora.obric.device_v2.ObricDoraGOnboardingDialogFragmentV2;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j implements Function0 {
    public final /* synthetic */ DoraObricDeviceBindFragment a;

    public /* synthetic */ j(DoraObricDeviceBindFragment r1) {
        this.a = r1;
    }

    public final Object invoke() {
        final DoraObricDeviceBindFragment r0 = this.a;
        BottomSheetDialogFragment r1 = r0.g;
        if (r1 != null) goto L58;
    L10:
        Integer r2 = r0.l;
        boolean r3 = false;
        if (r2 == null) goto L13;
        int r4 = r2.intValue();
    L14:
        Bundle r5 = r0.getArguments();
        if (r5 != null) goto L17;
    L19:
        boolean r6 = false;
    L21:
        if (r4 != ProductNameType.DORA_G.id) goto L24;
        if (r6 == true) goto L24;
        r3 = true;
    L24:
        g49.d.d("DoraObricDeviceBindFragment", "launchOnboarding: productId=" + r4 + ", autoConnect=" + r6 + ", scanAllGlassesProducts=" + r3);
        if (r4 != ProductNameType.DORA_LITE.id) goto L28;
        Fragment r7 = new DoraLiteOnboardingDialogFragment();
    L31:
        if (r7 == null) goto L53;
        Bundle r9 = r0.getArguments();
        if (r9 != null) goto L35;
        r9 = new Bundle();
    L35:
        Bundle r8 = new Bundle(r9);
        r8.putBoolean("key_dora_is_new_multi_device", true);
        r8.putInt("key_dora_product_id", r4);
        r8.putString("key_dora_onboarding_origin_from", r0.h);
        r8.putString("bury_point_source", r0.m);
        if (r3 == false) goto L38;
        r8.putIntArray("key_dora_scan_product_ids", DoraObricDeviceBindFragment.o);
    L39:
        r7.setArguments(r8);
        FragmentManager r10 = r0.getParentFragmentManager();     // Catch: Exception -> L51
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L51
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "DoraObricDeviceBindFragment", r11);     // Catch: Exception -> L51
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r7, r11) == false) goto L56;
    L45:
        r0.g = r7;     // Catch: Exception -> L51
        if (r6 == false) goto L53;
        Bundle r12 = r0.getArguments();     // Catch: Exception -> L51
        if (r12 == null) goto L53;
        r12.remove("key_dora_onboarding_auto_connect");     // Catch: Exception -> L51
        goto L53
    L56:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L55
    L44:
        r7.show(r10, "DoraObricDeviceBindFragment");     // Catch: Exception -> L51
    L51:
        e = move-exception;
        g49.d.c("DoraObricDeviceBindFragment", "launchOnboarding show dialog exception", e);
        goto L53
    L38:
        r8.remove("key_dora_scan_product_ids");
    L53:
        o5.b(r0, "fragment_request_key_onboarding_start", new k(r0));
        return Unit.INSTANCE;
    L28:
        if (DoraObricDeviceBindFragment.Y90(Integer.valueOf(r4)) == false) goto L30;
        r7 = new ObricDoraGOnboardingDialogFragmentV2();
        goto L31
    L30:
        r7 = null;
        goto L31
    L17:
        if (r5.getBoolean("key_dora_onboarding_auto_connect") != true) goto L19;
        r6 = true;
        goto L21
    L13:
        r4 = 0;
        goto L14
    L58:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r13 = DialogFragmentLancet.sLastShowStack;
        if (r13 == null) goto L10;
        com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }
}
