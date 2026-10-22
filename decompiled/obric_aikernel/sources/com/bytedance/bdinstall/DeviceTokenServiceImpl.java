package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
final class DeviceTokenServiceImpl extends AbsDeviceTokenService {
    private final Context mContext;
    private volatile Env mEnv;
    private volatile InstallOptions mOptions;

    public DeviceTokenServiceImpl(InstallOptions r10, Env r11) {
        this.mOptions = r10;
        this.mContext = r10.getContext();
        this.mEnv = r11;
    }

    @Override // com.bytedance.bdinstall.AbsDeviceTokenService
    protected String getDeviceToken() {
        return this.mEnv.getEnvIsolateSp(this.mContext).getString("device_token", null);
    }

    @Override // com.bytedance.bdinstall.DeviceTokenService
    public void updateToken(String r10, Env r11) {
        this.mEnv = r11;
        if (r11 == null) goto L7;
        SharedPreferences r12 = r11.getEnvIsolateSp(this.mOptions);
        if (r12 == null) goto L7;
        r12.edit().putString("device_token", r10).apply();
    L7:
        SubpSyncManager.inst(this.mContext).sendSubpEvent(this.mOptions.getAidString(), "device_token", r10);
    }
}
