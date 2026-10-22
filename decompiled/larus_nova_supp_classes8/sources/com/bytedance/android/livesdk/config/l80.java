package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l80 extends SettingKey<Boolean> {
    public static final l80 a = null;

    static {
        a = new l80();
    }

    public l80() {
        Boolean r1 = Boolean.TRUE;
        super("live_message_dispatch_control_ignore_state", "消息dispatch控制无视消息状态", r1, r1);
    }
}
