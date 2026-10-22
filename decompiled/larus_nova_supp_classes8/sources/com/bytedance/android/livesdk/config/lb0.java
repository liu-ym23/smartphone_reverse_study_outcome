package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lb0 extends SettingKey<Boolean> {
    public static final lb0 a = null;

    static {
        a = new lb0();
    }

    public lb0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multilink_miniappcommonmessage_fix", "多人场景嘉宾云启动消息去重", r1, r1);
    }
}
