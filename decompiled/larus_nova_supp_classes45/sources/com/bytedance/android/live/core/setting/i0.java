package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i0 extends SSettingKey<Boolean> {
    public static final i0 a = null;

    static {
        a = new i0();
    }

    public i0() {
        Boolean r1 = Boolean.TRUE;
        super("live_del_guest_battle_tech_report", "删除大作战客户端上的埋点上报", r1, r1);
    }
}
