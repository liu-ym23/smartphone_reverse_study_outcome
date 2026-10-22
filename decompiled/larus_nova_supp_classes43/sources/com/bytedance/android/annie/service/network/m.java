package com.bytedance.android.annie.service.network;

import com.bytedance.retrofit2.client.Client;
import com.bytedance.ttnet.retrofit.SsRetrofitClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements Client.Provider {
    public m() {
    }

    public final Client get() {
        return new SsRetrofitClient();
    }
}
