package com.bytedance.android.live.recharge;

import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface k extends dy0.c {

    public interface a {
        void a();

        void b(int r1, int r2, long r3);
    }

    public interface b {
    }

    void fetchAutoExchangeStatus(int r1);

    RechargeCurrentCacheData getCurrentRechargeCacheDataObject();

    Object getRechargeLynxBehavior();

    zv0.f rechargeCenter();
}
