package com.bytedance.bdlocation.provider;

import com.bytedance.bdlocation.api.IBeaconManager;
import com.bytedance.bdlocation.callback.BDBeaconCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DefaultBeaconProvider implements IBeaconManager {
    public DefaultBeaconProvider() {
    }

    @Override // com.bytedance.bdlocation.api.IBeaconManager
    public void startBeaconTask(String r1, BDBeaconCallback r2) {
        BDBeaconCallback r0 = (BDBeaconCallback) ZeusTransformUtils.wrapperContextForParams(r2, BDBeaconCallback.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdlocation.api.IBeaconManager
    public void stopBeaconTask() {
    }
}
