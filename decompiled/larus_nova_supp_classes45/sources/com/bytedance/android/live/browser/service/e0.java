package com.bytedance.android.live.browser.service;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e0 implements com.bytedance.android.annie.param.n {
    public e0() {
    }

    public final String N0() {
        String r0 = (" WebcastEnv/SaaS." + com.bytedance.android.livesdk.paas.c.b()) + " webcast_AppId/" + jc1.k.n(IMiddleWareHostContext.class).appId();
        String r1 = jc1.k.n(IMiddleWareHostContext.class).ecHostAppId();
        if (mz.c.b(r1) == true) goto L5;
        r0 = r0 + " ecom_host_appid/" + r1;
    L5:
        Map r2 = jc1.k.n(IMiddleWareHostContext.class).getFEParamExtra();
        if (r2 == null) goto L15;
        Iterator r3 = r2.keySet().iterator();
    L9:
        if (r3.hasNext() == false) goto L15;
        String r4 = (String) r3.next();
        String r5 = (String) r2.get(r4);
        if (mz.c.b(r4) == true) goto L9;
        if (mz.c.b(r5) == true) goto L9;
        r0 = r0 + ' ' + r4 + '/' + r5;
    L15:
        return r0;
    }
}
