package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qv extends SettingKey<Boolean> {
    public static final qv a = null;

    static {
        a = new qv();
    }

    public qv() {
        Boolean r1 = Boolean.TRUE;
        super("live_feed_drawer_enable", "抽屉入口更多直播是否展示", r1, r1);
    }
}
