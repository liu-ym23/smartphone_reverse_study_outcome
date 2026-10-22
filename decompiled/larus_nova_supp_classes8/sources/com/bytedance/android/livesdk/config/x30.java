package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x30 extends SSettingKey<Boolean> {
    public static final x30 a = null;

    static {
        a = new x30();
    }

    public x30() {
        Boolean r1 = Boolean.FALSE;
        super("live_json_optimize", "直播json序列化优化", r1, r1);
    }
}
