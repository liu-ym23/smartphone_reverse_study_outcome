package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k80 extends SSettingKey<Integer> {
    public static final k80 a = null;

    public k80() {
        super("live_message_custom_dispatch_limit_duration", "直播间消息分发限制执行时长(<=0视为不限制)", -1, 16);
    }

    static {
        a = new k80();
    }
}
