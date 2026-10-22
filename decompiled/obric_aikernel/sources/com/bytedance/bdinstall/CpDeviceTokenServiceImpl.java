package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes.dex */
final class CpDeviceTokenServiceImpl extends AbsDeviceTokenService implements SubpSyncManager.OnUpdateListener {
    private volatile String mDeviceToken;

    public CpDeviceTokenServiceImpl(InstallOptions r10) {
        SubpSyncManager.inst(r10.getContext()).observer(r10.getAidString(), "device_token", this);
    }

    @Override // com.bytedance.bdinstall.AbsDeviceTokenService
    protected String getDeviceToken() {
        return this.mDeviceToken;
    }

    @Override // com.bytedance.bdinstall.SubpSyncManager.OnUpdateListener
    public void onUpdate(String r10, String r11) {
        updateToken(r10, null);
    }

    @Override // com.bytedance.bdinstall.DeviceTokenService
    public void updateToken(String r10, Env r11) {
        this.mDeviceToken = r10;
    }
}
