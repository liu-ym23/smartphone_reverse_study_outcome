package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ga1 extends SSettingKey<Boolean> {
    public static final ga1 a = null;

    static {
        a = new ga1();
    }

    public ga1() {
        Boolean r1 = Boolean.FALSE;
        super("live_multi_linker_backup_stream_disable", "多人主播连线主备流开关", r1, r1);
    }
}
