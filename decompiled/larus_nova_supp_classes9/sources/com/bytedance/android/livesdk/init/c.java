package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends AbsTask {
    public final void run() {
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().getTtlivecontextInit() == false) goto L6;
        TTLiveSDKContext.initFeatureService(false);
        TTLiveSDKContext.initAiService();
        TTLiveSDKContext.initStrategyService();
        TTLiveSDKContext.initResolutionService();
        TTLiveSDKContext.initPlayerStrategyService();
        TTLiveSDKContext.delayStrategyService();
        return;
    }

    public c() {
    }
}
