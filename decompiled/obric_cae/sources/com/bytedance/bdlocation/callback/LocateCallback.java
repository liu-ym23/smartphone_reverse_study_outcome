package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public interface LocateCallback {
    void onLocateChange(String r8, BDLocation r10);

    void onLocateError(String r8, BDLocationException r10);

    void onLocateStart(String r8);

    void onLocateStop(String r8);
}
