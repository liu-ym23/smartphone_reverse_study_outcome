package com.byted.mgl.merge.service.api.location;

import com.byted.mgl.merge.service.model.BdpLocation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BdpGetLocationCallback {
    void onFail(String r1);

    void onSuccess(BdpLocation r1);
}
