package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xq extends SSettingKey<Boolean> {
    public static final xq a = null;

    static {
        a = new xq();
    }

    public xq() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_audience_game_manager", "是否开启观众端开放平台玩法", r1, r1);
    }
}
