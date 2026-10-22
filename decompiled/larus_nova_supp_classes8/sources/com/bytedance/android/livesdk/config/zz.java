package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveHazyFrameConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zz extends SSettingKey<LiveHazyFrameConfig> {
    public static final zz a = null;

    static {
        zz r0 = new zz();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public zz() {
        super("live_hazy_frame_opt", "直播背景图抽帧优化", new LiveHazyFrameConfig(), new LiveHazyFrameConfig());
    }
}
