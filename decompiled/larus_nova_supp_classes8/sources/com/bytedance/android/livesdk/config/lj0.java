package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lj0 extends SettingKey<Boolean> {
    public static final lj0 a = null;

    static {
        a = new lj0();
    }

    public lj0() {
        Boolean r4 = Boolean.TRUE;
        super("live_preview_crop_rotation_opt_enable", "图片裁剪旋转角度获取优化", r4, r4, true);
    }
}
