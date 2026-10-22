package com.bytedance.android.live.browser.service;

import android.content.Context;
import com.bytedance.android.live.browser.AnnieParamUtil;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.l6;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t extends i9.c {
    public final Map<String, Object> I1() {
        String[] r0 = AnnieParamUtil.a;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("perf", (Integer) l6.a.getValue());
        IMiddleWareHostContext r2 = jc1.k.f(IMiddleWareHostContext.class);
        if (r2 == null) goto L5;
        r1.put("aid", String.valueOf(r2.hostAppId()));
        r1.put("appID", String.valueOf(r2.hostAppId()));
        r1.put("appName", r2.appName());
        r1.put("app_name", r2.appName());
        r1.put("channel", r2.getChannel());
        r1.put("version_code", r2.getVersionCode());
        r1.put("webcast_sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
    L5:
        IMiddlewareUserService r3 = jc1.k.f(IMiddlewareUserService.class);
        if (r3 == null) goto L15;
        com.bytedance.android.livesdk.user.e r4 = r3.user();
        if (r4 == null) goto L15;
        String r5 = r4.n();
        if (r5 == null) goto L12;
        r1.put("user_id", r5);
    L12:
        String r6 = com.bytedance.android.live.base.model.user.o.a(r4.b());
        if (r6 == null) goto L15;
        r1.put("sec_user_id", r6);
    L15:
        return r1;
    }

    public t() {
    }

    public final Map<String, Object> H1(Context r4) {
        String[] r0 = AnnieParamUtil.a;
        if (r4 == null) goto L5;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("is_pad", Integer.valueOf(RomUtils.isTablet(r4) ? 1 : 0));
        r1.put("is_notch", Integer.valueOf(DigHoleScreenUtil.isDigHole(r4) ? 1 : 0));
        return r1;
    L5:
        return null;
    }
}
