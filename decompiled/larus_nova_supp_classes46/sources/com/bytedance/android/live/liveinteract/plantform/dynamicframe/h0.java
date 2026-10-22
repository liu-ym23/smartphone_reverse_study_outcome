package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.browser.IBaseBrowserService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ e0 a;

    public h0(e0 r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return jc1.k.n(IBaseBrowserService.class).provideGetLiveNtpTimeMethod(this.a.b);
    }
}
