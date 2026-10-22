package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o0 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.dynamicframe.b a;
    public final /* synthetic */ DataCenter b;

    public o0(com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r1, DataCenter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r0 = this.a;
        if (r0 == null) goto L6;
        return new com.bytedance.android.live.liveinteract.jsbridge.method.b1(r0.p());
    L6:
        return jc1.k.n(IBaseBrowserService.class).provideRegisterWRDSMethod(this.b);
    }
}
