package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.init.BMFInitTask;
import com.bytedance.android.livesdk.init.DynamicStrategyInitTask;
import com.bytedance.android.livesdk.init.EffectUpdateTask;
import com.bytedance.android.livesdk.init.GeckoInitTask;
import com.bytedance.android.livesdk.init.I18nInitTask;
import com.bytedance.android.livesdk.init.IMProxyInitTask;
import com.bytedance.android.livesdk.init.InternalServiceInitTask;
import com.bytedance.android.livesdk.init.LightenInitTask;
import com.bytedance.android.livesdk.init.LynxInitTask;
import com.bytedance.android.livesdk.init.MessageZstdInitTask;
import com.bytedance.android.livesdk.init.ProtoDecoderInjectTask;
import com.bytedance.android.livesdk.init.PushSettingInitTask;
import com.bytedance.android.livesdk.init.TaskManagerInitTask;
import com.bytedance.android.livesdk.init.TraceFuseInitTask;
import com.bytedance.android.livesdk.init.UnifyMessageInitTask;
import com.bytedance.android.livesdk.init.UplinkInitTask;
import com.bytedance.android.livesdk.init.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveTask$$livesdk {
    public LiveTask$$livesdk() {
    }

    public static void registerTask() {
        x50.b r0 = x50.b.a.a;
        r0.f(3002, new a0());
        r0.f(3001, new com.bytedance.android.livesdk.init.c());
        r0.f(6, new GeckoInitTask());
        r0.f(10, new LynxInitTask());
        r0.f(2, new InternalServiceInitTask());
        r0.f(4, new TaskManagerInitTask());
        r0.f(7, new ProtoDecoderInjectTask());
        r0.f(8, new LightenInitTask());
        r0.f(1, new I18nInitTask());
        r0.f(11, new MessageZstdInitTask());
        r0.f(12, new EffectUpdateTask());
        r0.f(13, new IMProxyInitTask());
        r0.f(14, new UplinkInitTask());
        r0.f(15, new PushSettingInitTask());
        r0.f(16, new TraceFuseInitTask());
        r0.f(17, new UnifyMessageInitTask());
        r0.f(18, new BMFInitTask());
        r0.f(34, new DynamicStrategyInitTask());
    }
}
