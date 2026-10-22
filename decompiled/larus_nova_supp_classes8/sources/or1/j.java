package or1;

import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j, com.bytedance.android.scope.o {
    public j() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final float a() {
        return z0.b(false);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void onEnterPlay() {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r0.onEnterPlay();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void onEnterRoom() {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r0.onEnterRoom(null);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void onExitRoom() {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r0.onExitRoom();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void onModuleStop(String r2) {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r0.onModuleStop(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void release(int r2) {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r0.release(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void setStreamType(int r2) {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r0.setStreamType(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void startLoadStallMonitor(long r2) {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r0.startLoadStallMonitor(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void startTimerMonitor(int r2) {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r0.startTimerMonitor(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void stopTimerMonitor(int r2) {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 == null) goto L6;
        r0.stopTimerMonitor(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void forceStopLoadStallMonitor(long r2, boolean r4) {
        IPerformanceManager r5 = jc1.k.f(IPerformanceManager.class);
        if (r5 == null) goto L6;
        r5.forceStopLoadStallMonitor(r2, true);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.j
    public final void onModuleStart(String r2, Map<String, String> r3) {
        IPerformanceManager r4 = jc1.k.f(IPerformanceManager.class);
        if (r4 == null) goto L6;
        r4.onModuleStart(r2, null);
        return;
    }
}
