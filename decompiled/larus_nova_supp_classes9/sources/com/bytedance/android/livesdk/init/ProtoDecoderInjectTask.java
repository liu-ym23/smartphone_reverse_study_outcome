package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.tools.pbadapter.annotation.GenProtoDecoders;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@GenProtoDecoders
@WorkThreadTask
@Task(businessInfo = "WTO_ProtoDecoderInjectTask", value = IAssetsManager.DownloadAssetsSource.SOURCE_INTERACT_GIFT_PANEL)
public class ProtoDecoderInjectTask extends AbsTask {
    private static boolean hasInjected;
    private static final Object lock = null;

    static {
        lock = new Object();
    }

    public void run() {
        Object r0 = lock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (hasInjected == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L8:
        hasInjected = true;     // Catch: Throwable -> L17
        if (t.a == true) goto L15;
        yb.a.call("modelx");     // Catch: Throwable -> L17
        Map r2 = hz.a.a;     // Catch: Throwable -> L17
        if (jc1.k.f(IMiddlewareNetworkService.class) == null) goto L14;
        jc1.k.f(IMiddlewareNetworkService.class).injectProtoDecoders(r2);     // Catch: Throwable -> L17
    L14:
        t.a = true;     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
    }

    public ProtoDecoderInjectTask() {
    }
}
