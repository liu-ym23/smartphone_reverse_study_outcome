package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s80 extends SSettingKey<Long> {
    public static final s80 a = null;

    static {
        a = new s80();
    }

    public s80() {
        super("live_message_smoothly_dispatch_interval", "消息分发时延", 200L, 200L);
    }
}
