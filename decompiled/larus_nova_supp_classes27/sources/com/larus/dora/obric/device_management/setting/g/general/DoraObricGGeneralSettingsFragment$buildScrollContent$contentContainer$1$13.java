package com.larus.dora.obric.device_management.setting.g.general;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricGGeneralSettingsFragment$buildScrollContent$contentContainer$1$13 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricGGeneralSettingsFragment$buildScrollContent$contentContainer$1$13(Object r8) {
        super(0, r8, DoraObricGGeneralSettingsFragment.class, "openUnbindAndResetPage", "openUnbindAndResetPage()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m326invoke() {
        DoraObricGGeneralSettingsFragment r0 = (DoraObricGGeneralSettingsFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricGGeneralSettingsFragment.x;
        Object r2 = r0.ba0().getGeneralSettingsStateFlow().getValue();
        if ((r2 instanceof com.larus.dora.impl.device.settings.general.w.b) == false) goto L5;
        com.larus.dora.impl.device.settings.general.w.b r3 = (com.larus.dora.impl.device.settings.general.w.b) r2;
    L6:
        if (r3 == null) goto L12;
        DoraDevice r4 = r3.b;
        if (r4 == null) goto L13;
        com.bytedance.router.i r5 = SmartRouter.buildRoute(r0.getContext(), "//flow/dora/obric_g_unbind_and_reset");
        int r6 = r4.productId;
        r5.c.putExtra("route_param_product_id", r6);
        String r7 = r4.mac;
        r5.c.putExtra("mac", r7);
        String r8 = r4.mac;
        r5.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC, r8);
        r5.d = 2130772401;
        r5.e = 2130772399;
        r5.e(r4.productId);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m326invoke();
        return Unit.INSTANCE;
    }
}
