package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m80 extends SettingKey<Boolean> {
    public static final m80 a = null;

    static {
        a = new m80();
    }

    public m80() {
        Boolean r1 = Boolean.FALSE;
        super("live_message_dispatch_stop_when_scroll", "上下滑停止消息分发", r1, r1);
    }
}
