package com.bytedance.android.live.misc;

import com.bytedance.android.live.impl.StrategyService;
import com.bytedance.android.live.strategy.api.IStrategyService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$livestrategyimpl {
    public LiveService$$livestrategyimpl() {
    }

    public static void registerService() {
        jc1.k.l(IStrategyService.class, new StrategyService());
    }
}
