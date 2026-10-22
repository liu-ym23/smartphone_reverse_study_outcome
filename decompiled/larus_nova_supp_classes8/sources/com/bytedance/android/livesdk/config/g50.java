package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g50 extends SettingKey<Boolean> {
    public static final g50 a = null;

    static {
        a = new g50();
    }

    public g50() {
        Boolean r1 = Boolean.FALSE;
        super("live_landscape_background_replace_optimize", "横屏直播间背景替换黑色", r1, r1);
    }
}
