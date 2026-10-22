package com.bytedance.android.live.misc;

import com.bytedance.android.live.componentsmarket.api.IComponentsMarketService;
import com.bytedance.android.live.componentsmarket.impl.ComponentsMarketService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$livecomponentsmarketimpl {
    public LiveService$$livecomponentsmarketimpl() {
    }

    public static void registerService() {
        jc1.k.l(IComponentsMarketService.class, new ComponentsMarketService());
    }
}
