package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n2 extends SSettingKey<Boolean> {
    public static final n2 a = null;

    static {
        a = new n2();
    }

    public n2() {
        Boolean r4 = Boolean.FALSE;
        super("live_media_session_config", "直播媒体会话配置", r4, r4, true);
    }
}
