package com.bytedance.bdlocation.trace;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.LocateCallback;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public interface TraceCallback extends LocateCallback {
    void onError(BDLocationException r8);

    void onLocationChanged(BDLocation r8);

    void onStart(LocationTrace r8);

    void onStop();
}
