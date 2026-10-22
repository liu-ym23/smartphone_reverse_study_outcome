package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s implements LivePluginSPIManager.a {
    public final /* synthetic */ t a;

    public final void afterReady() {
        if (t.h(this.a) != null) goto L10;
        t r0 = this.a;
        r0.i = 0;
        if (0 == 0) goto L12;
        TTVideoEngine r3 = r0.g;
        if (r3 == null) goto L13;
        r3.setLongOption(440, 0);
        r0.g.setIntOption(430, 2);
        return;
    L13:
        return;
    L12:
        return;
    L10:
        t.h(this.a).h();
        throw null;
    }

    public s(t r1) {
        this.a = r1;
    }
}
