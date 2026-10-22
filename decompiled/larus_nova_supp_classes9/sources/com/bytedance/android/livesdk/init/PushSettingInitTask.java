package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.android.live.core.setting.z6;
import com.bytedance.android.livesdkapi.ws.host.LiveHostWsMessageBridge;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@WorkThreadTask
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/init/PushSettingInitTask;", "Lcom/bytedance/android/live/core/launch/AbsTask;", "()V", "run", BuildConfig.FLAVOR, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@Task(businessInfo = "WTO_PushSettingInitTask", value = 15)
public final class PushSettingInitTask extends AbsTask {
    public void run() {
        z6 r0 = z6.a;
        LiveHostWsMessageBridge.getInstance().registerSettingListener(z6.a);
        w60.b r1 = SettingIncStrategy.a;
        SettingIncStrategy.a.b();
    }

    public PushSettingInitTask() {
    }
}
