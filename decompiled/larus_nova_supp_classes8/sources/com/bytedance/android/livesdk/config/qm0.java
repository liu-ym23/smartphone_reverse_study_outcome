package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qm0 extends SSettingKey<Integer> {
    public static final qm0 a = null;

    static {
        a = new qm0();
    }

    public qm0() {
        super("live_record_max_duration", "录屏最大时长", 60, 60);
    }
}
