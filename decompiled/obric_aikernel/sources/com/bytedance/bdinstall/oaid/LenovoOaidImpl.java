package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.IDeviceidInterface;

/* JADX INFO: loaded from: classes.dex */
final class LenovoOaidImpl extends BaseOaidImpl<IDeviceidInterface> {
    LenovoOaidImpl() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context r10) {
        Intent r11 = new Intent();
        r11.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return r11;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDeviceidInterface, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Lenovo";
    }
}
