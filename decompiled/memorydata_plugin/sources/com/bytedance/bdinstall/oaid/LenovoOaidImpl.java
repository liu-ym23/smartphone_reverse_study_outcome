package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.IDeviceidInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class LenovoOaidImpl extends BaseOaidImpl<IDeviceidInterface> {
    LenovoOaidImpl() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    public Intent buildIntent(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intent r3 = new Intent();
        r3.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return r3;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    public ServiceBlockBinder.ServiceBindedListener<IDeviceidInterface, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Lenovo";
    }
}
