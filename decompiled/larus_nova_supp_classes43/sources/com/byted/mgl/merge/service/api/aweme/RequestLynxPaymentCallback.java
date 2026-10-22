package com.byted.mgl.merge.service.api.aweme;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface RequestLynxPaymentCallback {
    JSONObject getMiniGameEventCommonParams();

    void onFailed();

    void onSuccess(int r1, String r10);
}
