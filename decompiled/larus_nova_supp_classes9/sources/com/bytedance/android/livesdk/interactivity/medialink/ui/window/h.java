package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ MediaMultiLinkAudienceWindowManager a;

    public h(MediaMultiLinkAudienceWindowManager r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        JSONObject r4 = (JSONObject) r3;
        MediaMultiLinkAudienceWindowManager r5 = this.a;
        int r0 = MediaMultiLinkAudienceWindowManager.C;
        r5.getClass();
        ALogger.w("ttlive_anchor_link_wm", "MultiAnchorWindowManger.unloadModule", new IllegalStateException());
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r6 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r6 == null) goto L6;
        r6.K4(256);
        return;
    }
}
