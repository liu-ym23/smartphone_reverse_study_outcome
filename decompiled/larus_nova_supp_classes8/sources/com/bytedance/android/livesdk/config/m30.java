package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m30 extends SettingKey<Boolean> {
    public static final m30 a = null;

    static {
        a = new m30();
    }

    public m30() {
        Boolean r1 = Boolean.TRUE;
        super("live_interact_xplay_launch_optimize_enable", "弹幕玩法云启动耗时并发优化", r1, r1);
    }
}
