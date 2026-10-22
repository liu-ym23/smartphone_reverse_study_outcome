package com.larus.commercemembership.impl;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.commercemembership.impl.utils.e;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.d3;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class d implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ d(String r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        String r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        CommerceMembershipService.b.getClass();
        e.b(r0, "top_banner", r1, 56);
        if (StringsKt.isBlank(r2) == false) goto L5;
        FLogger.a.i("CommerceMembershipService", "open pc guide action schema skipped, schema is blank");
    L10:
        d3.a.d();
        return Unit.INSTANCE;
    L5:
        AppHost.Companion r3 = AppHost.a;
        Context r4 = r3.a().getCurrentActivity();
        if (r4 != null) goto L9;
        r4 = r3.getApplication().getApplicationContext();
    L9:
        SmartRouter.buildRoute(r4, r2).d();
        goto L10
    }
}
