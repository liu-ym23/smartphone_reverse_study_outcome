package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocationResp;

/* JADX INFO: loaded from: classes.dex */
public interface LocationUploadCallback {
    void onError(String r8);

    void onSuccess(LocationResp r8, boolean r10, WifiInfo r11);
}
