package com.bytedance.bdinstall.storage;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class DeviceParamsProvider extends AbsDeviceParamsProvider {
    DeviceParamsProvider(Context r3, StorageSettings r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void clearAll() {
        this.mCache.clear(Arrays.asList(new String[]{"openudid", "clientudid", "device_id", "install_id"}));
    }
}
