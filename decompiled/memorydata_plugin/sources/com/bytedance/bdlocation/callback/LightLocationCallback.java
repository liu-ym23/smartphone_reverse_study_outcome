package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.response.LocationResp;

/* JADX INFO: loaded from: classes.dex */
public interface LightLocationCallback {
    void onError(String r1, String r2);

    void onSuccess(LocationResp r1, LocationUploadExtra r2);
}
