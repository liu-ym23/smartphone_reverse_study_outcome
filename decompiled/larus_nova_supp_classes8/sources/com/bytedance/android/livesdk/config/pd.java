package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pd extends SettingKey<j11> {
    public static final pd a = null;

    static {
        pd r0 = new pd();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public pd() {
        super("live_animation_center_controller", "直播动画中心管理器", new j11(), new j11());
    }
}
