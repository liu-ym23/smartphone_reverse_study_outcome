package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public interface LocateCallback {
    void onLocateChange(String r1, BDLocation r2);

    void onLocateError(String r1, BDLocationException r2);

    void onLocateStart(String r1);

    void onLocateStop(String r1);
}
