package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.livepullstream.api.IPullStreamService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.tools.pbadapter.annotation.GenProtoDecoders;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@GenProtoDecoders
@WorkThreadTask
@Task(businessInfo = "WTO_BMFInitTask", value = IAssetsManager.FetchGiftListSource.SOURCE_MOSTLY_USED_PIN_STATUS_CHANGED)
public class BMFInitTask extends AbsTask {
    public void run() {
        IPullStreamService r0 = jc1.k.f(IPullStreamService.class);
        if (r0 == null) goto L6;
        r0.tryInstallBMFPlugin();
        return;
    }

    public BMFInitTask() {
    }
}
