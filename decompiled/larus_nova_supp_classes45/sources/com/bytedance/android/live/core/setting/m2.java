package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m2 extends SSettingKey<Long> {
    public static final m2 a = null;

    static {
        a = new m2();
    }

    public m2() {
        super("live_match_room_progress_max_duration", "赛事直播进度条最大拖动范围ms", 10800000L, 10800000L);
    }
}
