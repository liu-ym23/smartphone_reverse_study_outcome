package com.bytedance.bdlocation.business;

import com.bytedance.bdlocation.callback.BDBeaconCallback;
import com.bytedance.bdlocation.service.BDLocationExtrasService;

/* JADX INFO: loaded from: classes.dex */
public class BDBeaconHelper {
    public BDBeaconHelper() {
    }

    public static void startBeaconTask(String r8, BDBeaconCallback r10) {
        BDLocationExtrasService.getBeaconManager().startBeaconTask(r8, r10);
    }

    public static void stopBeaconTask() {
        BDLocationExtrasService.getBeaconManager().stopBeaconTask();
    }
}
