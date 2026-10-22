package com.bytedance.android.live.broadcast;

import com.bytedance.android.live.broadcast.api.IScopeCollectBroadcastService;
import com.bytedance.android.live.broadcast.api.scope.global.IBroadcastInitService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdk.chatroom.broadcast.v2.NewLiveBroadcastShellFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/BroadcastInitService;", "Lcom/bytedance/android/live/broadcast/api/scope/global/IBroadcastInitService;", "()V", "hasRegisterOnce", "", "manualRegister", "", NewBroadcastMonitor.STAGE.START, "source", "", "livebroadcast-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BroadcastInitService implements IBroadcastInitService {
    private boolean hasRegisterOnce;

    private final void manualRegister() {
        IScopeCollectBroadcastService r0 = (IScopeCollectBroadcastService) va1.b.a.a.a(IScopeCollectBroadcastService.class);
        if (r0 == null) goto L6;
        r0.registerScopeService();
        return;
    }

    public BroadcastInitService() {
        ALogger.i("BroadcastScopeTag", "init in init.");
        BroadcastScopeInitializer.INSTANCE.ensureInitialized();
    }

    @Override // com.bytedance.android.live.broadcast.api.scope.global.IBroadcastInitService
    public void start(String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        boolean r0 = NewLiveBroadcastShellFragment.g;
        ALogger.i("BroadcastScopeTag", "start from " + r4);
        BroadcastScopeInitializer.INSTANCE.ensureInitialized();
        if (this.hasRegisterOnce == true) goto L8;
        this.hasRegisterOnce = true;
        ALogger.i("BroadcastScopeTag", "start from " + r4 + " once");
        manualRegister();
        f00.d.a r5 = f00.d.c;
        if (com.bytedance.android.scope.l.b(r5) == true) goto L9;
        ALogger.i("BroadcastScopeTag", "BroadcastOnlyGlobalScope enter.");
        com.bytedance.android.scope.l.a(r5);
        return;
    L9:
        return;
    }
}
