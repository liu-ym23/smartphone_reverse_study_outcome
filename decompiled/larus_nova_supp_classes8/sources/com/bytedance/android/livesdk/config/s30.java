package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s30 extends SettingKey<Boolean> {
    public static final s30 a = null;

    static {
        a = new s30();
    }

    public s30() {
        Boolean r4 = Boolean.TRUE;
        super("live_is_xplay_full_screen_size_default_1080p", "xplay全屏沉浸式模式的参数默认1080P", r4, r4, true);
    }
}
