package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e2 extends SSettingKey<Boolean> {
    public static final e2 a = null;

    static {
        a = new e2();
    }

    public e2() {
        Boolean r1 = Boolean.TRUE;
        super("live_ktv_audience_ai_lyric_enable", "你点我唱ai歌词展示开关", r1, r1);
    }
}
