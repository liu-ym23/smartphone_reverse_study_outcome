package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w1 extends SSettingKey<Boolean> {
    public static final w1 a = null;

    static {
        a = new w1();
    }

    public w1() {
        Boolean r1 = Boolean.TRUE;
        super("live_guest_battle_tech_report_lynx", "大作战技术埋点上报迁移到Lynx", r1, r1);
    }
}
