package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pa1 extends SettingKey<Boolean> {
    public static final pa1 a = null;

    static {
        a = new pa1();
    }

    public pa1() {
        Boolean r1 = Boolean.TRUE;
        super("multi_link_enter_room_log_extra_params", "多人场景进房埋点上报链路细节耗时", r1, r1);
    }
}
