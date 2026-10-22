package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t00 extends SSettingKey<Integer> {
    public static final t00 a = null;

    static {
        a = new t00();
    }

    public t00() {
        super("live_hybrid_send_subscriber_threshold", "Hybrid数据共享方案单位时间内发送订阅阈值", 100, 100);
    }
}
