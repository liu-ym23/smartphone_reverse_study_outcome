package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.bytedance.ee.bear.contract.setting.OfflineResIntervalConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b0 implements com.bytedance.ee.bear.doc.resupdate.h {
    public final boolean a;

    public final String getDeviceId() {
        return ((epb.a) LarkContext.spiByDwarf(epb.a.class)).getDeviceId();
    }

    public final boolean isBoe() {
        if (((gpb.a) ApiUtils.getApi(gpb.a.class)).isBoe() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public b0() {
        this.a = eu5.c.b(eu5.b.a);
    }

    public final long c() {
        long r0 = SettingManager.getInstance().getLong(OfflineResIntervalConfig.class);
        if (r0 != 0) goto L6;
        return 300000;
    L6:
        return r0;
    }

    public final String d() {
        return jcb.b.c().a("docs_fe_resource_hotfix");
    }

    public final int getAppId() {
        iva.a.a().getClass();
        return LarkAppContext.inst().appIdInfo().a;
    }

    public final String b(Context r2) {
        int r0 = com.bytedance.ee.bear.doc.resupdate.c.a;
        return com.bytedance.ee.bear.doc.resupdate.c.a(r2, isBoe());
    }

    public final boolean isEnable(String r2) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2);
    }

    public final void a(String r2, JSONObject r3) {
        if (this.a == false) goto L5;
        return;
    L5:
        if (isBoe() == true) goto L9;
        com.ss.android.lark.statistics.b.b(r2, r3);
        return;
    }
}
