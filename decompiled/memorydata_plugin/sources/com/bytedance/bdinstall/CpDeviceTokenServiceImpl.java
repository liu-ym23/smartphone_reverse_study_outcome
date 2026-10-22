package com.bytedance.bdinstall;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class CpDeviceTokenServiceImpl extends AbsDeviceTokenService implements SubpSyncManager.OnUpdateListener {
    private volatile String mDeviceToken;

    public CpDeviceTokenServiceImpl(InstallOptions r4) {
        SubpSyncManager.inst((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).observer(r4.getAidString(), "device_token", this);
    }

    @Override // com.bytedance.bdinstall.AbsDeviceTokenService
    public String getDeviceToken() {
        return this.mDeviceToken;
    }

    @Override // com.bytedance.bdinstall.SubpSyncManager.OnUpdateListener
    public void onUpdate(String r1, String r2) {
        updateToken(r1, null);
    }

    @Override // com.bytedance.bdinstall.DeviceTokenService
    public void updateToken(String r1, Env r2) {
        this.mDeviceToken = r1;
    }
}
