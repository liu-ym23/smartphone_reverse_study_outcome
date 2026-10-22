package com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker;

import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.livesdk.config.ke0;
import com.bytedance.android.livesdk.config.nh1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public volatile int a;
    public final int b;
    public final long c;
    public volatile boolean d;
    public final PluginContext e;

    public c(PluginContext r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        this.e = r3;
        this.b = 2;
        this.c = ((nh1) ke0.a.getValue()).b();
    }

    public final void a(boolean r11, int r12, boolean r13, long r14, String r16, String r17) {
        ((OpenPlatformMonitorService) this.e.o(OpenPlatformMonitorService.class)).c(r11 ? 1 : 0, r14, r12, r13, r16, r17);
    }
}
