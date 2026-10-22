package com.bytedance.bdlocation.api;

import com.bytedance.bdlocation.callback.BDBeaconCallback;

/* JADX INFO: loaded from: classes.dex */
public interface IBeaconManager extends IManager {
    void startBeaconTask(String r8, BDBeaconCallback r10);

    void stopBeaconTask();
}
