package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mi extends SettingKey<Boolean> {
    public static final mi a = null;

    static {
        a = new mi();
    }

    public mi() {
        Boolean r1 = Boolean.TRUE;
        super("live_broadcast_stream_pause_bg_opt", "直播暂停背景图优化", r1, r1);
    }
}
