package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p80 extends SSettingKey<Long> {
    public static final p80 a = null;

    static {
        a = new p80();
    }

    public p80() {
        super("live_message_max_total_dispatch_time", "消息分发最大可用时间", 1200L, 1200L);
    }
}
