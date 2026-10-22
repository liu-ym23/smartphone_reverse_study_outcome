package com.bytedance.android.livesdk.gamecp.impl;

import android.content.Context;
import com.bytedance.android.gamecp.business.download.GameCenterStrategy;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements dw.f {
    public i() {
    }

    public final void b() {
    }

    public final void action(Context r2, JSONObject r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "extra");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L6;
        r0.action(r2, r3, r4);
        return;
    }

    public final void cancelDownload(Context r2, JSONObject r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "extra");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L6;
        r0.cancelDownload(r2, r3, r4);
        return;
    }

    public final void unSubscribe(Context r2, JSONObject r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "extra");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L6;
        r0.unSubscribe(r2, r3, r4);
        return;
    }

    public final void a(Context r3, JSONObject r4, JSONObject r5, GameCenterStrategy.doSubscribe.1 r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "extra");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L6;
        r0.subscribe(r3, r4, r5, new h(r6));
        return;
    }
}
