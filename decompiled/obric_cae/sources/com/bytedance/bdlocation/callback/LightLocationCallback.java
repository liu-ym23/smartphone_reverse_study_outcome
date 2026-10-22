package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.response.LocationResp;

/* JADX INFO: loaded from: classes.dex */
public interface LightLocationCallback {
    void onError(String r8, String r10);

    void onSuccess(LocationResp r8, LocationUploadExtra r10);
}
