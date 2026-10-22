package com.larus.dora.api;

import com.larus.avlink.plugins.u2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0011H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001¨\u0006#"}, d2 = {"Lcom/larus/dora/api/DoraByteCastManagerDelegate;", "Lcom/larus/dora/api/IByteCastManager;", "<init>", "()V", "changeSinkConfig", "", "cmd", "", "param", "Lorg/json/JSONObject;", "clearDataCallBack", "finishSession", "getBtBandwidthMonitorData", "Lcom/larus/dora/api/BluetoothBandwidthMonitorData;", "getBtBandwidthMonitorSnapshot", "Lcom/larus/dora/api/BluetoothBandwidthMonitorSnapshot;", "getRtcVideoDumpEnable", "", "init", "initAfterAbilityNegotiation", "invalidateP2PRTCClientOwnership", "isBtRtcRunning", "isInitSuccess", "isP2PRTCClientConnected", "recordMmtTargetBitrate", "targetBitrateBps", "", "requestKeyFrame", "setDataCallBack", "callBack", "Lcom/larus/dora/api/IByteCastDataCallBack;", "syncRtcVideoDumpEnable", "checked", "updateP2PRTCCompanionRetention", "retain", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraByteCastManagerDelegate implements IByteCastManager {
    public static final DoraByteCastManagerDelegate b = null;
    public final /* synthetic */ IByteCastManager a;

    static {
        b = new DoraByteCastManagerDelegate();
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean a() {
        return this.a.a();
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean b(boolean r2) {
        return this.a.b(r2);
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean c() {
        return this.a.c();
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void c0() {
        this.a.c0();
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void d() {
        this.a.d();
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void e(long r2) {
        this.a.e(r2);
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void f() {
        this.a.f();
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void g(u2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.a.g(r2);
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean h() {
        return this.a.h();
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void init() {
        this.a.init();
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void requestKeyFrame() {
        this.a.requestKeyFrame();
    }

    private DoraByteCastManagerDelegate() {
        this.a = (IByteCastManager) ServiceManager.get().getService(IByteCastManager.class);
    }
}
