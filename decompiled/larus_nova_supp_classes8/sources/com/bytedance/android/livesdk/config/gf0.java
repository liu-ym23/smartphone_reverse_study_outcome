package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gf0 extends SSettingKey<Integer> {
    public static final gf0 a = null;

    public gf0() {
        super("live_paid_live_message_config", "付费直播消息通道控制设置 0-对照只依赖ping接口,1-只依赖消息，2-消息和ping接口共存", 2, 2);
    }

    static {
        a = new gf0();
    }
}
