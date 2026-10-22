package com.bytedance.android.live.broadcast;

import com.bytedance.android.live.broadcast.api.IScopeCollectBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcast/BroadcastScopeInitializer;", "", "()V", "ensureInitialized", "", "manualRegister", "livebroadcast-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BroadcastScopeInitializer {
    public static final BroadcastScopeInitializer INSTANCE = null;

    private BroadcastScopeInitializer() {
    }

    public final void ensureInitialized() {
    }

    static {
        BroadcastScopeInitializer r1 = new BroadcastScopeInitializer();
        INSTANCE = r1;
        f00.a.C0230a r2 = f00.a.b;     // Catch: Throwable -> L8
        if (com.bytedance.android.scope.l.b(r2) == true) goto L6;
        vb.a.call("scope-modules");     // Catch: Throwable -> L8
        z03.a r3 = z03.a.a;     // Catch: Throwable -> L8
        com.bytedance.android.scope.m r4 = com.bytedance.android.scope.m.e;     // Catch: Throwable -> L8
        z03.a r5 = z03.a.a;     // Catch: Throwable -> L8
        r4.getClass();     // Catch: Throwable -> L8
        com.bytedance.android.scope.m.e(r5);     // Catch: Throwable -> L8
        r1.manualRegister();     // Catch: Throwable -> L8
        com.bytedance.android.scope.l.a(r2);     // Catch: Throwable -> L8
    L6:
        ALogger.i("BroadcastScopeTag", "init");     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        ALogger.e("BroadcastScopeTag", "init failed", th);
    }

    private final void manualRegister() {
        LivePluginSPIManager.e.getClass();
        if (LivePluginSPIManager.b() == false) goto L8;
        IScopeCollectBroadcastService r0 = (IScopeCollectBroadcastService) va1.b.a.a.a(IScopeCollectBroadcastService.class);
        if (r0 == null) goto L9;
        r0.registerScopeService();
        return;
    L9:
        return;
    }
}
