package com.larus.dora.impl.guide;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.strategy.FeatureGuideServerStrategy;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraNotificationGuide extends a0 {
    public DoraDevice g;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final String j() {
        return "dora_notification_guide";
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object v() {
        DoraDevice r0 = this.g;
        if (r0 != null) goto L6;
        r0 = DoraAdapterExtKt.h(kj4.a.g());
    L6:
        if (r0 != null) goto L9;
        g49.d.d(k(), "resolveDeviceParams() failed: currentDevice is null");
        return null;
    L9:
        String r2 = r0.getSerialNumber();
        if (r2 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L20;
        g49.d.d(k(), "resolveDeviceParams() failed: serialNumber is null");
        return null;
    L20:
        return new i59.a(r2, String.valueOf(n1.c(r0)));
    L12:
        if (r2.length() == 0) goto L15;
        r3 = false;
        goto L16
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final DoraGuideMeta i() {
        return DoraGuideMeta.DoraNotificationGuide;
    }

    public DoraNotificationGuide(String r2) {
        Intrinsics.checkNotNullParameter(r2, "page");
        super(r2);
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object p(Continuation<? super Boolean> r5) {
        DoraDevice r6 = DoraAdapterExtKt.h(kj4.a.g());
        int r0 = kj4.a.g().getDoraLinkState(r6);
        if (r6 != null) goto L5;
    L9:
        g49.d.d(k(), "localConditionCheck: device not connected, device=" + r6 + ", linkState=" + r0);
        return Boxing.boxBoolean(false);
    L5:
        if (r0 != 2) goto L9;
        this.g = r6;
        return Boxing.boxBoolean(true);
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void r(j59.a r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        g49.d.d(k(), "onCloseBtnClicked()");
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void u(j59.a r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        g49.d.d(k(), "onShow()");
        int r5 = j49.a.a;
        DoraBuryPointManager.a.L("dora_floating_window_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "notification_broadcast"), TuplesKt.to("window_content_action", "click_start_experience")}));
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void s(j59.a r5, Fragment r6) {
        Intrinsics.checkNotNullParameter(r5, "state");
        g49.d.d(k(), "onConfirmBtnClicked()");
        if (r6 == null) goto L6;
        Context r7 = r6.getContext();
        if (r7 == null) goto L6;
    L7:
        DoraDevice r8 = this.g;
        if (r8 != null) goto L10;
        r8 = DoraAdapterExtKt.h(kj4.a.g());
    L10:
        com.bytedance.router.i r9 = SmartRouter.buildRoute(r7, "//flow/dora/notification_broadcast");
        r9.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "notification_broadcast");
        r9.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, this.a);
        r9.c.putExtra("product_id", o59.a.c(r8));
        r9.c.putExtra("from_onboarding", true);
        r9.d();
        int r10 = j49.a.a;
        DoraBuryPointManager.a.L("dora_floating_window_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "notification_broadcast"), TuplesKt.to("window_content_action", "click_start_experience")}));
        return;
    L6:
        r7 = AppHost.a.getApplication();
        goto L7
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object w(i59.a r4, j59.a r5, Continuation<? super Boolean> r6) {
        return new FeatureGuideServerStrategy(new DoraNotificationGuide$serverConditionCheck$strategy$1(r4, r5, null), k(), false).a(r6);
    }
}
