package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class CoolpadOaidImpl extends BaseOaidImpl<IDeviceIdManager> {
    private static final String DEVICEIDMANAGER_SERVICE_CLASSNAME = "com.coolpad.deviceidsupport.DeviceIdService";
    private static final String DEVICEIDMANAGER_SERVICE_PACKAGENAME = "com.coolpad.deviceidsupport";
    private final Context mContext;

    CoolpadOaidImpl(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(DEVICEIDMANAGER_SERVICE_PACKAGENAME);
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ Context access$000(CoolpadOaidImpl r0) {
        return r0.mContext;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    public Intent buildIntent(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intent r4 = new Intent();
        r4.setComponent(new ComponentName(DEVICEIDMANAGER_SERVICE_PACKAGENAME, DEVICEIDMANAGER_SERVICE_CLASSNAME));
        return r4;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    public ServiceBlockBinder.ServiceBindedListener<IDeviceIdManager, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "coolpad";
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl, com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        return super.getOaid(r4);
    L4:
        if (Build.VERSION.SDK_INT < 17) goto L12;
        String r0 = Settings.Global.getString(r4.getContentResolver(), "coolos.oaid");     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r0) == true) goto L12;
        OaidApi.Result r1 = new OaidApi.Result();     // Catch: Throwable -> L9
        r1.oaid = r0;     // Catch: Throwable -> L9
        return r1;
    }
}
