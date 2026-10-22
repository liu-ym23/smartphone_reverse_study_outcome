package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdManager;

/* JADX INFO: loaded from: classes.dex */
final class CoolpadOaidImpl extends BaseOaidImpl<IDeviceIdManager> {
    private static final String DEVICEIDMANAGER_SERVICE_CLASSNAME = "com.coolpad.deviceidsupport.DeviceIdService";
    private static final String DEVICEIDMANAGER_SERVICE_PACKAGENAME = "com.coolpad.deviceidsupport";
    private final Context mContext;

    CoolpadOaidImpl(Context r10) {
        super(DEVICEIDMANAGER_SERVICE_PACKAGENAME);
        this.mContext = r10;
    }

    static /* synthetic */ Context access$000(CoolpadOaidImpl r10) {
        return r10.mContext;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context r10) {
        Intent r11 = new Intent();
        r11.setComponent(new ComponentName(DEVICEIDMANAGER_SERVICE_PACKAGENAME, DEVICEIDMANAGER_SERVICE_CLASSNAME));
        return r11;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDeviceIdManager, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "coolpad";
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl, com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r10) {
    L8:
        th = move-exception;
        th.printStackTrace();
    L11:
        return super.getOaid(r10);
    L3:
        if (Build.VERSION.SDK_INT < 17) goto L11;
        String r11 = Settings.Global.getString(r10.getContentResolver(), "coolos.oaid");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r11) == true) goto L11;
        OaidApi.Result r12 = new OaidApi.Result();     // Catch: Throwable -> L8
        r12.oaid = r11;     // Catch: Throwable -> L8
        return r12;
    }
}
