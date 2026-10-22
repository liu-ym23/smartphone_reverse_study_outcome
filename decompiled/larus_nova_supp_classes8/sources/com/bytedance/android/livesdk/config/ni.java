package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ni extends SettingKey<Boolean> {
    public static final ni a = null;

    static {
        a = new ni();
    }

    public ni() {
        Boolean r1 = Boolean.FALSE;
        super("live_broadcast_stream_process_opt", "直播暂停状态处理及内容一致性校验", r1, r1);
    }
}
