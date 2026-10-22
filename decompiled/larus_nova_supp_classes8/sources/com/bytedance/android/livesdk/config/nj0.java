package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nj0 extends SettingKey<Long> {
    public static final nj0 a = null;

    static {
        a = new nj0();
    }

    public nj0() {
        super("live_preview_digg_tap_max_interval", "预览流点赞触发间隔 (ms)", 300L, 300L);
    }
}
