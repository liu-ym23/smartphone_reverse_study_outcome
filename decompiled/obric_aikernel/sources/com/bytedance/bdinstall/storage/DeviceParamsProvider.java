package com.bytedance.bdinstall.storage;

import android.content.Context;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DeviceParamsProvider extends AbsDeviceParamsProvider {
    DeviceParamsProvider(Context r10, StorageSettings r11) {
        super(r10, r11);
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void clearAll() {
        this.mCache.clear(Arrays.asList(new String[]{"openudid", "clientudid", "device_id", "install_id"}));
    }
}
