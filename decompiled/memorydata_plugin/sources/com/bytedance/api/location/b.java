package com.bytedance.api.location;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    void onError(BDLocationException r1);

    void onLocationChanged(BDLocation r1);
}
