package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ze1 extends SSettingKey<Boolean> {
    public static final ze1 a = null;

    static {
        a = new ze1();
    }

    public ze1() {
        super("live_playback_paid_change_to_new_process", "付费回放迁移至scope", Boolean.FALSE, Boolean.TRUE);
    }
}
