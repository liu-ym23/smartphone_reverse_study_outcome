package com.larus.dora.obric.device_management.setting.g.device_info;

import android.os.Bundle;
import by7.h;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel;
import com.larus.dora.impl.device.settings.general.w;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.f;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricGDeviceInfoFragment$buildScrollContent$contentContainer$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricGDeviceInfoFragment$buildScrollContent$contentContainer$1$1(Object r8) {
        super(0, r8, DoraObricGDeviceInfoFragment.class, "openOtaPage", "openOtaPage()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m318invoke() {
        DoraObricGDeviceInfoFragment r0 = (DoraObricGDeviceInfoFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricGDeviceInfoFragment.l;
        Object r2 = ((GeneralSettingsViewModel) r0.g.getValue()).getGeneralSettingsStateFlow().getValue();
        DoraDevice r3 = null;
        if ((r2 instanceof w.b) == false) goto L5;
        w.b r4 = (w.b) r2;
    L6:
        if (r4 == null) goto L8;
        r3 = r4.b;
    L8:
        if (r3 == null) goto L12;
        i r5 = SmartRouter.buildRoute(r0.getContext(), "//flow/dora/obric_g_update");
        Bundle r6 = f.c(new Pair[0]);
        h.k(r6, r0);
        r5.c.putExtras(r6);
        r5.c.putExtra("route_param_product_id", r3.productId);
        r5.c.putExtra("mac", r3.mac);
        r5.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC, r3.mac);
        r5.d = 2130772401;
        r5.e = 2130772399;
        r5.d();
        return;
    L12:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m318invoke();
        return Unit.INSTANCE;
    }
}
