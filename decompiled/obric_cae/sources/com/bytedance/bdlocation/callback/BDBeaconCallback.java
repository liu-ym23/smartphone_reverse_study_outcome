package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public interface BDBeaconCallback {
    void onFail(BDLocationException r8);

    void onSuccess();
}
