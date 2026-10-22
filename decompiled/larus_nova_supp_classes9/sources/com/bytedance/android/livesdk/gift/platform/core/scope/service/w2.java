package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.effect.GiftRoomEffectSwitchService")
public interface w2 extends uh7.a {
    @BindsRpc(rpcName = "GetCurrentSoundVibrationStatus")
    k getCurrentSoundVibrationStatus();

    @BindsRpc(rpcName = "SetCurrentSoundVibrationStatus")
    void setCurrentSoundVibrationStatus(@RpcParam(paramName = "sound_on") boolean r1);
}
