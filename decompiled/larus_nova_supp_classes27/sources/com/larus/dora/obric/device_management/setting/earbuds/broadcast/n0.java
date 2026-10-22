package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.larus.platform.service.AccountService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class n0 implements Function0 {
    public final /* synthetic */ String a;

    public /* synthetic */ n0(String r1) {
        this.a = r1;
    }

    public final Object invoke() {
        String r0 = this.a;
        int r1 = DoraObricEarbudsBroadcastSettingFragment.F;
        boolean r2 = Intrinsics.areEqual(r0, "1");
        com.larus.dora.impl.util.b0 r3 = com.larus.dora.impl.util.b0.a;
        String r4 = AccountService.a.getUserId();
        r3.getClass();
        com.larus.dora.impl.util.b0.L(r4, r2);
        return Unit.INSTANCE;
    }
}
