package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w extends SSettingKey<Boolean> {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
        Boolean r4 = Boolean.TRUE;
        super("live_audio_opt_channel_name", "是否开启优化直播通知标题", r4, r4, false);
    }
}
