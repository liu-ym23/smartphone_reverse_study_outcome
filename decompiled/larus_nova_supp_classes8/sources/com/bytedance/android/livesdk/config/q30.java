package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q30 extends SSettingKey<Boolean> {
    public static final q30 a = null;

    static {
        a = new q30();
    }

    public q30() {
        super(LiveInitSettingKeys.LIVE_IO_PRE_START, "Live IO预启动", Boolean.FALSE, Boolean.TRUE);
    }
}
