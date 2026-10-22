package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zf0 extends SSettingKey<Boolean> {
    public static final zf0 a = null;

    static {
        a = new zf0();
    }

    public zf0() {
        Boolean r1 = Boolean.FALSE;
        super("live_performance_pythia_enable", "直播性能策略是否使用pythia", r1, r1);
    }
}
