package com.larus.voicecall.impl.degrade;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.voicecall.impl.degrade.bean.QuotaCtaResult;
import com.larus.voicecall.impl.degrade.bean.QuotaInfo;
import hq9.q3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g implements q3 {
    public final /* synthetic */ QuotaInfo a;

    public final void a() {
    }

    public final void b(boolean r1) {
    }

    public final void c() {
        QuotaInfo r0 = this.a;
        if (r0 == null) goto L7;
        QuotaCtaResult r1 = r0.getCtaResult();
        if (r1 == null) goto L7;
        String r2 = r1.getActionUrl();
    L8:
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        return;
    L16:
        AppHost.Companion r4 = AppHost.a;
        Context r5 = r4.a().getCurrentActivity();
        if (r5 != null) goto L20;
        r5 = r4.getApplication().getApplicationContext();
    L20:
        SmartRouter.buildRoute(r5, r2).d();
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r6 = ICommerceMembershipService.a.a();
        if (r6 == null) goto L24;
        r6.w(r2, null);
        return;
    L24:
        return;
    L10:
        if (r2.length() == 0) goto L13;
        r3 = false;
    L7:
        r2 = null;
        goto L8
    }

    public g(QuotaInfo r1) {
        this.a = r1;
    }
}
