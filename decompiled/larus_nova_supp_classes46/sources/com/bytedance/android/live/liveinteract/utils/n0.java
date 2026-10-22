package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n0 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ DataCenter a;

    public n0(DataCenter r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return jc1.k.n(IBaseBrowserService.class).provideRegisterMessageLatchMethod(this.a);
    }
}
