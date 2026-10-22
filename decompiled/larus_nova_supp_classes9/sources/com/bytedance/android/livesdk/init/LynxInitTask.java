package com.bytedance.android.livesdk.init;

import android.content.Context;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.MainThreadTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@MainThreadTask
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/init/LynxInitTask;", "Lcom/bytedance/android/live/core/launch/AbsTask;", "()V", "run", BuildConfig.FLAVOR, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@Task(businessInfo = "WTO_LynxInitTask", value = 10)
public final class LynxInitTask extends AbsTask {
    public void run() {
        IHostContext r0 = jc1.k.f(IHostContext.class);
        if (r0 == null) goto L11;
        Context r1 = r0.context();
        if (r1 == null) goto L13;
        IBrowserService r2 = jc1.k.f(IBrowserService.class);
        if (r2 == null) goto L12;
        r2.tryInitEnvIfNeeded(r1);
        return;
    L12:
        return;
    L13:
        return;
    }

    public LynxInitTask() {
    }
}
