package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i3 implements IMiddlewareHostBusiness.onLivePublishCallback {
    public final void onClose() {
    }

    public i3() {
    }

    public final void onPublish(JSONObject r3) {
        jc1.k.f(IBrowserService.class).sendEventToAllJsBridges("H5_publishVideoStatusChange", r3);
    }
}
