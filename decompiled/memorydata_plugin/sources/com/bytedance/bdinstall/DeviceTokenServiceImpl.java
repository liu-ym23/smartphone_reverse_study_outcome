package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class DeviceTokenServiceImpl extends AbsDeviceTokenService {
    private final Context mContext;
    private volatile Env mEnv;
    private volatile InstallOptions mOptions;

    public DeviceTokenServiceImpl(InstallOptions r3, Env r4) {
        this.mOptions = r3;
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mEnv = r4;
    }

    @Override // com.bytedance.bdinstall.AbsDeviceTokenService
    public String getDeviceToken() {
        return this.mEnv.getEnvIsolateSp(this.mContext).getString("device_token", null);
    }

    @Override // com.bytedance.bdinstall.DeviceTokenService
    public void updateToken(String r3, Env r4) {
        this.mEnv = r4;
        if (r4 == null) goto L7;
        SharedPreferences r5 = r4.getEnvIsolateSp(this.mOptions);
        if (r5 == null) goto L7;
        r5.edit().putString("device_token", r3).apply();
    L7:
        SubpSyncManager.inst(this.mContext).sendSubpEvent(this.mOptions.getAidString(), "device_token", r3);
    }
}
