package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z10 extends SettingKey<Boolean> {
    public static final z10 a = null;

    static {
        a = new z10();
    }

    public z10() {
        Boolean r1 = Boolean.FALSE;
        super("live_inner_reach_end_backup", "刷空使用直播缓存池兜底", r1, r1);
    }
}
