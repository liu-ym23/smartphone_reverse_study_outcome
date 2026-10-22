package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.bytedance.router.SmartRouter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$4$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$4$1(Object r8) {
        super(0, r8, DoraObricEarbudsBroadcastSettingFragment.class, "openSocialMessagePage", "openSocialMessagePage()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m260invoke() {
        DoraObricEarbudsBroadcastSettingFragment r0 = (DoraObricEarbudsBroadcastSettingFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricEarbudsBroadcastSettingFragment.F;
        com.bytedance.router.i r2 = SmartRouter.buildRoute(r0.getContext(), "//flow/dora/obric_earbuds_social_message");
        r2.d = 2130772401;
        r2.e = 2130772399;
        Bundle r3 = BundleKt.bundleOf();
        by7.h.k(r3, r0);
        r2.c.putExtras(r3);
        r2.d();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m260invoke();
        return Unit.INSTANCE;
    }
}
