package com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker;

import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.config.le0;
import com.bytedance.android.livesdk.config.oh1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class GameFpsMonitor {
    public int a;
    public final int b;
    public final long c;
    public final GameFpsMonitor$fpsCheckTask$1 d;
    public final na4.b e;
    public final PluginContext f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (((oh1) le0.a.getValue()).c() == true) goto L6;
        return;
    L6:
        if (this.a <= this.b) goto L8;
        return;
    L8:
        MainThreadPostUtils.c(this.d, this.c);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker.GameFpsMonitor$fpsCheckTask$1] */
    public GameFpsMonitor(na4.b r2, PluginContext r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        this.e = r2;
        this.f = r3;
        le0 r4 = le0.a;
        this.b = ((oh1) r4.getValue()).b();
        this.c = ((oh1) r4.getValue()).a();
        this.d = new GameFpsMonitor$fpsCheckTask$1(this);
    }
}
