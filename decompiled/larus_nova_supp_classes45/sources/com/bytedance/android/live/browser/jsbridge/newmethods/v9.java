package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "preDownloadGame")
public final class v9 extends p<w9, PreDownloadGameResultModel> {
    public final void onTerminate() {
    }

    public v9() {
    }

    public final void invoke(Object r2, CallContext r3) {
        w9 r4 = (w9) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        String r5 = r4.a();
        if (NetworkUtils.isWifi(r3.getContext()) == false) goto L9;
        IHostLiveOpenPlatform r6 = TTLiveSDK.hostService().hostOpenPlatform();
        if (r6 == null) goto L10;
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r6.preloadMiniGame(r5);
    L10:
        finishWithSuccess();
        return;
    L9:
        finishWithFailure(new Throwable("This device is not in wifi environment!"));
        goto L10
    }
}
