package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends AbsTask {
    public final void run() {
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().getTtlivecontextInit() == false) goto L6;
        TTLiveSDKContext.initLiveCacheManagerService();
        return;
    }

    public f() {
    }
}
