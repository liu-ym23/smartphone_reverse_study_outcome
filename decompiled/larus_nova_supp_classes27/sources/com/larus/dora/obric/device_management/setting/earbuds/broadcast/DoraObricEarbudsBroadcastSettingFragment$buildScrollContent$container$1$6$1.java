package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import androidx.core.os.BundleKt;
import com.bytedance.router.SmartRouter;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$6$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$6$1(Object r8) {
        super(0, r8, DoraObricEarbudsBroadcastSettingFragment.class, "openAppListPage", "openAppListPage()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m262invoke() {
        DoraObricEarbudsBroadcastSettingFragment r0 = (DoraObricEarbudsBroadcastSettingFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricEarbudsBroadcastSettingFragment.F;
        com.bytedance.router.i r2 = SmartRouter.buildRoute(r0.getContext(), "//flow/dora/obric_earbuds_app_list");
        r2.d = 2130772401;
        r2.e = 2130772399;
        r2.c.putExtras(BundleKt.bundleOf(new Pair[]{TuplesKt.to("extra_current_page", "dora_broadcast_applist"), TuplesKt.to("extra_previous_page", "dora_broadcast_settings")}));
        r2.d();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m262invoke();
        return Unit.INSTANCE;
    }
}
