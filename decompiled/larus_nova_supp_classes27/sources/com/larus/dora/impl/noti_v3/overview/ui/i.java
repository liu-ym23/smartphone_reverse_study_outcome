package com.larus.dora.impl.noti_v3.overview.ui;

import com.larus.platform.service.AccountService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ String a;

    public /* synthetic */ i(String r1) {
        this.a = r1;
    }

    public final Object invoke() {
        String r0 = this.a;
        int r1 = NotificationBroadcastV3Fragment.l;
        boolean r2 = Intrinsics.areEqual(r0, "1");
        com.larus.dora.impl.util.b0 r3 = com.larus.dora.impl.util.b0.a;
        String r4 = AccountService.a.getUserId();
        r3.getClass();
        com.larus.dora.impl.util.b0.L(r4, r2);
        return Unit.INSTANCE;
    }
}
