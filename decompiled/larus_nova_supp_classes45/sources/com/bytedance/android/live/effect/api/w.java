package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.IMiddlewareCommodityNoFilterUploadCallBack;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ IMiddlewareCommodityNoFilterUploadCallBack a;

    public w(com.bytedance.android.livesdk.provideservices.d0.k r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
        ALogger.d("COMMODITY_NO_FILTER", "update no filter setting successfully");
        this.a.onSuccess();
    }
}
