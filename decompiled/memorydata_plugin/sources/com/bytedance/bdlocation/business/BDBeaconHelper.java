package com.bytedance.bdlocation.business;

import com.bytedance.bdlocation.callback.BDBeaconCallback;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class BDBeaconHelper {
    public BDBeaconHelper() {
    }

    public static void startBeaconTask(String r2, BDBeaconCallback r3) {
        BDBeaconCallback r4 = (BDBeaconCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDBeaconCallback.class, "com.obric.memorydata.plugin");
        BDLocationExtrasService.getBeaconManager().startBeaconTask(r2, r4);
    }

    public static void stopBeaconTask() {
        BDLocationExtrasService.getBeaconManager().stopBeaconTask();
    }
}
