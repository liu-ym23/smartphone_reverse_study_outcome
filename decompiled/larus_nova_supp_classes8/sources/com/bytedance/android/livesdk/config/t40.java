package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t40 extends SSettingKey<Boolean> {
    public static final t40 a = null;

    static {
        a = new t40();
    }

    public t40() {
        Boolean r1 = Boolean.TRUE;
        super("live_ktv_old_challenge_delay_load_enable", "旧版演唱挑战观众端延迟加载", r1, r1);
    }
}
