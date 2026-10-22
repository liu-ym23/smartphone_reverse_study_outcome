package com.larus.dora.api;

import com.larus.avlink.plugins.u2;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0006H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u0006H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0006H&¨\u0006!"}, d2 = {"Lcom/larus/dora/api/IByteCastManager;", "", "init", "", "initAfterAbilityNegotiation", "isInitSuccess", "", "isP2PRTCClientConnected", "invalidateP2PRTCClientOwnership", "updateP2PRTCCompanionRetention", "retain", "setDataCallBack", "callBack", "Lcom/larus/dora/api/IByteCastDataCallBack;", "clearDataCallBack", "requestKeyFrame", "changeSinkConfig", "cmd", "", "param", "Lorg/json/JSONObject;", "finishSession", "isBtRtcRunning", "getBtBandwidthMonitorData", "Lcom/larus/dora/api/BluetoothBandwidthMonitorData;", "getBtBandwidthMonitorSnapshot", "Lcom/larus/dora/api/BluetoothBandwidthMonitorSnapshot;", "recordMmtTargetBitrate", "targetBitrateBps", "", "getRtcVideoDumpEnable", "syncRtcVideoDumpEnable", "checked", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IByteCastManager {
    boolean a();

    boolean b(boolean r1);

    boolean c();

    void c0();

    void d();

    void e(long r1);

    void f();

    void g(u2.a r1);

    boolean h();

    void init();

    void requestKeyFrame();
}
