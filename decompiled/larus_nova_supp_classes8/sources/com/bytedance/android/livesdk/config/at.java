package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class at extends SettingKey<Boolean> {
    public static final at a = null;

    static {
        a = new at();
    }

    public at() {
        Boolean r4 = Boolean.FALSE;
        super("live_enable_server_merge_stream_for_multilink_game", "多人场景小玩法是否启用全链路服务端合流", r4, r4, false);
    }
}
