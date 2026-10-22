package com.larus.api.bussiness;

import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.u;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i implements u {
    public i() {
    }

    public final void cancel() {
        qr9.b r0 = VideoFeedProviderDelegate.b.getTopPlayerController();
        if (r0 == null) goto L5;
        r0.playPlayer();
    L5:
        Keva r1 = a.a;
        a.a(AppHost.a.getAppClock().currentTimeMillis());
    }
}
