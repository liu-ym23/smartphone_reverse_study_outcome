package com.larus.commercemembership.impl;

import android.content.Context;
import by7.a;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.track.TrackParams;
import com.larus.commercemembership.impl.utils.f;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.InAppBannerScene;
import com.larus.platform.api.d3;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import tc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ e b;

    public /* synthetic */ b(String r1, e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        String r0 = this.a;
        e r1 = this.b;
        CommerceMembershipService.a r2 = CommerceMembershipService.b;
        String r3 = r1.f();
        r2.getClass();
        if (StringsKt.isBlank(r0) == false) goto L5;
        FLogger.a.i("CommerceMembershipService", "open membership action schema skipped, schema is blank");
    L18:
        d3.a.d();
        return Unit.INSTANCE;
    L5:
        AppHost.Companion r4 = AppHost.a;
        Context r5 = r4.a().getCurrentActivity();
        if (r5 != null) goto L9;
        r5 = r4.getApplication().getApplicationContext();
    L9:
        SmartRouter.buildRoute(r5, r0).d();
        if (Intrinsics.areEqual(r3, InAppBannerScene.USER_EQUITY_CHANGED.getScene()) == false) goto L17;
        int r6 = com.larus.commercemembership.impl.utils.e.a;
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter("pop_click", "eventName");
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.put("name", "doubao_license_entrepreneur");     // Catch: JSONException -> L14
    L16:
        TrackParams r8 = new TrackParams().merge(r7);
        a r9 = new a("pop_click");
        r9.a.merge(r8);
        r9.b();
        g.a.monitorEventForSlardar("pop_click", r7, new JSONObject(), null);
    L14:
        e = move-exception;
        FLogger.a.e("CommerceMembershipMobHelper", "error in CommerceMembershipMobHelper mobPopClick " + e.getLocalizedMessage());
        goto L16
    L17:
        f.b(r0, null);
        goto L18
    }
}
