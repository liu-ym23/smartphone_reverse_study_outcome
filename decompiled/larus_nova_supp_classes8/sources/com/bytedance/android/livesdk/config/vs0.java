package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.SmoothAnimSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vs0 extends SSettingKey<SmoothAnimSetting> {
    public static final vs0 a = null;

    static {
        a = new vs0();
    }

    public vs0() {
        super("live_smooth_anim_config", "直播带动画的平滑进房", new SmoothAnimSetting(), new SmoothAnimSetting(), true);
    }
}
