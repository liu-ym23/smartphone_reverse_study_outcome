package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n80 extends SSettingKey<Boolean> {
    public static final n80 a = null;

    static {
        a = new n80();
    }

    public n80() {
        super("live_message_enable_anchor_switch", "是否开启主播端消息拆分", Boolean.FALSE, Boolean.TRUE);
    }
}
