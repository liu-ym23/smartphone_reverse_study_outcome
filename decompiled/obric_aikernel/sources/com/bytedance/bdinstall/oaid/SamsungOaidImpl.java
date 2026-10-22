package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdService;

/* JADX INFO: loaded from: classes.dex */
final class SamsungOaidImpl extends BaseOaidImpl<IDeviceIdService> {
    SamsungOaidImpl() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context r10) {
        Intent r11 = new Intent();
        r11.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return r11;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDeviceIdService, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Samsung";
    }
}
